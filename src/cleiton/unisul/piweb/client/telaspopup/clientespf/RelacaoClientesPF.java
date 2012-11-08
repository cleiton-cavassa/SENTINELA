package cleiton.unisul.piweb.client.telaspopup.clientespf;

import java.util.List;


import cleiton.unisul.piweb.client.SENTINELA;
import cleiton.unisul.piweb.client.telaspopup.clientespj.CriarNovoClientePJ;
import cleiton.unisul.piweb.client.util.CriadorTela;
import cleiton.unisul.piweb.shared.ClientePF;
import cleiton.unisul.piweb.shared.ClientePJ;

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
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

public class RelacaoClientesPF extends Composite {
	private CellTable<ClientePF> tabela;
	
	private static RelacaoClientesPF get=new RelacaoClientesPF();
	
	public static RelacaoClientesPF get(){
		if(get==null){
			get=new RelacaoClientesPF();
		}
		return get;
	}
	
	
	
	
	final ListDataProvider<ClientePF> dataProvider = new ListDataProvider<ClientePF>();
	
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
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		flowPanel.add(horizontalPanel);
		
		VerticalPanel verticalPanel = new VerticalPanel();
		flowPanel.add(verticalPanel);
		verticalPanel.setWidth("");
		
		CellTable<ClientePF> cellTable = new CellTable<ClientePF>();
		verticalPanel.add(cellTable);
		cellTable.setWidth("");
		
		TextColumn<ClientePF> textColumn = new TextColumn<ClientePF>() {
			public String getValue(ClientePF ClientePF) {
				return (String) null;
			}
		};
		cellTable.addColumn(textColumn, "ID");
		
		TextColumn<ClientePF> textColumn_1 = new TextColumn<ClientePF>() {
			public String getValue(ClientePF ClientePF) {
				return (String) null;
			}
		};
		cellTable.addColumn(textColumn_1, "Nome");
		
		Column<ClientePF, Boolean> column = new Column<ClientePF, Boolean>(new CheckboxCell()) {
			@Override
			public Boolean getValue(ClientePF ClientePF) {
				return (Boolean) null;
			}
		};
		cellTable.addColumn(column, "Ativo?");
		
		TextColumn<ClientePF> textColumn_2 = new TextColumn<ClientePF>() {
			public String getValue(ClientePF ClientePF) {
				return (String) null;
			}
		};
		cellTable.addColumn(textColumn_2, "idiomas");
		
		Column<ClientePF, Boolean> column_1 = new Column<ClientePF, Boolean>(new CheckboxCell()) {
			@Override
			public Boolean getValue(ClientePF ClientePF) {
				return (Boolean) null;
			}
		};
		cellTable.addColumn(column_1, "carrega animais?");
		
		Column<ClientePF, Boolean> column_2 = new Column<ClientePF, Boolean>(new CheckboxCell()) {
			@Override
			public Boolean getValue(ClientePF ClientePF) {
				return (Boolean) null;
			}
		};
		cellTable.addColumn(column_2, "aceita motoristas fumantes?");
		
		DecoratorPanel decoratorPanel = new DecoratorPanel();
		verticalPanel.add(decoratorPanel);
		
		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		horizontalPanel_1.setSpacing(5);
		decoratorPanel.setWidget(horizontalPanel_1);
		
		Button button = new Button("ver e editar dados completos");
		horizontalPanel_1.add(button);
		
		Button button_1 = new Button("novo cliente PF");
		horizontalPanel_1.add(button_1);
		
		ClickHandler h=new ClickHandler() {
			public void onClick(ClickEvent event) {
				new CriadorTela(new CriarNovoClientePF()).execute();
			}
		};
		button_1.addClickHandler(h); 
		
		tabela=cellTable;
		dataProvider.addDataDisplay(tabela);
		
		atualizar();
	}
	
	public void atualizar(){
		AsyncCallback<List<ClientePF>> a= new CallbackArmazenamento(dataProvider);
		SENTINELA.getArmazenamento().recuperar(new ClientePF(), a);		
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
			// TODO Auto-generated method stub
			
			Window.alert("Problemas...\n\n"+caught.getMessage());
		}
	}
}
