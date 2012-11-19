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
public class PessoaJuridica implements ObjetoChaveado {
	
//    @PrimaryKey
//	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
//	private Object chave;
    
    @Persistent
	private Long cnpj;
	
	@Persistent
	private String razaoSocial;

	@Persistent
    private ArrayList<String> regioesDeAtuacao;
	
	@Persistent
	private DadosDeContato dadosDeContato;
	

//    public Object getChave() {
//		return chave;
//	}


//	public void setChave(Object chave) {
//		this.chave = chave;
//	}


	public Long getCnpj() {
		return cnpj;
	}


	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}


	public String getRazaoSocial() {
		return razaoSocial;
	}


	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}


	public ArrayList<String> getRegioesDeAtuacao() {
		return regioesDeAtuacao;
	}


	public void setRegioesDeAtuacao(ArrayList<String> regioesDeAtuacao) {
		this.regioesDeAtuacao = regioesDeAtuacao;
	}


	public DadosDeContato getContatos() {
		return dadosDeContato;
	}


	public void setContatos(DadosDeContato dadosDeContato) {
		this.dadosDeContato = dadosDeContato;
	}


	@Override
	public String getResumo(){
    	StringBuilder b=new StringBuilder();
    	
    	PadraoItemResumo p = PadraoItemResumo.get();
    	p.gerarItem(b, "CNPJ", cnpj);
    	p.gerarItem(b, "Razao Social", razaoSocial);
    	p.gerarItem(b, "DadosDeContato", dadosDeContato);
    	p.gerarItem(b, "Regioes de Atuacao", regioesDeAtuacao);
		
		return b.toString();
	}
}
