package cleiton.unisul.piweb.sistema.client.telaspopup.clientes.clientespf;

//import java.util.Date;

import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.FormDadosDeContato;
import cleiton.unisul.piweb.ferramentasVisuais.client.formularios.Formulario;
import cleiton.unisul.piweb.rpc.client.ServicoArmazenamento;
import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;
import cleiton.unisul.piweb.rpc.shared.objetoschaveados.ClientePF;
//import cleiton.unisul.piweb.rpc.shared.objetoschaveados.DadosClientePF.Status;
//import cleiton.unisul.piweb.rpc.shared.objetoschaveados.DadosClientePF.TipoNacionalidade;
//import cleiton.unisul.piweb.rpc.shared.objetoschaveados.Preferencias.MotoristaFumante;
//import cleiton.unisul.piweb.rpc.shared.objetoschaveados.Preferencias.TransportaAnimais;
import cleiton.unisul.piweb.sistema.client.formularios.FormClientePF;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;

public class CadastroClientesPF extends Formulario<ClientePF> {
	
	private static CadastroClientesPF get = new CadastroClientesPF();
	
	public static CadastroClientesPF get(){
		if(get==null){
			get=new CadastroClientesPF();
		}
		return get;
	}
	
	private ClientePF cliente;
		public ClientePF getCliente() {return cliente;}
		public void setCliente(ClientePF cliente) {this.cliente = cliente;preencherTelaComDadosCliente();}


	private void preencherTelaComDadosCliente() {
//		form.getTextBoxNome().setText(cliente.getDadosPessoais().getNome());
//		form.getCompositeCPF().setValor(cliente.getDadosPessoais().getCpf());
////		form.getCompositePJdeOrigem().setValor(cliente.getPJVinculada());
//		form.getDateBoxNascimento().setValue(cliente.getDadosPessoais().getDataNascimento());
//		form.getComboBoxTipoNacionalidade().setEnumSelecionada(cliente.getTipoNacionalidade());
//		form.getTextBoxIdiomas().setText(cliente.getDadosPessoais().getIdiomasFalados().toString());
//		form.getTextBoxEndereco().setText(cliente.getDadosPessoais().getDadosDeContato().getEndereco());
//		form.getTextBoxTelefones().setText(cliente.getDadosPessoais().getDadosDeContato().getTelefones().toString());
//		form.getChckbxStatus().setEnumSelecionada(cliente.getStatus());
//		form.getCheckBoxTransportaAnimais().setEnumSelecionada(cliente.getPreferencias().getTransportaAnimais());
//		form.getCheckBoxPermiteMotFumante().setEnumSelecionada(cliente.getPreferencias().getMotoristaFumante());
	}

	
	private FormClientePF form;
	
	/**
	 * @wbp.parser.constructor
	 */
	public CadastroClientesPF() {
		
		FlowPanel flowPanel1 = new FlowPanel();
		flowPanel1.setStyleName("painelCadastro");
		initWidget(flowPanel1);
		flowPanel1.setSize("921px", "");
		
		Label lblSentinelaCadastro = new Label("SENTINELA - Cadastro de Clientes - pessoas flow\u00EDsicas");
		lblSentinelaCadastro.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		lblSentinelaCadastro.setStyleName("h1");
		flowPanel1.add(lblSentinelaCadastro);
		lblSentinelaCadastro.setSize("", "");
		
		FormClientePF formClientePF = new FormClientePF();
		flowPanel1.add(formClientePF);
		
		FormDadosDeContato formDadosDeContato = new FormDadosDeContato();
		flowPanel1.add(formDadosDeContato);
		
		form = formClientePF;
		setStyleName("painelCadastro");
		

		ClickHandler salvarClkHnd=new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				salvarClientePF();
			}
		};
		
		
