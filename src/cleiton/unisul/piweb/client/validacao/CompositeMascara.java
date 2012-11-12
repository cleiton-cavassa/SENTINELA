package cleiton.unisul.piweb.client.validacao;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.HasVerticalAlignment;

abstract public class CompositeMascara extends Composite {
	protected long valor;
	protected abstract String mascaraPadrao();
	abstract protected String mascara(long valor); 
	public long getValor() {
		try{
			valor=Long.parseLong(digitador.getText());
		}catch(Throwable tr){
			valor=-1;
		}
		return valor;
	}
	public void setValor(long valor) {
		this.valor=valor;
		eu.digitador.setText(String.valueOf(valor));
		eu.exibidor.setText(mascara(valor));
	}
	protected TextBox digitador;
	protected Label exibidor;
	private final CompositeMascara eu;
	public CompositeMascara() {
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

	
	private class Manipulador implements KeyPressHandler, KeyUpHandler{
		private String valorAntes;
		@Override
		public void onKeyPress(KeyPressEvent event) {
			valorAntes=eu.digitador.getText();
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
			String txto=eu.digitador.getText();
			if(!(txto.equals(""))){
				try{
					Long.parseLong(txto);
				}catch(Throwable tr){
					eu.digitador.setText(valorAntes);
				}
			}
			atualizaExibidor();
		}

		private void atualizaExibidor(){
			long valor;
			try{
				valor = Long.parseLong(eu.digitador.getText());
			}catch(Throwable t){
				valor =-1;
			}
			if (valor>0){
				eu.exibidor.setText(eu.mascara(valor));
			}else{
				eu.exibidor.setText("Digite somente texto composto pelos algarismos de 0 a 9.");
			}
		}

		
	}	
}
