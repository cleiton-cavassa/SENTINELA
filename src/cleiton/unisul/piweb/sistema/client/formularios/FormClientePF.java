package cleiton.unisul.piweb.sistema.client.formularios;

import cleiton.unisul.piweb.ferramentasVisuais.client.enums.ListBoxEnumeracoes;

import cleiton.unisul.piweb.rpc.shared.objetoschaveados.ClientePF;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.Preferencias.MotoristaFumante;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.Preferencias.TransportaAnimais;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.ClientePF.Status;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.ClientePF.TipoNacionalidade;
import cleiton.unisul.piweb.sistema.client.validacao.CompositeCNPJ;
import cleiton.unisul.piweb.sistema.client.validacao.CompositeCPF;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DateBox.DefaultFormat;

	public class FormClientePF extends Composite {
		private TextBox textBox;
		private CompositeCPF compositeCPF;
		private CompositeCNPJ compositeCNPJ;
		private DateBox dateBox;
		private ListBoxEnumeracoes<TipoNacionalidade> comboBox;
		private TextBox textBox_1;
		private TextBox textBox_2;
		private TextBox textBox_3;
		private ListBoxEnumeracoes<Status> chckbxNewCheckBox;
		private ListBoxEnumeracoes<TransportaAnimais> pshbtnNewButton;
		private ListBoxEnumeracoes<MotoristaFumante> pushButton;
		private Button btnNewButton;
		private Button button;

		/**
		 * @wbp.parser.constructor
		 */
		public FormClientePF() {
			
			TabPanel tabPanel = new TabPanel();
			tabPanel.setStyleName("painelCadastro");
			initWidget(tabPanel);
			tabPanel.setSize("914px", "300");
			
			VerticalPanel caractPessoaisPanel = new VerticalPanel();
			tabPanel.add(caractPessoaisPanel, "Caracter\u00EDsticas Pessoais", false);
			caractPessoaisPanel.setSize("5cm", "3cm");
			
			Grid grid = new Grid(8, 2);
			caractPessoaisPanel.add(grid);
			
			Label lblNome = new Label("nome(*):");
			lblNome.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
			grid.setWidget(0, 0, lblNome);
			
			textBox = new TextBox();
			textBox.setVisibleLength(120);
			grid.setWidget(0, 1, textBox );
			
			Label lblCpf = new Label("CPF(*):");
			
						
						lblCpf.setWordWrap(false);
						lblCpf.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
						grid.setWidget(1, 0, lblCpf);
						
						compositeCPF = new CompositeCPF();
						grid.setWidget(1, 1, compositeCPF);
						
						Label lblPjDeOrigem = new Label("PJ de origem:");
						lblPjDeOrigem.setWordWrap(false);
						lblPjDeOrigem.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
						grid.setWidget(2, 0, lblPjDeOrigem);
						
						compositeCNPJ = new CompositeCNPJ();
						grid.setWidget(2, 1, compositeCNPJ);
						
						Label lblNewLabel_1 = new Label("data de nascimento(*):");
						lblNewLabel_1.setWordWrap(false);
						lblNewLabel_1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
						grid.setWidget(3, 0, lblNewLabel_1);
						
						Label lblNewLabel_2 = new Label("tipo de nacionalidade");
						lblNewLabel_2.setWordWrap(false);
						lblNewLabel_2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
						grid.setWidget(4, 0, lblNewLabel_2);
						
						Label lblNewLabel_3 = new Label("idiomas:");
						lblNewLabel_3.setWordWrap(false);
						lblNewLabel_3.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
						grid.setWidget(5, 0, lblNewLabel_3);
						
						Label lblEndereo = new Label("endere\u00E7o:");
						lblEndereo.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
						grid.setWidget(6, 0, lblEndereo);
						
						Label lblTelefone = new Label("telefones:");
						lblTelefone.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
						grid.setWidget(7, 0, lblTelefone);
						
						dateBox = new DateBox();
						dateBox.setFormat(new DefaultFormat(DateTimeFormat.getFormat("dd/MMM/yyyy")));
						grid.setWidget(3, 1, dateBox);
						dateBox.setSize("131", "25");
						
						
						FlowPanel flowPanel = new FlowPanel();
						grid.setWidget(4, 1, flowPanel);
						
						comboBox = new ListBoxEnumeracoes<TipoNacionalidade>(ClientePF.TipoNacionalidade.Brasileiro);

						flowPanel.add(comboBox);
						
						textBox_1 = new TextBox();
						textBox_1.setVisibleLength(120);
						grid.setWidget(5, 1, textBox_1);
						
						textBox_2 = new TextBox();
						textBox_2.setVisibleLength(120);
						grid.setWidget(6, 1, textBox_2);
						
						textBox_3 = new TextBox();
						textBox_3.setVisibleLength(120);
						grid.setWidget(7, 1, textBox_3);
						
						chckbxNewCheckBox = new ListBoxEnumeracoes<Status>(Status.Ativo);
						chckbxNewCheckBox.setStyleName("ativoCheckBox");
						caractPessoaisPanel.add(chckbxNewCheckBox);
						
						HorizontalPanel flowPanel_1 = new HorizontalPanel();
						flowPanel_1.setSpacing(3);
						caractPessoaisPanel.add(flowPanel_1);
						flowPanel_1.setWidth("211");
						
						btnNewButton = new Button("New button");
						flowPanel_1.add(btnNewButton);
						btnNewButton.setText("salvar");
						
						button = new Button("New button");
						button.setText("excluir");
						flowPanel_1.add(button);
			
			
			VerticalPanel horizontalPanel = new VerticalPanel();
			tabPanel.add(horizontalPanel, "Prefer\u00EAncias", false);
			horizontalPanel.setSize("5cm", "300");
			
			Grid grid_1 = new Grid(2, 2);
			horizontalPanel.add(grid_1);
			
			Label lblTransportaAnimais = new Label("Carrega animais?");
			lblTransportaAnimais.setWordWrap(false);
			grid_1.setWidget(0, 0, lblTransportaAnimais);
			
			pshbtnNewButton = new ListBoxEnumeracoes<TransportaAnimais>(TransportaAnimais.Nao);
			grid_1.setWidget(0, 1, pshbtnNewButton);
			pshbtnNewButton.setSize("", "");
			
			Label lblMotoristaFumante = new Label("Aceita motorista fumante?");
			lblMotoristaFumante.setWordWrap(false);
			grid_1.setWidget(1, 0, lblMotoristaFumante);
			
			pushButton = new ListBoxEnumeracoes<MotoristaFumante>(MotoristaFumante.Nao);
			grid_1.setWidget(1, 1, pushButton);
			pushButton.setSize("129px", "20");
			grid_1.getCellFormatter().setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_RIGHT);
			grid_1.getCellFormatter().setHorizontalAlignment(1, 0, HasHorizontalAlignment.ALIGN_RIGHT);
			setStyleName("painelCadastro"); 
			
			tabPanel.selectTab(0);
		}

		public TextBox getTextBoxNome() {
			return textBox;
		}
		public CompositeCPF getCompositeCPF() {
			return compositeCPF;
		}
		public CompositeCNPJ getCompositePJdeOrigem() {
			return compositeCNPJ;
		}
		public DateBox getDateBoxNascimento() {
			return dateBox;
		}
		public ListBoxEnumeracoes<TipoNacionalidade> getComboBoxTipoNacionalidade() {
			return comboBox;
		}
		public TextBox getTextBoxIdiomas() {
			return textBox_1;
		}
		public TextBox getTextBoxEndereco() {
			return textBox_2;
		}
		public TextBox getTextBoxTelefones() {
			return textBox_3;
		}
		public ListBoxEnumeracoes<Status> getChckbxStatus() {
			return chckbxNewCheckBox;
		}
		public ListBoxEnumeracoes<TransportaAnimais> getCheckBoxTransportaAnimais() {
			return pshbtnNewButton;
		}
		public ListBoxEnumeracoes<MotoristaFumante> getCheckBoxPermiteMotFumante() {
			return pushButton;
		}
		public Button getBotaoSalvar() {
			return btnNewButton;
		}
		public Button getBotaoExcluir() {
			return button;
		}
}
