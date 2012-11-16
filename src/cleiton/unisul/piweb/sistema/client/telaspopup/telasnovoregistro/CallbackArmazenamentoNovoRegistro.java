package cleiton.unisul.piweb.sistema.client.telaspopup.telasnovoregistro;

import com.google.gwt.user.client.Window;

import com.google.gwt.user.client.rpc.AsyncCallback;

import cleiton.unisul.piweb.classesrpc.shared.ObjetoChaveado;
import cleiton.unisul.piweb.classesrpc.shared.RespostaPersistencia;
import cleiton.unisul.piweb.sistema.client.bloqueio.TelaComBloqueio;
import cleiton.unisul.piweb.sistema.client.persistencia.TelaPersistencia;

public class CallbackArmazenamentoNovoRegistro<T extends ObjetoChaveado>  implements AsyncCallback<cleiton.unisul.piweb.classesrpc.shared.RespostaPersistencia>{
		
	public CallbackArmazenamentoNovoRegistro(T objeto, TelaComBloqueio tela, TelaLimpavel cadastro){
		this.objeto=objeto;
		this.tela=tela;
		this.cadastro=cadastro;
	}
	
	private T objeto;
	private TelaComBloqueio tela;
	private TelaLimpavel cadastro;
	
	public T getObjeto() {
		return objeto;
	}
	public void setObjeto(T objeto) {
		this.objeto = objeto;
	}

	
	private String motivoPadrao="Motivo: desconhecido. Favor comunicar o ocorrido ao administrador do serviço.";
	@Override
	public void onSuccess(RespostaPersistencia result) {
		if (result.getOperacaoBemSucedida()){
			StringBuilder b=new StringBuilder();
			b.append("Dados salvos com sucesso!\n");
			b.append(objeto.getResumo());
			Window.alert(b.toString());
		}else{
			if (result.getOperacaoBemSucedida().equals(false)){				
				falha("Motivo: problemas de comunicação com o banco de dados.");
			}else{
				if ((result.getOperacaoBemSucedida()==null)&&(result.getIdObjetoJaExistia().booleanValue()==false)){
					falha("Motivo: já existe um cliente com o identificador informado.");
				}else{
					falha(motivoPadrao);
				}
			}
		}
		tela.setTelaBloqueada(false);
		cadastro.limpar();
	}
	@Override
	public void onFailure(Throwable caught) {
		falha(motivoPadrao);
		tela.setTelaBloqueada(false);
	}
	private void falha(String texto){
		StringBuilder b=new StringBuilder();
		b.append("Houve falha durante o armazenamento dos dados do novo Cliente Pessoa Jurídica.\n");
		b.append("Por favor, tente novamente em outra oportunidade.\n");
		b.append(objeto.getResumo());
		b.append(texto);
		Window.alert(b.toString());
		tela.setTelaBloqueada(false);
	}
}
