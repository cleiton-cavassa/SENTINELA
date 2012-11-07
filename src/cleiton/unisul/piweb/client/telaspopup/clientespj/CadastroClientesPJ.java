package cleiton.unisul.piweb.client.telaspopup.clientespj;

import cleiton.unisul.piweb.client.validacao.CampoCNPJ;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.datepicker.client.DateBox.DefaultFormat;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.client.ui.IntegerBox;
import cleiton.unisul.piweb.client.validacao.CompositeCNPJ;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import cleiton.unisul.piweb.client.formularios.FormClientePJ;

public class CadastroClientesPJ extends Composite {

	public CadastroClientesPJ() {
		

		
		FlowPanel flowPanel = new FlowPanel();
		initWidget(flowPanel);
		flowPanel.setSize("925px", "360px");
		
		Label lblSentinelaCadastro = new Label("SENTINELA - Cadastro de Clientes - pessoas jur\u00EDdicas");
		lblSentinelaCadastro.setStyleName("h1");
		lblSentinelaCadastro.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		flowPanel.add(lblSentinelaCadastro);
		lblSentinelaCadastro.setSize("", "20px");
		
		SimplePager simplePager = new SimplePager();
		flowPanel.add(simplePager);
		
		FormClientePJ formClientePJ = new FormClientePJ();
		flowPanel.add(formClientePJ);
		formClientePJ.setHeight("281px");
		
		setStyleName("painelCadastro");
	}

}
