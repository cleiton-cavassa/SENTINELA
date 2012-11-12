package cleiton.unisul.piweb.client.telaspopup.clientes.clientespj;

import java.util.ArrayList;


import cleiton.unisul.piweb.client.SENTINELA;


import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import cleiton.unisul.piweb.client.formularios.FormClientePJ;
import cleiton.unisul.piweb.shared.ClientePJ;
import cleiton.unisul.piweb.shared.RespostaPersistencia;
import cleiton.unisul.piweb.shared.ServicoArmazenamento;

public class CriarNovoClientePJ extends Composite {

	private static CriarNovoClientePJ get=new CriarNovoClientePJ();
	public static CriarNovoClientePJ get(){
		if(get==null){
			get=new CriarNovoClientePJ();
		}
		return get;
	}
	private final CriarNovoClientePJ eu;
	private final FormClientePJ form;
	
	ClientePJ cliente;
	
	public ClientePJ getCliente() {
		return cliente;
	}

	public void setCliente(ClientePJ cliente) {
		this.cliente = cliente;
		preencherTelaComDadosCliente();
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

	private CriarNovoClientePJ() {
		
		eu=this;
		
		FlowPanel flowPanel = new FlowPanel();
		initWidget(flowPanel);
		flowPanel.setSize("925px", "360px");
		
		Label lblSentinelaCadastro = new Label("SENTINELA - novo Cliente Pessoa Jur\u00EDdica");
		lblSentinelaCadastro.setStyleName("h1");
		lblSentinelaCadastro.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		flowPanel.add(lblSentinelaCadastro);
		lblSentinelaCadastro.setSize("", "20px");
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		flowPanel.add(horizontalPanel);
		
		FormClientePJ formClientePJ = new FormClientePJ();
		flowPanel.add(formClientePJ);
		formClientePJ.setHeight("281px");
		form=formClientePJ;
		
		final CallbackArmazenamento callback=new CallbackArmazenamento() ;
		ClickHandler salvarClkHnd=new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				salvarClientePJ(callback);
			}
		};
		formClientePJ.getBotaoSalvar().addClickHandler(salvarClkHnd);
		formClientePJ.getBotaoSalvar().setText("novo Cliente");
		
		formClientePJ.getBotaoExcluir().setText("descartar");
//		formClientePJ.getBotaoNovoClientePF().setEnabled(false);
		
		setStyleName("painelCadastro");
	}
	protected void salvarClientePJ(CallbackArmazenamento callback){
		ClientePJ clPJ=eu.montarClientePJ();
		callback.setClPJ(clPJ);
		if(clPJ!=null){
			ServicoArmazenamento.getArmazenamento().persistir(clPJ,true, false, callback);
		}else{
			Window.alert("Algum campo requerido deixou de ser preenchido.\nTodos os campos marcados com asterisco (*) precisam ser preenchidos.");
		}
	}
	
	
	protected ClientePJ montarClientePJ() {

	//CNPJ
		long cnpj =form.getCompositeCNPJ().getValor();
		if(cnpj==0){
			return null;
		}
	//Razão Social
		String rzsc=form.getTextBoxRazaoSocial().getText();
		if((rzsc==null)||(rzsc.equalsIgnoreCase(""))){
			return null;
		}
	//Endereço da Matriz
		String end = form.getEnderecoMatriz().getText();
	//Regiões de Atuação
		ArrayList<String> reg= new ArrayList<String>();
		reg.add(
				form.getTextBoxRegioesDeAtuacao().getText()
				);
	//Status (ativo/inativo)
		boolean status=form.getCheckBoxAtivo().getValue();
	//Vouchers (ativos/inativos)
		boolean vouchersAtivos=form.getCheckboxVouchersAtivos().getValue();
	//Pessoas Fisicas
		//result.setPessoasFisicas(...);
		
	//Montagem do objeto ClientePJ
		ClientePJ result = new ClientePJ();
			result.setChave(cnpj);
			result.setRazaoSocial(rzsc);
			result.setEnderecoMatriz(end);
			result.setRegioesDeAtuacao(reg);
			result.setStatus(status);
			result.setVouchersAtivos(vouchersAtivos);
		
		return result;
	}

	private class CallbackArmazenamento implements AsyncCallback<RespostaPersistencia>{
		private ClientePJ clPJ;
		public ClientePJ getClPJ() {
			return clPJ;
		}

		public void setClPJ(ClientePJ clPJ) {
			this.clPJ = clPJ;
		}

		@Override
		public void onSuccess(RespostaPersistencia result) {
			if (result.getOperacaoBemSucedida()){
				StringBuilder b=new StringBuilder();
				b.append("Dados de Cliente PJ salvos com sucesso!\n");
				b.append("CNPJ: "+clPJ.getChave()+"\n");
				b.append("RazSocial: "+clPJ.getRazaoSocial());
				RelacaoClientesPJ.get().atualizar();
				Window.alert(b.toString());
			}else{
				falha();
			}
		}
		
		@Override
		public void onFailure(Throwable caught) {
			falha();
		}
		private void falha(){
			StringBuilder b=new StringBuilder();
			b.append("Houve falha durante o armazenamento dos dados do novo Cliente Pessoa Jurídica.\n");
			b.append("Por favor, tente novamente em outra oportunidade.\n");
			b.append("Dados do cliente:\n");
			b.append("CNPJ: "+this.getClPJ().getChave()+"\n");
			b.append("Razão Social: "+this.getClPJ().getRazaoSocial()+"\n");
			Window.alert(b.toString());
		}
	}

	
}
