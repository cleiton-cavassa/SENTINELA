package cleiton.unisul.piweb.client.telaspopup.clientespj;

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

public class CriarNovoClientePJ extends Composite {


	private final CriarNovoClientePJ eu;
	private final FormClientePJ form;

	public CriarNovoClientePJ() {
		
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
		
		final respostaArmazenamentoClientePJ a=new respostaArmazenamentoClientePJ() ;
		ClickHandler salvarClkHnd=new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				ClientePJ clPJ=eu.montarClientePJ();
				a.setClPJ(clPJ);
				if(clPJ!=null){
					SENTINELA.getArmazenamento().persistir(clPJ, a);
				}else{
					Window.alert("Algum campo requerido deixou de ser preenchido.\nTodos os campos marcados com asterisco (*) precisam ser preenchidos.");
				}
			}
		};
		formClientePJ.getBotaoSalvar().addClickHandler(salvarClkHnd);
		
		
		setStyleName("painelCadastro");
	}

	protected ClientePJ montarClientePJ() {

	//CNPJ
		long cnpj =form.getCompositeCNPJ().getCNPJ();
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
			result.setCNPJ(cnpj);
			result.setRazaoSocial(rzsc);
			result.setEnderecoMatriz(end);
			result.setRegioesDeAtuacao(reg);
			result.setStatus(status);
			result.setVouchersAtivos(vouchersAtivos);
		
		return result;
	}

	private class respostaArmazenamentoClientePJ implements AsyncCallback<Boolean>{
		private ClientePJ clPJ;
		public ClientePJ getClPJ() {
			return clPJ;
		}

		public void setClPJ(ClientePJ clPJ) {
			this.clPJ = clPJ;
		}

		@Override
		public void onSuccess(Boolean result) {
			if (result){
				StringBuilder b=new StringBuilder();
				b.append("Dados de Cliente PJ salvos com sucesso!\n");
				b.append("CNPJ: "+clPJ.getCNPJ()+"\n");
				b.append("RazSocial: "+clPJ.getRazaoSocial());
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
			b.append("CNPJ: "+this.getClPJ().getCNPJ()+"\n");
			b.append("Razão Social: "+this.getClPJ().getRazaoSocial()+"\n");
			Window.alert(b.toString());
		}
	}

	
}
