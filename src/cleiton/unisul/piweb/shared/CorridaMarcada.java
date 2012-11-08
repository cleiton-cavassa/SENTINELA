package cleiton.unisul.piweb.shared;


import java.io.Serializable;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
public class CorridaMarcada  implements Serializable {
	
	@Persistent
	private Corrida Corrida;
	
	@Persistent
	private String motorista;

}
