package cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl;

import cleiton.unisul.piweb.ferramentasVisuais.client.util.FecharPopUpEventHandler;


public class InputViewCNPJ extends InputViewMascara {
	
	
	@Override
	public String getTitulo(){
		return "Campo para digitar o CNPJ";
	}
	
	private static InputViewCNPJ singParaMascara=new InputViewCNPJ();
	
	private static InputViewCNPJ singParaMascara(){
		if(singParaMascara==null){
			singParaMascara=new InputViewCNPJ();
		}
		return singParaMascara;
	}
	
	public static String mascaraCNPJ(long cnpj){return singParaMascara().mascara(cnpj);}

	@Override
	protected String mascaraPadrao() {
		return "00.000.000/0000-00";
	}

	@Override
	protected String mascara(Long valor) {
		if (valor<0){
			return "";
		}
		StringBuilder b=new StringBuilder(String.valueOf(valor));
		
		while(b.length()<14){
			b.insert(0, "0");
		}
		b.insert(2, ".");
		b.insert(6, ".");
		b.insert(10, "/");
		b.insert(15, "-");
		
		return b.toString();
	}

	@Override
	public String nomeCampo() {
		return "CNPJ";
	}

	@Override
	public boolean setFecharHandler(FecharPopUpEventHandler f) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void fechar() {
		// TODO Auto-generated method stub
		
	}

		
}

