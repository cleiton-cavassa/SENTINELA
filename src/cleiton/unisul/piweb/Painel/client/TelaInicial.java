package cleiton.unisul.piweb.Painel.client;

import cleiton.unisul.piweb.rpc.client.ServicoUsuario;
import cleiton.unisul.piweb.rpc.shared.Usuario;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;

public class TelaInicial implements EntryPoint {
	
	private Usuario usuario;

	@Override
	public void onModuleLoad() {
		RootPanel rootUsuario= RootPanel.get("usuario");
		final Label saudacao=new Label("Ol‡.");;
		rootUsuario.add(saudacao);
		RootPanel rootPanel = RootPanel.get("botoes");
		
		VerticalPanel verticalPanel = new VerticalPanel();
		rootPanel.add(verticalPanel);
		
		
		Button btnNewButton = new Button("New button");
		btnNewButton.setStyleName("botaoLogout");
		btnNewButton.setText("acessar frota");
		verticalPanel.add(btnNewButton);
		btnNewButton.setWidth("100%");
		
		Button btnNewButton_1 = new Button("New button");
		btnNewButton_1.setStyleName("botaoLogout");
		btnNewButton_1.setText("cadastrar-se em frota");
		verticalPanel.add(btnNewButton_1);
		btnNewButton_1.setWidth("100%");
		
		Button button = new Button("New button");
		button.setText("criar frota");
		button.setStyleName("botaoLogout");
		verticalPanel.add(button);
		button.setWidth("100%");
		
		ServicoUsuario.getGreetingService().getUsuario("", new AsyncCallback<Usuario>() {

			@Override
			public void onFailure(Throwable caught) {Window.alert("falha ao exibir usuario.");
			caught.printStackTrace();}

			@Override
			public void onSuccess(Usuario result) {
				usuario=result;
				String boasvindas= "Seja bem-vindo ";
					boasvindas+=(usuario.getNickname()+"!");
					//boasvindas+=(usuario.getEmail()+" - ");
				String id="UserId: ";
						id+=usuario.getIdUsuario();
				saudacao.setText(boasvindas);
				//label2.setText(id);
			}
		});

	}
}
