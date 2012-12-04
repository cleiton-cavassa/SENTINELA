package cleiton.unisul.piweb.ferramentasVisuais.client.formularios;

import java.util.List;

import cleiton.unisul.piweb.rpc.client.ServicoArmazenamento;
import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.view.client.ListDataProvider;

public abstract class FormPesquisar <Ob extends ObjetoChaveado>extends Formulario<Ob>{
	
	public abstract CellTable<Ob> getTabela();

	private String categoria;
	
	private ListDataProvider<Ob> dataProv = new ListDataProvider<Ob>();
//	private CellTable<ParChaveDescricao> cellTable = new CellTable<ParChaveDescricao>();
	
	private FlowPanel flow = new FlowPanel();
//	private String explic = "Digite nome ou CPF/CNPJ(somente algarismos) e aperte a tecla enter";
//	private String explic = "Digite o CPF(somente algarismos)";
//	private InputViewTextBox texto= new InputViewTextBox(50, 500);
//	private InputViewCPF texto= new InputViewCPF();
//	private InputViewWithTitle<Long> palavraChave;

	final private PesquisaCallBack<Ob> callback;
	
	final protected void acionarCallback(Ob resposta){
		try {
			fechar();
			callback.sucesso(resposta);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	final protected void acionarCallbackSemResposta(){
		try {
			fechar();
			callback.semResposta();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	protected Column<Ob,String> colunaEscolher(){
		Column<Ob,String> col = new Column<Ob,String>(new ButtonCell()){
			@Override
			public String getValue(Ob object) {
				return "escolher";
			}
		};
				col.setFieldUpdater(new FieldUpdater<Ob, String>() {
					@Override
					public void update(int index, Ob object, String value) {
						acionarCallback(object);
					}
				});
		return col;
	}
	
	@Override
	public String getTitulo(){
		return "Pesquisar "+categoria;
	}
	
	public  FormPesquisar (String categoria, String chavePai, PesquisaCallBack<Ob> resposta){
		initWidget(flow);
		
//		palavraChave= new InputViewWithTitle<Long>(explic, texto);
		
//		texto.addKeyDownHandler(new KeyDownHandler() {
//			@Override
//			public void onKeyDown(KeyDownEvent event) {
//				texto.getInput();				
//			}
//		});
		
		
		
		this.categoria=categoria;
		this.callback=resposta;
		
//		flow.add(palavraChave);
		
//		palavraChave.asWidget().addStyleName("padding10");

//		cellTable.setKeyboardSelectionPolicy(HasKeyboardSelectionPolicy.KeyboardSelectionPolicy.ENABLED);
		
		CellTable<Ob> tabela=getTabela();
		dataProv.addDataDisplay(tabela);
		flow.add(tabela);
		
		ServicoArmazenamento.getArmazenamento().recuperar(criarInputVazio(), chavePai, new CallbackRecuperacao());
		
//		dataProv.addDataDisplay(cellTable);
//		flow.add(cellTable);
//		cellTable.setWidth("100%");
		
//		Column<ParChaveDescricao, String> column = new Column<ParChaveDescricao, String>(new ButtonCell()) {
//			@Override
//			public String getValue(ParChaveDescricao object) {
//				return "selecionar";
//			}
//		};
//		cellTable.addColumn(column);
//		
//		TextColumn<ParChaveDescricao> textColumn = new TextColumn<ParChaveDescricao>() {
//			@Override
//			public String getValue(ParChaveDescricao object) {
//				return object.getDescricao();
//			}
//		};
//		cellTable.addColumn(textColumn, "Resultados");
//		
//		column.setFieldUpdater(new FieldUpdater<ParChaveDescricao, String>(){
//			@Override
//			public void update(int index, ParChaveDescricao object, String value) {
//				callback.sucesso(object);
//			}
//			
//		});
//		
	}
	
	private class CallbackRecuperacao implements AsyncCallback<List<Ob>>{

		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Falha durante a busca de "+categoria + ".\nTente novamente mais tarde.");
		}

		@Override
		public void onSuccess(List<Ob> result) {
			dataProv.setList(result);
		}
		
	}
	
//	public boolean setList(List<ParChaveDescricao> input) {
//		dataProv.setList(input);
//		return true;
//	}
//	
//	public List<ParChaveDescricao> getList() {
//		return dataProv.getList();
//	}
//		
		

//	@Override
//	public boolean setInput(ParChaveDescricao input) {
//		if(cellTable.getVisibleItems().indexOf(input)>-1){
//			cellTable.getSelectionModel().setSelected(input, true);
//			return true;
//		}else{
//			return false;
//		}
//	}

//	@Override
//	public ParChaveDescricao getInput() {
//		return cellTable.getVisibleItem(cellTable.getKeyboardSelectedRow());
//	}


	public interface PesquisaCallBack<T extends ObjetoChaveado> {
//		void sucesso(ParChaveDescricao resposta);
		void sucesso(T resposta);
		void semResposta();
	}


//	@Override
//	protected ParChaveDescricao criarInputVazio() {
//		return new ParChaveDescricao();
//	}
	
	
	
}
