package cleiton.unisul.piweb.rpc.shared;

import java.io.Serializable;


public interface ObjetoChaveado extends Serializable, Cloneable {
	
	String getChave();
	void setChave(String chave);
	String getResumo();
}
