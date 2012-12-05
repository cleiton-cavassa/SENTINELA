package cleiton.unisul.piweb.sistema.client.formularios;

import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputView;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputViewFactory;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.CorridaFinalizada;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.CorridaSolicitada;
import cleiton.unisul.piweb.sistema.client.formularios.individuais.FormCorridaFinalizada;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;

public class FormRelacaoCorridasFinalizadas extends FormRelacao<CorridaFinalizada> {

	@Override
	public String getTitulo() {
		return "Listagem de Corridas Finalizadas";
	}

	@Override
	protected CorridaFinalizada novoOb() {
		return new CorridaFinalizada();
	}
	
	public FormRelacaoCorridasFinalizadas() {
		iniciarWidgets();
	}
	
	
	protected CellTable<CorridaFinalizada> criarTabela(){
		CellTable<CorridaFinalizada> cellTable= new CellTable<CorridaFinalizada>();

		cellTable.addColumn(colunaEditar(new InputViewFactory<CorridaFinalizada>() {
			@Override
			public InputView<CorridaFinalizada> getInputView() {
				return new FormCorridaFinalizada(false,new CorridaSolicitada());
			}
		}));
		
		TextColumn<CorridaFinalizada> textColumn = new TextColumn<CorridaFinalizada>() {
			public String getValue(CorridaFinalizada object) {
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
		
		TextColumn<CorridaFinalizada> textColumn_1 = new TextColumn<CorridaFinalizada>() {
			public String getValue(CorridaFinalizada object) {
				try{
					return object
							.getDataHoraDesembarque()
							.toLocaleString();
				}catch(NullPointerException nEx){
					return "vazio";
				}

			}
		};
		cellTable.addColumn(textColumn_1, "data e hora");
		
		TextColumn<CorridaFinalizada> column = new TextColumn<CorridaFinalizada>() {
			@Override
			public String getValue(CorridaFinalizada object) {
				try{
					return object
							.getLocalDesembarque();
				}catch(NullPointerException nEx){
					return "vazio";
				}
			}
		};
		cellTable.addColumn(column, "local desembarque");
		
		cellTable.addColumn(colunaExcluir());
		
		return cellTable;
	}	
}
