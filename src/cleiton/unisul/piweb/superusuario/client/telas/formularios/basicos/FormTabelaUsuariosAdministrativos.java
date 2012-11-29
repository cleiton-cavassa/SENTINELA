package cleiton.unisul.piweb.superusuario.client.telas.formularios.basicos;

import java.util.ArrayList;
import java.util.List;

import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputView;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputViewFactory;
import cleiton.unisul.piweb.ferramentasVisuais.client.util.CriadorTela;
import cleiton.unisul.piweb.ferramentasVisuais.client.util.FecharPopUpEventHandler;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.UsuarioAdministrativo;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.widgets.ColumnEditar;
import cleiton.unisul.piweb.superusuario.client.telas.formularios.FormUsuarioAdministrativo;
import cleiton.unisul.piweb.superusuario.client.telas.formularios.FormUsuarioAdministrativo.BotoesHandler;

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

public class FormTabelaUsuariosAdministrativos extends Composite implements
		InputView<ArrayList<UsuarioAdministrativo>> {

	private ListDataProvider<UsuarioAdministrativo> dp= new ListDataProvider<UsuarioAdministrativo>();

	private FormUsuarioAdministrativo getFormUsuAdm(){
		FormUsuarioAdministrativo f = new FormUsuarioAdministrativo();
		f.addSalvarHandler(new BotoesHandler() {
			
			@Override
			public void sucesso(UsuarioAdministrativo salvo) {
				List<UsuarioAdministrativo> l = dp.getList();
				UsuarioAdministrativo usu = salvo;
				int ind = l.indexOf(usu);
				if(ind!=-1){
					l.set(ind, usu);
				}else{
					l.add(usu);
				}
			}
		});
		return f;
	}
	
	public FormTabelaUsuariosAdministrativos(){
		
//		atualizador=new TabelasAtualizador<UsuarioAdministrativo>(dp);
		
		
		ClickHandler hNovo = new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				new CriadorTela(getFormUsuAdm()).execute();
			}
		};
		
	
		
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
		
		
		Column<UsuarioAdministrativo, String> column = new ColumnEditar<UsuarioAdministrativo>(null, new InputViewFactory<UsuarioAdministrativo>() {
			@Override
			public InputView<UsuarioAdministrativo> getInputView() {
				return getFormUsuAdm();
			}
		});
		cellTable.addColumn(column);
		
		TextColumn<UsuarioAdministrativo> textColumn = new TextColumn<UsuarioAdministrativo>() {
			@Override
			public String getValue(UsuarioAdministrativo object) {
				try{
					return object.
						getDadosUsuarioAdministrativo().
						getEmail();
				}catch(NullPointerException nEx){
					return "vazio";
				}
			}
		};
		cellTable.addColumn(textColumn, "email");
		
		TextColumn<UsuarioAdministrativo> textColumnNivel = new TextColumn<UsuarioAdministrativo>() {
			@Override
			public String getValue(UsuarioAdministrativo object) {
				try{
					return object.
						getDadosUsuarioAdministrativo().
						getNivelAcesso().toString();
				}catch(NullPointerException nEx){
					return "vazio";
				}
				
			}
		};
		cellTable.addColumn(textColumnNivel, "Nivel");
		
		Column<UsuarioAdministrativo, String> columnExcluir = new Column<UsuarioAdministrativo, String>(new ButtonCell()) {
			@Override
			public String getValue(UsuarioAdministrativo object) {
				return "excluir";
			}
		};
		cellTable.addColumn(columnExcluir);
		
		columnExcluir.setFieldUpdater(new FieldUpdater<UsuarioAdministrativo, String>() {
			
			@Override
			public void update(int index, UsuarioAdministrativo object, String value) {
				dp.getList().remove(object);
			}
		});
				
		dp.addDataDisplay(cellTable);
//		atualizar();

	}

//	public void atualizar(){
//		atualizador.atualizar(exemplo, dp);
//	}

	@Override
	public String validarDados() {
		return null;
	}

	@Override
	public String getTitulo() {
		return "Usuarios Administrativos";
	}

	@Override
	public boolean setInput(ArrayList<UsuarioAdministrativo> input) {
		dp.setList(input);
		return true;
	}

	@Override
	public ArrayList<UsuarioAdministrativo> getInput() {
		ArrayList<UsuarioAdministrativo> a = new ArrayList<UsuarioAdministrativo>(dp.getList().size());
				a.addAll(dp.getList());
		return a;
	}

	@Override
	public boolean setFecharHandler(FecharPopUpEventHandler f) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void fechar() {
		// TODO Auto-generated method stub
		
	}

}
