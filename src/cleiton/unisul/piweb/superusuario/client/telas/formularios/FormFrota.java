package cleiton.unisul.piweb.superusuario.client.telas.formularios;

import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.FormDadosDeContato;
import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.FormDadosPessoaJuridica;
import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.Formulario;
import cleiton.unisul.piweb.rpc.shared.RespostaPersistencia;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.DadosPessoaJuridica;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.Frota;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.FrotaDadosCompartilhados;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.PessoaJuridica;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.widgets.BotaoSalvar;
import cleiton.unisul.piweb.superusuario.client.telas.formularios.basicos.FormTabelaUsuariosAdministrativos;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class FormFrota extends Formulario<Frota>{

	private VerticalPanel raiz=new VerticalPanel();
	private FormDadosPessoaJuridica dadosPessoaJuridica = new FormDadosPessoaJuridica();
	private FormDadosDeContato dadosDeContato= new FormDadosDeContato();
	private FormTabelaUsuariosAdministrativos usuariosAdministrativos = new FormTabelaUsuariosAdministrativos(); 
	
	public FormFrota(){
		raiz = new VerticalPanel();
		TabPanel tabPanel = new TabPanel();
		tabPanel.setStyleName("painelCadastro");
		raiz.add(tabPanel);
		initWidget(raiz);
		tabPanel.setSize("914px", "300");
		
		
		tabPanel.add(dadosPessoaJuridica, "Dados da Pessoa Jur\u00EDdica", false);
		tabPanel.add(dadosDeContato, "Dados de Contato", false);
		tabPanel.add(usuariosAdministrativos, "Usuarios Administrativos", false);
		
		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		horizontalPanel_1.setSpacing(3);
		raiz.add(horizontalPanel_1);
		horizontalPanel_1.setWidth("211");
		
		Button button_1 = new BotaoSalvar<Frota>("salvar", this, true, false, new CallbackPersistenciaFrota());
		button_1.setText("salvar");
		horizontalPanel_1.add(button_1);
		
		Button button_2 = new Button("New button");
		button_2.setText("excluir");
		horizontalPanel_1.add(button_2);
		setStyleName("painelCadastro"); 
		
		tabPanel.selectTab(0);
		
		
	}

	private class CallbackPersistenciaFrota implements AsyncCallback<RespostaPersistencia>{
		
		@Override
		public void onFailure(Throwable caught) {
			Window.alert("N‹o foi poss’vel salvar os dados do usuario administrativo.\nPor favor, tente novamente.");
		}

		@Override
		public void onSuccess(RespostaPersistencia result) {
			Window.alert("Dados salvos com sucesso:\n");
			
		}
	};
	
	
	
	
	
	@Override
	public boolean setInput(Frota input) {
		super.setInput(input);
		
		boolean result= true;
		result &= dadosPessoaJuridica.setInput(input.getMeusDadosCompartilhados().getDadosPessoaJuridica().getDadosPessoaJuridica());
		result &= dadosDeContato.setInput(input.getMeusDadosCompartilhados().getDadosPessoaJuridica().getDadosDeContato());

		return result;
	}

	@Override
	public Frota getInput() {
		Frota input = super.getInput();		
		
		input.setMeusDadosCompartilhados(new FrotaDadosCompartilhados());
		input.getMeusDadosCompartilhados().setDadosPessoaJuridica(new PessoaJuridica());
		input.getMeusDadosCompartilhados().getDadosPessoaJuridica().setDadosPessoaJuridica(new DadosPessoaJuridica());
		
		input.getMeusDadosCompartilhados().getDadosPessoaJuridica().setDadosPessoaJuridica(dadosPessoaJuridica.getInput());
		input.getMeusDadosCompartilhados().getDadosPessoaJuridica().setDadosDeContato(dadosDeContato.getInput());
		
		
		return input;
	}

	@Override
	protected Frota criarInputVazio() {
		return new Frota();
	}
}
