package cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.rol;

import cleiton.unisul.piweb.ferramentasVisuais.client.enums.ListBoxEnumeracoes;

public class ParserEnumWidgetComBotaoMenos <E extends Enum<E>> implements ParserForIsWidgets<E, WidgetComBotaoMenos<ListBoxEnumeracoes<E>>> {	
	
	@Override
	public WidgetComBotaoMenos<ListBoxEnumeracoes<E>> set(E input) {
		return new WidgetComBotaoMenos<ListBoxEnumeracoes<E>> (
				new ListBoxEnumeracoes<E>(input)
				);
	}

	@Override
	public void set(E input, WidgetComBotaoMenos<ListBoxEnumeracoes<E>> target) {
		target=set(input);
	}

	@Override
	public E get(WidgetComBotaoMenos<ListBoxEnumeracoes<E>> isWidget) {
		return isWidget.getWidgetParaExibir().getEnumSelecionada();
	}


}
