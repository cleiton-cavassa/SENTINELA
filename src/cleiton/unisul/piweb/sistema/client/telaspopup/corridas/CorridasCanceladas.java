package cleiton.unisul.piweb.sistema.client.telaspopup.corridas;

import cleiton.unisul.piweb.rpc.shared.objetoschaveados.CorridaCancelada;
import cleiton.unisul.piweb.sistema.client.formularios.Formulario;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.view.client.ListDataProvider;

public class CorridasCanceladas extends Formulario<CorridaCancelada> {
	
	private static class DadosCorridaCancelada{
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
		public String getMotivo() {
			return motivo;
		}
		public DadosCorridaCancelada(String cliente, String horario,
				String local, String motorista, String motivo) {
			super();
			this.cliente = cliente;
			this.horario = horario;
			this.local = local;
			this.motorista = motorista;
			this.motivo = motivo;
		}
		private String cliente;
		private String horario;
		private String local;
		private String motorista;
		private String motivo;
	}
	
	public CorridasCanceladas() {
		
		FlowPanel flowPanel = new FlowPanel();
		initWidget(flowPanel);
		flowPanel.setSize("660px", "269px");
		
		Label lblSentinelaCorridas = new Label("SENTINELA - Corridas canceladas");
		lblSentinelaCorridas.setStyleName("h1");
		lblSentinelaCorridas.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		flowPanel.add(lblSentinelaCorridas);
		lblSentinelaCorridas.setSize("100%", "20px");
		
		
		
		CellTable cellTable = new CellTable();
		flowPanel.add(cellTable);
		cellTable.setSize("659px", "215px");
		
		TextColumn<DadosCorridaCancelada> textColumn= new TextColumn<DadosCorridaCancelada>() {
			public String getValue(DadosCorridaCancelada object) {
				return object.getCliente();
			}
		};
		cellTable.addColumn(textColumn, "Cliente");
		
		TextColumn<DadosCorridaCancelada> textColumn_1 = new TextColumn<DadosCorridaCancelada>() {
			public String getValue(DadosCorridaCancelada object) {
				return object.getHorario();
			}
		};
		cellTable.addColumn(textColumn_1, "Hor\u00E1rio de Embarque");
		
		TextColumn<DadosCorridaCancelada> textColumn_2 = new TextColumn<DadosCorridaCancelada>() {
			public String getValue(DadosCorridaCancelada object) {
				return object.getLocal();
			}
		};
		cellTable.addColumn(textColumn_2, "Local de Embarque");
		
		TextColumn<DadosCorridaCancelada> textColumn_3 = new TextColumn<DadosCorridaCancelada>() {
			public String getValue(DadosCorridaCancelada object) {
				return object.getMotorista();
			}
		};
		cellTable.addColumn(textColumn_3, "Motorista");
		
		TextColumn<DadosCorridaCancelada> textColumn_4 = new TextColumn<DadosCorridaCancelada>() {
			public String getValue(DadosCorridaCancelada object) {
				return object.getMotivo();
			}
		};
		cellTable.addColumn(textColumn_4, "Motivo");
		
		FlowPanel flowPanel_1 = new FlowPanel();
		flowPanel.add(flowPanel_1);
		
		Button button = new Button("New button");
		button.setText("descancelar corrida selecionada");
		flowPanel_1.add(button);
		
		Button btnNewButton = new Button("New button");
		btnNewButton.setText("excluir corrida do banco de dados");
		flowPanel_1.add(btnNewButton);
		
		ListDataProvider<DadosCorridaCancelada> dataProvider = new ListDataProvider<DadosCorridaCancelada>();
		dataProvider.addDataDisplay(cellTable);
		
		for (int i=1;i<=5;i++){
			dataProvider.getList().add(
					new DadosCorridaCancelada(
						"Cliente "+i,
						"horario"+i,
						"Local "+i,
						"motorista "+i,
						"motivo"+i
						)
			);
		}
	}

	@Override
	protected CorridaCancelada criarInputVazio() {
		return new CorridaCancelada();
	}

}
