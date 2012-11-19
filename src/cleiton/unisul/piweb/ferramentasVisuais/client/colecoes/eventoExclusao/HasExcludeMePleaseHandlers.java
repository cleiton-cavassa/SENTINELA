package cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.eventoExclusao;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.user.client.ui.IsWidget;

public interface HasExcludeMePleaseHandlers extends HasHandlers, IsWidget {
	public HandlerRegistration addExcludeMeHandler(ExcludeMePleaseHandler excluidor);
}
