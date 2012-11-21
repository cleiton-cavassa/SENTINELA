package cleiton.unisul.piweb.sistema.client.formularios;

import java.util.Collection;

import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.InputViewWithTitle;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.Painel;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.RolTextBox;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.exibidor.InputCollectionToHTMLStringParser;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.exibidor.InputView;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputviews.InputViewTextBox;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.DadosDeContato;

import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class FormDadosDeContato extends Formulario implements InputView<DadosDeContato>  {
	
	final private InputViewWithTitle<String> endereco=new InputViewWithTitle<String>("Endere\u00E7o", new InputViewTextBox(100,500)); 
	final private Painel<Collection<String>> painelTelefones = new Painel<Collection<String>> ("Telefones", new RolTextBox(20,50), new InputCollectionToHTMLStringParser<String>());
	final private Painel<Collection<String>> painelEmails = new Painel<Collection<String>> ("Emails", new RolTextBox(40,500), new InputCollectionToHTMLStringParser<String>());
	
	
	public FormDadosDeContato() {	
		FlowPanel flowPanel = new FlowPanel();
		initWidget(flowPanel);
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setStyleName("padding10");
		horizontalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		flowPanel.add(horizontalPanel);
		
		horizontalPanel.add(endereco);
		
		DockPanel dockPanel = new DockPanel();
		flowPanel.add(dockPanel);
		
		VerticalPanel verticalPanel_Emails = new VerticalPanel();
		verticalPanel_Emails.setStyleName("padding10");
		dockPanel.add(verticalPanel_Emails, DockPanel.EAST);

		verticalPanel_Emails.add(painelEmails);
		
		VerticalPanel verticalPanel_Telefones = new VerticalPanel();
		verticalPanel_Telefones.setStyleName("padding10");
		dockPanel.add(verticalPanel_Telefones, DockPanel.WEST);
		
		verticalPanel_Telefones.add(painelTelefones);
		

		
	}

	@Override
	public boolean setInput(DadosDeContato input) {
		Boolean result;
		result = painelTelefones.setInput(input.getTelefones());
		result &= painelEmails.setInput(input.getEmails());
		return result;
	}

	@Override
	public DadosDeContato getInput() {
		DadosDeContato input = new DadosDeContato();
		input.setEndereco(endereco.getInput());
		input.setTelefones(painelTelefones.getInput());
		input.setEmails(painelEmails.getInput());
		return input;
	}

}
