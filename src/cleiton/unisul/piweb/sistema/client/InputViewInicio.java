package cleiton.unisul.piweb.sistema.client;

import java.util.ArrayList;
import java.util.List;

import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputView;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewCNPJ;
import cleiton.unisul.piweb.ferramentasVisuais.client.util.CriadorTela;
import cleiton.unisul.piweb.ferramentasVisuais.client.util.FecharPopUpEventHandler;
import cleiton.unisul.piweb.rpc.client.BotaoLogout;
import cleiton.unisul.piweb.rpc.client.ServicoArmazenamento;
import cleiton.unisul.piweb.rpc.shared.respostasdeconsulta.FrotaECredenciais;
import cleiton.unisul.piweb.rpc.shared.respostasdeconsulta.RespostaLoginUsuarioAdministrativo;
import cleiton.unisul.piweb.rpc.shared.respostasdeconsulta.Usuario;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
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
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;

public class InputViewInicio implements InputView<List<FrotaECredenciais>> {

	private ArrayList<AcessarHandler> acessarHandlers = new ArrayList<AcessarHandler>();
	private FecharPopUpEventHandler f;
	private DockPanel raiz = new DockPanel();
	private FlowPanel painelSuperusuario = new FlowPanel();
	private ListDataProvider<FrotaECredenciais> dataProvider = new ListDataProvider<FrotaECredenciais>();
	private Label labelEmail=new Label();
	private Usuario usuario=null;
	private final InputViewInicio eu;
	@Override
	public String getTitulo() {
		return "SENTINELA - login";
	}

	@Override
	public Widget asWidget() {
		return raiz;
	}	 
	
	public InputViewInicio(){
		eu=this;
		raiz.setStyleName("padding0");
		raiz.addStyleName("padding5");
		raiz.setSize("100%", "100%");
		
		raiz.setWidth(Window.getClientWidth()*80/100+"px");
		raiz.setHeight(Window.getClientHeight()*70/100+"px");
		VerticalPanel verticalPanel_1 = new VerticalPanel();
		raiz.add(verticalPanel_1, DockPanel.NORTH);
		verticalPanel_1.setWidth("100%");
		
		DockPanel dockPanel = new DockPanel();
		verticalPanel_1.add(dockPanel);
		dockPanel.setWidth("100%");
		dockPanel.add(painelSuperusuario, DockPanel.WEST);
		dockPanel.setCellVerticalAlignment(painelSuperusuario, HasVerticalAlignment.ALIGN_BOTTOM);
		
		painelSuperusuario.setVisible(false);
		painelSuperusuario.setWidth("100%");
		raiz.setCellVerticalAlignment(painelSuperusuario, HasVerticalAlignment.ALIGN_BOTTOM);
		
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
		verticalPanel.setWidth("100%");
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
	
	public class CallbackBuscaFrota implements AsyncCallback<RespostaLoginUsuarioAdministrativo> {

		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Houve problemas durante a busca por suas credenciais.\n\nO acesso ao sistema foi negado"+caught.getMessage());
		}

		@Override
		public void onSuccess(RespostaLoginUsuarioAdministrativo result) {
			if(result==null){
				Window.alert("N‹o foi encontrada qualquer frota para o seu email.");
			}else{
//				Window.alert("Suas credenciais de acesso foram confirmadas.\n" + result.toString());
				usuario=result.getUsuario();
				setInput(result.getFrotasEcredenciais());
			}
			preencherUsuario(result.getUsuario());
			new CriadorTela<List<FrotaECredenciais>>(eu).execute();
		}

	}
	
	private void preencherUsuario(Usuario usuario){
		
		painelSuperusuario.setVisible( usuario.isUserAdmin() );
		
		labelEmail.setText("email: "+usuario.getEmail());
	}
	


	void acessarFrota(FrotaECredenciais frotaEcredenciais){
		for (AcessarHandler a: acessarHandlers ){
			a.onAcessar(frotaEcredenciais, usuario);
		}
		fechar();
	}
	
	

	public boolean addAcessarHandler(AcessarHandler h){
		acessarHandlers.add(h);
		return true;
	}
	
	public interface AcessarHandler {
		void onAcessar(FrotaECredenciais frotaEcredenciais, Usuario usuario);
	}
	
	@Override
	public boolean setInput(List<FrotaECredenciais> input) {
		dataProvider.setList(input);
		return true;
	}
	@Override
	public List<FrotaECredenciais> getInput() {
		return dataProvider.getList();
	}

	@Override
	public boolean setFecharHandler(FecharPopUpEventHandler f) {
		this.f=f;
		return true;
	}

	@Override
	public void fechar() {
		f.fecharPopUp();
	}
	
	@Override
	public String validarDados() {
		return null;
	}
	
}

