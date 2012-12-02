package cleiton.unisul.piweb.sistema.client;




import java.util.List;

import org.eclipse.jdt.internal.compiler.flow.LabelFlowContext;

import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputView;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputViewFactory;
import cleiton.unisul.piweb.ferramentasVisuais.client.util.CriadorTela;
import cleiton.unisul.piweb.rpc.client.BotaoLogout;
import cleiton.unisul.piweb.rpc.client.ServicoUsuario;
import cleiton.unisul.piweb.rpc.shared.Usuario;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.ClientePF;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.ClientePJ;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.FrotaECredenciais;
import cleiton.unisul.piweb.sistema.client.formularios.FormClientePF;
import cleiton.unisul.piweb.sistema.client.formularios.FormClientePJ;
import cleiton.unisul.piweb.sistema.client.formularios.FormCorridaSolicitada;
import cleiton.unisul.piweb.sistema.client.formularios.FormMotorista;
import cleiton.unisul.piweb.sistema.client.formularios.FormRelacaoClientesPF;
import cleiton.unisul.piweb.sistema.client.telaspopup.clientes.clientespj.RelacaoClientesPJ;
import cleiton.unisul.piweb.sistema.client.telaspopup.corridas.CorridasCanceladas;
import cleiton.unisul.piweb.sistema.client.telaspopup.corridas.CorridasFinalizadas;
import cleiton.unisul.piweb.sistema.client.telaspopup.corridas.CorridasSolicitadas;
import cleiton.unisul.piweb.sistema.client.telaspopup.frotas.CadastroEstaFrota;
import cleiton.unisul.piweb.sistema.client.telaspopup.frotas.CadastroFrotasParceiras;
import cleiton.unisul.piweb.sistema.client.telaspopup.frotas.FrotasQueEmitemVouchers;
import cleiton.unisul.piweb.sistema.client.telaspopup.funcionarios.FuncionariosEmAtividade;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SENTINELA implements EntryPoint {

	private Usuario usuario;
	private Label lblFrota = new Label();
	
	//private Button clickMeButton;
	public void onModuleLoad() {
		
		RootPanel rootPanel = RootPanel.get();
		rootPanel.setSize("100%", "100%");
		
		FlowPanel verticalPanel = new FlowPanel();
			verticalPanel.setSize("100%", "");
		rootPanel.add(verticalPanel, 0, 10);
		
		Grid gridPanel = new Grid(1,2);
		verticalPanel.add(gridPanel);
		gridPanel.setSize("100%", "30px");
		
				
				HorizontalPanel horizontalPanel = new HorizontalPanel();
				gridPanel.setWidget(0, 1,horizontalPanel);
				
				
//				Button btnNewButton = new Button("Logout");
				Button btnNewButton = new BotaoLogout("Logout");
//				btnNewButton.addClickHandler(new SairClickHandler());
				final Label label2= new Label();
				horizontalPanel.add(label2);
//				btnNewButton.setStyleName("botaoLogout");
				horizontalPanel.add(btnNewButton);
			
				
				FlowPanel flowPanel_1 = new FlowPanel();
				gridPanel.setWidget(0, 0,flowPanel_1);
				//gridPanel.add(horizontalPanel_1);
				//horizontalSplitPanel.setLeftWidget(horizontalPanel_1);
				flowPanel_1.setSize("100%", "100%");
				
				final Label label = new Label();
				label.setStyleName("boasvindas");
				flowPanel_1.add(label);
				

				flowPanel_1.add(lblFrota);
				gridPanel.getCellFormatter().setVerticalAlignment(0, 1, HasVerticalAlignment.ALIGN_BOTTOM);
				gridPanel.getCellFormatter().setHorizontalAlignment(0, 1, HasHorizontalAlignment.ALIGN_RIGHT);
				ServicoUsuario.getGreetingService().getUsuario("", new AsyncCallback<Usuario>() {

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
						if(usuario.getFrota()==null){
							lblFrota.setText("Sem registro de frota");
						}else{
							lblFrota.setText("Frota: " + result.getFrota().getMeusDadosCompartilhados().getDadosPessoaJuridica().getDadosPessoaJuridica().getRazaoSocial());
						}
							
					}
				});
				
				
		
		criaMenus(verticalPanel);
		
		new CriadorTela<List<FrotaECredenciais>>(new InputViewInicio()).execute();
	
	}
	
	private void criaMenus(FlowPanel verticalPanel){
		
		MenuBar menuBar = new MenuBar(false);
		
		verticalPanel.add(menuBar);
		menuBar.setSize("100%", "23px");
		MenuBar menuBar_1 = new MenuBar(true);
		MenuItem mntmNewMenu = new MenuItem("Clientes", false, menuBar_1);
		
		MenuBar menuBar_PJ = new MenuBar(true);
		MenuItem menuItemPJ = new MenuItem("Pessoas Jur\u00EDdicas",false, menuBar_PJ);
			MenuItem menuItemRelaPJ = new MenuItem("listagem de Pessoas Jur\u00EDdicas", false, new CriadorTela<List<ClientePJ>>(new InputViewFactory<List<ClientePJ>>() {

				@Override
				public InputView<List<ClientePJ>> getInputView() {
					return new RelacaoClientesPJ();
				}
			}));
			
			menuBar_PJ.addItem(menuItemRelaPJ);
			MenuItem menuItemNovaPJ = new MenuItem("nova Pessoa Jur\u00EDdica", false, new CriadorTela<ClientePJ>(new FormClientePJ()));
			menuBar_PJ.addItem(menuItemNovaPJ);
		menuBar_1.addItem(menuItemPJ);

		
		MenuBar menuBar_PF = new MenuBar(true);
		MenuItem menuItemPF = new MenuItem("Pessoas F\u00EDsicas",false, menuBar_PF);
//			MenuItem menuItemRelaPF = new MenuItem("listagem de Pessoas F\u00EDsicas", false,new CriadorTela(new FormRelacaoClientesPF()));
			MenuItem menuItemRelaPF = new MenuItem("listagem de Pessoas F\u00EDsicas", false,new CriadorTela<List<ClientePF>>(new InputViewFactory<List<ClientePF>>() {

				@Override
				public InputView<List<ClientePF>> getInputView() {
					return new FormRelacaoClientesPF();
				}
			}));


			menuBar_PF.addItem(menuItemRelaPF);
			MenuItem menuItemNovaPF = new MenuItem("nova Pessoa F\u00EDsica", false, new CriadorTela<ClientePF>(new FormClientePF() ));
			menuBar_PF.addItem(menuItemNovaPF);
		menuBar_1.addItem(menuItemPF);
		menuBar.addItem(mntmNewMenu);
		
//		MenuItem menuItemPFePJ = new MenuItem("Pessoas F\u00EDsicas e Pessoas Jur\u00EDdicas relacionadas",false, new CriadorTela(RelacaoClientesPFePJ.get()));
//		menuBar_1.addItem(menuItemPFePJ);
		
		
		MenuBar menuBar_2 = new MenuBar(true);
		

		
		MenuItem mntmNewMenu_1 = new MenuItem("Funcion\u00E1rios", false, menuBar_2);
		
		MenuItem mntmNewItem_5 = new MenuItem("Cadastro", false, new CriadorTela(new FormMotorista()));
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
		
		
		MenuBar menuBar_corridasSolicitadas = new MenuBar(true);
		MenuItem mntmNewItem_4 = new MenuItem("Corridas solicitadas", false, menuBar_corridasSolicitadas);
		
		menuBar_corridasSolicitadas.addItem(
			new MenuItem("nova corrida solicitada", false, new CriadorTela(new FormCorridaSolicitada()) )
				);
		menuBar_corridasSolicitadas.addItem(
				new MenuItem("todas as corridas", false, new CriadorTela(new CorridasSolicitadas()) )
					);
		
		
		menuBar_4.addItem(mntmNewItem_4);
		
		MenuItem mntmNewItem_3 = new MenuItem("Corridas canceladas", false,  new CriadorTela(new CorridasCanceladas()));
		mntmNewItem_3.setHTML("Corridas canceladas");
		menuBar_4.addItem(mntmNewItem_3);
		
		MenuItem mntmNewItem = new MenuItem("Corridas finalizadas", false,  new CriadorTela(new CorridasFinalizadas()));
		menuBar_4.addItem(mntmNewItem);
		menuBar.addItem(mntmNewMenu_3);
	}
	
//	public class SairClickHandler implements ClickHandler {
//
//		@Override
//		public void onClick(ClickEvent event) {
//			ServicoUsuario.getGreetingService().urlLogout("/SENTINELA.html", new AsyncCallback<String>() {
//				@Override
//				public void onFailure(Throwable caught) {}
//				@Override
//				public void onSuccess(String result) {
//					Window.Location.assign(result);
//				}
//			});
//		}
//	}
}	

	
	
	

