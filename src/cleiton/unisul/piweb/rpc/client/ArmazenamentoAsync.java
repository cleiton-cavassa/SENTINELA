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
	
	<T extends ObjetoChaveado> void persistir(T obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado, AsyncCallback<RespostaPersistencia> callback);

	<T extends ObjetoChaveado> void excluir(T obj, AsyncCallback<RespostaPersistencia> callback);
}
