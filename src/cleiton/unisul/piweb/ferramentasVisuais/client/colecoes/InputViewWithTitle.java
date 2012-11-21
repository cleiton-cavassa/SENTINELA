package cleiton.unisul.piweb.ferramentasVisuais.client.colecoes;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.exibidor.InputView;

public class InputViewWithTitle <Ob extends Object>implements InputView<Ob> {
	
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
}
