package cleiton.unisul.piweb.sistema.client.formularios;

import java.util.ArrayList;
import java.util.List;

import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputView;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputViewFactory;
import cleiton.unisul.piweb.ferramentasVisuais.client.util.CriadorTela;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.CorridaCancelada;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.CorridaFinalizada;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.CorridaSolicitada;
import cleiton.unisul.piweb.sistema.client.formularios.individuais.FormCorridaCancelada;
import cleiton.unisul.piweb.sistema.client.formularios.individuais.FormCorridaFinalizada;
import cleiton.unisul.piweb.sistema.client.formularios.individuais.FormCorridaSolicitada;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;

public class FormRelacaoCorridasSolicitadas extends FormRelacao<CorridaSolicitada> {

	@Override
	public String getTitulo() {
		return "Listagem de Corridas Solicitadas";
	}

	@Override
	protected CorridaSolicitada novoOb() {
		return new CorridaSolicitada();
	}
	
	public FormRelacaoCorridasSolicitadas() {
		iniciarWidgets();
	}
	@Override
	public boolean setInput(List<CorridaSolicitada> a){
		ArrayList<CorridaSolicitada> b = new ArrayList<CorridaSolicitada>(); 
		
		for(CorridaSolicitada x: a){
			if (x.getStatus()==CorridaSolicitada.Status.SOLICITADA){
				b.add(x);
			}
		}
		super.setInput(b);
		return true;
	}
	
	
	protected CellTable<CorridaSolicitada> criarTabela(){
		CellTable<CorridaSolicitada> cellTable= new CellTable<CorridaSolicitada>();

		cellTable.addColumn(colunaEditar(new InputViewFactory<CorridaSolicitada>() {
			@Override
			public InputView<CorridaSolicitada> getInputView() {
				return new FormCorridaSolicitada(false);
			}
		}));
		
		TextColumn<CorridaSolicitada> textColumn = new TextColumn<CorridaSolicitada>() {
			public String getValue(CorridaSolicitada object) {
				try{
					return object.getCliente().getResumo();
				}catch(NullPointerException nEx){
					return "vazio";
				}

			}
		};
		cellTable.addColumn(textColumn, "Cliente");
		
		TextColumn<CorridaSolicitada> textColumn_1 = new TextColumn<CorridaSolicitada>() {
			public String getValue(CorridaSolicitada object) {
				try{
					return object.getMotorista().getResumo();
				}catch(NullPointerException nEx){
					return "vazio";
				}

			}
		};
		cellTable.addColumn(textColumn_1, "Motorista");
		
		TextColumn<CorridaSolicitada> column = new TextColumn<CorridaSolicitada>() {
			@Override
			public String getValue(CorridaSolicitada object) {
				try{
					return (object
							.getDataHoraEmbarque()
							.toLocaleString());
				}catch(NullPointerException nEx){
					return "vazio";
				}
			}
		};
		cellTable.addColumn(column, "Data e Hora");
		
		TextColumn<CorridaSolicitada> textColumn_2 = new TextColumn<CorridaSolicitada>() {
			public String getValue(CorridaSolicitada object) {
				try{
					return object
							.getLocalEmbarque();
				}catch(NullPointerException nEx){
					return "vazio";
				}
			}
		};
		cellTable.addColumn(textColumn_2, "Local de embarque");
		
		
		Column<CorridaSolicitada,String> colunaFinalizar = new Column<CorridaSolicitada,String>(new ButtonCell()){
			@Override
			public String getValue(CorridaSolicitada object) {
				return "finalizar";
			}
		};
				colunaFinalizar.setFieldUpdater(new FieldUpdater<CorridaSolicitada, String>() {
					@Override
					public void update(int index, CorridaSolicitada object, String value) {
						new CriadorTela<CorridaFinalizada>(new FormCorridaFinalizada(true, object)).execute();
					}
				});
		
		cellTable.addColumn(colunaFinalizar, "");
		
		
		Column<CorridaSolicitada,String> colunaCancelar= new Column<CorridaSolicitada,String>(new ButtonCell()){
			@Override
			public String getValue(CorridaSolicitada object) {
				return "cancelar";
			}
		};
			colunaCancelar.setFieldUpdater(new FieldUpdater<CorridaSolicitada, String>() {
				@Override
				public void update(int index, CorridaSolicitada object, String value) {
					new CriadorTela<CorridaCancelada>(new FormCorridaCancelada(true, object)).execute();
				}
			});		
		cellTable.addColumn(colunaCancelar, "");

		cellTable.addColumn(colunaExcluir());
		
		return cellTable;
	}	
}
