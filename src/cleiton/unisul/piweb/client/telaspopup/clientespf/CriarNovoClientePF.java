package cleiton.unisul.piweb.client.telaspopup.clientespf;


import com.google.gwt.user.client.ui.Composite;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

import cleiton.unisul.piweb.client.formularios.FormClientePF;

public class CriarNovoClientePF extends Composite {
	
	/**
	 * @wbp.parser.constructor
	 */
	public CriarNovoClientePF() {
		
		FlowPanel flowPanel1 = new FlowPanel();
		flowPanel1.setStyleName("painelCadastro");
		initWidget(flowPanel1);
		flowPanel1.setSize("", "");
		
		Label lblSentinelaCadastro = new Label("SENTINELA - novo Cliente Pessoa F\u00EDsica");
		lblSentinelaCadastro.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		lblSentinelaCadastro.setStyleName("h1");
		flowPanel1.add(lblSentinelaCadastro);
		lblSentinelaCadastro.setSize("", "");
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		flowPanel1.add(horizontalPanel);
		
		FormClientePF formClientePF = new FormClientePF();
		flowPanel1.add(formClientePF);
		setStyleName("painelCadastro");
	}

}
