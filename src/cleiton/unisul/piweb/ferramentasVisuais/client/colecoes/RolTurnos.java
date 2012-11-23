package cleiton.unisul.piweb.ferramentasVisuais.client.colecoes;

import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.rol.CriadorWidgets;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.rol.ParserForIsWidgets;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.rol.ParserInputViewTurno;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.rol.WidgetComBotaoMenos;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputviews.InputViewTurno;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.Turno;

public class RolTurnos extends Rol<WidgetComBotaoMenos<InputViewTurno>, Turno> {

	public RolTurnos(
			CriadorWidgets<WidgetComBotaoMenos<InputViewTurno>> criador,
			ParserForIsWidgets<Turno, WidgetComBotaoMenos<InputViewTurno>> parser) {
		super(criador, parser);
		
	}
	public RolTurnos(){
		this(new Criador(),new ParserInputViewTurno());
	}

	private static class Criador implements CriadorWidgets<WidgetComBotaoMenos<InputViewTurno>>{
		@Override
		public WidgetComBotaoMenos<InputViewTurno> criarWidget() {
			return new ParserInputViewTurno().set(new Turno());
		}
		
	}
	

}
