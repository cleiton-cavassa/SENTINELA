package cleiton.unisul.piweb.client.validacao;

import com.google.gwt.user.client.ui.Composite;

import com.google.gwt.user.client.ui.Label;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.HasVerticalAlignment;

public class CompositeCPF extends Composite {

		private long CPF;
		public long getCPF() {
			return CPF;
		}
		private IntegerBox digitador;
		private Label exibidor;
		private final CompositeCPF eu;
		public CompositeCPF() {
			eu = this;
			HorizontalPanel horizontalPanel = new HorizontalPanel();
			horizontalPanel.setSpacing(2);
			horizontalPanel.setStyleName("CNPJsemBordas");
			horizontalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
			initWidget(horizontalPanel);
			
			digitador = new IntegerBox();
			horizontalPanel.add(digitador);
			digitador.setMaxLength(11);
			digitador.setVisibleLength(13);
			
			digitador.addKeyPressHandler(new Manipulador());
			
			exibidor = new Label("000.000.000-00");
			horizontalPanel.add(exibidor);
		}
		
		private class Manipulador implements KeyPressHandler{
			@Override
			public void onKeyPress(KeyPressEvent event) {
				if(eu.exibidor==null){
					return;
				}

				Character c = event.getCharCode();
				if (Character.digit(c,10)!=-1){
					String texto = eu.digitador.getText();
					texto+=((texto.length()<11)?c:"");
				try{
					CPF=Long.parseLong(texto);
				}catch(Throwable tr){
					CPF=0;
				}
				StringBuilder b=new StringBuilder(texto);
					
				while(b.length()<11){
					b.insert(0, "0");
				}
				b.insert(3, ".");
				b.insert(7, ".");
				b.insert(11, "-");
					
				eu.exibidor.setText(b.toString());
			}else{
				if (Character.digit(c,36)!=-1){
					event.getNativeEvent().preventDefault();
				}
			}
				
		}
	}
			
}

