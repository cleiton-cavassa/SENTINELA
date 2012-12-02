package cleiton.unisul.piweb.sistema.client.formularios;

import cleiton.unisul.piweb.ferramentasVisuais.client.util.CriadorTela;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.ClientePF;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.view.client.ListDataProvider;

public class FormRelacaoClientesPF extends FormRelacao<ClientePF> {//implements InputView<List<ClientePF>>{
	
	final ListDataProvider<ClientePF> dataProvider = new ListDataProvider<ClientePF>();
	
	public FormRelacaoClientesPF() {
		iniciarWidgets();
	}
	
	
	protected CellTable<ClientePF> criarTabela(){
		CellTable<ClientePF> cellTable= new CellTable<ClientePF>();
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
				FormClientePF c = new FormClientePF();
				c.setInput(object);
				new CriadorTela<ClientePF>(c).execute();				
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
		
		return cellTable;
	}
	
	@Override
	public String getTitulo() {
		return "Listagem de clientes PF";
	}

	@Override
	protected ClientePF novoOb() {
		return new ClientePF();
	}
}
