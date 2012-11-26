package cleiton.unisul.piweb.ferramentasVisuais.client.inputview.impl;


public class InputViewCPF extends InputViewMascara {
	
	@Override
	public String getTitulo(){
		return "Campo para digitar o CPF";
	}
	
	private static InputViewCPF singParaMascara=new InputViewCPF();
	
	private static InputViewCPF singParaMascara(){
		if(singParaMascara==null){
			singParaMascara=new InputViewCPF();
		}
		return singParaMascara;
	}
	
	public static String mascaraCPF(long cpf){return singParaMascara().mascara(cpf);}

	public InputViewCPF(){
		digitador.setMaxLength(11);
		digitador.setVisibleLength(13);
	}
	
	@Override
	protected String mascaraPadrao() {
		return "000.000.000-00";
	}

	@Override
	protected String mascara(Long valor) {
		if (valor<0){
			return "";
		}
		StringBuilder b=new StringBuilder(String.valueOf(valor));

		while(b.length()<11){
			b.insert(0, "0");
		}
		b.insert(3, ".");
		b.insert(7, ".");
		b.insert(11, "-");

		return b.toString();
	}

	@Override
	public String nomeCampo() {
		return "CPF";
	}	
			
}

