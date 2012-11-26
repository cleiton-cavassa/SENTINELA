package cleiton.unisul.piweb.rpc.shared.objetoschaveados;


import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import org.datanucleus.api.jpa.annotations.Extension;

import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;
import cleiton.unisul.piweb.rpc.shared.ParChaveDescricao;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.acessorios.PadraoItemResumo;

@SuppressWarnings("serial")
@PersistenceCapable
public class ClientePJ implements ObjetoChaveado {
    
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
	private String chave;
	@Persistent
	private DadosClientePJ dadosClientePJ;
    @Persistent
    private List<ParChaveDescricao> clientesPFVinculados;
    @Persistent
    private PessoaJuridica pessoaJuridica;
	
	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public DadosClientePJ getDadosClientePJ() {
		return dadosClientePJ;
	}

	public void setDadosClientePJ(DadosClientePJ dadosClientePJ) {
		this.dadosClientePJ = dadosClientePJ;
	}

	public List<ParChaveDescricao> getClientesPFVinculados() {
		return clientesPFVinculados;
	}

	public void setClientesPFVinculados(List<ParChaveDescricao> clientesPFVinculados) {
		this.clientesPFVinculados = clientesPFVinculados;
	}

	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}


    
    @Override
 	public String getResumo(){
     	StringBuilder b=new StringBuilder();
     	
     	PadraoItemResumo p = PadraoItemResumo.get();
     	p.gerarItem(b, "Pessoa Jur\u00EDdica", pessoaJuridica);
     	p.gerarItem(b, "", dadosClientePJ);
 		
 		return b.toString();
 	}
}
