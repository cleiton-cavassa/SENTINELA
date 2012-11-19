package cleiton.unisul.piweb.ferramentasVisuais.client.colecoes;

import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.rol.CriadorWidgets;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.rol.ParserEnumWidgetComBotaoMenos;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.rol.ParserForIsWidgets;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.rol.WidgetComBotaoMenos;
import cleiton.unisul.piweb.ferramentasVisuais.client.enums.ListBoxEnumeracoes;

public class RolEnumerativo <E extends Enum<E>> extends
Rol<WidgetComBotaoMenos<ListBoxEnumeracoes<E>>, 
E, ParserForIsWidgets<E,WidgetComBotaoMenos<ListBoxEnumeracoes<E>>>>
{

	public RolEnumerativo(E exemplo){
		super(
		(CriadorWidgets<WidgetComBotaoMenos<ListBoxEnumeracoes<E>>>)
			(new Criador<E>(exemplo)), 
				new ParserEnumWidgetComBotaoMenos<E>()
				);
	}
	//Exemplo:
	//RolEnumerativo<TipoNacionalidade> rol=new RolEnumerativo<TipoNacionalidade>(TipoNacionalidade.BRASILEIRO);
	
	
	private static class Criador <F extends Enum<F>> implements CriadorWidgets<WidgetComBotaoMenos<ListBoxEnumeracoes<F>>>{
		
		private F exemplo;
		public Criador(F exemplo){
			this.exemplo=exemplo;
		}
		
		@Override
		public WidgetComBotaoMenos<ListBoxEnumeracoes<F>> criarWidget() {
			return new WidgetComBotaoMenos<ListBoxEnumeracoes<F>> (new ListBoxEnumeracoes<F>(exemplo, true));
		} 
	}

}
