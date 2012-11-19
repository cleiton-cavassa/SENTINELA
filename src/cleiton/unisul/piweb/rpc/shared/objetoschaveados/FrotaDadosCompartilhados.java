package cleiton.unisul.piweb.rpc.shared.objetoschaveados;

import java.util.ArrayList;


import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.acessorios.PadraoItemResumo;


@SuppressWarnings("serial")
@PersistenceCapable
public class FrotaDadosCompartilhados implements ObjetoChaveado {

	@Persistent
	ArrayList<ClientePF> clientesPF;
	
	@Persistent
	ArrayList<ClientePJ> clientesPJ;
	
	@Persistent
	PessoaJuridica dadosPessoaJuridica;

//	@PrimaryKey
//	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
//	private Object chave;

//	public Object getChave() {
//		return chave;
//	}

	public ArrayList<ClientePF> getClientesPF() {
		return clientesPF;
	}

	public ArrayList<ClientePJ> getClientesPJ() {
		return clientesPJ;
	}

	public PessoaJuridica getDadosPessoaJuridica() {
		return dadosPessoaJuridica;
	}

	@Override
 	public String getResumo(){
     	StringBuilder b=new StringBuilder();
     	
     	PadraoItemResumo p = PadraoItemResumo.get();
     	p.gerarItem(b, "Dados da Pessoa Juridica", dadosPessoaJuridica);
 		
 		return b.toString();
 	}

//	public void setChave(Object chave) {
//		this.chave = chave;
//	}

	public void setClientesPF(ArrayList<ClientePF> clientesPF) {
		this.clientesPF = clientesPF;
	}
	
	public void setClientesPJ(ArrayList<ClientePJ> clientesPJ) {
		this.clientesPJ = clientesPJ;
	}
	
	public void setDadosPessoaJuridica(PessoaJuridica dadosPessoaJuridica) {
		this.dadosPessoaJuridica = dadosPessoaJuridica;
	}
}
