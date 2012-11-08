package cleiton.unisul.piweb.server;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

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
import cleiton.unisul.piweb.shared.Usuario;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class ArmazenamentoImpl extends RemoteServiceServlet implements Armazenamento{
	PersistenceManager pm(){return PMF.get().getPersistenceManager();}
	
	@Override
	public Boolean persistir(ClientePF obj){return persiste(obj);}
	@Override
	public Boolean persistir(ClientePJ obj){return persiste(obj);}
	@Override
	public Boolean persistir(Corrida obj){return persiste(obj);}
	@Override
	public Boolean persistir(CorridaAtendida obj){return persiste(obj);}
	@Override
	public Boolean persistir(CorridaCancelada obj){return persiste(obj);}
	@Override
	public Boolean persistir(CorridaMarcada obj){return persiste(obj);}
	@Override
	public Boolean persistir(Frota obj){return persiste(obj);}
	@Override
	public Boolean persistir(Motorista obj){return persiste(obj);}

	
	@Override
	public List<ClientePF> recuperar(ClientePF exemplo){return recupera(exemplo);}
	@Override
	public List<ClientePJ> recuperar(ClientePJ exemplo){return recupera(exemplo);}
	@Override
	public List<Corrida> recuperar(Corrida exemplo){return recupera(exemplo);}
	@Override
	public List<CorridaAtendida> recuperar(CorridaAtendida exemplo){return recupera(exemplo);}
	@Override
	public List<CorridaCancelada> recuperar(CorridaCancelada exemplo){return recupera(exemplo);}
	@Override
	public List<CorridaMarcada> recuperar(CorridaMarcada exemplo){return recupera(exemplo);}
	@Override
	public List<Expediente> recuperar(Expediente exemplo){return recupera(exemplo);}
	@Override
	public List<Frota> recuperar(Frota exemplo){return recupera(exemplo);}
	@Override
	public List<Motorista> recuperar(Motorista exemplo){return recupera(exemplo);}
	@Override
	public List<Usuario> recuperar(Usuario exemplo){return recupera(exemplo);}
	
	
	private Boolean persiste(Object objeto){
	    boolean resultado;
	    PersistenceManager pm = pm();
		try {
			pm.makePersistent(objeto);
			resultado=true;	
		}catch(Throwable t){
			resultado=false;
		}finally {
			pm.close();
		}
		return resultado;
	}
	
	@SuppressWarnings("unchecked")
	public <T extends Object> List<T> recupera(T exemplo){
		//Query q = pm.newQuery(exemplo.getClass());
	    PersistenceManager pm = pm();
		Query q   = pm.newQuery("select from "+exemplo.getClass().getName());
		
		List<T> a=null;
		
		try {
			a= (List<T>)q.execute();

		}catch(Throwable t){
			throw new RuntimeException("Problemas na consulta:\n"+t.getLocalizedMessage()+"\n"+t.getMessage());
		} finally {
			q.closeAll();
		}
		if (a==null){
			return null;
		}else{
			return (List<T>) pm.detachCopyAll(a);			
		}
	}
}
