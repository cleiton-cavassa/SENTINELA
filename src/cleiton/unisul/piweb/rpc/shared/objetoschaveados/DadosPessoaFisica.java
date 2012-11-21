package cleiton.unisul.piweb.rpc.shared.objetoschaveados;

import java.util.Collection;
import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import org.datanucleus.api.jpa.annotations.Extension;

import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;

@SuppressWarnings("serial")
public class DadosPessoaFisica implements ObjetoChaveado {

	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
	private String chave;
	
	@Persistent
	private Long cpf;

	@Persistent
	private Date dataNascimento;

	private Collection<String> idiomasFalados;

	@Persistent
	private String nome;
	
	public String getChave() {
		return chave;
	}

	public Long getCpf() {
		return cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public Collection<String> getIdiomasFalados() {
		return idiomasFalados;
	}
	
	public String getNome() {
		return nome;
	}

	@Override
	public String getResumo() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}
	
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public void setIdiomasFalados(Collection<String> idiomasFalados) {
		this.idiomasFalados = idiomasFalados;
	}
		
	public void setNome(String nome) {
		this.nome = nome;
	}

}
