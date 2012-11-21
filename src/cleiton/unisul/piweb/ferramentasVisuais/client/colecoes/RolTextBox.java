package cleiton.unisul.piweb.ferramentasVisuais.client.colecoes;

import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.rol.CriadorWidgets;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.rol.WidgetComBotaoMenos;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.textbox.ParserPadraoTextBox;

import com.google.gwt.user.client.ui.TextBox;

public class RolTextBox extends Rol<WidgetComBotaoMenos<TextBox>, String>{

	public RolTextBox(CriadorWidgets<WidgetComBotaoMenos<TextBox>> criador,
			ParserPadraoTextBox parser) {
		super(criador, parser);
	}
	
	public RolTextBox(int tamanhoMaximoTextBox, int tamanhoVisivelTextBox) {
		super(new Criador(tamanhoMaximoTextBox, tamanhoVisivelTextBox),
				new ParserPadraoTextBox(tamanhoMaximoTextBox,tamanhoVisivelTextBox));
	}

	private static class Criador implements CriadorWidgets<WidgetComBotaoMenos<TextBox>>{
		private int tamanhoMaximoTextBox;
		private int tamanhoVisivelTextBox;
		
		public Criador(int tamanhoMaximoTextBox, int tamanhoVisivelTextBox){
			this.tamanhoMaximoTextBox=tamanhoMaximoTextBox;
			this.tamanhoVisivelTextBox=tamanhoVisivelTextBox;
		}
		
		@Override
		public WidgetComBotaoMenos<TextBox> criarWidget() {
			return new ParserPadraoTextBox(tamanhoMaximoTextBox,tamanhoVisivelTextBox).set("");
		}
		
	}
}
