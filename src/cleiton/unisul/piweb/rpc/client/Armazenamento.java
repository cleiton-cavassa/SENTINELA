package cleiton.unisul.piweb.rpc.client;

import java.util.List;



import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;
import cleiton.unisul.piweb.rpc.shared.RespostaPersistencia;
//import cleiton.unisul.piweb.rpc.shared.objetoschaveados.antigos.ClientesPFePJ;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("armazenamento")
public interface Armazenamento extends RemoteService {
	
	<T extends ObjetoChaveado> RespostaPersistencia persistir
	(T obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado)
	throws Exception;
	
	<T extends ObjetoChaveado> List<T> recuperar(T exemplo) throws Exception;

	<T extends ObjetoChaveado> RespostaPersistencia excluir(T obj);

}