//		form.getBotaoSalvar().addClickHandler(salvarClkHnd);
	}
	
	protected void salvarClientePF(){
		final CallbackArmazenamento callback=new CallbackArmazenamento() ;
		salvaClientePF(callback);	
	}
	
	protected void salvaClientePF(CallbackArmazenamento callback) {
		ClientePF clPF=montarClientePF();
		callback.setClPF(clPF);
		if(clPF!=null){
			ServicoArmazenamento.getArmazenamento().persistir((ObjetoChaveado)clPF, false, false, callback);
		}else{
			Window.alert("Algum campo requerido deixou de ser preenchido.\nTodos os campos marcados com asterisco (*) precisam ser preenchidos.");
		}
		
	}

	private ClientePF montarClientePF() {

//		String nome=form.getTextBoxNome().getText();
//		Long cpf=form.getCompositeCPF().getValor();		
//		Long cnpjPJorigem=form.getCompositePJdeOrigem().getValor();
//		Date nascimento = form.getDateBoxNascimento().getValue();
//		TipoNacionalidade nacionalidade=form.getComboBoxTipoNacionalidade().getEnumSelecionada();
////		boolean nacionalidade;
////			ListBox n= form.getComboBoxTipoNacionalidade();
////			nacionalidade=(n.getValue(n.getSelectedIndex()).equals("brasileiro"));
//		String idiomas=form.getTextBoxIdiomas().getText();
//		String endereco= form.getTextBoxEndereco().getText();
//		String telefones=form.getTextBoxTelefones().getText();
//		Status status = form.getChckbxStatus().getEnumSelecionada();
//		TransportaAnimais carregaAnimais=form.getCheckBoxTransportaAnimais().getEnumSelecionada();
////		MotoristaFumante aceitaMotFumante = form.getCheckBoxPermiteMotFumante().getEnumSelecionada();
////		
//		if ((nome==null)||(nome.equalsIgnoreCase(""))){
//			return null;
//		}
//		
//		if (cpf==0){
//			return null;
//		}
//		
//		if (nascimento==null){
//			return null;
//		}
//		
		ClientePF cliente=new ClientePF();
//			cliente.setNome(nome);
//			cliente.setChave(cpf);
//			cliente.setPJVinculada(cnpjPJorigem);
//			cliente.setDataNascimento(nascimento);
//			cliente.setTipoNacionalidade(nacionalidade);
//			cliente.setIdiomasFalados(idiomas);
//			cliente.setEndereco(endereco);
//			cliente.setTelefones(telefones);
//			cliente.setStatus(status);
//			cliente.setTransportaAnimais(carregaAnimais);
//			cliente.setAceitaMotFumante(aceitaMotFumante);
		return cliente;
	}

	private class CallbackArmazenamento implements AsyncCallback<cleiton.unisul.piweb.rpc.shared.RespostaPersistencia>{
		private ClientePF clPF;
		public ClientePF getClPF() {
			return clPF;
		}

		public void setClPF(ClientePF clPF) {
			this.clPF = clPF;
		}

		@Override
		public void onSuccess(cleiton.unisul.piweb.rpc.shared.RespostaPersistencia result) {
			
			if (result.getOperacaoBemSucedida()){
				StringBuilder b=new StringBuilder();
				b.append("Dados de Cliente PF salvos com sucesso!\n");
				b.append("CPF: "+clPF.getDadosPessoaFisica().getCpf()+"\n");
//				b.append("Nome: "+clPF.getNome());
				RelacaoClientesPF.get().atualizar();
				Window.alert(b.toString());
			}
			if (result.getOperacaoBemSucedida().equals(false)){				
				falha("Motivo: problemas de comunicação com o banco de dados.");
			}
			if ((result.getOperacaoBemSucedida()==null)&&result.getIdObjetoJaExistia()){
				falha("Motivo: não existe um cliente com o CPF informado.");
			}else{
				onFailure(new Exception());
			}
				
		}
		
		@Override
		public void onFailure(Throwable caught) {
			falha("Motivo: desconhecido. Favor comunicar o ocorrido ao administrador do serviço.");
		}
		private void falha(String texto){
			StringBuilder b=new StringBuilder();
			b.append("Houve falha durante o armazenamento dos dados do novo Cliente Pessoa Jurídica.\n");
			b.append("Por favor, tente novamente em outra oportunidade.\n");
			b.append("Dados do cliente:\n");
			b.append("CNPJ: "+this.getClPF().getDadosPessoaFisica().getCpf()+"\n");
//			b.append("Razão Social: "+this.getClPF().getNome()+"\n");
			b.append(((texto==null)?"":texto));
			Window.alert(b.toString());
		}
	}

	@Override
	protected ClientePF criarInputVazio() {
		return new ClientePF();
	}

		
		
	

}
