package cleiton.unisul.piweb.sistema.client.formularios;

import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewCorridaSolicitada;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewForDate;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewTextBox;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewWithTitle;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.CorridaCancelada;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class FormCorridaCancelada extends Formulario<CorridaCancelada> {
	
	private VerticalPanel raiz=new VerticalPanel();

	private InputViewCorridaSolicitada corridaSolicitada = new InputViewCorridaSolicitada("ClientePF", "Corrida Solicitada");
	private InputViewForDate dataHoraCancelamento= new InputViewForDate("data e hora em que o cancelamento foi solicitado"); 
	private InputViewWithTitle<String> motivo= new InputViewWithTitle<String>("Motivo do cancelamento",new InputViewTextBox(50,500));
	
	
	public FormCorridaCancelada(){
		raiz = new VerticalPanel(); 
		TabPanel tabPanel = new TabPanel();
		tabPanel.setStyleName("painelCadastro");
		raiz.add(tabPanel);

		tabPanel.setSize("914px", "300");
		
		FlowPanel flow = new FlowPanel(); 
		
		flow.add(corridaSolicitada);
		flow.add(dataHoraCancelamento);
		flow.add(motivo);
		
		tabPanel.add(flow, "Corrida Cancelada", false);
		
		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		horizontalPanel_1.setSpacing(3);
		raiz.add(horizontalPanel_1);
		horizontalPanel_1.setWidth("211");
		
		Button button_1 = new Button("salvar");
		horizontalPanel_1.add(button_1);
		
		Button button_2 = new Button("sair sem salvar");
		horizontalPanel_1.add(button_2);

		
		tabPanel.selectTab(0);
		
		initWidget(raiz);
		addStyleName("painelCadastro"); 
		
	}
	
	@Override
	public boolean setInput(CorridaCancelada input){
		super.setInput(input);
		
		boolean result = true;
		result &= corridaSolicitada.setInput(input.getCorridaSolicitada());
		result &= dataHoraCancelamento.setInput(input.getDataHoraCancelamento());
		result &= motivo.setInput(input.getMotivo());
		
		return result;
	}
	
	@Override
	public CorridaCancelada getInput(){
		CorridaCancelada input= super.getInput();
		
		input.setCorridaSolicitada(corridaSolicitada.getInput());
		input.setDataHoraCancelamento(dataHoraCancelamento.getInput());
		input.setMotivo(motivo.getInput());
		
		return input;
	}

	@Override
	protected CorridaCancelada criarInputVazio() {
		return new CorridaCancelada();
	}
	
	
	
}

