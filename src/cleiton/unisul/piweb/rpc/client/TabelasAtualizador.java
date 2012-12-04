package cleiton.unisul.piweb.rpc.client;

import java.util.List;

import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.view.client.ListDataProvider;

public class TabelasAtualizador<Ob extends ObjetoChaveado> {
	
	private ListDataProvider<Ob> dataProvider;
	private String chaveFrota;
	
	public TabelasAtualizador(ListDataProvider<Ob> dataProvider, String chaveFrota){
		this.dataProvider = dataProvider;
		this.chaveFrota= chaveFrota;
	}
	
	public boolean atualizar(Ob exemplo, ListDataProvider<Ob> dataProvider){
//		Window.alert("AAAAAA");
		
		if(exemplo==null){
			return false;
		}
		ServicoArmazenamento.getArmazenamento().recuperar(exemplo, chaveFrota, new CallbackAtualizarTabela());
		return true;
	}
	
	private class CallbackAtualizarTabela implements AsyncCallback<List<Ob>>{
		
		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Falha ao atualizar tabela:\n"+caught.getLocalizedMessage()+"\n"+caught.getMessage());
			caught.printStackTrace();			
		}

		@Override
		public void onSuccess(List<Ob> result) {
			dataProvider.setList(result);			
		}
	}
}
