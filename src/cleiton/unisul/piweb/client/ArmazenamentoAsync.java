package cleiton.unisul.piweb.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import cleiton.unisul.piweb.shared.ClientePF;
import cleiton.unisul.piweb.shared.ClientePJ;
import cleiton.unisul.piweb.shared.Corrida;
import cleiton.unisul.piweb.shared.CorridaAtendida;
import cleiton.unisul.piweb.shared.CorridaCancelada;
import cleiton.unisul.piweb.shared.CorridaMarcada;
import cleiton.unisul.piweb.shared.Expediente;
import cleiton.unisul.piweb.shared.Frota;
import cleiton.unisul.piweb.shared.Motorista;
import cleiton.unisul.piweb.shared.ClientesPFePJ;
import cleiton.unisul.piweb.shared.Usuario;
import cleiton.unisul.piweb.shared.ObjetoChaveado.RespostaPersistencia;

public interface ArmazenamentoAsync {
	void recuperar(ClientePJ exemplo, AsyncCallback<List<ClientePJ>> result);
	void recuperar(ClientePF exemplo, AsyncCallback<List<ClientePF>> result);
	void recuperar(Corrida exemplo, AsyncCallback<List<Corrida>> result);
	void recuperar(CorridaAtendida exemplo, AsyncCallback<List<CorridaAtendida>> result);
	void recuperar(CorridaCancelada exemplo, AsyncCallback<List<CorridaCancelada>> result);
	void recuperar(CorridaMarcada exemplo, AsyncCallback<List<CorridaMarcada>> result);
	void recuperar(Expediente exemplo, AsyncCallback<List<Expediente>> result);
	void recuperar(Frota exemplo, AsyncCallback<List<Frota>> result);
	void recuperar(Motorista exemplo, AsyncCallback<List<Motorista>> result);
	void recuperar(Usuario exemplo, AsyncCallback<List<Usuario>> result);
	void recuperar(ClientesPFePJ exemplo, AsyncCallback<List<ClientesPFePJ>> result);

	void persistir(ClientePF obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado, AsyncCallback<RespostaPersistencia> callback);
	void persistir(ClientePJ obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado, AsyncCallback<RespostaPersistencia> callback);
	void persistir(Corrida obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado, AsyncCallback<RespostaPersistencia> callback);
	void persistir(CorridaAtendida obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado, AsyncCallback<RespostaPersistencia> callback);
	void persistir(CorridaCancelada obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado, AsyncCallback<RespostaPersistencia> callback);
	void persistir(CorridaMarcada obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado, AsyncCallback<RespostaPersistencia> callback);
	void persistir(Frota obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado, AsyncCallback<RespostaPersistencia> callback);
	void persistir(Motorista obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado, AsyncCallback<RespostaPersistencia> callback);


}
