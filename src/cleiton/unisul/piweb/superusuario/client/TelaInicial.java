package cleiton.unisul.piweb.superusuario.client;

import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputView;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputViewFactory;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewCNPJ;
import cleiton.unisul.piweb.ferramentasVisuais.client.util.CriadorTela;
import cleiton.unisul.piweb.rpc.client.BotaoLogout;
import cleiton.unisul.piweb.rpc.client.TabelasAtualizador;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.Frota;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.UsuarioAdministrativo;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.widgets.Atualizavel;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.widgets.BotaoSalvar;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.widgets.ColumnEditar;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.widgets.ColumnExcluir;
import cleiton.unisul.piweb.rpc.shared.respostasdeconsulta.RespostaPersistencia;
import cleiton.unisul.piweb.superusuario.client.telas.formularios.FormFrota;
import cleiton.unisul.piweb.superusuario.client.telas.formularios.FormFrota.BotoesHandler;

import com.google.gwt.cell.client.FieldUpdater;
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
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.ListDataProvider;

public class TelaInicial extends Composite implements BotoesHandler, Atualizavel{
	
	private TabelasAtualizador<Frota> atualizador;
	private Frota exemplo = new Frota();
	private ListDataProvider<Frota> dp=new ListDataProvider<Frota>();
	
	private final TelaInicial eu;
	private Frota frotaEmAmazenamento=null;
	private int posFrota;
	
	public void acionarEstadoArmazenando(Frota aArmazenar){
		frotaEmAmazenamento=aArmazenar;
	}
	
	public void liberarEstadoArmazenando(RespostaPersistencia resposta){
		if(resposta.getOperacaoBemSucedida()){
			
		}else{
			
		}
		frotaEmAmazenamento=null;
	}
	
	private ClickHandler hNovo = new ClickHandler() {
		@Override
		public void onClick(ClickEvent event) {
			FormFrota f =new FormFrota(atualizador, dp, true);
			f.addSalvarHandler(eu);
			posFrota=-1;
			new CriadorTela<Frota>(f).execute();
		}
	};
	
	@Override
	public void enviar(Frota aSalvar){
		frotaEmAmazenamento = aSalvar;
	}
	
	
	
	@Override
	public void sucesso(RespostaPersistencia resposta) {
		if (resposta.getOperacaoBemSucedida()){
			if(posFrota==-1){
				dp.getList().add(frotaEmAmazenamento);
			}else{
				dp.getList().set(posFrota, frotaEmAmazenamento);
			}
		}
		posFrota=-1;
//		List<Frota> l = dp.getList();
//		Frota f = frotaEmAmazenamento;
//		int ind = l.indexOf(f);
//		if(ind!=-1){
////			dp.getList().set(ind, null);
//			dp.getList().set(ind, f);
////			dp.refresh();
//		}else{
//			dp.getList().add(f);
//		}
	}

	@Override
	public void falha(Throwable caught) {
		posFrota=-1;
	}
	
	
	public TelaInicial(){
		
		BotaoSalvar.addAtualizavel(this);
		
		eu=this;
		atualizador=new TabelasAtualizador<Frota>(dp, null);
		
		FlowPanel flow = new FlowPanel();
		
		initWidget(flow);
		flow.setWidth("100%");
		
		Label lblSentinelaMdulo = new Label("SENTINELA - m\u00F3dulo de superusu\u00E1rio");
		lblSentinelaMdulo.setStyleName("h1");
		lblSentinelaMdulo.addStyleName("padding10");
		flow.add(lblSentinelaMdulo);
		lblSentinelaMdulo.setWidth("100%");
		
		DockPanel dockPanel = new DockPanel();
		dockPanel.setWidth("100%");
		BotaoLogout botaoLogout = new BotaoLogout("logout");
		dockPanel.add(botaoLogout, DockPanel.EAST);
		dockPanel.setCellHorizontalAlignment(botaoLogout, HasHorizontalAlignment.ALIGN_RIGHT);
		
		
		
		flow.add(dockPanel);
		
		VerticalPanel verticalPanel = new VerticalPanel();
		flow.add(verticalPanel);
		verticalPanel.setWidth("100%");
		
		Label lblFrotasExistentesNo = new Label("Frotas existentes no sistema");
		lblFrotasExistentesNo.setStyleName("TituloTabela");
		verticalPanel.add(lblFrotasExistentesNo);
		verticalPanel.setCellHorizontalAlignment(lblFrotasExistentesNo, HasHorizontalAlignment.ALIGN_CENTER);
		lblFrotasExistentesNo.setWidth("100%");
		
		Button btnCriarNovaFrota = new Button("Criar nova frota");
		btnCriarNovaFrota.setStyleName("botaoLogout");
		verticalPanel.add(btnCriarNovaFrota);
		btnCriarNovaFrota.addClickHandler(hNovo);
		
		CellTable<Frota> cellTable = new CellTable<Frota>();
		verticalPanel.add(cellTable);
		cellTable.setWidth("100%");
		
		Column<Frota, String> columnEditar=new ColumnEditar<Frota>(null, new FieldUpdater<Frota, String>() {
			@Override
			public void update(int index, Frota object, String value) {
				posFrota=index;
			}
		},new InputViewFactory<Frota>() {
			@Override
			public InputView<Frota> getInputView() {
				FormFrota f = new FormFrota(atualizador, dp, false);
				f.addSalvarHandler(eu);
				return f;
			}
		});
		
		cellTable.addColumn(columnEditar);
		
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
				StringBuilder b = new StringBuilder();
				for(UsuarioAdministrativo s: object.
						getUsuariosAdministrativos()){
					b.append(s);
					b.append("\n");
				}
				return b.toString(); 
					
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
