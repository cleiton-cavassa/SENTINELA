package cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.rol;

import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.eventoExclusao.HasExcludeMePleaseHandlers;


public interface CriadorWidgets <U extends HasExcludeMePleaseHandlers>{
	public abstract U criarWidget();
}

