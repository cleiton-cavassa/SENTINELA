package cleiton.unisul.piweb.rpc.client;


import com.google.gwt.core.client.GWT;

public class ServicoUsuario {
	
	private static GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);	
	public static GreetingServiceAsync getGreetingService() {
		if (greetingService!=null){
			greetingService=GWT.create(GreetingService.class);
		}
		return greetingService;
	}
}
