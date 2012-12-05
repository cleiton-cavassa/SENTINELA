package cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.mural;

import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputView;
import cleiton.unisul.piweb.ferramentasVisuais.client.util.CriadorTela;
import cleiton.unisul.piweb.ferramentasVisuais.client.util.FecharPopUpEventHandler;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Mural <Input extends Object> extends Composite implements InputView<Input>{
	
	private String titulo;
		public String getTitulo() {return titulo;}
//		private final HTML labelTitulo = new HTML();
		public void setTitulo(String titulo) {
			this.titulo = titulo;
//			labelTitulo.setHTML("<b><center>"+titulo+"</center></b>");
			captionPanel.setCaptionHTML("<b><center>"+titulo+"</center></b>");
			}
		
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

	private final CaptionPanel captionPanel=new CaptionPanel();
	private final VerticalPanel vertical=new VerticalPanel();
	private final Button botaoEditar= new Button("editar");
	
	
	private final HTML lugar=new HTML("<i>Mural vazio. Para preench\u00EA-lo, aperte o bot\u00E3o <b>editar</b></i>"); 

	private final CaixaInput caixaInput;
	
	/**
	 * @wbp.parser.constructor
	 */
	public Mural(String titulo, InputView<Input> inputView, InputParser<Input, String> inputParser){
		super();
		
		this.setTitulo(titulo);
//		labelTitulo.addStyleName("padding5");
		
		this.caixaInput=new CaixaInput(inputView);
		botaoEditar.addClickHandler(new BotaoEditarClickHandler());
		botaoEditar.setStyleName("botaoLogout");
		this.inputParser=inputParser;
		this.initWidget(captionPanel);
			captionPanel.add(vertical);

//				vertical.add(labelTitulo);
				vertical.add(new HorizontalPanel());
				vertical.add(lugar);
 				vertical.add(botaoEditar);
	}
	
	public Mural(String titulo, InputView<Input> inputView, InputParser<Input, String> inputParser,Input input){
		this(titulo, inputView, inputParser);
		this.inputProperty.setInput(input);
		
	}
	
	
	private class BotaoEditarClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			caixaInput.inputView.setInput(inputProperty.getInput());
			new CriadorTela<Input>(caixaInput).execute();
		}
	}
	
	private class CaixaInput extends Composite implements InputView<Input>{//IsFormulario{
		private final VerticalPanel pa=new VerticalPanel();
		private final HorizontalPanel botoes=new HorizontalPanel();
		private final Button ok=new Button("OK");
		private final Button cancelar=new Button("Cancelar");
		private final InputView<Input> inputView;

		
		public void fechar(){
			Mural.this.fechar();
		}
		
		private final ClickHandler hOk=new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				String s = inputView.validarDados();
				
				if (s!=null){
					Window.alert("Erro de preenchimento: \n"+s);
					return;
				}else{
					inputProperty.setInput(inputView.getInput());
					fechar();
				}
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

		@Override
		public String validarDados() {
			return null;
		}

		@Override
		public String getTitulo() {
//			return inputView.getTitulo();
			return titulo;
		}

		@Override
		public boolean setFecharHandler(FecharPopUpEventHandler f) {
			return Mural.this.setFecharHandler(f);
		}

		@Override
		public boolean setInput(Input input) {
			return inputView.setInput(input);
		}

		@Override
		public Input getInput() {
			return inputView.getInput();
		}

	}
	
	@Override
	public String validarDados() {
		return null;
	}
	
	public interface InputParser <Input extends Object, Output extends Object> {
		Output parse(Input input);
	}

	
	private FecharPopUpEventHandler f;
	@Override
	public boolean setFecharHandler(FecharPopUpEventHandler f) {
		this.f=f;
		return true;
	}
	@Override
	public void fechar() {
		f.fecharPopUp();
	}

}
