package cleiton.unisul.piweb.ferramentasVisuais.client.formularios;

import java.util.ArrayList;
import java.util.Collection;

import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.mural.Mural;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.mural.inputparsers.InputParserCollectionToHTMLString;
import cleiton.unisul.piweb.ferramentasVisuais.client.colecoes.rol.impl.RolTextBox;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewCPF;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewForDate;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewTextBox;
import cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl.InputViewWithTitle;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.DadosPessoaFisica;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class FormDadosPessoaFisica extends Formulario<DadosPessoaFisica>{

	
	@Override
	public String getTitulo(){
		return "Sentinela - Dados de Pessoa Fisica";
	}
	
	
	
	private final VerticalPanel vp= new VerticalPanel();
	private final HorizontalPanel nomeEcPF=new HorizontalPanel();
	private final InputViewWithTitle<Long> cpf = new InputViewWithTitle<Long>("CPF",new InputViewCPF()); 
	private final InputViewWithTitle<String> nome=new InputViewWithTitle<String>("Nome", new InputViewTextBox(70,500));
	private final InputViewForDate dataNascimento = new InputViewForDate("Data de Nascimento");
	private final Mural<ArrayList<String>> idiomasFalados= new Mural<ArrayList<String>>("Idiomas Falados",new RolTextBox(500,40), new InputParserCollectionToHTMLString<String>()); 
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
		super.setInput(input);
		
		Boolean result;
		result = cpf.setInput(input.getCpf());
		result&= nome.setInput(input.getNome());
		result&= dataNascimento.setInput(input.getDataNascimento());
		result&= idiomasFalados.setInput(input.getIdiomasFalados());
		
		return result;
	}

	@Override
	public DadosPessoaFisica getInput() {
		DadosPessoaFisica input = super.getInput();
		
		input.setCpf(cpf.getInput());
		input.setDataNascimento(dataNascimento.getInput());
		input.setIdiomasFalados(idiomasFalados.getInput());
		input.setNome(nome.getInput());
		
		return input;
	}

	@Override
	protected DadosPessoaFisica criarInputVazio() {
		// TODO Auto-generated method stub
		return new DadosPessoaFisica();
	}

}
