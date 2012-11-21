package cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.textbox;

import com.google.gwt.user.client.ui.TextBox;

import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.rol.ParserForIsWidgets;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.rol.WidgetComBotaoMenos;

public class ParserPadraoTextBox implements ParserForIsWidgets<String, WidgetComBotaoMenos<TextBox>> {
	
	private int tamanhoMaximoTextBox;
	private int tamanhoVisivelTextBox;
	
	public ParserPadraoTextBox(int tamanhoMaximoTextBox, int tamanhoVisivelTextBox){
		this.tamanhoMaximoTextBox=tamanhoMaximoTextBox;
		this.tamanhoVisivelTextBox=tamanhoVisivelTextBox;
	}
	
	
	@Override
	public WidgetComBotaoMenos<TextBox> set(String input) {
		TextBox t= new TextBox();
			t.setMaxLength(tamanhoMaximoTextBox);
			t.setVisibleLength(tamanhoVisivelTextBox);
		WidgetComBotaoMenos<TextBox> b
			= new WidgetComBotaoMenos<TextBox>(new TextBox());
		set(input,b);
		return b;
	}

	@Override
	public void set(String input, WidgetComBotaoMenos<TextBox> target) {
		target.getWidgetParaExibir().setValue(input);
	}

	@Override
	public String get(WidgetComBotaoMenos<TextBox> isWidget) {
		// TODO Auto-generated method stub
		return isWidget.getWidgetParaExibir().getValue();
	}

}
