package cleiton.unisul.piweb.rpc.shared.objetoschaveados.acessorios;

import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;

public class PadraoItemResumo{

	private PadraoItemResumo(){}
	
	private static PadraoItemResumo get=new PadraoItemResumo();
	public static PadraoItemResumo get(){
		if (get==null){
			get=new PadraoItemResumo();
		}
		return get;
	}
	
	
	public Boolean gerarItem(StringBuilder b, CharSequence titulo, Object objeto){
		b.append(titulo.toString());
		b.append(": ");
		if(objeto==null){
			b.append("vazio");
		}else{
			b.append(getResumo(objeto));
		}
		b.append("\n");
		return true;
	}
	
	
	@SuppressWarnings("unused")
	private String getResumo(ObjetoChaveado obj){
		return obj.getResumo();
	}
	
	private String getResumo(Object obj){
		return obj.toString();
	}
}
