package cleiton.unisul.piweb.rpc.shared.objetoschaveados;

import java.util.ArrayList;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.FetchGroup;
import javax.jdo.annotations.FetchGroups;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.acessorios.PadraoItemResumo;

@PersistenceCapable(detachable="true")
@FetchGroups({
@FetchGroup(name="grupo",members={@Persistent(name="usuariosAdministrativos"),@Persistent(name="meusDadosCompartilhados")})
,
@FetchGroup(name="dadosCompartilhados",members={@Persistent(name="meusDadosCompartilhados")})
,
//@FetchGroup(name="corridasCanceladas",members={@Persistent(name="corridasCanceladas"),@Persistent(name="corridasSolicitadas")})
@FetchGroup(name="corridasCanceladas",members={@Persistent(name="corridasCanceladas"),@Persistent(name="corridasSolicitadas")})
,
@FetchGroup(name="corridasFinalizadas",members={@Persistent(name="corridasFinalizadas"),@Persistent(name="corridasSolicitadas")})
})
public class Frota implements ObjetoChaveado{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5996312483963695634L;

	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
	private String chave;
	
	@Persistent
    ArrayList<CorridaCancelada> corridasCanceladas;
	
	@Persistent
	ArrayList<CorridaFinalizada> corridasFinalizadas;
	
	@Persistent
	ArrayList<CorridaSolicitada> corridasSolicitadas;
	
	@Persistent
	ArrayList<FrotaDadosCompartilhados> frotasParceirasForaDaRede;
	
	@Persistent//chaves codificadas
	ArrayList<String> frotasParceirasNaRede;
	
	@Persistent
	FrotaDadosCompartilhados meusDadosCompartilhados;
	
	@Persistent
	ArrayList<Motorista> motoristas;
	
	@Persistent
	ArrayList<UsuarioAdministrativo> usuariosAdministrativos;
	
	@Persistent
	ArrayList<ConviteEnviado> convitesEnviadosPendentes;
	
	@Persistent
	ArrayList<ConviteRecebido> convitesRecebidosPendentes;

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public ArrayList<CorridaCancelada> getCorridasCanceladas() {
		if(corridasCanceladas==null){
			setCorridasCanceladas(new ArrayList<CorridaCancelada>());
		}
		return corridasCanceladas;
	}

	public void setCorridasCanceladas(ArrayList<CorridaCancelada> corridasCanceladas) {
		this.corridasCanceladas = corridasCanceladas;
	}

	public ArrayList<CorridaFinalizada> getCorridasFinalizadas() {
		if(corridasFinalizadas==null){
			setCorridasFinalizadas(new ArrayList<CorridaFinalizada>());
		}
		return corridasFinalizadas;
	}

	public void setCorridasFinalizadas(
			ArrayList<CorridaFinalizada> corridasFinalizadas) {
		this.corridasFinalizadas = corridasFinalizadas;
	}

	public ArrayList<CorridaSolicitada> getCorridasSolicitadas() {
		if(corridasSolicitadas==null){
			setCorridasSolicitadas(new ArrayList<CorridaSolicitada>());
		}
		return corridasSolicitadas;
	}

	public void setCorridasSolicitadas(
			ArrayList<CorridaSolicitada> corridasSolicitadas) {
		this.corridasSolicitadas = corridasSolicitadas;
	}

	public ArrayList<FrotaDadosCompartilhados> getFrotasParceirasForaDaRede() {
		if(frotasParceirasForaDaRede==null){
			setFrotasParceirasForaDaRede(new ArrayList<FrotaDadosCompartilhados>());
		}
		return frotasParceirasForaDaRede;
	}

	public void setFrotasParceirasForaDaRede(
			ArrayList<FrotaDadosCompartilhados> frotasParceirasForaDaRede) {
		this.frotasParceirasForaDaRede = frotasParceirasForaDaRede;
	}

	public ArrayList<String> getFrotasParceirasNaRede() {
		if(frotasParceirasNaRede==null){
			setFrotasParceirasNaRede(new ArrayList<String>());
		}
		return frotasParceirasNaRede;
	}

	public void setFrotasParceirasNaRede(ArrayList<String> frotasParceirasNaRede) {
		this.frotasParceirasNaRede = frotasParceirasNaRede;
	}

	public FrotaDadosCompartilhados getMeusDadosCompartilhados() {
		if(meusDadosCompartilhados==null){
			setMeusDadosCompartilhados(new FrotaDadosCompartilhados());
		}
		return meusDadosCompartilhados;
	}

	public void setMeusDadosCompartilhados(
			FrotaDadosCompartilhados meusDadosCompartilhados) {
		this.meusDadosCompartilhados = meusDadosCompartilhados;
	}

	public ArrayList<Motorista> getMotoristas() {
		if(motoristas==null){
			setMotoristas(new ArrayList<Motorista>());
		}
		return motoristas;
	}

	public void setMotoristas(ArrayList<Motorista> motoristas) {
		this.motoristas = motoristas;
	}

	public ArrayList<UsuarioAdministrativo> getUsuariosAdministrativos() {
		if(usuariosAdministrativos==null){
			setUsuariosAdministrativos(new ArrayList<UsuarioAdministrativo>());
		}
		return usuariosAdministrativos;
	}

	public void setUsuariosAdministrativos(
			ArrayList<UsuarioAdministrativo> usuariosAdministrativos) {
		this.usuariosAdministrativos = usuariosAdministrativos;
	}

	public ArrayList<ConviteEnviado> getConvitesEnviadosPendentes() {
		if(convitesEnviadosPendentes==null){
			setConvitesEnviadosPendentes(new ArrayList<ConviteEnviado>());
		}
		return convitesEnviadosPendentes;
	}

	public void setConvitesEnviadosPendentes(
			ArrayList<ConviteEnviado> convitesEnviadosPendentes) {
		this.convitesEnviadosPendentes = convitesEnviadosPendentes;
	}

	public ArrayList<ConviteRecebido> getConvitesRecebidosPendentes() {
		if(convitesRecebidosPendentes==null){
			setConvitesRecebidosPendentes(new ArrayList<ConviteRecebido>());
		}
		return convitesRecebidosPendentes;
	}

	public void setConvitesRecebidosPendentes(
			ArrayList<ConviteRecebido> convitesRecebidosPendentes) {
		this.convitesRecebidosPendentes = convitesRecebidosPendentes;
	}

	@Override
 	public String getResumo(){
     	StringBuilder b=new StringBuilder();
     	PadraoItemResumo p = PadraoItemResumo.get();
     	
     	p.gerarItem(b, "Dados Compartilhados", meusDadosCompartilhados);
 		
 		return b.toString();
 	}



}
