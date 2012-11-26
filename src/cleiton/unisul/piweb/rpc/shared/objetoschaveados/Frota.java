package cleiton.unisul.piweb.rpc.shared.objetoschaveados;

import java.util.ArrayList;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.acessorios.PadraoItemResumo;

@SuppressWarnings("serial")
@PersistenceCapable
public class Frota implements ObjetoChaveado{
	
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
	
	@Persistent//chave codificada
	ArrayList<String> frotasParceirasNaRede;
	
	@Persistent
	FrotaDadosCompartilhados meusDadosCompartilhados;
	
	@Persistent
	ArrayList<Motorista> motoristas;
	
	@Persistent
	ArrayList<UsuarioAdministrativo> usuariosAdministrativos;
	
	@Persistent
	ArrayList<ConviteRecebido> convitesEnviadosPendentes;
	
	@Persistent
	ArrayList<ConviteRecebido> convitesRecebidosPendentes;

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public ArrayList<CorridaCancelada> getCorridasCanceladas() {
		return corridasCanceladas;
	}

	public void setCorridasCanceladas(ArrayList<CorridaCancelada> corridasCanceladas) {
		this.corridasCanceladas = corridasCanceladas;
	}

	public ArrayList<CorridaFinalizada> getCorridasFinalizadas() {
		return corridasFinalizadas;
	}

	public void setCorridasFinalizadas(
			ArrayList<CorridaFinalizada> corridasFinalizadas) {
		this.corridasFinalizadas = corridasFinalizadas;
	}

	public ArrayList<CorridaSolicitada> getCorridasSolicitadas() {
		return corridasSolicitadas;
	}

	public void setCorridasSolicitadas(
			ArrayList<CorridaSolicitada> corridasSolicitadas) {
		this.corridasSolicitadas = corridasSolicitadas;
	}

	public ArrayList<FrotaDadosCompartilhados> getFrotasParceirasForaDaRede() {
		return frotasParceirasForaDaRede;
	}

	public void setFrotasParceirasForaDaRede(
			ArrayList<FrotaDadosCompartilhados> frotasParceirasForaDaRede) {
		this.frotasParceirasForaDaRede = frotasParceirasForaDaRede;
	}

	public ArrayList<String> getFrotasParceirasNaRede() {
		return frotasParceirasNaRede;
	}

	public void setFrotasParceirasNaRede(ArrayList<String> frotasParceirasNaRede) {
		this.frotasParceirasNaRede = frotasParceirasNaRede;
	}

	public FrotaDadosCompartilhados getMeusDadosCompartilhados() {
		return meusDadosCompartilhados;
	}

	public void setMeusDadosCompartilhados(
			FrotaDadosCompartilhados meusDadosCompartilhados) {
		this.meusDadosCompartilhados = meusDadosCompartilhados;
	}

	public ArrayList<Motorista> getMotoristas() {
		return motoristas;
	}

	public void setMotoristas(ArrayList<Motorista> motoristas) {
		this.motoristas = motoristas;
	}

	public ArrayList<UsuarioAdministrativo> getUsuariosAdministrativos() {
		return usuariosAdministrativos;
	}

	public void setUsuariosAdministrativos(
			ArrayList<UsuarioAdministrativo> usuariosAdministrativos) {
		this.usuariosAdministrativos = usuariosAdministrativos;
	}

	public ArrayList<ConviteRecebido> getConvitesEnviadosPendentes() {
		return convitesEnviadosPendentes;
	}

	public void setConvitesEnviadosPendentes(
			ArrayList<ConviteRecebido> convitesEnviadosPendentes) {
		this.convitesEnviadosPendentes = convitesEnviadosPendentes;
	}

	public ArrayList<ConviteRecebido> getConvitesRecebidosPendentes() {
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
