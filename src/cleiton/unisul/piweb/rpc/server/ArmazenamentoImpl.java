package cleiton.unisul.piweb.rpc.server;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import cleiton.unisul.piweb.rpc.client.Armazenamento;
import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;
import cleiton.unisul.piweb.rpc.shared.RespostaPersistencia;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;


@SuppressWarnings("serial")
public class ArmazenamentoImpl extends RemoteServiceServlet implements Armazenamento{
	PersistenceManager pm(){

		return PMF.get().getPersistenceManager();
		}
	
	@Override 
	public <T extends ObjetoChaveado> RespostaPersistencia persistir(T obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado)throws Exception{return persiste(obj, novoRegistro, salvarMesmoSeNaoOcorrerOEsperado);}
	@Override 
	public <T extends ObjetoChaveado> List<T> recuperar(T exemplo) throws Exception{return recupera(exemplo);}
	@Override
	public <T extends ObjetoChaveado>RespostaPersistencia excluir(T obj){return exclui(obj);}

	
	private RespostaPersistencia exclui(ObjetoChaveado obj){
		
		
		PersistenceManager pm=pm();
		RespostaPersistencia resultado=new RespostaPersistencia();
		
		Boolean conformeEsperado=null;
		Boolean objetoJaExiste=null;
		Boolean salvoComSucesso=null;
			try {
				pm.deletePersistent(obj);
				salvoComSucesso=true;
			}catch(Throwable t){
				salvoComSucesso=false;
				throw new RuntimeException("AAAAA"+t.getMessage());
			}finally {
				pm.close();
			}
		resultado.setIdObjetoJaExistia(objetoJaExiste);
		resultado.setObjetoConformeEsperado(conformeEsperado);
		resultado.setOperacaoBemSucedida(salvoComSucesso);
		return resultado;
	}
	
//	@Override
//	public List<ClientesPFePJ> montarLista(ClientesPFePJ exemplo) throws Exception{
//		List<ClientePF> pfs = recupera(new ClientePF());
//		
//		//this.getThreadLocalRequest().getSession().setAttribute("FrotaModeloAntigo", new FrotaModeloAntigo());
//		
//		LinkedList<ClientesPFePJ> resposta= new LinkedList<ClientesPFePJ>(); 
//		PersistenceManager pm = pm();
//		for(ClientePF pf:pfs){
//			ClientePJ pj;
//			boolean PJexisteNoBD=true;
//			try{
//				pj=(ClientePJ)pm.getObjectById(new LongIdentity(ClientePJ.class, pf.getPJVinculada()));
//			}catch(Throwable t){
//				
//				pj=new ClientePJ();
//				pj.setChave(pf.getPJVinculada());
//				pj.setRazaoSocial("Ainda n�o existe pessoa jur�dica com esse CNPJ cadastrada na base de dados");
//				PJexisteNoBD=false;
//			}
//			ClientesPFePJ resp = new ClientesPFePJ();
//				resp.setClientePF(pf);
//				resp.setClientePJ(pj);
//				resp.setPJexisteNaBaseDeDados(PJexisteNoBD);
//			resposta.add(resp);
//		}
//		return resposta;
//	}
	
	private <T extends ObjetoChaveado>RespostaPersistencia persiste(T objeto, Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado)throws Exception{
		PersistenceManager pm=pm();
		RespostaPersistencia resultado=new RespostaPersistencia();
		
		Boolean conformeEsperado=null;
		Boolean objetoJaExiste=null;
		Boolean salvoComSucesso=null;
		
		
		
		if (objeto.getChave()==null){
			objetoJaExiste=false;
			conformeEsperado=novoRegistro;
		}else{
			try{
	//			pm.getObjectById(new LongIdentity(objeto.getClass(), objeto.getChave()));
				pm.getObjectById(objeto.getChave());
				objetoJaExiste=true;
				conformeEsperado=!novoRegistro;
			}catch(javax.jdo.JDOObjectNotFoundException t){
				objetoJaExiste=false;
				conformeEsperado=novoRegistro;
			}catch(Throwable t){
				throw new java.lang.Exception("BBBBB"+t.getMessage());
			}
		}
		if((salvarMesmoSeNaoOcorrerOEsperado.booleanValue())||(conformeEsperado==null?false:conformeEsperado.booleanValue())){
			try {
				pm.makePersistent(objeto);
				salvoComSucesso=true;
			}catch(Throwable t){
				salvoComSucesso=false;
				throw new java.lang.Exception("AAAAA"+t.getMessage());
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
		List<T> result;
	    PersistenceManager pm = pm();
		pm.getFetchPlan().addGroup("grupo");
		pm.getFetchPlan().setMaxFetchDepth(-1);
//		pm.getFetchPlan().setFetchSize(FetchPlan.FETCH_SIZE_GREEDY);
		
		List<T> a=(List<T>)consulta(pm, "select from "+exemplo.getClass().getName());
		if (a==null){
			result=null;
		}else{
			result = (List<T>) pm.detachCopyAll(a);			
		}
		
		pm.close();
		return result;
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
//	public RespostaPersistencia persistir(CorridaAgendada obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado){return persiste(obj, novoRegistro, salvarMesmoSeNaoOcorrerOEsperado);}
//	@Override
//	public RespostaPersistencia persistir(FrotaModeloAntigo obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado){return persiste(obj, novoRegistro, salvarMesmoSeNaoOcorrerOEsperado);}
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
//	public List<CorridaAgendada> recuperar(CorridaAgendada exemplo)throws Exception{return recupera(exemplo);}
//	@Override
//	public List<Expediente> recuperar(Expediente exemplo)throws Exception{return recupera(exemplo);}
//	@Override
//	public List<FrotaModeloAntigo> recuperar(FrotaModeloAntigo exemplo)throws Exception{return recupera(exemplo);}
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
