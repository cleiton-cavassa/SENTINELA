
package cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.rol;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.eventoExclusao.ExcludeMePleaseEvent;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.eventoExclusao.ExcludeMePleaseHandler;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.eventoExclusao.HasExcludeMePleaseHandlers;



public class WidgetComBotaoMenos<T extends IsWidget> implements HasExcludeMePleaseHandlers{
	
	private ExcludeMePleaseHandler e=null;	
	private FlowPanel f=new FlowPanel();
	private BotaoMenos b=new BotaoMenos();
	private final WidgetComBotaoMenos<T> eu=this;
	T widgetParaExibir;
	

	public WidgetComBotaoMenos(T widgetParaExibir){
		f.add(b);
		f.add(widgetParaExibir);
		this.widgetParaExibir=widgetParaExibir;
	}
	
	public T getWidgetParaExibir(){
		return widgetParaExibir;
	}
	
	@Override
	public void fireEvent(GwtEvent<?> event) {}

	@Override
	public HandlerRegistration addExcludeMeHandler(
			ExcludeMePleaseHandler excluidor) {
		e=excluidor;
		return null;
	}

	@Override
	public Widget asWidget() {
		// TODO Auto-generated method stub
		return f;
	}
	
	private class BotaoMenos extends Button implements ClickHandler{

		BotaoMenos(){
			super("-");
			this.setStyleName("botaoLogout");
			this.addClickHandler(this);
		}
		@Override
		public void onClick(ClickEvent event) {
			e.onExcludeMePlease(new ExcludeMePleaseEvent(){
				@Override
				public HasExcludeMePleaseHandlers getMe() {
					return eu;
				}
			});
		}	
	}





}