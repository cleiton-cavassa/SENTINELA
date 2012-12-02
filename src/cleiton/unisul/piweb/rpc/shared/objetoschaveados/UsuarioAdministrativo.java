package cleiton.unisul.piweb.rpc.shared.objetoschaveados;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;

import javax.jdo.annotations.FetchGroup;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.acessorios.PadraoItemResumo;

@PersistenceCapable(detachable="true")
@FetchGroup(name="grupo",members={
		@Persistent(name="pessoaFisica"),
		@Persistent(name="dadosUsuarioAdministrativo")
		})
public class UsuarioAdministrativo implements ObjetoChaveado{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 7694901771463034009L;

	public UsuarioAdministrativo() {}
	
//	public enum NivelDeAcesso{Administrador1,Administrador2}
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
	private String chave;
	
	@Persistent
	private DadosUsuarioAdministrativo dadosUsuarioAdministrativo;
	
	
    @Persistent
    private PessoaFisica pessoaFisica; 

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}
	
	
	public DadosUsuarioAdministrativo getDadosUsuarioAdministrativo() {
		if(dadosUsuarioAdministrativo==null){
			setDadosUsuarioAdministrativo(new DadosUsuarioAdministrativo());
		}
		return dadosUsuarioAdministrativo;
	}

	public void setDadosUsuarioAdministrativo(
			DadosUsuarioAdministrativo dadosUsuarioAdministrativo) {
		this.dadosUsuarioAdministrativo = dadosUsuarioAdministrativo;
	}

	public PessoaFisica getPessoaFisica() {
		if(pessoaFisica==null){
			setPessoaFisica(new PessoaFisica());
		}
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	@Override
	public String getResumo(){
    	StringBuilder b=new StringBuilder();
    	
    	PadraoItemResumo p = PadraoItemResumo.get();
    	p.gerarItem(b, "Dados do usuAdm", dadosUsuarioAdministrativo.getResumo());
				
		return b.toString();
	}
	
	@Override
	public String toString(){		
		return dadosUsuarioAdministrativo.getEmail() + " - "+ dadosUsuarioAdministrativo.getNivelAcesso();
	}
}
