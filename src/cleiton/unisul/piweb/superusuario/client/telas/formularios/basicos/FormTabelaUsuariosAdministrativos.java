package cleiton.unisul.piweb.superusuario.client.telas.formularios.basicos;

import java.util.List;

import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputView;
import cleiton.unisul.piweb.ferramentasVisuais.client.util.CriadorTela;
import cleiton.unisul.piweb.rpc.client.TabelasAtualizador;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.UsuarioAdministrativo;
import cleiton.unisul.piweb.superusuario.client.telas.formularios.FormUsuarioAdministrativo;

import com.google.gwt.cell.client.ButtonCell;
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

public class FormTabelaUsuariosAdministrativos extends Composite implements
		InputView<List<UsuarioAdministrativo>> {

	
	
	private TabelasAtualizador<UsuarioAdministrativo> atualizador;
	private UsuarioAdministrativo exemplo =new UsuarioAdministrativo();
	private ListDataProvider<UsuarioAdministrativo> dp= new ListDataProvider<UsuarioAdministrativo>();

	private ClickHandler hNovo = new ClickHandler() {
		@Override
		public void onClick(ClickEvent event) {
			new CriadorTela(new FormUsuarioAdministrativo()).execute();
		}
	};
	
	public FormTabelaUsuariosAdministrativos(){
		
		atualizador=new TabelasAtualizador<UsuarioAdministrativo>(dp);
		
		FlowPanel flow = new FlowPanel();
		initWidget(flow);
		DockPanel dockPanel = new DockPanel();
		dockPanel.setWidth("100%");
		flow.add(dockPanel);
		
		Label lblFrotasExistentesNo = new Label("Usuarios administrativos cadastrados para esta frota");
		dockPanel.add(lblFrotasExistentesNo, DockPanel.WEST);
		
		Button btnCriarNovaFrota = new Button("cadastrar novo usu\u00E1rio");
		btnCriarNovaFrota.addClickHandler(hNovo);
		
		
		dockPanel.add(btnCriarNovaFrota, DockPanel.EAST);
		dockPanel.setCellHorizontalAlignment(btnCriarNovaFrota, HasHorizontalAlignment.ALIGN_RIGHT);
		
		CellTable<UsuarioAdministrativo> cellTable = new CellTable<UsuarioAdministrativo>();
		flow.add(cellTable);
		cellTable.setWidth("100%");
		
		Column<UsuarioAdministrativo, String> column = new Column<UsuarioAdministrativo, String>(new ButtonCell()) {
			@Override
			public String getValue(UsuarioAdministrativo object) {
				return "editar";
			}
		};
		cellTable.addColumn(column);
		
		TextColumn<UsuarioAdministrativo> textColumn = new TextColumn<UsuarioAdministrativo>() {
			@Override
			public String getValue(UsuarioAdministrativo object) {
				return object.
						getDadosUsuarioAdministrativo().
						getEmail();
			}
		};
		cellTable.addColumn(textColumn, "email");
		
		TextColumn<UsuarioAdministrativo> textColumnNivel = new TextColumn<UsuarioAdministrativo>() {
			@Override
			public String getValue(UsuarioAdministrativo object) {
				return object.
						getDadosUsuarioAdministrativo().
						getNivelAcesso().toString();
			}
		};
		cellTable.addColumn(textColumnNivel, "Nivel");
				
		dp.addDataDisplay(cellTable);
		atualizar();

	}

	public void atualizar(){
		atualizador.atualizar(exemplo, dp);
	}

	@Override
	public String validarDados() {
		return null;
	}

	@Override
	public String getTitulo() {
		return "Usuarios Administrativos";
	}

	@Override
	public boolean setInput(List<UsuarioAdministrativo> input) {
		dp.setList(input);
		return true;
	}

	@Override
	public List<UsuarioAdministrativo> getInput() {
		return dp.getList();
	}

}
