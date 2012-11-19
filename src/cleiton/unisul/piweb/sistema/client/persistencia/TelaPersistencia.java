package cleiton.unisul.piweb.sistema.client.persistencia;

import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;

public interface TelaPersistencia <T extends ObjetoChaveado>{
	public void salvar(T objeto);
	public T getObjeto();
	public void setObjeto(T objeto);

}
