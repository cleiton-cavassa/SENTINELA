package cleiton.unisul.piweb.rpc.shared.objetoschaveados;

import javax.jdo.annotations.IdGeneratorStrategy;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.acessorios.PadraoItemResumo;


@SuppressWarnings("serial")
@PersistenceCapable
public class ClientePF implements ObjetoChaveado {

	public enum Status{Ativo,Inativo}
	public enum TipoNacionalidade{Brasileiro, Estrangeiro}
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private String chave;
	
//	@PrimaryKey
//	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
//	private Object chave;
	
	@Persistent
	private PessoaFisica dadosPessoais;
	
	@Persistent
	private Preferencias preferencias;
	
	@Persistent
	private Status status;

	@Persistent
	private TipoNacionalidade tipoNacionalidade;

	public TipoNacionalidade getTipoNacionalidade() {
		return tipoNacionalidade;
	}


	public void setTipoNacionalidade(TipoNacionalidade tipoNacionalidade) {
		this.tipoNacionalidade = tipoNacionalidade;
	}


//	public Object getChave() {
//		return chave;
//	}


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


	public Status getStatus() {
		return status;
	}


//	public void setChave(Object chave) {
//		this.chave = chave;
//	}


	public void setDadosPessoais(PessoaFisica dadosPessoais) {
		this.dadosPessoais = dadosPessoais;
	}


	public void setPreferencias(Preferencias preferencias) {
		this.preferencias = preferencias;
	}
	

	public void setStatus(Status status) {
		this.status = status;
	}

}
