package cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.rol;

import cleiton.unisul.piweb.ferramentasVisuais.client.inputviews.InputViewTurno;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.Turno;

public class ParserInputViewTurno implements ParserForIsWidgets<Turno, WidgetComBotaoMenos<InputViewTurno>>{

	@Override
	public WidgetComBotaoMenos<InputViewTurno> set(Turno input) {
		WidgetComBotaoMenos<InputViewTurno> result = new WidgetComBotaoMenos<InputViewTurno>(new InputViewTurno());
		set(input, result);
		return result;
	}

	@Override
	public void set(Turno input, WidgetComBotaoMenos<InputViewTurno> target) {
		target.getWidgetParaExibir().setInput(input);
	}

	@Override
	public Turno get(WidgetComBotaoMenos<InputViewTurno> isWidget) {
		return isWidget.getWidgetParaExibir().getInput();
	}

}
