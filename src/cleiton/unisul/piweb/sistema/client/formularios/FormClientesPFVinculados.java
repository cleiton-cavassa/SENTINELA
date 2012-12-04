package cleiton.unisul.piweb.sistema.client.formularios;

import java.util.ArrayList;

import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.FormPesquisar.PesquisaCallBack;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputView;
import cleiton.unisul.piweb.ferramentasVisuais.client.util.CriadorTela;
import cleiton.unisul.piweb.ferramentasVisuais.client.util.FecharPopUpEventHandler;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.ClientePF;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.ParChaveDescricao;
import cleiton.unisul.piweb.sistema.client.SENTINELA;
import cleiton.unisul.piweb.sistema.client.formularios.pesquisa.FormPesquisarClientesPF;

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

public class FormClientesPFVinculados extends Composite implements InputView<ArrayList<ParChaveDescricao>>{//extends Formulario<DadosPessoaFisica>{
	
	private ListDataProvider<ParChaveDescricao> d = new ListDataProvider<ParChaveDescricao>();
	
	private Button atualiz = new Button("atualizar tabela");
	private Button novo = new Button("vincular novo cliente PF");
	
	private final PesquisaCallBack<ClientePF> callback= new PesquisaCallBack<ClientePF>(){
		@Override
		public void sucesso(ClientePF resposta) {
			criarVinculo(resposta);
		}
		@Override
		public void semResposta() {}	
	};
	
	private boolean criarVinculo(ClientePF resposta){
		ParChaveDescricao p = new ParChaveDescricao();
			p.setChaveObjeto(resposta.getChave());
			p.setDescricao(resposta.getResumo());
			
		return d.getList().add(p);
	}
	
	
	private boolean excluirVinculo(ParChaveDescricao object){
		return d.getList().remove(object);
	}
	

	
	public FormClientesPFVinculados(){
		
		novo.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				new CriadorTela<ClientePF>(new FormPesquisarClientesPF("ClientePF", SENTINELA.getFrota().getChave(), callback)).execute();
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
		
		CellTable<ParChaveDescricao> cellTable = new CellTable<ParChaveDescricao>();
		flow.add(cellTable);
		cellTable.setWidth("100%");
				
		d.addDataDisplay(cellTable);
		
		TextColumn<ParChaveDescricao> textColumn = new TextColumn<ParChaveDescricao>() {
			@Override
			public String getValue(ParChaveDescricao object) {
				return object.getDescricao();
			}
		};
		cellTable.addColumn(textColumn, "Cliente PF vinculado");
		
		Column<ParChaveDescricao, String> column = new Column<ParChaveDescricao, String>(new ButtonCell()) {
			@Override
			public String getValue(ParChaveDescricao object) {
				return "desvincular";
			}
		};
		
		cellTable.addColumn(column);
		
		column.setFieldUpdater(new FieldUpdater<ParChaveDescricao, String>(){
			@Override
			public void update(int index, ParChaveDescricao object, String value) {
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
	public boolean setInput(ArrayList<ParChaveDescricao> input) {
		d.setList(input);
		return true;
	}


	@Override
	public ArrayList<ParChaveDescricao> getInput() {
		ArrayList<ParChaveDescricao> result = new ArrayList<ParChaveDescricao>();
		result.addAll(d.getList());
		return result;
	}

}
