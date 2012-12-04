package cleiton.unisul.piweb.rpc.client;

import java.util.List;

import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.FrotaDadosCompartilhados;
import cleiton.unisul.piweb.rpc.shared.respostasdeconsulta.RespostaLoginUsuarioAdministrativo;
import cleiton.unisul.piweb.rpc.shared.respostasdeconsulta.RespostaPersistencia;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("armazenamento")
public interface Armazenamento extends RemoteService {
	
	<T extends ObjetoChaveado> RespostaPersistencia persistir
	(T obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado, String chavePai)
	throws Exception;
	
	<T extends ObjetoChaveado> List<T> recuperar(T exemplo, String chavePai) throws Exception;
	<T extends ObjetoChaveado> List<T> recuperar(T exemplo, String chavePai, String nomeOuNroDocumento) throws Exception;

	<T extends ObjetoChaveado> RespostaPersistencia excluir(T obj);
	
	RespostaLoginUsuarioAdministrativo acharFrotas();
	
	FrotaDadosCompartilhados recuperarMeusDadosCompartilhados(String minhaChave);
	List<FrotaDadosCompartilhados> recuperarDadosParceirosForaDaRede(String minhaChave);
	
	
//	<T extends ObjetoChaveado> ParChaveDescricao pessoaPorCPF(T exemplo, long CPF);
	

	
//	RespostaPersistencia criar(ClientePF objeto, String chavePai);
//	RespostaPersistencia criar(ClientePJ objeto, String chavePai);
//	RespostaPersistencia criar(CorridaSolicitada objeto, String chavePai);
//	/**
//	 * Este método deve ser implementado por uma transacão
//	 * @param objeto
//	 * @param chavePai
//	 * @return <i>true</i> se a transação for bem-sucedida, e <i>false</i> caso contrário. 
//	 */
//	RespostaPersistencia criar(CorridaCancelada objeto, String chavePai);
//	/**
//	 * Este método deve ser implementado por uma transacão
//	 * @param objeto 
//	 * @param chavePai
//	 * @return <i>true</i> se a transação for bem-sucedida, e <i>false</i> caso contrário. 
//	 */
//	RespostaPersistencia criar(CorridaFinalizada objeto, String chavePai);
//	RespostaPersistencia criar(Motorista objeto, String chavePai);
//	/**
//	 * Este método deve ser implementado por uma transacão
//	 * @param objeto Convite que será criado
//	 * @param chavePai chave da frota
//	 * @return <i>true</i> se a transação for bem-sucedida, e <i>false</i> caso contrário. 
//	 */
//	boolean criar(ConviteEnviado objeto, String chavePai);

	RespostaPersistencia criar(ObjetoChaveado objeto, String chavePai);

}
