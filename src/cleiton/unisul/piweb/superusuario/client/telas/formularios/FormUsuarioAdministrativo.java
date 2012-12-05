package cleiton.unisul.piweb.superusuario.client.telas.formularios;

import java.util.ArrayList;

import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.FormDadosDeContato;
import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.FormDadosPessoaFisica;
import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.Formulario;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.UsuarioAdministrativo;
import cleiton.unisul.piweb.rpc.shared.respostasdeconsulta.RespostaPersistencia;
import cleiton.unisul.piweb.superusuario.client.telas.formularios.basicos.FormDadosUsuarioAdministrativo;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class FormUsuarioAdministrativo extends
		Formulario<UsuarioAdministrativo> {	
	
	private final FormDadosUsuarioAdministrativo dadosUsuarioAdministrativo = new FormDadosUsuarioAdministrativo(); 
	private final FormDadosDeContato dadosDeContato= new FormDadosDeContato();
	
	private final FormDadosPessoaFisica dadosPessoaFisica = new FormDadosPessoaFisica(); 
	
	private final VerticalPanel raiz;
	
	public String getTitulo(){
		return "Usu‡rio Administrativo";
	}
//	private final ListDataProvider<UsuarioAdministrativo> dataProv;


	@Override
	public UsuarioAdministrativo getInput(){
		UsuarioAdministrativo input= super.getInput();
		
		input.setDadosUsuarioAdministrativo(dadosUsuarioAdministrativo.getInput());
		
//		PessoaFisica p= new PessoaFisica();
//			p.setDadosDeContato(dadosDeContato.getInput());
//			p.setDadosPessoaFisica(dadosPessoaFisica.getInput());
		input.getPessoaFisica().setDadosDeContato(dadosDeContato.getInput());
		input.getPessoaFisica().setDadosPessoaFisica(dadosPessoaFisica.getInput());
//		input.setPessoaFisica(p);
		
		return input;
	}
	
	@Override
	public boolean setInput(UsuarioAdministrativo input){
		boolean result = super.setInput(input);
		
		result &= dadosUsuarioAdministrativo.setInput(input.getDadosUsuarioAdministrativo());
		result &= dadosPessoaFisica.setInput(input.getPessoaFisica().getDadosPessoaFisica());
		result &= dadosDeContato.setInput(input.getPessoaFisica().getDadosDeContato());
		
		return result;
	}
	
	FormUsuarioAdministrativo eu;
	public FormUsuarioAdministrativo(){//(ListDataProvider<UsuarioAdministrativo> dataProvider){
		eu=this;
//		this.dataProv=dataProvider;
		
		raiz = new VerticalPanel();
		TabPanel tabPanel = new TabPanel();
		raiz.add(tabPanel);
		initWidget(raiz);
		
		tabPanel.setSize("915px", "100%");
		
		tabPanel.add(dadosUsuarioAdministrativo, "Dados Administrativos", false);
		tabPanel.add(dadosPessoaFisica , "Dados da Pessoa F\u00EDsica", false);
		tabPanel.add(dadosDeContato, "Dados de contato", false);
		
		
		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		horizontalPanel_1.setSpacing(3);
		raiz.add(horizontalPanel_1);
		horizontalPanel_1.setWidth("211");
		
		Button button_1 = new Button("Ok");
			button_1.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {

					for(BotoesHandler bh: salvarHandlers){
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

					for(BotoesHandler bh: excluirHandlers){
						bh.enviar(getInput());
					}
					fechar();
				}
			});
		
		horizontalPanel_1.add(button_2);
		setStyleName("painelCadastro"); 
		
		setStyleName("painelCadastro");
		tabPanel.selectTab(0);
	} 
			
	public void addExcluirHandler(BotoesHandler handler){
		excluirHandlers.add(handler);
	}
	
	private ArrayList<BotoesHandler > excluirHandlers=new ArrayList<BotoesHandler >(); 
	public interface BotoesHandler{
		void enviar(UsuarioAdministrativo aSalvar);
		void sucesso(RespostaPersistencia resposta);
		void falha(Throwable caught);
	}
	
	
	
	public void addSalvarHandler(BotoesHandler handler){
		salvarHandlers.add(handler);
	}
	
	private ArrayList<BotoesHandler> salvarHandlers=new ArrayList<BotoesHandler>(); 
	
	@Override
	protected UsuarioAdministrativo criarInputVazio() {
		return new UsuarioAdministrativo();
	}
	
	

}
