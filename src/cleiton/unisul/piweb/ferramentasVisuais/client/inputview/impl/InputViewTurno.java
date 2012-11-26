package cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl;

import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputView;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.Turno;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class InputViewTurno implements InputView<Turno>{
	
	@Override
	public String getTitulo(){
		return inputTurnoInterna.getTitulo();
	}	

	private InputTurnoInterna inputTurnoInterna = new InputTurnoInterna();
	private final InputViewWithTitle<Turno> in=new InputViewWithTitle<Turno>("Turno",inputTurnoInterna); 
	private DecoratorPanel d = new DecoratorPanel();
	public InputViewTurno(){
		d.setWidget(in);
		d.addStyleName("padding15");
		in.asWidget().addStyleName("padding15");
	}

	@Override
	public boolean setInput(Turno input) {
		return inputTurnoInterna.setInput(input);
	}

	@Override
	public Turno getInput() {
		return inputTurnoInterna.getInput();
	}

	@Override
	public Widget asWidget() {
		return d;
	}
	
	private static class InputTurnoInterna extends Composite implements InputView<Turno>{
		
		@Override
		public String getTitulo(){
			return "campo para informar dados de turno";
		}
		
		private final InputViewTimePicker ivInicio = new InputViewTimePicker(); 
		private final InputViewTimePicker ivFim = new InputViewTimePicker();
		private final HorizontalPanel h=new HorizontalPanel(); 
		
		public InputTurnoInterna(){
			initWidget(h);
			h.add(new Label("inicia "));
			h.add(ivInicio );
			h.add(new Label("   termina "));
			h.add(ivFim);
		}

		@Override
		public boolean setInput(Turno input) {
			if (input == null){
				return false;
			}

			boolean result=true;
			
			result&= ivInicio.setInput(input.getInicio());
			result&= ivFim.setInput(input.getFim());
			
			return result;
		}

		@Override
		public Turno getInput() {
			Turno result=new Turno();				
				result.setInicio(ivInicio.getInput());
				result.setFim(ivFim.getInput());
				
			return result;
		}

		@Override
		public String validarDados() {
			Turno t = getInput();
			StringBuilder obs = new StringBuilder();
			
			Boolean ti = t.getInicio()==null;
			Boolean tf = t.getFim()==null;
			
			if(ti){
				obs.append("O termo inicial do turno precisa ser preenchido\n");
			}
			if(tf){
				obs.append("O termo final do turno precisa ser preenchido\n");
			}
			if(!(ti||tf)){
				if( !( t.getInicio().before(t.getFim()) ) )
				obs.append("O termo inicial do turno precisa ser anterior ao final.");
			}
			if(obs.length()>0){
				return obs.toString();
			}else{
				return null;	
			}
		}

	}

	@Override
	public String validarDados() {
		return inputTurnoInterna.validarDados();
	}
}