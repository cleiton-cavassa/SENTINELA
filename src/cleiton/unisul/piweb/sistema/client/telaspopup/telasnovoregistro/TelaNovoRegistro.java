package cleiton.unisul.piweb.sistema.client.telaspopup.telasnovoregistro;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import cleiton.unisul.piweb.ferramentasVisuais.client.util.CriadorTela;
import cleiton.unisul.piweb.rpc.client.ServicoArmazenamento;
import cleiton.unisul.piweb.rpc.shared.ObjetoChaveado;
import cleiton.unisul.piweb.sistema.client.bloqueio.TelaComBloqueio;
import cleiton.unisul.piweb.sistema.client.bloqueio.TelaPadraoBloqueada;
import cleiton.unisul.piweb.sistema.client.persistencia.TelaPersistencia;

public abstract class TelaNovoRegistro 
<T extends ObjetoChaveado> extends Composite 
implements TelaComBloqueio, TelaPersistencia<T>, TelaLimpavel{
	
	protected abstract boolean validar();
	protected abstract Widget getWidgetTelaDesbloqueada();
//	protected abstract Button getBotaoSalvar();
	
	@Override
	public abstract T getObjeto();
	@Override
	public abstract void setObjeto(T objeto);
	
	protected Command salvarCommand(){return salvarCommand;}
	private final Command salvarCommand=new Command(){@Override public void execute() {salvar();}};	
	
	protected TelaPadraoBloqueada compositeTelaBloqueada ;
//	private Widget widgetTelaDesbloqueada;
	

	
	public TelaNovoRegistro() {
//		widgetTelaDesbloqueada=getWidgetTelaDesbloqueada();
		compositeTelaBloqueada =new TelaPadraoBloqueada();
		compositeTelaBloqueada.setVisible(false);
//		try{
//			getBotaoSalvar().addClickHandler(new ClickHandler() {
//				@Override
//				public void onClick(ClickEvent event) {
//					salvarCommand().execute();
//				}
//			});
//		}catch(Throwable tr){}
	}
	
	private void salvar(){
		T obj=getObjeto();
		if(validar()){
			salvar(obj);
		}else{
			Window.alert("Algum campo requerido deixou de ser preenchido.\nTodos os campos marcados com asterisco (*) precisam ser preenchidos.");			
		}
	}


	@Override
	public void salvar(T objeto) {
		final CallbackArmazenamentoNovoRegistro<T> callback=new CallbackArmazenamentoNovoRegistro<T>(objeto, this, this);
		ServicoArmazenamento.getArmazenamento().persistir(objeto,true, false, callback);
		setTelaBloqueada(true); 
	}
	
	private boolean telaBloqueada=false;
	@Override
	public void setTelaBloqueada(boolean telaBloqueada) {
//		if (isTelaBloqueada()==telaBloqueada){
//			return;
//		}
		this.telaBloqueada =telaBloqueada;
		
		if (telaBloqueada){
			compositeTelaBloqueada.getTxtAreaDadosRegistroEmCriacao().setText(getObjeto().getResumo());
			//initWidget(compositeTelaBloqueada);
			getWidgetTelaDesbloqueada().setVisible(false);
			compositeTelaBloqueada.setVisible(true);
		}else{
			//initWidget(widgetTelaDesbloqueada);
			compositeTelaBloqueada.setVisible(false);
			getWidgetTelaDesbloqueada().setVisible(true);
			invocarPendencias();
		}
	}
	
	@Override
	public boolean isTelaBloqueada(){
		return telaBloqueada;
	}


	protected void invocarPendencias(){
		if(compositeTelaBloqueada.isReabrirTelaAutomaticamente()){
			StringBuilder b = new StringBuilder();
			b.append("Uma tentativa de criação de registro chegou ao fim.\n");
			b.append("Foi solicitada abertura automática da tela correspondente, assim que ela estivesse disponível.\n\n");
			b.append("Você ainda deseja abrir a tela?");
			b.append("Mensagem de lembrete:\n");
			b.append(compositeTelaBloqueada.getMensagem());
			if ( Window.confirm(b.toString()) ){
				
			}
			new CriadorTela(this).execute();
		}
	}
}
