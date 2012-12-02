package cleiton.unisul.piweb.rpc.shared.objetoschaveados.widgets;

import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputView;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputViewFactory;
import cleiton.unisul.piweb.ferramentasVisuais.client.util.CriadorTela;
import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.user.cellview.client.Column;

public class ColumnEditar <T extends ObjetoChaveado>extends Column<T, String>{
	
	private final String texto;
	private final InputViewFactory<T> ivFactory;
	private FieldUpdater<T,String> preExecutor;
	
	/**
	 * 
	 * @param texto String que ser� exibida sobre o bot�o
	 * @param preExecutor O m�todo update(int, T, String) deste objeto ser� executado antes de qualquer coisa quando o bot�o for apertado
	 * @param criadorInputView F�brica de objetos da classe InputView. � utilizada para se obter um Widget que ser� preenchido com os 
	 * dados do objeto de classe T da linha correspondente ao bot�o acionado.
	 */
	public ColumnEditar(String texto, FieldUpdater<T,String> preExecutor, InputViewFactory<T> criadorInputView){
		super(new ButtonCell());
		this.texto = (texto==null?"editar":texto);
		this.ivFactory=criadorInputView;
		this.setFieldUpdater(new  FieldUpdt());
		this.preExecutor=preExecutor;
	}
	
	@Override
	public String getValue(T object) {
		return texto;
	}
	
	private class FieldUpdt implements FieldUpdater<T, String>{
		@Override
		public void update(int index, T object, String value) {
			preExecutor.update(index, object, value);
			InputView<T> iv = ivFactory.getInputView();
			iv.setInput(object);
			
//			new CriadorTela(iv).execute();
			new CriadorTela<T>(iv).execute();
		}
	}
	
}
