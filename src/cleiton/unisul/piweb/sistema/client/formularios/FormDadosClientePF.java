package cleiton.unisul.piweb.sistema.client.formularios;

import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.InputViewForEnums;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.exibidor.InputView;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.DadosClientePF;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.DadosClientePF.Status;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.DadosClientePF.TipoNacionalidade;

import com.google.gwt.user.client.ui.VerticalPanel;

public class FormDadosClientePF extends Formulario implements InputView<DadosClientePF>{
	
	private final VerticalPanel verticalPanel=new VerticalPanel();
	private final InputViewForEnums<Status>status= new InputViewForEnums<Status>(Status.Ativo,"Status",false); 
	private final InputViewForEnums<TipoNacionalidade>tipoNacionalidade= new InputViewForEnums<TipoNacionalidade>(TipoNacionalidade.Brasileiro, "Nacionalidade", false);
	
	public FormDadosClientePF(){
		this.initWidget(verticalPanel);
		verticalPanel.add(status);
		verticalPanel.add(tipoNacionalidade);
	}

	@Override
	public boolean setInput(DadosClientePF input) {
		Boolean result;
		result = status.setInput(input.getStatus());
		result &= tipoNacionalidade.setInput(input.getTipoNacionalidade());
		return result;
	}

	@Override
	public DadosClientePF getInput() {
		DadosClientePF input = new DadosClientePF();
			input.setStatus(status.getInput());
			input.setTipoNacionalidade(tipoNacionalidade.getInput());
		return input;
	}
}
