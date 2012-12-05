package cleiton.unisul.piweb.rpc.server;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import cleiton.unisul.piweb.rpc.client.Armazenamento;
import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.ClientePF;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.ClientePJ;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.CorridaCancelada;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.CorridaFinalizada;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.CorridaSolicitada;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.Frota;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.FrotaDadosCompartilhados;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.Motorista;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.ParChaveDescricao;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.UsuarioAdministrativo;
import cleiton.unisul.piweb.rpc.shared.respostasdeconsulta.FrotaECredenciais;
import cleiton.unisul.piweb.rpc.shared.respostasdeconsulta.RespostaLoginUsuarioAdministrativo;
import cleiton.unisul.piweb.rpc.shared.respostasdeconsulta.RespostaPersistencia;
import cleiton.unisul.piweb.rpc.shared.respostasdeconsulta.Usuario;

import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Transaction;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;


@SuppressWarnings("serial")
public class ArmazenamentoImpl extends RemoteServiceServlet implements Armazenamento{
	
	UserService userService = UserServiceFactory.getUserService();
	User user = userService.getCurrentUser();

//	@Override
//	public <T extends ObjetoChaveado> ParChaveDescricao pessoaPorCPF(T exemplo, long CPF) {
//		PersistenceManager pm = pm();
//		consulta(pm, "select from "+exemplo.getClass().getName()+"where ")
//		
//		pm.close();
//		return null;
//	}
	
	PersistenceManager pm(){
		return PMF.get().getPersistenceManager();
	}
	
	@Override 
	public <T extends ObjetoChaveado> RespostaPersistencia persistir(T obj,Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado, String chavePai)throws Exception{return persiste(obj, novoRegistro, salvarMesmoSeNaoOcorrerOEsperado, chavePai);}
	@Override 
	public <T extends ObjetoChaveado> List<T> recuperar(T exemplo, String chavePai) throws Exception{ return recupera(exemplo, chavePai); }
	@Override 
	public <T extends ObjetoChaveado> List<T> recuperar(T exemplo, String chavePai, String nomeOuNroDocumento) throws Exception{return null;}//{return recupera(exemplo, nomeOuNroDocumento);}
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
	
	
	private <T extends ObjetoChaveado>T acessoPermitidoAoObjeto (T objeto, String chavePai){
		//Implementar depois. Questão de segurança. 
		return null;
	}
	
