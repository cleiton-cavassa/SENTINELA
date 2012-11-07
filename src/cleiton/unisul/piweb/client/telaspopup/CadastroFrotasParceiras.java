package cleiton.unisul.piweb.client.telaspopup;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.client.ui.SimplePanel;

public class CadastroFrotasParceiras extends Composite {

	public CadastroFrotasParceiras() {
		
		FlowPanel flowPanel = new FlowPanel();
		initWidget(flowPanel);
		flowPanel.setWidth("920px");
		
		Label lblSentinelaDados = new Label("SENTINELA - dados de frotas parceiras");
		lblSentinelaDados.setStyleName("h1");
		lblSentinelaDados.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		flowPanel.add(lblSentinelaDados);
		lblSentinelaDados.setSize("100%", "20px");
		
		SimplePager simplePager = new SimplePager();
		flowPanel.add(simplePager);
		
		Grid grid=new Grid(7, 2);
		flowPanel.add(grid);
		
		Label label = new Label("ID:");
		label.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		grid.setWidget(0, 0, label);
		
		Label label_7 = new Label("Ainda n\u00E3o criado");
		label_7.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		grid.setWidget(0, 1, label_7);
		
		Label label_1 = new Label("Raz\u00E3o Social:");
		label_1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		grid.setWidget(1, 0, label_1);
		
		Label label_2 = new Label("CNPJ:");
		label_2.setWordWrap(false);
		label_2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		grid.setWidget(2, 0, label_2);
		
		Label label_3 = new Label("Regi\u00F5es de Atua\u00E7\u00E3o:");
		label_3.setWordWrap(false);
		label_3.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		grid.setWidget(3, 0, label_3);
		
		Label label_4 = new Label("Endere\u00E7o:");
		label_4.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		grid.setWidget(4, 0, label_4);
		
		Label label_5 = new Label("Telefones:");
		label_5.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		grid.setWidget(5, 0, label_5);
		
		Label label_6 = new Label("email");
		label_6.setWordWrap(false);
		label_6.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		grid.setWidget(6, 0, label_6);
		
		TextBox textBox = new TextBox();
		textBox.setVisibleLength(120);
		grid.setWidget(1, 1, textBox);
		
		TextBox textBox_1 = new TextBox();
		textBox_1.setVisibleLength(18);
		textBox_1.setMaxLength(14);
		grid.setWidget(2, 1, textBox_1);
		
		TextBox textBox_2 = new TextBox();
		textBox_2.setVisibleLength(120);
		grid.setWidget(3, 1, textBox_2);
		
		TextBox textBox_3 = new TextBox();
		textBox_3.setVisibleLength(120);
		grid.setWidget(4, 1, textBox_3);
		
		TextBox textBox_4 = new TextBox();
		textBox_4.setVisibleLength(120);
		grid.setWidget(5, 1, textBox_4);
		
		TextBox textBox_5 = new TextBox();
		textBox_5.setVisibleLength(120);
		grid.setWidget(6, 1, textBox_5);
		setStyleName("painelCadastro");
	}

}
