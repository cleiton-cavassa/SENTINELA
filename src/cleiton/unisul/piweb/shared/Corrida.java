package cleiton.unisul.piweb.shared;
import java.io.Serializable;
import java.util.Date;

import java.util.List;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;


@PersistenceCapable
public class Corrida  implements Serializable {
	
	@Persistent
	private String clienteId;
	
	@Persistent
	private Date horarioEmbarque;
	
	@Persistent
	private String localEmbarque;
	
}
