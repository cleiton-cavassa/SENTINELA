package cleiton.unisul.piweb.client.telaspopup.clientespf;


import java.util.ArrayList;
import java.util.Date;

import com.google.gwt.event.dom.client.ClickEvent;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;

import cleiton.unisul.piweb.client.SENTINELA;
import cleiton.unisul.piweb.client.formularios.FormClientePF;
import cleiton.unisul.piweb.client.telaspopup.clientespj.RelacaoClientesPJ;
import cleiton.unisul.piweb.shared.ClientePF;

public class CriarNovoClientePF extends Composite {
	
	private FormClientePF form;

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
		form = formClientePF ;
		flowPanel1.add(formClientePF);
		setStyleName("painelCadastro");
		
		
		final CallbackArmazenamento callback=new CallbackArmazenamento() ;
		
		ClickHandler salvarClkHnd=new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				salvarClientePF(callback);
			}
		};
		
		
		form.getBotaoSalvar().setText("novo Cliente");
			form.getBotaoSalvar().addClickHandler(salvarClkHnd);
		
		form.getBotaoExcluir().setText("descartar");
	}
	
	protected void salvarClientePF(CallbackArmazenamento callback) {
		ClientePF clPF=montarClientePF();
		if(clPF!=null){
			callback.setClPF(clPF);
			SENTINELA.getArmazenamento().persistir(clPF, callback);
		}else{
			Window.alert("Algum campo requerido deixou de ser preenchido.\nTodos os campos marcados com asterisco (*) precisam ser preenchidos.");
		}
		
	}

	private ClientePF montarClientePF() {

		String nome=form.getTextBoxNome().getText();
		Long cpf=form.getCompositeCPF().getCPF();		
		Long cnpjPJorigem=form.getCompositePJdeOrigem().getCNPJ();
		Date nascimento = form.getDateBoxNascimento().getValue();
		boolean nacionalidade;
			ListBox n= form.getComboBoxTipoNacionalidade();
			nacionalidade=(n.getValue(n.getSelectedIndex()).equals("brasileiro"));
		String idiomas=form.getTextBoxIdiomas().getText();
		String endereco= form.getTextBoxEndereco().getText();
		String telefones=form.getTextBoxTelefones().getText();
		boolean status = form.getChckbxStatus().getValue();
		boolean carregaAnimais=form.getCheckBoxCarregaAnimais().getValue();
		boolean aceitaMotFumante = form.getCheckBoxPermiteMotFumante().getValue();
		
		if ((nome==null)||(nome.equalsIgnoreCase(""))){
			return null;
		}
		
		if (cpf==0){
			return null;
		}
		
		if (nascimento==null){
			return null;
		}
		
		ClientePF cliente=new ClientePF();
			cliente.setNome(nome);
			cliente.setCPF(cpf);
			cliente.setPJVinculada(cnpjPJorigem);
			cliente.setDataNascimento(nascimento);
			cliente.setTipoNacionalidade(nacionalidade);
			cliente.setIdiomasFalados(idiomas);
			cliente.setEndereco(endereco);
			cliente.setTelefones(telefones);
			cliente.setStatus(status);
			cliente.setCarregaAnimais(carregaAnimais);
			cliente.setAceitaMotFumante(aceitaMotFumante);
		return cliente;
	}

	private class CallbackArmazenamento implements AsyncCallback<Boolean>{
		private ClientePF clPF;
		public ClientePF getClPF() {
			return clPF;
		}

		public void setClPF(ClientePF clPJ) {
			this.clPF = clPF;
		}

		@Override
		public void onSuccess(Boolean result) {
			if (result){
				StringBuilder b=new StringBuilder();
				b.append("Dados de Cliente PF salvos com sucesso!\n");
				b.append("CPF: "+clPF.getCPF()+"\n");
				b.append("Nome: "+clPF.getNome());
				RelacaoClientesPF.get().atualizar();
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
			b.append("Houve falha durante o armazenamento dos dados do novo Cliente Pessoa Jur’dica.\n");
			b.append("Por favor, tente novamente em outra oportunidade.\n");
			b.append("Dados do cliente:\n");
			b.append("CNPJ: "+this.getClPF().getCPF()+"\n");
			b.append("Raz‹o Social: "+this.getClPF().getNome()+"\n");
			Window.alert(b.toString());
		}
	}


}
