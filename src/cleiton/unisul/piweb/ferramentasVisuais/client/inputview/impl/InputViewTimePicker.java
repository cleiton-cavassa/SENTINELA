package cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl;

import java.util.Date;

import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputView;
import cleiton.unisul.piweb.ferramentasVisuais.client.util.FecharPopUpEventHandler;

import com.google.gwt.user.client.ui.Widget;
import com.summatech.gwt.client.HourMinutePicker;
import com.summatech.gwt.client.HourMinutePicker.PickerFormat;

public class InputViewTimePicker implements InputView<Date>{
	private final HourMinutePicker view=new HourMinutePicker(PickerFormat._24_HOUR);
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean setInput(Date input) {
		if (input == null){
			return false;
		}
		
		try {
			view.setTime("", input.getHours(),+input.getMinutes());
		} catch (Throwable e) {
			return false;
		}
		return true;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public Date getInput() {
		Date result=
			(view.getMinutes()==null
				?null
				:new Date(0,0,0,view.getHour(),view.getMinute(),0)
			);
			
		return result;
	}

	@Override
	public String validarDados() {
		return null;
	}

	@Override
	public String getTitulo() {
		return null;
	}

	@Override
	public Widget asWidget() {
		return view;
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
