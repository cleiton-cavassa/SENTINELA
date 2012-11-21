package cleiton.unisul.piweb.ferramentasVisuais.client.colecoes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.eventoExclusao.ExcludeMePleaseEvent;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.eventoExclusao.ExcludeMePleaseHandler;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.eventoExclusao.HasExcludeMePleaseHandlers;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.exibidor.InputView;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.rol.CriadorWidgets;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.rol.ParserForIsWidgets;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Rol<T extends HasExcludeMePleaseHandlers, Ob extends Object> extends Composite implements InputView<Collection<Ob>> {
	
	
	private final ArrayList<T> widgets;
	private final Button botaoMais;
	private final VerticalPanel painelWidgets;
	private final ParserForIsWidgets<Ob, T>parser; 
	
	public Collection<Ob> getInput(){
		if(parser==null){
			return null;
		}
		
		ArrayList<Ob> result = new ArrayList<Ob>();
		
		for(T wid: widgets){
			result.add(parser.get(wid));
		}
		return result;
	}
	
	public boolean setInput(Collection<Ob> objetos){
		if ((objetos==null)||(parser==null)){
			return false;
		}
		
		widgets.clear();
		painelWidgets.clear();
		
		T buffer;
		for(Ob objeto: objetos){
			buffer= parser.set(objeto);
			if (buffer!=null){
				widgets.add(buffer);
				painelWidgets.add(buffer);				
			}
		}
		return true;
	}
	
	public Rol(CriadorWidgets<T> criador, ParserForIsWidgets<Ob, T> parser){
		widgets = new ArrayList<T>();
		botaoMais = new BotaoMais(criador);
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
	
	private class BotaoMais extends Button implements ClickHandler, ExcludeMePleaseHandler{
		final CriadorWidgets<T> criador;
		
		private BotaoMais(CriadorWidgets<T> criador){
			super("+");
			this.setStyleName("botaoLogout");
			this.criador=criador;
			this.addClickHandler(this);
		}
		@Override
		public void onClick(ClickEvent event) {
			T widget = criador.criarWidget();
			
			widget.addExcludeMeHandler(this);
//			FlowPanel f= new FlowPanel();
//				f.add(new BotaoMenos(f));
//				f.add(widget);
//			painelWidgets.add(f);
			painelWidgets.add(widget);
			widgets.add(widget);
		}
		@Override
		public void onExcludeMePlease(ExcludeMePleaseEvent event) {
			widgets.remove(event.getMe());
			painelWidgets.remove(event.getMe());
		}
	};
	
}
