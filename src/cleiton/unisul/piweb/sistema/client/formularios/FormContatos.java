package cleiton.unisul.piweb.sistema.client.formularios;

import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.RolTextBox;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.TextBox;

public class FormContatos extends Composite {
	public FormContatos() {
		
		Grid grid = new Grid(3, 2);
		initWidget(grid);
		grid.setWidth("196px");
		
		Label lblEndereo = new Label("Endere\u00E7o:");
		grid.setWidget(0, 0, lblEndereo);
		
		TextBox textBox = new TextBox();
		textBox.setMaxLength(500);
		textBox.setVisibleLength(50);
		grid.setWidget(0, 1, textBox);
		
		Label lblTelefones = new Label("Telefones:");
		grid.setWidget(1, 0, lblTelefones);
		
		
		RolTextBox rolTelefones = new RolTextBox(20,50);
		grid.setWidget(1, 1, rolTelefones);
		grid.getCellFormatter().setVerticalAlignment(1, 0, HasVerticalAlignment.ALIGN_TOP);
		
		Label lblEmails = new Label("Emails");
		grid.setWidget(2, 0, lblEmails);
		
		RolTextBox rolEmails = new RolTextBox(20,50);
		grid.setWidget(2, 1, rolEmails);
	}

}
