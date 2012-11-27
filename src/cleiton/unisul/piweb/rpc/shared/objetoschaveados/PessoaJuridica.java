package cleiton.unisul.piweb.rpc.shared.objetoschaveados;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.acessorios.PadraoItemResumo;

@PersistenceCapable(detachable="true")
public class PessoaJuridica implements ObjetoChaveado {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7786392863725237095L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
	private String chave;
	
	@Persistent
    private DadosPessoaJuridica dadosPessoaJuridica;
	
	@Persistent
	private DadosDeContato dadosDeContato;
	

	public String getChave() {
		return chave;
	}


	public void setChave(String chave) {
		this.chave = chave;
	}


	public DadosPessoaJuridica getDadosPessoaJuridica() {
		return dadosPessoaJuridica;
	}


	public void setDadosPessoaJuridica(DadosPessoaJuridica dadosPessoaJuridica) {
		this.dadosPessoaJuridica = dadosPessoaJuridica;
	}


	public DadosDeContato getDadosDeContato() {
		return dadosDeContato;
	}


	public void setDadosDeContato(DadosDeContato dadosDeContato) {
		this.dadosDeContato = dadosDeContato;
	}


	@Override
	public String getResumo(){
    	StringBuilder b=new StringBuilder();
    	
    	PadraoItemResumo p = PadraoItemResumo.get();
    	p.gerarItem(b, "Dados da Pessoa Juridica", dadosPessoaJuridica);
		
		return b.toString();
	}
}
