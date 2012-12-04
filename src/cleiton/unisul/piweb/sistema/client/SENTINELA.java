package cleiton.unisul.piweb.sistema.client;




import java.util.List;

import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputView;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputViewFactory;
import cleiton.unisul.piweb.ferramentasVisuais.client.util.CriadorTela;
import cleiton.unisul.piweb.rpc.client.BotaoLogout;
import cleiton.unisul.piweb.rpc.client.ServicoArmazenamento;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.ClientePF;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.ClientePJ;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.CorridaCancelada;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.CorridaSolicitada;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.Frota;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.FrotaDadosCompartilhados;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.Motorista;
import cleiton.unisul.piweb.rpc.shared.respostasdeconsulta.FrotaECredenciais;
import cleiton.unisul.piweb.rpc.shared.respostasdeconsulta.Usuario;
import cleiton.unisul.piweb.sistema.client.InputViewInicio.AcessarHandler;
import cleiton.unisul.piweb.sistema.client.formularios.FormCorridaCancelada;
import cleiton.unisul.piweb.sistema.client.formularios.FormCorridaSolicitada;
import cleiton.unisul.piweb.sistema.client.formularios.FormRelacaoClientesPF;
import cleiton.unisul.piweb.sistema.client.formularios.FormRelacaoClientesPJ;
import cleiton.unisul.piweb.sistema.client.formularios.FormRelacaoCorridasCanceladas;
import cleiton.unisul.piweb.sistema.client.formularios.FormRelacaoCorridasSolicitadas;
import cleiton.unisul.piweb.sistema.client.formularios.FormRelacaoFrotasDadosCompartilhados;
import cleiton.unisul.piweb.sistema.client.formularios.FormRelacaoMotoristas;
import cleiton.unisul.piweb.sistema.client.formularios.individuais.FormClientePF;
import cleiton.unisul.piweb.sistema.client.formularios.individuais.FormClientePJ;
import cleiton.unisul.piweb.sistema.client.formularios.individuais.FormFrotaDadosCompartilhados;
import cleiton.unisul.piweb.sistema.client.formularios.individuais.FormMotorista;
import cleiton.unisul.piweb.sistema.client.telaspopup.corridas.CorridasCanceladas;
import cleiton.unisul.piweb.sistema.client.telaspopup.corridas.CorridasFinalizadas;
import cleiton.unisul.piweb.sistema.client.telaspopup.corridas.CorridasSolicitadas;
import cleiton.unisul.piweb.sistema.client.telaspopup.frotas.CadastroEstaFrota;
import cleiton.unisul.piweb.sistema.client.telaspopup.frotas.CadastroFrotasParceiras;
import cleiton.unisul.piweb.sistema.client.telaspopup.frotas.FrotasQueEmitemVouchers;
import cleiton.unisul.piweb.sistema.client.telaspopup.funcionarios.FuncionariosEmAtividade;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
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
public class SENTINELA implements EntryPoint, AcessarHandler {
	
	private static Frota frota=null;
	public static Frota getFrota(){
		return frota;
	}

	private static Usuario usuario=null;
	private final Label lblFrota = new Label();
	private final Label label = new Label();
	private final Label label2= new Label();
	
	
	public void onModuleLoad() {
		InputViewInicio ivi = new InputViewInicio();
			ivi.addAcessarHandler(this);
	}
	
	@Override
	public void onAcessar(FrotaECredenciais frotaEcredenciais, Usuario usuario) {
		montarTela(frotaEcredenciais, usuario);
	}
	
	private void montarTela(FrotaECredenciais frotaEcredenciais, Usuario usuario){
		SENTINELA.usuario = usuario;
		SENTINELA.frota = frotaEcredenciais.getFrota();
		
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
				
				
		Button btnNewButton = new BotaoLogout("Logout");

		horizontalPanel.add(label2);
		horizontalPanel.add(btnNewButton);


		FlowPanel flowPanel_1 = new FlowPanel();
		gridPanel.setWidget(0, 0,flowPanel_1);
		flowPanel_1.setSize("100%", "100%");


		label.setStyleName("boasvindas");
		flowPanel_1.add(label);

		flowPanel_1.add(lblFrota);
		gridPanel.getCellFormatter().setVerticalAlignment(0, 1, HasVerticalAlignment.ALIGN_BOTTOM);
		gridPanel.getCellFormatter().setHorizontalAlignment(0, 1, HasHorizontalAlignment.ALIGN_RIGHT);
		
		acrescentarDadosUsuarioEFrota();
		criaMenus(verticalPanel);
	}
	
	
	
