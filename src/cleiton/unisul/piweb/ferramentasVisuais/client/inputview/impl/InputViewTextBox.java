package cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl;

import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputView;
import cleiton.unisul.piweb.ferramentasVisuais.client.util.FecharPopUpEventHandler;

import com.google.gwt.user.client.ui.TextBox;


public class InputViewTextBox extends TextBox implements InputView<String>{
	
	private FecharPopUpEventHandler f;   
	
	
	@Override
	public String getTitulo(){
		return "Campo para digitar texto";
	}
	
	public InputViewTextBox(int visibleLenght, int maxLenght){
		super();
		this.addStyleName("padding5");
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
		return this.getValue();
	}

	@Override
	public String validarDados() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setFecharHandler(FecharPopUpEventHandler f) {
		this.f=f;
		return true;
	}

	@Override
	public void fechar() {
		f.fecharPopUp();
	}

}
