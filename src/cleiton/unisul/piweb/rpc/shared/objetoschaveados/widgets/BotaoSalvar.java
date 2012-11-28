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

	
	/**
	 * Cria um bot�o especial com um ClickHandler preconfigurado, o qual aciona uma RPC de persist�ncia de objeto a cada clique.
	 * @param texto Texto que ser� exibido no bot�o
	 * @param inputView O objeto InputView que armazena o objeto a ser salvo 
	 * @param novoRegistro <i>true</i> Se o objetivo do bot�o � salvar um objeto preexistente no banco de dados. <i>false</i> caso contr�rio. 
	 * @param salvarMesmoSeNaoOcorrerOEsperado Caso o objeto j� exista, e se esperava que ele n�o existisse 
	 * (ou vice-versa), o que fazer? Informe <i>true</i> para continuar em todo caso, e <i>false</i> para desistir caso as coisas n�o ocorram conforme esperado.
	 * @param Objeto de callback AsyncCallback<> que deve ser acionada quando a persist�ncia chegar ao fim.
	 */
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
