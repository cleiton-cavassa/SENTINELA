package cleiton.unisul.piweb.sistema.client.formularios;

import cleiton.unisul.piweb.rpc.shared.objetoschaveados.ClientePJ;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.PessoaJuridica;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class FormClientePJ extends Formulario<ClientePJ>{
	
	@Override
	public String getTitulo(){
		return "Sentinela - Clientes Pessoa Jur’dica";
	}
	

	private final FormDadosPessoaJuridica dadosPessoaJuridica= new FormDadosPessoaJuridica();
	private final FormDadosDeContato dadosDeContato= new FormDadosDeContato();
	private final FormDadosClientePJ dadosClientePJ= new FormDadosClientePJ();
	private final FormClientesPFVinculados clientesPFVinculados = new FormClientesPFVinculados();
	
	private final VerticalPanel raiz;

	public FormClientePJ() {
		raiz = new VerticalPanel();
		TabPanel tabPanel = new TabPanel();
		raiz.add(tabPanel);
		initWidget(raiz);
		
		tabPanel.setSize("915px", "100%");
		
		tabPanel.add(dadosPessoaJuridica, "Dados da Pessoa Jur\u00EDdica", false);
		tabPanel.add(dadosDeContato, "Dados de contato", false);
		tabPanel.add(dadosClientePJ, "Dados do cliente", false);
		tabPanel.add(clientesPFVinculados, "Clientes Pessoa F\u00EDsica vinculados", false);
		
		clientesPFVinculados.setSize("100%", "");
		
		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		horizontalPanel_1.setSpacing(3);
		raiz.add(horizontalPanel_1);
		horizontalPanel_1.setWidth("211");
		
		Button button_1 = new Button("New button");
		button_1.setText("salvar");
		horizontalPanel_1.add(button_1);
		
		Button button_2 = new Button("New button");
		button_2.setText("excluir");
		horizontalPanel_1.add(button_2);
		setStyleName("painelCadastro"); 
		
		setStyleName("painelCadastro");
		tabPanel.selectTab(0);
	}
	@Override
	public boolean setInput(ClientePJ input) {
		super.setInput(input);
		
		dadosPessoaJuridica.setInput(input.getPessoaJuridica().getDadosPessoaJuridica());
		dadosDeContato.setInput(input.getPessoaJuridica().getDadosDeContato());
		dadosClientePJ.setInput(input.getDadosClientePJ());
		clientesPFVinculados.setList(input.getClientesPFVinculados());
		
		return true;
	}
	@Override
	public ClientePJ getInput() {
		ClientePJ input = super.getInput();
		
		input.setDadosClientePJ(dadosClientePJ.getInput());
		PessoaJuridica p = new PessoaJuridica();
			p.setDadosDeContato(dadosDeContato.getInput());
			p.setDadosPessoaJuridica(dadosPessoaJuridica.getInput());
		input.setPessoaJuridica(p);
		input.setClientesPFVinculados(clientesPFVinculados.getList());
		
		
		return null;
	}
	@Override
	protected ClientePJ criarInputVazio() {
		return new ClientePJ();
	}
}

