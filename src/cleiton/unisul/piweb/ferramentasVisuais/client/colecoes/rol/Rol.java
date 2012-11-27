package cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.rol;

import java.util.ArrayList;

import java.util.Collection;

import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.excludeMePlease.ExcludeMePleaseEvent;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.excludeMePlease.ExcludeMePleaseHandler;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.excludeMePlease.HasExcludeMePleaseHandlers;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputView;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Rol<T extends HasExcludeMePleaseHandlers, Ob extends Object> extends Composite implements InputView<Collection<Ob>> {
	
	@Override
	public String getTitulo(){
		return null;
	}
	
	private final ArrayList<T> formularios;
	private final Button botaoMais;
	private final VerticalPanel painelWidgets;
	private final Parser<Ob, T>parser; 
	

//	public Rol(CriadorWidgets<T> criador, Parser<Ob, T> parser){
	public Rol(Parser<Ob, T> parser){
		formularios = new ArrayList<T>();
//		botaoMais = new BotaoMais(criador);
		botaoMais = new BotaoMais();
		painelWidgets= new VerticalPanel();
		this.parser=parser;
		
		DecoratorPanel painel= new DecoratorPanel();
		initWidget(painel);
		painel.setWidth("");
		
		VerticalPanel painelIntermediario = new VerticalPanel();
		painel.add(painelIntermediario);
		
		painelIntermediario.add(painelWidgets);
		painelIntermediario.add(botaoMais);
		
		((ClickHandler) botaoMais).onClick(null);

	}
	
	public Collection<Ob> getInput(){
		if(parser==null){
			return null;
		}
		
		ArrayList<Ob> result = new ArrayList<Ob>();
		
		for(T wid: formularios){
			result.add(parser.get(wid));
		}
		return result;
	}
	
	public boolean setInput(Collection<Ob> objetos){
		if ((objetos==null)||(parser==null)){
			return false;
		}
		
		formularios.clear();
		painelWidgets.clear();
		
		T buffer;
		for(Ob objeto: objetos){
			buffer= parser.set(objeto);
			if (buffer!=null){
				formularios.add(buffer);
				painelWidgets.add(buffer);				
			}
		}
		return true;
	}
	
	
	private class BotaoMais extends Button implements ClickHandler, ExcludeMePleaseHandler{
//		final CriadorWidgets<T> criador;
		
//		private BotaoMais(CriadorWidgets<T> criador){
		private BotaoMais(){
			super("+");
			this.setStyleName("botaoLogout");
//			this.criador=criador;
			this.addClickHandler(this);
		}
		@Override
		public void onClick(ClickEvent event) {
//			T widget = criador.criarWidget();
			T widget = parser.set();
			
			widget.addExcludeMeHandler(this);
//			FlowPanel flow= new FlowPanel();
//				flow.add(new BotaoMenos(flow));
//				flow.add(widget);
//			painelWidgets.add(flow);
			painelWidgets.add(widget);
			formularios.add(widget);
		}
		@Override
		public void onExcludeMePlease(ExcludeMePleaseEvent event) {
			formularios.remove(event.getMe());
			painelWidgets.remove(event.getMe());
		}
	};
//	public interface CriadorWidgets <U extends HasExcludeMePleaseHandlers>{
//		public abstract U criarWidget();
//	}
	
	public interface Parser <T extends Object, W extends IsWidget>{
		public W set();
		public W set(T input);
		public void set(T input, W target);
		public T get(W isWidget);
	}
	@Override
	public String validarDados() {
		StringBuilder obs = new StringBuilder();
		
		String buf;
		for (HasExcludeMePleaseHandlers a: formularios){
			buf = a.validarDados();
			if (buf!=null){
				obs.append(buf);
				obs.append("\n");
			}
		}
		if(obs.length()>0){
			return obs.toString();
		}else{
			return null;
		}
	}
}
