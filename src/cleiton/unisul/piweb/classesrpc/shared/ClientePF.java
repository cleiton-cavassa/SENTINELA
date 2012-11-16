package cleiton.unisul.piweb.classesrpc.shared;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.sun.tools.javac.code.Attribute.Array;

import cleiton.unisul.piweb.sistema.client.validacao.CompositeCNPJ;
import cleiton.unisul.piweb.sistema.client.validacao.CompositeCPF;


@SuppressWarnings("serial")
@PersistenceCapable
public class ClientePF implements Serializable, ObjetoChaveado {
	
	public static enum TipoNacionalidade{BRASILEIRO, ESTRANGEIRO};
	public static enum Status{ATIVO, INATIVO};
	public static enum AceitaMotoristaFumante{SIM, NUNCA};
	public static enum CarregaAnimais{SIM, NUNCA};
	
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long CPF;
	
    @Persistent
    private  Long PJVinculada;
    
	@Persistent
	private String nome;
	
	@Persistent
	private Enum<Status> status;
	
	@Persistent
	private Date dataNascimento;
	
	@Persistent
	private Enum<TipoNacionalidade> tipoNacionalidade;
	
	@Persistent
	private String idiomasFalados;
	
	@Persistent
	private String endereco;
	
	@Persistent
	private String telefones;
	
	@Persistent
	private Enum<CarregaAnimais> carregaAnimais;
	
	@Persistent
	private Enum<AceitaMotoristaFumante> aceitaMotFumante;


	public Enum<AceitaMotoristaFumante> getAceitaMotFumante() {
		return aceitaMotFumante;
	}

	public void setAceitaMotFumante(Enum<AceitaMotoristaFumante> aceitaMotFumante) {
		this.aceitaMotFumante = aceitaMotFumante;
	}

	public Long getChave() {
		return CPF;
	}

	public void setChave(Long cPF) {
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

	public Enum<Status> getStatus() {
		return status;
	}

	public void setStatus(Enum<Status> status) {
		this.status = status;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Enum<TipoNacionalidade> getTipoNacionalidade() {
		return tipoNacionalidade;
	}

	public void setTipoNacionalidade(Enum<TipoNacionalidade> tipoNacionalidade) {
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

	public Enum<CarregaAnimais> getCarregaAnimais() {
		return carregaAnimais;
	}

	public void setCarregaAnimais(Enum<CarregaAnimais> carregaAnimais) {
		this.carregaAnimais = carregaAnimais;
	}

	@Override
	public String getResumo() {
		StringBuilder b= new StringBuilder();
		b.append("CPF: ");
			b.append(CompositeCPF.mascaraCPF( this.getChave() ));
			b.append("\n");
		b.append("Nome: ");
			b.append(this.getNome());
			b.append("\n");
		b.append("Data de Nascimento: ");
			//b.append(String.format("d/m/Y", this.getDataNascimento()));
			b.append(getDataNascimento().toString());
			b.append("\n");
		b.append("Status do cliente: ");
			b.append(this.getStatus().name());
			b.append("\n");
		b.append("Pessoa Jur’dica Vinculada: ");
			b.append(CompositeCNPJ.mascaraCNPJ( this.getPJVinculada() ));
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
		b.append("Aceita viajar com motorista fumante? ");
			b.append(this.getAceitaMotFumante().name());
			b.append("\n");
		b.append("Carrega animais? ");
			b.append(this.getCarregaAnimais().name());
			b.append("\n");
		
		return b.toString();
	}
}
