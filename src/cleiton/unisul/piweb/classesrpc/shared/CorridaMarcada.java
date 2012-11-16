package cleiton.unisul.piweb.classesrpc.shared;


import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class CorridaMarcada  implements Serializable, ObjetoChaveado {

	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long chave;
	
	@Persistent
	private Corrida Corrida;
	
	@Persistent
	private String motorista;

	public Long getChave() {
		return chave;
	}

	public void setChave(Long chave) {
		this.chave = chave;
	}

	public Corrida getCorrida() {
		return Corrida;
	}

	public void setCorrida(Corrida corrida) {
		Corrida = corrida;
	}

	public String getMotorista() {
		return motorista;
	}

	public void setMotorista(String motorista) {
		this.motorista = motorista;
	}

	@Override
	public String getResumo() {
		return "";
	}
}
