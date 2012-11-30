package cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl;

import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputView;
import cleiton.unisul.piweb.ferramentasVisuais.client.util.FecharPopUpEventHandler;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.ListBox;

public class InputViewListBoxEnumeracoes <T extends Enum<T>> extends ListBox implements InputView<T>{
		
	@Override
	public String getTitulo(){
		return "campo para enum";
	}
	
	private T exemplo;
	
//	public InputViewListBoxEnumeracoes(List<T> valores){
	public InputViewListBoxEnumeracoes(T exemplo){
		this(exemplo, true);
//		for(T valorLista: valores){
//			this.addItem(valorLista.name());
//		}

	}
	
	public InputViewListBoxEnumeracoes(T exemplo, Boolean selecaoInicial){
		this.exemplo=exemplo;
		for(T valorLista: exemplo.getDeclaringClass().getEnumConstants()){
			this.addItem(valorLista.name());
		}
		if (selecaoInicial){
			this.setEnumSelecionada(exemplo);			
		}
	}
	
	@SuppressWarnings("unchecked")
	public T getEnumSelecionada(){
//		if(exemplo.getClass()==null){
//			Window.alert("classe nula");
//		}
//		if(		this.getItemText(
//				this.getSelectedIndex())==null){
//			Window.alert("Item nulo:\n"+this.getSelectedIndex());
//		}
		return (T) Enum.valueOf(
				exemplo.getClass(), 
				this.getItemText(
						this.getSelectedIndex()));
	}
	
	public Boolean setEnumSelecionada(T selecao){
		
		if (selecao==null){
			return false;
		}
		
		for(int i=0; i<this.getItemCount();i++){
			if (this.getItemText(i).equals(selecao.name())){
				this.setSelectedIndex(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean setInput(T input) {
		return this.setEnumSelecionada(input);
	}

	@Override
	public T getInput() {
		return this.getEnumSelecionada();
	}

	@Override
	public String validarDados() {
		return null;
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