	private <T extends ObjetoChaveado>RespostaPersistencia persiste(T objeto, Boolean novoRegistro, Boolean salvarMesmoSeNaoOcorrerOEsperado, String chavePai)throws Exception{
//		if ( !(acessoPermitidoAoObjeto(objeto, chavePai)) ){
//			throw new RuntimeException("Sem acesso ao objeto. Faltam credenciais de segurança.");
//		}
		
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
				pm.getObjectById(objeto.getClass(), KeyFactory.stringToKey(objeto.getChave()));
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
	
//	private String nomeCampo(ObjetoChaveado exemplo, boolean StringDicaeNumero){
//		return null;
//	}

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
	
	public <T extends Object> List<T> recupera(T exemplo, String chavePai) throws Exception{
		if(chavePai==null){
			return consultaLista("select from "+exemplo.getClass().getName());
		}else{
			return consultaLista("select from "+exemplo.getClass().getName()+" where chavePai == '"+chavePai+"'");			
		}
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
	public RespostaLoginUsuarioAdministrativo acharFrotas(){
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
		RespostaLoginUsuarioAdministrativo r = new RespostaLoginUsuarioAdministrativo();
			r.setFrotasEcredenciais(result);
			r.setUsuario(new Usuario(
						user.getEmail(),
						user.getUserId(),
						user.getNickname(),
						user.getAuthDomain(),
						userService.isUserAdmin()
					));
		return r;
	}

	
	
	private Frota pegarFrota(PersistenceManager pm, String chavePai){
		Frota buf;
		Frota result=null;
		try{
			buf = pm.getObjectById(Frota.class, KeyFactory.stringToKey(chavePai));
		}catch(Throwable t){
			t.printStackTrace();
			return null;
		}
		for(UsuarioAdministrativo usu : buf.getUsuariosAdministrativos()){
			if (user.getEmail().equals(usu.getDadosUsuarioAdministrativo().getEmail())){
				result=buf;
			}
		}
		return result;
	}
	

	
	public RespostaPersistencia cria(ClientePF objeto, String chavePai) {
		PersistenceManager pm=pm();
		pm.getFetchPlan().addGroup("clientePF");
		pm.getFetchPlan().setMaxFetchDepth(-1);
		Frota f = pegarFrota(pm, chavePai);
		
		if(f==null){
			new Exception("Frota não encontrada para o id "+chavePai).printStackTrace();
			return null;
		}
		
		boolean result = f.getMeusDadosCompartilhados().getClientesPF().add(objeto);
		
		if (result){
			try {
				pm.makePersistent(f);
			} catch (Exception e) {
				new Exception("Falha durante a persistência:\n"+e.getMessage()).printStackTrace();
				result=false;
				e.printStackTrace();
			}
		}else{
			new Exception("A chave já existe!!"+chavePai);
		}
		pm.close();
		RespostaPersistencia r = new RespostaPersistencia();
				r.setOperacaoBemSucedida(result);
		return r; 
		
	}

	public RespostaPersistencia cria(ClientePJ objeto, String chavePai) {
		PersistenceManager pm=pm();
		pm.getFetchPlan().addGroup("clientePJ");
		pm.getFetchPlan().setMaxFetchDepth(-1);
		Frota f = pegarFrota(pm, chavePai);
		
		if(f==null){
			return null;
		}
		
		boolean result = f.getMeusDadosCompartilhados().getClientesPJ().add(objeto);
		
		if (result){
			try {
				pm.makePersistent(f);
			} catch (Exception e) {
				result=true;
				e.printStackTrace();
			}
		}
		pm.close();
		
		RespostaPersistencia r = new RespostaPersistencia();
			r.setOperacaoBemSucedida(result);
		return r; 
	}

	public RespostaPersistencia cria(CorridaSolicitada objeto, String chavePai) {
		PersistenceManager pm=pm();
		pm.getFetchPlan().addGroup("corridaSolicitada");
		pm.getFetchPlan().setMaxFetchDepth(-1);
		Frota f = pegarFrota(pm, chavePai);
		
		if(f==null){
			return null;
		}
		
		boolean result = f.getCorridasSolicitadas().add(objeto);
		
		if (result){
			try {
				pm.makePersistent(f);
			} catch (Exception e) {
				result=true;
				e.printStackTrace();
			}
		}
		pm.close();
		
		RespostaPersistencia r = new RespostaPersistencia();
			r.setOperacaoBemSucedida(result);
		return r; 
	}

	public RespostaPersistencia cria(CorridaCancelada objeto, String chavePai) {
		
		CorridaSolicitada a = objeto.getCorridaSolicitada();
		
		CorridaSolicitada c= new CorridaSolicitada();
			ParChaveDescricao<ClientePF> cli = new ParChaveDescricao<ClientePF>();
			ParChaveDescricao<ClientePF> b = a.getCliente();
				cli.setChaveObjeto(b.getChaveObjeto());
				cli.setDescricao(b.getDescricao());
				cli.setCopiaObjeto(b.getCopiaObjeto());
			c.setCliente(cli);
			c.setDataHoraEmbarque(a.getDataHoraEmbarque());
			c.setLocalEmbarque(a.getLocalEmbarque());
			c.setLocalPrevisaoDesembarque(a.getLocalPrevisaoDesembarque());
			c.setStatus(CorridaSolicitada.Status.CANCELADA);

			ParChaveDescricao<Motorista> mot = new ParChaveDescricao<Motorista>();
			ParChaveDescricao<Motorista> z = a.getMotorista();
				mot.setChaveObjeto(z.getChaveObjeto());
				mot.setDescricao(z.getDescricao());
				mot.setCopiaObjeto(z.getCopiaObjeto());
			c.setMotorista(mot);
			c.setObservacao(a.getObservacao());
			
		objeto.setCorridaSolicitada(c);
		
		
		PersistenceManager pm=pm();
		pm.getFetchPlan().addGroup("corridasCanceladas");

		boolean result =true;

		CorridaSolicitada d = pm.getObjectById(CorridaSolicitada.class, KeyFactory.stringToKey(a.getChave()));
			
			try {
					pm.deletePersistent(d);
				} catch (Exception e) {
					result=false;
					new Exception("BBBBBBBBB").printStackTrace();
					e.printStackTrace();
					throw new RuntimeException();
				}

				Frota f = pegarFrota(pm, chavePai);
				if(f==null){
					return null;
				}

				
				f.getCorridasCanceladas().add(objeto);
				
			try {
				pm.makePersistent(f);
			} catch (Exception e) {
				new Exception("AAAA").printStackTrace();
				result=false;
				e.printStackTrace();
			}
		
		pm.close();
		

		
		RespostaPersistencia r = new RespostaPersistencia();
			r.setOperacaoBemSucedida(result);
		return r; 
	}

	public RespostaPersistencia cria(CorridaFinalizada objeto, String chavePai) {
		CorridaSolicitada a = objeto.getCorridaSolicitada();
		
		CorridaSolicitada c= new CorridaSolicitada();
			ParChaveDescricao<ClientePF> cli = new ParChaveDescricao<ClientePF>();
			ParChaveDescricao<ClientePF> b = a.getCliente();
				cli.setChaveObjeto(b.getChaveObjeto());
				cli.setDescricao(b.getDescricao());
				cli.setCopiaObjeto(b.getCopiaObjeto());
			c.setCliente(cli);
			c.setDataHoraEmbarque(a.getDataHoraEmbarque());
			c.setLocalEmbarque(a.getLocalEmbarque());
			c.setLocalPrevisaoDesembarque(a.getLocalPrevisaoDesembarque());
			c.setStatus(CorridaSolicitada.Status.CANCELADA);

			ParChaveDescricao<Motorista> mot = new ParChaveDescricao<Motorista>();
			ParChaveDescricao<Motorista> z = a.getMotorista();
				mot.setChaveObjeto(z.getChaveObjeto());
				mot.setDescricao(z.getDescricao());
				mot.setCopiaObjeto(z.getCopiaObjeto());
			c.setMotorista(mot);
			c.setObservacao(a.getObservacao());
			
		objeto.setCorridaSolicitada(c);
		
		
		PersistenceManager pm=pm();
		pm.getFetchPlan().addGroup("corridasFinalizadas");

		boolean result =true;

		CorridaSolicitada d = pm.getObjectById(CorridaSolicitada.class, KeyFactory.stringToKey(a.getChave()));
			
			try {
					pm.deletePersistent(d);
				} catch (Exception e) {
					result=false;
					new Exception("BBBBBBBBB").printStackTrace();
					e.printStackTrace();
					throw new RuntimeException();
				}

				Frota f = pegarFrota(pm, chavePai);
				if(f==null){
					return null;
				}

				
				f.getCorridasFinalizadas().add(objeto);
				
			try {
				pm.makePersistent(f);
			} catch (Exception e) {
				new Exception("AAAA").printStackTrace();
				result=false;
				e.printStackTrace();
			}
		
		pm.close();
		

		
		RespostaPersistencia r = new RespostaPersistencia();
			r.setOperacaoBemSucedida(result);
		return r; 
//		PersistenceManager pm=pm();
//		pm.getFetchPlan().addGroup("corridasFinalizadas");
//		pm.getFetchPlan().setMaxFetchDepth(-1);
//		Frota f = pegarFrota(pm, chavePai);
//		
//		if(f==null){
//			return null;
//		}
//		
//		boolean result =true;
//		
//
//			result &= f.getCorridasFinalizadas().add(objeto);
//			result &= f.getCorridasSolicitadas().remove(objeto.getCorridaSolicitada());
//			
//		if (result){
//			try {
//				pm.deletePersistent(objeto.getCorridaSolicitada());
//			} catch (Exception e) {
//				result=false;
//				e.printStackTrace();
//			}
//		}
//			
//			objeto.getCorridaSolicitada().setChave(null);
//		
//		if (result){
//			try {
//				pm.makePersistent(f);
//			} catch (Exception e) {
//				result=false;
//				e.printStackTrace();
//			}
//		}
//		pm.close();
//		
//		RespostaPersistencia r = new RespostaPersistencia();
//			r.setOperacaoBemSucedida(result);
//		return r; 
	}

	public RespostaPersistencia cria(Motorista objeto, String chavePai) {
		PersistenceManager pm=pm();
		pm.getFetchPlan().addGroup("Motorista");
		pm.getFetchPlan().setMaxFetchDepth(-1);
		Frota f = pegarFrota(pm, chavePai);
		
		if(f==null){
			return null;
		}
		
		boolean result =true;
			result &= f.getMotoristas().add(objeto);
		
		if (result){
			try {
				pm.makePersistent(f);
			} catch (Exception e) {
				result=true;
				e.printStackTrace();
			}
		}
		pm.close();
		
		RespostaPersistencia r = new RespostaPersistencia();
			r.setOperacaoBemSucedida(result);
		return r; 
	}
	
	
	
	public RespostaPersistencia cria(FrotaDadosCompartilhados objeto, String chavePai) {
		PersistenceManager pm=pm();
		pm.getFetchPlan().addGroup("dadosCompartilhados");
		pm.getFetchPlan().setMaxFetchDepth(-1);
		Frota f = pegarFrota(pm, chavePai);
		
		if(f==null){
			return null;
		}
		
		boolean result =true;
			result &= f.getFrotasParceirasForaDaRede().add(objeto);
		
		if (result){
			try {
				pm.makePersistent(f);
			} catch (Exception e) {
				result=true;
				e.printStackTrace();
			}
		}
		pm.close();
		
		RespostaPersistencia r = new RespostaPersistencia();
			r.setOperacaoBemSucedida(result);
		return r; 
	}
	
	@Override
	public RespostaPersistencia criar(ObjetoChaveado objeto, String chavePai) {
		
		try{ return cria((ClientePF)objeto,chavePai); }catch(Throwable t){}
		
		try{ return cria((ClientePJ)objeto,chavePai); }catch(Throwable t){}
		
		try{ return cria((Motorista)objeto,chavePai); }catch(Throwable t){}
		
		try{ return cria((CorridaSolicitada)objeto,chavePai); }catch(Throwable t){}
		
		try{ return cria((CorridaCancelada)objeto,chavePai); }catch(Throwable t){t.printStackTrace();}
		
		try{ return cria((CorridaFinalizada)objeto,chavePai); }catch(Throwable t){}
		
		try{ return cria((FrotaDadosCompartilhados)objeto,chavePai); }catch(Throwable t){}
		
		RespostaPersistencia r = new RespostaPersistencia();
			r.setOperacaoBemSucedida(false);	
		new Exception("A operação de criação ainda não é suportada por esse método, para esse tipo de objeto.").printStackTrace();
		
		return r;
	}

	
	
	private Frota recuperarFrota(PersistenceManager pm, String minhaChave){
		Frota buf;
		try{
			buf = pm.getObjectById(Frota.class, KeyFactory.stringToKey(minhaChave));
		}catch(Throwable t){
			t.printStackTrace();
			return null;
		}
		return buf;
	}
	
	@Override
	public FrotaDadosCompartilhados recuperarMeusDadosCompartilhados(
			String minhaChave) {
		PersistenceManager pm = pm();
		pm.getFetchPlan().addGroup("dadosCompartilhados");
		pm.getFetchPlan().setMaxFetchDepth(-1);
		
		Frota f =recuperarFrota(pm, minhaChave);
		if (f==null){
			return null;
		}
		
		return pm.detachCopy(f.getMeusDadosCompartilhados());
	}

	@Override
	public List<FrotaDadosCompartilhados> recuperarDadosParceirosForaDaRede(
			String minhaChave) {
		PersistenceManager pm = pm();
		pm.getFetchPlan().addGroup("dadosCompartilhados");
		pm.getFetchPlan().setMaxFetchDepth(-1);
		
		Frota f =recuperarFrota(pm, minhaChave);
		if (f==null){
			return null;
		}
		return (List<FrotaDadosCompartilhados>)(pm.detachCopyAll(f.getFrotasParceirasForaDaRede()));
	}



//	@Override
//	public boolean criar(ConviteEnviado objeto, String chavePai) {
//		PersistenceManager pm=pm();
//		pm.getFetchPlan().addGroup("corridaCancelada");
//		pm.getFetchPlan().setMaxFetchDepth(-1);
//		Frota f = pegarFrota(pm, chavePai);
//		
//		if(f==null){
//			return false;
//		}
//
//		boolean result =true;
//			result &= f.getConvitesEnviadosPendentes().add(objeto);
//			//completar com o código que verifica se existe frota com o CNPJ informado, e cadastra o convite em sua lista de convites pendentes, se for o caso.
//		
//		if (result){
//			try {
//				pm.makePersistent(f);
//			} catch (Exception e) {
//				result=true;
//				e.printStackTrace();
//			}
//		}
//		pm.close();
//		
//		return result;
//	}

	
	
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
//				pj.setRazaoSocial("Ainda não existe pessoa jurídica com esse CNPJ cadastrada na base de dados");
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
