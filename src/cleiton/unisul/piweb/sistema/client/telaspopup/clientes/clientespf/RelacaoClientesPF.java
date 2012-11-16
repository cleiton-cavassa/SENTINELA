package cleiton.unisul.piweb.sistema.client.telaspopup.clientes.clientespf;

import java.util.List;


import cleiton.unisul.piweb.classesrpc.shared.ClientePF;
import cleiton.unisul.piweb.classesrpc.shared.ClientePJ;
import cleiton.unisul.piweb.classesrpc.shared.ServicoArmazenamento;
import cleiton.unisul.piweb.sistema.client.SENTINELA;
import cleiton.unisul.piweb.sistema.client.telaspopup.clientes.clientespj.CadastroClientesPJ;
import cleiton.unisul.piweb.sistema.client.telaspopup.clientes.clientespj.CriarNovoClientePJ;
import cleiton.unisul.piweb.sistema.client.util.CriadorTela;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.cell.client.ButtonCell;

public class RelacaoClientesPF extends Composite {
	private CellTable<ClientePF> tabela;
	
	private static RelacaoClientesPF get=new RelacaoClientesPF();
	
	public static RelacaoClientesPF get(){
		if(get==null){
			get=new RelacaoClientesPF();
		}
		get.atualizar();
		return get;
	}
	
	final ListDataProvider<ClientePF> dataProvider = new ListDataProvider<ClientePF>();
	final String strPositivo="Sim";
	final String strNegativo="Nao";
	
	private RelacaoClientesPF() {
		
		FlowPanel flowPanel = new FlowPanel();
		flowPanel.setStyleName("painelCadastro");
		initWidget(flowPanel);
		flowPanel.setSize("808px", "");
		
		Label lblSentinelaRelao = new Label("SENTINELA - Rela\u00E7\u00E3o de Clientes PESSOAS F\u00CDSICAS");
		lblSentinelaRelao.setStyleName("h1");
		lblSentinelaRelao.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		flowPanel.add(lblSentinelaRelao);
		lblSentinelaRelao.setSize("", "");

		ClickHandler h=new ClickHandler() {
			public void onClick(ClickEvent event) {
				new CriadorTela(CriarNovoClientePF.get()).execute();
			}
		};
		
		VerticalPanel verticalPanel = new VerticalPanel();
		flowPanel.add(verticalPanel);
		verticalPanel.setWidth("");
		
		CellTable<ClientePF> cellTable = new CellTable<ClientePF>();
		verticalPanel.add(cellTable);
		cellTable.setWidth("");
		
		Column<ClientePF, String> column_3 = new Column<ClientePF, String>(new ButtonCell()) {
			@Override
			public String getValue(ClientePF object) {
				return "editar";
			}
		};
		cellTable.addColumn(column_3);
		
		Column<ClientePF,String> colBotoes=column_3;
		colBotoes.setFieldUpdater(new FieldUpdater<ClientePF, String>(){
			@Override
			public void update(int index, ClientePF object, String value) {
				CadastroClientesPF c =CadastroClientesPF.get();
				c.setCliente(object);
				new CriadorTela(c).execute();				
			}
			
		});
		
		
		
		
		TextColumn<ClientePF> textColumn = new TextColumn<ClientePF>() {
			public String getValue(ClientePF clientePF) {
				return String.valueOf(clientePF.getChave());
			}
		};
		cellTable.addColumn(textColumn, "CPF");
		
		TextColumn<ClientePF> textColumn_1 = new TextColumn<ClientePF>() {
			public String getValue(ClientePF clientePF) {
				return clientePF.getNome();
			}
		};
		cellTable.addColumn(textColumn_1, "Nome");
		
		TextColumn<ClientePF> column = new TextColumn<ClientePF>() {
			@Override
			public String getValue(ClientePF clientePF) {
				return (clientePF.getStatus()?strPositivo:strNegativo);
			}
		};
		cellTable.addColumn(column, "Ativo?");
		
		TextColumn<ClientePF> textColumn_2 = new TextColumn<ClientePF>() {
			public String getValue(ClientePF clientePF) {
				return clientePF.getIdiomasFalados();
			}
		};
		cellTable.addColumn(textColumn_2, "idiomas");
		
		TextColumn<ClientePF> column_1 = new TextColumn<ClientePF>() {
			@Override
			public String getValue(ClientePF clientePF) {
				return (clientePF.getCarregaAnimais()?strPositivo:strNegativo);
			}
		};
		cellTable.addColumn(column_1, "carrega animais?");
		
		TextColumn<ClientePF> column_2 = new TextColumn<ClientePF>() {
			@Override
			public String getValue(ClientePF clientePF) {
				return (  clientePF.getAceitaMotFumante()?strPositivo:strNegativo);
			}
		};
		cellTable.addColumn(column_2, "aceita motoristas fumantes?");
		
		
		tabela=cellTable;
		dataProvider.addDataDisplay(tabela);
		
		atualizar();
	}
	
	public void atualizar(){
		AsyncCallback<List<ClientePF>> a= new CallbackArmazenamento(dataProvider);
		ServicoArmazenamento.getArmazenamento().recuperar(new ClientePF(), a);		
	}
	
	private class CallbackArmazenamento implements AsyncCallback<List<ClientePF>>{
		ListDataProvider<ClientePF> prov;
		public CallbackArmazenamento(ListDataProvider<ClientePF> dtPr){
			prov=dtPr;
		}
		
		@Override
		public void onSuccess(List<ClientePF> result) {
			prov.setList(result);
			//Window.alert("Sucesso!\nClientePF");
		}
		
		@Override
		public void onFailure(Throwable caught) {
			//Window.alert("Problemas...\n\n"+caught.getMessage());
		}
	}
}
