package cleiton.unisul.piweb.client.telaspopup.clientes.clientespj;

import com.google.gwt.user.client.ui.Composite;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.cellview.client.SimplePager;
import cleiton.unisul.piweb.client.formularios.FormClientePJ;
import cleiton.unisul.piweb.shared.ClientePJ;

public class CadastroClientesPJ extends Composite {

	private static CadastroClientesPJ get=new CadastroClientesPJ();
	
	public static CadastroClientesPJ get(){
		if(get==null){
			get=new CadastroClientesPJ();
		}
		return get;
	}
	
	private ClientePJ cliente;
		public ClientePJ getCliente(){return cliente;}
		public void setCliente(ClientePJ cliente) {this.cliente = cliente;preencherTelaComDadosCliente();}
	

	private FormClientePJ form;

	private CadastroClientesPJ() {

		FlowPanel flowPanel = new FlowPanel();
		initWidget(flowPanel);
		flowPanel.setSize("925px", "360px");
		
		Label lblSentinelaCadastro = new Label("SENTINELA - Cadastro de Clientes - pessoas jur\u00EDdicas");
		lblSentinelaCadastro.setStyleName("h1");
		lblSentinelaCadastro.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		flowPanel.add(lblSentinelaCadastro);
		lblSentinelaCadastro.setSize("", "20px");
		
		FormClientePJ formClientePJ = new FormClientePJ();
		flowPanel.add(formClientePJ);
		formClientePJ.setHeight("281px");
		
		form = formClientePJ;
		setStyleName("painelCadastro");
	}
	
	private void preencherTelaComDadosCliente(){
		form.getCompositeCNPJ().setValor(cliente.getChave());
		form.getTextBoxRazaoSocial().setText(cliente.getRazaoSocial());
		form.getEnderecoMatriz().setText(cliente.getEnderecoMatriz());
		//Regioes de atuação
		String regs="";
		for(String s:cliente.getRegioesDeAtuacao()){
			regs+=s;
		}
		form.getTextBoxRegioesDeAtuacao().setText(regs);
		form.getCheckBoxAtivo().setValue(cliente.getStatus());
		form.getCheckboxVouchersAtivos().setValue(cliente.getVouchersAtivos());
	}

}
