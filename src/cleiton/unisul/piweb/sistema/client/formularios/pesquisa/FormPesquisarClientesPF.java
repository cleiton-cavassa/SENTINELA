package cleiton.unisul.piweb.sistema.client.formularios.pesquisa;

import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.FormPesquisar;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewCPF;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.ClientePF;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;

public class FormPesquisarClientesPF extends FormPesquisar<ClientePF> {

	public FormPesquisarClientesPF(
			String categoria,
			String chavePai,
			PesquisaCallBack<ClientePF> resposta) {
		super(categoria, chavePai, resposta);
		
	}

	@Override
	public CellTable<ClientePF> getTabela() {
	
		CellTable<ClientePF> tabela = new CellTable<ClientePF>();
		
		tabela.addColumn(colunaEscolher());
		
		tabela.addColumn(new TextColumn<ClientePF>() {
			@Override
			public String getValue(ClientePF object) {
				return object.getDadosPessoaFisica().getNome();
			}
		},"Nome");
		
		tabela.addColumn(new TextColumn<ClientePF>() {
			@Override
			public String getValue(ClientePF object) {
				return InputViewCPF.mascaraCPF(object.getDadosPessoaFisica().getCpf());
			}
		},"CPF");
		
		return tabela;
	}

	@Override
	protected ClientePF criarInputVazio() {
		return new ClientePF();
	}
}
