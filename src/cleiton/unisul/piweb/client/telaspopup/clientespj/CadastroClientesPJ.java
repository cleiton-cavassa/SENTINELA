package cleiton.unisul.piweb.client.telaspopup.clientespj;

import com.google.gwt.user.client.ui.Composite;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.cellview.client.SimplePager;
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
