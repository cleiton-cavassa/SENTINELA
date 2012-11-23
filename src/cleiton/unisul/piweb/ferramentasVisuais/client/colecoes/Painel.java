package cleiton.unisul.piweb.ferramentasVisuais.client.colecoes;

import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.exibidor.InputParser;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.exibidor.InputView;
import cleiton.unisul.piweb.ferramentasVisuais.client.util.CriadorTela;
import cleiton.unisul.piweb.ferramentasVisuais.client.util.FecharPopUpEvent;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.HasDirection;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.DockLayoutPanel.Direction;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Painel <Input extends Object> extends Composite implements InputView<Input>{
	
	private String titulo;
		public String getTitulo() {return titulo;}
		private final HTML labelTitulo = new HTML();
		public void setTitulo(String titulo) {this.titulo = titulo;labelTitulo.setHTML("<b><center>"+titulo+"</center></b>");}
		
	@Override
	public boolean setInput(Input input) {
		inputProperty.setInput(input);
		return true;
	}

	@Override
	public Input getInput() {
		return inputProperty.getInput();
	}

	private final InputProperty inputProperty=new InputProperty();
	private final InputParser<Input, String> inputParser;
	private class InputProperty {
		private Input input;

		public Input getInput() {
			return input;
		}

		public void setInput(Input input) {
			this.input = input;
			lugar.setHTML(inputParser.parse(input));
		} 
	}

	private final DecoratorPanel decorador=new DecoratorPanel();
	private final VerticalPanel vertical=new VerticalPanel();
	private final Button botaoEditar= new Button("editar");
	
	
	private final HTML lugar=new HTML("<i>Painel vazio. Para preench\u00EA-lo, aperte o bot\u00E3o <b>editar</b></i>"); 

	private final CaixaInput caixaInput;
	
	/**
	 * @wbp.parser.constructor
	 */
	public Painel(String titulo, InputView<Input> inputView, InputParser<Input, String> inputParser){
		super();
		
		this.setTitulo(titulo);
		labelTitulo.addStyleName("padding5");
		
		this.caixaInput=new CaixaInput(inputView);
		botaoEditar.addClickHandler(new BotaoEditarClickHandler());
		botaoEditar.setStyleName("botaoLogout");
		this.inputParser=inputParser;
		this.initWidget(decorador);
			decorador.add(vertical);
				vertical.add(labelTitulo);
				vertical.add(new HorizontalPanel());
				vertical.add(lugar);
 				vertical.add(botaoEditar);
	}
	
	public Painel(String titulo, InputView<Input> inputView, InputParser<Input, String> inputParser,Input input){
		this(titulo, inputView, inputParser);
		this.inputProperty.setInput(input);
		
	}
	
	
	private class BotaoEditarClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			caixaInput.inputView.setInput(inputProperty.getInput());
			new CriadorTela(caixaInput).execute();
		}
	}
	
	private class CaixaInput extends Composite{
		private final VerticalPanel pa=new VerticalPanel();
		private final HorizontalPanel botoes=new HorizontalPanel();
		private final Button ok=new Button("OK");
		private final Button cancelar=new Button("Cancelar");
		private final InputView<Input> inputView;
		private final CaixaInput eu = this;

		
		private void fechar(){
			try {
				eu.fireEvent(new FecharPopUpEvent());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		private final ClickHandler hOk=new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				inputProperty.setInput(inputView.getInput());
				fechar();
			}
		};
		
		private final ClickHandler hCancel=new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				fechar();
			}
		};
		
		CaixaInput(InputView<Input> inputView){
			this.inputView=inputView;
			this.initWidget(pa);
			pa.add(inputView);
			pa.add(botoes);
			botoes.add(ok);
				ok.addClickHandler(hOk);
			botoes.add(cancelar);
				cancelar.addClickHandler(hCancel);
		}	
	}
}
