package cleiton.unisul.piweb.rpc.shared.objetoschaveados;

import java.util.Collection;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.acessorios.PadraoItemResumo;

@PersistenceCapable(detachable="true")
public class DadosProfissionais implements ObjetoChaveado {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5862025157489307936L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
	private String chave;
	
	@Persistent
	private String carro;
	
	@Persistent
	private Collection<Turno> turnos;
	
	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public String getCarro() {
		return carro;
	}

	public void setCarro(String carro) {
		this.carro = carro;
	}

	public Collection<Turno> getTurnos() {
		return turnos;
	}

	public void setTurnos(Collection<Turno> turnos) {
		this.turnos = turnos;
	}

	
	
	@Override
 	public String getResumo(){
     	StringBuilder b=new StringBuilder();
     	
     	PadraoItemResumo p = PadraoItemResumo.get();
     	p.gerarItem(b, "carro", carro);
     	p.gerarItem(b, "in’cio", turnos);
 		
 		return b.toString();
 	}

}
