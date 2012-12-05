package cleiton.unisul.piweb.sistema.client.formularios;

import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputView;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputViewFactory;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewCPF;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.Motorista;
import cleiton.unisul.piweb.sistema.client.formularios.individuais.FormMotorista;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;

public class FormRelacaoMotoristas extends FormRelacao<Motorista> {

	@Override
	public String getTitulo() {
		return "Listagem de Motoristas";
	}

	@Override
	protected Motorista novoOb() {
		return new Motorista();
	}
	
	public FormRelacaoMotoristas() {
		iniciarWidgets();
	}
	
	
	protected CellTable<Motorista> criarTabela(){
		CellTable<Motorista> cellTable= new CellTable<Motorista>();

		cellTable.addColumn(colunaEditar(new InputViewFactory<Motorista>() {
			@Override
			public InputView<Motorista> getInputView() {
				return new FormMotorista(false);
			}
		}));
		
		TextColumn<Motorista> textColumn = new TextColumn<Motorista>() {
			public String getValue(Motorista object) {
				try{
					return InputViewCPF.mascaraCPF(object.
							getDadosPessoais().
							getDadosPessoaFisica().
							getCpf());
				}catch(NullPointerException nEx){
					return "vazio";
				}

			}
		};
		cellTable.addColumn(textColumn, "CPF");
		
		TextColumn<Motorista> textColumn_1 = new TextColumn<Motorista>() {
			public String getValue(Motorista object) {
				try{
					return object.
							getDadosPessoais().
							getDadosPessoaFisica().
							getNome();
				}catch(NullPointerException nEx){
					return "vazio";
				}

			}
		};
		cellTable.addColumn(textColumn_1, "Nome");
		
		TextColumn<Motorista> column = new TextColumn<Motorista>() {
			@Override
			public String getValue(Motorista object) {
				try{
					return (object
							.getDadosProfissionais()
							.getCarro()
							);
				}catch(NullPointerException nEx){
					return "vazio";
				}
			}
		};
		cellTable.addColumn(column, "carro");
		
		TextColumn<Motorista> textColumn_2 = new TextColumn<Motorista>() {
			public String getValue(Motorista object) {
				try{
					return object.
							getDadosPessoais().
							getDadosPessoaFisica().
							getIdiomasFalados().toString();
				}catch(NullPointerException nEx){
					return "vazio";
				}
			}
		};
		cellTable.addColumn(textColumn_2, "idiomas");
		
		TextColumn<Motorista> column_1 = new TextColumn<Motorista>() {
			@Override
			public String getValue(Motorista object) {
				try{
					return (object.getPreferencias().getTransportaAnimais().name());
				}catch(NullPointerException nEx){
					return "vazio";
				}
			}
		};
		cellTable.addColumn(column_1, "carrega animais?");
		
		TextColumn<Motorista> column_2 = new TextColumn<Motorista>() {
			@Override
			public String getValue(Motorista object) {
				try{
					return ( object.getPreferencias().getMotoristaFumante().name() );
				}catch(NullPointerException nEx){
					return "vazio";
				}
				
			}
		};
		cellTable.addColumn(column_2, "fumante?");
		
		cellTable.addColumn(colunaExcluir());
		
		return cellTable;
	}	
}