	private void acrescentarDadosUsuarioEFrota() {
		String boasvindas= "Seja bem-vindo ";
		boasvindas+=(usuario==null?"an™nimo":usuario.getNickname()+"!");
		String id="UserId: ";
		id+=(usuario==null?"an™nimo":usuario.getIdUsuario());
		label.setText(boasvindas);
		label2.setText(id);
		
		if(frota==null){
			lblFrota.setText("Sem registro de frota");
		}else{
			lblFrota.setText("Frota: " + frota.getMeusDadosCompartilhados().getDadosPessoaJuridica().getDadosPessoaJuridica().getRazaoSocial());
		}		
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
					return new FormRelacaoClientesPJ();
				}
			}));
			
			menuBar_PJ.addItem(menuItemRelaPJ);
			MenuItem menuItemNovaPJ = new MenuItem("nova Pessoa Jur\u00EDdica", false,new CriadorTela<ClientePJ>(new InputViewFactory<ClientePJ>() {
				@Override
				public InputView<ClientePJ> getInputView() {
					return new FormClientePJ(true);
				}
			}));
			menuBar_PJ.addItem(menuItemNovaPJ);
		menuBar_1.addItem(menuItemPJ);

		
		MenuBar menuBar_PF = new MenuBar(true);
		MenuItem menuItemPF = new MenuItem("Pessoas F\u00EDsicas",false, menuBar_PF);
			MenuItem menuItemRelaPF = new MenuItem("listagem de Pessoas F\u00EDsicas", false,new CriadorTela<List<ClientePF>>(new InputViewFactory<List<ClientePF>>() {
				@Override
				public InputView<List<ClientePF>> getInputView() {
					return new FormRelacaoClientesPF();
				}
			}));


			menuBar_PF.addItem(menuItemRelaPF);
			MenuItem menuItemNovaPF = new MenuItem("nova Pessoa F\u00EDsica", false,new CriadorTela<ClientePF>(new InputViewFactory<ClientePF>() {
				@Override
				public InputView<ClientePF> getInputView() {
					return new FormClientePF(true);
				}
			}));
					
				
			menuBar_PF.addItem(menuItemNovaPF);
		menuBar_1.addItem(menuItemPF);
		menuBar.addItem(mntmNewMenu);
		
//		MenuItem menuItemPFePJ = new MenuItem("Pessoas F\u00EDsicas e Pessoas Jur\u00EDdicas relacionadas",false, new CriadorTela(RelacaoClientesPFePJ.get()));
//		menuBar_1.addItem(menuItemPFePJ);
		
		
		MenuBar menuBar_2 = new MenuBar(true);
		MenuItem mntmNewMenu_1 = new MenuItem("Motoristas", false, menuBar_2);
		
		MenuBar menuBar_CadastroMotoristas = new MenuBar(true);
		MenuItem mntmNewItem_5 = new MenuItem("Cadastro", false,menuBar_CadastroMotoristas);
			MenuItem menuItemRelaMotoristas = new MenuItem("listagem de Motoristas", false,new CriadorTela<List<Motorista>>(new InputViewFactory<List<Motorista>>() {
				@Override
				public InputView<List<Motorista>> getInputView() {
					return new FormRelacaoMotoristas();
				}
			}));
				
//				new CriadorTela<Motorista>(new FormMotorista(true)));
			menuBar_CadastroMotoristas.addItem(menuItemRelaMotoristas);
			MenuItem menuItemNovoMotorista = new MenuItem("novo Motorista", false,new CriadorTela<Motorista>(new InputViewFactory<Motorista>() {
				@Override
				public InputView<Motorista> getInputView() {
					return new FormMotorista(true);
				}
			}));
			menuBar_CadastroMotoristas.addItem(menuItemNovoMotorista);
		menuBar_2.addItem(mntmNewItem_5);
		
