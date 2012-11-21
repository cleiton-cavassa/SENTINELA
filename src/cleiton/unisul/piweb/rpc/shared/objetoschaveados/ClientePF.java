package cleiton.unisul.piweb.rpc.shared.objetoschaveados;

import javax.jdo.annotations.IdGeneratorStrategy;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import org.datanucleus.api.jpa.annotations.Extension;

import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.acessorios.PadraoItemResumo;


@SuppressWarnings("serial")
@PersistenceCapable
public class ClientePF implements ObjetoChaveado {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
	private String chave;
	
	@Persistent
	private PessoaFisica dadosPessoais;


	@Persistent
	private Preferencias preferencias;

	private DadosClientePF dadosClientePF;

	public DadosClientePF getDadosClientePF() {
		return dadosClientePF;
	}

	public void setDadosClientePF(DadosClientePF dadosClientePF) {
		this.dadosClientePF = dadosClientePF;
	}

	public String getChave() {
		return chave;
	}
	
	public PessoaFisica getDadosPessoais() {
		return dadosPessoais;
	}
	

	public Preferencias getPreferencias() {
		return preferencias;
	}


	@Override
 	public String getResumo(){
     	StringBuilder b=new StringBuilder();
     	
     	PadraoItemResumo p = PadraoItemResumo.get();
     	p.gerarItem(b, "Dados Pessoais", dadosPessoais);
     	p.gerarItem(b, "Preferencias", preferencias);
 		
 		return b.toString();
 	}


	public void setChave(String chave) {
		this.chave = chave;
	}

	public void setDadosPessoais(PessoaFisica dadosPessoais) {
		this.dadosPessoais = dadosPessoais;
	}


	public void setPreferencias(Preferencias preferencias) {
		this.preferencias = preferencias;
	}

}
