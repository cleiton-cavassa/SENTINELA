package cleiton.unisul.piweb.sistema.client.formularios;

import java.util.Collection;

import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.mural.Mural;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.mural.inputparsers.InputParserCollectionToHTMLString;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.rol.impl.RolTurnos;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewTextBox;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewWithTitle;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.DadosProfissionais;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.Turno;

import com.google.gwt.user.client.ui.FlowPanel;

public class FormDadosProfissionais  extends Formulario<DadosProfissionais>{
	
	@Override
	public String getTitulo(){
		return "Sentinela - Dados de Profissinais";
	}
	
	private InputViewWithTitle<String> carro=new InputViewWithTitle <String>("Carro", new InputViewTextBox(50,100));
	private Mural<Collection<Turno>>turnos = new Mural<Collection<Turno>>("Turnos",new RolTurnos(), new InputParserCollectionToHTMLString<Turno>());
	private FlowPanel f= new FlowPanel();
	
	public FormDadosProfissionais(){
		initWidget(f);
		f.addStyleName("padding10");
		f.add(carro);
		f.add(turnos);
	}

	@Override
	public boolean setInput(DadosProfissionais input) {
		super.setInput(input);
		
		boolean result=true;
		result &= carro.setInput(input.getCarro());
		result &= turnos.setInput(input.getTurnos());		
		
		return result;
	}

	@Override
	public DadosProfissionais getInput() {
		DadosProfissionais result = new DadosProfissionais ();
		
		result.setCarro(carro.getInput());
		result.setTurnos(turnos.getInput());
		
		return result;
	}

	@Override
	protected DadosProfissionais criarInputVazio() {
		return new DadosProfissionais();
	}
	
}
