package cleiton.unisul.piweb.ferramentasVisuais.client.inputview;

import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.IsFormulario;

public interface InputView<Input extends Object> extends IsFormulario {
	boolean setInput(Input input);
	Input getInput();
}
