package cleiton.unisul.piweb.sistema.client.telaspopup.clientes.clientespj;

import java.util.List;

import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputView;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewCNPJ;
import cleiton.unisul.piweb.ferramentasVisuais.client.util.CriadorTela;
import cleiton.unisul.piweb.ferramentasVisuais.client.util.FecharPopUpEventHandler;
import cleiton.unisul.piweb.rpc.client.ServicoArmazenamento;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.ClientePJ;
import cleiton.unisul.piweb.sistema.client.formularios.FormClientePJ;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.ListDataProvider;



public class RelacaoClientesPJ extends Composite implements InputView<List<ClientePJ>>{

	private final ListDataProvider<ClientePJ> dataProvider = new ListDataProvider<ClientePJ>();
	private final AsyncCallback<List<ClientePJ>> callback= new CallbackArmazenamento(dataProvider);
	
	public RelacaoClientesPJ() {
				
		FlowPanel flowPanel = new FlowPanel();
		flowPanel.setStyleName("painelCadastro");
		initWidget(flowPanel);
		flowPanel.setSize("854px", "");
		
		VerticalPanel verticalPanel = new VerticalPanel();
		flowPanel.add(verticalPanel);
		verticalPanel.setWidth("100%");
		
		DecoratorPanel decoratorPanel_1 = new DecoratorPanel();
		verticalPanel.add(decoratorPanel_1);
		decoratorPanel_1.setSize("100%", "100%");
		
		decoratorPanel_1.setWidget(criarTabela());
		
		atualizar();
	}
	
	protected CellTable<ClientePJ> criarTabela(){
		CellTable<ClientePJ> cellTable=new CellTable<ClientePJ>();
		
		cellTable.setSize("100%", "100%");
		
		Column<ClientePJ, String> column_1 = new Column<ClientePJ, String>(new ButtonCell()) {
			@Override
			public String getValue(ClientePJ object) {
				return "editar";
			}
		};
		Column<ClientePJ,String> colBotoes=column_1;
		colBotoes.setFieldUpdater(new FieldUpdater<ClientePJ, String>(){
			@Override
			public void update(int index, ClientePJ object, String value) {
				FormClientePJ c =new FormClientePJ();
				c.setInput(object);
				new CriadorTela(c).execute();				
			}
			
		});
		
		cellTable.addColumn(column_1);
		
		
		
		TextColumn<ClientePJ> textColumn = new TextColumn<ClientePJ>() {
			@Override
			public String getValue(ClientePJ object) {
				return InputViewCNPJ.mascaraCNPJ(object.getPessoaJuridica().getDadosPessoaJuridica().getCnpj());
			}
		};
		cellTable.addColumn(textColumn, "CNPJ");
		
		TextColumn<ClientePJ> textColumn_1 = new TextColumn<ClientePJ>() {
			@Override
			public String getValue(ClientePJ object) {
				return object.getPessoaJuridica().getDadosPessoaJuridica().getRazaoSocial();		
			}
		};
		cellTable.addColumn(textColumn_1, "Raz\u00E3o Social");
		
		TextColumn<ClientePJ> textColumn_2 = new TextColumn<ClientePJ>() {
			@Override
			public String getValue(ClientePJ object) {
				return object.getPessoaJuridica().getDadosDeContato().getEndereco();		
			}
		};
		cellTable.addColumn(textColumn_2, "Endere\u00E7o Matriz");
		
		TextColumn<ClientePJ> textColumn_3 = new TextColumn<ClientePJ>() {
			@Override
			public String getValue(ClientePJ object) {
				return object.getPessoaJuridica().getDadosPessoaJuridica().getRegioesDeAtuacao().toString();
			}
		};
		cellTable.addColumn(textColumn_3, "Regi\u00E3o de Atua\u00E7\u00E3o");
		
		TextColumn<ClientePJ> column = new TextColumn<ClientePJ>() {
			@Override
			public String getValue(ClientePJ object) {
				return (object.getDadosClientePJ().getStatus().toString());
			}
		};
		cellTable.addColumn(column, "Ativo?");
		
		dataProvider.addDataDisplay(cellTable);
		
		TextColumn<ClientePJ> textColumn_4 = new TextColumn<ClientePJ>() {
			@Override
			public String getValue(ClientePJ object) {
				return (object.getDadosClientePJ().getVoucher().toString());
			}
		};
		cellTable.addColumn(textColumn_4, "Voucher");
		
		return cellTable;
	}
	
	public void atualizar(){
		ServicoArmazenamento.getArmazenamento().recuperar(new ClientePJ(), callback);		
	}
	
	private class CallbackArmazenamento implements AsyncCallback<List<ClientePJ>>{
		ListDataProvider<ClientePJ> prov;
		public CallbackArmazenamento(ListDataProvider<ClientePJ> dtPr){
			prov=dtPr;
		}
		
		@Override
		public void onSuccess(List<ClientePJ> result) {
			prov.setList(result);
		}
		
		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Problemas ao recuperar lista de clientes PJ\n\n"+caught.getMessage());
		}
	}

	@Override
	public String validarDados() {
		return null;
	}

	@Override
	public String getTitulo() {
		return "Listagem de Clientes PJ";
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
	public List<ClientePJ> getInput() {
		return dataProvider.getList();
	}

	@Override
	public boolean setInput(List<ClientePJ> input) {
		dataProvider.setList(input);
		return true;
	}
}
