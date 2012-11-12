package cleiton.unisul.piweb.client.telaspopup.clientes.clientespf;

import java.util.Date;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;

import cleiton.unisul.piweb.client.formularios.FormClientePF;
import cleiton.unisul.piweb.shared.ClientePF;
import cleiton.unisul.piweb.shared.ObjetoChaveado;
import cleiton.unisul.piweb.shared.RespostaPersistencia;
import cleiton.unisul.piweb.shared.ServicoArmazenamento;

public class CadastroClientesPF extends Composite {
	
	private static CadastroClientesPF get = new CadastroClientesPF();
	
	public static CadastroClientesPF get(){
		if(get==null){
			get=new CadastroClientesPF();
		}
		return get;
	}
	
	private ClientePF cliente;
		public ClientePF getCliente() {return cliente;}
		public void setCliente(ClientePF cliente) {this.cliente = cliente;preencherTelaComDadosCliente();}


	private void preencherTelaComDadosCliente() {
		form.getTextBoxNome().setText(cliente.getNome());
		form.getCompositeCPF().setValor(cliente.getChave());
		form.getCompositePJdeOrigem().setValor(cliente.getPJVinculada());
		form.getDateBoxNascimento().setValue(cliente.getDataNascimento());
		form.getComboBoxTipoNacionalidade().setItemSelected((cliente.getTipoNacionalidade()?0:1), true);
		form.getTextBoxIdiomas().setText(cliente.getIdiomasFalados());
		form.getTextBoxEndereco().setText(cliente.getEndereco());
		form.getTextBoxTelefones().setText(cliente.getTelefones());
		form.getChckbxStatus().setValue(cliente.getStatus());
		form.getCheckBoxCarregaAnimais().setValue(cliente.getCarregaAnimais());
		form.getCheckBoxPermiteMotFumante().setValue(cliente.getAceitaMotFumante());
	}

	
	private FormClientePF form;
	
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
		
		FormClientePF formClientePF = new FormClientePF();
		flowPanel1.add(formClientePF);
		
		form = formClientePF;
		setStyleName("painelCadastro");
		

		ClickHandler salvarClkHnd=new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				salvarClientePF();
			}
		};
		
		
		form.getBotaoSalvar().addClickHandler(salvarClkHnd);
	}
	
	protected void salvarClientePF(){
		final CallbackArmazenamento callback=new CallbackArmazenamento() ;
		salvaClientePF(callback);	
	}
	
	protected void salvaClientePF(CallbackArmazenamento callback) {
		ClientePF clPF=montarClientePF();
		callback.setClPF(clPF);
		if(clPF!=null){
			ServicoArmazenamento.getArmazenamento().persistir((ObjetoChaveado)clPF, false, false, callback);
		}else{
			Window.alert("Algum campo requerido deixou de ser preenchido.\nTodos os campos marcados com asterisco (*) precisam ser preenchidos.");
		}
		
	}

	private ClientePF montarClientePF() {

		String nome=form.getTextBoxNome().getText();
		Long cpf=form.getCompositeCPF().getValor();		
		Long cnpjPJorigem=form.getCompositePJdeOrigem().getValor();
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
			cliente.setChave(cpf);
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

	private class CallbackArmazenamento implements AsyncCallback<cleiton.unisul.piweb.shared.RespostaPersistencia>{
		private ClientePF clPF;
		public ClientePF getClPF() {
			return clPF;
		}

		public void setClPF(ClientePF clPF) {
			this.clPF = clPF;
		}

		@Override
		public void onSuccess(cleiton.unisul.piweb.shared.RespostaPersistencia result) {
			
			if (result.getOperacaoBemSucedida()){
				StringBuilder b=new StringBuilder();
				b.append("Dados de Cliente PF salvos com sucesso!\n");
				b.append("CPF: "+clPF.getChave()+"\n");
				b.append("Nome: "+clPF.getNome());
				RelacaoClientesPF.get().atualizar();
				Window.alert(b.toString());
			}
			if (result.getOperacaoBemSucedida().equals(false)){				
				falha("Motivo: problemas de comunicação com o banco de dados.");
			}
			if ((result.getOperacaoBemSucedida()==null)&&result.getIdObjetoJaExistia()){
				falha("Motivo: não existe um cliente com o CPF informado.");
			}else{
				onFailure(new Exception());
			}
				
		}
		
		@Override
		public void onFailure(Throwable caught) {
			falha("Motivo: desconhecido. Favor comunicar o ocorrido ao administrador do serviço.");
		}
		private void falha(String texto){
			StringBuilder b=new StringBuilder();
			b.append("Houve falha durante o armazenamento dos dados do novo Cliente Pessoa Jurídica.\n");
			b.append("Por favor, tente novamente em outra oportunidade.\n");
			b.append("Dados do cliente:\n");
			b.append("CNPJ: "+this.getClPF().getChave()+"\n");
			b.append("Razão Social: "+this.getClPF().getNome()+"\n");
			b.append(((texto==null)?"":texto));
			Window.alert(b.toString());
		}
	}

		
		
	

}
