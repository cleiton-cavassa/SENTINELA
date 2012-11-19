package cleiton.unisul.piweb.rpc.shared.objetoschaveados;

import java.util.ArrayList;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.acessorios.PadraoItemResumo;

@SuppressWarnings("serial")
@PersistenceCapable
public class DadosProfissionais implements ObjetoChaveado {
	
	@Persistent
	private String carro;
	
//	@PrimaryKey
//	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
//	private Object chave;
	
	@Persistent
	private ArrayList<Turno> turnos;
	
	public String getCarro() {
		return carro;
	}

//	public Object getChave() {
//		return chave;
//	}

	@Override
 	public String getResumo(){
     	StringBuilder b=new StringBuilder();
     	
     	PadraoItemResumo p = PadraoItemResumo.get();
     	p.gerarItem(b, "carro", carro);
     	p.gerarItem(b, "in’cio", turnos);
 		
 		return b.toString();
 	}

	public ArrayList<Turno> getTurnos() {
		return turnos;
	}

	public void setCarro(String carro) {
		this.carro = carro;
	}

//	public void setChave(Object chave) {
//		this.chave = chave;
//	}

	public void setTurnos(ArrayList<Turno> turnos) {
		this.turnos = turnos;
	}


}
