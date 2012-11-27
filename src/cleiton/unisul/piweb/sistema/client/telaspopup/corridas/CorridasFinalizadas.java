package cleiton.unisul.piweb.sistema.client.telaspopup.corridas;


import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.Formulario;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.CorridaFinalizada;

import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.view.client.ListDataProvider;

public class CorridasFinalizadas extends Formulario<CorridaFinalizada> {
		
	private static class DadosCorridaFinalizada{
			
			public String getCliente() {
				return cliente;
			}


			public String getHorario() {
				return horario;
			}


			public String getLocal() {
				return local;
			}


			public String getMotorista() {
				return motorista;
			}
			
			public String getDesembarque() {
				return desembarque;
			}


			public String getHorarioDesembarque() {
				return horarioDesembarque;
			}
			
			private String cliente;
			private String horario;
			private String local;
			private String motorista;
			private String desembarque;
			private String horarioDesembarque;
			
			public DadosCorridaFinalizada(String cliente, String horario,
					String local, String motorista, String desembarque,
					String horarioDesembarque) {
				super();
				this.cliente = cliente;
				this.horario = horario;
				this.local = local;
				this.motorista = motorista;
				this.desembarque = desembarque;
				this.horarioDesembarque = horarioDesembarque;
			}
			
			
		}
			
	
	
	
	
	
	public CorridasFinalizadas() {
		
		FlowPanel flowPanel = new FlowPanel();
		initWidget(flowPanel);
		flowPanel.setSize("753px", "334px");
		
		Label lblSentinelaCorridas = new Label("SENTINELA - Corridas finalizadas");
		lblSentinelaCorridas.setStyleName("h1");
		lblSentinelaCorridas.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		flowPanel.add(lblSentinelaCorridas);
		lblSentinelaCorridas.setSize("100%", "20px");
		
		DataGrid<DadosCorridaFinalizada> cellTable = new DataGrid<DadosCorridaFinalizada> ();
		flowPanel.add(cellTable);
		cellTable.setSize("744px", "308px");
		
		TextColumn<DadosCorridaFinalizada> textColumn = new TextColumn<DadosCorridaFinalizada>() {
			public String getValue(DadosCorridaFinalizada object) {
				return object.getCliente();
			}
		};
		cellTable.addColumn(textColumn, "Cliente");
		
		TextColumn<DadosCorridaFinalizada> textColumn_3 = new TextColumn<DadosCorridaFinalizada>() {
			public String getValue(DadosCorridaFinalizada object) {
				return object.getMotorista();
			}
		};
		cellTable.addColumn(textColumn_3, "Motorista");
		
		TextColumn<DadosCorridaFinalizada> textColumn_2 = new TextColumn<DadosCorridaFinalizada>() {
			public String getValue(DadosCorridaFinalizada object) {
				return object.getLocal();
			}
		};
		cellTable.addColumn(textColumn_2, "in\u00EDcio");
		
		TextColumn<DadosCorridaFinalizada> textColumn_1 = new TextColumn<DadosCorridaFinalizada>() {
			public String getValue(DadosCorridaFinalizada object) {
				return object.getHorario();
			}
		};
		cellTable.addColumn(textColumn_1, "Hor\u00E1rio");
		
		TextColumn<DadosCorridaFinalizada> textColumn_4 = new TextColumn<DadosCorridaFinalizada>() {
			public String getValue(DadosCorridaFinalizada object) {
				return object.getDesembarque();
			}
		};
		
		cellTable.addColumn(textColumn_4, "final");
		
		TextColumn<DadosCorridaFinalizada> textColumn_5 = new TextColumn<DadosCorridaFinalizada>() {
			public String getValue(DadosCorridaFinalizada object) {
				return object.getHorarioDesembarque();
			}
		};
		
		cellTable.addColumn(textColumn_5, "Hor\u00E1rio");
		
		ListDataProvider<DadosCorridaFinalizada> dataProvider = new ListDataProvider<DadosCorridaFinalizada>();
		dataProvider.addDataDisplay(cellTable);
		
		for (int i=1;i<=5;i++){
			dataProvider.getList().add(
					new DadosCorridaFinalizada(
						"Cliente "+i,
						"horario"+i,
						"Local "+i,
						"motorista "+i,
						"local 2"+i,
						"horario flow"+i
						)
			);
		}
	}


	@Override
	protected CorridaFinalizada criarInputVazio() {
		return new CorridaFinalizada();
	}

}
