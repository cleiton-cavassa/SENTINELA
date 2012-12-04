package cleiton.unisul.piweb.ferramentasVisuais.client.util;


import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputView;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputViewFactory;

import com.google.gwt.user.client.Command;

public class CriadorTela <T extends Object> implements Command{
		
		private InputViewFactory<T> telaFactory;
		private InputView<T> tela;
		public void execute() {
				TelaPopUp p= new TelaPopUp();
				if(telaFactory!=null){
					p.setTela(telaFactory.getInputView());
				}else{
					if(tela!=null){
						p.setTela(tela);
					}
				}

				p.center();		
				p.setPopupPosition(p.getPopupLeft(), Math.min(40, p.getPopupTop()));
		}
		
//		public CriadorTela(IsFormulario telaFactory){
		public CriadorTela(InputViewFactory<T> telaFactory){
			this.telaFactory = telaFactory;
		}
		public CriadorTela(InputView<T> tela){
			this.tela= tela;
		}
}