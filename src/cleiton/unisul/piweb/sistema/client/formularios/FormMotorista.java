package cleiton.unisul.piweb.sistema.client.formularios;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.exibidor.InputView;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.ClientePF;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.DadosPessoaFisica;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.Motorista;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.PessoaFisica;

public class FormMotorista extends Formulario implements InputView<Motorista> {

	
	private VerticalPanel raiz;
	private FormDadosPessoaFisica dadosPessoaFisica = new FormDadosPessoaFisica();
	private FormDadosDeContato dadosDeContato= new FormDadosDeContato();
	private FormPreferencias preferencias= new FormPreferencias();
	private FormDadosProfissionais dadosProfissionais= new FormDadosProfissionais();

	/**
	 * @wbp.parser.constructor
	 */
	public FormMotorista(){
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
		
		Button button_1 = new Button("New button");
		button_1.setText("salvar");
		horizontalPanel_1.add(button_1);
		
		Button button_2 = new Button("New button");
		button_2.setText("excluir");
		horizontalPanel_1.add(button_2);
		setStyleName("painelCadastro"); 
		
		tabPanel.selectTab(0);
	}
	
	@Override
	public boolean setInput(Motorista input) {
		// TODO Auto-generated method stub
		Boolean result;
		result = dadosPessoaFisica.setInput(input.getDadosPessoais().getDadosPessoaFisica());
		result &= dadosDeContato.setInput(input.getDadosPessoais().getDadosDeContato());
		result &= preferencias.setInput(input.getPreferencias());
		result &= dadosProfissionais.setInput(input.getDadosProfissionais());
		return result;
	}

	@Override
	public Motorista getInput() {
		Motorista m = new Motorista();
		PessoaFisica d = new PessoaFisica();
			d.setDadosPessoaFisica(dadosPessoaFisica.getInput());
			d.setDadosDeContato(dadosDeContato.getInput());
		m.setDadosPessoais(d);
		m.setDadosProfissionais(dadosProfissionais.getInput());
		m.setPreferencias(preferencias.getInput());
		return m;
	}
	
	

}
