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
public class UsuarioAdministrativo implements ObjetoChaveado{
	
    public enum NivelDeAcesso{Administrador1,Administrador2}
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
	private String chave;
	
    @Persistent
    private String email=null;
    
    @Persistent
    private NivelDeAcesso nivelAcesso=null;
    
	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public NivelDeAcesso getNivelAcesso() {
		return nivelAcesso;
	}

	public void setNivelAcesso(NivelDeAcesso nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	}

	@Override
	public String getResumo(){
    	StringBuilder b=new StringBuilder();
    	
    	PadraoItemResumo p = PadraoItemResumo.get();
    	p.gerarItem(b, "email", email);
    	p.gerarItem(b, "acesso", nivelAcesso);
				
		return b.toString();
	}
}
