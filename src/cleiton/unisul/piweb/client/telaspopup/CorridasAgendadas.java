package cleiton.unisul.piweb.client.telaspopup;

import java.util.Arrays;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class CorridasAgendadas extends Composite {
	
	private static class DadosCorridaAgendada{
		
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


		private String cliente;
		private String horario;
		private String local;
		private String motorista;
		
		
		public DadosCorridaAgendada(String cliente, String horario,
				String local, String motorista) {
			super();
			this.cliente = cliente;
			this.horario = horario;
			this.local = local;
			this.motorista = motorista;
		}

	}
	
	public CorridasAgendadas() {
		
		FlowPanel flowPanel = new FlowPanel();
		initWidget(flowPanel);
		flowPanel.setSize("767px", "496px");
		
		Label lblSentinelaCorridas = new Label("SENTINELA - Corridas agendadas");
		lblSentinelaCorridas.setStyleName("h1");
		lblSentinelaCorridas.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		flowPanel.add(lblSentinelaCorridas);
		lblSentinelaCorridas.setSize("100%", "20px");
		
		DataGrid cellTable = new DataGrid();
		flowPanel.add(cellTable);
		cellTable.setSize("734px", "432px");
		
		ListDataProvider<DadosCorridaAgendada> dataProvider = new ListDataProvider<DadosCorridaAgendada>();
		dataProvider.addDataDisplay(cellTable);
		
		for (int i=1;i<=5;i++){
			dataProvider.getList().add(
					new DadosCorridaAgendada(
						"Cliente "+i,
						"horario"+i,
						"Local "+i,
						"motorista "+i)
			);
		}
		
		TextColumn<DadosCorridaAgendada> textColumn = 
				new TextColumn<DadosCorridaAgendada>() {
			public String getValue(DadosCorridaAgendada object) {
				return object.getCliente();
			}
		};
		cellTable.addColumn(textColumn, "Cliente");
		
		TextColumn<DadosCorridaAgendada> textColumn_3 = 
				new TextColumn<DadosCorridaAgendada>() {
			public String getValue(DadosCorridaAgendada object) {
				return object.getMotorista();
			}
		};
		cellTable.addColumn(textColumn_3, "Motorista");
		
		TextColumn<DadosCorridaAgendada> textColumn_2 = 
				new TextColumn<DadosCorridaAgendada>() {
			public String getValue(DadosCorridaAgendada object) {
				return object.getLocal();
			}
		};
		cellTable.addColumn(textColumn_2, "Local embarque");
		
		TextColumn<DadosCorridaAgendada> textColumn_1 = 
				new TextColumn<DadosCorridaAgendada>() {
			public String getValue(DadosCorridaAgendada object) {
				return object.getHorario();
			}
		};
		cellTable.addColumn(textColumn_1, "Hor\u00E1rio");
		
		HorizontalPanel verticalPanel = new HorizontalPanel();
		flowPanel.add(verticalPanel);
		
		Button btnNewButton_1 = new Button("New button");
		verticalPanel.add(btnNewButton_1);
		btnNewButton_1.setWidth("156px");
		btnNewButton_1.setText("Agendar nova corrida");
		
		Button btnNewButton_2 = new Button("New button");
		verticalPanel.add(btnNewButton_2);
		btnNewButton_2.setWidth("222px");
		btnNewButton_2.setText("Marcar corrida como atendida");
		
		FlowPanel flowPanel_1 = new FlowPanel();
		verticalPanel.add(flowPanel_1);
		
		Button btnNewButton = new Button("New button");
		btnNewButton.setText("Cancelar corrida selecionada");
		flowPanel_1.add(btnNewButton);
		
		TextBox txtbxMotivo = new TextBox();
		txtbxMotivo.setText("motivo");
		flowPanel_1.add(txtbxMotivo);
		setStyleName("painelCadastro");
	}

}
