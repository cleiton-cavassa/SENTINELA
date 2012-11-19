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
public class ClientePJ implements ObjetoChaveado {
	
    public enum Status{Ativo,Inativo}
    public enum Voucher{Ativado,Desativado}
	
//    @PrimaryKey
//	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
//	private Object chave;
    @Persistent
    private Status status;
//    public Object getChave() {
//		return chave;
//	}

//	public void setChave(Object chave) {
//		this.chave = chave;
//	}

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

	public ArrayList<Object> getClientesPFVinculados() {
		return clientesPFVinculados;
	}

	public void setClientesPFVinculados(ArrayList<Object> clientesPFVinculados) {
		this.clientesPFVinculados = clientesPFVinculados;
	}

	public PessoaJuridica getDadosPessoaJuridica() {
		return dadosPessoaJuridica;
	}

	public void setDadosPessoaJuridica(PessoaJuridica dadosPessoaJuridica) {
		this.dadosPessoaJuridica = dadosPessoaJuridica;
	}

	@Persistent
    private Voucher voucher;
    @Persistent
    private ArrayList<Object> clientesPFVinculados;
    @Persistent
    private PessoaJuridica dadosPessoaJuridica;
    
    @Override
 	public String getResumo(){
     	StringBuilder b=new StringBuilder();
     	
     	PadraoItemResumo p = PadraoItemResumo.get();
     	p.gerarItem(b, "Dados da Pessoa Jur\u00EDdica", dadosPessoaJuridica);
     	p.gerarItem(b, "Status", status);
     	p.gerarItem(b, "Voucher", voucher);
 		
 		return b.toString();
 	}
}
