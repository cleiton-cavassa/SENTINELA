package cleiton.unisul.piweb.sistema.client.formularios;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputView;
import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;

import com.google.gwt.user.client.ui.Composite;

public class Formulario <Ob extends ObjetoChaveado>extends Composite implements IsFormulario, InputView<Ob>{
	
	private Ob objeto;

	@Override
	public String validarDados(){
		return null;
	};
	
	/**Esse método é sobrescrito por cada subclasse de cleiton.unisul.piweb.sistema.client.formularios.Formulario, pois retorna originalmente o objeto null.
	 * @returns O valor retornado pode ser usado para identificar o objeto em um container.
	 */
	@Override
	public String getTitulo(){
		return null;
	}

	@Override
	public boolean setInput(Ob input) {
		objeto=input;
		return true;
	}

	@Override
	public Ob getInput() {
		return objeto;
	};
}
