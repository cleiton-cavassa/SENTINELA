package cleiton.unisul.piweb.ferramentasVisuais.client.colecoes;

import java.util.Date;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;

import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.exibidor.InputView;

public class InputViewForDate implements InputView<Date> {
	
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

}