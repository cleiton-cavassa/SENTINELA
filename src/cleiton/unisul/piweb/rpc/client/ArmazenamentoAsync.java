package cleiton.unisul.piweb.rpc.client;

import java.util.List;

import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.FrotaDadosCompartilhados;
import cleiton.unisul.piweb.rpc.shared.respostasdeconsulta.RespostaLoginUsuarioAdministrativo;
import cleiton.unisul.piweb.rpc.shared.respostasdeconsulta.RespostaPersistencia;

import com.google.gwt.user.client.rpc.AsyncCallback;



public interface ArmazenamentoAsync {
	<T extends ObjetoChaveado>void recuperar(T exemplo, String chavePai, AsyncCallback<List<T>> result);
	<T extends ObjetoChaveado> void recuperar(T exemplo, String chavePai, String nomeOuNroDocumento, AsyncCallback<List<T>> result);
	
	<T extends ObjetoChaveado> void persistir(T obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado, String chavePai, AsyncCallback<RespostaPersistencia> callback);

	<T extends ObjetoChaveado> void excluir(T obj, AsyncCallback<RespostaPersistencia> callback);
	
	void acharFrotas(AsyncCallback<RespostaLoginUsuarioAdministrativo> callback);
	
	void recuperarMeusDadosCompartilhados(String minhaChave, AsyncCallback<FrotaDadosCompartilhados> callback);
	void recuperarDadosParceirosForaDaRede(String minhaChave, AsyncCallback<List<FrotaDadosCompartilhados>> callback);
	
//	<T extends ObjetoChaveado> void pessoaPorCPF(T exemplo, long CPF, AsyncCallback<ParChaveDescricao> callback);

//	void criar(ClientePF objeto, String chavePai, AsyncCallback<RespostaPersistencia> callback);
//	void criar(ClientePJ objeto, String chavePai, AsyncCallback<RespostaPersistencia> callback);
//	void criar(CorridaSolicitada objeto, String chavePai, AsyncCallback<RespostaPersistencia> callback);
//	/**
//	 * Este método deve ser implementado por uma transacão
//	 * @param objeto
//	 * @param chavePai
//	 */
//	void criar(CorridaCancelada objeto, String chavePai, AsyncCallback<RespostaPersistencia> callback);
//	/**
//	 * Este método deve ser implementado por uma transacão
//	 * @param objeto 
//	 * @param chavePai
//	 */
//	void criar(CorridaFinalizada objeto, String chavePai, AsyncCallback<RespostaPersistencia> callback);
//	void criar(Motorista objeto, String chavePai, AsyncCallback<RespostaPersistencia> callback);
//	
//	/**
//	 * Este método deve ser implementado por uma transacão
//	 * @param objeto Convite que será criado
//	 * @param chavePai chave da frota 
//	 */
//	void criar(ConviteEnviado objeto, String chavePai, AsyncCallback<Boolean> callback);
	
	void criar(ObjetoChaveado objeto, String chavePai, AsyncCallback<RespostaPersistencia> callback);	

}
