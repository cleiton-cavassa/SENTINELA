package cleiton.unisul.piweb.rpc.shared.objetoschaveados;


import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.FetchGroup;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.acessorios.PadraoItemResumo;


@PersistenceCapable(detachable="true")
@FetchGroup(name="grupo", members={
		@Persistent(name="dadosClientePJ"),
		@Persistent(name="clientesPFVinculados"),
		@Persistent(name="pessoaJuridica")
		})
public class ClientePJ implements ObjetoChaveado {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 2244823849227873688L;
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
	private String chave;
	@Persistent
	private DadosClientePJ dadosClientePJ;
    @Persistent
    private ArrayList<ParChaveDescricao> clientesPFVinculados;
    @Persistent
    private PessoaJuridica pessoaJuridica;
	
	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public DadosClientePJ getDadosClientePJ() {
		if (dadosClientePJ==null){
			setDadosClientePJ(new DadosClientePJ());
		}
		return dadosClientePJ;
	}

	public void setDadosClientePJ(DadosClientePJ dadosClientePJ) {
		this.dadosClientePJ = dadosClientePJ;
	}

	public ArrayList<ParChaveDescricao> getClientesPFVinculados() {
		if (clientesPFVinculados==null){
			setClientesPFVinculados(new ArrayList<ParChaveDescricao>());
		}
		return clientesPFVinculados;
	}

	public void setClientesPFVinculados(ArrayList<ParChaveDescricao> clientesPFVinculados) {
		this.clientesPFVinculados = clientesPFVinculados;
	}

	public PessoaJuridica getPessoaJuridica() {
		if (pessoaJuridica==null){
			setPessoaJuridica(new PessoaJuridica());
		}
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
