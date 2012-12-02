package cleiton.unisul.piweb.superusuario.client;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
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
		
		DockPanel dockPanel = new DockPanel();
		verticalPanel.add(dockPanel);
		dockPanel.setWidth("100%");
		
		FlowPanel flowPanel = new FlowPanel();
		dockPanel.add(flowPanel, DockPanel.WEST);
		flowPanel.setSize("100%", "100%");
		
		Label lblSadsdasdas = new Label();
		lblSadsdasdas.setStyleName("boasvindas");
		flowPanel.add(lblSadsdasdas);
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		dockPanel.add(horizontalPanel, DockPanel.EAST);
		
		Label label = new Label();
		horizontalPanel.add(label);
		
//		Button button = new BotaoLogout("Logout");
//		dockPanel.add(button, DockPanel.EAST);
//		dockPanel.setCellHorizontalAlignment(button, HasHorizontalAlignment.ALIGN_RIGHT);
//		horizontalPanel.setCellVerticalAlignment(button, HasVerticalAlignment.ALIGN_MIDDLE);
//		horizontalPanel.setCellHorizontalAlignment(button, HasHorizontalAlignment.ALIGN_RIGHT);
		verticalPanel.add(telaInicial);
	}
}
