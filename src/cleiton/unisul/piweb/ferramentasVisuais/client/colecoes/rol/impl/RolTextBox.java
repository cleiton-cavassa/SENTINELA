package cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.rol.impl;

import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.excludeMePlease.impl.WidgetComBotaoMenos;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.rol.Rol;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewTextBox;

import com.google.gwt.user.client.ui.TextBox;

public class RolTextBox extends Rol<WidgetComBotaoMenos<InputViewTextBox>, String>{

	@Override
	public String getTitulo(){
		return null;
	}

	public RolTextBox(ParserTextBox parser) {
		super(parser);
	}
	
	public RolTextBox(int tamanhoMaximoTextBox, int tamanhoVisivelTextBox) {
		super(new ParserTextBox(tamanhoMaximoTextBox,tamanhoVisivelTextBox));
	}
	
	
	private static class ParserTextBox implements Parser<String, WidgetComBotaoMenos<InputViewTextBox>> {
		
		private int tamanhoMaximoTextBox;
		private int tamanhoVisivelTextBox;
		
		public ParserTextBox(int tamanhoMaximoTextBox, int tamanhoVisivelTextBox){
			this.tamanhoMaximoTextBox=tamanhoMaximoTextBox;
			this.tamanhoVisivelTextBox=tamanhoVisivelTextBox;
		}
		
		@Override
		public WidgetComBotaoMenos<InputViewTextBox> set() {
			TextBox t= new TextBox();
			t.setMaxLength(tamanhoMaximoTextBox);
			t.setVisibleLength(tamanhoVisivelTextBox);
			WidgetComBotaoMenos<InputViewTextBox> b
				= new WidgetComBotaoMenos<InputViewTextBox>(new InputViewTextBox(tamanhoVisivelTextBox, tamanhoMaximoTextBox));
			return b;
		}
		
		@Override
		public WidgetComBotaoMenos<InputViewTextBox> set(String input) {
			WidgetComBotaoMenos<InputViewTextBox> b= set();
			set(input,b);
			return b;
		}

		@Override
		public void set(String input, WidgetComBotaoMenos<InputViewTextBox> target) {
			target.getWidgetParaExibir().setInput(input);
		}

		@Override
		public String get(WidgetComBotaoMenos<InputViewTextBox> isWidget) {
			return isWidget.getWidgetParaExibir().getInput();
		}
	}
	
}
