package cleiton.unisul.piweb.rpc.shared.objetoschaveados;

import java.util.Collection;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.acessorios.PadraoItemResumo;


@SuppressWarnings("serial")
@PersistenceCapable
public class FrotaDadosCompartilhados implements ObjetoChaveado {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
	private String chave;
	
	@Persistent
	Collection<ClientePF> clientesPF;
	
	@Persistent
	Collection<ClientePJ> clientesPJ;
	
	@Persistent
	PessoaJuridica dadosPessoaJuridica;

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public Collection<ClientePF> getClientesPF() {
		return clientesPF;
	}

	public void setClientesPF(Collection<ClientePF> clientesPF) {
		this.clientesPF = clientesPF;
	}

	public Collection<ClientePJ> getClientesPJ() {
		return clientesPJ;
	}

	public void setClientesPJ(Collection<ClientePJ> clientesPJ) {
		this.clientesPJ = clientesPJ;
	}

	public PessoaJuridica getDadosPessoaJuridica() {
		return dadosPessoaJuridica;
	}

	public void setDadosPessoaJuridica(PessoaJuridica dadosPessoaJuridica) {
		this.dadosPessoaJuridica = dadosPessoaJuridica;
	}

	@Override
 	public String getResumo(){
     	StringBuilder b=new StringBuilder();
     	
     	PadraoItemResumo p = PadraoItemResumo.get();
     	p.gerarItem(b, "Dados da Pessoa Juridica", dadosPessoaJuridica);
 		
 		return b.toString();
 	}
}
