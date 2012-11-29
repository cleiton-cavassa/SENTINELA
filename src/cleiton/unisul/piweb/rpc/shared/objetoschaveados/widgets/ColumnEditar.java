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
	
	public ColumnEditar(String texto, InputViewFactory<T> criadorInputView){
		super(new ButtonCell());
		this.texto = (texto==null?"editar":texto);
		this.ivFactory=criadorInputView;
		this.setFieldUpdater(new  FieldUpdt());
	}
	
	@Override
	public String getValue(T object) {
		return texto;
	}
	
	private class FieldUpdt implements FieldUpdater<T, String>{
		@Override
		public void update(int index, T object, String value) {
			InputView<T> iv = ivFactory.getInputView();
			iv.setInput(object);
			new CriadorTela(iv).execute();
		}
	}
	
}
