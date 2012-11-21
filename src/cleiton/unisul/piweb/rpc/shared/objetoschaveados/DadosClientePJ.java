package cleiton.unisul.piweb.rpc.shared.objetoschaveados;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import org.datanucleus.api.jpa.annotations.Extension;

import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;

@SuppressWarnings("serial")
public class DadosClientePJ implements ObjetoChaveado {
	
    public enum Status{Ativo,Inativo}
    public enum Voucher{Ativado,Desativado}
	
    @PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
	private String chave;
	
	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Voucher getVoucher() {
		return voucher;
	}

	public void setVoucher(Voucher voucher) {
		this.voucher = voucher;
	}

	@Persistent
	private Status status;
	
	@Persistent
	private Voucher voucher;
	
	@Override
	public String getResumo() {
		// TODO Auto-generated method stub
		return null;
	}

}