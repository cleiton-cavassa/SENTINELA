package cleiton.unisul.piweb.client.formularios;

	import com.google.gwt.event.logical.shared.BeforeSelectionEvent;

import com.google.gwt.event.logical.shared.BeforeSelectionHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Composite;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DateBox.DefaultFormat;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Grid;
import cleiton.unisul.piweb.client.validacao.CompositeCPF;
import com.google.gwt.user.client.ui.ListBox;

	public class FormClientePF extends Composite {

		/**
		 * @wbp.parser.constructor
		 */
		public FormClientePF() {
			
			TabPanel tabPanel = new TabPanel();
			tabPanel.setStyleName("painelCadastro");
			initWidget(tabPanel);
			
			VerticalPanel caractPessoaisPanel = new VerticalPanel();
			tabPanel.add(caractPessoaisPanel, "Caracter\u00EDsticas Pessoais", false);
			caractPessoaisPanel.setSize("5cm", "3cm");
			
			Grid grid = new Grid(8, 2);
			caractPessoaisPanel.add(grid);
			
			Label lblId = new Label("ID:");
			lblId.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
			grid.setWidget(0, 0, lblId);
			
			Label lblAindaNoCriado = new Label("Ainda n\u00E3o criado");
			lblAindaNoCriado.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
			grid.setWidget(0, 1, lblAindaNoCriado);
			
			Label label = new Label("nome:");
			label.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
			grid.setWidget(1, 0, label);
			
			TextBox textBox_5 = new TextBox();
			textBox_5.setVisibleLength(120);
			grid.setWidget(1, 1, textBox_5 );
			
			Label label_1 = new Label("CPF:");
			
						
						label_1.setWordWrap(false);
						label_1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
						grid.setWidget(2, 0, label_1);
						
						CompositeCPF compositeCPF = new CompositeCPF();
						grid.setWidget(2, 1, compositeCPF);
						
						Label lblNewLabel_1 = new Label("data de nascimento:");
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
						
						DateBox dateBox = new DateBox();
						dateBox.setFormat(new DefaultFormat(DateTimeFormat.getFormat("dd/MMM/yyyy")));
						grid.setWidget(3, 1, dateBox);
						dateBox.setSize("131", "25");
						
						
						FlowPanel flowPanel = new FlowPanel();
						grid.setWidget(4, 1, flowPanel);
						
						ListBox comboBox = new ListBox();
						comboBox.addItem("brasileiro");
						comboBox.addItem("estrangeiro");
						flowPanel.add(comboBox);
						
						TextBox textBox_1 = new TextBox();
						textBox_1.setVisibleLength(120);
						grid.setWidget(5, 1, textBox_1);
						
						TextBox textBox_2_1 = new TextBox();
						textBox_2_1.setVisibleLength(120);
						grid.setWidget(6, 1, textBox_2_1);
						
						TextBox textBox_4 = new TextBox();
						textBox_4.setVisibleLength(120);
						grid.setWidget(7, 1, textBox_4);
						
						CheckBox chckbxNewCheckBox = new CheckBox("Cliente Ativo");
						chckbxNewCheckBox.setStyleName("ativoCheckBox");
						caractPessoaisPanel.add(chckbxNewCheckBox);
						
						HorizontalPanel flowPanel_1 = new HorizontalPanel();
						flowPanel_1.setSpacing(3);
						caractPessoaisPanel.add(flowPanel_1);
						flowPanel_1.setWidth("211");
						
						Button btnNewButton = new Button("New button");
						flowPanel_1.add(btnNewButton);
						btnNewButton.setText("salvar");
						
						Button button = new Button("New button");
						button.setText("excluir");
						flowPanel_1.add(button);
			
			
			VerticalPanel horizontalPanel = new VerticalPanel();
			tabPanel.add(horizontalPanel, "Prefer\u00EAncias", false);
			horizontalPanel.setSize("905", "269");
			
			CheckBox pshbtnNewButton = new CheckBox("New button");
			pshbtnNewButton.setHTML("animal de estima\u00E7\u00E3o");
			horizontalPanel.add(pshbtnNewButton);
			pshbtnNewButton.setSize("129px", "20");
			
			CheckBox pushButton = new CheckBox("New button");
			pushButton.setHTML("permite motorista fumante");
			horizontalPanel.add(pushButton);
			pushButton.setSize("129px", "20");
			setStyleName("painelCadastro");
			
			tabPanel.selectTab(0);
			
			tabPanel.addBeforeSelectionHandler(new BeforeSelectionHandler<Integer>() {
				@Override
				public void onBeforeSelection(BeforeSelectionEvent<Integer> event) {
					//((PopupPanel)(FormClientePF.this.getParent().getParent().getParent())).center();
					
				}
			});
		}

}
