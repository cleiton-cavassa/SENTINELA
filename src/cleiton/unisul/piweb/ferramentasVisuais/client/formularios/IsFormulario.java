package cleiton.unisul.piweb.ferramentasVisuais.client.formularios;

import com.google.gwt.user.client.ui.IsWidget;

public interface IsFormulario extends IsWidget{
	/**M�todo utilizado para validar os conte�dos dos campos dos formul�rios.
	 * As implementa��es dessa interface devem sobrescrev�-lo quando quiserem efetuar valida��o do formul�rio.
	 * @return Se a valida��o encontrar algum erro, deve retornar uma mensagem explicativa como resposta.<br/>
	 * Caso n�o se encontrem falhas de preenchimento, deve ser retornado o objeto null. 
	 * */
	String validarDados();
	String getTitulo();
}
