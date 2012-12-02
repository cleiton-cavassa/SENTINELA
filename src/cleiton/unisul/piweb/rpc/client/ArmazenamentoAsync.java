package cleiton.unisul.piweb.rpc.client;

import java.util.List;

import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;
import cleiton.unisul.piweb.rpc.shared.RespostaPersistencia;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.Frota;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.FrotaECredenciais;

import com.google.gwt.user.client.rpc.AsyncCallback;



public interface ArmazenamentoAsync {
	<T extends ObjetoChaveado>void recuperar(T exemplo, AsyncCallback<List<T>> result);
	<T extends ObjetoChaveado> void recuperar(T exemplo, String nomeOuNroDocumento, AsyncCallback<List<T>> result);
	
	<T extends ObjetoChaveado> void persistir(T obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado, AsyncCallback<RespostaPersistencia> callback);

	<T extends ObjetoChaveado> void excluir(T obj, AsyncCallback<RespostaPersistencia> callback);
	
	void acharFrotas(AsyncCallback<List<FrotaECredenciais>> callback);
	

}
