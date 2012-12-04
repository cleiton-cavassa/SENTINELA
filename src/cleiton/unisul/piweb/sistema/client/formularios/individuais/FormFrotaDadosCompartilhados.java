package cleiton.unisul.piweb.sistema.client.formularios.individuais;

import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.FormDadosDeContato;
import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.FormDadosPessoaJuridica;
import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.Formulario;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.ClientePF;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.FrotaDadosCompartilhados;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.widgets.BotaoSalvar;
import cleiton.unisul.piweb.sistema.client.SENTINELA;
import cleiton.unisul.piweb.sistema.client.formularios.Acionador;
import cleiton.unisul.piweb.sistema.client.formularios.frota.FormClientesPFdeUmaFrota;
import cleiton.unisul.piweb.sistema.client.formularios.frota.FormClientesPJdeUmaFrota;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class FormFrotaDadosCompartilhados extends Formulario<FrotaDadosCompartilhados>{

	private VerticalPanel raiz=new VerticalPanel();
	private FormDadosPessoaJuridica dadosPessoaJuridica = new FormDadosPessoaJuridica();
	private FormDadosDeContato dadosDeContato= new FormDadosDeContato();
	private FormClientesPJdeUmaFrota clientesPJ= new FormClientesPJdeUmaFrota();
	private FormClientesPFdeUmaFrota clientesPF= new FormClientesPFdeUmaFrota();

	
	public FormFrotaDadosCompartilhados(boolean novoRegistro){
		if(novoRegistro){
			this.setInput(criarInputVazio());
		}
		
		raiz = new VerticalPanel();
		TabPanel tabPanel = new TabPanel();
		tabPanel.setStyleName("painelCadastro");
		raiz.add(tabPanel);
		initWidget(raiz);
		tabPanel.setSize("914px", "300");
		
		
		tabPanel.add(dadosPessoaJuridica, "Dados da Pessoa Jur\u00EDdica", false);
		tabPanel.add(dadosDeContato, "Dados de Contato", false);
		tabPanel.add(clientesPJ, "Clientes Pessoas Juridicas", false);
		tabPanel.add(clientesPF, "Clientes Pessoas Fisicas", false);
		
		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		horizontalPanel_1.setSpacing(3);
		raiz.add(horizontalPanel_1);
		horizontalPanel_1.setWidth("211");
		
		Button button_1 = new BotaoSalvar<FrotaDadosCompartilhados>(
				"salvar",this, novoRegistro,true, SENTINELA.getFrota().getChave(),
				new Acionador<FrotaDadosCompartilhados>(this) );
					
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
	public boolean setInput(FrotaDadosCompartilhados input) {
		super.setInput(input);
		
		boolean result= true;
		result &= dadosPessoaJuridica.setInput(input.getDadosPessoaJuridica().getDadosPessoaJuridica());
		result &= dadosDeContato.setInput(input.getDadosPessoaJuridica().getDadosDeContato());
		result &= clientesPJ.setInput(input.getClientesPJ());
		result &= clientesPF.setInput(input.getClientesPF());

		return result;
	}

	@Override
	public FrotaDadosCompartilhados getInput() {
		FrotaDadosCompartilhados input = super.getInput();
		
		input.getDadosPessoaJuridica().setDadosPessoaJuridica(dadosPessoaJuridica.getInput());
		input.getDadosPessoaJuridica().setDadosDeContato(dadosDeContato.getInput());		
		input.setClientesPJ(clientesPJ.getInput());
		input.setClientesPF(clientesPF.getInput());
		
		return input;
	}

	@Override
	protected FrotaDadosCompartilhados criarInputVazio() {
		return new FrotaDadosCompartilhados();
	}
}
