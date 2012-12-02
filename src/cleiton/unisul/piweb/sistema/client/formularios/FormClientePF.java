package cleiton.unisul.piweb.sistema.client.formularios;

import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.FormDadosDeContato;
import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.FormDadosPessoaFisica;
import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.FormPreferencias;
import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.Formulario;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.ClientePF;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.widgets.BotaoSalvar;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
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
	

	/**
	 * @wbp.parser.constructor
	 */
	public FormClientePF() {
		
		this.setInput(new ClientePF());
		
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
		
		Button button_1 = new BotaoSalvar<ClientePF>(
							"salvar",this, true,true,
							new cleiton.unisul.piweb.sistema.client.formularios.Acionador<ClientePF>(this));
		
		horizontalPanel_1.add(button_1);
		
		Button button_2 = new Button("excluir");
		
		button_2.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				fechar();
			}
		});
		
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