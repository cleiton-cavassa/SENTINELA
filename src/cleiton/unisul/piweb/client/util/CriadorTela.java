package cleiton.unisul.piweb.client.util;


import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Widget;

public class CriadorTela implements Command{
		
		public Widget tela;
		public void execute() {
				TelaPopUp p= new TelaPopUp();
				p.setTela(tela);
				p.center();		
				p.setPopupPosition(p.getPopupLeft(), Math.min(40, p.getPopupTop()));
		}
		
		public CriadorTela(Widget tela){
			this.tela = tela;
		}
}