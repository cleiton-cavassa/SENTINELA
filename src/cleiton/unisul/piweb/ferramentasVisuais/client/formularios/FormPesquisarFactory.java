package cleiton.unisul.piweb.ferramentasVisuais.client.formularios;

import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.FormPesquisar.PesquisaCallBack;
import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;

public interface FormPesquisarFactory<Ob extends ObjetoChaveado> {
	FormPesquisar<Ob> getFormPesquisar(PesquisaCallBack<Ob> callback);

}
