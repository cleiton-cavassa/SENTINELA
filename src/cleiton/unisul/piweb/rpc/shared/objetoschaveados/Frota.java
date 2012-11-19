package cleiton.unisul.piweb.rpc.shared.objetoschaveados;

import java.util.ArrayList;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.acessorios.PadraoItemResumo;

@SuppressWarnings("serial")
public class Frota implements ObjetoChaveado{
	
	@Persistent
    ArrayList<CorridaCancelada> corridasCanceladas;
	
	@Persistent
	ArrayList<CorridaFinalizada> corridasFinalizadas;
	
	@Persistent
	ArrayList<CorridaSolicitada> corridasSolicitadas;
	
	@Persistent
	ArrayList<FrotaDadosCompartilhados> frotasParceirasForaDaRede;
	
//	@Persistent
//	ArrayList<Object> frotasParceirasNaRede;
	
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
	
//	@PrimaryKey
//    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
//	private Object chave;
	

	
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



//	public ArrayList<Object> getFrotasParceirasNaRede() {
//		return frotasParceirasNaRede;
//	}
//
//
//
//	public void setFrotasParceirasNaRede(ArrayList<Object> frotasParceirasNaRede) {
//		this.frotasParceirasNaRede = frotasParceirasNaRede;
//	}



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


//
//	public Object getChave() {
//		return chave;
//	}
//
//
//
//	public void setChave(Object chave) {
//		this.chave = chave;
//	}



	@Override
 	public String getResumo(){
     	StringBuilder b=new StringBuilder();
     	PadraoItemResumo p = PadraoItemResumo.get();
     	
     	p.gerarItem(b, "Dados Compartilhados", meusDadosCompartilhados);
 		
 		return b.toString();
 	}



}