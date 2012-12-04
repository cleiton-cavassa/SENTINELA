package cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl;

import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.FormPesquisar;
import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.FormPesquisar.PesquisaCallBack;
import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.FormPesquisarFactory;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputView;
import cleiton.unisul.piweb.ferramentasVisuais.client.util.FecharPopUpEventHandler;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.CorridaSolicitada;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.ParChaveDescricao;
import cleiton.unisul.piweb.sistema.client.formularios.pesquisa.FormPesquisarCorridaSolicitada;

import com.google.gwt.user.client.ui.Widget;


public class InputViewCorridaSolicitada implements InputView<CorridaSolicitada>{

	
	private CorridaSolicitada corridaSolicitada;
	private InputViewParChaveDescricao<CorridaSolicitada> iv; 
	
	public InputViewCorridaSolicitada (final String chavePai){
		
		iv = new InputViewParChaveDescricao<CorridaSolicitada>("CorridaSolicitada", "Corrida Solicitada", new FormPesquisarFactory<CorridaSolicitada>() {

			@Override
			public FormPesquisar<CorridaSolicitada> getFormPesquisar(
					PesquisaCallBack<CorridaSolicitada> callback) {
				return new FormPesquisarCorridaSolicitada("CorridaSolicitada", chavePai, callback);
			}
		}, false);
		iv.setHabilitado(false);
		
	}

	@Override
	public String validarDados() {
		return null;
	}

	@Override
	public String getTitulo() {
		return "escolher corrida solicitada";
	}

	@Override
	public Widget asWidget() {
		return iv.asWidget();
	}

	@Override
	public boolean setInput(CorridaSolicitada input) {
		corridaSolicitada= input;
		ParChaveDescricao par = new ParChaveDescricao();
		par.setChaveObjeto(
				input
				.
				getChave());
		par.setDescricao(input.toString());
		
		return iv.setInput(par);
	}

	@Override
	public CorridaSolicitada getInput() {
		return corridaSolicitada;
	}

	private FecharPopUpEventHandler f;
	@Override
	public boolean setFecharHandler(FecharPopUpEventHandler f) {
		this.f=f;
		return true;
	}

	@Override
	public void fechar() {
		f.fecharPopUp();
	}
	
}
