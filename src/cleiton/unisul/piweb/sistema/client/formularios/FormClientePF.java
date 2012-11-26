package cleiton.unisul.piweb.sistema.client.formularios;

import cleiton.unisul.piweb.ferramentasVisuais.client.util.FecharPopUpEvent;
import cleiton.unisul.piweb.rpc.shared.RespostaPersistencia;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.ClientePF;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.widgets.BotaoSalvar;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.VerticalPanel;


public class FormClientePF extends Formulario<ClientePF>{
	@Override
	public String getTitulo(){
		return "Sentinela - Clientes Pessoa Fisica";
	}
	
	private VerticalPanel raiz;
	private FormDadosPessoaFisica dadosPessoaFisica = new FormDadosPessoaFisica();
	private FormDadosDeContato dadosDeContato= new FormDadosDeContato();
	private FormPreferencias preferencias= new FormPreferencias();
	private FormDadosClientePF dadosClientePF= new FormDadosClientePF();
	private AsyncCallback<RespostaPersistencia> callback= new AsyncCallback<RespostaPersistencia>() {
		
		@Override
		public void onFailure(Throwable caught) {
			Window.alert("O procedimento falhou. Por favor, tente novamente.");
		}

		@Override
		public void onSuccess(RespostaPersistencia result) {
			Window.alert("O procedimento foi bem-sucedido?\n"+(result.getOperacaoBemSucedida()?"Sim":"N‹o"));
			Window.alert("O objeto ja existia?\n"+(result.getIdObjetoJaExistia()?"Sim":"N‹o"));
			Window.alert("A existencia (ou nao) do objeto era esperada?\n"+(result.getObjetoConformeEsperado()?"Sim":"N‹o"));
			
			fireEvent(new FecharPopUpEvent());
		}
		
	};

	/**
	 * @wbp.parser.constructor
	 */
	public FormClientePF() {
		
		raiz = new VerticalPanel();
		TabPanel tabPanel = new TabPanel();
		tabPanel.setStyleName("painelCadastro");
		raiz.add(tabPanel);
		initWidget(raiz);
		tabPanel.setSize("914px", "300");
		
		
		tabPanel.add(dadosPessoaFisica, "Dados da Pessoa F\u00EDsica", false);
		tabPanel.add(dadosDeContato, "Dados de Contato", false);
		tabPanel.add(preferencias, "Prefer\u00EAncias", false);
		tabPanel.add(dadosClientePF, "Dados do cliente", false);
		
		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		horizontalPanel_1.setSpacing(3);
		raiz.add(horizontalPanel_1);
		horizontalPanel_1.setWidth("211");
		
		Button button_1 = new BotaoSalvar<ClientePF>("salvar",this, true,false, callback);
		horizontalPanel_1.add(button_1);
		
		Button button_2 = new Button("New button");
		button_2.setText("excluir");
		horizontalPanel_1.add(button_2);
		setStyleName("painelCadastro"); 
		
		tabPanel.selectTab(0);
	}

	@Override
	public boolean setInput(ClientePF input) {
		super.setInput(input);
		
		boolean result=true;
		
		result&=dadosDeContato.setInput(input.getDadosDeContato());
		result&=dadosPessoaFisica.setInput(input.getDadosPessoaFisica());
		result&=preferencias.setInput(input.getPreferencias());
		result&=dadosClientePF.setInput(input.getDadosClientePF());
		
		return result;
	}

	@Override
	public ClientePF getInput() {
		ClientePF input = super.getInput();
		 
		input.setDadosClientePF(dadosClientePF.getInput());
		input.setDadosPessoaFisica(dadosPessoaFisica.getInput());
		input.setDadosDeContato(dadosDeContato.getInput());
		input.setPreferencias(preferencias.getInput());
		
		return input;
	}
	
	protected ClientePF criarInputVazio(){
		return new ClientePF();
	}
}