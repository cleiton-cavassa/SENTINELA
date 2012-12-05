package cleiton.unisul.piweb.sistema.client.formularios.frota;

import java.util.ArrayList;

import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.FormPesquisar.PesquisaCallBack;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputView;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewCNPJ;
import cleiton.unisul.piweb.ferramentasVisuais.client.util.CriadorTela;
import cleiton.unisul.piweb.ferramentasVisuais.client.util.FecharPopUpEventHandler;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.ClientePJ;
import cleiton.unisul.piweb.sistema.client.formularios.individuais.FormClientePJ;

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

public class FormClientesPJdeUmaFrota extends Composite implements InputView<ArrayList<ClientePJ>>{//extends Formulario<DadosPessoaFisica>{
	
	private final ListDataProvider<ClientePJ> d = new ListDataProvider<ClientePJ>();
	
	private Button atualiz = new Button("atualizar tabela");
	private Button novo = new Button("novo cliente Pessoa Juridica");
	
	private final PesquisaCallBack<ClientePJ> callback= new PesquisaCallBack<ClientePJ>(){
		@Override
		public void sucesso(ClientePJ resposta) {
			criarVinculo(resposta);
		}
		@Override
		public void semResposta() {}	
	};
	
	private boolean criarVinculo(ClientePJ resposta){
		return d.getList().add(resposta);
	}
	
	
	private boolean excluirVinculo(ClientePJ object){
		return d.getList().remove(object);
	}
	

	
	public FormClientesPJdeUmaFrota(){
		
		novo.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				new CriadorTela<ClientePJ>(new FormClientePJ(callback)).execute();
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
		
		CellTable<ClientePJ> cellTable = new CellTable<ClientePJ>();
		flow.add(cellTable);
		cellTable.setWidth("100%");
				
		d.addDataDisplay(cellTable);
		
		
		//Coluna "editar"
		Column<ClientePJ, String> columnEditar = new Column<ClientePJ, String>(new ButtonCell()) {
			@Override
			public String getValue(ClientePJ object) {
				return "editar";
			}
		};
			cellTable.addColumn(columnEditar);
				columnEditar.setFieldUpdater(new FieldUpdater<ClientePJ, String>(){
					@Override
					public void update(int index, ClientePJ object, String value) {
						new CriadorTela<ClientePJ>(new FormClientePJ(new PesquisaCallBack<ClientePJ>() {
							@Override
							public void sucesso(ClientePJ resposta) {
								criarVinculo(resposta);
							}
							@Override
							public void semResposta() {}
						})).execute();
					}
				});
				
		
		//Coluna "Raz‹o Social"
		TextColumn<ClientePJ> textColumn = new TextColumn<ClientePJ>() {
			@Override
			public String getValue(ClientePJ object) {
				return object.getPessoaJuridica().getDadosPessoaJuridica().getRazaoSocial();
			}
		};
		cellTable.addColumn(textColumn, "Razao Social");
		
		//Coluna "Raz‹o Social"
		TextColumn<ClientePJ> textCNPJ = new TextColumn<ClientePJ>() {
			@Override
			public String getValue(ClientePJ object) {
				return InputViewCNPJ.mascaraCNPJ(object
						.getPessoaJuridica()
						.getDadosPessoaJuridica()
						.getCnpj()
						);
			}
		};
		cellTable.addColumn(textCNPJ, "CNPJ");
		
		//Coluna "excluir"
		Column<ClientePJ, String> column = new Column<ClientePJ, String>(new ButtonCell()) {
			@Override
			public String getValue(ClientePJ object) {
				return "excluir";
			}
		};
		
		cellTable.addColumn(column);
		
				column.setFieldUpdater(new FieldUpdater<ClientePJ, String>(){
					@Override
					public void update(int index, ClientePJ object, String value) {
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
	public boolean setInput(ArrayList<ClientePJ> input) {
		d.setList(input);
		return true;
	}


	@Override
	public ArrayList<ClientePJ> getInput() {
		ArrayList<ClientePJ> res = new ArrayList<ClientePJ>(d.getList());
		return res;
	}

}
