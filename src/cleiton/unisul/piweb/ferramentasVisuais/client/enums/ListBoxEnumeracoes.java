package cleiton.unisul.piweb.ferramentasVisuais.client.enums;



import com.google.gwt.user.client.ui.ListBox;

public class ListBoxEnumeracoes <T extends Enum<T>> extends ListBox {
	
	T exemplo;
	
//	public ListBoxEnumeracoes(List<T> valores){
	public ListBoxEnumeracoes(T exemplo){
		this(exemplo, true);
//		for(T valorLista: valores){
//			this.addItem(valorLista.name());
//		}

	}
	
	public ListBoxEnumeracoes(T exemplo, Boolean selecaoInicial){
		for(T valorLista: exemplo.getDeclaringClass().getEnumConstants()){
			this.addItem(valorLista.name());
		}
		if (selecaoInicial){
			this.setEnumSelecionada(exemplo);			
		}
	}
	
	@SuppressWarnings("unchecked")
	public T getEnumSelecionada(){
		return (T) Enum.valueOf(exemplo.getClass(), this.getItemText(this.getSelectedIndex()));
	}
	
	public Boolean setEnumSelecionada(T selecao){
		for(int i=0; i<this.getItemCount();i++){
			if (this.getItemText(i).equals(selecao.name())){
				this.setSelectedIndex(i);
				return true;
			}
		}
		return false;
	}
}
