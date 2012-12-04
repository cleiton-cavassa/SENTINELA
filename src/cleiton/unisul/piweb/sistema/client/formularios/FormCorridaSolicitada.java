package cleiton.unisul.piweb.sistema.client.formularios;

import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.Formulario;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewForDate;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewParChaveDescricao;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewTextBox;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewWithTitle;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.ClientePF;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.CorridaSolicitada;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.Motorista;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.widgets.BotaoSalvar;
import cleiton.unisul.piweb.sistema.client.SENTINELA;
import cleiton.unisul.piweb.sistema.client.formularios.pesquisa.FormPesquisarClientesPFfactory;
import cleiton.unisul.piweb.sistema.client.formularios.pesquisa.FormPesquisarMotoristasFactory;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.VerticalPanel;


 public class FormCorridaSolicitada extends Formulario<CorridaSolicitada> {

	private VerticalPanel raiz = new VerticalPanel();

	private InputViewParChaveDescricao<ClientePF> cliente 
								= new InputViewParChaveDescricao<ClientePF>
										("ClientePF"
										, "Cliente solicitante"
										, new FormPesquisarClientesPFfactory());
	private InputViewParChaveDescricao <Motorista>motorista 
													= new InputViewParChaveDescricao<Motorista>
														("Motorista"
														, "Motorista escalado"
														, new FormPesquisarMotoristasFactory());
	
	private InputViewForDate dataHoraEmbarque= new InputViewForDate("data e hora de embarque");
	private InputViewTextBox txtBoxLocalEmbarque = new InputViewTextBox(50,500);
	private InputViewWithTitle<String> localEmbarque = new InputViewWithTitle<String>("local de embarque",txtBoxLocalEmbarque);
	private InputViewTextBox txtBoxLocalPrevisaoDesembarque = new InputViewTextBox(50,500);
	private InputViewWithTitle<String> localPrevisaoDesembarque= new InputViewWithTitle<String>("destino previsto",txtBoxLocalPrevisaoDesembarque);
	private InputViewTextBox txtBoxObservacao=new InputViewTextBox(50,500);
	private InputViewWithTitle<String> observacao= new InputViewWithTitle<String>("Obs",txtBoxObservacao);
	
	private boolean habilitado=true;
	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		if (this.habilitado!=habilitado){
			this.habilitado=habilitado;
				cliente.setHabilitado(habilitado);
				motorista.setHabilitado(habilitado);
				txtBoxLocalEmbarque.setHabilitado(habilitado);
				txtBoxLocalPrevisaoDesembarque.setHabilitado(habilitado);
				txtBoxObservacao.setHabilitado(habilitado);
		}
	}
	
	public FormCorridaSolicitada(boolean novoRegistro){
		if(novoRegistro){
			setInput(criarInputVazio());
		}
		
		 
		TabPanel tabPanel = new TabPanel();
		tabPanel.setStyleName("painelCadastro");
		raiz.add(tabPanel);

		tabPanel.setSize("914px", "300");
		
		FlowPanel flow = new FlowPanel(); 
		
		flow.add(cliente);
		flow.add(motorista);
		flow.add(dataHoraEmbarque);
		flow.add(localEmbarque);
		flow.add(localPrevisaoDesembarque);
		flow.add(observacao);
		
		tabPanel.add(flow, "Corrida Solicitada", false);
		
		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		horizontalPanel_1.setSpacing(3);
		raiz.add(horizontalPanel_1);
		horizontalPanel_1.setWidth("211");
		
		Button button_1 =  new BotaoSalvar<CorridaSolicitada>(
				"salvar",this, novoRegistro,true, SENTINELA.getFrota().getChave(),
				new Acionador<CorridaSolicitada>(this) );
		
		horizontalPanel_1.add(button_1);
		
		Button button_2 = new Button("sair");
		
		button_2.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				fechar();
			}
		});
		
		horizontalPanel_1.add(button_2);

		
		tabPanel.selectTab(0);
		
		initWidget(raiz);
		addStyleName("painelCadastro"); 
		
		
	}
	
	@Override public String getTitulo(){
		return "Corrida Solicitada";
	}
	
	@Override 
	public String validarDados(){
		StringBuilder b =new StringBuilder(); 
		if(cliente.getInput()==null){
			b.append("O campo \"cliente\" precisa ser preenchido");
		}
		if(dataHoraEmbarque.getInput()==null){
			b.append("O campo \"data e hora de embarque\" precisa ser preenchido");
		}
		if(localEmbarque.getInput()==null||localEmbarque.getInput().equals("")){
			b.append("O campo \"local de embarque\" precisa ser preenchido");
		}
		
		if (b.length()>0){
			return b.toString();
		}else{
			return null;
		}
	}

	@Override
	public boolean setInput(CorridaSolicitada input) {
		super.setInput(input);
		
		boolean result=true;
		result &=cliente.setInput(input.getCliente());
		result &=motorista.setInput(input.getMotorista());
		result &=dataHoraEmbarque.setInput(input.getDataHoraEmbarque());
		result &=localEmbarque.setInput(input.getLocalEmbarque());
		result &=localPrevisaoDesembarque.setInput(input.getLocalPrevisaoDesembarque()); 
		result &=observacao.setInput(input.getObservacao());
		return result;
	}


	@Override
	public CorridaSolicitada getInput() {
		CorridaSolicitada input = super.getInput();
			input.setCliente(cliente.getInput());
			input.setDataHoraEmbarque(dataHoraEmbarque.getInput());
			input.setLocalEmbarque(localEmbarque.getInput());
			input.setLocalPrevisaoDesembarque(localPrevisaoDesembarque.getInput());
			input.setMotorista(motorista.getInput());
			input.setObservacao(observacao.getInput());
			input.setStatus(CorridaSolicitada.Status.SOLICITADA);
		return input;
	}

	@Override
	protected CorridaSolicitada criarInputVazio() {
		return new CorridaSolicitada();
	}
}