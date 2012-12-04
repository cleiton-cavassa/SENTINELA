package cleiton.unisul.piweb.sistema.client.formularios.individuais;

import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.FormDadosDeContato;
import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.FormDadosPessoaJuridica;
import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.FormPesquisar.PesquisaCallBack;
import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.Formulario;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.ClientePJ;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.PessoaJuridica;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.widgets.BotaoSalvar;
import cleiton.unisul.piweb.sistema.client.SENTINELA;
import cleiton.unisul.piweb.sistema.client.formularios.Acionador;
import cleiton.unisul.piweb.sistema.client.formularios.FormClientesPFVinculados;
import cleiton.unisul.piweb.sistema.client.formularios.FormDadosClientePJ;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class FormClientePJ extends Formulario<ClientePJ>{
	
	@Override
	public String getTitulo(){
		return "Sentinela - Clientes Pessoa Juridica";
	}
	
	private final VerticalPanel raiz;
	private final FormDadosPessoaJuridica dadosPessoaJuridica= new FormDadosPessoaJuridica();
	private final FormDadosDeContato dadosDeContato= new FormDadosDeContato();
	private final FormDadosClientePJ dadosClientePJ= new FormDadosClientePJ();
	private final FormClientesPFVinculados clientesPFVinculados = new FormClientesPFVinculados();
	
	public FormClientePJ(final PesquisaCallBack<ClientePJ> callback) {
		this.setInput(criarInputVazio());
		raiz = new VerticalPanel();
		Button salvar= new Button("salvar");
			salvar.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					callback.sucesso(getInput());
					fechar();
				}
			});
		criarTela(salvar);
	}
	
	public FormClientePJ(boolean novoRegistro) {
		if(novoRegistro){
			this.setInput(criarInputVazio());
		}
		raiz = new VerticalPanel();
		
		criarTela(new BotaoSalvar<ClientePJ>(
					"salvar",this, novoRegistro,true, SENTINELA.getFrota().getChave(),
					new Acionador<ClientePJ>(this) )
						);
	}

	private void criarTela(Button botao){
		

		TabPanel tabPanel = new TabPanel();
		raiz.add(tabPanel);
		initWidget(raiz);
		
		tabPanel.setSize("915px", "100%");
		
		tabPanel.add(dadosPessoaJuridica, "Dados da Pessoa Jur\u00EDdica", false);
		tabPanel.add(dadosDeContato, "Dados de contato", false);
		tabPanel.add(dadosClientePJ, "Dados do cliente", false);
		tabPanel.add(clientesPFVinculados, "Clientes Pessoa F\u00EDsica vinculados", false);
		
		clientesPFVinculados.setSize("100%", "");
		
		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		horizontalPanel_1.setSpacing(3);
		raiz.add(horizontalPanel_1);
		horizontalPanel_1.setWidth("211");
		
		Button button_1 = botao;
		
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
	public boolean setInput(ClientePJ input) {
		super.setInput(input);
		
		boolean result=true;
		
		result&=dadosPessoaJuridica.setInput(input.getPessoaJuridica().getDadosPessoaJuridica());
		result&=dadosDeContato.setInput(input.getPessoaJuridica().getDadosDeContato());
		result&=dadosClientePJ.setInput(input.getDadosClientePJ());
		result&=clientesPFVinculados.setInput(input.getClientesPFVinculados());
		
		return result;
	}
	
	@Override
	public ClientePJ getInput() {
		ClientePJ input = super.getInput();
		
		input.setDadosClientePJ(dadosClientePJ.getInput());
		PessoaJuridica p = input.getPessoaJuridica();
			p.setDadosDeContato(dadosDeContato.getInput());
			p.setDadosPessoaJuridica(dadosPessoaJuridica.getInput());
		input.setPessoaJuridica(p);
		input.setClientesPFVinculados(clientesPFVinculados.getInput());
		
		
		return input;
	}
	@Override
	protected ClientePJ criarInputVazio() {
		return new ClientePJ();
	}
}