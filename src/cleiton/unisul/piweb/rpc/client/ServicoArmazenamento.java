package cleiton.unisul.piweb.rpc.client;



import com.google.gwt.core.client.GWT;

public class ServicoArmazenamento {
	
	
	
	
	private static ArmazenamentoAsync recuperador= GWT
			.create(Armazenamento.class);

	public static ArmazenamentoAsync getArmazenamento() {
		if (recuperador!=null){
			recuperador=GWT.create(Armazenamento.class);
		}
		return recuperador;
	}


}