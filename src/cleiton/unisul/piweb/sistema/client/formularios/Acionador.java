package cleiton.unisul.piweb.sistema.client.formularios;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.InputView;
import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;
import cleiton.unisul.piweb.rpc.shared.respostasdeconsulta.RespostaPersistencia;

public class Acionador <Ob extends ObjetoChaveado>implements cleiton.unisul.piweb.rpc.shared.objetoschaveados.widgets.BotaoSalvar.Acionador{
	private InputView<Ob> iv;
	
	public Acionador(InputView<Ob> inputView){
		iv=inputView;
	}
		
	@Override
	public void execute() {}
	
	@Override
	public AsyncCallback<RespostaPersistencia> getCallback() {
		return new AsyncCallback<RespostaPersistencia>() {
			final String msgFalha="Houve problemas durante o procedimento. O objeto n‹o foi salvo.\nPor favor, tente novamente em outra oportunidade";
			final String msgSucesso="Dados salvos com sucesso.";
			@Override
			public void onFailure(Throwable caught) {
				Window.alert(msgFalha + ":\n" + caught.getMessage());
				new Exception("passei por aqui:\n"+caught.getMessage()).printStackTrace();
			}
			@Override
			public void onSuccess(RespostaPersistencia result) {
				if(result.getOperacaoBemSucedida()){
					Window.alert(msgSucesso);
					iv.fechar();
				}else{
					new Exception("passei por c‡:\n").printStackTrace();
					Window.alert(msgFalha);
				}
			}
		};
	}
}
