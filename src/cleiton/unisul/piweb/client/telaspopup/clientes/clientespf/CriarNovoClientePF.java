package cleiton.unisul.piweb.client.telaspopup.clientes.clientespf;

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
import com.google.gwt.user.client.ui.Widget;

import cleiton.unisul.piweb.client.SENTINELA;
import cleiton.unisul.piweb.client.classesabstratas.CadastroNovaPessoa;
import cleiton.unisul.piweb.client.classesabstratas.TelaBloqueada;
import cleiton.unisul.piweb.client.classesabstratas.TelaNovoRegistro;
import cleiton.unisul.piweb.client.formularios.FormClientePF;
import cleiton.unisul.piweb.client.validacao.CompositeCPF;
import cleiton.unisul.piweb.shared.ClientePF;
import cleiton.unisul.piweb.shared.ObjetoChaveado.RespostaPersistencia;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.SimplePanel;

public class CriarNovoClientePF extends Composite implements TelaNovoRegistro<ClientePF>{
	
	private String tipoRegistro="Cliente Pessoa Física";
	private ClientePF objeto =new ClientePF();
	
	private static CriarNovoClientePF get=new CriarNovoClientePF(); 
	
	public static CriarNovoClientePF get(){
		if (get==null){
			get=new CriarNovoClientePF();
		}
		return get;
	}


	private TelaBloqueada compositeTelaBloqueada ;
	private boolean telaBloqueada; 
	private FormClientePF form;
	private Widget widgetTelaDesbloqueada;
	/**
	 * @wbp.parser.constructor
	 */
	public CriarNovoClientePF() {
		
		FlowPanel flowPanel1 = new FlowPanel();
		widgetTelaDesbloqueada=flowPanel1;
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
		
		ClickHandler salvarClkHnd=new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				salvarClientePF();
			}
		};
		
		
		form.getBotaoSalvar().setText("novo Cliente");
			form.getBotaoSalvar().addClickHandler(salvarClkHnd);
		
		form.getBotaoExcluir().setText("descartar");
		compositeTelaBloqueada =new TelaBloqueada();
	}
	
	protected void salvarClientePF(){
		final CallbackArmazenamento callback=new CallbackArmazenamento() ;
		salvaClientePF(callback);	
	}
	
	protected void salvaClientePF(CallbackArmazenamento callback) {
		ClientePF clPF=montarClientePF();
		callback.setClPF(clPF);
		if(clPF!=null){
			SENTINELA.getArmazenamento().persistir(clPF,true, false, callback);
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

	private class CallbackArmazenamento implements AsyncCallback<RespostaPersistencia>{
		private ClientePF clPF;
		public ClientePF getClPF() {
			return clPF;
		}

		public void setClPF(ClientePF clPF) {
			this.clPF = clPF;
		}

		@Override
		public void onSuccess(RespostaPersistencia result) {
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
			if ((result.getOperacaoBemSucedida()==null)&&(result.getIdObjetoJaExistia().booleanValue()==false)){
				falha("Motivo: já existe um cliente com o CPF informado.");
			}else{
				onFailure(new Exception());
			}
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
		
		@Override
		public void onFailure(Throwable caught) {
			falha("Motivo: desconhecido. Favor comunicar o ocorrido ao administrador do serviço.");
		}
		
	}

	private String mensagemTelaBloqueada(){
		StringBuilder mensagem=new StringBuilder ();
		mensagem.append("Tipo de Registro: novo ");
	 		mensagem.append(objeto().getClass().getName());
	 		mensagem.append("\n");
	 	mensagem.append("CPF: ");
 			mensagem.append(CompositeCPF.mascaraCPF(objeto().getChave()));
	 		mensagem.append("\n");
 		mensagem.append("Nome: ");
 			mensagem.append(objeto().getNome());
	 		mensagem.append("\n");
	 	return mensagem.toString();
	}
	
	@Override
	public void salvar(ClientePF objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTelaBloqueada(boolean telaBloqueada) {
		if (isTelaBloqueada()==telaBloqueada){
			return;
		}
		this.telaBloqueada =telaBloqueada;
		
		if (telaBloqueada){
			compositeTelaBloqueada.setMensagem(mensagemTelaBloqueada());
			initWidget(compositeTelaBloqueada);
		}else{
			initWidget(widgetTelaDesbloqueada);
		}
	}
	@Override
	public ClientePF objeto() {
		return objeto;
	}

	@Override
	public boolean isTelaBloqueada(){
		return telaBloqueada;
	}



}
