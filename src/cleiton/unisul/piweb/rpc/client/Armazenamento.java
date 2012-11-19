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
	
	<T extends ObjetoChaveado> RespostaPersistencia persistir(T obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado);
	<T extends ObjetoChaveado> List<T> recuperar(T exemplo) throws Exception;

//	RespostaPersistencia persistir(ClientePF obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado);
//	RespostaPersistencia persistir(ClientePJ obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado);
//	RespostaPersistencia persistir(Corrida obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado);
//	RespostaPersistencia persistir(CorridaAtendida obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado);
//	RespostaPersistencia persistir(CorridaCancelada obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado);
//	RespostaPersistencia persistir(CorridaAgendada obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado);
//	RespostaPersistencia persistir(FrotaModeloAntigo cliente,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado);
//	RespostaPersistencia persistir(Motorista obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado);
//	
//	RespostaPersistencia persistir(ObjetoChaveado obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado);

//	List<ClientePF> recuperar(ClientePF exemplo) throws Exception;
//	List<ClientePJ> recuperar(ClientePJ exemplo) throws Exception;
//	List<Corrida> recuperar(Corrida exemplo) throws Exception;
//	List<CorridaAtendida> recuperar(CorridaAtendida exemplo) throws Exception;
//	List<CorridaCancelada> recuperar(CorridaCancelada exemplo) throws Exception;
//	List<CorridaAgendada> recuperar(CorridaAgendada exemplo) throws Exception;
//	List<Expediente> recuperar(Expediente exemplo) throws Exception;
//	List<FrotaModeloAntigo> recuperar(FrotaModeloAntigo exemplo) throws Exception;
//	List<Motorista> recuperar(Motorista exemplo) throws Exception;
//	List<Usuario> recuperar(Usuario exemplo) throws Exception;	
//	List<ClientesPFePJ> montarLista(ClientesPFePJ exemplo) throws Exception;

}
