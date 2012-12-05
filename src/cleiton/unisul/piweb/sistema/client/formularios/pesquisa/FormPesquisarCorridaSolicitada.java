package cleiton.unisul.piweb.sistema.client.formularios.pesquisa;

import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.FormPesquisar;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewCPF;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.ClientePF;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.CorridaSolicitada;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;

public class FormPesquisarCorridaSolicitada extends FormPesquisar<CorridaSolicitada> {

	public FormPesquisarCorridaSolicitada(
			String categoria,
			String chavePai,
			PesquisaCallBack<CorridaSolicitada> resposta) {
		super(categoria, chavePai, resposta);
		
	}

	@Override
	public CellTable<CorridaSolicitada> getTabela() {
	
		CellTable<CorridaSolicitada> tabela = new CellTable<CorridaSolicitada>();
		
		tabela.addColumn(colunaEscolher());
		
		tabela.addColumn(new TextColumn<CorridaSolicitada>() {
			@Override
			public String getValue(CorridaSolicitada object) {
				return object
						.getCliente()
						.getDescricao();
			}
		},"cliente");
		
		tabela.addColumn(new TextColumn<CorridaSolicitada>() {
			@Override
			public String getValue(CorridaSolicitada object) {
				return object
						.getMotorista()
						.getDescricao();
			}
		},"motorista");
		
		tabela.addColumn(new TextColumn<CorridaSolicitada>() {
			@Override
			public String getValue(CorridaSolicitada object) {
				return object
						.getLocalEmbarque();
			}
		},"local embarque");
		
		tabela.addColumn(new TextColumn<CorridaSolicitada>() {
			@Override
			public String getValue(CorridaSolicitada object) {
				return object
						.getDataHoraEmbarque()
						.toLocaleString();
			}
		},"data e hora");
		
		return tabela;
	}

	@Override
	protected CorridaSolicitada criarInputVazio() {
		return new CorridaSolicitada();
	}
}
