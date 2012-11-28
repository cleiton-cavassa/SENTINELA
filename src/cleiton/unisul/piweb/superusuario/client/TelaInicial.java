package cleiton.unisul.piweb.superusuario.client;

import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewCNPJ;
import cleiton.unisul.piweb.ferramentasVisuais.client.util.CriadorTela;
import cleiton.unisul.piweb.rpc.client.TabelasAtualizador;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.Frota;
import cleiton.unisul.piweb.superusuario.client.telas.formularios.FormFrota;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.view.client.ListDataProvider;

public class TelaInicial extends Composite{
	
	private TabelasAtualizador<Frota> atualizador;
	private Frota exemplo = new Frota();
	private ListDataProvider<Frota> dp=new ListDataProvider<Frota>();
	
	
	
	
	
	private ClickHandler hNovo = new ClickHandler() {
		@Override
		public void onClick(ClickEvent event) {
			new CriadorTela(new FormFrota(atualizador, dp)).execute();
		}
	};
	
	public TelaInicial(){
		
		atualizador=new TabelasAtualizador<Frota>(dp);
		
		FlowPanel flow = new FlowPanel();
		
		initWidget(flow);
		
		DockPanel dockPanel = new DockPanel();
		dockPanel.setWidth("100%");
		flow.add(dockPanel);
		
		Label lblFrotasExistentesNo = new Label("Frotas existentes no sistema");
		dockPanel.add(lblFrotasExistentesNo, DockPanel.WEST);
		
		Button btnCriarNovaFrota = new Button("Criar nova frota");
		btnCriarNovaFrota.addClickHandler(hNovo);
		
		
		dockPanel.add(btnCriarNovaFrota, DockPanel.EAST);
		dockPanel.setCellHorizontalAlignment(btnCriarNovaFrota, HasHorizontalAlignment.ALIGN_RIGHT);
		
		CellTable<Frota> cellTable = new CellTable<Frota>();
		flow.add(cellTable);
		cellTable.setWidth("100%");
		
		Column<Frota, String> column = new Column<Frota, String>(new ButtonCell()) {
			@Override
			public String getValue(Frota object) {
				return "editar";
			}
		};
		cellTable.addColumn(column);
		
		column.setFieldUpdater(new FieldUpdater<Frota, String>() {
			
			@Override
			public void update(int index, Frota object, String value) {
				FormFrota f =new FormFrota(atualizador, dp);
				f.setInput(object);
				new CriadorTela(f).execute();
				
			}
		});
		
		TextColumn<Frota> textColumn = new TextColumn<Frota>() {
			@Override
			public String getValue(Frota object) {
				return InputViewCNPJ.mascaraCNPJ(
							object.
							getMeusDadosCompartilhados().
							getDadosPessoaJuridica().
							getDadosPessoaJuridica().
							getCnpj()
						);
			}
		};
		cellTable.addColumn(textColumn, "CNPJ");
		
		TextColumn<Frota> textColumn_1 = new TextColumn<Frota>() {
			@Override
			public String getValue(Frota object) {
				return object.
						getMeusDadosCompartilhados().
						getDadosPessoaJuridica().
						getDadosPessoaJuridica().
						getRazaoSocial();
			}
		};
		cellTable.addColumn(textColumn_1, "Raz\u00E3o Social");
		
		TextColumn<Frota> textColumn_2 = new TextColumn<Frota>() {
			@Override
			public String getValue(Frota object) {
				return object.
						getUsuariosAdministrativos().
						toString();
//				return "";
			}
		};
		cellTable.addColumn(textColumn_2, "Administradores");
		
		dp.addDataDisplay(cellTable);
		atualizar();

	}

	public void atualizar(){
		atualizador.atualizar(exemplo, dp);
	}
}
