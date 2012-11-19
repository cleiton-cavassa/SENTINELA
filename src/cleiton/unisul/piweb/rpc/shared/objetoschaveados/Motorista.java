package cleiton.unisul.piweb.rpc.shared.objetoschaveados;

import javax.jdo.annotations.IdGeneratorStrategy;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.acessorios.PadraoItemResumo;

@SuppressWarnings("serial")
@PersistenceCapable
public class Motorista implements ObjetoChaveado {
	
//	@PrimaryKey
//	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
//	private Object chave;
	
	@Persistent
	private PessoaFisica dadosPessoais;
	
	@Persistent
	private DadosProfissionais dadosProfissionais;
	
	@Persistent
	private Preferencias preferencias;
	
//	public Object getChave() {
//		return chave;
//	}

	public PessoaFisica getDadosPessoais() {
		return dadosPessoais;
	}

	public DadosProfissionais getDadosProfissionais() {
		return dadosProfissionais;
	}

	public Preferencias getPreferencias() {
		return preferencias;
	}

	@Override
 	public String getResumo(){
     	StringBuilder b=new StringBuilder();
     	
     	PadraoItemResumo p = PadraoItemResumo.get();
     	p.gerarItem(b, "Dados Pessoais", dadosPessoais);
     	p.gerarItem(b, "Dados Profissionais", dadosProfissionais);
     	p.gerarItem(b, "Preferencias", preferencias);
 		
     	
 		return b.toString();
 	}

//	public void setChave(Object chave) {
//		this.chave = chave;
//	}

	public void setDadosPessoais(PessoaFisica dadosPessoais) {
		this.dadosPessoais = dadosPessoais;
	}

	public void setDadosProfissionais(DadosProfissionais dadosProfissionais) {
		this.dadosProfissionais = dadosProfissionais;
	}

	public void setPreferencias(Preferencias preferencias) {
		this.preferencias = preferencias;
	}


}
