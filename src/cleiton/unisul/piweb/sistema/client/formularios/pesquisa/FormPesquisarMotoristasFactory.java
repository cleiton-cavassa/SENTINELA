package cleiton.unisul.piweb.sistema.client.formularios.pesquisa;

import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.FormPesquisar;
import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.FormPesquisar.PesquisaCallBack;
import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.FormPesquisarFactory;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.Motorista;
import cleiton.unisul.piweb.sistema.client.SENTINELA;

public class FormPesquisarMotoristasFactory implements FormPesquisarFactory<Motorista>{

	@Override
	public FormPesquisar<Motorista> getFormPesquisar(
			PesquisaCallBack<Motorista> callback) {
		return new FormPesquisarMotoristas
				("Motorista"
				, SENTINELA.getFrota().getChave()
				, callback);
	}

}
