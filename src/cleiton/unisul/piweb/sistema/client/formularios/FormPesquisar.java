package cleiton.unisul.piweb.sistema.client.formularios;

import java.util.List;

import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewTextBox;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewWithTitle;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.ParChaveDescricao;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.view.client.ListDataProvider;

public class FormPesquisar extends Formulario<ParChaveDescricao>{
	


	private String categoria;
	
	private ListDataProvider<ParChaveDescricao> dataProv = new ListDataProvider<ParChaveDescricao>();
	private CellTable<ParChaveDescricao> cellTable = new CellTable<ParChaveDescricao>();
	
	private FlowPanel flow = new FlowPanel();
	private InputViewWithTitle<String> palavraChave= new InputViewWithTitle<String>("Digite nome ou CPF/CNPJ(somente algarismos) e aperte a tecla enter", new InputViewTextBox(50, 500));

	final private PesquisaCallBack callback; 
	
	@Override
	public String getTitulo(){
		return "Pesquisar "+categoria;
	}
	
	public  FormPesquisar (String categoria, PesquisaCallBack resposta){
		initWidget(flow);
		
		this.categoria=categoria;
		this.callback=resposta;
		
		flow.add(palavraChave);
		
		palavraChave.asWidget().addStyleName("padding10");

		cellTable.setKeyboardSelectionPolicy(HasKeyboardSelectionPolicy.KeyboardSelectionPolicy.ENABLED);
		dataProv.addDataDisplay(cellTable);
		
		flow.add(cellTable);
		cellTable.setWidth("100%");
		
		Column<ParChaveDescricao, String> column = new Column<ParChaveDescricao, String>(new ButtonCell()) {
			@Override
			public String getValue(ParChaveDescricao object) {
				return "selecionar";
			}
		};
		cellTable.addColumn(column);
		
		TextColumn<ParChaveDescricao> textColumn = new TextColumn<ParChaveDescricao>() {
			@Override
			public String getValue(ParChaveDescricao object) {
				return object.getDescricao();
			}
		};
		cellTable.addColumn(textColumn, "Resultados");
		
		column.setFieldUpdater(new FieldUpdater<ParChaveDescricao, String>(){
			@Override
			public void update(int index, ParChaveDescricao object, String value) {
				callback.sucesso(object);
			}
			
		});
		
	}
	
	public boolean setList(List<ParChaveDescricao> input) {
		dataProv.setList(input);
		return true;
	}
	
	public List<ParChaveDescricao> getList() {
		return dataProv.getList();
	}
		
		

	@Override
	public boolean setInput(ParChaveDescricao input) {
		if(cellTable.getVisibleItems().indexOf(input)>-1){
			cellTable.getSelectionModel().setSelected(input, true);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public ParChaveDescricao getInput() {
		return cellTable.getVisibleItem(cellTable.getKeyboardSelectedRow());
	}


	public interface PesquisaCallBack {
		void sucesso(ParChaveDescricao resposta);
		void semResposta();
	}


	@Override
	protected ParChaveDescricao criarInputVazio() {
		return new ParChaveDescricao();
	}
	
	
	
}
