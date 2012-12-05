package cleiton.unisul.piweb.rpc.shared.respostasdeconsulta;

import java.io.Serializable;
import java.util.List;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


@PersistenceCapable(detachable="true")
public class RespostaLoginUsuarioAdministrativo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3849559944594961732L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
	private String chave;
	
	@Persistent
	private Usuario usuario;
	
	@Persistent
	private List<FrotaECredenciais> frotasEcredenciais;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<FrotaECredenciais> getFrotasEcredenciais() {
		return frotasEcredenciais;
	}

	public void setFrotasEcredenciais(
			List<FrotaECredenciais> frotasEcredenciais) {
		this.frotasEcredenciais = frotasEcredenciais;
	}

}
