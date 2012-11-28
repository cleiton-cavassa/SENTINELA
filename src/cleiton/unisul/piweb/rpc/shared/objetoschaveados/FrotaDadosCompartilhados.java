package cleiton.unisul.piweb.rpc.shared.objetoschaveados;

import java.util.ArrayList;
import java.util.Collection;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.FetchGroup;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.acessorios.PadraoItemResumo;


@PersistenceCapable(detachable="true")
@FetchGroup(name="grupo",members={
		@Persistent(name="dadosPessoaJuridica")
		})
public class FrotaDadosCompartilhados implements ObjetoChaveado {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2567723009307417897L;

	public FrotaDadosCompartilhados(){}
	
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
		if(clientesPF==null){
			setClientesPF(new ArrayList<ClientePF>());
		}
		return clientesPF;
	}

	public void setClientesPF(Collection<ClientePF> clientesPF) {
		this.clientesPF = clientesPF;
	}

	public Collection<ClientePJ> getClientesPJ() {
		if(clientesPJ==null){
			setClientesPJ(new ArrayList<ClientePJ>());
		}
		return clientesPJ;
	}

	public void setClientesPJ(Collection<ClientePJ> clientesPJ) {
		this.clientesPJ = clientesPJ;
	}

	public PessoaJuridica getDadosPessoaJuridica() {
		if(dadosPessoaJuridica==null){
			setDadosPessoaJuridica(new PessoaJuridica());
		}
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
