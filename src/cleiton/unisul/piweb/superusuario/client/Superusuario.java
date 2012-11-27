package cleiton.unisul.piweb.superusuario.client;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootPanel;

public class Superusuario implements EntryPoint {
	

	
	@Override
	public void onModuleLoad() {
		RootPanel rootPanel = RootPanel.get();
		rootPanel.setSize("100%", "100%");
		
		TelaInicial telaInicial= new TelaInicial();
		
		FlowPanel verticalPanel = new FlowPanel();
			verticalPanel.setSize("100%", "");
		rootPanel.add(verticalPanel, 0, 10);
		verticalPanel.add(telaInicial);
	}
	

}
