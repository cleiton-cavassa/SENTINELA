package cleiton.unisul.piweb.telainicial.client;

import java.util.List;

import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputView;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewCNPJ;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.widgets.InputViewBotoes;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.widgets.InputViewBotoes.ObEevento;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.widgets.InputViewBotoes.PersonalClickHandler;
import cleiton.unisul.piweb.ferramentasVisuais.client.util.CriadorTela;
import cleiton.unisul.piweb.ferramentasVisuais.client.util.FecharPopUpEventHandler;
import cleiton.unisul.piweb.rpc.client.BotaoLogout;
import cleiton.unisul.piweb.rpc.client.ServicoArmazenamento;
import cleiton.unisul.piweb.rpc.client.ServicoUsuario;
import cleiton.unisul.piweb.rpc.shared.Usuario;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.DadosUsuarioAdministrativo;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.DadosUsuarioAdministrativo.NivelAcesso;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.Frota;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.FrotaECredenciais;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;

public class Inicio implements EntryPoint, InputView<List<FrotaECredenciais>>{
	

	FlowPanel painelSuperusuario = new FlowPanel();
	private ListDataProvider<FrotaECredenciais> dataProvider = new ListDataProvider<FrotaECredenciais>();
	
	private Label labelEmail=new Label();
	private DockPanel raiz = new DockPanel();

