package cleiton.unisul.piweb.ferramentasVisuais.client.util;

import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.IsFormulario;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class TelaPopUp extends PopupPanel implements FecharPopUpEventHandler{
	IsFormulario tela;
	final private Label labelTitulo = new Label();
	
	private VerticalPanel verticalPanel;
	public IsFormulario getTela() {
		return tela;
	}
	public void setTela(IsFormulario tela) {
		this.tela = tela;
		tela.asWidget().addHandler(this, FecharPopUpEventType.get());
		String s = tela.getTitulo();
		if(s!=null){
			labelTitulo.setText(s);
		}
		
		verticalPanel.add(tela);
	}
	
	public TelaPopUp(String titulo){
		this();
		labelTitulo.setText(titulo);
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
		horizontalPanel.setSize("100%", "");
		horizontalPanel .setStyleName("h1");
		verticalPanel.add(horizontalPanel);
//		verticalPanel.setCellHorizontalAlignment(horizontalPanel, HasHorizontalAlignment.ALIGN_RIGHT);
	
		labelTitulo.setStyleName("padding5");
		labelTitulo.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
//		labelTitulo.setStyleName("h1");
		labelTitulo.setSize("100%", "");
		
		horizontalPanel.add(labelTitulo);
		horizontalPanel.setCellHorizontalAlignment(labelTitulo, HasHorizontalAlignment.ALIGN_CENTER);
		
			Button btnX = new Button("X");
			btnX.setText("x");
			horizontalPanel.add(btnX);
			horizontalPanel.setCellHorizontalAlignment(btnX, HasHorizontalAlignment.ALIGN_RIGHT);
			btnX.setSize("20", "20");
			btnX.addClickHandler(new ClickHandler(){
				@Override
				public void onClick(ClickEvent event) {
					eu.fecharPopUp();
				}
			});
	}
	@Override
	public void fecharPopUp() {
		hide();	
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
