package cleiton.unisul.piweb.server;

import java.util.LinkedList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.identity.LongIdentity;

import cleiton.unisul.piweb.client.Armazenamento;
import cleiton.unisul.piweb.shared.ClientePF;
import cleiton.unisul.piweb.shared.ClientePJ;
import cleiton.unisul.piweb.shared.Corrida;
import cleiton.unisul.piweb.shared.CorridaAtendida;
import cleiton.unisul.piweb.shared.CorridaCancelada;
import cleiton.unisul.piweb.shared.CorridaMarcada;
import cleiton.unisul.piweb.shared.Expediente;
import cleiton.unisul.piweb.shared.Frota;
import cleiton.unisul.piweb.shared.Motorista;
import cleiton.unisul.piweb.shared.ClientesPFePJ;
import cleiton.unisul.piweb.shared.ObjetoChaveado;
import cleiton.unisul.piweb.shared.ObjetoChaveado.RespostaPersistencia;
import cleiton.unisul.piweb.shared.Usuario;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class ArmazenamentoImpl extends RemoteServiceServlet implements Armazenamento{
	PersistenceManager pm(){return PMF.get().getPersistenceManager();}
	
	@Override 
	public <T extends ObjetoChaveado> RespostaPersistencia persistir(T obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado){return persiste(obj, novoRegistro, salvarMesmoSeNaoOcorrerOEsperado);}
	@Override 
	public <T> List<T> recuperar(T exemplo) throws Exception{return recupera(exemplo);}
	

	
	@Override
	public List<ClientesPFePJ> montarLista(ClientesPFePJ exemplo) throws Exception{
		List<ClientePF> pfs = recupera(new ClientePF());
		
		LinkedList<ClientesPFePJ> resposta= new LinkedList<ClientesPFePJ>(); 
		PersistenceManager pm = pm();
		for(ClientePF pf:pfs){
			ClientePJ pj;
			boolean PJexisteNoBD=true;
			try{
				pj=(ClientePJ)pm.getObjectById(new LongIdentity(ClientePJ.class, pf.getPJVinculada()));
			}catch(Throwable t){
				
				pj=new ClientePJ();
				pj.setChave(pf.getPJVinculada());
				pj.setRazaoSocial("Ainda n‹o existe pessoa jur’dica com esse CNPJ cadastrada na base de dados");
				PJexisteNoBD=false;
			}
			ClientesPFePJ resp = new ClientesPFePJ();
				resp.setClientePF(pf);
				resp.setClientePJ(pj);
				resp.setPJexisteNaBaseDeDados(PJexisteNoBD);
			resposta.add(resp);
		}
		return resposta;
	}
	
	private <T extends ObjetoChaveado>RespostaPersistencia persiste(T objeto, Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado){
		PersistenceManager pm=pm();
		RespostaPersistencia resultado=new RespostaPersistencia();
		
		Boolean conformeEsperado=null;
		Boolean objetoJaExiste=null;
		Boolean salvoComSucesso=null;
		try{
			pm.getObjectById(new LongIdentity(objeto.getClass(), objeto.getChave()));
			objetoJaExiste=true;
			conformeEsperado=!novoRegistro;
		}catch(javax.jdo.JDOObjectNotFoundException t){
			objetoJaExiste=false;
			conformeEsperado=novoRegistro;
		}catch(Throwable t){}
		
		if((salvarMesmoSeNaoOcorrerOEsperado.booleanValue())||(conformeEsperado.booleanValue())){
			try {
				pm.makePersistent(objeto);
				salvoComSucesso=true;
			}catch(Throwable t){
				salvoComSucesso=false;
			}finally {
				pm.close();
			}
		}else{
			
		}
		resultado.setIdObjetoJaExistia(objetoJaExiste);
		resultado.setObjetoConformeEsperado(conformeEsperado);
		resultado.setOperacaoBemSucedida(salvoComSucesso);
		return resultado;
	}
	

	
	@SuppressWarnings("unchecked")
	public <T extends Object> List<T> recupera(T exemplo) throws Exception{
	    PersistenceManager pm = pm();
		List<T> a=(List<T>)consulta(pm, "select from "+exemplo.getClass().getName());
		if (a==null){
			return null;
		}else{
			return (List<T>) pm.detachCopyAll(a);			
		}
	}
	
	private Object consulta(PersistenceManager pm, String consulta) throws Exception{
		Object result;
		Query q   = pm.newQuery(consulta);
		try {
			result= q.execute();
		}catch(Throwable t){
			throw new java.lang.Exception("Problemas na consulta:\n"+t.getLocalizedMessage()+"\n"+t.getMessage());
		} finally {
			q.closeAll();
		}
		return result;
	}

//	@Override
//	public RespostaPersistencia persistir(ClientePF obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado){return persiste(obj, novoRegistro, salvarMesmoSeNaoOcorrerOEsperado);}
//	@Override
//	public RespostaPersistencia persistir(ClientePJ obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado){return persiste(obj, novoRegistro, salvarMesmoSeNaoOcorrerOEsperado);}
//	@Override
//	public RespostaPersistencia persistir(Corrida obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado){return persiste(obj, novoRegistro, salvarMesmoSeNaoOcorrerOEsperado);}
//	@Override
//	public RespostaPersistencia persistir(CorridaAtendida obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado){return persiste(obj, novoRegistro, salvarMesmoSeNaoOcorrerOEsperado);}
//	@Override
//	public RespostaPersistencia persistir(CorridaCancelada obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado){return persiste(obj, novoRegistro, salvarMesmoSeNaoOcorrerOEsperado);}
//	@Override
//	public RespostaPersistencia persistir(CorridaMarcada obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado){return persiste(obj, novoRegistro, salvarMesmoSeNaoOcorrerOEsperado);}
//	@Override
//	public RespostaPersistencia persistir(Frota obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado){return persiste(obj, novoRegistro, salvarMesmoSeNaoOcorrerOEsperado);}
//	@Override
//	public RespostaPersistencia persistir(Motorista obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado){return persiste(obj, novoRegistro, salvarMesmoSeNaoOcorrerOEsperado);}

	
//	@Override
//	public List<ClientePF> recuperar(ClientePF exemplo)throws Exception{return recupera(exemplo);}
//	@Override
//	public List<ClientePJ> recuperar(ClientePJ exemplo)throws Exception{return recupera(exemplo);}
//	@Override
//	public List<Corrida> recuperar(Corrida exemplo)throws Exception{return recupera(exemplo);}
//	@Override
//	public List<CorridaAtendida> recuperar(CorridaAtendida exemplo)throws Exception{return recupera(exemplo);}
//	@Override
//	public List<CorridaCancelada> recuperar(CorridaCancelada exemplo)throws Exception{return recupera(exemplo);}
//	@Override
//	public List<CorridaMarcada> recuperar(CorridaMarcada exemplo)throws Exception{return recupera(exemplo);}
//	@Override
//	public List<Expediente> recuperar(Expediente exemplo)throws Exception{return recupera(exemplo);}
//	@Override
//	public List<Frota> recuperar(Frota exemplo)throws Exception{return recupera(exemplo);}
//	@Override
//	public List<Motorista> recuperar(Motorista exemplo)throws Exception{return recupera(exemplo);}
//	@Override 
//	public List<Usuario> recuperar(Usuario exemplo) throws Exception{return recupera(exemplo);}
//	public List<Usuario> recuperar(Usuario exemplo){try { return recupera(exemplo);}catch (Exception e) {throw new RuntimeException(e.getMessage());}}

//	private boolean persiste(Object objeto){
//	   
//		boolean resultado;
//	    PersistenceManager pm = pm();
//		try {
//			pm.makePersistent(objeto);
//			resultado=true;	
//		}catch(Throwable t){
//			resultado=false;
//		}finally {
//			pm.close();
//		}
//		return resultado;
//	}
}
