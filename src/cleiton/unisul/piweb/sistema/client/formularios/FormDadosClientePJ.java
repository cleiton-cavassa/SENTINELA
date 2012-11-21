package cleiton.unisul.piweb.sistema.client.formularios;

import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.InputViewForEnums;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.exibidor.InputView;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.DadosClientePJ;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.DadosClientePJ.Status;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.DadosClientePJ.Voucher;

import com.google.gwt.user.client.ui.VerticalPanel;

public class FormDadosClientePJ extends Formulario implements InputView<DadosClientePJ>{
	
	private final VerticalPanel verticalPanel=new VerticalPanel();
	private final InputViewForEnums<Status>status= new InputViewForEnums<Status>(Status.Ativo,"Status",false); 
	private final InputViewForEnums<Voucher>voucher= new InputViewForEnums<Voucher>(Voucher.Ativado, "Voucher", false);
	
	public FormDadosClientePJ(){
		this.initWidget(verticalPanel);
		verticalPanel.add(status);
		verticalPanel.add(voucher);
	}

	@Override
	public boolean setInput(DadosClientePJ input) {
		Boolean result;
		result = status.setInput(input.getStatus());
		result &= voucher.setInput(input.getVoucher());
		return result;
	}

	@Override
	public DadosClientePJ getInput() {
		DadosClientePJ input = new DadosClientePJ();
			input.setStatus(status.getInput());
			input.setVoucher(voucher.getInput());
		return input;
	}
}
