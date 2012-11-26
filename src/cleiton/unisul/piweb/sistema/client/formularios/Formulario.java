package cleiton.unisul.piweb.sistema.client.formularios;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputView;
import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;

import com.google.gwt.user.client.ui.Composite;

abstract public class Formulario <Ob extends ObjetoChaveado>extends Composite implements IsFormulario, InputView<Ob>{
	
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
		return (objeto==null?criarInputVazio():objeto);
	};
	
	/**
	 * Esse método precisa ser implementado pelas subclasses de Formulario{@literal <Ob>},
	 * e é usado para obter um objeto de retorno para o método <i>Ob getInput()</i>
	 * quando nenhum objeto diferente de null foi passado por meio do método 
	 * <i>boolean setInput(Ob input)</i>.
	 * @return um objeto do tipo Ob sem qualquer valor significante preenchido.
	 */
	protected abstract Ob criarInputVazio();
}
