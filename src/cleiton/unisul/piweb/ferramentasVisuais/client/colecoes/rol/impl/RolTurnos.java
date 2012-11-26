package cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.rol.impl;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.excludeMePlease.impl.WidgetComBotaoMenos;

import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.rol.Rol;
//import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.rol.parser.Parser;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewTurno;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.Turno;
import cleiton.unisul.piweb.sistema.client.formularios.IsFormulario;

public class RolTurnos extends Rol<WidgetComBotaoMenos<InputViewTurno>, Turno> {

//	public RolTurnos(
//			CriadorWidgets<WidgetComBotaoMenos<InputViewTurno>> criador,
//			Parser<Turno, WidgetComBotaoMenos<InputViewTurno>> parser) {
////		super(criador, parser);
//		super(parser);
//		
//	}
	public RolTurnos(){
//		this(new Criador(),new ParserTurno());
		super(new ParserTurno());
	}

//	private static class Criador implements CriadorWidgets<WidgetComBotaoMenos<InputViewTurno>>{
//		@Override
//		public WidgetComBotaoMenos<InputViewTurno> criarWidget() {
//			return new ParserTurno().set(new Turno());
//		}
//		
//	}
	
	private static class ParserTurno implements Parser<Turno, WidgetComBotaoMenos<InputViewTurno>>{

		
		@Override
		public WidgetComBotaoMenos<InputViewTurno> set() {
			WidgetComBotaoMenos<InputViewTurno> result = new Janela<InputViewTurno>(new InputViewTurno());
			return result;
		}

		@Override
		public WidgetComBotaoMenos<InputViewTurno> set(Turno input) {
			WidgetComBotaoMenos<InputViewTurno> result = set();
			set(input, result);
			return result;
		}

		@Override
		public void set(Turno input, WidgetComBotaoMenos<InputViewTurno> target) {
			target.getWidgetParaExibir().setInput(input);
		}

		@Override
		public Turno get(WidgetComBotaoMenos<InputViewTurno> isWidget) {
			return isWidget.getWidgetParaExibir().getInput();
		}

	}
	
	private static class Janela<T extends IsFormulario> extends WidgetComBotaoMenos<T>{

		public Janela(T widgetParaExibir) {
			super(widgetParaExibir);
		}
		protected void arrumarPainelBase(FlowPanel painelBase, T widgetParaExibir, Widget botaoMenos){
			HorizontalPanel h = new HorizontalPanel();
			h.setWidth("100%");
			h.add(widgetParaExibir);
				h.setCellHorizontalAlignment(widgetParaExibir, HasHorizontalAlignment.ALIGN_CENTER);
			h.add(botaoMenos);
				h.setCellHorizontalAlignment(botaoMenos, HasHorizontalAlignment.ALIGN_RIGHT);
				h.setCellVerticalAlignment(botaoMenos, HasVerticalAlignment.ALIGN_MIDDLE);
			painelBase.add(h);
		}
		
	}

}
