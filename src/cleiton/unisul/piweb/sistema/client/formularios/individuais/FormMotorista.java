package cleiton.unisul.piweb.sistema.client.formularios.individuais;

import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.FormDadosDeContato;
import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.FormDadosPessoaFisica;
import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.FormDadosProfissionais;
import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.FormPreferencias;
import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.Formulario;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.Motorista;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.PessoaFisica;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.widgets.BotaoSalvar;
import cleiton.unisul.piweb.sistema.client.SENTINELA;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class FormMotorista extends Formulario<Motorista> {

	
	@Override
	public String getTitulo(){
		return "Sentinela - Cadastro de Motorista";
	}
	
	private VerticalPanel raiz;
	private FormDadosPessoaFisica dadosPessoaFisica = new FormDadosPessoaFisica();
	private FormDadosDeContato dadosDeContato= new FormDadosDeContato();
	private FormPreferencias preferencias= new FormPreferencias();
	private FormDadosProfissionais dadosProfissionais= new FormDadosProfissionais();

	/**
	 * @wbp.parser.constructor
	 */
	public FormMotorista(boolean novoRegistro){
		if(novoRegistro){
			this.setInput(this.criarInputVazio());
		}
		
		raiz = new VerticalPanel();
		TabPanel tabPanel = new TabPanel();
		tabPanel.setStyleName("painelCadastro");
		raiz.add(tabPanel);
		initWidget(raiz);
		tabPanel.setSize("914px", "300");
		
		
		tabPanel.add(dadosPessoaFisica, "Dados da Pessoa F\u00EDsica", false);
		tabPanel.add(dadosDeContato, "Dados de Contato", false);
		tabPanel.add(preferencias, "Prefer\u00EAncias", false);
		tabPanel.add(dadosProfissionais, "Dados profissionais", false);
		
		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		horizontalPanel_1.setSpacing(3);
		raiz.add(horizontalPanel_1);
		horizontalPanel_1.setWidth("211");
		
		Button button_1 =  new BotaoSalvar<Motorista>(
				"salvar",this, novoRegistro,true, SENTINELA.getFrota().getChave(),
				new cleiton.unisul.piweb.sistema.client.formularios.Acionador<Motorista>(this) );
		
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
	public boolean setInput(Motorista input) {
		super.setInput(input);
		
		Boolean result;
		result = dadosPessoaFisica.setInput(input.getDadosPessoais().getDadosPessoaFisica());
		result &= dadosDeContato.setInput(input.getDadosPessoais().getDadosDeContato());
		result &= preferencias.setInput(input.getPreferencias());
		result &= dadosProfissionais.setInput(input.getDadosProfissionais());
		return result;
	}

	@Override
	public Motorista getInput() {
		Motorista m = super.getInput();
		
		PessoaFisica d = m.getDadosPessoais();
			d.setDadosPessoaFisica(dadosPessoaFisica.getInput());
			d.setDadosDeContato(dadosDeContato.getInput());
		m.setDadosPessoais(d);
		m.setDadosProfissionais(dadosProfissionais.getInput());
		m.setPreferencias(preferencias.getInput());
		return m;
	}

	@Override
	protected Motorista criarInputVazio() {
		return new Motorista();
	}
	
	

}
