package cleiton.unisul.piweb.sistema.client.formularios;

import java.util.Collection;

import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.mural.Mural;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.mural.inputparsers.InputParserCollectionToHTMLString;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.rol.impl.RolTextBox;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewCNPJ;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewTextBox;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewWithTitle;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.DadosPessoaJuridica;

import com.google.gwt.user.client.ui.VerticalPanel;

public class FormDadosPessoaJuridica extends Formulario<DadosPessoaJuridica>{

	@Override
	public String getTitulo(){
		return "Sentinela - Dados de Pessoa Juridica";
	}
	
	private final VerticalPanel vp= new VerticalPanel();
//	private final HorizontalPanel cnpjErazaoSocial=new HorizontalPanel();
	private final InputViewWithTitle<Long> cnpj = new InputViewWithTitle<Long>("CNPJ",new InputViewCNPJ()); 
	private final InputViewWithTitle<String> razaoSocial=new InputViewWithTitle<String>("Raz\u00E3o Social", new InputViewTextBox(100,500));
	private final Mural<Collection<String>> regioesDeAtuacao= new Mural<Collection<String>>("Regi\u00F5es de Atua\u00E7\u00E3o",new RolTextBox(100,500), new InputParserCollectionToHTMLString<String>());
	
	public FormDadosPessoaJuridica(){
		initWidget(vp);
		vp.add(cnpj);
		vp.add(razaoSocial);
		
//		vp.add(cnpjErazaoSocial);
		vp.add(regioesDeAtuacao);
	}
	
	@Override
	public boolean setInput(DadosPessoaJuridica input) {
		super.setInput(input);
		
		Boolean result;
		result = cnpj.setInput(input.getCnpj());
		result &= razaoSocial.setInput(input.getRazaoSocial());
		result &= regioesDeAtuacao.setInput(input.getRegioesDeAtuacao());
		
		return  result;
	}

	@Override
	public DadosPessoaJuridica getInput() {
		DadosPessoaJuridica input = super.getInput();
		
		input.setCnpj(cnpj.getInput());
		input.setRazaoSocial(razaoSocial.getInput());
		input.setRegioesDeAtuacao(regioesDeAtuacao.getInput());
		
		return input;
	}

}
