package cleiton.unisul.piweb.sistema.client.formularios;

import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewCorridaSolicitada;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewForDate;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewTextBox;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewWithTitle;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.CorridaFinalizada;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class FormCorridaFinalizada extends Formulario<CorridaFinalizada> {
	
	private VerticalPanel raiz=new VerticalPanel();

	private InputViewCorridaSolicitada corridaSolicitada = new InputViewCorridaSolicitada("ClientePF", "Corrida Solicitada");
	private InputViewForDate dataHoraDesembarque= new InputViewForDate("data e hora de chegada ao destino"); 
	private InputViewWithTitle<String> localDesembarque= new InputViewWithTitle<String>("local do desembarque",new InputViewTextBox(50,500));
	
	
	public FormCorridaFinalizada(){
		raiz = new VerticalPanel(); 
		TabPanel tabPanel = new TabPanel();
		tabPanel.setStyleName("painelCadastro");
		raiz.add(tabPanel);

		tabPanel.setSize("914px", "300");
		
		FlowPanel flow = new FlowPanel(); 
		
		flow.add(corridaSolicitada);
		flow.add(dataHoraDesembarque);
		flow.add(localDesembarque);
		
		tabPanel.add(flow, "Corrida Finalizada", false);
		
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
	public boolean setInput(CorridaFinalizada input){
		super.setInput(input);
		
		boolean result = true;
		result &= corridaSolicitada.setInput(input.getCorridaSolicitada());
		result &= dataHoraDesembarque.setInput(input.getDataHoraDesembarque());
		result &= localDesembarque.setInput(input.getLocalDesembarque());
		
		return result;
	}
	
	@Override
	public CorridaFinalizada getInput(){
		CorridaFinalizada input= super.getInput();
		
		input.setCorridaSolicitada(corridaSolicitada.getInput());
		input.setDataHoraDesembarque(dataHoraDesembarque.getInput());
		input.setLocalDesembarque(localDesembarque.getInput());
		
		return input;
	}

	@Override
	protected CorridaFinalizada criarInputVazio() {
		return new CorridaFinalizada();
	}
		
	

}
