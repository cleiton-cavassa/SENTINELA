package cleiton.unisul.piweb.rpc.shared.objetoschaveados;

import java.io.Serializable;
import java.util.ArrayList;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable="true")
public class FrotaECredenciais implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5409284620319342409L;
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
	private String chave;
	
	private Frota frota=new Frota();
	private ArrayList<DadosUsuarioAdministrativo.NivelAcesso> credenciais=new ArrayList<DadosUsuarioAdministrativo.NivelAcesso>();
	public Frota getFrota() {
		return frota;
	}
	public void setFrota(Frota frota) {
		this.frota = frota;
	}
	public ArrayList<DadosUsuarioAdministrativo.NivelAcesso> getCredenciais() {
		return credenciais;
	}
	public void setCredenciais(
			ArrayList<DadosUsuarioAdministrativo.NivelAcesso> credenciais) {
		this.credenciais = credenciais;
	}


}
