package cleiton.unisul.piweb.ferramentasVisuais.client.colecoes;

import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.rol.CriadorWidgets;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.rol.ParserEnumWidgetComBotaoMenos;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.rol.ParserForIsWidgets;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.rol.WidgetComBotaoMenos;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputviews.InputViewListBoxEnumeracoes;

public class RolEnumerativo <E extends Enum<E>> extends
Rol<WidgetComBotaoMenos<InputViewListBoxEnumeracoes<E>>, E>
{

	public RolEnumerativo(E exemplo){
		super(
		(CriadorWidgets<WidgetComBotaoMenos<InputViewListBoxEnumeracoes<E>>>)
			(new Criador<E>(exemplo)), 
				new ParserEnumWidgetComBotaoMenos<E>()
				);
	}
	//Exemplo:
	//RolEnumerativo<TipoNacionalidade> rol=new RolEnumerativo<TipoNacionalidade>(TipoNacionalidade.BRASILEIRO);
	
	
	private static class Criador <F extends Enum<F>> implements CriadorWidgets<WidgetComBotaoMenos<InputViewListBoxEnumeracoes<F>>>{
		
		private F exemplo;
		public Criador(F exemplo){
			this.exemplo=exemplo;
		}
		
		@Override
		public WidgetComBotaoMenos<InputViewListBoxEnumeracoes<F>> criarWidget() {
			return new WidgetComBotaoMenos<InputViewListBoxEnumeracoes<F>> (new InputViewListBoxEnumeracoes<F>(exemplo, true));
		} 
	}

}
