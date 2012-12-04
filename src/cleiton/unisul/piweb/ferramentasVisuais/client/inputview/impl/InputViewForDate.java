package cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl;

import java.util.Date;

import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputView;
import cleiton.unisul.piweb.ferramentasVisuais.client.util.FecharPopUpEventHandler;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;


public class InputViewForDate implements InputView<Date> {
	
	
	@Override
	public String getTitulo(){
		return "Campo para digitar data";
	}
	
	public boolean isHabilitado(){
		return dateBox.isEnabled();
	}
	
	public void setHabilitado(boolean habilitado){
		dateBox.setEnabled(habilitado);
	}
	
	private final VerticalPanel vp=new VerticalPanel();
	private final DateBox dateBox= new DateBox();
	private final HTML labelTitulo=new HTML();
	
	public InputViewForDate(String titulo){
		vp.add(labelTitulo);
			labelTitulo.setHTML("<b>"+titulo+"</b>");
		vp.add(dateBox);
	}
	
	@Override
	public Widget asWidget() {
		return vp;
	}

	@Override
	public boolean setInput(Date input) {
		dateBox.setValue(input);
		return true;
	}

	@Override
	public Date getInput() {
		return dateBox.getValue();
	}

	@Override
	public String validarDados() {
		return null;
	}

	@Override
	public boolean setFecharHandler(FecharPopUpEventHandler f) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void fechar() {
		// TODO Auto-generated method stub
		
	}
	
	

}