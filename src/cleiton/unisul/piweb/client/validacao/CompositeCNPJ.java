package cleiton.unisul.piweb.client.validacao;


import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.HasVerticalAlignment;

public class CompositeCNPJ extends Composite {
	private long CNPJ;
	public long getCNPJ() {
		return CNPJ;
	}
	private IntegerBox digitador;
	private Label exibidor;
	private final CompositeCNPJ eu;
	public CompositeCNPJ() {
		eu = this;
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(2);
		horizontalPanel.setStyleName("CNPJsemBordas");
		horizontalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		initWidget(horizontalPanel);
		
		digitador = new IntegerBox();
		horizontalPanel.add(digitador);
		digitador.setMaxLength(14);
		digitador.setVisibleLength(16);
		
		digitador.addKeyPressHandler(new Manipulador());
		
		exibidor = new Label("00.000.000/0000-00");
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
				texto+=((texto.length()<14)?c:"");
				try{
					CNPJ=Long.parseLong(texto);
				}catch(Throwable tr){
					CNPJ=0;
				}
				StringBuilder b=new StringBuilder(texto);
				
				while(b.length()<14){
					b.insert(0, "0");
				}
				b.insert(2, ".");
				b.insert(6, ".");
				b.insert(10, "/");
				b.insert(15, "-");
				
				eu.exibidor.setText(b.toString());
			}else{
				if (Character.digit(c,36)!=-1){
					event.getNativeEvent().preventDefault();
				}
			}
			
		}
	}
		
}

