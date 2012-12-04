package cleiton.unisul.piweb.sistema.client.formularios;

import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputView;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputViewFactory;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewCNPJ;
import cleiton.unisul.piweb.ferramentasVisuais.client.util.CriadorTela;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.ClientePJ;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.widgets.ColumnEditar;
import cleiton.unisul.piweb.sistema.client.formularios.individuais.FormClientePJ;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;



public class FormRelacaoClientesPJ extends FormRelacao<ClientePJ>{
	
	@Override
	public String getTitulo() {
		return "Listagem de Clientes PJ";
	}
	
	@Override
	protected ClientePJ novoOb() {
		return new ClientePJ();
	}
	
	public FormRelacaoClientesPJ() {
		iniciarWidgets();
	}
	
	protected CellTable<ClientePJ> criarTabela(){
		CellTable<ClientePJ> cellTable=new CellTable<ClientePJ>();
		
		cellTable.setSize("100%", "100%");
		
		cellTable.addColumn(colunaEditar(new InputViewFactory<ClientePJ>() {
			@Override
			public InputView<ClientePJ> getInputView() {
				return new FormClientePJ(false);
			}
		}));
		
		
		
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
		
		TextColumn<ClientePJ> textColumn_4 = new TextColumn<ClientePJ>() {
			@Override
			public String getValue(ClientePJ object) {
				return (object.getDadosClientePJ().getVoucher().toString());
			}
		};
		cellTable.addColumn(textColumn_4, "Voucher");
		
		cellTable.addColumn(colunaExcluir());
		
		return cellTable;
	}

}
