package cleiton.unisul.piweb.rpc.shared.objetoschaveados;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import org.datanucleus.api.jpa.annotations.Extension;

import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;

@SuppressWarnings("serial")
public class DadosClientePF implements ObjetoChaveado {
	
	public enum Status{Ativo,Inativo}
	public enum TipoNacionalidade{Brasileiro, Estrangeiro}
    
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
	private String chave;
	
	
	private Status status;
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
