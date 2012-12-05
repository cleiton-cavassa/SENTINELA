package cleiton.unisul.piweb.sistema.client.formularios.frota;

import java.util.ArrayList;

import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.FormPesquisar.PesquisaCallBack;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputView;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewCPF;
import cleiton.unisul.piweb.ferramentasVisuais.client.util.CriadorTela;
import cleiton.unisul.piweb.ferramentasVisuais.client.util.FecharPopUpEventHandler;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.ClientePF;
import cleiton.unisul.piweb.sistema.client.formularios.individuais.FormClientePF;

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
import com.google.gwt.view.client.ListDataProvider;

public class FormClientesPFdeUmaFrota extends Composite implements InputView<ArrayList<ClientePF>>{//extends Formulario<DadosPessoaFisica>{
	
	private final ListDataProvider<ClientePF> d = new ListDataProvider<ClientePF>();
	
	private Button atualiz = new Button("atualizar tabela");
	private Button novo = new Button("novo cliente Pessoa Fisica");
	
	private final PesquisaCallBack<ClientePF> callback= new PesquisaCallBack<ClientePF>(){
		@Override
		public void sucesso(ClientePF resposta) {
			criarVinculo(resposta);
		}
		@Override
		public void semResposta() {}	
	};
	
	private boolean criarVinculo(ClientePF resposta){
		return d.getList().add(resposta);
	}
	
	
	private boolean excluirVinculo(ClientePF object){
		return d.getList().remove(object);
	}
	

	
	public FormClientesPFdeUmaFrota(){
		
		novo.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				new CriadorTela<ClientePF>(new FormClientePF(callback)).execute();
			}
		});
		
		
		FlowPanel flow = new FlowPanel();
		initWidget(flow);
		
		
		DockPanel dock = new DockPanel();
		
		dock.setSize("100%", "");
		
		dock.add(novo,DockPanel.WEST);
		dock.add(atualiz,DockPanel.EAST);
		dock.setCellHorizontalAlignment(atualiz, HasHorizontalAlignment.ALIGN_RIGHT);

		dock.addStyleName("padding10");
		flow.add(dock);
		
		CellTable<ClientePF> cellTable = new CellTable<ClientePF>();
		flow.add(cellTable);
		cellTable.setWidth("100%");
				
		d.addDataDisplay(cellTable);
		
		
		//Coluna "editar"
		Column<ClientePF, String> columnEditar = new Column<ClientePF, String>(new ButtonCell()) {
			@Override
			public String getValue(ClientePF object) {
				return "editar";
			}
		};
			cellTable.addColumn(columnEditar);
				columnEditar.setFieldUpdater(new FieldUpdater<ClientePF, String>(){
					@Override
					public void update(int index, ClientePF object, String value) {
						new CriadorTela<ClientePF>(new FormClientePF(new PesquisaCallBack<ClientePF>() {
							@Override
							public void sucesso(ClientePF resposta) {
								criarVinculo(resposta);
							}
							@Override
							public void semResposta() {}
						})).execute();
					}
				});
				
		
		//Coluna "Nome"
		TextColumn<ClientePF> textColumn = new TextColumn<ClientePF>() {
			@Override
			public String getValue(ClientePF object) {
				return object
						.getDadosPessoaFisica()
						.getNome();
			}
		};
		cellTable.addColumn(textColumn, "Nome");
		
		//Coluna "CPF"
		TextColumn<ClientePF> textCPF = new TextColumn<ClientePF>() {
			@Override
			public String getValue(ClientePF object) {
				return InputViewCPF.mascaraCPF(object
						.getDadosPessoaFisica()
						.getCpf()
						);
			}
		};
		cellTable.addColumn(textCPF, "CPF");
		
		//Coluna "excluir"
		Column<ClientePF, String> column = new Column<ClientePF, String>(new ButtonCell()) {
			@Override
			public String getValue(ClientePF object) {
				return "excluir";
			}
		};
		
		cellTable.addColumn(column);
		
				column.setFieldUpdater(new FieldUpdater<ClientePF, String>(){
					@Override
					public void update(int index, ClientePF object, String value) {
						excluirVinculo(object);
					}
				});
		
//		TextColumn<DadosPessoaFisica> textColumn_1 = new TextColumn<DadosPessoaFisica>() {
//			@Override
//			public String getValue(DadosPessoaFisica object) {
//				return InputViewCPF.mascaraCPF(object.getCpf());
//			}
//		};
//		cellTable.addColumn(textColumn_1, "CPF");
//		
//		TextColumn<DadosPessoaFisica> textColumn_2 = new TextColumn<DadosPessoaFisica>() {
//			@Override
//			public String getValue(DadosPessoaFisica object) {
//				return object.getIdiomasFalados().toString();
//			}
//		};
//		cellTable.addColumn(textColumn_2, "Idiomas falados");
		
	}

//	public boolean setList(List<ParChaveDescricao> input) {
//		d.setList(input);
//		return true;
//	}
//
//	public List<ParChaveDescricao> getList() {
//		return d.getList();
//	}
	



//	@Override
//	protected DadosPessoaFisica criarInputVazio() {
//		return new DadosPessoaFisica();
//	}


	@Override
	public String validarDados() {
		return null;
	}


	@Override
	public String getTitulo() {
		return null;
	}


	private FecharPopUpEventHandler f;
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
	public boolean setInput(ArrayList<ClientePF> input) {
		d.setList(input);
		return true;
	}


	@Override
	public ArrayList<ClientePF> getInput() {
		ArrayList<ClientePF> res = new ArrayList<ClientePF>(d.getList());
		return res;
	}

}
