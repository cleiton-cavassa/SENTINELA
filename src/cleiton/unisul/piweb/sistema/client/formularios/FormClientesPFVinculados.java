package cleiton.unisul.piweb.sistema.client.formularios;

import java.util.List;

import cleiton.unisul.piweb.ferramentasVisuais.client.util.CriadorTela;
import cleiton.unisul.piweb.rpc.shared.ParChaveDescricao;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.DadosPessoaFisica;
import cleiton.unisul.piweb.sistema.client.formularios.FormPesquisar.PesquisaCallBack;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.view.client.ListDataProvider;

public class FormClientesPFVinculados extends Formulario<DadosPessoaFisica>{
	
	private ListDataProvider<ParChaveDescricao> d = new ListDataProvider<ParChaveDescricao>();
	
	private Button atualiz = new Button("atualizar tabela");
	private Button novo = new Button("vincular novo cliente PF");
	
	
	private boolean criarVinculo(ParChaveDescricao resposta){
		//IMPLEMENTAR!!!
		return false;
	}
	
	
	private boolean excluirVinculo(String chave){
		//IMPLEMENTAR!!!
		return false;
	}
	

	
	public FormClientesPFVinculados(){
		
		novo.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				new CriadorTela(new FormPesquisar("ClientePF", callback)).execute();
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
				excluirVinculo(object.getChave());
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

	public boolean setList(List<ParChaveDescricao> input) {
		d.setList(input);
		return true;
	}

	public List<ParChaveDescricao> getList() {
		return d.getList();
	}
	
	private final PesquisaCallBack callback= new PesquisaCallBack(){
		@Override
		public void sucesso(ParChaveDescricao resposta) {
			criarVinculo(resposta);
		}
		@Override
		public void semResposta() {}	
	};

}
