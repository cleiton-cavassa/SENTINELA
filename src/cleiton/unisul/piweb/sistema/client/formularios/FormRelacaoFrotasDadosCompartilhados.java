package cleiton.unisul.piweb.sistema.client.formularios;

import java.util.LinkedList;
import java.util.List;

import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputView;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputViewFactory;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewCNPJ;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.FrotaDadosCompartilhados;
import cleiton.unisul.piweb.sistema.client.SENTINELA;
import cleiton.unisul.piweb.sistema.client.formularios.individuais.FormFrotaDadosCompartilhados;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;



public class FormRelacaoFrotasDadosCompartilhados extends FormRelacao<FrotaDadosCompartilhados>{
	
	@Override
	public String getTitulo() {
		return "Listagem de Frotas Parceiras";
	}
	
	@Override
	public boolean setInput(List<FrotaDadosCompartilhados> input){
		LinkedList<FrotaDadosCompartilhados> l= new LinkedList<FrotaDadosCompartilhados>();
		String chave = SENTINELA.getFrota().getMeusDadosCompartilhados().getChave();
		for(FrotaDadosCompartilhados f: input){
			if(!(f.getChave().equals(chave))){
				l.add(f);
			}
		}
		return super.setInput(l);
	}
	
	
	@Override
	protected FrotaDadosCompartilhados novoOb() {
		return new FrotaDadosCompartilhados();
	}
	
	public FormRelacaoFrotasDadosCompartilhados() {
		iniciarWidgets();
	}
	
	protected CellTable<FrotaDadosCompartilhados> criarTabela(){
		CellTable<FrotaDadosCompartilhados> cellTable=new CellTable<FrotaDadosCompartilhados>();
		
		cellTable.setSize("100%", "100%");
		
		cellTable.addColumn(colunaEditar(new InputViewFactory<FrotaDadosCompartilhados>() {
			@Override
			public InputView<FrotaDadosCompartilhados> getInputView() {
				return new FormFrotaDadosCompartilhados(false);
			}
		}));
		
		TextColumn<FrotaDadosCompartilhados> textColumn = new TextColumn<FrotaDadosCompartilhados>() {
			@Override
			public String getValue(FrotaDadosCompartilhados object) {
				return InputViewCNPJ.mascaraCNPJ
										(object
										.getDadosPessoaJuridica()
										.getDadosPessoaJuridica()
										.getCnpj());
			}
		};
		cellTable.addColumn(textColumn, "CNPJ");
		
		TextColumn<FrotaDadosCompartilhados> textColumn_1 = new TextColumn<FrotaDadosCompartilhados>() {
			@Override
			public String getValue(FrotaDadosCompartilhados object) {
				return object
						.getDadosPessoaJuridica()
						.getDadosPessoaJuridica()
						.getRazaoSocial();		
			}
		};
		cellTable.addColumn(textColumn_1, "Raz\u00E3o Social");
		
		TextColumn<FrotaDadosCompartilhados > textColumn_2 = new TextColumn<FrotaDadosCompartilhados>() {
			@Override
			public String getValue(FrotaDadosCompartilhados object) {
				return object
					.getDadosPessoaJuridica()
					.getDadosDeContato()
					.getEndereco();		
			}
		};
		cellTable.addColumn(textColumn_2, "Endere\u00E7o Matriz");
		
		TextColumn<FrotaDadosCompartilhados> textColumn_3 = new TextColumn<FrotaDadosCompartilhados>() {
			@Override
			public String getValue(FrotaDadosCompartilhados object) {
				return object
						.getDadosPessoaJuridica()
						.getDadosPessoaJuridica()
						.getRegioesDeAtuacao()
						.toString();
			}
		};
		cellTable.addColumn(textColumn_3, "Regi\u00E3o de Atua\u00E7\u00E3o");
			
		cellTable.addColumn(colunaExcluir());
		
		return cellTable;
	}

}
