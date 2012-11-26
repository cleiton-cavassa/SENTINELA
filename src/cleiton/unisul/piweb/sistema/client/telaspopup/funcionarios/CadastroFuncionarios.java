package cleiton.unisul.piweb.sistema.client.telaspopup.funcionarios;

import cleiton.unisul.piweb.sistema.client.formularios.FormMotorista;
import cleiton.unisul.piweb.sistema.client.formularios.Formulario;

public class CadastroFuncionarios extends Formulario {
	
	@Override
	public String getTitulo(){
		return "SENTINELA - Cadastro de Motorista";
	}
	
	public CadastroFuncionarios() {
		
		FormMotorista formMotorista = new FormMotorista();
		initWidget(formMotorista);
		
	}

//	public CadastroFuncionarios() {
//		
//		FlowPanel flowPanel = new FlowPanel();
//		initWidget(flowPanel);
//		flowPanel.setSize("947px", "100%");
//		
//		Label lblSentinelaCadastro = new Label("SENTINELA - Cadastro de funcion\u00E1rios");
//		lblSentinelaCadastro.setStyleName("h1");
//		lblSentinelaCadastro.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
//		flowPanel.add(lblSentinelaCadastro);
//		lblSentinelaCadastro.setSize("100%", "20px");
//		
//		SimplePager simplePager = new SimplePager();
//		flowPanel.add(simplePager);
//		
//		Grid grid = new Grid(10,2);
//		flowPanel.add(grid);
//		
//		Label label_8 = new Label("ID:");
//		label_8.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
//		grid.setWidget(0, 0, label_8);
//		
//		Label label_4 = new Label("Ainda n\u00E3o criado");
//		label_4.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
//		grid.setWidget(0, 1, label_4);
//		
//		Label label = new Label("nome:");
//		label.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
//		grid.setWidget(1, 0, label);
//		
//		Label label_1 = new Label("CPF:");
//		label_1.setWordWrap(false);
//		label_1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
//		grid.setWidget(2, 0, label_1);
//		
//		Label label_2 = new Label("data de nascimento:");
//		label_2.setWordWrap(false);
//		label_2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
//		grid.setWidget( 3, 0, label_2);
//		
//		Label lblCarro = new Label("carro:");
//		lblCarro.setWordWrap(false);
//		lblCarro.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
//		grid.setWidget(4, 0, lblCarro);
//		
//		Label lblIdiomasFalados = new Label("idiomas falados:");
//		lblIdiomasFalados.setWordWrap(false);
//		lblIdiomasFalados.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
//		grid.setWidget(5, 0, lblIdiomasFalados);
//		
//		Label label_5 = new Label("Endere\u00E7o:");
//		label_5.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
//		grid.setWidget(6, 0, label_5);
//		
//		Label label_6 = new Label("Telefones:");
//		label_6.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
//		grid.setWidget(7, 0, label_6);
//		
//		Label lbloTurno = new Label("1o turno:");
//		lbloTurno.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
//		grid.setWidget(8, 0, lbloTurno);
//		
//		Label lbloTurno_1 = new Label("2o turno:");
//		lbloTurno_1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
//		grid.setWidget(9, 0, lbloTurno_1);
//		
//		TextBox textBox = new TextBox();
//		textBox.setVisibleLength(120);
//		grid.setWidget(1, 1, textBox);
//		
//		TextBox textBox_1 = new TextBox();
//		textBox_1.setVisibleLength(14);
//		textBox_1.setMaxLength(11);
//		grid.setWidget(2 ,1 ,textBox_1);
//		
//		DateBox txtbxDdmmaaaa = new DateBox();
//		txtbxDdmmaaaa.setFormat(new DefaultFormat(DateTimeFormat.getFormat("dd/MMM/yyyy")));
//		grid.setWidget( 3, 1, txtbxDdmmaaaa);
//		txtbxDdmmaaaa.setWidth("126px");
//		
//		TextBox textBox_carro = new TextBox();
//		textBox_carro.setVisibleLength(120);
//		grid.setWidget(4, 1, textBox_carro);
//		
//		TextBox textBox_2 = new TextBox();
//		textBox_2.setVisibleLength(120);
//		grid.setWidget(5, 1, textBox_2);
//		
//		TextBox textBox_3 = new TextBox();
//		textBox_3.setVisibleLength(120);
//		grid.setWidget(6, 1, textBox_3);
//		
//		TextBox textBox_4 = new TextBox();
//		textBox_4.setVisibleLength(120);
//		grid.setWidget(7, 1, textBox_4);
//		
//		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
//		grid.setWidget(8, 1, horizontalPanel_1);
//		
//		Label lblDe = new Label("das");
//		horizontalPanel_1.add(lblDe);
//		
//		TextBox txtbxHhmm = new TextBox();
//		txtbxHhmm.setText("hh:mm");
//		horizontalPanel_1.add(txtbxHhmm);
//		txtbxHhmm.setWidth("46px");
//		
//		
//		Label lbls = new Label("\u00E0s");
//		horizontalPanel_1.add(lbls);
//		
//		TextBox textBox_6 = new TextBox();
//		textBox_6.setText("hh:mm");
//		horizontalPanel_1.add(textBox_6);
//		textBox_6.setWidth("46px");
//		
//		HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
//		grid.setWidget(9, 1, horizontalPanel_2);
//		
//		Label label_3 = new Label("das");
//		horizontalPanel_2.add(label_3);
//		
//		TextBox textBox_7 = new TextBox();
//		textBox_7.setText("hh:mm");
//		horizontalPanel_2.add(textBox_7);
//		textBox_7.setWidth("46px");
//		
//		Label label_7 = new Label("\u00E0s");
//		horizontalPanel_2.add(label_7);
//		
//		TextBox textBox_8 = new TextBox();
//		textBox_8.setText("hh:mm");
//		horizontalPanel_2.add(textBox_8);
//		textBox_8.setWidth("46px");
//		
//		CheckBox chckbxCarregaAnimais = new CheckBox("aceita transportar animais");
//		flowPanel.add(chckbxCarregaAnimais);
//		setStyleName("painelCadastro");
//	}

}
