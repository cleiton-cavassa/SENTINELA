package cleiton.unisul.piweb.client.telaspopup;

import cleiton.unisul.piweb.client.validacao.CampoCNPJ;

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
import com.google.gwt.user.client.ui.IntegerBox;
import cleiton.unisul.piweb.client.validacao.CompositeCNPJ;
import com.google.gwt.user.client.ui.DecoratorPanel;

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
		
		Grid grid = new Grid(5, 2);
		verticalPanel.add(grid);
		
		Label label = new Label("ID:");
		label.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		grid.setWidget(0, 0, label);
		
		Label label_1 = new Label("Ainda n\u00E3o criado");
		label_1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		grid.setWidget(0, 1, label_1);
		
		Label label_2 = new Label("CNPJ:");
		label_2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		grid.setWidget(1, 0, label_2);
		
		CompositeCNPJ compositeCNPJ = new CompositeCNPJ();
		grid.setWidget(1, 1, compositeCNPJ);
		
		
		Label lblRazoSocial = new Label("Raz\u00E3o Social:");
		lblRazoSocial.setWordWrap(false);
		lblRazoSocial.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		grid.setWidget(2, 0, lblRazoSocial);
		
		Label lblEndereco = new Label("Endere\u00E7o da Matriz:");
		lblEndereco.setWordWrap(false);
		lblEndereco.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		grid.setWidget(3, 0, lblEndereco);
		
		Label lblreaDeAtuao = new Label("Regi\u00E3o de Atua\u00E7\u00E3o:");
		grid.setWidget(4, 0, lblreaDeAtuao);
		lblreaDeAtuao.setWidth("123px");
		
		TextBox textBox_1 = new TextBox();
		textBox_1.setVisibleLength(120);
		grid.setWidget(2, 1, textBox_1);
		
		TextBox textBox_2 = new TextBox();
		textBox_2.setVisibleLength(120);
		grid.setWidget(3, 1, textBox_2);
		
		TextBox textBox_3 = new TextBox();
		textBox_3.setVisibleLength(120);
		grid.setWidget(4, 1, textBox_3);
		
				CheckBox checkBox = new CheckBox("Cliente Ativo");
				checkBox.setStyleName("ativoCheckBox");
				verticalPanel.add(checkBox);
				
				HorizontalPanel flowPanel_2 = new HorizontalPanel();
				flowPanel_2.setSpacing(3);
				flowPanel_2.setStyleName("separadorBotoes");
				verticalPanel.add(flowPanel_2);
				
				Button button = new Button("New button");
				button.setText("salvar");
				flowPanel_2.add(button);
				
				Button button_1 = new Button("New button");
				button_1.setText("excluir");
				flowPanel_2.add(button_1);
				
				Button button_2 = new Button("novo Cliente PF");
				button_2.setText("novo Cliente");
				flowPanel_2.add(button_2);
				
				VerticalPanel verticalPanel_3 = new VerticalPanel();
				tabPanel.add(verticalPanel_3, "Pessoas F\u00EDsicas Vinculadas", false);
				verticalPanel_3.setSize("100%", "100%");
				
				ListBox listBox = new ListBox();
				verticalPanel_3.add(listBox);
				listBox.setSize("100%", "100%");
				listBox.setVisibleItemCount(10);
				
				Button btnNewButton_1 = new Button("New button");
				btnNewButton_1.setStyleName("padding5");
				verticalPanel_3.add(btnNewButton_1);
				btnNewButton_1.setText("desvincular PF selecionada");
				
				HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
				verticalPanel_3.add(horizontalPanel_1);
				
				DecoratorPanel decoratorPanel = new DecoratorPanel();
				decoratorPanel.setStyleName("padding10");
				horizontalPanel_1.add(decoratorPanel);
				
				VerticalPanel verticalPanel_1 = new VerticalPanel();
				verticalPanel_1.setSpacing(5);
				decoratorPanel.setWidget(verticalPanel_1);
				
				Label lblIncluirNovaPessoa = new Label("INCLUIR nova pessoa f\u00EDsica vinculada");
				verticalPanel_1.add(lblIncluirNovaPessoa);
				
				TextBox txtbxDigiteAquiA = new TextBox();
				verticalPanel_1.add(txtbxDigiteAquiA);
				txtbxDigiteAquiA.setMaxLength(11);
				txtbxDigiteAquiA.setText("digite aqui o CPF");
				
				Button btnNewButton = new Button("New button");
				verticalPanel_1.add(btnNewButton);
				btnNewButton.setText("incluir pessoa f\u00EDsica");
				
				tabPanel.selectTab(0);
		
		setStyleName("painelCadastro");
	}

}
