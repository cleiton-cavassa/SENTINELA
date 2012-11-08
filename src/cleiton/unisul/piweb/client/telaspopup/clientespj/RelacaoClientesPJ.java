package cleiton.unisul.piweb.client.telaspopup.clientespj;

import java.io.Serializable;

import java.util.ArrayList;


import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;

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
		
		CellTable<Serializable> cellTable = new CellTable<Serializable>();
		decoratorPanel_1.setWidget(cellTable);
		cellTable.setSize("100%", "100%");
		
		
		
		TextColumn<Serializable> textColumn = new TextColumn<Serializable>() {
			@Override
			public String getValue(Serializable object) {
				return object.toString();
			}
		};
		cellTable.addColumn(textColumn, "ID");
		
		TextColumn<Serializable> textColumn_1 = new TextColumn<Serializable>() {
			@Override
			public String getValue(Serializable object) {
				return ((ClientePJ)object).getRazaoSocial();		
			}
		};
		cellTable.addColumn(textColumn_1, "Raz\u00E3o Social");
		
		TextColumn<Serializable> textColumn_2 = new TextColumn<Serializable>() {
			@Override
			public String getValue(Serializable object) {
				return ((ClientePJ)object).getEnderecoMatriz();		
			}
		};
		cellTable.addColumn(textColumn_2, "Endere\u00E7o Matriz");
		
		TextColumn<Serializable> textColumn_3 = new TextColumn<Serializable>() {
			@Override
			public String getValue(Serializable object) {
				return ((ClientePJ)object).getRegioesDeAtuacao().get(0);
			}
		};
		cellTable.addColumn(textColumn_3, "Regi\u00E3o de Atua\u00E7\u00E3o");
		
		Column<Serializable, Boolean> column = new Column<Serializable, Boolean>(new CheckboxCell()) {
			@Override
			public Boolean getValue(Serializable object) {
				return ((ClientePJ)object).getStatus();
			}
		};
		cellTable.addColumn(column, "Ativo?");
		
		final ListDataProvider<Serializable> dataProvider = new ListDataProvider<Serializable>();
		dataProvider.addDataDisplay(cellTable);
		
		AsyncCallback<ArrayList<Serializable>> a= new AsyncCallback<ArrayList<Serializable>>() {
			@Override
			public void onSuccess(ArrayList<Serializable> result) {
				dataProvider.setList(result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		};
		//SENTINELA.getGreetingService().recuperarDadosCategoria(true, a);
	}
}
