package cleiton.unisul.piweb.shared;
import java.io.Serializable;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


@SuppressWarnings("serial")
@PersistenceCapable
public class ClientePF implements Serializable {
	
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long CPF;
	
    
    @Persistent
    private  Long PJVinculada;
    
	@Persistent
	private String nome;
	
	@Persistent
	private Boolean status;
	
	@Persistent
	private Date dataNascimento;
	
	@Persistent
	private Boolean tipoNacionalidade;
	
	@Persistent
	private String idiomasFalados;
	
	@Persistent
	private String endereco;
	
	@Persistent
	private String telefones;
	
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

	public Long getCPF() {
		return CPF;
	}

	public void setCPF(Long cPF) {
		CPF = cPF;
	}

	public Long getPJVinculada() {
		return PJVinculada;
	}

	public void setPJVinculada(Long pJVinculada) {
		PJVinculada = pJVinculada;
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

	public String getIdiomasFalados() {
		return idiomasFalados;
	}

	public void setIdiomasFalados(String idiomasFalados) {
		this.idiomasFalados = idiomasFalados;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefones() {
		return telefones;
	}

	public void setTelefones(String telefones) {
		this.telefones = telefones;
	}

	public Boolean getCarregaAnimais() {
		return carregaAnimais;
	}

	public void setCarregaAnimais(Boolean carregaAnimais) {
		this.carregaAnimais = carregaAnimais;
	}

}
