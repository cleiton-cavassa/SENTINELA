package cleiton.unisul.piweb.rpc.shared.objetoschaveados;

import java.util.ArrayList;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.acessorios.PadraoItemResumo;

@SuppressWarnings("serial")
@PersistenceCapable
public class PessoaFisica implements ObjetoChaveado {
    
//	@PrimaryKey
//	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
//	private Object chave;
	
	@Persistent
	private Long cpf;
	@Persistent
	private DadosDeContato dadosDeContato;
	@Persistent
	private Date dataNascimento;
	
	@Persistent
	private ArrayList<String> idiomasFalados;


	@Persistent
	private String nome;


//	public Object getChave() {
//		return chave;
//	}
	
	public Long getCpf() {
		return cpf;
	}


	public DadosDeContato getDadosDeContato() {
		return dadosDeContato;
	}


	public Date getDataNascimento() {
		return dataNascimento;
	}


	public ArrayList<String> getIdiomasFalados() {
		return idiomasFalados;
	}


	public String getNome() {
		return nome;
	}


	@Override
 	public String getResumo(){
     	StringBuilder b=new StringBuilder();
     	
     	PadraoItemResumo p = PadraoItemResumo.get();
     	p.gerarItem(b, "CPF", cpf);
     	p.gerarItem(b, "Nome", nome);
     	p.gerarItem(b, "Data de Nascimento", dataNascimento);
     	p.gerarItem(b, "Dados de Contato", dadosDeContato);
 		
 		return b.toString();
 	}


//	public void setChave(Object chave) {
//		this.chave = chave;
//	}


	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}


	public void setDadosDeContato(DadosDeContato dadosDeContato) {
		this.dadosDeContato = dadosDeContato;
	}


	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public void setIdiomasFalados(ArrayList<String> idiomasFalados) {
		this.idiomasFalados = idiomasFalados;
	}
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}
}
