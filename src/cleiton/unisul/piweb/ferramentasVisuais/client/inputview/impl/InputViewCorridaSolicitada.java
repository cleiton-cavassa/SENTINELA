package cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl;

import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputView;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.CorridaSolicitada;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.ParChaveDescricao;

import com.google.gwt.user.client.ui.Widget;


public class InputViewCorridaSolicitada implements InputView<CorridaSolicitada>{
	private CorridaSolicitada corr;

	
	private InputViewParChaveDescricao iv; 
	
	public InputViewCorridaSolicitada (String categoria, String titulo){
		iv = new InputViewParChaveDescricao(categoria, titulo, false);
	}

	@Override
	public String validarDados() {
		return null;
	}

	@Override
	public String getTitulo() {
		return null;
	}

	@Override
	public Widget asWidget() {
		return iv.asWidget();
	}

	@Override
	public boolean setInput(CorridaSolicitada input) {
		ParChaveDescricao par = new ParChaveDescricao();
		par.setChaveObjeto(input.getChave());
		par.setDescricao(input.toString());
		
		return iv.setInput(par);
	}

	@Override
	public CorridaSolicitada getInput() {
		return corr;
	}
	
}
