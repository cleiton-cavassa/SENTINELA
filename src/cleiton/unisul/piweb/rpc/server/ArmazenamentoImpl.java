package cleiton.unisul.piweb.rpc.server;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import cleiton.unisul.piweb.rpc.client.Armazenamento;
import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;
import cleiton.unisul.piweb.rpc.shared.RespostaPersistencia;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.Frota;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.FrotaECredenciais;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.UsuarioAdministrativo;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;


@SuppressWarnings("serial")
public class ArmazenamentoImpl extends RemoteServiceServlet implements Armazenamento{
	
	UserService userService = UserServiceFactory.getUserService();
	User user = userService.getCurrentUser();



	
	public Frota obterFrota(){
		Frota result=null;
			try {
				result = (Frota)(getThreadLocalRequest().getAttribute("frota"));
			} catch (Throwable e) {
				e.printStackTrace();
			}
		return result;
	}
	
	PersistenceManager pm(){
		return PMF.get().getPersistenceManager();
	}
	
	@Override 
	public <T extends ObjetoChaveado> RespostaPersistencia persistir(T obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado)throws Exception{return persiste(obj, novoRegistro, salvarMesmoSeNaoOcorrerOEsperado);}
	@Override 
	public <T extends ObjetoChaveado> List<T> recuperar(T exemplo) throws Exception{ return recupera(exemplo); }
	@Override 
	public <T extends ObjetoChaveado> List<T> recuperar(T exemplo, String nomeOuNroDocumento) throws Exception{return null;}//{return recupera(exemplo, nomeOuNroDocumento);}
	@Override
	public <T extends ObjetoChaveado>RespostaPersistencia excluir(T obj){return exclui(obj);}

	
	private RespostaPersistencia exclui(ObjetoChaveado obj){
		
		PersistenceManager pm=pm();
		RespostaPersistencia resultado=new RespostaPersistencia();
		
		Boolean conformeEsperado=null;
		Boolean objetoJaExiste=null;
		Boolean excluidoComSucesso=null;
			try {
				pm.deletePersistent(obj);
				excluidoComSucesso=true;
			}catch(Throwable t){
				excluidoComSucesso=false;
				throw new RuntimeException("Falha ao excluir objeto"+t.getMessage());
			}finally {
				pm.close();
			}
		resultado.setIdObjetoJaExistia(objetoJaExiste);
		resultado.setObjetoConformeEsperado(conformeEsperado);
		resultado.setOperacaoBemSucedida(excluidoComSucesso);
		return resultado;
	}
	
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
				pm.getObjectById(objeto.getChave());
				objetoJaExiste=true;
				conformeEsperado=!novoRegistro;
			}catch(javax.jdo.JDOObjectNotFoundException t){
				objetoJaExiste=false;
				conformeEsperado=novoRegistro;
			}catch(Throwable t){
				t.printStackTrace();
				throw new RuntimeException("BBBBB"+t.getMessage());
			}
		}
		if((salvarMesmoSeNaoOcorrerOEsperado.booleanValue())||(conformeEsperado==null?false:conformeEsperado.booleanValue())){
			try {
				pm.makePersistent(objeto);
				salvoComSucesso=true;
			}catch(Throwable t){
				t.printStackTrace();
				salvoComSucesso=false;
				throw new RuntimeException("AAAAA"+t.getMessage());
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
	

//	public <T extends ObjetoChaveado> List<T> recupera(T exemplo, String nome) throws Exception{
//		boolean eNumero=true; 
//		try{		
//		Long.parseLong(nomeOuNroDocumento);
//		}catch(Throwable t){ eNumero=false;}
//		
//		return consultaLista("Select from "+exemplo.getClass().getName());
//		
//	}
//	
//	public <T extends ObjetoChaveado> List<T> recupera(T exemplo, long nroDocumento) throws Exception{
//		boolean eNumero=true; 
//		try{		
//		Long.parseLong(nomeOuNroDocumento);
//		}catch(Throwable t){ eNumero=false;}
//		
//		Query q = new Query();
//		
//		return consultaLista()
//		
//	}
//	
	
	private String nomeCampo(ObjetoChaveado exemplo, boolean StringDicaeNumero){
		return null;
	}

//	@SuppressWarnings("unchecked")
//	public <T extends Object> List<T> recupera(T exemplo) throws Exception{
//		
//		List<T> result;
//	    PersistenceManager pm = pm();
//		pm.getFetchPlan().addGroup("grupo");
//		pm.getFetchPlan().setMaxFetchDepth(-1);
////		pm.getFetchPlan().setFetchSize(FetchPlan.FETCH_SIZE_GREEDY);
//		
//		List<T> a=(List<T>)consulta(pm, "select from "+exemplo.getClass().getName());
//		if (a==null){
//			result=null;
//		}else{
//			result = (List<T>) pm.detachCopyAll(a);			
//		}
//		
//		pm.close();
//		return result;
//	}

//	public List<Frota> recupera(Frota exemplo) throws Exception{
//		return consultaLista("select from "+exemplo.getClass().getName());
//	}
//	
	
	public <T extends Object> List<T> recupera(T exemplo) throws Exception{
		return consultaLista("select from "+exemplo.getClass().getName());
	}
	
	
	@SuppressWarnings("unchecked")
	public <T> List<T> consultaLista(String consulta) throws Exception{
		List<T> result;
	    PersistenceManager pm = pm();
		pm.getFetchPlan().addGroup("grupo");
		pm.getFetchPlan().setMaxFetchDepth(-1);
//		pm.getFetchPlan().setFetchSize(FetchPlan.FETCH_SIZE_GREEDY);

		List<T> a=(List<T>)consulta(pm, consulta);
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
	
	private Object consulta(Query consulta) throws Exception{
		Object result;
		try {
			result= consulta.execute();
		}catch(Throwable t){
			throw new java.lang.Exception("Problemas na consulta:\n"+t.getLocalizedMessage()+"\n"+t.getMessage());
		} finally {
			consulta.closeAll();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FrotaECredenciais> acharFrotas(){
		PersistenceManager pm = pm();
		pm.getFetchPlan().addGroup("grupo");
		pm.getFetchPlan().setMaxFetchDepth(-1);
		
		Query f = pm.newQuery(Frota.class);
		List<Frota> frotas = null;
		
		try {	frotas = (List<Frota>)consulta(f);	} catch (Exception e1) {}
		
		if (frotas!=null){
			frotas=(List<Frota>)pm.detachCopyAll(frotas);
		}
		
		List<FrotaECredenciais> result=new ArrayList<FrotaECredenciais>();
		FrotaECredenciais buffer=null;
		
//		buscaFrotas:
		for(Frota o: frotas){
			
			for (UsuarioAdministrativo usu: o.getUsuariosAdministrativos()){
				if (user.getEmail().equals( usu.getDadosUsuarioAdministrativo().getEmail()) ){
					if (buffer==null){
						buffer=new FrotaECredenciais();
						buffer.setFrota(o);
					}
					buffer.getCredenciais().add(usu.getDadosUsuarioAdministrativo().getNivelAcesso());
				}	
//					break buscaFrotas;	
			}
			if (buffer!=null){
				result.add(buffer);
			}
			buffer=null;
		}
//		result=(List<FrotaECredenciais>)pm.detachCopyAll(result);
		result=(List<FrotaECredenciais>)result;
		pm.close();
		return result;
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
//				pj.setRazaoSocial("Ainda n‹o existe pessoa jur’dica com esse CNPJ cadastrada na base de dados");
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
	

}
