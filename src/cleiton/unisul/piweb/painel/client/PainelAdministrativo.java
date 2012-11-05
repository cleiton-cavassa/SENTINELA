package cleiton.unisul.piweb.painel.client;

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
import cleiton.unisul.piweb.client.telaspopup.TelaPopUp;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.Command;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class PainelAdministrativo implements EntryPoint {

	//private Button clickMeButton;
	public void onModuleLoad() {
		RootPanel rootPanel = RootPanel.get();
		rootPanel.setSize("100%", "100%");
		
		MenuBar menuBar = new MenuBar(false);
		rootPanel.add(menuBar, 10, 10);
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
		

		
		
		ClickHandler h = new ClickHandler(){
			public void onClick(ClickEvent event) {
				Window.alert("Hello, GWT World!");
			}
		};
	}
	
	private class CriadorTela implements Command{
		private Widget tela;
		public void execute() {
			
				TelaPopUp p= new TelaPopUp();
				p.setTela(tela);
				p.center();		
				p.setPopupPosition(p.getPopupLeft(), Math.min(40, p.getPopupTop()));
			

		}
		
		CriadorTela(Widget tela){
			this.tela = tela;
		}
	}
}	

	
	
	
