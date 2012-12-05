package cleiton.unisul.piweb.sistema.client.formularios.pesquisa;

import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.FormPesquisar;
import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.FormPesquisar.PesquisaCallBack;
import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.FormPesquisarFactory;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.ClientePF;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.CorridaSolicitada;
import cleiton.unisul.piweb.sistema.client.SENTINELA;

public class FormPesquisarCorridaSolicitadaFactory implements FormPesquisarFactory<CorridaSolicitada>{

	@Override
	public FormPesquisar<CorridaSolicitada> getFormPesquisar(
			PesquisaCallBack<CorridaSolicitada> callback) {
		return new FormPesquisarCorridaSolicitada
				("Corrida Solicitada"
				, SENTINELA.getFrota().getChave()
				, callback);
	}

}
