package cleiton.unisul.piweb.sistema.client.formularios;

import cleiton.unisul.piweb.rpc.shared.objetoschaveados.ClientePF;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.PessoaFisica;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.VerticalPanel;


public class FormClientePF extends Formulario<ClientePF>{
	@Override
	public String getTitulo(){
		return "Sentinela - Clientes Pessoa Fisica";
	}
	
	private VerticalPanel raiz;
	private FormDadosPessoaFisica dadosPessoaFisica = new FormDadosPessoaFisica();
	private FormDadosDeContato dadosDeContato= new FormDadosDeContato();
	private FormPreferencias preferencias= new FormPreferencias();
	private FormDadosClientePF dadosClientePF= new FormDadosClientePF();

	/**
	 * @wbp.parser.constructor
	 */
	public FormClientePF() {
		raiz = new VerticalPanel();
		TabPanel tabPanel = new TabPanel();
		tabPanel.setStyleName("painelCadastro");
		raiz.add(tabPanel);
		initWidget(raiz);
		tabPanel.setSize("914px", "300");
		
		
		tabPanel.add(dadosPessoaFisica, "Dados da Pessoa F\u00EDsica", false);
		tabPanel.add(dadosDeContato, "Dados de Contato", false);
		tabPanel.add(preferencias, "Prefer\u00EAncias", false);
		tabPanel.add(dadosClientePF, "Dados do cliente", false);
		
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
		
		tabPanel.selectTab(0);
	}

	@Override
	public boolean setInput(ClientePF input) {
		super.setInput(input);
		
		Boolean result;
		
		result=dadosPessoaFisica.setInput(input.getDadosPessoais().getDadosPessoaFisica());
		result&=dadosDeContato.setInput(input.getDadosPessoais().getDadosDeContato());
		result&=preferencias.setInput(input.getPreferencias());
		result&=dadosClientePF.setInput(input.getDadosClientePF());
		
		return result;
	}

	@Override
	public ClientePF getInput() {
		ClientePF input = super.getInput();
		
		input.setDadosClientePF(dadosClientePF.getInput());
		
		PessoaFisica pessoa = new PessoaFisica();
			pessoa.setDadosDeContato(dadosDeContato.getInput());
			pessoa.setDadosPessoaFisica(dadosPessoaFisica.getInput());
		input.setDadosPessoais(pessoa);
		input.setPreferencias(preferencias.getInput());
		return input;
	}
	
}









//import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.exibidor.InputView;
//import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputViewListBoxEnumeracoes;
//import cleiton.unisul.piweb.ferramentasVisuais.client.validacao.CompositeCNPJ;
//import cleiton.unisul.piweb.ferramentasVisuais.client.validacao.CompositeCPF;
//
//import cleiton.unisul.piweb.rpc.shared.objetoschaveados.ClientePF;
//import cleiton.unisul.piweb.rpc.shared.objetoschaveados.Preferencias.MotoristaFumante;
//import cleiton.unisul.piweb.rpc.shared.objetoschaveados.Preferencias.TransportaAnimais;
//import cleiton.unisul.piweb.rpc.shared.objetoschaveados.DadosClientePF.Status;
//import cleiton.unisul.piweb.rpc.shared.objetoschaveados.DadosClientePF.TipoNacionalidade;
//
//import com.google.gwt.i18n.client.DateTimeFormat;
//import com.google.gwt.user.client.ui.Button;
//import com.google.gwt.user.client.ui.FlowPanel;
//import com.google.gwt.user.client.ui.Grid;
//import com.google.gwt.user.client.ui.HasHorizontalAlignment;
//import com.google.gwt.user.client.ui.HorizontalPanel;
//import com.google.gwt.user.client.ui.Label;
//import com.google.gwt.user.client.ui.TabPanel;
//import com.google.gwt.user.client.ui.TextBox;
//import com.google.gwt.user.client.ui.VerticalPanel;
//import com.google.gwt.user.datepicker.client.DateBox;
//import com.google.gwt.user.datepicker.client.DateBox.DefaultFormat;

