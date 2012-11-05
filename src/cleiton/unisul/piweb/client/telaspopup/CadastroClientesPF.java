package cleiton.unisul.piweb.client.telaspopup;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Composite;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DateBox.DefaultFormat;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.client.ui.Grid;

public class CadastroClientesPF extends Composite {

	public CadastroClientesPF() {
		
		FlowPanel flowPanel1 = new FlowPanel();
		flowPanel1.setStyleName("painelCadastro");
		initWidget(flowPanel1);
		flowPanel1.setSize("", "");
		
		Label lblSentinelaCadastro = new Label("SENTINELA - Cadastro de Clientes - pessoas f\u00EDsicas");
		lblSentinelaCadastro.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		lblSentinelaCadastro.setStyleName("h1");
		flowPanel1.add(lblSentinelaCadastro);
		lblSentinelaCadastro.setSize("", "");
		
		SimplePager simplePager = new SimplePager();
		flowPanel1.add(simplePager);
		
		
		
		TabPanel tabPanel = new TabPanel();
		flowPanel1.add(tabPanel);
		tabPanel.setSize("", "");
		
		VerticalPanel caractPessoaisPanel = new VerticalPanel();
		tabPanel.add(caractPessoaisPanel, "Caracter\u00EDsticas Pessoais", false);
		caractPessoaisPanel.setSize("5cm", "3cm");
		
		Grid grid = new Grid(7, 2);
		caractPessoaisPanel.add(grid);
		
		Label label = new Label("nome:");
		label.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		grid.setWidget(0, 0, label);
		
		TextBox textBox_5 = new TextBox();
		textBox_5.setVisibleLength(120);
		grid.setWidget(0, 1, textBox_5 );
		
		Label label_1 = new Label("CPF:");

		
		label_1.setWordWrap(false);
		label_1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		grid.setWidget(1, 0, label_1);
		
		Label lblNewLabel_1 = new Label("data de nascimento:");
		lblNewLabel_1.setWordWrap(false);
		lblNewLabel_1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		grid.setWidget(2, 0, lblNewLabel_1);
		
		Label lblNewLabel_2 = new Label("tipo de nacionalidade");
		lblNewLabel_2.setWordWrap(false);
		lblNewLabel_2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		grid.setWidget(3, 0, lblNewLabel_2);
		
		Label lblNewLabel_3 = new Label("idiomas:");
		lblNewLabel_3.setWordWrap(false);
		lblNewLabel_3.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		grid.setWidget(4, 0, lblNewLabel_3);
		
		Label lblEndereo = new Label("Endere\u00E7o:");
		lblEndereo.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		grid.setWidget(5, 0, lblEndereo);
		
		Label lblTelefone = new Label("Telefones:");
		lblTelefone.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		grid.setWidget(6, 0, lblTelefone);
		
		TextBox textBox_3 = new TextBox();
		textBox_3.setMaxLength(11);
		grid.setWidget(1, 1, textBox_3);
		
		DateBox dateBox = new DateBox();
		dateBox.setFormat(new DefaultFormat(DateTimeFormat.getFormat("dd/MMM/aaaa")));
		grid.setWidget(2, 1, dateBox);
		dateBox.setSize("131", "25");
		
		
		FlowPanel flowPanel = new FlowPanel();
		grid.setWidget(3, 1, flowPanel);
		
		RadioButton rdbtnNewRadioButton = new RadioButton("new name", "brasileiro");
		flowPanel.add(rdbtnNewRadioButton);
		
		RadioButton rdbtnEstrangeiro = new RadioButton("new name", "estrangeiro");
		flowPanel.add(rdbtnEstrangeiro);
		
		TextBox textBox_1 = new TextBox();
		textBox_1.setVisibleLength(120);
		grid.setWidget(4, 1, textBox_1);
		
		TextBox textBox_2_1 = new TextBox();
		textBox_2_1.setVisibleLength(120);
		grid.setWidget(5, 1, textBox_2_1);
		
		TextBox textBox_4 = new TextBox();
		textBox_4.setVisibleLength(120);
		grid.setWidget(6, 1, textBox_4);
		
		CheckBox chckbxNewCheckBox = new CheckBox("Cliente Ativo");
		caractPessoaisPanel.add(chckbxNewCheckBox);
		
		FlowPanel flowPanel_1 = new FlowPanel();
		caractPessoaisPanel.add(flowPanel_1);
		flowPanel_1.setWidth("100%");
		
		Button btnNewButton = new Button("New button");
		flowPanel_1.add(btnNewButton);
		btnNewButton.setText("salvar");
		
		Button button = new Button("New button");
		button.setText("excluir");
		flowPanel_1.add(button);
		
		
		VerticalPanel horizontalPanel = new VerticalPanel();
		tabPanel.add(horizontalPanel, "Prefer\u00EAncias", false);
		horizontalPanel.setSize("10cm", "3cm");
		
		Label lblNewLabel_4 = new Label("Tipos de Carros Preferidos");
		horizontalPanel.add(lblNewLabel_4);
		lblNewLabel_4.setWidth("158px");
		
		TextBox textBox_2 = new TextBox();
		horizontalPanel.add(textBox_2);
		textBox_2.setWidth("161px");
		
		CheckBox pshbtnNewButton = new CheckBox("New button");
		pshbtnNewButton.setHTML("animal de estima\u00E7\u00E3o");
		horizontalPanel.add(pshbtnNewButton);
		pshbtnNewButton.setSize("129px", "20");
		
		CheckBox pushButton = new CheckBox("New button");
		pushButton.setHTML("permite motorista fumante");
		horizontalPanel.add(pushButton);
		pushButton.setSize("129px", "20");
		
		
		tabPanel.selectTab(0);
		setStyleName("painelCadastro");
	}

}
