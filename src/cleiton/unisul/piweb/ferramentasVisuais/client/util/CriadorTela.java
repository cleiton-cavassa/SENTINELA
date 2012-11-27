package cleiton.unisul.piweb.ferramentasVisuais.client.util;


import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.IsFormulario;

import com.google.gwt.user.client.Command;

public class CriadorTela implements Command{
		
		public IsFormulario tela;
		public void execute() {
				TelaPopUp p= new TelaPopUp();
				p.setTela(tela);
				p.center();		
				p.setPopupPosition(p.getPopupLeft(), Math.min(40, p.getPopupTop()));
		}
		
		public CriadorTela(IsFormulario tela){
			this.tela = tela;
		}
}