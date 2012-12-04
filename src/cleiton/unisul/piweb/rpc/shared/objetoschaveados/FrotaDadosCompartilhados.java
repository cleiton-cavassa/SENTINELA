package cleiton.unisul.piweb.rpc.shared.objetoschaveados;

import java.util.ArrayList;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.FetchGroup;
import javax.jdo.annotations.FetchGroups;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.acessorios.PadraoItemResumo;


@PersistenceCapable(detachable="true")

@FetchGroups({
@FetchGroup(name="grupo",members={@Persistent(name="dadosPessoaJuridica")})
,
@FetchGroup(name="dadosCompartilhados",members={@Persistent(name="clientesPF"), @Persistent(name="clientesPJ"), @Persistent(name="dadosPessoaJuridica")})
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
	@Extension(vendorName="datanucleus", key="gae.parent-pk", value="true")
	private String chavePai;
	
	public String getChavePai() {
		return chavePai;
	}

	public void setChavePai(String chavePai) {
		this.chavePai = chavePai;
	}

	
	
	@Persistent
	ArrayList<ClientePF> clientesPF;
	
	@Persistent
	ArrayList<ClientePJ> clientesPJ;
	
	@Persistent
	PessoaJuridica dadosPessoaJuridica;

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public ArrayList<ClientePF> getClientesPF() {
		if(clientesPF==null){
			setClientesPF(new ArrayList<ClientePF>());
		}
		return clientesPF;
	}

	public void setClientesPF(ArrayList<ClientePF> clientesPF) {
		this.clientesPF = clientesPF;
	}

	public ArrayList<ClientePJ> getClientesPJ() {
		if(clientesPJ==null){
			setClientesPJ(new ArrayList<ClientePJ>());
		}
		return clientesPJ;
	}

	public void setClientesPJ(ArrayList<ClientePJ> clientesPJ) {
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
