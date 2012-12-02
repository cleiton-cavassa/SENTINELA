package cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.FormPesquisar;
import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.FormPesquisar.PesquisaCallBack;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputView;
import cleiton.unisul.piweb.ferramentasVisuais.client.util.CriadorTela;
import cleiton.unisul.piweb.ferramentasVisuais.client.util.FecharPopUpEventHandler;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.ParChaveDescricao;

public class InputViewParChaveDescricao implements InputView<ParChaveDescricao>{
	
	private String vCategoria;
	private InputProperty inputProperty = new InputProperty();
	private FlowPanel flow= new FlowPanel();
	private HTML conteudo = new HTML();
	private boolean botaoHabilitado;
	private Button botao=new Button();
	
	public boolean isBotaoHabilitado() {
		return botaoHabilitado;
	}

	public void setBotaoHabilitado(boolean botaoHabilitado) {
		this.botaoHabilitado= botaoHabilitado;
		botao.setEnabled(botaoHabilitado);
		
	}


	public InputViewParChaveDescricao(String categoria, String titulo){
		this(categoria, titulo, true);
	}
	
	public InputViewParChaveDescricao(String categoria, String titulo, boolean alterarComCliqueNoConteudo){
		this.vCategoria=categoria;
		
		CaptionPanel c = new CaptionPanel(titulo);
		VerticalPanel v= new VerticalPanel();
		c.add(v);
		flow.add(c);
		
		v.add(conteudo);
		v.add(botao);
		
		botao.setText("clique aqui para escolher o "+titulo);
		
//		if(alterarComCliqueNoConteudo){
			botao.addClickHandler(new ClickHandler() {
			
				@Override
				public void onClick(ClickEvent event) {
					new CriadorTela(new FormPesquisar(vCategoria, callback)).execute();	
				}
			});
//		}
	}
	
	private PesquisaCallBack callback = new PesquisaCallBack() {
		@Override
		public void sucesso(ParChaveDescricao resposta) {
			inputProperty.setInput(resposta);
		}
		@Override
		public void semResposta() {}
	};
	
	private void atualizaDados() {
		conteudo.setHTML(inputProperty.getInput().getDescricao());
	}
	
	private class InputProperty {
		private ParChaveDescricao input=null; 
		public boolean setInput(ParChaveDescricao input){
			this.input= input;
			atualizaDados();
			return true;
		}
		public ParChaveDescricao getInput(){
			return this.input;
		}
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
	public boolean setInput(ParChaveDescricao input) {
		return inputProperty.setInput(input);
	}

	@Override
	public ParChaveDescricao getInput() {
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
