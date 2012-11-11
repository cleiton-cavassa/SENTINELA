package cleiton.unisul.piweb.shared;

import java.io.Serializable;

public interface ObjetoChaveado {
	final static int erro_FalhaGenericaAoPesquisarObjetoComChave=8;
	final static int erro_FalhaGenericaAoSalvarObjeto=7;
	final static int erro_JaExisteObjetoComMesmaChave=6;
	final static int erro_NaoExisteObjetoComMesmaChave=5;
	final static int salvo_JaExistiaObjetoComMesmaChave=4;
	final static int salvo_NaoExistiaObjetoComMesmaChave=3;
	final static int salvo_SemRessalvas=2;
	
	//final static int erro_JaExisteObjetoComMesmaChave=8;
	
	Long getChave();
	void setChave(Long chave);
	public class RespostaPersistencia implements Serializable{
		//o campo abaixo informa se o banco de dados j� possuia objeto com o mesmo id do que se tentou salvar
		private Boolean idObjetoJaExistia;
		//o campo abaixo informa se a exist�ncia (ou n�o) de objeto com o mesmo id atende o esperado para essa opera��o
		private Boolean objetoConformeEsperado;
		//o campo abaixo informa se a opera��o foi conclu�da com sucesso
		private Boolean operacaoBemSucedida;
		
		public Boolean getIdObjetoJaExistia() {
			return idObjetoJaExistia;
		}
		public void setIdObjetoJaExistia(Boolean idObjetoJaExistia) {
			this.idObjetoJaExistia = idObjetoJaExistia;
		}
		public Boolean getObjetoConformeEsperado() {
			return objetoConformeEsperado;
		}
		public void setObjetoConformeEsperado(Boolean objetoConformeEsperado) {
			this.objetoConformeEsperado = objetoConformeEsperado;
		}
		public Boolean getOperacaoBemSucedida() {
			return operacaoBemSucedida;
		}
		public void setOperacaoBemSucedida(Boolean operacaoBemSucedida) {
			this.operacaoBemSucedida = operacaoBemSucedida;
		}
	}
}
