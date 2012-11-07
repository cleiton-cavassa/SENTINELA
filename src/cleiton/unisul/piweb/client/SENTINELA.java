package cleiton.unisul.piweb.client;


import cleiton.unisul.piweb.client.telaspopup.CadastroClientesPF;

import cleiton.unisul.piweb.client.telaspopup.CadastroClientesPJ;
import cleiton.unisul.piweb.client.telaspopup.CadastroEstaFrota;
import cleiton.unisul.piweb.client.telaspopup.CadastroFrotasParceiras;
import cleiton.unisul.piweb.client.telaspopup.CadastroFuncionarios;
import cleiton.unisul.piweb.client.telaspopup.CorridasAgendadas;
import cleiton.unisul.piweb.client.telaspopup.CorridasCanceladas;
import cleiton.unisul.piweb.client.telaspopup.CorridasFinalizadas;
import cleiton.unisul.piweb.client.telaspopup.FrotasQueEmitemVouchers;
import cleiton.unisul.piweb.client.telaspopup.FuncionariosEmAtividade;
import cleiton.unisul.piweb.client.util.CriadorTela;
import cleiton.unisul.piweb.shared.Usuario;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.HasVerticalAlignment;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SENTINELA implements EntryPoint {
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);
	
	private Usuario usuario; 
	
	//private Button clickMeButton;
	public void onModuleLoad() {
		RootPanel rootPanel = RootPanel.get();
		rootPanel.setSize("100%", "100%");
		
		FlowPanel verticalPanel = new FlowPanel();
			verticalPanel.setSize("100%", "");
		rootPanel.add(verticalPanel, 0, 10);
		
		Grid gridPanel = new Grid(1,2);
		//horizontalSplitPanel.setSplitPosition("50%");
		verticalPanel.add(gridPanel);
		gridPanel.setSize("100%", "30px");
		
				
				HorizontalPanel horizontalPanel = new HorizontalPanel();
				gridPanel.setWidget(0, 1,horizontalPanel);
				
				
				Label btnNewButton = new Label("Fazer Logout");
				btnNewButton.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						greetingService.urlLogout("/SENTINELA.html", new AsyncCallback<String>() {
							@Override
							public void onFailure(Throwable caught) {}
							@Override
							public void onSuccess(String result) {
								Window.Location.assign(result);
							}
						});
					}
				});
				final Label label2= new Label();
				label2.setText("aaaaaaaaa");
				horizontalPanel.add(label2);
				btnNewButton.setStyleName("botaoLogout");
				horizontalPanel.add(btnNewButton);
			
				
				FlowPanel horizontalPanel_1 = new FlowPanel();
				gridPanel.setWidget(0, 0,horizontalPanel_1);
				//gridPanel.add(horizontalPanel_1);
				//horizontalSplitPanel.setLeftWidget(horizontalPanel_1);
				horizontalPanel_1.setSize("100%", "100%");
				
				final Label label = new Label();
				label.setStyleName("boasvindas");
				horizontalPanel_1.add(label);
				gridPanel.getCellFormatter().setVerticalAlignment(0, 1, HasVerticalAlignment.ALIGN_BOTTOM);
				gridPanel.getCellFormatter().setHorizontalAlignment(0, 1, HasHorizontalAlignment.ALIGN_RIGHT);
				greetingService.getUsuario("", new AsyncCallback<Usuario>() {

					@Override
					public void onFailure(Throwable caught) {}

					@Override
					public void onSuccess(Usuario result) {
						usuario=result;
						String boasvindas= "Seja bem-vindo ";
							boasvindas+=(usuario.getNickname()+"!");
							//boasvindas+=(usuario.getEmail()+" - ");
						String id="UserId: ";
								id+=usuario.getIdUsuario();
						label.setText(boasvindas);
						label2.setText(id);
					}
				});
		
	
		criaMenus(verticalPanel);
	
	}
	
	private void criaMenus(FlowPanel verticalPanel){
		
		MenuBar menuBar = new MenuBar(false);
		
		verticalPanel.add(menuBar);
		menuBar.setSize("100%", "23px");
		MenuBar menuBar_1 = new MenuBar(true);
		MenuItem mntmNewMenu = new MenuItem("Clientes", false, menuBar_1);
		
		MenuItem mntmNewItem_2 = new MenuItem("Pessoas Jur\u00EDdicas", false, new CriadorTela(new CadastroClientesPJ()));
		menuBar_1.addItem(mntmNewItem_2);
		
		MenuItem mntmNewItem_7 = new MenuItem("Pessoas F\u00EDsicas", false, new CriadorTela(new CadastroClientesPF()));
		
		menuBar_1.addItem(mntmNewItem_7);
		menuBar.addItem(mntmNewMenu);
		MenuBar menuBar_2 = new MenuBar(true);
		
		MenuItem mntmNewMenu_1 = new MenuItem("Funcion\u00E1rios", false, menuBar_2);
		
		MenuItem mntmNewItem_5 = new MenuItem("Cadastro", false, new CriadorTela(new CadastroFuncionarios()));
		menuBar_2.addItem(mntmNewItem_5);
		
		MenuItem mntmNewItem_6 = new MenuItem("Funcion\u00E1rios em atividade agora", false, new CriadorTela(new FuncionariosEmAtividade()));
		menuBar_2.addItem(mntmNewItem_6);
		menuBar.addItem(mntmNewMenu_1);
		MenuBar menuBar_3 = new MenuBar(true);
		
		MenuItem mntmNewMenu_2 = new MenuItem("Frotas Parceiras", false, menuBar_3);
		mntmNewMenu_2.setHTML("Frotas");
		
		MenuItem mntmCadastro = new MenuItem("Dados desta frota", false, new CriadorTela(new CadastroEstaFrota()));
		menuBar_3.addItem(mntmCadastro);
		
		MenuItem mntmCadastroDeFrotas = new MenuItem("Cadastro de Frotas Parceiras", false, new CriadorTela(new CadastroFrotasParceiras()));
		menuBar_3.addItem(mntmCadastroDeFrotas);
		
		MenuItem mntmNewItem_1 = new MenuItem("Frotas que emitem vouchers", false, new CriadorTela(new FrotasQueEmitemVouchers()));
		menuBar_3.addItem(mntmNewItem_1);
		menuBar.addItem(mntmNewMenu_2);
		MenuBar menuBar_4 = new MenuBar(true);
		
		MenuItem mntmNewMenu_3 = new MenuItem("Corridas", false, menuBar_4);
		
		MenuItem mntmNewItem_4 = new MenuItem("Corridas a atender", false, new CriadorTela(new CorridasAgendadas()));
		menuBar_4.addItem(mntmNewItem_4);
		
		MenuItem mntmNewItem_3 = new MenuItem("Corridas canceladas", false,  new CriadorTela(new CorridasCanceladas()));
		mntmNewItem_3.setHTML("Corridas canceladas");
		menuBar_4.addItem(mntmNewItem_3);
		
		MenuItem mntmNewItem = new MenuItem("Corridas finalizadas", false,  new CriadorTela(new CorridasFinalizadas()));
		menuBar_4.addItem(mntmNewItem);
		menuBar.addItem(mntmNewMenu_3);
	}
	

}	

	
	
	

