package cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.exibidor;

import com.google.gwt.user.client.ui.IsWidget;

public interface InputView<Input extends Object> extends IsWidget {
	boolean setInput(Input input);
	Input getInput();
}
