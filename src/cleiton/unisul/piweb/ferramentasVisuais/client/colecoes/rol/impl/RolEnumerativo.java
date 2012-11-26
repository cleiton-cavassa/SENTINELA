package cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.rol.impl;

import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.excludeMePlease.impl.WidgetComBotaoMenos;

import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.rol.Rol;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewListBoxEnumeracoes;

public class RolEnumerativo <E extends Enum<E>> extends
Rol<WidgetComBotaoMenos<InputViewListBoxEnumeracoes<E>>, E>
{

	public RolEnumerativo(E exemplo){
//		super(
//		(CriadorWidgets<WidgetComBotaoMenos<InputViewListBoxEnumeracoes<E>>>)
//			(new Criador<E>(exemplo)), 
//				new ParserEnumWidgetComBotaoMenos<E>()
//				);
		super( new ParserEnumWidgetComBotaoMenos<E>(exemplo) );
	}
	//Exemplo:
	//RolEnumerativo<TipoNacionalidade> rol=new RolEnumerativo<TipoNacionalidade>(TipoNacionalidade.BRASILEIRO);
	
	
//	private static class Criador <F extends Enum<F>> implements CriadorWidgets<WidgetComBotaoMenos<InputViewListBoxEnumeracoes<F>>>{
//		
//		private F exemplo;
//		public Criador(F exemplo){
//			this.exemplo=exemplo;
//		}
//		
//		@Override
//		public WidgetComBotaoMenos<InputViewListBoxEnumeracoes<F>> criarWidget() {
//			return new WidgetComBotaoMenos<InputViewListBoxEnumeracoes<F>> (new InputViewListBoxEnumeracoes<F>(exemplo, true));
//		} 
//	}
	private static class ParserEnumWidgetComBotaoMenos <E extends Enum<E>> implements Parser<E, WidgetComBotaoMenos<InputViewListBoxEnumeracoes<E>>> {	

		private E exemplo;

		public ParserEnumWidgetComBotaoMenos (E exemplo){
			this.exemplo=exemplo;
		}
		
		@Override
		public WidgetComBotaoMenos<InputViewListBoxEnumeracoes<E>> set() {
			return set(exemplo);
		}
		
		@Override
		public WidgetComBotaoMenos<InputViewListBoxEnumeracoes<E>> set(E input) {
			return new WidgetComBotaoMenos<InputViewListBoxEnumeracoes<E>> (
					new InputViewListBoxEnumeracoes<E>(input)
					);
		}

		@Override
		public void set(E input, WidgetComBotaoMenos<InputViewListBoxEnumeracoes<E>> target) {
			target=set(input);
		}

		@Override
		public E get(WidgetComBotaoMenos<InputViewListBoxEnumeracoes<E>> isWidget) {
			return isWidget.getWidgetParaExibir().getEnumSelecionada();
		}


	}

}
