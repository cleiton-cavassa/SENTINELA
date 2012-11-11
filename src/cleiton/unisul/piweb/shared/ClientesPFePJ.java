package cleiton.unisul.piweb.shared;

import java.io.Serializable;

public class ClientesPFePJ implements Serializable{
	private ClientePF clientePF;
	private ClientePJ clientePJ;
	private boolean PJexisteNaBaseDeDados=true;
	public ClientePF getClientePF() {
		return clientePF;
	}
	public void setClientePF(ClientePF clientePF) {
		this.clientePF = clientePF;
	}
	public ClientePJ getClientePJ() {
		return clientePJ;
	}
	public void setClientePJ(ClientePJ clientePJ) {
		this.clientePJ = clientePJ;
	}
	public boolean isPJexisteNaBaseDeDados() {
		return PJexisteNaBaseDeDados;
	}
	public void setPJexisteNaBaseDeDados(boolean pJexisteNaBaseDeDados) {
		PJexisteNaBaseDeDados = pJexisteNaBaseDeDados;
	}

	
}
