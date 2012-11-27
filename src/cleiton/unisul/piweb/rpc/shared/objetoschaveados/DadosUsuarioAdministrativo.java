package cleiton.unisul.piweb.rpc.shared.objetoschaveados;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.acessorios.PadraoItemResumo;

@PersistenceCapable(detachable="true")
public class DadosUsuarioAdministrativo implements ObjetoChaveado {
	
	public enum NivelAcesso{Administrador1,Administrador2};
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5999558428512124153L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
	private String chave;
	
	@Persistent
	private String email;
	
	@Persistent
	private NivelAcesso nivelAcesso;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public NivelAcesso getNivelAcesso() {
		return nivelAcesso;
	}

	public void setNivelAcesso(NivelAcesso nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	}

	@Override
	public String getChave() {
		return chave;
	}

	@Override
	public void setChave(String chave) {
		this.chave=chave;
	}

	@Override
	public String getResumo() {
		return toString();
	}
	
	@Override
	public String toString() {
		StringBuilder b=new StringBuilder();
     	
     	PadraoItemResumo p = PadraoItemResumo.get();
     	p.gerarItem(b, "email", email);
     	p.gerarItem(b, "nivel", nivelAcesso);
 		
 		return b.toString(); 
	}

}
