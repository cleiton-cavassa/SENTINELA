
package cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.excludeMePlease.impl;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.excludeMePlease.ExcludeMePleaseEvent;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.excludeMePlease.ExcludeMePleaseHandler;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.excludeMePlease.HasExcludeMePleaseHandlers;
import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.IsFormulario;
import cleiton.unisul.piweb.ferramentasVisuais.client.util.FecharPopUpEventHandler;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

public class WidgetComBotaoMenos<T extends IsFormulario> implements HasExcludeMePleaseHandlers{
	
	@Override
	public String getTitulo(){
		return null;
	}
	
	private ExcludeMePleaseHandler e=null;	
	private FlowPanel painelBase=new FlowPanel();
	private BotaoMenos botaoMenos=new BotaoMenos();
	private final WidgetComBotaoMenos<T> eu=this;
	T formularioParaExibir;
	

	public WidgetComBotaoMenos(T widgetParaExibir){
		arrumarPainelBase(painelBase, widgetParaExibir, botaoMenos);
		this.formularioParaExibir=widgetParaExibir;
	}
	
	protected void arrumarPainelBase(FlowPanel painelBase, T widgetParaExibir, Widget botaoMenos){
		painelBase.add(botaoMenos);
		painelBase.add(widgetParaExibir);

	}
	
	public T getWidgetParaExibir(){
		return formularioParaExibir;
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
		return painelBase;
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

	@Override
	public String validarDados() {
		return formularioParaExibir.validarDados();
	}

	@Override
	public boolean setFecharHandler(FecharPopUpEventHandler f) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void fechar() {
		// TODO Auto-generated method stub
		
	}





}