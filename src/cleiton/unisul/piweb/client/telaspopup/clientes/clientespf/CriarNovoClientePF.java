package cleiton.unisul.piweb.client.telaspopup.clientes.clientespf;

import java.util.Date;


import com.google.gwt.event.dom.client.ClickEvent;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;

import cleiton.unisul.piweb.client.SENTINELA;
import cleiton.unisul.piweb.client.bloqueio.TelaPadraoBloqueada;
import cleiton.unisul.piweb.client.bloqueio.TelaComBloqueio;
import cleiton.unisul.piweb.client.formularios.FormClientePF;
import cleiton.unisul.piweb.client.persistencia.TelaPersistencia;
import cleiton.unisul.piweb.client.telaspopup.telasnovoregistro.CallbackArmazenamentoNovoRegistro;
import cleiton.unisul.piweb.client.telaspopup.telasnovoregistro.TelaNovoRegistro;
import cleiton.unisul.piweb.shared.ClientePF;
import cleiton.unisul.piweb.shared.ObjetoChaveado;
import cleiton.unisul.piweb.shared.ServicoArmazenamento;
import com.google.gwt.user.client.ui.SimplePanel;

public class CriarNovoClientePF extends TelaNovoRegistro<ClientePF> {
	
	private static CriarNovoClientePF get=new CriarNovoClientePF(); 
	
	public static CriarNovoClientePF get(){
		if (get==null){
			get=new CriarNovoClientePF();
		}
		return get;
	}
	
//	private TelaPadraoBloqueada compositeTelaBloqueada ;
//	private boolean telaBloqueada; 
	private FormClientePF form=new FormClientePF();
	private FlowPanel widgetTelaDesbloqueada=new FlowPanel();
	/**
	 * @wbp.parser.constructor
	 */
	public CriarNovoClientePF() {
		
//		FlowPanel flowPanel1 = new FlowPanel();
//		flowPanel1=widgetTelaDesbloqueada;
		
		FlowPanel thePanel = new FlowPanel();
		thePanel.add(widgetTelaDesbloqueada);
		initWidget(thePanel);
		thePanel.setSize("950px", "100%");
		
		widgetTelaDesbloqueada.setStyleName("painelCadastro");
		widgetTelaDesbloqueada.setSize("936px", "");
		
		Label lblSentinelaCadastro = new Label("SENTINELA - novo Cliente Pessoa F\u00EDsica");
		lblSentinelaCadastro.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		lblSentinelaCadastro.setStyleName("h1");
		widgetTelaDesbloqueada.add(lblSentinelaCadastro);
		lblSentinelaCadastro.setSize("", "");
		


		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		widgetTelaDesbloqueada.add(horizontalPanel);
		
//		FormClientePF formClientePF = new FormClientePF();
//		form = formClientePF ;
		widgetTelaDesbloqueada.add(form);
		setStyleName("painelCadastro");
		
		final CriarNovoClientePF eu=this;
		ClickHandler salvarClkHnd=new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				eu.salvarCommand().execute();
			}
		};
		
		form.getBotaoSalvar().setText("novo Cliente");
			form.getBotaoSalvar().addClickHandler(salvarClkHnd);
		
		form.getBotaoExcluir().setText("descartar");
		
		thePanel.add(this.compositeTelaBloqueada);
//		compositeTelaBloqueada =new TelaPadraoBloqueada();
	}
	
//	protected void salvar(){
//		ClientePF obj=montarComValidacao();
//		if (obj!=null){
//			salvar(obj);
//		}else{
//			Window.alert("Algum campo requerido deixou de ser preenchido.\nTodos os campos marcados com asterisco (*) precisam ser preenchidos.");
//		}
//	}


//	@Override
//	public void setTelaBloqueada(boolean telaBloqueada) {
//		if (isTelaBloqueada()==telaBloqueada){
//			return;
//		}
//		this.telaBloqueada =telaBloqueada;
//		
//		if (telaBloqueada){
//			compositeTelaBloqueada.setMensagem(getObjeto().getResumo());
//			initWidget(compositeTelaBloqueada);
//		}else{
//			initWidget(widgetTelaDesbloqueada);
//		}
//	}
//	
//	@Override
//	public boolean isTelaBloqueada(){
//		return telaBloqueada;
//	}
	
	@Override
	public ClientePF getObjeto() {
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

	@Override
	public void setObjeto(ClientePF cliente) {
		String nome=cliente.getNome();
		Long cpf=cliente.getChave();		
		Long cnpjPJorigem=cliente.getPJVinculada();
		Date nascimento = cliente.getDataNascimento();
		Boolean nacionalidade=cliente.getTipoNacionalidade();
			nacionalidade=(nacionalidade==null?false:nacionalidade);
		String idiomas=cliente.getIdiomasFalados();
		String endereco= cliente.getEndereco();
		String telefones=cliente.getTelefones();
		Boolean status = cliente.getStatus();
			status=(status==null?false:status);
		Boolean carregaAnimais=cliente.getCarregaAnimais();
			carregaAnimais=(carregaAnimais==null?false:carregaAnimais);
		Boolean aceitaMotFumante = cliente.getAceitaMotFumante();
			aceitaMotFumante=(aceitaMotFumante==null?false:aceitaMotFumante);
		form.getTextBoxNome().setText(nome);
		form.getCompositeCPF().setValor(cpf);		
		form.getCompositePJdeOrigem().setValor(cnpjPJorigem);
		form.getDateBoxNascimento().setValue(nascimento);
		form.getComboBoxTipoNacionalidade().setItemSelected((nacionalidade?1:0), true);
		form.getTextBoxIdiomas().setText(idiomas);
		form.getTextBoxEndereco().setText(endereco);
		form.getTextBoxTelefones().setText(telefones);
		form.getChckbxStatus().setValue(status);
		form.getCheckBoxCarregaAnimais().setValue(carregaAnimais);
		form.getCheckBoxPermiteMotFumante().setValue(aceitaMotFumante);
	}
	
//	private ClientePF montarComValidacao() {
//		ClientePF cliente = getObjeto();
//		
//		String nome=cliente.getNome();
//		Long cpf=cliente.getChave();		
//		Date nascimento = cliente.getDataNascimento();
//		
//		if ((nome==null)||(nome.equalsIgnoreCase(""))){
//			return null;
//		}
//		
//		if (cpf==0){
//			return null;
//		}
//		
//		if (nascimento==null){
//			return null;
//		}
//		return cliente;
//	}

	@Override
	protected boolean validar() {
		ClientePF cliente = getObjeto();
			String nome=cliente.getNome();
			Long cpf=cliente.getChave();		
			Date nascimento = cliente.getDataNascimento();
		if ((nome==null)||(nome.equalsIgnoreCase(""))){
			return false;
		}
		if (cpf<=0){
			return false;
		}
		if (nascimento==null){
			return false;
		}
		return true;
	}

	@Override
	protected Widget getWidgetTelaDesbloqueada() {
		return widgetTelaDesbloqueada;
	}

	@Override
	protected Button getBotaoSalvar() {
		return form.getBotaoSalvar();
	}

	@Override
	public void limpar() {
		setObjeto(new ClientePF());
	}
}
