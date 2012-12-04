package cleiton.unisul.piweb.rpc.shared.objetoschaveados;

import javax.jdo.annotations.IdGeneratorStrategy;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.FetchGroup;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewCPF;
import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.acessorios.PadraoItemResumo;

@PersistenceCapable(detachable="true")
@FetchGroup(name="grupo", members={
		@Persistent(name="dadosPessoais"),
		@Persistent(name="dadosProfissionais"),
		@Persistent(name="preferencias")
		})
public class Motorista implements ObjetoChaveado {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 516380132262526385L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
	private String chave;
	
	@Persistent
	@Extension(vendorName="datanucleus", key="gae.parent-pk", value="true")
	private String chavePai;
	
	@Persistent
	private PessoaFisica dadosPessoais;
	
	@Persistent
	private DadosProfissionais dadosProfissionais;
	
	@Persistent
	private Preferencias preferencias;
	
	

	public String getChavePai() {
		return chavePai;
	}

	public void setChavePai(String chavePai) {
		this.chavePai = chavePai;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public PessoaFisica getDadosPessoais() {
		if(dadosPessoais==null){
			setDadosPessoais(new PessoaFisica());
		}
		return dadosPessoais;
	}

	public void setDadosPessoais(PessoaFisica dadosPessoais) {
		this.dadosPessoais = dadosPessoais;
	}

	public DadosProfissionais getDadosProfissionais() {
		if(dadosProfissionais==null){
			setDadosProfissionais(new DadosProfissionais());
		}
		return dadosProfissionais;
	}

	public void setDadosProfissionais(DadosProfissionais dadosProfissionais) {
		this.dadosProfissionais = dadosProfissionais;
	}

	public Preferencias getPreferencias() {
		if(preferencias==null){
			setPreferencias(new Preferencias());
		}
		return preferencias;
	}

	public void setPreferencias(Preferencias preferencias) {
		this.preferencias = preferencias;
	}

	@Override
 	public String getResumo(){
     	StringBuilder b=new StringBuilder();
     	
     	PadraoItemResumo p = PadraoItemResumo.get();
     	p.gerarItem(b, "Nome", dadosPessoais.getDadosPessoaFisica().getNome());
     	p.gerarItem(b, "CPF", InputViewCPF.mascaraCPF(dadosPessoais.getDadosPessoaFisica().getCpf()));
//     	p.gerarItem(b, "Dados Pessoais", dadosPessoais.getResumo());
//     	p.gerarItem(b, "Dados Profissionais", dadosProfissionais.getResumo());
//     	p.gerarItem(b, "Preferencias", preferencias.getResumo());
 		
     	
 		return b.toString();
 	}

}
