package cleiton.unisul.piweb.superusuario.client;

import java.util.List;

import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputView;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputViewFactory;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewCNPJ;
import cleiton.unisul.piweb.ferramentasVisuais.client.util.CriadorTela;
import cleiton.unisul.piweb.rpc.client.TabelasAtualizador;
import cleiton.unisul.piweb.rpc.shared.RespostaPersistencia;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.Frota;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.widgets.ColumnEditar;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.widgets.ColumnExcluir;
import cleiton.unisul.piweb.superusuario.client.telas.formularios.FormFrota;
import cleiton.unisul.piweb.superusuario.client.telas.formularios.FormFrota.BotoesHandler;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.view.client.ListDataProvider;

public class TelaInicial extends Composite implements BotoesHandler{
	
	private TabelasAtualizador<Frota> atualizador;
	private Frota exemplo = new Frota();
	private ListDataProvider<Frota> dp=new ListDataProvider<Frota>();
	
	private final TelaInicial eu;
	
	
	
	private ClickHandler hNovo = new ClickHandler() {
		@Override
		public void onClick(ClickEvent event) {
			FormFrota f =new FormFrota(atualizador, dp);
			f.addSalvarHandler(eu);
			new CriadorTela(f).execute();
		}
	};
	
	@Override
	public void sucesso(Frota salva, RespostaPersistencia resposta) {
		List<Frota> l = dp.getList();
		Frota f = salva;
		int ind = l.indexOf(f);
		if(ind!=-1){
//			dp.getList().set(ind, null);
			dp.getList().set(ind, f);
//			dp.refresh();
		}else{
			dp.getList().add(f);
		}
	}

	@Override
	public void falha(Throwable caught) {}
	
	
	public TelaInicial(){
		eu=this;
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
		
		Column<Frota, String> ColumnEditar=new ColumnEditar<Frota>(null, new InputViewFactory<Frota>() {
			@Override
			public InputView<Frota> getInputView() {
				FormFrota f = new FormFrota(atualizador, dp);
				f.addSalvarHandler(eu);
				return f;
			}
		});
				
		cellTable.addColumn(ColumnEditar);
		
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
			}
		};
		cellTable.addColumn(textColumn_2, "Administradores");
		
		
		ColumnExcluir<Frota> columnExcluir= new ColumnExcluir<Frota>(null, new ColumnExcluir.AcionadorExcluir<Frota>() {
			@Override
			public void execute() {}
			@Override
			public AsyncCallback<RespostaPersistencia> getCallback(
					Frota aExcluir) {
				return new ExcluirFrotaCallback(aExcluir);
			}
		});
		  
		cellTable.addColumn(columnExcluir);
		
		
		dp.addDataDisplay(cellTable);
		atualizar();

	}

	public void atualizar(){
		atualizador.atualizar(exemplo, dp);
	}

			
	private class ExcluirFrotaCallback implements AsyncCallback<RespostaPersistencia>{
		
		private Frota frotaExcluida;
		
		public ExcluirFrotaCallback (Frota aExcluir){
			frotaExcluida= aExcluir;
		}

		@Override
		public void onFailure(Throwable caught) {
			Window.alert("N‹o foi poss’vel excluir a frota do sistema. Por favor, tente novamente mais tarde.");
		}

		@Override
		public void onSuccess(RespostaPersistencia result) {
			Window.alert("Frota exclu’da do sistema com sucesso!");
			dp.getList().remove(frotaExcluida);
		}
		
	};

}
