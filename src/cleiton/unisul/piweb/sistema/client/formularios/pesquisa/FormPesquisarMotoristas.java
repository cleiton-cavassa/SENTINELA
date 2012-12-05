package cleiton.unisul.piweb.sistema.client.formularios.pesquisa;

import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.FormPesquisar;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewCPF;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.Motorista;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;

public class FormPesquisarMotoristas extends FormPesquisar<Motorista> {

	public FormPesquisarMotoristas(
			String categoria,
			String chavePai,
			PesquisaCallBack<Motorista> resposta) {
		super(categoria, chavePai, resposta);
	}

	@Override
	public CellTable<Motorista> getTabela() {
		CellTable<Motorista> tabela = new CellTable<Motorista>();
		
		tabela.addColumn(colunaEscolher());
		
		tabela.addColumn(new TextColumn<Motorista>() {
			@Override
			public String getValue(Motorista object) {
				return object.getDadosPessoais().getDadosPessoaFisica().getNome();
			}
		},"Nome");
		
		tabela.addColumn(new TextColumn<Motorista>() {
			@Override
			public String getValue(Motorista object) {
				return InputViewCPF.mascaraCPF(object.getDadosPessoais().getDadosPessoaFisica().getCpf());
			}
		},"CPF");
		
		return tabela;
	}

	@Override
	protected Motorista criarInputVazio() {
		return new Motorista();
	}
}
