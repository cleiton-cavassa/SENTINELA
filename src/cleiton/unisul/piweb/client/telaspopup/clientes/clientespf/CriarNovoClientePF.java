package cleiton.unisul.piweb.client.telaspopup.clientes.clientespf;

import java.util.Date;


import com.google.gwt.event.dom.client.ClickEvent;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;

import cleiton.unisul.piweb.client.SENTINELA;
import cleiton.unisul.piweb.client.bloqueio.TelaPadraoBloqueada;
import cleiton.unisul.piweb.client.bloqueio.TelaComBloqueio;
import cleiton.unisul.piweb.client.classesabstratas.TelaPersistencia;
import cleiton.unisul.piweb.client.formularios.FormClientePF;
import cleiton.unisul.piweb.client.telaspopup.CallbackArmazenamentoNovoRegistro;
import cleiton.unisul.piweb.shared.ClientePF;

public class CriarNovoClientePF extends Composite implements TelaComBloqueio, TelaPersistencia<ClientePF>{
	
	private static CriarNovoClientePF get=new CriarNovoClientePF(); 
	
	public static CriarNovoClientePF get(){
		if (get==null){
			get=new CriarNovoClientePF();
		}
		return get;
	}
	
	private TelaPadraoBloqueada compositeTelaBloqueada ;
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
				salvar();
			}
		};
		
		form.getBotaoSalvar().setText("novo Cliente");
			form.getBotaoSalvar().addClickHandler(salvarClkHnd);
		
		form.getBotaoExcluir().setText("descartar");
		compositeTelaBloqueada =new TelaPadraoBloqueada();
	}
	
	protected void salvar(){
		ClientePF obj=montarComValidacao();
		if (obj!=null){
			salvar(obj);
		}else{
			Window.alert("Algum campo requerido deixou de ser preenchido.\nTodos os campos marcados com asterisco (*) precisam ser preenchidos.");
		}
	}


	@Override
	public void salvar(ClientePF objeto) {
		final CallbackArmazenamentoNovoRegistro<ClientePF> callback=new CallbackArmazenamentoNovoRegistro<ClientePF>(objeto);
		SENTINELA.getArmazenamento().persistir(objeto,true, false, callback);	
	}

	@Override
	public void setTelaBloqueada(boolean telaBloqueada) {
		if (isTelaBloqueada()==telaBloqueada){
			return;
		}
		this.telaBloqueada =telaBloqueada;
		
		if (telaBloqueada){
			compositeTelaBloqueada.setMensagem(getObjeto().getResumo());
			initWidget(compositeTelaBloqueada);
		}else{
			initWidget(widgetTelaDesbloqueada);
		}
	}
	
	@Override
	public boolean isTelaBloqueada(){
		return telaBloqueada;
	}
	
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
		boolean nacionalidade=cliente.getTipoNacionalidade();
		String idiomas=cliente.getIdiomasFalados();
		String endereco= cliente.getEndereco();
		String telefones=cliente.getTelefones();
		boolean status = cliente.getStatus();
		boolean carregaAnimais=cliente.getCarregaAnimais();
		boolean aceitaMotFumante = cliente.getAceitaMotFumante();
		
		form.getTextBoxNome().setText(nome);
		form.getCompositeCPF().setValor(cpf);		
		form.getCompositePJdeOrigem().setValor(cnpjPJorigem);
		form.getDateBoxNascimento().setValue(nascimento);
		form.getComboBoxTipoNacionalidade().setItemSelected((nacionalidade?0:1), true);
		form.getTextBoxIdiomas().setText(idiomas);
		form.getTextBoxEndereco().setText(endereco);
		form.getTextBoxTelefones().setText(telefones);
		form.getChckbxStatus().setValue(status);
		form.getCheckBoxCarregaAnimais().setValue(carregaAnimais);
		form.getCheckBoxPermiteMotFumante().setValue(aceitaMotFumante);
	}
	
	private ClientePF montarComValidacao() {
		ClientePF cliente = getObjeto();
		
		String nome=cliente.getNome();
		Long cpf=cliente.getChave();		
		Date nascimento = cliente.getDataNascimento();
		
		if ((nome==null)||(nome.equalsIgnoreCase(""))){
			return null;
		}
		
		if (cpf==0){
			return null;
		}
		
		if (nascimento==null){
			return null;
		}
		return cliente;
	}


}
