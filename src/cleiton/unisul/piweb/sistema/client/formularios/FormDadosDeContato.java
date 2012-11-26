package cleiton.unisul.piweb.sistema.client.formularios;

import java.util.Collection;

import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.mural.Mural;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.mural.inputparsers.InputParserCollectionToHTMLString;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.rol.impl.RolTextBox;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewTextBox;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewWithTitle;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.DadosDeContato;

import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class FormDadosDeContato extends Formulario<DadosDeContato>  {
	
	
	@Override
	public String getTitulo(){
		return "Sentinela - Dados de contato";
	}
	
	final private InputViewWithTitle<String> endereco=new InputViewWithTitle<String>("Endere\u00E7o", new InputViewTextBox(100,500)); 
	final private Mural<Collection<String>> painelTelefones = new Mural<Collection<String>> ("Telefones", new RolTextBox(20,50), new InputParserCollectionToHTMLString<String>());
	final private Mural<Collection<String>> painelEmails = new Mural<Collection<String>> ("Emails", new RolTextBox(40,500), new InputParserCollectionToHTMLString<String>());
	
	
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
		super.setInput(input);
		
		Boolean result;
		result = painelTelefones.setInput(input.getTelefones());
		result &= painelEmails.setInput(input.getEmails());
		return result;
	}

	@Override
	public DadosDeContato getInput() {
		DadosDeContato input = super.getInput();
		input.setEndereco(endereco.getInput());
		input.setTelefones(painelTelefones.getInput());
		input.setEmails(painelEmails.getInput());
		return input;
	}

	@Override
	protected DadosDeContato criarInputVazio() {
		return new DadosDeContato();
	}

}
