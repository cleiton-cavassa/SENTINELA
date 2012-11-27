package cleiton.unisul.piweb.sistema.client.telaspopup.corridas;

import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.Formulario;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.CorridaSolicitada;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;

public class CadastroNovaCorrida extends Formulario<CorridaSolicitada> {
	public CadastroNovaCorrida() {
		
		FlowPanel flowPanel = new FlowPanel();
		initWidget(flowPanel);
		flowPanel.setSize("333px", "100%");
		
		Label lblSentinelaNova = new Label("SENTINELA - nova corrida");
		lblSentinelaNova.setStyleName("h1");
		lblSentinelaNova.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		flowPanel.add(lblSentinelaNova);
		lblSentinelaNova.setSize("100%", "20px");
		
		Grid grid = new Grid(4, 2);
		flowPanel.add(grid);
		
		Label lblIdcliente = new Label("idCliente");
		lblIdcliente.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		grid.setWidget(0, 0, lblIdcliente);
		
		TextBox textBox = new TextBox();
		grid.setWidget(0, 1, textBox);
		
		Label lblDiaDoEmbarque = new Label("data e hora do embarque");
		lblDiaDoEmbarque.setWordWrap(false);
		lblDiaDoEmbarque.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		grid.setWidget(1, 0, lblDiaDoEmbarque);
		
		DateBox dateBox_1 = new DateBox();
		grid.setWidget(1, 1, dateBox_1);
		
		Label lblLocalDeEmbarque = new Label("local de embarque");
		lblLocalDeEmbarque.setWordWrap(false);
		lblLocalDeEmbarque.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		grid.setWidget(2, 0, lblLocalDeEmbarque);
		
		DateBox dateBox = new DateBox();
		grid.setWidget(2, 1, dateBox);
		dateBox.setWidth("126px");
		
		Label lblIdmotorista = new Label("idMotorista");
		lblIdmotorista.setWordWrap(false);
		lblIdmotorista.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		grid.setWidget(3, 0, lblIdmotorista);
		
		TextBox textBox_2 = new TextBox();
		grid.setWidget(3, 1, textBox_2);
		
		VerticalPanel verticalPanel = new VerticalPanel();
		flowPanel.add(verticalPanel);
		verticalPanel.setHeight("7px");
		
		CheckBox chckbxComTransporteDe = new CheckBox("com transporte de animais");
		verticalPanel.add(chckbxComTransporteDe);
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		flowPanel.add(horizontalPanel);
		horizontalPanel.setWidth("100%");
		
		Button btnNewButton = new Button("New button");
		horizontalPanel.add(btnNewButton);
		btnNewButton.setText("criar nova corrida!");
	}

	@Override
	protected CorridaSolicitada criarInputVazio() {
		return new CorridaSolicitada();
	}
	
	
	
	

}
