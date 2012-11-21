package cleiton.unisul.piweb.ferramentasVisuais.client.inputviews;

import com.google.gwt.user.client.ui.TextBox;

import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.exibidor.InputView;

public class InputViewTextBox extends TextBox implements InputView<String>{
	
	public InputViewTextBox(int visibleLenght, int maxLenght){
		super();
		this.setVisibleLength(visibleLenght);
		this.setMaxLength(maxLenght);
	}

	@Override
	public boolean setInput(String input) {
		try{
			this.setText(input);
		}catch(Throwable t){
			return false;
		}
		return true;
	}

	@Override
	public String getInput() {
		return this.getText();
	}

}
