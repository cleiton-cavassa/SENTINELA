package cleiton.unisul.piweb.rpc.shared.objetoschaveados.widgets;

import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputView;
import cleiton.unisul.piweb.rpc.client.ServicoArmazenamento;
import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;
import cleiton.unisul.piweb.rpc.shared.RespostaPersistencia;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;

public class BotaoSalvar <Ob extends ObjetoChaveado>extends Button {
	
	private InputView<Ob> inputView;
	private boolean novoRegistro;
	private boolean salvarMesmoSeNaoOcorrerOEsperado;
	private AsyncCallback<RespostaPersistencia> callback;
	private Acionador acionador;

	
	/**
	 * Cria um botão especial com um ClickHandler preconfigurado, o qual aciona uma RPC de persistência de objeto a cada clique.
	 * @param texto Texto que será exibido no botão
	 * @param inputView O objeto InputView que armazena o objeto a ser salvo 
	 * @param novoRegistro <i>true</i> Se o objetivo do botão é salvar um objeto preexistente no banco de dados. <i>false</i> caso contrário. 
	 * @param salvarMesmoSeNaoOcorrerOEsperado Caso o objeto já exista, e se esperava que ele não existisse 
	 * (ou vice-versa), o que fazer? Informe <i>true</i> para continuar em todo caso, e <i>false</i> para desistir caso as coisas não ocorram conforme esperado.
	 * @param Objeto de callback AsyncCallback<> que deve ser acionada quando a persistência chegar ao fim.
	 */
	public BotaoSalvar(String texto, InputView<Ob> inputView, boolean novoRegistro,
			boolean salvarMesmoSeNaoOcorrerOEsperado, Acionador acionador) {
		super(texto);
		this.inputView = inputView;
		this.novoRegistro = novoRegistro;
		this.salvarMesmoSeNaoOcorrerOEsperado = salvarMesmoSeNaoOcorrerOEsperado;
		this.callback=acionador.getCallback();
		this.acionador=acionador;
		this.addClickHandler(hSalvar);
	}

	private ClickHandler hSalvar=  new ClickHandler() {
		@Override
		public void onClick(ClickEvent event) {
			acionador.execute();
			ServicoArmazenamento.getArmazenamento().persistir(inputView.getInput(), novoRegistro, salvarMesmoSeNaoOcorrerOEsperado, callback);
		}
	};
	
	public interface Acionador extends Command{
		AsyncCallback<RespostaPersistencia> getCallback();
	}
	
}
