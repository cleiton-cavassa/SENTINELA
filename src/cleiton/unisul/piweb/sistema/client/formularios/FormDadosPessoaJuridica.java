package cleiton.unisul.piweb.sistema.client.formularios;

import java.util.Collection;

import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.InputViewWithTitle;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.Painel;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.RolTextBox;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.exibidor.InputCollectionToHTMLStringParser;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.exibidor.InputView;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputviews.InputViewCNPJ;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputviews.InputViewTextBox;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.DadosPessoaJuridica;

import com.google.gwt.user.client.ui.VerticalPanel;

public class FormDadosPessoaJuridica extends Formulario implements InputView<DadosPessoaJuridica>{

	
	private final VerticalPanel vp= new VerticalPanel();
//	private final HorizontalPanel cnpjErazaoSocial=new HorizontalPanel();
	private final InputViewWithTitle<Long> cnpj = new InputViewWithTitle<Long>("CNPJ",new InputViewCNPJ()); 
	private final InputViewWithTitle<String> razaoSocial=new InputViewWithTitle<String>("Raz\u00E3o Social", new InputViewTextBox(100,500));
	private final Painel<Collection<String>> regioesDeAtuacao= new Painel<Collection<String>>("Regi\u00F5es de Atua\u00E7\u00E3o",new RolTextBox(100,500), new InputCollectionToHTMLStringParser<String>());
	
	public FormDadosPessoaJuridica(){
		initWidget(vp);
		vp.add(cnpj);
		vp.add(razaoSocial);
		
//		vp.add(cnpjErazaoSocial);
		vp.add(regioesDeAtuacao);
	}
	
	@Override
	public boolean setInput(DadosPessoaJuridica input) {
		Boolean result;
		result = cnpj.setInput(input.getCnpj());
		result &= razaoSocial.setInput(input.getRazaoSocial());
		result &= regioesDeAtuacao.setInput(input.getRegioesDeAtuacao());
		
		return  result;
	}

	@Override
	public DadosPessoaJuridica getInput() {
		DadosPessoaJuridica input = new DadosPessoaJuridica();
		
		input.setCnpj(cnpj.getInput());
		input.setRazaoSocial(razaoSocial.getInput());
		input.setRegioesDeAtuacao(regioesDeAtuacao.getInput());
		
		return input;
	}

}
