package cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl;

import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.FormPesquisar.PesquisaCallBack;
import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.FormPesquisarFactory;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputView;
import cleiton.unisul.piweb.ferramentasVisuais.client.util.CriadorTela;
import cleiton.unisul.piweb.ferramentasVisuais.client.util.FecharPopUpEventHandler;
import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.ParChaveDescricao;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class InputViewParChaveDescricao <Ob extends ObjetoChaveado> implements InputView<ParChaveDescricao<Ob>>{
	
	private String vCategoria;
	private InputProperty inputProperty = new InputProperty();
	private FlowPanel flow= new FlowPanel();
	private HTML conteudo = new HTML();
	private boolean habilitado;
	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		botao.setEnabled(habilitado);
		this.habilitado = habilitado;
	}

	private Button botao=new Button();
//	private final FormPesquisarFactory<Ob>fabricaFormularios;
	



	public InputViewParChaveDescricao(String categoria, String titulo, FormPesquisarFactory<Ob> fabricaFormularios){
		this(categoria, titulo, fabricaFormularios, true);
	}
	
	public InputViewParChaveDescricao(String categoria, String titulo, final FormPesquisarFactory<Ob> fabricaFormularios, boolean alterarComCliqueNoBotao){
		this.vCategoria=categoria;
//		this.fabricaFormularios=fabricaFormularios;
		
		CaptionPanel c = new CaptionPanel(titulo);
		VerticalPanel v= new VerticalPanel();
		c.add(v);
		flow.add(c);
		
		v.add(conteudo);
		v.add(botao);
		
		botao.setText("escolher");
		botao.addStyleName("botaoLogout");
		setHabilitado(alterarComCliqueNoBotao);
		
//		if(alterarComCliqueNoConteudo){
			botao.addClickHandler(new ClickHandler() {
			
				@Override
				public void onClick(ClickEvent event) {
					if (fabricaFormularios == null ){
						return;
					}
					new CriadorTela<Ob>(fabricaFormularios.getFormPesquisar(callback)).execute();	
				}
			});
//		}
	}
	
	private PesquisaCallBack<Ob> callback = new PesquisaCallBack<Ob>() {
		@Override
		public void sucesso(Ob resposta) {
			ParChaveDescricao<Ob> p = new ParChaveDescricao<Ob>();
				p.setChaveObjeto(resposta.getChave());
				p.setDescricao(resposta.getResumo());
			inputProperty.setInput(p);
		}
		@Override
		public void semResposta() {}
	};
	
	private class InputProperty {
		private ParChaveDescricao<Ob> input=null; 
		public boolean setInput(ParChaveDescricao<Ob> input){
			this.input= input;
			atualizaDados();
			return true;
		}
		public ParChaveDescricao<Ob> getInput(){
			return this.input;
		}
	}
	
	private void atualizaDados() {
		conteudo.setHTML(inputProperty.getInput().getDescricao());
	}
	
	@Override
	public String validarDados() {
		return null;
	}

	@Override
	public String getTitulo() {
		// TODO Auto-generated method stub
		return vCategoria;
	}

	@Override
	public Widget asWidget() {
		return flow;
	}

	@Override
	public boolean setInput(ParChaveDescricao<Ob> input) {
		return inputProperty.setInput(input);
	}

	@Override
	public ParChaveDescricao<Ob> getInput() {
		return inputProperty.getInput();
	}

	@Override
	public boolean setFecharHandler(FecharPopUpEventHandler f) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void fechar() {
		// TODO Auto-generated method stub
		
	}

}
