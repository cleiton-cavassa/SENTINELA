package cleiton.unisul.piweb.rpc.shared.objetoschaveados.widgets;

import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputView;
import cleiton.unisul.piweb.rpc.client.ServicoArmazenamento;
import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;
import cleiton.unisul.piweb.rpc.shared.RespostaPersistencia;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;

public class BotaoSalvar <Ob extends ObjetoChaveado>extends Button {
	
	private InputView<Ob> inputView;
	private boolean novoRegistro;
	private boolean salvarMesmoSeNaoOcorrerOEsperado;
	private AsyncCallback<RespostaPersistencia> callback;

	public BotaoSalvar(String texto, InputView<Ob> inputView, boolean novoRegistro,
			boolean salvarMesmoSeNaoOcorrerOEsperado, AsyncCallback<RespostaPersistencia> callback) {
		super(texto);
		this.inputView = inputView;
		this.novoRegistro = novoRegistro;
		this.salvarMesmoSeNaoOcorrerOEsperado = salvarMesmoSeNaoOcorrerOEsperado;
		this.callback=callback;
		
		this.addClickHandler(hSalvar);
	}

	private ClickHandler hSalvar=  new ClickHandler() {
		@Override
		public void onClick(ClickEvent event) {
			Window.alert(inputView.getInput().getResumo());
			ServicoArmazenamento.getArmazenamento().persistir(inputView.getInput(), novoRegistro, salvarMesmoSeNaoOcorrerOEsperado, callback);
		}
	};
	
}
