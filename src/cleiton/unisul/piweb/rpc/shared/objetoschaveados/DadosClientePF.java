package cleiton.unisul.piweb.rpc.shared.objetoschaveados;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;


@PersistenceCapable(detachable="true")
public class DadosClientePF implements ObjetoChaveado, Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2248410917580218590L;

	public enum Status{Ativo,Inativo}
	public enum TipoNacionalidade{Brasileiro, Estrangeiro}
    
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
	private Status status;
	
	@Persistent
	private TipoNacionalidade tipoNacionalidade;
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public TipoNacionalidade getTipoNacionalidade() {
		return tipoNacionalidade;
	}

	public void setTipoNacionalidade(TipoNacionalidade tipoNacionalidade) {
		this.tipoNacionalidade = tipoNacionalidade;
	}
	

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	@Override
	public String getResumo() {
		// TODO Auto-generated method stub
		return null;
	}

}
