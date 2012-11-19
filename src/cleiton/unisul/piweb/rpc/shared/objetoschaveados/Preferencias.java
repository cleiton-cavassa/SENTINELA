package cleiton.unisul.piweb.rpc.shared.objetoschaveados;

import javax.jdo.annotations.IdGeneratorStrategy;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.acessorios.PadraoItemResumo;

@SuppressWarnings("serial")
@PersistenceCapable
public class Preferencias implements ObjetoChaveado {
    public enum MotoristaFumante{Nao,Sim}
    public enum TransportaAnimais{Nao,Sim}

//	@PrimaryKey
//	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
//	private Object chave;



	@Persistent
	private MotoristaFumante motoristaFumante;



	@Persistent
	private TransportaAnimais transportaAnimais;



//	public Object getChave() {
//		return chave;
//	}



	public MotoristaFumante getMotoristaFumante() {
		return motoristaFumante;
	}



	@Override
 	public String getResumo(){
     	StringBuilder b=new StringBuilder();
     	
     	PadraoItemResumo p = PadraoItemResumo.get();
     	p.gerarItem(b, "Transporte de Animais", transportaAnimais);
     	p.gerarItem(b, "Motorista fumante", motoristaFumante);
 		
 		return b.toString();
 	}



	public TransportaAnimais getTransportaAnimais() {
		return transportaAnimais;
	}
	
//	public void setChave(Object chave) {
//		this.chave = chave;
//	}
	
	public void setMotoristaFumante(MotoristaFumante motoristaFumante) {
		this.motoristaFumante = motoristaFumante;
	}
	
	
	
	public void setTransportaAnimais(TransportaAnimais transportaAnimais) {
		this.transportaAnimais = transportaAnimais;
	}
	
	

}
