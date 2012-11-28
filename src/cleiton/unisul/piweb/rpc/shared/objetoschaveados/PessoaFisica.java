package cleiton.unisul.piweb.rpc.shared.objetoschaveados;

import java.io.Serializable;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.acessorios.PadraoItemResumo;

@PersistenceCapable(detachable="true")
public class PessoaFisica implements ObjetoChaveado, Serializable  {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 4081340040640904106L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
	private String chave;
	
	@Persistent
	private DadosPessoaFisica dadosPessoaFisica;
	
	@Persistent
	private DadosDeContato dadosDeContato;



	public String getChave() {
		return chave;
	}



	public void setChave(String chave) {
		this.chave = chave;
	}



	public DadosPessoaFisica getDadosPessoaFisica() {
		if(dadosPessoaFisica==null){
			setDadosPessoaFisica(new DadosPessoaFisica());
		}
		return dadosPessoaFisica;
	}



	public void setDadosPessoaFisica(DadosPessoaFisica dadosPessoaFisica) {
		this.dadosPessoaFisica = dadosPessoaFisica;
	}



	public DadosDeContato getDadosDeContato() {
		if(dadosDeContato==null){
			setDadosDeContato(new DadosDeContato());
		}
		return dadosDeContato;
	}



	public void setDadosDeContato(DadosDeContato dadosDeContato) {
		this.dadosDeContato = dadosDeContato;
	}



	@Override
 	public String getResumo(){
     	StringBuilder b=new StringBuilder();
     	
     	PadraoItemResumo p = PadraoItemResumo.get();
     	p.gerarItem(b, "Dados da Pessoa F’sica", dadosPessoaFisica.getResumo());
     	p.gerarItem(b, "Dados de Contato", dadosDeContato.getResumo());
 		
 		return b.toString();
 	}

}
