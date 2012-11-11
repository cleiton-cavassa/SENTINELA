package cleiton.unisul.piweb.client.classesabstratas;



import cleiton.unisul.piweb.client.util.CriadorTela;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public abstract class CadastroNovaPessoa extends Composite {

	
	private Composite eu;
	public CadastroNovaPessoa(Composite eu) {
		this.eu=eu;
	}

	
	protected abstract Widget getWidgetTelaDesbloqueada();
	
	public boolean isReabrirTelaAutomaticamente() {
		return telaBloqueada.isReabrirTelaAutomaticamente();
	}

	public String getMensagem() {
		return telaBloqueada.getMensagem();
	}
	
	
	protected Widget getTelaBloqueada(){
		return telaBloqueada;  
	}
	
	private TelaBloqueada telaBloqueada=new TelaBloqueada();
	
	private boolean telabloqueada;
	public boolean isTelabloqueada() {
		return telabloqueada;
	}

	public void setTelabloqueada(boolean telabloqueada) {
		this.telabloqueada = telabloqueada;
		if(telabloqueada){
//			eu.initWidget(getTelaBloqueada());
		}else{
//			eu.initWidget(getWidgetTelaDesbloqueada());
		}
	}

	protected void invocarPendencias(){
		if(this.isReabrirTelaAutomaticamente()){
			StringBuilder b = new StringBuilder();
			b.append("Uma tentativa de criação de registro chegou ao fim.\n");
			b.append("Foi solicitada abertura automática da tela correspondente, assim que ela estivesse disponível.\n\n");
			b.append("Você ainda deseja abrir a tela?");
			b.append("Mensagem de lembrete:\n");
			b.append(this.getMensagem());
			if ( Window.confirm(b.toString()) ){
				
			}
			new CriadorTela(this).execute();
		}
	}
}
