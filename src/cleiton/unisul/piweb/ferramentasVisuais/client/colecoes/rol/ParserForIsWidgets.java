package cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.rol;

import com.google.gwt.user.client.ui.IsWidget;

public interface ParserForIsWidgets <T extends Object, W extends IsWidget>{
	public W set(T input);
	public void set(T input, W target);
	public T get(W isWidget);
}
