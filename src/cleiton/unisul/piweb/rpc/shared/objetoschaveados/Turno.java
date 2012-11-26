package cleiton.unisul.piweb.rpc.shared.objetoschaveados;

import java.util.Date;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;

@SuppressWarnings("serial")
@PersistenceCapable
public class Turno implements ObjetoChaveado {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
	private String chave;
	
	@Persistent
	private Date fim;

	@Persistent
	private Date inicio;

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	@Override
 	public String getResumo(){
     	StringBuilder b=new StringBuilder();
     	
//     	PadraoItemResumo p = PadraoItemResumo.get();
//     	p.gerarItem(b, "in’cio", String.format("R", inicio));
//     	p.gerarItem(b, "fim", String.format("R", fim));
 		
 		return b.toString();
 	}
	
	@SuppressWarnings("deprecation")
	@Override
	public String toString(){
		StringBuilder b = new StringBuilder();
		
		Date buffer;
		
		buffer=inicio;
		
		b.append("inicia ");
		b.append(buffer.getHours()+":");
		b.append((buffer.getMinutes()<10?"0":""));
		b.append(buffer.getMinutes());
		
		buffer=fim;
		b.append(" e termina ");
		b.append(buffer.getHours()+":");
		b.append((buffer.getMinutes()<10?"0":""));
		b.append(buffer.getMinutes());
		
		return b.toString();
	}
	
}
