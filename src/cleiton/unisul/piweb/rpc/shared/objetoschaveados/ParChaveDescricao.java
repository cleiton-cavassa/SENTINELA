package cleiton.unisul.piweb.rpc.shared.objetoschaveados;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;

@PersistenceCapable(detachable="true")
public class ParChaveDescricao implements ObjetoChaveado{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8730906869318818438L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
	private String chave;
	
	@Persistent
	private String chaveObjeto;
	
	@Persistent
	private String descricao;

	public ParChaveDescricao() {
	}

	public String getChaveObjeto() {
		return chaveObjeto;
	}

	public void setChaveObjeto(String chaveObjeto) {
		this.chaveObjeto = chave;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString(){
		return descricao;
	}

	@Override
	public String getChave() {
		return chave;
	}

	@Override
	public void setChave(String chave) {
		this.chave = chave;
	}

	@Override
	public String getResumo() {
		return toString();
	}
}