//public class FormClientePF extends Formulario implements InputView<ClientePF> {
//		private TextBox textBox;
//		private InputViewCPF inputViewCPF;
//		private InputViewCNPJ inputViewCNPJ;
//		private DateBox dateBox;
//		private InputViewListBoxEnumeracoes<TipoNacionalidade> comboBox;
//		private TextBox textBox_1;
//		private TextBox textBox_2;
//		private TextBox textBox_3;
//		private InputViewListBoxEnumeracoes<Status> chckbxNewCheckBox;
//		private InputViewListBoxEnumeracoes<TransportaAnimais> pshbtnNewButton;
//		private InputViewListBoxEnumeracoes<MotoristaFumante> pushButton;
//		private Button btnNewButton;
//		private Button button;
//
//		/**
//		 * @wbp.parser.constructor
//		 */
//		public FormClientePF() {
//			
//			TabPanel tabPanel = new TabPanel();
//			tabPanel.setStyleName("painelCadastro");
//			initWidget(tabPanel);
//			tabPanel.setSize("914px", "300");
//			
//			VerticalPanel caractPessoaisPanel = new VerticalPanel();
//			tabPanel.add(caractPessoaisPanel, "Caracter\u00EDsticas Pessoais", false);
//			caractPessoaisPanel.setSize("5cm", "3cm");
//			
//			Grid grid = new Grid(8, 2);
//			caractPessoaisPanel.add(grid);
//			
//			Label lblNome = new Label("nome(*):");
//			lblNome.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
//			grid.setWidget(0, 0, lblNome);
//			
//			textBox = new TextBox();
//			textBox.setVisibleLength(120);
//			grid.setWidget(0, 1, textBox );
//			
//			Label lblCpf = new Label("CPF(*):");
//			
//						
//						lblCpf.setWordWrap(false);
//						lblCpf.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
//						grid.setWidget(1, 0, lblCpf);
//						
//						inputViewCPF = new InputViewCPF();
//						grid.setWidget(1, 1, inputViewCPF);
//						
//						Label lblPjDeOrigem = new Label("PJ de origem:");
//						lblPjDeOrigem.setWordWrap(false);
//						lblPjDeOrigem.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
//						grid.setWidget(2, 0, lblPjDeOrigem);
//						
//						inputViewCNPJ = new InputViewCNPJ();
//						grid.setWidget(2, 1, inputViewCNPJ);
//						
//						Label lblNewLabel_1 = new Label("data de nascimento(*):");
//						lblNewLabel_1.setWordWrap(false);
//						lblNewLabel_1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
//						grid.setWidget(3, 0, lblNewLabel_1);
//						
//						Label lblNewLabel_2 = new Label("tipo de nacionalidade");
//						lblNewLabel_2.setWordWrap(false);
//						lblNewLabel_2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
//						grid.setWidget(4, 0, lblNewLabel_2);
//						
//						Label lblNewLabel_3 = new Label("idiomas:");
//						lblNewLabel_3.setWordWrap(false);
//						lblNewLabel_3.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
//						grid.setWidget(5, 0, lblNewLabel_3);
//						
//						Label lblEndereo = new Label("endere\u00E7o:");
//						lblEndereo.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
//						grid.setWidget(6, 0, lblEndereo);
//						
//						Label lblTelefone = new Label("telefones:");
//						lblTelefone.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
//						grid.setWidget(7, 0, lblTelefone);
//						
//						dateBox = new DateBox();
//						dateBox.setFormat(new DefaultFormat(DateTimeFormat.getFormat("dd/MMM/yyyy")));
//						grid.setWidget(3, 1, dateBox);
//						dateBox.setSize("131", "25");
//						
//						
//						FlowPanel flowPanel = new FlowPanel();
//						grid.setWidget(4, 1, flowPanel);
//						
//						comboBox = new InputViewListBoxEnumeracoes<TipoNacionalidade>(TipoNacionalidade.Brasileiro);
//
//						flowPanel.add(comboBox);
//						
//						textBox_1 = new TextBox();
//						textBox_1.setVisibleLength(120);
//						grid.setWidget(5, 1, textBox_1);
//						
//						textBox_2 = new TextBox();
//						textBox_2.setVisibleLength(120);
//						grid.setWidget(6, 1, textBox_2);
//						
//						textBox_3 = new TextBox();
//						textBox_3.setVisibleLength(120);
//						grid.setWidget(7, 1, textBox_3);
//						
//						chckbxNewCheckBox = new InputViewListBoxEnumeracoes<Status>(Status.Ativo);
//						chckbxNewCheckBox.setStyleName("ativoCheckBox");
//						caractPessoaisPanel.add(chckbxNewCheckBox);
//						
//						HorizontalPanel flowPanel_1 = new HorizontalPanel();
//						flowPanel_1.setSpacing(3);
//						caractPessoaisPanel.add(flowPanel_1);
//						flowPanel_1.setWidth("211");
//						
//						btnNewButton = new Button("New button");
//						flowPanel_1.add(btnNewButton);
//						btnNewButton.setText("salvar");
//						
//						button = new Button("New button");
//						button.setText("excluir");
//						flowPanel_1.add(button);
//			
//			
//			VerticalPanel horizontalPanel = new VerticalPanel();
//			tabPanel.add(horizontalPanel, "Prefer\u00EAncias", false);
//			horizontalPanel.setSize("5cm", "300");
//			
//			Grid grid_1 = new Grid(2, 2);
//			horizontalPanel.add(grid_1);
//			
//			Label lblTransportaAnimais = new Label("Carrega animais?");
//			lblTransportaAnimais.setWordWrap(false);
//			grid_1.setWidget(0, 0, lblTransportaAnimais);
//			
//			pshbtnNewButton = new InputViewListBoxEnumeracoes<TransportaAnimais>(TransportaAnimais.Nao);
//			grid_1.setWidget(0, 1, pshbtnNewButton);
//			pshbtnNewButton.setSize("", "");
//			
//			Label lblMotoristaFumante = new Label("Aceita motorista fumante?");
//			lblMotoristaFumante.setWordWrap(false);
//			grid_1.setWidget(1, 0, lblMotoristaFumante);
//			
//			pushButton = new InputViewListBoxEnumeracoes<MotoristaFumante>(MotoristaFumante.Nao);
//			grid_1.setWidget(1, 1, pushButton);
//			pushButton.setSize("129px", "20");
//			grid_1.getCellFormatter().setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_RIGHT);
//			grid_1.getCellFormatter().setHorizontalAlignment(1, 0, HasHorizontalAlignment.ALIGN_RIGHT);
//			setStyleName("painelCadastro"); 
//			
//			tabPanel.selectTab(0);
//		}
//
//		public TextBox getTextBoxNome() {
//			return textBox;
//		}
//		public InputViewCPF getCompositeCPF() {
//			return inputViewCPF;
//		}
//		public InputViewCNPJ getCompositePJdeOrigem() {
//			return inputViewCNPJ;
//		}
//		public DateBox getDateBoxNascimento() {
//			return dateBox;
//		}
//		public InputViewListBoxEnumeracoes<TipoNacionalidade> getComboBoxTipoNacionalidade() {
//			return comboBox;
//		}
//		public TextBox getTextBoxIdiomas() {
//			return textBox_1;
//		}
//		public TextBox getTextBoxEndereco() {
//			return textBox_2;
//		}
//		public TextBox getTextBoxTelefones() {
//			return textBox_3;
//		}
//		public InputViewListBoxEnumeracoes<Status> getChckbxStatus() {
//			return chckbxNewCheckBox;
//		}
//		public InputViewListBoxEnumeracoes<TransportaAnimais> getCheckBoxTransportaAnimais() {
//			return pshbtnNewButton;
//		}
//		public InputViewListBoxEnumeracoes<MotoristaFumante> getCheckBoxPermiteMotFumante() {
//			return pushButton;
//		}
//		public Button getBotaoSalvar() {
//			return btnNewButton;
//		}
//		public Button getBotaoExcluir() {
//			return button;
//		}
//}

