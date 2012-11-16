package cleiton.unisul.piweb.sistema.client.util;

import com.google.gwt.event.dom.client.ClickEvent;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;

public class TelaPopUp extends PopupPanel {
	Widget tela;
	private VerticalPanel verticalPanel;
	public Widget getTela() {
		return tela;
	}
	public void setTela(Widget tela) {
		this.tela = tela;

		verticalPanel.add(tela);
	}
	public TelaPopUp() {
		super(true);
		final TelaPopUp eu=this;
		
		setAutoHideOnHistoryEventsEnabled(false);
		setAutoHideEnabled(false);
		setGlassEnabled(true);
		setSize("100%", "100%");
		setModal(true);
		
		verticalPanel= new VerticalPanel();
 
		setWidget(verticalPanel);
		verticalPanel.setSize("100%", "100%");
		

		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		verticalPanel.add(horizontalPanel);
		verticalPanel.setCellHorizontalAlignment(horizontalPanel, HasHorizontalAlignment.ALIGN_RIGHT);
		
		
			Button btnX = new Button("X");
			btnX.setText("x");
			horizontalPanel.add(btnX);
			btnX.setSize("20", "20");
			btnX.addClickHandler(new ClickHandler(){
				@Override
				public void onClick(ClickEvent event) {
					eu.hide();
				}
			});
	}

	
	
	
	/*public TelaPopUp(Widget tela) {
		super(true);
		setAutoHideOnHistoryEventsEnabled(false);
		setAutoHideEnabled(false);
		setGlassEnabled(true);
		setSize("533px", "413px");
		setModal(true);
		
		VerticalPanel verticalPanel = new VerticalPanel();
		setWidget(verticalPanel);
		verticalPanel.setSize("100%", "100%");
		
		verticalPanel.add(tela);
		
		Button button = new Button("New button");
		button.setText("excluir");
		button.setStyleName("gwt-ButtonExcluir");
		verticalPanel.add(button);
	}*/
	
}
