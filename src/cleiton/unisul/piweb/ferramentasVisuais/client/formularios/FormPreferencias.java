package cleiton.unisul.piweb.ferramentasVisuais.client.formularios;

import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewForEnums;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.Preferencias;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.Preferencias.MotoristaFumante;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.Preferencias.TransportaAnimais;

import com.google.gwt.user.client.ui.VerticalPanel;

public class FormPreferencias extends Formulario<Preferencias>{
	
	@Override
	public String getTitulo(){
		return "Sentinela - Preferencias";
	}
	
	private VerticalPanel verticalPanel=new VerticalPanel();
	private InputViewForEnums<MotoristaFumante>motFum= new InputViewForEnums<MotoristaFumante>(MotoristaFumante.Sim,"Motorista fumante ?",false); 
	private InputViewForEnums<TransportaAnimais>animais= new InputViewForEnums<TransportaAnimais>(TransportaAnimais.Sim,"Transporta animais?",false);
	
	public FormPreferencias(){
		this.initWidget(verticalPanel);
		verticalPanel.add(motFum);
		verticalPanel.add(animais);
	}

	@Override
	public boolean setInput(Preferencias input) {
		Boolean result = true;
		result &= motFum.setInput(input.getMotoristaFumante());
		result &= animais.setInput(input.getTransportaAnimais());
		return result;
	}

	@Override
	public Preferencias getInput() {
		Preferencias input= super.getInput();
			input.setMotoristaFumante(motFum.getInput());
			input.setTransportaAnimais(animais.getInput());
		return input;
	}

	@Override
	protected Preferencias criarInputVazio() {
		return new Preferencias();
	}
}