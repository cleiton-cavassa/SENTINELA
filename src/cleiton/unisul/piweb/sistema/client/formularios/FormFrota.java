package cleiton.unisul.piweb.sistema.client.formularios;

import cleiton.unisul.piweb.rpc.shared.objetoschaveados.FrotaDadosCompartilhados;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class FormFrota extends Formulario<FrotaDadosCompartilhados>{

	private VerticalPanel raiz=new VerticalPanel();
	private FormDadosPessoaJuridica dadosPessoaJuridica = new FormDadosPessoaJuridica();
	private FormDadosDeContato dadosDeContato= new FormDadosDeContato();

	
	public FormFrota(){
		raiz = new VerticalPanel();
		TabPanel tabPanel = new TabPanel();
		tabPanel.setStyleName("painelCadastro");
		raiz.add(tabPanel);
		initWidget(raiz);
		tabPanel.setSize("914px", "300");
		
		
		tabPanel.add(dadosPessoaJuridica, "Dados da Pessoa Jur\u00EDdica", false);
		tabPanel.add(dadosDeContato, "Dados de Contato", false);
		
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
	public boolean setInput(FrotaDadosCompartilhados input) {
		super.setInput(input);
		
		boolean result= true;
		result &= dadosPessoaJuridica.setInput(input.getDadosPessoaJuridica().getDadosPessoaJuridica());
		result &= dadosDeContato.setInput(input.getDadosPessoaJuridica().getDadosDeContato());

		return result;
	}

	@Override
	public FrotaDadosCompartilhados getInput() {
		FrotaDadosCompartilhados input = super.getInput();
		
		input.getDadosPessoaJuridica().setDadosPessoaJuridica(dadosPessoaJuridica.getInput());
		input.getDadosPessoaJuridica().setDadosDeContato(dadosDeContato.getInput());		
		
		return input;
	}
}
