package cleiton.unisul.piweb.superusuario.client.telas.formularios.basicos;

import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.Formulario;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewForEnums;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewTextBox;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.DadosUsuarioAdministrativo;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.DadosUsuarioAdministrativo.NivelAcesso;

import com.google.gwt.user.client.ui.FlowPanel;

public class FormDadosUsuarioAdministrativo extends
		Formulario<DadosUsuarioAdministrativo> {

	private FlowPanel flow = new FlowPanel();
	
	private InputViewTextBox email = new InputViewTextBox(50, 100);
	private InputViewForEnums<NivelAcesso> nivel= 
				new InputViewForEnums<NivelAcesso>
					(NivelAcesso.Administrador1,
					"Credencial de acesso", 
					false); 
	
	public FormDadosUsuarioAdministrativo(){
		
		initWidget(flow);
		
		flow.add(email);
		flow.add(nivel);
	}
	
	@Override
	public  DadosUsuarioAdministrativo getInput(){
		DadosUsuarioAdministrativo input = super.getInput();
		
		input.setEmail(email.getInput());
		input.setNivelAcesso(nivel.getInput());
		
		return input;
	}
	
	@Override
	public boolean setInput(DadosUsuarioAdministrativo input){
		super.setInput(input);
		
		boolean result = true;
		result &= email.setInput(input.getEmail());
		result &= nivel.setInput(input.getNivelAcesso());
		
		return result;
	}
	
	
	@Override
	protected DadosUsuarioAdministrativo criarInputVazio() {
		return new DadosUsuarioAdministrativo();
	}

}