	@Override
	public void onModuleLoad() {
		RootPanel rootPanel = RootPanel.get();
		rootPanel.setStyleName("padding0");
		rootPanel.setSize("100%", "100%");
		
		

		raiz.setStyleName("padding0");
		raiz.addStyleName("padding5");
		raiz.setSize("100%", "100%");
		rootPanel.add(raiz, 0, 0);
		
		VerticalPanel verticalPanel_1 = new VerticalPanel();
		raiz.add(verticalPanel_1, DockPanel.NORTH);
		verticalPanel_1.setWidth("100%");
		
		Label lblSentinelaSistema = new Label("SENTINELA - SISTEMA DE GERENCIAMENTO E INTEGRA\u00C7\u00C3O DE FROTAS DE T\u00C1XIS");
		verticalPanel_1.add(lblSentinelaSistema);
		lblSentinelaSistema.setStyleName("h1");
		lblSentinelaSistema.addStyleName("padding5");
		
		DockPanel dockPanel = new DockPanel();
		verticalPanel_1.add(dockPanel);
		dockPanel.setWidth("100%");
		dockPanel.add(painelSuperusuario, DockPanel.WEST);
		dockPanel.setCellVerticalAlignment(painelSuperusuario, HasVerticalAlignment.ALIGN_BOTTOM);
		
		painelSuperusuario.setVisible(false);
		painelSuperusuario.setWidth("100%");
		raiz.setCellVerticalAlignment(painelSuperusuario, HasVerticalAlignment.ALIGN_BOTTOM);
		
		Label lblOSeuEmail = new Label("O seu email possui credenciais de superusu\u00E1rio! Isso significa que voc\u00EA pode criar novas frotas!");
		painelSuperusuario.add(lblOSeuEmail);
		
		Button btnAcessarComoSuperusurio = new Button("acessar como superusu\u00E1rio");
		btnAcessarComoSuperusurio.setStyleName("botaoLogout");
		painelSuperusuario.add(btnAcessarComoSuperusurio);
		
		btnAcessarComoSuperusurio.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				String urlSuper=GWT.getHostPageBaseURL()+"superusuario.html";
				Window.Location.assign(urlSuper);	
			}
		});
		
		
		BotaoLogout btnLogout = new BotaoLogout("logout"); 
		
		dockPanel.add(btnLogout, DockPanel.WEST);
		dockPanel.setCellHorizontalAlignment(btnLogout, HasHorizontalAlignment.ALIGN_RIGHT);
		dockPanel.setCellVerticalAlignment(btnLogout, HasVerticalAlignment.ALIGN_TOP);
		
		VerticalPanel verticalPanel = new VerticalPanel();
		raiz.add(verticalPanel,DockPanel.CENTER);
		raiz.setCellVerticalAlignment(verticalPanel, HasVerticalAlignment.ALIGN_MIDDLE);
		raiz.setCellHorizontalAlignment(verticalPanel, HasHorizontalAlignment.ALIGN_CENTER);
		
		verticalPanel.add(labelEmail);
		labelEmail.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		
		Label lblDigiteOCnpj = new Label("Voc\u00EA possui permiss\u00E3o de acesso \u00E0s seguintes frotas:");
		verticalPanel.add(lblDigiteOCnpj);
		verticalPanel.setCellHorizontalAlignment(lblDigiteOCnpj, HasHorizontalAlignment.ALIGN_CENTER);
		lblDigiteOCnpj.addStyleName("padding5");
		
		lblDigiteOCnpj.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		
		DecoratorPanel decoratorPanel = new DecoratorPanel();
		verticalPanel.add(decoratorPanel);
		decoratorPanel.setWidth("100%");
		
		CellTable<FrotaECredenciais> cellTable = new CellTable<FrotaECredenciais>();
		decoratorPanel.setWidget(cellTable);
		cellTable.setWidth("100%");
		
		Column<FrotaECredenciais, String> column = new Column<FrotaECredenciais, String>(new ButtonCell()) {
			@Override
			public String getValue(FrotaECredenciais object) {
				return "acessar";
			}
		};
				column.setFieldUpdater(new FieldUpdater<FrotaECredenciais, String>() {
					@Override
					public void update(int index, FrotaECredenciais object, String value) {
						acessarFrota(object);
					}
				});
		
		cellTable.addColumn(column);
		
		TextColumn<FrotaECredenciais> textColumn = new TextColumn<FrotaECredenciais>() {
			@Override
			public String getValue(FrotaECredenciais object) {
				String r = object.
						getFrota().
						getMeusDadosCompartilhados().
						getDadosPessoaJuridica().
						getDadosPessoaJuridica().
						getRazaoSocial();
				if (r==null){
					return "";
				}else{
					return object.getFrota().getMeusDadosCompartilhados().getDadosPessoaJuridica().getDadosPessoaJuridica().getRazaoSocial();
				}
			}
		};
		cellTable.addColumn(textColumn, "Raz\u00E3o Social");
		
		TextColumn<FrotaECredenciais> textColumn_1 = new TextColumn<FrotaECredenciais>() {
			@Override
			public String getValue(FrotaECredenciais object) {
				return InputViewCNPJ.mascaraCNPJ(object.getFrota().getMeusDadosCompartilhados().getDadosPessoaJuridica().getDadosPessoaJuridica().getCnpj());
			}
		};
		cellTable.addColumn(textColumn_1, "CNPJ");
		

		dataProvider.addDataDisplay(cellTable);
		
		TextColumn<FrotaECredenciais> textColumn_2 = new TextColumn<FrotaECredenciais>() {
			@Override
			public String getValue(FrotaECredenciais object) {
				return object.getCredenciais().toString();
			}
		};
		cellTable.addColumn(textColumn_2, "suas credenciais");
		
		ServicoArmazenamento.getArmazenamento().acharFrotas(new CallbackBuscaFrota());

	}
	
	private Usuario usuario;	
	private void verificarUsuario(){
		ServicoUsuario.getGreetingService().getUsuario(null, new AsyncCallback<Usuario>() {

			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
				Window.alert("Falha na busca de usuario:\n"+caught.getMessage());
			}

			@Override
			public void onSuccess(Usuario result) {
				usuario=result;
				painelSuperusuario.setVisible(
						usuario.isUserAdmin()
						);
				labelEmail.setText("email: "+usuario.getEmail());
			}
		});
	}
	

	
	public class CallbackBuscaFrota implements AsyncCallback<List<FrotaECredenciais>> {

		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Houve problemas durante a busca por suas credenciais de acesso.\n\n"+caught.getMessage());
			verificarUsuario();
		}

		@Override
		public void onSuccess(List<FrotaECredenciais> result) {
			if(result==null){
				Window.alert("Não foi encontrada frota para o seu email, ou você não possui acesso aos dados dessa frota:\n");
			}else{
				Window.alert("Suas credenciais de acesso foram confirmadas.\n" + result.toString());
				setInput(result);
			}
			verificarUsuario();
		}

	}
	@Override
	public String validarDados() {
		return null;
	}
	@Override
	public String getTitulo() {
		return "telaFactory inicial";
	}
	@Override
	public boolean setFecharHandler(FecharPopUpEventHandler f) {
		return false;
	}
	
	@Override
	public void fechar() {}
	
	@Override
	public Widget asWidget() {return null;}
	
	@Override
	public boolean setInput(List<FrotaECredenciais> input) {
		dataProvider.setList(input);
		return true;
	}
	@Override
	public List<FrotaECredenciais> getInput() {
		return dataProvider.getList();
	}
	
	private InputViewBotoes<DadosUsuarioAdministrativo.NivelAcesso> ib;
	
	void acessarFrota(FrotaECredenciais frotaEcredenciais){

			ib = new InputViewBotoes<DadosUsuarioAdministrativo.NivelAcesso>();
			ib.setInput(frotaEcredenciais.getCredenciais());
			ib.addButtonClickHandler(new PCHandler(frotaEcredenciais));
		new CriadorTela<List<DadosUsuarioAdministrativo.NivelAcesso>>(ib).execute();
	}
	
	
	
	private class PCHandler implements PersonalClickHandler<DadosUsuarioAdministrativo.NivelAcesso> {
		private FrotaECredenciais f;
		public PCHandler(FrotaECredenciais f){
			this.f=f;
		}
		@Override
		public void onClick(ObEevento<NivelAcesso> origem) {
			ib.fechar();
			acessarModulo(f.getFrota(), origem.getObjeto());
		}
	}
	

	void acessarModulo(Frota f, DadosUsuarioAdministrativo.NivelAcesso n){
		String urlModuloNivel;
		
		if (n.equals(DadosUsuarioAdministrativo.NivelAcesso.Administrador1)){
			urlModuloNivel=GWT.getHostPageBaseURL()+"SENTINELA.html";
		}else{
			urlModuloNivel=GWT.getHostPageBaseURL()+"painelInicio.html";
		}
		ServicoUsuario.getGreetingService().definirFrota(f, new CallbackDefinirFrota(1, f, urlModuloNivel));
	}
	
	private class CallbackDefinirFrota implements AsyncCallback<Boolean>{

		private final int maximoTentativas=3;
		private int nroTentativa;
		private Frota frota;
		private String urlModuloNivel;
		
		public CallbackDefinirFrota(int nroTentativa, Frota frota, String urlModuloNivel){
			this.nroTentativa=nroTentativa;
			this.frota = frota;
			this.urlModuloNivel=urlModuloNivel;
		}
		
		
		@Override
		public void onFailure(Throwable caught) {
			if(nroTentativa<=maximoTentativas){
				ServicoUsuario.getGreetingService().definirFrota(frota, new CallbackDefinirFrota(nroTentativa+1, frota, urlModuloNivel));
			}else{
				Window.alert("Foram feitas "+maximoTentativas + "de acesso, sem sucesso. Por favor, tente novamente a posteriori.");
			}
		}

		@Override
		public void onSuccess(Boolean result) {
			Window.alert("Frota armazenada?\n" + result);
//			Window.Location.assign(urlModuloNivel);
			Window.open(urlModuloNivel, "_self", "");
		}
		
	}
}
