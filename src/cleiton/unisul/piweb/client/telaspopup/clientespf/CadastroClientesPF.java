package cleiton.unisul.piweb.client.telaspopup.clientespf;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Composite;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DateBox.DefaultFormat;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.client.ui.Grid;
import cleiton.unisul.piweb.client.validacao.CompositeCPF;
import com.google.gwt.user.client.ui.ListBox;
import cleiton.unisul.piweb.client.formularios.FormClientePF;

public class CadastroClientesPF extends Composite {
	
	/**
	 * @wbp.parser.constructor
	 */
	public CadastroClientesPF() {
		
		FlowPanel flowPanel1 = new FlowPanel();
		flowPanel1.setStyleName("painelCadastro");
		initWidget(flowPanel1);
		flowPanel1.setSize("921px", "");
		
		Label lblSentinelaCadastro = new Label("SENTINELA - Cadastro de Clientes - pessoas f\u00EDsicas");
		lblSentinelaCadastro.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		lblSentinelaCadastro.setStyleName("h1");
		flowPanel1.add(lblSentinelaCadastro);
		lblSentinelaCadastro.setSize("", "");
		
		DockPanel dockPanel = new DockPanel();
		dockPanel.setStyleName("padding5");
		dockPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		flowPanel1.add(dockPanel);
		dockPanel.setWidth("100%");
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		dockPanel.add(horizontalPanel, DockPanel.WEST);
		horizontalPanel.setWidth("100%");
		
		SimplePager simplePager = new SimplePager();
		simplePager.setStyleName("pager");
		horizontalPanel.add(simplePager);
		
		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		horizontalPanel_1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		dockPanel.add(horizontalPanel_1, DockPanel.LINE_END);
		horizontalPanel_1.setWidth("100%");
		
		Button btnNewButton = new Button("Cadastrar novo cliente PF");
		horizontalPanel_1.add(btnNewButton);
		
		FormClientePF formClientePF = new FormClientePF();
		flowPanel1.add(formClientePF);
		setStyleName("painelCadastro");
	}

}
