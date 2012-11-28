package cleiton.unisul.piweb.rpc.shared.objetoschaveados;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.acessorios.PadraoItemResumo;


@PersistenceCapable(detachable="true")
public class DadosPessoaFisica implements ObjetoChaveado, Serializable  {



	/**
	 * 
	 */
	private static final long serialVersionUID = -3562565852292295322L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
	private String chave;
	
	@Persistent
	private long cpf;

	@Persistent
	private Date dataNascimento;

//	@Persistent(defaultFetchGroup="true")
	@Persistent
	private Collection<String> idiomasFalados;

	@Persistent
	private String nome;
	
	public String getChave() {
		return chave;
	}

	public long getCpf() {
		return cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public Collection<String> getIdiomasFalados() {
		if(idiomasFalados==null){
			setIdiomasFalados(new ArrayList<String>());
		}
		return idiomasFalados;
	}
	
	public String getNome() {
		return nome;
	}

	@Override
	public String getResumo() {
   	StringBuilder b=new StringBuilder();
     	
     	PadraoItemResumo p = PadraoItemResumo.get();
     	p.gerarItem(b, "Nome", nome);
     	p.gerarItem(b, "CPF", cpf);
 		
 		return b.toString();
	}

	public void setChave(String chave) {
		this.chave = chave;
	}
	
	public void setCpf(long cpf) {
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
