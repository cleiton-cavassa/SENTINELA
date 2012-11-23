package cleiton.unisul.piweb.ferramentasVisuais.client.inputviews;

import java.util.Date;

import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.InputViewWithTitle;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.exibidor.InputView;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.Turno;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.summatech.gwt.client.HourMinutePicker;
import com.summatech.gwt.client.HourMinutePicker.PickerFormat;

public class InputViewTurno implements InputView<Turno>{
	
//	private final Calendar cal=Calendar.getInstance();
	private InputTurnoInterna it = new InputTurnoInterna();
	private final HorizontalPanel h=new HorizontalPanel();
	private final InputViewWithTitle<Turno> in=new InputViewWithTitle<Turno>("Turno",it); 
	private DecoratorPanel d = new DecoratorPanel();
	public InputViewTurno(){
		d.setWidget(in);
		d.addStyleName("padding10");
		in.asWidget().addStyleName("padding10");
	}

	@Override
	public boolean setInput(Turno input) {
		return it.setInput(input);
	}

	@Override
	public Turno getInput() {
		return it.getInput();
	}

	@Override
	public Widget asWidget() {
		return d;
	}
	
	private static class InputTurnoInterna extends Composite implements InputView<Turno>{
		private final HourMinutePicker inicio=new HourMinutePicker(PickerFormat._24_HOUR);
		private final HourMinutePicker fim= new HourMinutePicker (PickerFormat._24_HOUR);
		private final HorizontalPanel h=new HorizontalPanel(); 
		
		public InputTurnoInterna(){
			initWidget(h);
			h.add(new Label("inicia "));
			h.add(inicio);
			h.add(new Label("   termina "));
			h.add(fim);
		}

		@Override
		public boolean setInput(Turno input) {
			if (input == null){
				return false;
			}
//			cal.setTime(input.getInicio());
//			inicio.setTime("", cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE));
//			cal.setTime(input.getFim());
//			fim.setTime("", cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE));
			
			try {
				inicio.setTime("", input.getInicio().getHours(),+input.getInicio().getMinutes());
				fim.setTime("", input.getFim().getHours(),+input.getFim().getMinutes());
			} catch (Throwable e) {
				return false;
			}
			
			return true;
		}

		@Override
		public Turno getInput() {
			Turno result=new Turno();
				
				result.setInicio(new Date(inicio.getMinutes()*60*1000));
				result.setFim(new Date(fim.getMinutes()*60*1000));
				
			return result;
		}

	}
}