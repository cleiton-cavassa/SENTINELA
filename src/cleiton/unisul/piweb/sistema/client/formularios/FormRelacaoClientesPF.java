package cleiton.unisul.piweb.sistema.client.formularios;

import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputView;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputViewFactory;
import cleiton.unisul.piweb.ferramentasVisuais.client.util.CriadorTela;
import cleiton.unisul.piweb.rpc.client.ServicoArmazenamento;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.ClientePF;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.ClientePJ;
import cleiton.unisul.piweb.rpc.shared.respostasdeconsulta.RespostaPersistencia;
import cleiton.unisul.piweb.sistema.client.formularios.individuais.FormClientePF;
import cleiton.unisul.piweb.sistema.client.formularios.individuais.FormClientePJ;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class FormRelacaoClientesPF extends FormRelacao<ClientePF> {

	@Override
	public String getTitulo() {
		return "Listagem de clientes PF";
	}

	@Override
	protected ClientePF novoOb() {
		return new ClientePF();
	}
	
	public FormRelacaoClientesPF() {
		iniciarWidgets();
	}
	
	
	protected CellTable<ClientePF> criarTabela(){
		CellTable<ClientePF> cellTable= new CellTable<ClientePF>();
		
		cellTable.addColumn(colunaEditar(new InputViewFactory<ClientePF>() {
			@Override
			public InputView<ClientePF> getInputView() {
				return new FormClientePF(false);
			}
		}));
				
		
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
					return ( clientePF.getPreferencias().getMotoristaFumante().name() );
				}catch(NullPointerException nEx){
					return "vazio";
				}
				
			}
		};
		cellTable.addColumn(column_2, "aceita motoristas fumantes?");
		
		cellTable.addColumn(colunaExcluir());
		
		return cellTable;
	}	
}
