package cleiton.unisul.piweb.client.classesabstratas;

import cleiton.unisul.piweb.shared.ObjetoChaveado;

public interface TelaNovoRegistro <T extends ObjetoChaveado>{
	public void salvar(T objeto);
	public void setTelaBloqueada(boolean telaBloqueada);
	public boolean isTelaBloqueada();
	public T objeto();

}
