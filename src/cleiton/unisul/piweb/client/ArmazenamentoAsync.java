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
import cleiton.unisul.piweb.shared.Usuario;

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

	void persistir(ClientePF obj,AsyncCallback<Boolean> callback);
	void persistir(ClientePJ obj,AsyncCallback<Boolean> callback);
	void persistir(Corrida obj,AsyncCallback<Boolean> callback);
	void persistir(CorridaAtendida obj,AsyncCallback<Boolean> callback);
	void persistir(CorridaCancelada obj,AsyncCallback<Boolean> callback);
	void persistir(CorridaMarcada obj,AsyncCallback<Boolean> callback);
	void persistir(Frota obj,AsyncCallback<Boolean> callback);
	void persistir(Motorista obj,AsyncCallback<Boolean> callback);

}
