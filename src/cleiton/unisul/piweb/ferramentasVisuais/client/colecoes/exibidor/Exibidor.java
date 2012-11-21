package cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.exibidor;

import com.google.gwt.user.client.ui.Widget;


public interface Exibidor <Dados extends Object, Lugar extends Widget>{
	Lugar exibir(Dados dados);
	Boolean exibir(Dados dados, Lugar lugar);
}