//		MenuItem mntmNewItem_6 = new MenuItem("Funcion\u00E1rios em atividade agora", false, new CriadorTela<List<Motorista>>(new FuncionariosEmAtividade()));
//		menuBar_2.addItem(mntmNewItem_6);
		menuBar.addItem(mntmNewMenu_1);
		MenuBar menuBar_3 = new MenuBar(true);
		
		MenuItem mntmNewMenu_2 = new MenuItem("Frotas Parceiras", false, menuBar_3);
		mntmNewMenu_2.setHTML("Frotas");
		
		MenuItem mntmCadastro = new MenuItem("Dados desta frota", false, new CriadorTela<FrotaDadosCompartilhados>(new InputViewFactory<FrotaDadosCompartilhados>() {
			@Override
			public InputView<FrotaDadosCompartilhados> getInputView() {
				FormFrotaDadosCompartilhados f = new FormFrotaDadosCompartilhados(false);
				ServicoArmazenamento.getArmazenamento().recuperarMeusDadosCompartilhados(SENTINELA.getFrota().getChave(), new CallbackRapido(f));
				return f;
			}
			final class CallbackRapido implements AsyncCallback<FrotaDadosCompartilhados>{
				FormFrotaDadosCompartilhados f;
				
				public CallbackRapido(FormFrotaDadosCompartilhados f){
					this.f=f;
				}
				@Override
				public void onFailure(Throwable caught) {
					Window.alert("Falha ao recuperar os dados desta frota.");
					f.fechar();
				}
				@Override
				public void onSuccess(FrotaDadosCompartilhados result) {
					f.setInput(result);
				}
			}
		}
		));
		menuBar_3.addItem(mntmCadastro);
		
		MenuItem mntmCadastroDeFrotas = new MenuItem("Cadastrar nova Frota Parceira", false, new CriadorTela<FrotaDadosCompartilhados>(new InputViewFactory<FrotaDadosCompartilhados>() {
			@Override
			public InputView<FrotaDadosCompartilhados> getInputView() {
				return new FormFrotaDadosCompartilhados(true);
			}
		}));
		menuBar_3.addItem(mntmCadastroDeFrotas);
		
		
		MenuItem mntmRelacaoDeFrotas = new MenuItem("Relacao de frotas parceiras", false, new CriadorTela<List<FrotaDadosCompartilhados>>(new InputViewFactory<List<FrotaDadosCompartilhados>>() {
			@Override
			public InputView<List<FrotaDadosCompartilhados>> getInputView() {
				return new FormRelacaoFrotasDadosCompartilhados();
			}
		}));
		menuBar_3.addItem(mntmRelacaoDeFrotas);
		
//		MenuItem mntmNewItem_1 = new MenuItem("Frotas que emitem vouchers", false, new CriadorTela(new FrotasQueEmitemVouchers()));
//		menuBar_3.addItem(mntmNewItem_1);
		menuBar.addItem(mntmNewMenu_2);
		MenuBar menuBar_4 = new MenuBar(true);
		
		MenuItem mntmNewMenu_3 = new MenuItem("Corridas", false, menuBar_4);
		
		
		MenuBar menuBar_corridasSolicitadas = new MenuBar(true);
		MenuItem mntmNewItem_4 = new MenuItem("Corridas solicitadas", false, menuBar_corridasSolicitadas);
		
		menuBar_corridasSolicitadas.addItem(
			new MenuItem("nova corrida solicitada", false, new CriadorTela<CorridaSolicitada>(new InputViewFactory<CorridaSolicitada>() {
				@Override
				public InputView<CorridaSolicitada> getInputView() {
					return new FormCorridaSolicitada(true);
				}
			})));
		
		menuBar_corridasSolicitadas.addItem(
				new MenuItem("todas as corridas", false, new CriadorTela<List<CorridaSolicitada>>(new InputViewFactory<List<CorridaSolicitada>>() {
					@Override
					public InputView<List<CorridaSolicitada>> getInputView() {
						return new FormRelacaoCorridasSolicitadas();
					}
				})));
		menuBar_4.addItem(mntmNewItem_4);
		
		MenuBar menuBar_corridasCanceladas = new MenuBar(true);
		MenuItem mntmNewItem_3 = new MenuItem("Corridas canceladas", false, menuBar_corridasCanceladas);
		
//		menuBar_corridasCanceladas.addItem(
//				new MenuItem("nova corrida cancelada", false, new CriadorTela<CorridaCancelada>(new InputViewFactory<CorridaCancelada>() {
//					@Override
//					public InputView<CorridaCancelada> getInputView() {
//						return new FormCorridaCancelada(true);
//					}
//				})));
		
		menuBar_corridasCanceladas.addItem(
				new MenuItem("todas as corridas", false, new CriadorTela<List<CorridaCancelada>>(new InputViewFactory<List<CorridaCancelada>>() {
					@Override
					public InputView<List<CorridaCancelada>> getInputView() {
						return new FormRelacaoCorridasCanceladas();
					}
				})));
		
		mntmNewItem_3.setHTML("Corridas canceladas");
		menuBar_4.addItem(mntmNewItem_3);
		
		MenuBar menuBar_corridasFinalizadas = new MenuBar(true);
		MenuItem mntmNewItem = new MenuItem("Corridas finalizadas", false,  new CriadorTela(new CorridasFinalizadas()));
		menuBar_4.addItem(mntmNewItem);
		menuBar.addItem(mntmNewMenu_3);
	}


}	

	
	
	

