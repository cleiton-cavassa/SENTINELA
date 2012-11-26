package cleiton.unisul.piweb.ferramentasVisuais.client.inputview;

import cleiton.unisul.piweb.sistema.client.formularios.IsFormulario;

public interface InputView<Input extends Object> extends IsFormulario {
	boolean setInput(Input input);
	Input getInput();
}
