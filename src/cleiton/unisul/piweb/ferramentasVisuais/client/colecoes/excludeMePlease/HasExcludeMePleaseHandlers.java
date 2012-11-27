package cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.excludeMePlease;

import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.IsFormulario;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

public interface HasExcludeMePleaseHandlers extends HasHandlers, IsFormulario {
	public HandlerRegistration addExcludeMeHandler(ExcludeMePleaseHandler excluidor);
}
