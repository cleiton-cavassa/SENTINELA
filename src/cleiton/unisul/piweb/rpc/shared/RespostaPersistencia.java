package cleiton.unisul.piweb.rpc.shared;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RespostaPersistencia implements Serializable{
	//o campo abaixo informa se o banco de dados já possuia objeto com o mesmo id do que se tentou salvar
	private Boolean idObjetoJaExistia;
	//o campo abaixo informa se a existência (ou não) de objeto com o mesmo id atende o esperado para essa operação
	private Boolean objetoConformeEsperado;
	//o campo abaixo informa se a operação foi concluída com sucesso
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