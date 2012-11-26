package cleiton.unisul.piweb.sistema.client.telaspopup.clientes.clientespf;

import java.util.List;

import cleiton.unisul.piweb.ferramentasVisuais.client.util.CriadorTela;
import cleiton.unisul.piweb.rpc.client.ServicoArmazenamento;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.ClientePF;
import cleiton.unisul.piweb.sistema.client.formularios.FormClientePF;
import cleiton.unisul.piweb.sistema.client.formularios.Formulario;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.ListDataProvider;

public class RelacaoClientesPF extends Formulario<ClientePF>{
	private CellTable<ClientePF> tabela;
	
	private static RelacaoClientesPF get=new RelacaoClientesPF();
	
	public static RelacaoClientesPF get(){
		if(get==null){
			get=new RelacaoClientesPF();
		}
		get.atualizar();
		return get;
	}
	
	final ListDataProvider<ClientePF> dataProvider = new ListDataProvider<ClientePF>();
//	final String strPositivo="Sim";
//	final String strNegativo="Nao";
	
	private RelacaoClientesPF() {
		
		FlowPanel flowPanel = new FlowPanel();
		flowPanel.setStyleName("painelCadastro");
		initWidget(flowPanel);
		flowPanel.setSize("808px", "");
		
		Label lblSentinelaRelao = new Label("SENTINELA - Rela\u00E7\u00E3o de Clientes PESSOAS F\u00CDSICAS");
		lblSentinelaRelao.setStyleName("h1");
		lblSentinelaRelao.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		flowPanel.add(lblSentinelaRelao);
		lblSentinelaRelao.setSize("", "");

//		ClickHandler h=new ClickHandler() {
//			public void onClick(ClickEvent event) {
//				new CriadorTela(CriarNovoClientePF.get()).execute();
//			}
//		};
		
		VerticalPanel verticalPanel = new VerticalPanel();
		flowPanel.add(verticalPanel);
		verticalPanel.setWidth("");
		
		CellTable<ClientePF> cellTable = new CellTable<ClientePF>();
		verticalPanel.add(cellTable);
		cellTable.setWidth("");
		
		Column<ClientePF, String> column_3 = new Column<ClientePF, String>(new ButtonCell()) {
			@Override
			public String getValue(ClientePF object) {
				return "editar";
			}
		};
		cellTable.addColumn(column_3);
		
		Column<ClientePF,String> colBotoes=column_3;
		colBotoes.setFieldUpdater(new FieldUpdater<ClientePF, String>(){
			@Override
			public void update(int index, ClientePF object, String value) {
//				CadastroClientesPF c =CadastroClientesPF.get();
//				c.setCliente(object);
				FormClientePF c = new FormClientePF();
				c.setInput(object);
				Window.alert(object.getResumo());
				new CriadorTela(c).execute();				
			}
			
		});
		
		
		
		
		TextColumn<ClientePF> textColumn = new TextColumn<ClientePF>() {
			public String getValue(ClientePF clientePF) {
				try{
					return String.valueOf(clientePF.
							getDadosPessoaFisica().
							getCpf());
				}catch(NullPointerException nEx){
					return "vazio";
				}

			}
		};
		cellTable.addColumn(textColumn, "CPF");
		
		TextColumn<ClientePF> textColumn_1 = new TextColumn<ClientePF>() {
			public String getValue(ClientePF clientePF) {
				try{
					return clientePF.
							getDadosPessoaFisica().
							getNome();
				}catch(NullPointerException nEx){
					return "vazio";
				}

			}
		};
		cellTable.addColumn(textColumn_1, "Nome");
		
		TextColumn<ClientePF> column = new TextColumn<ClientePF>() {
			@Override
			public String getValue(ClientePF clientePF) {
				try{
					return (clientePF.getDadosClientePF().getStatus().name());
				}catch(NullPointerException nEx){
					return "vazio";
				}
			}
		};
		cellTable.addColumn(column, "Ativo?");
		
		TextColumn<ClientePF> textColumn_2 = new TextColumn<ClientePF>() {
			public String getValue(ClientePF clientePF) {
				try{
					return clientePF.
							getDadosPessoaFisica().
							getIdiomasFalados().toString();
				}catch(NullPointerException nEx){
					return "vazio";
				}
			}
		};
		cellTable.addColumn(textColumn_2, "idiomas");
		
		TextColumn<ClientePF> column_1 = new TextColumn<ClientePF>() {
			@Override
			public String getValue(ClientePF clientePF) {
				try{
					return (clientePF.getPreferencias().getTransportaAnimais().name());
				}catch(NullPointerException nEx){
					return "vazio";
				}
			}
		};
		cellTable.addColumn(column_1, "carrega animais?");
		
		TextColumn<ClientePF> column_2 = new TextColumn<ClientePF>() {
			@Override
			public String getValue(ClientePF clientePF) {
				try{
					return (  clientePF.getPreferencias().getMotoristaFumante().name());
				}catch(NullPointerException nEx){
					return "vazio";
				}
				
			}
		};
		cellTable.addColumn(column_2, "aceita motoristas fumantes?");
		
		
		tabela=cellTable;

		atualizar();
		dataProvider.addDataDisplay(tabela);
	}
	
	public void atualizar(){
		AsyncCallback<List<ClientePF>> a= new CallbackArmazenamento(dataProvider);
		ServicoArmazenamento.getArmazenamento().recuperar(new ClientePF(), a);		
	}
	
	private class CallbackArmazenamento implements AsyncCallback<List<ClientePF>>{
		ListDataProvider<ClientePF> prov;
		public CallbackArmazenamento(ListDataProvider<ClientePF> dtPr){
			prov=dtPr;
		}
		
		@Override
		public void onSuccess(List<ClientePF> result) {
			prov.setList(result);
			
		}
		
		@Override
		public void onFailure(Throwable caught) {

		}
	}

	@Override
	protected ClientePF criarInputVazio() {
		return new ClientePF();
	}
}
