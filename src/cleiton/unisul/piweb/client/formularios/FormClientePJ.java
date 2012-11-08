package cleiton.unisul.piweb.client.formularios;


import com.google.gwt.user.client.ui.Composite;

import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;

import cleiton.unisul.piweb.client.validacao.CompositeCNPJ;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;

public class FormClientePJ extends Composite {
	private Button button;
	private Button button_1;
	private CompositeCNPJ compositeCNPJ;
	private TextBox textBox;
	private TextBox textBox_1;
	private CheckBox checkBoxAtivo;
	private CheckBox chckbxVouchersAtivosPara;
	private TextBox textBox_2;

	public FormClientePJ() {

		TabPanel tabPanel = new TabPanel();
		initWidget(tabPanel);
		tabPanel.setSize("915px", "100%");
		
		VerticalPanel verticalPanel = new VerticalPanel();
		tabPanel.add(verticalPanel, "Dados do Cliente", false);
		verticalPanel.setSize("5cm", "3cm");
		
		Grid grid = new Grid(4, 2);
		verticalPanel.add(grid);
		
		Label lblCnpj = new Label("CNPJ(*):");
		lblCnpj.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		grid.setWidget(0, 0, lblCnpj);
		
		compositeCNPJ = new CompositeCNPJ();
		grid.setWidget(0, 1, compositeCNPJ);
		
		
		Label lblRazoSocial = new Label("Raz\u00E3o Social(*):");
		lblRazoSocial.setWordWrap(false);
		lblRazoSocial.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		grid.setWidget(1, 0, lblRazoSocial);
		
		Label lblEndereco = new Label("Endere\u00E7o da Matriz:");
		lblEndereco.setWordWrap(false);
		lblEndereco.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		grid.setWidget(2, 0, lblEndereco);
		
		Label lblreaDeAtuao = new Label("Regi\u00E3o de Atua\u00E7\u00E3o:");
		grid.setWidget(3, 0, lblreaDeAtuao);
		lblreaDeAtuao.setWidth("123px");
		
		textBox = new TextBox();
		textBox.setVisibleLength(120);
		grid.setWidget(1, 1, textBox);
		
		textBox_2 = new TextBox();
		textBox_2.setVisibleLength(120);
		grid.setWidget(2, 1, textBox_2);
		
		textBox_1 = new TextBox();
		textBox_1.setVisibleLength(120);
		grid.setWidget(3, 1, textBox_1);
		
				checkBoxAtivo = new CheckBox("Cliente Ativo");
				checkBoxAtivo.setHTML("cliente Ativo");
				checkBoxAtivo.setStyleName("ativoCheckBox");
				verticalPanel.add(checkBoxAtivo);
				
				chckbxVouchersAtivosPara = new CheckBox("Vouchers ativos para este cliente PJ");
				chckbxVouchersAtivosPara.setHTML("pagamentos com vouchers s\u00E3o permitidos para este cliente PJ");
				verticalPanel.add(chckbxVouchersAtivosPara);
				
				HorizontalPanel flowPanel_2 = new HorizontalPanel();
				flowPanel_2.setSpacing(3);
				flowPanel_2.setStyleName("separadorBotoes");
				verticalPanel.add(flowPanel_2);
				
				button = new Button("New button");
				button.setText("salvar");
				flowPanel_2.add(button);
				
				button_1 = new Button("New button");
				button_1.setText("excluir");
				flowPanel_2.add(button_1);
		
		VerticalPanel verticalPanel_3 = new VerticalPanel();
		tabPanel.add(verticalPanel_3, "Pessoas F\u00EDsicas Vinculadas", false);
		verticalPanel_3.setSize("100%", "3cm");
		
		CellTable<Object> cellTable = new CellTable<Object>();
		verticalPanel_3.add(cellTable);
		cellTable.setWidth("100%");
		
		TextColumn<Object> textColumn_3 = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		cellTable.addColumn(textColumn_3, "ID");
		cellTable.setColumnWidth(textColumn_3, "20%");
		
		TextColumn<Object> textColumn = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		cellTable.addColumn(textColumn, "Nome");
		cellTable.setColumnWidth(textColumn, "20%");
		
		TextColumn<Object> textColumn_1 = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		cellTable.addColumn(textColumn_1, "CPF");
		cellTable.setColumnWidth(textColumn_1, "20%");
		
		TextColumn<Object> textColumn_2 = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		cellTable.addColumn(textColumn_2, "Nacionalidade");
		cellTable.setColumnWidth(textColumn_2, "20%");
		
		TextColumn<Object> textColumn_4 = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		cellTable.addColumn(textColumn_4, "Idiomas");
		cellTable.setColumnWidth(textColumn_4, "20%");
		
		DecoratorPanel decoratorPanel = new DecoratorPanel();
		verticalPanel_3.add(decoratorPanel);
		decoratorPanel.setStyleName("padding10");
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		decoratorPanel.setWidget(horizontalPanel);
		horizontalPanel.setSpacing(10);
		
		Button btnNewButton = new Button("New button");
		btnNewButton.setStyleName("padding5");
		btnNewButton.setText("editar");
		horizontalPanel.add(btnNewButton);
		
		Button button_3 = new Button("New button");
		button_3.setText("excluir");
		button_3.setStyleName("padding5");
		horizontalPanel.add(button_3);
		
		Button btnNewButton_1 = new Button("New button");
		horizontalPanel.add(btnNewButton_1);
		btnNewButton_1.setStyleName("padding5");
		btnNewButton_1.setText("nova Pessoa F\u00EDsica");
		
		setStyleName("painelCadastro");
		tabPanel.selectTab(0);
	}

	public Button getBotaoSalvar() {
		return button;
	}
	public Button getBotaoExcluir() {
		return button_1;
	}
	public CompositeCNPJ getCompositeCNPJ() {
		return compositeCNPJ;
	}
	public TextBox getTextBoxRazaoSocial() {
		return textBox;
	}
	public TextBox getTextBoxRegioesDeAtuacao() {
		return textBox_1;
	}
	public CheckBox getCheckBoxAtivo() {
		return checkBoxAtivo;
	}
	public CheckBox getCheckboxVouchersAtivos() {
		return chckbxVouchersAtivosPara;
	}
	public TextBox getEnderecoMatriz() {
		return textBox_2;
	}
}
