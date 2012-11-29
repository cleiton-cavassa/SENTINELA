package cleiton.unisul.piweb.ferramentasVisuais.client.inputview;

public interface InputViewFactory <Input extends Object> {
	InputView<Input> getInputView();
}
