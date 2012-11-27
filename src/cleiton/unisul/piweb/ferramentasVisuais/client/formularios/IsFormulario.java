package cleiton.unisul.piweb.ferramentasVisuais.client.formularios;

import com.google.gwt.user.client.ui.IsWidget;

public interface IsFormulario extends IsWidget{
	/**Método utilizado para validar os conteúdos dos campos dos formulários.
	 * As implementações dessa interface devem sobrescrevê-lo quando quiserem efetuar validação do formulário.
	 * @return Se a validação encontrar algum erro, deve retornar uma mensagem explicativa como resposta.<br/>
	 * Caso não se encontrem falhas de preenchimento, deve ser retornado o objeto null. 
	 * */
	String validarDados();
	String getTitulo();
}
