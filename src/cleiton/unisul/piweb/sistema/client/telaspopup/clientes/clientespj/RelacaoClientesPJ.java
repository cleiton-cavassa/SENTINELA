package cleiton.unisul.piweb.sistema.client.telaspopup.clientes.clientespj;


import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;

import cleiton.unisul.piweb.classesrpc.shared.ClientePJ;
import cleiton.unisul.piweb.classesrpc.shared.ServicoArmazenamento;
import cleiton.unisul.piweb.sistema.client.SENTINELA;
import cleiton.unisul.piweb.sistema.client.telaspopup.clientes.clientespf.RelacaoClientesPF;
import cleiton.unisul.piweb.sistema.client.util.CriadorTela;
import cleiton.unisul.piweb.sistema.client.validacao.CompositeCNPJ;

import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.cell.client.ButtonCell;



public class RelacaoClientesPJ extends Composite{
	private static String sim="sim";
	private static String nao="n\u00E3o";

	private static RelacaoClientesPJ get=new RelacaoClientesPJ();
	
	public static RelacaoClientesPJ get(){
		if(get==null){
			get=new RelacaoClientesPJ();
		}
		get.atualizar();
		return get;
	}
	
	final ListDataProvider<ClientePJ> dataProvider = new ListDataProvider<ClientePJ>();
	AsyncCallback<List<ClientePJ>> callback= new CallbackArmazenamento(dataProvider);
	
	private RelacaoClientesPJ() {
				
		FlowPanel flowPanel = new FlowPanel();
		flowPanel.setStyleName("painelCadastro");
		initWidget(flowPanel);
		flowPanel.setSize("854px", "");
		
		Label lblSentinelaRelao = new Label("SENTINELA - Rela\u00E7\u00E3o de Clientes PESSOAS JUR\u00CDDICAS");
		lblSentinelaRelao.setStyleName("h1");
		lblSentinelaRelao.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		flowPanel.add(lblSentinelaRelao);
		lblSentinelaRelao.setSize("", "");
		
		VerticalPanel verticalPanel = new VerticalPanel();
		flowPanel.add(verticalPanel);
		verticalPanel.setWidth("100%");
		ClickHandler h=new ClickHandler() {
			public void onClick(ClickEvent event) {
				new CriadorTela(CriarNovoClientePJ.get()).execute();
			}
		};
		
		DecoratorPanel decoratorPanel_1 = new DecoratorPanel();
		verticalPanel.add(decoratorPanel_1);
		decoratorPanel_1.setSize("100%", "100%");
		
		CellTable<ClientePJ> cellTable = new CellTable<ClientePJ>();
		decoratorPanel_1.setWidget(cellTable);
		cellTable.setSize("100%", "100%");
		
		Column<ClientePJ, String> column_1 = new Column<ClientePJ, String>(new ButtonCell()) {
			@Override
			public String getValue(ClientePJ object) {
				return "editar";
			}
		};
		Column<ClientePJ,String> colBotoes=column_1;
		colBotoes.setFieldUpdater(new FieldUpdater<ClientePJ, String>(){
			@Override
			public void update(int index, ClientePJ object, String value) {
				CadastroClientesPJ c =CadastroClientesPJ.get();
				c.setCliente(object);
				new CriadorTela(c).execute();				
			}
			
		});
		
		cellTable.addColumn(column_1);
		
		
		
		TextColumn<ClientePJ> textColumn = new TextColumn<ClientePJ>() {
			@Override
			public String getValue(ClientePJ object) {
				return CompositeCNPJ.mascaraCNPJ(object.getChave());
			}
		};
		cellTable.addColumn(textColumn, "CNPJ");
		
		TextColumn<ClientePJ> textColumn_1 = new TextColumn<ClientePJ>() {
			@Override
			public String getValue(ClientePJ object) {
				return ((ClientePJ)object).getRazaoSocial();		
			}
		};
		cellTable.addColumn(textColumn_1, "Raz\u00E3o Social");
		
		TextColumn<ClientePJ> textColumn_2 = new TextColumn<ClientePJ>() {
			@Override
			public String getValue(ClientePJ object) {
				return ((ClientePJ)object).getEnderecoMatriz();		
			}
		};
		cellTable.addColumn(textColumn_2, "Endere\u00E7o Matriz");
		
		TextColumn<ClientePJ> textColumn_3 = new TextColumn<ClientePJ>() {
			@Override
			public String getValue(ClientePJ object) {
				return ((ClientePJ)object).getRegioesDeAtuacao().get(0);
			}
		};
		cellTable.addColumn(textColumn_3, "Regi\u00E3o de Atua\u00E7\u00E3o");
		
		TextColumn<ClientePJ> column = new TextColumn<ClientePJ>() {
			@Override
			public String getValue(ClientePJ object) {
				return (object.getStatus()?sim:nao);
			}
		};
		cellTable.addColumn(column, "Ativo?");
		
		dataProvider.addDataDisplay(cellTable);
		
		TextColumn<ClientePJ> textColumn_4 = new TextColumn<ClientePJ>() {
			@Override
			public String getValue(ClientePJ object) {
				return (object.getVouchersAtivos()?sim:nao);
			}
		};
		cellTable.addColumn(textColumn_4, "usa vouchers?");
		
		atualizar();
	}
	
	public void atualizar(){
		ServicoArmazenamento.getArmazenamento().recuperar(new ClientePJ(), callback);		
	}
	
	private class CallbackArmazenamento implements AsyncCallback<List<ClientePJ>>{
		ListDataProvider<ClientePJ> prov;
		public CallbackArmazenamento(ListDataProvider<ClientePJ> dtPr){
			prov=dtPr;
		}
		
		@Override
		public void onSuccess(List<ClientePJ> result) {
			prov.setList(result);
			//Window.alert("Sucesso!\nClientePJ");
		}
		
		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Problemas...\n\n"+caught.getMessage());
		}
	}
}
