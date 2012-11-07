package cleiton.unisul.piweb.shared;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import com.google.appengine.api.datastore.*;

@PersistenceCapable
public class ClientePF {
	
	@Persistent
	private String CPF;
	
	@Persistent
	private String nome;
	
	@Persistent
	private Boolean status;
	
	@Persistent
	private Date dataNascimento;
	
	@Persistent
	private Boolean tipoNacionalidade;
	
	@Persistent
	private List<String> idiomasFalados;
	
	@Persistent
	private PostalAddress endereco;
	
	@Persistent
	private List<PhoneNumber> telefones;
	
	@Persistent
	private Boolean carregaAnimais;
	
	@Persistent
	private Boolean aceitaMotFumante;


	public Boolean getAceitaMotFumante() {
		return aceitaMotFumante;
	}

	public void setAceitaMotFumante(Boolean aceitaMotFumante) {
		this.aceitaMotFumante = aceitaMotFumante;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Boolean getTipoNacionalidade() {
		return tipoNacionalidade;
	}

	public void setTipoNacionalidade(Boolean tipoNacionalidade) {
		this.tipoNacionalidade = tipoNacionalidade;
	}

	public List<String> getIdiomasFalados() {
		return idiomasFalados;
	}

	public void setIdiomasFalados(List<String> idiomasFalados) {
		this.idiomasFalados = idiomasFalados;
	}

	public PostalAddress getEndereco() {
		return endereco;
	}

	public void setEndereco(PostalAddress endereco) {
		this.endereco = endereco;
	}

	public List<PhoneNumber> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<PhoneNumber> telefones) {
		this.telefones = telefones;
	}

	public Boolean getCarregaAnimais() {
		return carregaAnimais;
	}

	public void setCarregaAnimais(Boolean carregaAnimais) {
		this.carregaAnimais = carregaAnimais;
	}

}
