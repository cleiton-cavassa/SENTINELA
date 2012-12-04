package cleiton.unisul.piweb.rpc.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;

public class BotaoLogout extends Button {

	
	public BotaoLogout(String texto){
		super(texto);
		setStyleName("botaoLogout");
		addClickHandler(new SairClickHandler());
	}
	
	public class SairClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			ServicoUsuario.getGreetingService().urlLogout("", new AsyncCallback<String>() {
				@Override
				public void onFailure(Throwable caught) {
					caught.printStackTrace();
				}
				@Override
				public void onSuccess(String result) {
					Window.Location.assign(result);
				}
			});
		}
	}

}
