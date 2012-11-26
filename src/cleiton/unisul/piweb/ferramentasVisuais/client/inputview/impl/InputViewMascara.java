package cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl;


import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputView;

import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

abstract public class InputViewMascara extends Composite implements InputView<Long> {
	protected Long valor;
	protected abstract String mascaraPadrao();
	abstract protected String mascara(Long valor);
	
	@Override
	public Long getInput(){
		return getValor();
	}
	
	@Override
	public boolean setInput(Long input){
		setValor(input);
		return true;
	}
	
	public Long getValor() {
		try{
			valor=Long.parseLong(digitador.getText());
		}catch(Throwable tr){
			valor= 0l;
		}
		return valor;
	}
	public void setValor(Long valor) {
		this.valor=((valor==null)?0l:valor);
		eu.digitador.setText(String.valueOf(this.valor));
		eu.exibidor.setText(mascara(this.valor));
	}
	protected TextBox digitador;
	protected Label exibidor;
	private final InputViewMascara eu;
	public InputViewMascara() {
		eu = this;
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(2);
		horizontalPanel.setStyleName("CNPJsemBordas");
		horizontalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		initWidget(horizontalPanel);
		
		digitador = new TextBox();
		horizontalPanel.add(digitador);
		digitador.setMaxLength(14);
		digitador.setVisibleLength(16);
		
		
		//digitador.addValueChangeHandler(new Manipulador());
		Manipulador m=new Manipulador();
		digitador.addKeyPressHandler(m);
		digitador.addKeyUpHandler(m);
		
		
		exibidor = new Label(mascaraPadrao());
		horizontalPanel.add(exibidor);
		//exibidor.setVisible(false);	
	}
	
	@Override
	public String validarDados() {
		if (verificaStringELong(digitador.getText())){
			return null;
		}else{
			return nomeCampo()+": permitidos somente algarismos nesse campo.";
		}

	}
	
	public abstract String nomeCampo();

	private Boolean verificaStringELong(String txto){
		if(!(txto.equals(""))){
			try{
				Long.parseLong(txto);
				return true;
			}catch(Throwable tr){
				return false;
			}
		}
		return true;
	}
	private class Manipulador implements KeyPressHandler, KeyUpHandler{
		private String valorAntes="";
		@Override
		public void onKeyPress(KeyPressEvent event) {
			if (verificaStringELong(eu.digitador.getText())){
				valorAntes=eu.digitador.getText();
			}

		}
//		@Override
//		public void onKeyPress(KeyPressEvent event) {
//				if(eu.exibidor==null){
//					return;
//				}
//				Character d=event.getCharCode();
//				int c = (int)d;
//					boolean teste;
//					teste=(Character.digit(d,10)!=-1)||
//							(c==KeyCodes.KEY_RIGHT)||(c==KeyCodes.KEY_SHIFT)||
//							(c==KeyCodes.KEY_TAB)||(c==KeyCodes.KEY_UP)||
//							(c==KeyCodes.KEY_BACKSPACE)||(c==KeyCodes.KEY_DOWN)||
//							(c==KeyCodes.KEY_END)||(c==KeyCodes.KEY_DELETE)||
//							(c==KeyCodes.KEY_ENTER)||(c==KeyCodes.KEY_ESCAPE)||
//							(c==KeyCodes.KEY_ALT)||(c==KeyCodes.KEY_CTRL)||
//							(c==KeyCodes.KEY_HOME)||(c==KeyCodes.KEY_LEFT)||
//							(c==KeyCodes.KEY_PAGEDOWN)||(c==KeyCodes.KEY_PAGEUP);
//					teste=!(teste);
//					if(teste){
//						event.getNativeEvent().preventDefault();
//					}
//					//if (Character.digit(c,36)!=-1){}
//
//		}
		
		@Override
		public void onKeyUp(KeyUpEvent event) {
			if (!verificaStringELong(eu.digitador.getText())){
				eu.digitador.setText(valorAntes);
			}
			atualizaExibidor();
		}

		private void atualizaExibidor(){
			Long valor;
			try{
				valor = Long.parseLong(eu.digitador.getText());
			}catch(Throwable t){
				valor =0l;
			}
			if (valor>0){
				eu.exibidor.setText(eu.mascara(valor));
			}else{
				eu.exibidor.setText("Digite somente texto composto pelos algarismos de 0 a 9.");
			}
		}

		
	}	
}

