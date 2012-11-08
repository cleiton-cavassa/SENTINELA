package cleiton.unisul.piweb.client.telaspopup.clientespj;


import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;

import cleiton.unisul.piweb.client.SENTINELA;
import cleiton.unisul.piweb.client.util.CriadorTela;
import cleiton.unisul.piweb.shared.ClientePJ;

import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class RelacaoClientesPJ extends Composite{
	public RelacaoClientesPJ() {
		
		
		
		
		FlowPanel flowPanel = new FlowPanel();
		flowPanel.setStyleName("painelCadastro");
		initWidget(flowPanel);
		flowPanel.setSize("854px", "");
		
		Label lblSentinelaRelao = new Label("SENTINELA - Rela\u00E7\u00E3o de Clientes PESSOAS JUR\u00CDDICAS");
		lblSentinelaRelao.setStyleName("h1");
		lblSentinelaRelao.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		flowPanel.add(lblSentinelaRelao);
		lblSentinelaRelao.setSize("", "");
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		flowPanel.add(horizontalPanel);
		
		VerticalPanel verticalPanel = new VerticalPanel();
		flowPanel.add(verticalPanel);
		verticalPanel.setWidth("100%");
		
		DecoratorPanel decoratorPanel = new DecoratorPanel();
		verticalPanel.add(decoratorPanel);

		final ListDataProvider<ClientePJ> dataProvider = new ListDataProvider<ClientePJ>();

		
		Button button = new Button("novo cliente PJ");
		ClickHandler h=new ClickHandler() {
			public void onClick(ClickEvent event) {

				new CriadorTela(new CriarNovoClientePJ()).execute();
			}
		};
		button.addClickHandler(h);
		decoratorPanel.setWidget(button);
		
		DecoratorPanel decoratorPanel_1 = new DecoratorPanel();
		verticalPanel.add(decoratorPanel_1);
		decoratorPanel_1.setSize("100%", "100%");
		
		CellTable<ClientePJ> cellTable = new CellTable<ClientePJ>();
		decoratorPanel_1.setWidget(cellTable);
		cellTable.setSize("100%", "100%");
		
		
		
		TextColumn<ClientePJ> textColumn = new TextColumn<ClientePJ>() {
			@Override
			public String getValue(ClientePJ object) {
				return object.toString();
			}
		};
		cellTable.addColumn(textColumn, "ID");
		
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
		
		Column<ClientePJ, Boolean> column = new Column<ClientePJ, Boolean>(new CheckboxCell()) {
			@Override
			public Boolean getValue(ClientePJ object) {
				return ((ClientePJ)object).getStatus();
			}
		};
		cellTable.addColumn(column, "Ativo?");
		
		dataProvider.addDataDisplay(cellTable);

		AsyncCallback<List<ClientePJ>> a= new A(dataProvider);
		//SENTINELA.getGreetingService().recuperar(true, a);
		SENTINELA.getArmazenamento().recuperar(new ClientePJ(), a);		


	}
	private class A implements AsyncCallback<List<ClientePJ>>{
		ListDataProvider<ClientePJ> prov;
		public A(ListDataProvider<ClientePJ> dtPr){
			prov=dtPr;
		}
		
		@Override
		public void onSuccess(List<ClientePJ> result) {
			prov.setList(result);
			Window.alert("Sucesso!");
		}
		
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			
			Window.alert("Problemas...\n\n"+caught.getMessage());
		}
	}
}
