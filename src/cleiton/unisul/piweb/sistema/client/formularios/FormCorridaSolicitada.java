package cleiton.unisul.piweb.sistema.client.formularios;

import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.Formulario;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewForDate;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewParChaveDescricao;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewTextBox;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewWithTitle;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.CorridaSolicitada;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.VerticalPanel;


 public class FormCorridaSolicitada extends Formulario<CorridaSolicitada> {

	private VerticalPanel raiz=new VerticalPanel();

	private InputViewParChaveDescricao clienteSolicitante = new InputViewParChaveDescricao("ClientePF", "Cliente solicitante");
	private InputViewParChaveDescricao motoristaEscolhido = new InputViewParChaveDescricao("Motorista", "Motorista escalado");
	private InputViewForDate dataHoraEmbarque= new InputViewForDate("data e hora de embarque");
	private InputViewWithTitle<String> localEmbarque = new InputViewWithTitle<String>("local de embarque",new InputViewTextBox(50,500));
	private InputViewWithTitle<String> localPrevisaoDesembarque= new InputViewWithTitle<String>("destino previsto",new InputViewTextBox(50,500)); 
	private InputViewWithTitle<String> observacao= new InputViewWithTitle<String>("Obs",new InputViewTextBox(50,500));
	
	public FormCorridaSolicitada(){
		raiz = new VerticalPanel(); 
		TabPanel tabPanel = new TabPanel();
		tabPanel.setStyleName("painelCadastro");
		raiz.add(tabPanel);

		tabPanel.setSize("914px", "300");
		
		FlowPanel flow = new FlowPanel(); 
		
		flow.add(clienteSolicitante);
		flow.add(motoristaEscolhido);
		flow.add(dataHoraEmbarque);
		flow.add(localEmbarque);
		flow.add(localPrevisaoDesembarque);
		flow.add(observacao);
		
		tabPanel.add(flow, "Corrida Solicitada", false);
		
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
		if(clienteSolicitante.getInput()==null){
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
		result &=clienteSolicitante.setInput(input.getCliente());
		result &=motoristaEscolhido.setInput(input.getMotorista());
		result &=dataHoraEmbarque.setInput(input.getDataHoraEmbarque());
		result &=localEmbarque.setInput(input.getLocalEmbarque());
		result &=localPrevisaoDesembarque.setInput(input.getLocalPrevisaoDesembarque()); 
		result &=observacao.setInput(input.getObservacao());
		return result;
	}


	@Override
	public CorridaSolicitada getInput() {
		CorridaSolicitada input = super.getInput();
			input.setCliente(clienteSolicitante.getInput());
			input.setDataHoraEmbarque(dataHoraEmbarque.getInput());
			input.setLocalEmbarque(localEmbarque.getInput());
			input.setLocalPrevisaoDesembarque(localPrevisaoDesembarque.getInput());
			input.setMotorista(motoristaEscolhido.getInput());
			input.setObservacao(observacao.getInput());
		return input;
	}

	@Override
	protected CorridaSolicitada criarInputVazio() {
		return new CorridaSolicitada();
	}
}