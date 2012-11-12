package cleiton.unisul.piweb.client.validacao;


public class CompositeCNPJ extends CompositeMascara {
	
	private static CompositeCNPJ singParaMascara=new CompositeCNPJ();
	
	private static CompositeCNPJ singParaMascara(){
		if(singParaMascara==null){
			singParaMascara=new CompositeCNPJ();
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
	

		
}

