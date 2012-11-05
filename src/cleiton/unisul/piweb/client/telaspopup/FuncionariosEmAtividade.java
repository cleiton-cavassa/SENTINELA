package cleiton.unisul.piweb.client.telaspopup;

import java.util.ArrayList;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.view.client.ListDataProvider;

public class FuncionariosEmAtividade extends Composite {
	
	private class DadosFuncionarioEmAtividade{
		public String getNome() {
			return nome;
		}
		public String getCarro() {
			return carro;
		}
		public String getIdiomas() {
			return idiomas;
		}
		public String getTelefones() {
			return telefones;
		}
		
		public DadosFuncionarioEmAtividade(String nome, String carro,
				String idiomas, String telefones) {
			super();
			this.nome = nome;
			this.carro = carro;
			this.idiomas = idiomas;
			this.telefones = telefones;
		}

		private String nome;
		private String carro;
		private String idiomas;
		private String telefones;
		
	}
	
	public FuncionariosEmAtividade() {
		
		FlowPanel flowPanel = new FlowPanel();
		initWidget(flowPanel);
		flowPanel.setSize("100%", "100%");
		
		Label lblSentinelaFuncionrios = new Label("SENTINELA - Funcion\u00E1rios em atividade agora");
		lblSentinelaFuncionrios.setStyleName("gwt-LabelTitulo");
		lblSentinelaFuncionrios.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		flowPanel.add(lblSentinelaFuncionrios);
		lblSentinelaFuncionrios.setSize("100%", "20px");
		
		CellTable cellTable = new CellTable();
		flowPanel.add(cellTable);
		cellTable.setSize("400px", "100%");
		
		ListDataProvider<DadosFuncionarioEmAtividade> dataProvider = new ListDataProvider<DadosFuncionarioEmAtividade>();
		dataProvider.addDataDisplay(cellTable);
		
		for (int i=1;i<=5;i++){
			dataProvider.getList().add(
					new DadosFuncionarioEmAtividade(
						"motorista "+i,
						"carro "+i,
						"idioma "+i,
						"telefones "+i)
			);
		}
		
		
		TextColumn<DadosFuncionarioEmAtividade> textColumn = new TextColumn<DadosFuncionarioEmAtividade>() {
			@Override
			public String getValue(DadosFuncionarioEmAtividade object) {
				return object.getNome();
			}
		};
		cellTable.addColumn(textColumn, "Nome");
		
		TextColumn<DadosFuncionarioEmAtividade> textColumn_1 = new TextColumn<DadosFuncionarioEmAtividade>() {
			@Override
			public String getValue(DadosFuncionarioEmAtividade object) {
				return object.getCarro();
			}
		};
		cellTable.addColumn(textColumn_1, "Carro");
		
		TextColumn<DadosFuncionarioEmAtividade> textColumn_2 = new TextColumn<DadosFuncionarioEmAtividade>() {
			@Override
			public String getValue(DadosFuncionarioEmAtividade object) {
				return object.getIdiomas();
			}
		};
		cellTable.addColumn(textColumn_2, "Idiomas falados");
		
		TextColumn<DadosFuncionarioEmAtividade> textColumn_3 = new TextColumn<DadosFuncionarioEmAtividade>() {
			@Override
			public String getValue(DadosFuncionarioEmAtividade object) {
				return object.getTelefones();
			}
		};
		cellTable.addColumn(textColumn_3, "Telefones");
	}

}
