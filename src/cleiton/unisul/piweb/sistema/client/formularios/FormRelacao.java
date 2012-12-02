package cleiton.unisul.piweb.sistema.client.formularios;

import java.util.List;

import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputView;
import cleiton.unisul.piweb.ferramentasVisuais.client.util.FecharPopUpEventHandler;
import cleiton.unisul.piweb.rpc.client.ServicoArmazenamento;
import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;

import com.google.gwt.user.cellview.client.CellTable;
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
		ServicoArmazenamento.getArmazenamento().recuperar(novoOb(), a);		
	}
	
	private class CallbackArmazenamento implements AsyncCallback<List<Ob>>{
		@Override
		public void onSuccess(List<Ob> result) {
			dataProvider.setList(result);
		}
		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Problemas ao recuperar listagem:\n"+caught.getMessage());
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


}
