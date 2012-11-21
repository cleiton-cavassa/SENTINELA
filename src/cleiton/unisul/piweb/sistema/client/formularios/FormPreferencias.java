package cleiton.unisul.piweb.sistema.client.formularios;

import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.InputViewForEnums;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.exibidor.InputView;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.DadosClientePF;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.Preferencias;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.Preferencias.MotoristaFumante;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.Preferencias.TransportaAnimais;

import com.google.gwt.user.client.ui.VerticalPanel;

public class FormPreferencias extends Formulario implements InputView<Preferencias>{
	
	private VerticalPanel verticalPanel=new VerticalPanel();
	private InputViewForEnums<MotoristaFumante>motFum= new InputViewForEnums<MotoristaFumante>(MotoristaFumante.Sim,"Motorista fumante ?",false); 
	private InputViewForEnums<TransportaAnimais>animais= new InputViewForEnums<TransportaAnimais>(TransportaAnimais.Sim,"Transporta animais?",false);
	
	FormPreferencias(){
		this.initWidget(verticalPanel);
		verticalPanel.add(motFum);
		verticalPanel.add(animais);
	}

	@Override
	public boolean setInput(Preferencias input) {
		Boolean result =motFum.setInput(input.getMotoristaFumante());
		result &=animais.setInput(input.getTransportaAnimais());
		return result;
	}

	@Override
	public Preferencias getInput() {
		Preferencias input=new Preferencias();
			input.setMotoristaFumante(motFum.getInput());
			input.setTransportaAnimais(animais.getInput());
		return input;
	}
}