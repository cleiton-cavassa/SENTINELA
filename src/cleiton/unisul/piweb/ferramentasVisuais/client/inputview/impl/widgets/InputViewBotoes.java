package cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.widgets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputView;
import cleiton.unisul.piweb.ferramentasVisuais.client.util.FecharPopUpEventHandler;

public class InputViewBotoes <Ob extends Object> implements InputView<List<Ob>>{

	private final HashMap<Button, Ob> mapa=new HashMap<Button, Ob>();
	private final VerticalPanel raiz = new VerticalPanel();

	public InputViewBotoes(){}
	
	public InputViewBotoes(List<Ob> textos){
		this();
		this.setInput(textos);
	}
	
	@Override
	public String validarDados() {
		return null;
	}

	@Override
	public String getTitulo() {
		return "escolha a credencial desejada";
	}

	
	private FecharPopUpEventHandler f;
	@Override
	public boolean setFecharHandler(FecharPopUpEventHandler f) {
		this.f=f;
		return true;
	}

	@Override
	public void fechar() {
		f.fecharPopUp();
	}

	@Override
	public Widget asWidget() {
		return raiz;
	}

	@Override
	public boolean setInput(List<Ob> input) {
		Button buf;
		
		mapa.clear();
		
		raiz.clear();
			for(Ob s: input){
				buf=new Button(s.toString());
				buf.addClickHandler(new inn(s));
				raiz.add(buf);
				mapa.put(buf, s);
//				botoes.add(buf);
			}
		return false;
	}

	@Override
	public List<Ob> getInput() {
		ArrayList<Ob> result = new ArrayList<Ob>();
		result.addAll(mapa.values());
		return result;
	}
	
	
	
	
	private class inn implements ClickHandler{
		private Ob objeto;
		
		public inn(Ob objeto){
			this.objeto = objeto;
		}
		
		@Override
		public void onClick(ClickEvent event) {
			InputViewBotoes.this.onClick(event, objeto);
		}
	}
	
	
	
	public void onClick(ClickEvent evento, Ob objeto) {
		for(PersonalClickHandler<Ob> c : clickHandlers){
			c.onClick(new ObEevento<Ob>(evento, objeto));
		}
	}
	
	
	
	
	
	private LinkedList<PersonalClickHandler<Ob>> clickHandlers=new LinkedList<PersonalClickHandler<Ob>>();
	public void addButtonClickHandler(PersonalClickHandler<Ob> c){
		clickHandlers.add(c);
	}

	public interface PersonalClickHandler <T extends Object>{
		void onClick(ObEevento<T> origem);
	}
	
	public static class ObEevento<T extends Object>{
		private ClickEvent evento;
		private T objeto;
		public ClickEvent getEvento() {
			return evento;
		}
		public ObEevento(ClickEvent evento, T objeto) {
			super();
			this.evento = evento;
			this.objeto = objeto;
		}
		public void setEvento(ClickEvent evento) {
			this.evento = evento;
		}
		public T getObjeto() {
			return objeto;
		}
		public void setObjeto(T objeto) {
			this.objeto = objeto;
		}
		
	}
}
