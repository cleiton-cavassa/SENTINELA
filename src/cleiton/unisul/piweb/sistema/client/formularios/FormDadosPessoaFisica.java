package cleiton.unisul.piweb.sistema.client.formularios;

import java.util.Collection;

import sun.awt.HorizBagLayout;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.InputViewForDate;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.InputViewWithTitle;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.Painel;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.RolTextBox;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.exibidor.InputCollectionToHTMLStringParser;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.exibidor.InputView;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputviews.InputViewCPF;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputviews.InputViewTextBox;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.DadosPessoaFisica;

public class FormDadosPessoaFisica extends Formulario implements InputView<DadosPessoaFisica>{

	private final VerticalPanel vp= new VerticalPanel();
	private final HorizontalPanel nomeEcPF=new HorizontalPanel();
	private final InputViewWithTitle<Long> cpf = new InputViewWithTitle<Long>("CPF",new InputViewCPF()); 
	private final InputViewWithTitle<String> nome=new InputViewWithTitle<String>("Nome", new InputViewTextBox(70,500));
	private final InputViewForDate dataNascimento = new InputViewForDate("Data de Nascimento");
	private final Painel<Collection<String>> idiomasFalados= new Painel<Collection<String>>("Idiomas Falados",new RolTextBox(40,500), new InputCollectionToHTMLStringParser<String>()); 
	public FormDadosPessoaFisica(){
		
		nomeEcPF.add(nome);
		nomeEcPF.add(cpf);
		vp.add(nomeEcPF);
		
		vp.add(dataNascimento);
		vp.add(idiomasFalados);
		
		initWidget(vp);
	}
	
	@Override
	public boolean setInput(DadosPessoaFisica input) {
		Boolean result;
		result = cpf.setInput(input.getCpf());
		result&= nome.setInput(input.getNome());
		result&= dataNascimento.setInput(input.getDataNascimento());
		result&= idiomasFalados.setInput(input.getIdiomasFalados());
		
		return result;
	}

	@Override
	public DadosPessoaFisica getInput() {
		DadosPessoaFisica input = new DadosPessoaFisica();
		
		input.setCpf(cpf.getInput());
		input.setDataNascimento(dataNascimento.getInput());
		input.setIdiomasFalados(idiomasFalados.getInput());
		input.setNome(nome.getInput());
		
		return input;
	}

}
