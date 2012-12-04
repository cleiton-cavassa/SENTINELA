package cleiton.unisul.piweb.superusuario.client.telas.formularios;

import java.util.ArrayList;

import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.FormDadosDeContato;
import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.FormDadosPessoaJuridica;
import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.Formulario;
import cleiton.unisul.piweb.rpc.client.TabelasAtualizador;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.Frota;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.PessoaJuridica;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.widgets.BotaoSalvar;
import cleiton.unisul.piweb.rpc.shared.respostasdeconsulta.RespostaPersistencia;
import cleiton.unisul.piweb.superusuario.client.telas.formularios.basicos.FormTabelaUsuariosAdministrativos;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;

public class FormFrota extends Formulario<Frota>{

	@Override
	public Widget asWidget(){
		return this;
	}

	
	private VerticalPanel raiz=new VerticalPanel();
	private FormDadosPessoaJuridica dadosPessoaJuridica = new FormDadosPessoaJuridica();
	private FormDadosDeContato dadosDeContato= new FormDadosDeContato();
	private FormTabelaUsuariosAdministrativos usuariosAdministrativos = new FormTabelaUsuariosAdministrativos(); 
	
	public FormFrota(TabelasAtualizador<Frota> atualizador, ListDataProvider<Frota> dataProvider){
		setInput(new Frota());
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
		
		Button button_1 = new BotaoSalvar<Frota>("salvar", this, true, false, null, new AcionadorSalvarFrota());
		button_1.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				for(BotoesHandler bh:salvarHandlers){
					bh.enviar(getInput());
				}
				fechar();
			}
		});
		horizontalPanel_1.add(button_1);
		
		Button button_2 = new Button("cancelar");
		button_2.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				for(BotoesHandler bh:excluirHandlers){
					bh.enviar(getInput());
				}
				fechar();
			}
		});
		
		
		horizontalPanel_1.add(button_2);
		setStyleName("painelCadastro"); 
		
		tabPanel.selectTab(0);
		
	}
	
	
	private class AcionadorSalvarFrota implements BotaoSalvar.Acionador{
		
		@Override
		public void execute() {}

		@Override
		public AsyncCallback<RespostaPersistencia> getCallback() {
			return new CallbackPersistenciaFrota();
		}
		
	}

	private class CallbackPersistenciaFrota implements AsyncCallback<RespostaPersistencia>{
		
		@Override
		public void onFailure(Throwable caught) {
			caught.printStackTrace();
			Window.alert("N‹o foi poss’vel salvar os dados da frota.\nPor favor, tente novamente:\n"+caught.getLocalizedMessage()+"\n"+caught.getMessage());
			for(BotoesHandler s: salvarHandlers){
				s.falha(caught);
			}
		}

		@Override
		public void onSuccess(RespostaPersistencia result) {
			Window.alert("Dados salvos com sucesso!");
			for(BotoesHandler s: salvarHandlers){
				s.sucesso(result);
			}
		}
	};
	
	
	public void addExcluirHandler(BotoesHandler handler){
		excluirHandlers.add(handler);
	}
	
	private ArrayList<BotoesHandler > excluirHandlers=new ArrayList<BotoesHandler >(); 
	public interface BotoesHandler{
		void enviar(Frota aSalvar);
		void sucesso(RespostaPersistencia resposta);
		void falha(Throwable caught);
	}
	
	
	
	public void addSalvarHandler(BotoesHandler handler){
		salvarHandlers.add(handler);
	}
	
	private ArrayList<BotoesHandler> salvarHandlers=new ArrayList<BotoesHandler>(); 
	
	
	@Override
	public boolean setInput(Frota input) {
		super.setInput(input);
		
		boolean result= true;
		result &= dadosPessoaJuridica.setInput(input.getMeusDadosCompartilhados().getDadosPessoaJuridica().getDadosPessoaJuridica());
		result &= dadosDeContato.setInput(input.getMeusDadosCompartilhados().getDadosPessoaJuridica().getDadosDeContato());
		result &= usuariosAdministrativos.setInput(input.getUsuariosAdministrativos());
		return result;
	}

	@Override
	public Frota getInput() {
		Frota input = super.getInput();
		PessoaJuridica p = input.getMeusDadosCompartilhados().getDadosPessoaJuridica();
			p.setDadosPessoaJuridica(dadosPessoaJuridica.getInput());
			p.setDadosDeContato(dadosDeContato.getInput());
		input.setUsuariosAdministrativos(usuariosAdministrativos.getInput());
		
		return input;
	}

	@Override
	protected Frota criarInputVazio() {
		return new Frota();
	}
}
