package cleiton.unisul.piweb.sistema.client.formularios.pesquisa;

import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.FormPesquisar;
import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.FormPesquisar.PesquisaCallBack;
import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.FormPesquisarFactory;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.ClientePF;
import cleiton.unisul.piweb.sistema.client.SENTINELA;

public class FormPesquisarClientesPFfactory implements FormPesquisarFactory<ClientePF>{

	@Override
	public FormPesquisar<ClientePF> getFormPesquisar(
			PesquisaCallBack<ClientePF> callback) {
		return new FormPesquisarClientesPF
				("Cliente Pessoa Fisica"
				, SENTINELA.getFrota().getChave()
				, callback);
	}

}
