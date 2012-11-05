package cleiton.unisul.piweb.client.telaspopup;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.datepicker.client.DateBox.DefaultFormat;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.cellview.client.SimplePager;

public class CadastroClientesPJ extends Composite {

	public CadastroClientesPJ() {
		

		
		FlowPanel flowPanel = new FlowPanel();
		initWidget(flowPanel);
		flowPanel.setSize("", "100%");
		
		Label lblSentinelaCadastro = new Label("SENTINELA - Cadastro de Clientes - pessoa jur\u00EDdica");
		lblSentinelaCadastro.setStyleName("h1");
		lblSentinelaCadastro.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		flowPanel.add(lblSentinelaCadastro);
		lblSentinelaCadastro.setSize("100%", "20px");
		
		SimplePager simplePager = new SimplePager();
		flowPanel.add(simplePager);
		
		TabPanel tabPanel = new TabPanel();
		flowPanel.add(tabPanel);
		tabPanel.setSize("100%", "100%");
		
		VerticalPanel verticalPanel = new VerticalPanel();
		tabPanel.add(verticalPanel, "Dados do Cliente", false);
		verticalPanel.setSize("5cm", "3cm");
		
		Grid grid = new Grid(4, 2);
		verticalPanel.add(grid);
		
		Label lblCnpj = new Label("CNPJ:");
		lblCnpj.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		grid.setWidget(0, 0, lblCnpj);
		
		Label lblRazoSocial = new Label("Raz\u00E3o Social:");
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
		
		TextBox textBox = new TextBox();
		textBox.setVisibleLength(18);
		textBox.setMaxLength(14);
		grid.setWidget(0, 1, textBox);
		
		TextBox textBox_1 = new TextBox();
		textBox_1.setVisibleLength(120);
		grid.setWidget(1, 1, textBox_1);
		
		TextBox textBox_2 = new TextBox();
		textBox_2.setVisibleLength(120);
		grid.setWidget(2, 1, textBox_2);
		
		TextBox textBox_3 = new TextBox();
		textBox_3.setVisibleLength(120);
		grid.setWidget(3, 1, textBox_3);
		
				CheckBox checkBox = new CheckBox("Cliente Ativo");
				verticalPanel.add(checkBox);
				
				FlowPanel flowPanel_2 = new FlowPanel();
				verticalPanel.add(flowPanel_2);
				
				Button button = new Button("New button");
				button.setText("salvar");
				flowPanel_2.add(button);
				
				Button button_1 = new Button("New button");
				button_1.setText("excluir");
				flowPanel_2.add(button_1);
				
				VerticalPanel verticalPanel_3 = new VerticalPanel();
				tabPanel.add(verticalPanel_3, "Pessoas F\u00EDsicas Vinculadas", false);
				verticalPanel_3.setSize("100%", "100%");
				
				ListBox listBox = new ListBox();
				verticalPanel_3.add(listBox);
				listBox.setSize("100%", "100%");
				listBox.setVisibleItemCount(10);
				
				Button btnNewButton_1 = new Button("New button");
				verticalPanel_3.add(btnNewButton_1);
				btnNewButton_1.setText("desvincular PF selecionada");
				
				VerticalPanel verticalPanel_4 = new VerticalPanel();
				verticalPanel_3.add(verticalPanel_4);
				
				HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
				verticalPanel_3.add(horizontalPanel_1);
				
				Button btnNewButton = new Button("New button");
				btnNewButton.setText("incluir pessoa f\u00EDsica");
				horizontalPanel_1.add(btnNewButton);
				
				TextBox txtbxDigiteAquiA = new TextBox();
				txtbxDigiteAquiA.setMaxLength(11);
				txtbxDigiteAquiA.setText("digite aqui o CPF");
				horizontalPanel_1.add(txtbxDigiteAquiA);
				
				tabPanel.selectTab(0);
		
		setStyleName("painelCadastro");
	}

}
