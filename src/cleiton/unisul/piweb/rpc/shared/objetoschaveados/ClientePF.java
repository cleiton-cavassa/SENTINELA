package cleiton.unisul.piweb.rpc.shared.objetoschaveados;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.FetchGroup;
import javax.jdo.annotations.FetchGroups;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewCPF;
import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.acessorios.PadraoItemResumo;


@PersistenceCapable(detachable="true")

@FetchGroups({
@FetchGroup(name="grupo", members={@Persistent(name="dadosPessoaFisica"),@Persistent(name="dadosDeContato"),@Persistent(name="preferencias"),@Persistent(name="dadosClientePF")})
,
@FetchGroup(name="dadosCompartilhados",members={@Persistent(name="dadosPessoaFisica"),@Persistent(name="dadosDeContato"),@Persistent(name="preferencias"),@Persistent(name="dadosClientePF")})
})
public class ClientePF implements ObjetoChaveado{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3890031823483388597L;

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
	private DadosPessoaFisica dadosPessoaFisica;
	
	@Persistent
	private DadosDeContato dadosDeContato;

	@Persistent
	private Preferencias preferencias;

	@Persistent
	private DadosClientePF dadosClientePF;

	public DadosPessoaFisica getDadosPessoaFisica() {
		if (dadosPessoaFisica==null){
			setDadosPessoaFisica(new DadosPessoaFisica());
		}
		return dadosPessoaFisica;
	}

	public void setDadosPessoaFisica(DadosPessoaFisica dadosPessoaFisica) {
		this.dadosPessoaFisica = dadosPessoaFisica;
	}
	
	public DadosDeContato getDadosDeContato() {
		if (dadosDeContato==null){
			setDadosDeContato(new DadosDeContato());
		}
		return dadosDeContato;
	}

	public void setDadosDeContato(DadosDeContato dadosDeContato) {
		this.dadosDeContato = dadosDeContato;
	}


	public DadosClientePF getDadosClientePF() {
		if(dadosClientePF==null){
			setDadosClientePF(new DadosClientePF());
		}
		return dadosClientePF;
	}

	public void setDadosClientePF(DadosClientePF dadosClientePF) {
		this.dadosClientePF = dadosClientePF;
	}

	public String getChave() {
		return chave;
	}
	

	public Preferencias getPreferencias() {
		if(preferencias==null){
			setPreferencias(new Preferencias());
		}
		return preferencias;
	}


	@Override
 	public String getResumo(){
     	StringBuilder b=new StringBuilder();
     	
     	PadraoItemResumo p = PadraoItemResumo.get();
     	p.gerarItem(b, "Nome", dadosPessoaFisica.getNome());
     	p.gerarItem(b, "CPF", InputViewCPF.mascaraCPF(dadosPessoaFisica.getCpf()));
//     	p.gerarItem(b, "Dados Pessoa Fisica", dadosPessoaFisica.getResumo());
//     	p.gerarItem(b, "Dados de Contato", dadosDeContato.getResumo());
//     	p.gerarItem(b, "Preferencias", preferencias.getResumo());
 		
 		return b.toString();
 	}


	public void setChave(String chave) {
		this.chave = chave;
	}


	public void setPreferencias(Preferencias preferencias) {
		this.preferencias = preferencias;
	}

}
