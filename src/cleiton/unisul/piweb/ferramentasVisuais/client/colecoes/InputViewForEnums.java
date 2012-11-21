package cleiton.unisul.piweb.ferramentasVisuais.client.colecoes;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.exibidor.InputView;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputviews.InputViewListBoxEnumeracoes;

public class InputViewForEnums <T extends Enum<T>> implements InputView<T> {
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
	
}
