package cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.mural.inputparsers;

import java.util.Collection;

import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.mural.Mural;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.mural.Mural.InputParser;


public class InputParserCollectionToHTMLString <T extends Object> implements InputParser<Collection<T>, String>{
	
	private static final String divisor="<br/>";

	@Override
	public String parse(Collection<T> input) {
		if (input==null){
			return "";
		}else{
			return processar(input);
		}
	}
	
	private String processar(Collection<T> input){
		StringBuilder b = new StringBuilder ();
		int i=0;
		for(T a: input){
			i++;
			b.append(formataNumero(i));
//			try {
				b.append(a.toString());
//			} catch (Throwable e) {
//				b.append("vazio");
//			}
			b.append(divisor);
		}
		return b.toString();
	}
	
	private String formataNumero(int i){
		return "<b>"+i+".</b>  ";
	}
}