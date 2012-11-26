package cleiton.unisul.piweb.sistema.client.telaspopup.frotas;

import cleiton.unisul.piweb.rpc.shared.objetoschaveados.ParChaveDescricao;
import cleiton.unisul.piweb.sistema.client.formularios.Formulario;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.user.client.ui.VerticalPanel;

public class FrotasQueEmitemVouchers extends Formulario<ParChaveDescricao>{

	private class DadosFrotaClienteVoucher{
		public String getFrota() {
			return frota;
		}
		public String getClientePJ() {
			return clientePJ;
		}
		public DadosFrotaClienteVoucher(String frota, String clientePJ) {
			super();
			this.frota = frota;
			this.clientePJ = clientePJ;
		}
		private String frota;
		private String clientePJ;
	}
	
	public FrotasQueEmitemVouchers() {
		
		VerticalPanel flowPanel = new VerticalPanel();
		initWidget(flowPanel);
		flowPanel.setSize("100%", "100%");
		
		Label lblSentinelaFrotas = new Label("SENTINELA - Frotas que emitem Voucher");
		lblSentinelaFrotas.setStyleName("gwt-LabelTitulo");
		lblSentinelaFrotas.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		flowPanel.add(lblSentinelaFrotas);
		lblSentinelaFrotas.setSize("100%", "20px");
		
		CellTable cellTable = new CellTable();
		flowPanel.add(cellTable);
		cellTable.setSize("450px", "100%");
		
		TextColumn<DadosFrotaClienteVoucher> textColumn = new TextColumn<DadosFrotaClienteVoucher>() {
			public String getValue(DadosFrotaClienteVoucher object) {
				return object.getFrota();
			}
		};
		cellTable.addColumn(textColumn, "FrotaModeloAntigo");
		
		TextColumn<DadosFrotaClienteVoucher> textColumn_1 = new TextColumn<DadosFrotaClienteVoucher>() {
			public String getValue(DadosFrotaClienteVoucher object) {
				return object.getClientePJ();
			}
		};
		cellTable.addColumn(textColumn_1, "Cliente PJ");
		
		ListDataProvider<DadosFrotaClienteVoucher> dataProvider = new ListDataProvider<DadosFrotaClienteVoucher>();
		dataProvider.addDataDisplay(cellTable);
		
		for (int i=1;i<=5;i++){
			dataProvider.getList().add(
					new DadosFrotaClienteVoucher(
						"frota "+i,
						"cliente PJ "+i)
			);
		}
	}

	@Override
	protected ParChaveDescricao criarInputVazio() {
		return new ParChaveDescricao();
	}
	

}
