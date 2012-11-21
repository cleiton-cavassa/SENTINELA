package cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.exibidor;

import java.util.Collection;

import com.google.gwt.user.client.ui.Label;


public class ExibidorLabelDeColecao <Dados extends Collection<?>> implements Exibidor<Dados, Label>{
	
	public Label exibir(Dados dados){
		Label result = new Label();
		exibir(dados,result);
		return result;
	}

	@Override
	public Boolean exibir(Dados dados, Label lugar) {
		lugar.setText(dados.toString());
		return true;
	}
}
