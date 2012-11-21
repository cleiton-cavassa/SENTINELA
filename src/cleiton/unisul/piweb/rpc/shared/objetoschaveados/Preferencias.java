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
public class Preferencias implements ObjetoChaveado {
    public enum MotoristaFumante{Nao,Sim}
    public enum TransportaAnimais{Nao,Sim}

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
	private String chave;

	@Persistent
	private MotoristaFumante motoristaFumante;

	@Persistent
	private TransportaAnimais transportaAnimais;

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public MotoristaFumante getMotoristaFumante() {
		return motoristaFumante;
	}

	public void setMotoristaFumante(MotoristaFumante motoristaFumante) {
		this.motoristaFumante = motoristaFumante;
	}

	public TransportaAnimais getTransportaAnimais() {
		return transportaAnimais;
	}

	public void setTransportaAnimais(TransportaAnimais transportaAnimais) {
		this.transportaAnimais = transportaAnimais;
	}

	@Override
 	public String getResumo(){
     	StringBuilder b=new StringBuilder();
     	
     	PadraoItemResumo p = PadraoItemResumo.get();
     	p.gerarItem(b, "Transporte de Animais", transportaAnimais);
     	p.gerarItem(b, "Motorista fumante", motoristaFumante);
 		
 		return b.toString();
 	}

}
