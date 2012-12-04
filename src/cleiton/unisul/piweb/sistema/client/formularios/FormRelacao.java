package cleiton.unisul.piweb.sistema.client.formularios;

import java.util.List;

import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputView;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputViewFactory;
import cleiton.unisul.piweb.ferramentasVisuais.client.util.CriadorTela;
import cleiton.unisul.piweb.ferramentasVisuais.client.util.FecharPopUpEventHandler;
import cleiton.unisul.piweb.rpc.client.ServicoArmazenamento;
import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;
import cleiton.unisul.piweb.rpc.shared.respostasdeconsulta.RespostaPersistencia;
import cleiton.unisul.piweb.sistema.client.SENTINELA;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;

public abstract class FormRelacao <Ob extends ObjetoChaveado>extends Composite implements InputView<List<Ob>>{

	abstract protected CellTable<Ob> criarTabela();
	abstract protected Ob novoOb();
	
	private final ListDataProvider<Ob> dataProvider = new ListDataProvider<Ob>();
	private FecharPopUpEventHandler f;
	
	protected Widget iniciarWidgets(){
		FlowPanel flowPanel = new FlowPanel();
		flowPanel.setStyleName("painelCadastro");
		initWidget(flowPanel);
		flowPanel.setSize("808px", "");
		
		VerticalPanel verticalPanel = new VerticalPanel();
		flowPanel.add(verticalPanel);
		verticalPanel.setWidth("");
		
//		CellTable<Ob> cellTable = criarTabela();
//		verticalPanel.add(cellTable);
//		cellTable.setWidth("");
		CellTable<Ob> cellTable =criarTabela();
		DecoratorPanel decoratorPanel_1 = new DecoratorPanel();
		verticalPanel.add(decoratorPanel_1);
		decoratorPanel_1.setSize("100%", "100%");
		
		decoratorPanel_1.setWidget(cellTable);

		atualizar();
		dataProvider.addDataDisplay(cellTable );
		return flowPanel;
	}
	
	public void atualizar(){
		AsyncCallback<List<Ob>> a= new CallbackArmazenamento();
		ServicoArmazenamento.getArmazenamento().recuperar(novoOb(), SENTINELA.getFrota().getChave(), a);		
	}
	
	private class CallbackArmazenamento implements AsyncCallback<List<Ob>>{
		@Override
		public void onSuccess(List<Ob> result) {
			setInput(result);
		}
		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Problemas ao recuperar listagem. A listagem correta pode ser exibida recarregando o sistema no navegador.\n\n\n"+caught.getMessage());
		}
	}
	
	@Override
	public String validarDados() {
		return null;
	}

	@Override
	public boolean setFecharHandler(FecharPopUpEventHandler f) {
		this.f=f;
		return true;
	}

	@Override
	public void fechar() {
		f.fecharPopUp();
	}
	
	@Override
	public boolean setInput(List<Ob> input) {
		dataProvider.setList(input);
		return true;
	}

	@Override
	public List<Ob> getInput() {
		return dataProvider.getList();
	}

	
	
	protected Column<Ob, String> colunaEditar(InputViewFactory<Ob> fabrica){
		Column<Ob, String> column_Editar = new Column<Ob, String>(new ButtonCell()) {
			@Override
			public String getValue(Ob object) {
				return "editar";
			}
		};
		
		column_Editar.setFieldUpdater(new EditarFieldUpdater(fabrica));
		return column_Editar;
	}
	private class EditarFieldUpdater implements FieldUpdater<Ob, String> {
		private InputViewFactory<Ob> fabrica;
		
		public EditarFieldUpdater(InputViewFactory<Ob> fabrica){
			this.fabrica=fabrica;
		}

		@Override
		public void update(int index, Ob object, String value) {
			InputView<Ob> c =fabrica.getInputView();
			c.setInput(object);
			new CriadorTela<Ob>(c).execute();				
		}
	}
	
	
	protected Column<Ob, String> colunaExcluir(){
		return colunaExcluir("excluir");
	}
	
	protected Column<Ob, String> colunaExcluir(final String txtBotao){
		Column<Ob, String> column_Excluir = new Column<Ob, String>(new ButtonCell()) {
			@Override
			public String getValue(Ob object) {
				return txtBotao;
			}
		};
		
				column_Excluir.setFieldUpdater(new FieldUpdater<Ob, String>(){
					@Override
					public void update(int index, Ob object, String value) {
						if ( !(Window.confirm("Tem certeza de que deseja excluir esses dados?")) ){
							return;
						}
						ServicoArmazenamento.getArmazenamento().excluir(object, new AsyncCallback<RespostaPersistencia>() {

							@Override
							public void onFailure(Throwable caught) {
								Window.alert("Uma falha impossibilitou o sistema de excluir os dados. Tente novamente mais tarde." );
							}

							@Override
							public void onSuccess(RespostaPersistencia result) {
								Window.alert("Dados eliminados com sucesso.");
								atualizar();
							}
						});				
					}
					
				});
				
		return column_Excluir;
	}

}
