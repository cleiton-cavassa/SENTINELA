package cleiton.unisul.piweb.client.telaspopup.clientespf;

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
import com.google.gwt.cell.client.CheckboxCell;

public class RelacaoClientesPF extends Composite {
	public RelacaoClientesPF() {
		
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
		
		CellTable<Object> cellTable = new CellTable<Object>();
		verticalPanel.add(cellTable);
		cellTable.setWidth("");
		
		TextColumn<Object> textColumn = new TextColumn<Object>() {
			public String getValue(Object object) {
				return (String) null;
			}
		};
		cellTable.addColumn(textColumn, "ID");
		
		TextColumn<Object> textColumn_1 = new TextColumn<Object>() {
			public String getValue(Object object) {
				return (String) null;
			}
		};
		cellTable.addColumn(textColumn_1, "Nome");
		
		Column<Object, Boolean> column = new Column<Object, Boolean>(new CheckboxCell()) {
			@Override
			public Boolean getValue(Object object) {
				return (Boolean) null;
			}
		};
		cellTable.addColumn(column, "Ativo?");
		
		TextColumn<Object> textColumn_2 = new TextColumn<Object>() {
			public String getValue(Object object) {
				return (String) null;
			}
		};
		cellTable.addColumn(textColumn_2, "idiomas");
		
		Column<Object, Boolean> column_1 = new Column<Object, Boolean>(new CheckboxCell()) {
			@Override
			public Boolean getValue(Object object) {
				return (Boolean) null;
			}
		};
		cellTable.addColumn(column_1, "carrega animais?");
		
		Column<Object, Boolean> column_2 = new Column<Object, Boolean>(new CheckboxCell()) {
			@Override
			public Boolean getValue(Object object) {
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
		
		Button button_1 = new Button("novo cliente PJ");
		button_1.setText("novo cliente PF");
		horizontalPanel_1.add(button_1);
	}

}
