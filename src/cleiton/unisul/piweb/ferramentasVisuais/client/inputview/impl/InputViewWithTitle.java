package cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl;

import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputView;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;


public class InputViewWithTitle <Ob extends Object>implements InputView<Ob> {
	
	@Override
	public String getTitulo(){
		return null;
	}
	
	private final VerticalPanel vp=new VerticalPanel();
	private final InputView<Ob> inputView;
	private final HTML labelTitulo=new HTML();
	
	public InputViewWithTitle (String titulo, InputView<Ob> inputView){
		vp.add(labelTitulo);
			labelTitulo.setHTML("<b>"+titulo+"</b>");
		vp.add(inputView);
		this.inputView=inputView;
	}
	
	@Override
	public Widget asWidget() {
		return vp;
	}

	@Override
	public boolean setInput(Ob input) {
		return inputView.setInput(input);
	}

	@Override
	public Ob getInput() {
		return inputView.getInput();
	}

	@Override
	public String validarDados() {
		return null;
	}
}
