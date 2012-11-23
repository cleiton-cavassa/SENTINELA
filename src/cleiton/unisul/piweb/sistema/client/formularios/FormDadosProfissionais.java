package cleiton.unisul.piweb.sistema.client.formularios;

import java.util.Collection;

import com.google.gwt.user.client.ui.FlowPanel;

import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.InputViewWithTitle;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.Painel;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.RolTurnos;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.exibidor.InputCollectionToHTMLStringParser;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.exibidor.InputView;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputviews.InputViewTextBox;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.DadosProfissionais;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.Turno;

public class FormDadosProfissionais  extends Formulario implements InputView<DadosProfissionais>{
	
	private InputViewWithTitle<String> carro=new InputViewWithTitle <String>("Carro", new InputViewTextBox(50,100));
	private Painel<Collection<Turno>>turnos = new Painel<Collection<Turno>>("Turnos",new RolTurnos(), new InputCollectionToHTMLStringParser<Turno>());
	private FlowPanel f= new FlowPanel();
	
	public FormDadosProfissionais(){
		initWidget(f);
		
		f.add(carro);
		f.add(turnos);
	}

	@Override
	public boolean setInput(DadosProfissionais input) {
		return carro.setInput(input.getCarro());
	}

	@Override
	public DadosProfissionais getInput() {
		DadosProfissionais result = new DadosProfissionais ();
		
		result.setCarro(carro.getInput());
		result.setTurnos(turnos.getInput());
		
		return result;
	}
	
}
