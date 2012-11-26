package cleiton.unisul.piweb.sistema.client.telaspopup.frotas;

import cleiton.unisul.piweb.sistema.client.formularios.Formulario;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.client.ui.CheckBox;

public class CadastroEstaFrota extends Formulario {

	public CadastroEstaFrota() {
		
		FlowPanel flowPanel = new FlowPanel();
		initWidget(flowPanel);
		flowPanel.setSize("910px", "371px");
		
		Label lblSentinelaDados = new Label("SENTINELA - dados desta frota");
		lblSentinelaDados.setStyleName("h1");
		lblSentinelaDados.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		flowPanel.add(lblSentinelaDados);
		lblSentinelaDados.setSize("100%", "20px");
		
		Grid grid = new Grid(7,2);
		flowPanel.add(grid);
		
		Label label_1 = new Label("ID:");
		label_1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		grid.setWidget(0, 0, label_1);
		
		Label label = new Label("Ainda n\u00E3o criado");
		label.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		grid.setWidget(0, 1, label);
		
		Label lblRazoSocial = new Label("Raz\u00E3o Social:");
		lblRazoSocial.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		grid.setWidget(1, 0, lblRazoSocial);
		
		Label lblCnpj = new Label("CNPJ:");
		lblCnpj.setWordWrap(false);
		lblCnpj.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		grid.setWidget(2, 0, lblCnpj);
		
		Label lblRegiesDeAtuao = new Label("Regi\u00F5es de Atua\u00E7\u00E3o:");
		lblRegiesDeAtuao.setWordWrap(false);
		lblRegiesDeAtuao.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		grid.setWidget(3, 0, lblRegiesDeAtuao);
		
		Label label_6 = new Label("Endere\u00E7o:");
		label_6.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		grid.setWidget(4, 0, label_6);
		
		Label label_7 = new Label("Telefones:");
		label_7.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		grid.setWidget(5, 0, label_7);
		
		Label lblEmail = new Label("email");
		lblEmail.setWordWrap(false);
		lblEmail.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		grid.setWidget(6, 0, lblEmail);
		
		TextBox textBox = new TextBox();
		textBox.setVisibleLength(120);
		grid.setWidget(1, 1, textBox);
		
		TextBox textBox_1 = new TextBox();
		textBox_1.setVisibleLength(18);
		textBox_1.setMaxLength(14);
		grid.setWidget(2, 1, textBox_1);
		
		TextBox textBox_2 = new TextBox();
		textBox_2.setVisibleLength(120);
		grid.setWidget(3, 1, textBox_2);
		
		TextBox textBox_3 = new TextBox();
		textBox_3.setVisibleLength(120);
		grid.setWidget(4, 1, textBox_3);
		
		TextBox textBox_4 = new TextBox();
		textBox_4.setVisibleLength(120);
		grid.setWidget(5, 1, textBox_4);
		
		TextBox textBox_5 = new TextBox();
		textBox_5.setVisibleLength(120);
		grid.setWidget(6, 1, textBox_5);
	}

}
