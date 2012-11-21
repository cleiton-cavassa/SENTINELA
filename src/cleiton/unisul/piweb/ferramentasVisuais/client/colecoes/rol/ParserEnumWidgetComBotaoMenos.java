package cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.rol;

import cleiton.unisul.piweb.ferramentasVisuais.client.inputviews.InputViewListBoxEnumeracoes;

public class ParserEnumWidgetComBotaoMenos <E extends Enum<E>> implements ParserForIsWidgets<E, WidgetComBotaoMenos<InputViewListBoxEnumeracoes<E>>> {	
	
	@Override
	public WidgetComBotaoMenos<InputViewListBoxEnumeracoes<E>> set(E input) {
		return new WidgetComBotaoMenos<InputViewListBoxEnumeracoes<E>> (
				new InputViewListBoxEnumeracoes<E>(input)
				);
	}

	@Override
	public void set(E input, WidgetComBotaoMenos<InputViewListBoxEnumeracoes<E>> target) {
		target=set(input);
	}

	@Override
	public E get(WidgetComBotaoMenos<InputViewListBoxEnumeracoes<E>> isWidget) {
		return isWidget.getWidgetParaExibir().getEnumSelecionada();
	}


}
