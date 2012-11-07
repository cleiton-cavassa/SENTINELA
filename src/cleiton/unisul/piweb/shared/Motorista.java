package cleiton.unisul.piweb.shared;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import com.google.appengine.api.datastore.*;

@PersistenceCapable
public class Motorista {

	@Persistent
	private String CPF;
	
	@Persistent
	private String nome;
	
	@Persistent
	private Date dataNascimento;
	
	@Persistent
	private String carro;

	@Persistent
	private List<PhoneNumber> telefones;

	@Persistent
	private PostalAddress endereco;
	
	@Persistent
	private List<String> idiomasFalados;
	
	@Persistent
	private List<Expediente> horariosDeExpediente;

	@Persistent
	private Boolean carregaAnimais;
	
	@Persistent
	private Boolean fumante;

	public Boolean getFumante() {
		return fumante;
	}

	public void setFumante(Boolean fumante) {
		this.fumante = fumante;
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCarro() {
		return carro;
	}

	public void setCarro(String carro) {
		this.carro = carro;
	}

	public List<PhoneNumber> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<PhoneNumber> telefones) {
		this.telefones = telefones;
	}

	public PostalAddress getEndereco() {
		return endereco;
	}

	public void setEndereco(PostalAddress endereco) {
		this.endereco = endereco;
	}

	public List<String> getIdiomasFalados() {
		return idiomasFalados;
	}

	public void setIdiomasFalados(List<String> idiomasFalados) {
		this.idiomasFalados = idiomasFalados;
	}

	public List<Expediente> getHorariosDeExpediente() {
		return horariosDeExpediente;
	}

	public void setHorariosDeExpediente(List<Expediente> horariosDeExpediente) {
		this.horariosDeExpediente = horariosDeExpediente;
	}

	public Boolean getCarregaAnimais() {
		return carregaAnimais;
	}

	public void setCarregaAnimais(Boolean carregaAnimais) {
		this.carregaAnimais = carregaAnimais;
	}
}
