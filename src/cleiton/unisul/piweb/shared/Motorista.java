package cleiton.unisul.piweb.shared;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import cleiton.unisul.piweb.client.validacao.CompositeCNPJ;
import cleiton.unisul.piweb.client.validacao.CompositeCPF;

@PersistenceCapable
public class Motorista  implements Serializable, ObjetoChaveado {

	@Persistent
	private Long CPF;
	
	@Persistent
	private String nome;
	
	@Persistent
	private Date dataNascimento;
	
	@Persistent
	private String carro;

	@Persistent
	private List<String> telefones;

	@Persistent
	private String endereco;
	
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

	public Long getChave() {
		return CPF;
	}

	public void setChave(Long cPF) {
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

	public List<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<String> telefones) {
		this.telefones = telefones;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
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
	
	@Override
	public String resumo() {
		StringBuilder b= new StringBuilder();
		b.append("CPF: ");
			b.append(CompositeCPF.mascaraCPF( this.getChave() ));
			b.append("\n");
		b.append("Nome: ");
			b.append(this.getNome());
			b.append("\n");
		b.append("Data de Nascimento: ");
			b.append(String.format("d/m/Y", this.getDataNascimento()));
			b.append("\n");
		b.append("Carro: ");
			b.append(this.getCarro());
			b.append("\n");
		b.append("Idiomas Falados: ");
			b.append(this.getIdiomasFalados());
			b.append("\n");
		b.append("Endere\u00E7o: ");
			b.append(this.getEndereco());
			b.append("\n");
		b.append("Telefones: ");
			b.append(this.getTelefones());
			b.append("\n");
		b.append("Aceita motorista fumante? ");
			b.append((this.getFumante()?"Sim":"Nao"));
			b.append("\n");
		b.append("Carrega animais? ");
			b.append((this.getCarregaAnimais()?"Sim":"Nao"));
			b.append("\n");
		
		return b.toString();
	}

}
