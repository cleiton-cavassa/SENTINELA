package cleiton.unisul.piweb.sistema.client.telaspopup.corridas;

import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.Formulario;
import cleiton.unisul.piweb.ferramentasVisuais.client.util.CriadorTela;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.CorridaSolicitada;
import cleiton.unisul.piweb.sistema.client.formularios.FormCorridaSolicitada;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.view.client.ListDataProvider;

public class CorridasSolicitadas extends Formulario<CorridaSolicitada> {
	
	private ListDataProvider<CorridaSolicitada> dataProvider = new ListDataProvider<CorridaSolicitada>();
	private CellTable<CorridaSolicitada> cellTable = new CellTable<CorridaSolicitada>();
	
	private FlowPanel s = new FlowPanel();
	private HTML mensagemAguarde = new HTML("<center><b> Consulta de dados em andamento. Exibiremos a tabela em seguida.</b></center>");
	
	private void liberarTabela(boolean liberar){
		cellTable.setVisible(liberar);
		mensagemAguarde.setVisible(!liberar);
	}
	
	@Override public String getTitulo(){return "Corridas Solicitadas";}
	
	public CorridasSolicitadas() {
		
		FlowPanel flowPanel = new FlowPanel();
		initWidget(flowPanel);
//		flowPanel.setSize("767px", "496px");
		
		s.add(cellTable);
		s.add(mensagemAguarde);
		
		liberarTabela(false);
		
		flowPanel.add(s);
		cellTable.setSize("100%", "100%");
		

		dataProvider.addDataDisplay(cellTable);
		
		
		Column<CorridaSolicitada, String> columnEditar = new Column<CorridaSolicitada, String>(new ButtonCell()) {
			@Override
			public String getValue(CorridaSolicitada object) {
				return "editar dados";
			}
		};
			columnEditar.setFieldUpdater(new FieldUpdater<CorridaSolicitada, String>() {
				@Override
				public void update(int index, CorridaSolicitada object, String value) {
					FormCorridaSolicitada f = new FormCorridaSolicitada();
					f.setInput(object);
					new CriadorTela(f).execute();
				}
			});
		
		cellTable.addColumn(columnEditar, "");
			
		TextColumn<CorridaSolicitada> textColumn = 
				new TextColumn<CorridaSolicitada>() {
			public String getValue(CorridaSolicitada object) {
				return object.getCliente().getDescricao();
			}
		};
		
		cellTable.addColumn(textColumn, "Cliente");
		
		TextColumn<CorridaSolicitada> textColumnDtHrEmbarque = 
				new TextColumn<CorridaSolicitada>() {
			public String getValue(CorridaSolicitada object) {
				return object.getDataHoraEmbarque().toString();
			}
		};
		
		cellTable.addColumn(textColumnDtHrEmbarque, "data e hora de embarque");

		TextColumn<CorridaSolicitada> textColumnLocal = 
				new TextColumn<CorridaSolicitada>() {
			public String getValue(CorridaSolicitada object) {
				return object.getLocalEmbarque();
			}
		};
		
		cellTable.addColumn(textColumnLocal, "local de embarque");
		
		TextColumn<CorridaSolicitada> textColumnDestino= 
				new TextColumn<CorridaSolicitada>() {
			public String getValue(CorridaSolicitada object) {
				return object.getLocalPrevisaoDesembarque();
			}
		};
		
		cellTable.addColumn(textColumnDestino, "destino previsto");
		
		TextColumn<CorridaSolicitada> textColumnObs= 
				new TextColumn<CorridaSolicitada>() {
			public String getValue(CorridaSolicitada object) {
				return object.getObservacao();
			}
		};
		
		cellTable.addColumn(textColumnObs, "Obs");
		
		TextColumn<CorridaSolicitada> textColumnMotorista = 
				new TextColumn<CorridaSolicitada>() {
			public String getValue(CorridaSolicitada object) {
				return object.getMotorista().getDescricao();
			}
		};
		
		cellTable.addColumn(textColumnMotorista, "Motorista");
		
		Column<CorridaSolicitada, String> columnFinalizar = new Column<CorridaSolicitada, String>(new ButtonCell()) {
			@Override
			public String getValue(CorridaSolicitada object) {
				return "finalizar";
			}
		};
			columnFinalizar.setFieldUpdater(new FieldUpdater<CorridaSolicitada, String>() {
				@Override
				public void update(int index, CorridaSolicitada object, String value) {
					// IMPLEMENTAR!!!!!
					
				}
			});
		
		cellTable.addColumn(columnFinalizar, "");
				
		Column<CorridaSolicitada, String> columnCancelar = new Column<CorridaSolicitada, String>(new ButtonCell()) {
			@Override
			public String getValue(CorridaSolicitada object) {
				return "cancelar";
			}
		};
			columnCancelar.setFieldUpdater(new FieldUpdater<CorridaSolicitada, String>() {
				@Override
				public void update(int index, CorridaSolicitada object, String value) {
					// IMPLEMENTAR!!!!!
				
				}
			});
		
		cellTable.addColumn(columnCancelar, "");
		

	}

	@Override
	protected CorridaSolicitada criarInputVazio() {
		return new CorridaSolicitada();
	}

}
