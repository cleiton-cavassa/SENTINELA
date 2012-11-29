package cleiton.unisul.piweb.rpc.shared.objetoschaveados.widgets;

import cleiton.unisul.piweb.rpc.client.ServicoArmazenamento;
import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;
import cleiton.unisul.piweb.rpc.shared.RespostaPersistencia;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ColumnExcluir <T extends ObjetoChaveado>extends Column<T, String>{
	
	private final String texto;
	private final AcionadorExcluir<T> acionador;
	
	public ColumnExcluir(String texto, AcionadorExcluir<T> acionadorCallback){
		super(new ButtonCell());
		this.texto = (texto==null?"excluir":texto);
		this.acionador=acionadorCallback;
		this.setFieldUpdater(new  FieldUpdt());
	}
	
	@Override
	public String getValue(T object) {
		return texto;
	}
	
	private class FieldUpdt implements FieldUpdater<T, String>{
		@Override
		public void update(int index, T object, String value) {
			acionador.execute();
			ServicoArmazenamento.getArmazenamento().excluir(object, acionador.getCallback(object));
		}
	}
	
	public interface AcionadorExcluir<U extends ObjetoChaveado> extends Command{
		AsyncCallback<RespostaPersistencia> getCallback(U aExcluir);
	}
}
