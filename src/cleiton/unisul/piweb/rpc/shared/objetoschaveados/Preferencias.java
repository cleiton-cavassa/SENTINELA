package cleiton.unisul.piweb.rpc.shared.objetoschaveados;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.acessorios.PadraoItemResumo;


@PersistenceCapable(detachable="true")
public class Preferencias implements ObjetoChaveado, Serializable  {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum MotoristaFumante{Nao,Sim}
    public enum TransportaAnimais{Nao,Sim}

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