//import com.google.gwt.user.client.ui.Grid;
//import com.google.gwt.user.client.ui.Label;
//import com.google.gwt.user.client.ui.HasHorizontalAlignment;
//import com.google.gwt.user.client.ui.TabPanel;
//import com.google.gwt.user.client.ui.VerticalPanel;
//import com.google.gwt.user.client.ui.HorizontalPanel;
//import com.google.gwt.user.client.ui.TextBox;
//import com.google.gwt.user.client.ui.Button;
//import com.google.gwt.user.client.ui.CheckBox;
//
//import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.exibidor.InputView;
//import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputViewCNPJ;
//import cleiton.unisul.piweb.rpc.shared.objetoschaveados.ClientePF;
//import cleiton.unisul.piweb.rpc.shared.objetoschaveados.ClientePJ;
//
//public class FormClientePJ extends Formulario implements InputView<ClientePJ> {
//	private Button button;
//	private Button button_1;
//	private InputViewCNPJ inputViewCNPJ;
//	private TextBox textBox;
//	private TextBox textBox_1;
//	private CheckBox checkBoxAtivo;
//	private CheckBox chckbxVouchersAtivosPara;
//	private TextBox textBox_2;
////	private Button botaoNovaPF;
////	private Button btnNewButton;
//
//	public FormClientePJ() {
//
//		TabPanel tabPanel = new TabPanel();
//		initWidget(tabPanel);
//		tabPanel.setSize("915px", "100%");
//		
//		VerticalPanel verticalPanel = new VerticalPanel();
//		tabPanel.add(verticalPanel, "Dados do Cliente", false);
//		verticalPanel.setSize("5cm", "3cm");
//		
//		Grid grid = new Grid(4, 2);
//		verticalPanel.add(grid);
//		
//		Label lblCnpj = new Label("CNPJ(*):");
//		lblCnpj.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
//		grid.setWidget(0, 0, lblCnpj);
//		
//		inputViewCNPJ = new InputViewCNPJ();
//		grid.setWidget(0, 1, inputViewCNPJ);
//		
//		
//		Label lblRazoSocial = new Label("Raz\u00E3o Social(*):");
//		lblRazoSocial.setWordWrap(false);
//		lblRazoSocial.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
//		grid.setWidget(1, 0, lblRazoSocial);
//		
//		Label lblEndereco = new Label("Endere\u00E7o da Matriz:");
//		lblEndereco.setWordWrap(false);
//		lblEndereco.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
//		grid.setWidget(2, 0, lblEndereco);
//		
//		Label lblreaDeAtuao = new Label("Regi\u00E3o de Atua\u00E7\u00E3o:");
//		grid.setWidget(3, 0, lblreaDeAtuao);
//		lblreaDeAtuao.setWidth("123px");
//		
//		textBox = new TextBox();
//		textBox.setVisibleLength(120);
//		grid.setWidget(1, 1, textBox);
//		
//		textBox_2 = new TextBox();
//		textBox_2.setVisibleLength(120);
//		grid.setWidget(2, 1, textBox_2);
//		
//		textBox_1 = new TextBox();
//		textBox_1.setVisibleLength(120);
//		grid.setWidget(3, 1, textBox_1);
//		
//				checkBoxAtivo = new CheckBox("Cliente Ativo");
//				checkBoxAtivo.setHTML("cliente Ativo");
//				checkBoxAtivo.setStyleName("ativoCheckBox");
//				verticalPanel.add(checkBoxAtivo);
//				
//				chckbxVouchersAtivosPara = new CheckBox("Vouchers ativos para este cliente PJ");
//				chckbxVouchersAtivosPara.setHTML("pagamentos com vouchers s\u00E3o permitidos para este cliente PJ");
//				verticalPanel.add(chckbxVouchersAtivosPara);
//				
//				HorizontalPanel flowPanel_2 = new HorizontalPanel();
//				flowPanel_2.setSpacing(3);
//				flowPanel_2.setStyleName("separadorBotoes");
//				verticalPanel.add(flowPanel_2);
//				
//				button = new Button("New button");
//				button.setText("salvar");
//				flowPanel_2.add(button);
//				
//				button_1 = new Button("New button");
//				button_1.setText("excluir");
//				flowPanel_2.add(button_1);
//		/*
//		VerticalPanel verticalPanel_3 = new VerticalPanel();
//		tabPanel.add(verticalPanel_3, "Pessoas F\u00EDsicas Vinculadas", false);
//		
//		CellTable<Object> cellTable = new CellTable<Object>();
//		verticalPanel_3.setSize("100%", "3cm");
//		verticalPanel_3.add(cellTable);
//		cellTable.setWidth("100%");
//		
//		TextColumn<Object> textColumn_3 = new TextColumn<Object>() {
//			@Override
//			public String getValue(Object object) {
//				return object.toString();
//			}
//		};
//		cellTable.addColumn(textColumn_3, "ID");
//		cellTable.setColumnWidth(textColumn_3, "20%");
//		
//		TextColumn<Object> textColumn = new TextColumn<Object>() {
//			@Override
//			public String getValue(Object object) {
//				return object.toString();
//			}
//		};
//		cellTable.addColumn(textColumn, "Nome");
//		cellTable.setColumnWidth(textColumn, "20%");
//		
//		TextColumn<Object> textColumn_1 = new TextColumn<Object>() {
//			@Override
//			public String getValue(Object object) {
//				return object.toString();
//			}
//		};
//		cellTable.addColumn(textColumn_1, "CPF");
//		cellTable.setColumnWidth(textColumn_1, "20%");
//		
//		TextColumn<Object> textColumn_2 = new TextColumn<Object>() {
//			@Override
//			public String getValue(Object object) {
//				return object.toString();
//			}
//		};
//		cellTable.addColumn(textColumn_2, "Nacionalidade");
//		cellTable.setColumnWidth(textColumn_2, "20%");
//		
//		TextColumn<Object> textColumn_4 = new TextColumn<Object>() {
//			@Override
//			public String getValue(Object object) {
//				return object.toString();
//			}
//		};
//		cellTable.addColumn(textColumn_4, "Idiomas");
//		cellTable.setColumnWidth(textColumn_4, "20%");
//		
//		DecoratorPanel decoratorPanel = new DecoratorPanel();
//		verticalPanel_3.add(decoratorPanel);
//		decoratorPanel.setStyleName("padding10");
//		
//		btnNewButton = new Button("New button");
//		decoratorPanel.setWidget(btnNewButton);
//		btnNewButton.setStyleName("padding5");
//		btnNewButton.setText("nova Pessoa F\u00EDsica");
//		*/
//		
//		setStyleName("painelCadastro");
//		tabPanel.selectTab(0);
//	}
//
//	public Button getBotaoSalvar() {
//		return button;
//	}
//	public Button getBotaoExcluir() {
//		return button_1;
//	}
//	public InputViewCNPJ getCompositeCNPJ() {
//		return inputViewCNPJ;
//	}
//	public TextBox getTextBoxRazaoSocial() {
//		return textBox;
//	}
//	public TextBox getTextBoxRegioesDeAtuacao() {
//		return textBox_1;
//	}
//	public CheckBox getCheckBoxAtivo() {
//		return checkBoxAtivo;
//	}
//	public CheckBox getCheckboxVouchersAtivos() {
//		return chckbxVouchersAtivosPara;
//	}
//	public TextBox getEnderecoMatriz() {
//		return textBox_2;
//	}
////	public Button getBotaoNovoClientePF() {
////		return btnNewButton;
////	}
//}
