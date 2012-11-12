package cleiton.unisul.piweb.client.persistencia;

import cleiton.unisul.piweb.shared.ObjetoChaveado;

public interface TelaPersistencia <T extends ObjetoChaveado>{
	public void salvar(T objeto);
	public T getObjeto();
	public void setObjeto(T objeto);

}
