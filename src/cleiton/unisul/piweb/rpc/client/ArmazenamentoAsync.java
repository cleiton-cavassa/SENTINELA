package cleiton.unisul.piweb.rpc.client;

import java.util.List;



import com.google.gwt.user.client.rpc.AsyncCallback;

import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;
import cleiton.unisul.piweb.rpc.shared.RespostaPersistencia;

//import cleiton.unisul.piweb.shared.ClientePF;
//import cleiton.unisul.piweb.shared.ClientePJ;
//import cleiton.unisul.piweb.shared.Corrida;
//import cleiton.unisul.piweb.shared.CorridaAtendida;
//import cleiton.unisul.piweb.shared.CorridaCancelada;
//import cleiton.unisul.piweb.shared.CorridaMarcada;
//import cleiton.unisul.piweb.shared.Expediente;
//import cleiton.unisul.piweb.shared.Frota;
//import cleiton.unisul.piweb.shared.Motorista;
//import cleiton.unisul.piweb.shared.Usuario;


public interface ArmazenamentoAsync {
	<T extends ObjetoChaveado>void recuperar(T exemplo, AsyncCallback<List<T>> result);
//	void montarLista(ClientesPFePJ exemplo, AsyncCallback<List<ClientesPFePJ>> result) throws Exception;
//	void recuperar(ClientePJ exemplo, AsyncCallback<List<ClientePJ>> result);
//	void recuperar(ClientePF exemplo, AsyncCallback<List<ClientePF>> result);
//	void recuperar(Corrida exemplo, AsyncCallback<List<Corrida>> result);
//	void recuperar(CorridaAtendida exemplo, AsyncCallback<List<CorridaAtendida>> result);
//	void recuperar(CorridaCancelada exemplo, AsyncCallback<List<CorridaCancelada>> result);
//	void recuperar(CorridaAgendada exemplo, AsyncCallback<List<CorridaAgendada>> result);
//	void recuperar(Expediente exemplo, AsyncCallback<List<Expediente>> result);
//	void recuperar(FrotaModeloAntigo exemplo, AsyncCallback<List<FrotaModeloAntigo>> result);
//	void recuperar(Motorista exemplo, AsyncCallback<List<Motorista>> result);
//	void recuperar(Usuario exemplo, AsyncCallback<List<Usuario>> result);
//	void recuperar(ClientesPFePJ exemplo, AsyncCallback<List<ClientesPFePJ>> result);
	

	<T extends ObjetoChaveado> void persistir(T obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado, AsyncCallback<RespostaPersistencia> callback);
//	void persistir(ClientePF obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado, AsyncCallback<RespostaPersistencia> callback);
//	void persistir(ClientePJ obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado, AsyncCallback<RespostaPersistencia> callback);
//	void persistir(Corrida obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado, AsyncCallback<RespostaPersistencia> callback);
//	void persistir(CorridaAtendida obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado, AsyncCallback<RespostaPersistencia> callback);
//	void persistir(CorridaCancelada obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado, AsyncCallback<RespostaPersistencia> callback);
//	void persistir(CorridaAgendada obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado, AsyncCallback<RespostaPersistencia> callback);
//	void persistir(FrotaModeloAntigo obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado, AsyncCallback<RespostaPersistencia> callback);
//	void persistir(Motorista obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado, AsyncCallback<RespostaPersistencia> callback);
//
//	void persistir(ObjetoChaveado obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado, AsyncCallback<RespostaPersistencia> callback);
}
