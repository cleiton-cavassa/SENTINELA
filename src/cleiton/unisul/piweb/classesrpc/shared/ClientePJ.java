package cleiton.unisul.piweb.classesrpc.shared;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import cleiton.unisul.piweb.sistema.client.validacao.CompositeCNPJ;
import cleiton.unisul.piweb.sistema.client.validacao.CompositeCPF;


@SuppressWarnings("serial")
@PersistenceCapable
public class ClientePJ  implements Serializable, ObjetoChaveado {
	
    @PrimaryKey
    @Persistent
	private Long CNPJ;
	
	@Persistent
	private String razaoSocial;
	
	@Persistent
	private Boolean status;
	
	/*
	@Persistent
	private ArrayList<ClientePF> pessoasFisicas;

	public ArrayList<ClientePF> getPessoasFisicas() {
		return pessoasFisicas;
	}

	public void setPessoasFisicas(ArrayList<ClientePF> pessoasFisicas) {
		this.pessoasFisicas = pessoasFisicas;
	}
	*/

	@Persistent
	private String enderecoMatriz;

	@Persistent
	private ArrayList<String> regioesDeAtuacao=new ArrayList<String>();
	
	@Persistent
	private Boolean vouchersAtivos;

	public Long getChave() {
		return CNPJ;
	}

	public void setChave(Long cNPJ) {
		CNPJ = cNPJ;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}


	public ArrayList<String> getRegioesDeAtuacao() {
		return regioesDeAtuacao;
	}
	
	public String getEnderecoMatriz() {
		return enderecoMatriz;
	}

	public void setEnderecoMatriz(String enderecoMatriz) {
		this.enderecoMatriz = enderecoMatriz;
	}

	public void setRegioesDeAtuacao(ArrayList<String> regioesDeAtuacao) {
		this.regioesDeAtuacao = regioesDeAtuacao;
	}

	public Boolean getVouchersAtivos() {
		return vouchersAtivos;
	}

	public void setVouchersAtivos(Boolean vouchersAtivos) {
		this.vouchersAtivos = vouchersAtivos;
	}
	
	@Override
	public String getResumo() {
		StringBuilder b= new StringBuilder();
		b.append("CNPJ: ");
			b.append(CompositeCNPJ.mascaraCNPJ( this.getChave() ));
			b.append("\n");
		b.append("Razao Social: ");
			b.append(this.getRazaoSocial());
			b.append("\n");
		b.append("Cliente ativo? ");
			b.append((this.getStatus()?"Sim":"Nao"));
			b.append("\n");
		b.append("Endere\u00E7o da Matriz: ");
			b.append(this.getEnderecoMatriz());
			b.append("\n");
		b.append("Vouchers ativos? ");
			b.append((this.getVouchersAtivos()?"Sim":"Nao"));
			b.append("\n");
		b.append("Regi›es de Atuacao: ");
			b.append(this.regioesDeAtuacao.toString());
			b.append("\n");
		
		return b.toString();
	}

}
