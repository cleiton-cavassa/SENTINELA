package cleiton.unisul.piweb.sistema.client.formularios;

import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputView;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputViewFactory;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.CorridaCancelada;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.CorridaSolicitada;
import cleiton.unisul.piweb.sistema.client.formularios.individuais.FormCorridaCancelada;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;

public class FormRelacaoCorridasCanceladas extends FormRelacao<CorridaCancelada> {

	@Override
	public String getTitulo() {
		return "Listagem de Corridas Canceladas";
	}

	@Override
	protected CorridaCancelada novoOb() {
		return new CorridaCancelada();
	}
	
	public FormRelacaoCorridasCanceladas() {
		iniciarWidgets();
	}
	
	
	protected CellTable<CorridaCancelada> criarTabela(){
		CellTable<CorridaCancelada> cellTable= new CellTable<CorridaCancelada>();

		cellTable.addColumn(colunaEditar(new InputViewFactory<CorridaCancelada>() {
			@Override
			public InputView<CorridaCancelada> getInputView() {
				return new FormCorridaCancelada(false,new CorridaSolicitada());
			}
		}));
		
		TextColumn<CorridaCancelada> textColumn = new TextColumn<CorridaCancelada>() {
			public String getValue(CorridaCancelada object) {
				try{
					StringBuilder b = new StringBuilder();
						b.append("Cliente: ");
						b.append(object.getCorridaSolicitada().getCliente().getDescricao());
						b.append("Motorista: ");
						b.append(object.getCorridaSolicitada().getMotorista().getDescricao());
					return b.toString();
				}catch(NullPointerException nEx){
					return "vazio";
				}

			}
		};
		cellTable.addColumn(textColumn, "Corrida Solicitada");
		
		TextColumn<CorridaCancelada> textColumn_1 = new TextColumn<CorridaCancelada>() {
			public String getValue(CorridaCancelada object) {
				try{
					return object
							.getDataHoraCancelamento()
							.toLocaleString();
				}catch(NullPointerException nEx){
					return "vazio";
				}

			}
		};
		cellTable.addColumn(textColumn_1, "data e hora");
		
		TextColumn<CorridaCancelada> column = new TextColumn<CorridaCancelada>() {
			@Override
			public String getValue(CorridaCancelada object) {
				try{
					return object
							.getMotivo();
				}catch(NullPointerException nEx){
					return "vazio";
				}
			}
		};
		cellTable.addColumn(column, "motivo");
		
		cellTable.addColumn(colunaExcluir());
		
		return cellTable;
	}	
}
