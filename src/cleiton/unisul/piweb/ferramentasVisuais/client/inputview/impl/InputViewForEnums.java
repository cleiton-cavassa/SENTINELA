package cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl;

import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputView;
import cleiton.unisul.piweb.ferramentasVisuais.client.util.FecharPopUpEventHandler;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class InputViewForEnums <T extends Enum<T>> implements InputView<T> {
	
	
	@Override
	public String getTitulo(){
		return "campo para enum";
	}
	
	final private VerticalPanel vp=new VerticalPanel();
	HTML titulo = new HTML();
	final private InputViewListBoxEnumeracoes<T> iv;
	
	public InputViewForEnums(T exemplo, String titulo){
		this(exemplo, titulo, true);
	}
	
	public InputViewForEnums(T exemplo, String titulo, Boolean selecao){
		iv=new InputViewListBoxEnumeracoes<T>(exemplo, selecao);
		this.titulo.setHTML("<b>"+titulo+"</b>");
		
		vp.add(this.titulo);
		vp.add(iv);
	}

	@Override
	public Widget asWidget() {
		return vp;
	}

	@Override
	public boolean setInput(T input) {
		return iv.setInput(input);
	}

	@Override
	public T getInput() {
		return iv.getInput();
	}

	@Override
	public String validarDados() {
		return null;
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
