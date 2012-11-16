package cleiton.unisul.piweb.sistema.client.bloqueio;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.SimpleCheckBox;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.TextBox;

public class TelaPadraoBloqueada extends Composite {
	private CheckBox chckbxAbrirEstaTela;
	private TextBox textBox;
	private TextArea txtrDadosNoInformados;
	
	public boolean isReabrirTelaAutomaticamente() {
		return chckbxAbrirEstaTela.getValue();
	}

	public void setReabrirTelaAutomaticamente(boolean reabrirTelaAutomaticamente) {
		chckbxAbrirEstaTela.setValue(reabrirTelaAutomaticamente);
	}

	public String getMensagem() {
		return textBox.getText();
	}

	public void setMensagem(String mensagem) {
		textBox.setText(mensagem);
	}
	
	public TelaPadraoBloqueada() {
		
		VerticalPanel verticalPanel = new VerticalPanel();
		initWidget(verticalPanel);
		verticalPanel.setSize("620px", "100%");
		
		Label lblTelaBloqueadaOperao = new Label("Tela Bloqueada! Opera\u00E7\u00E3o de persist\u00EAncia em curso...");
		lblTelaBloqueadaOperao.setStyleName("tituloTelaBloqueada");
		lblTelaBloqueadaOperao.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.add(lblTelaBloqueadaOperao);
		
		Label lblNewLabel = new Label("Est\u00E1 sendo efetuada uma tentativa de cria\u00E7\u00E3o de registro. Por favor, volte mais tarde.");
		verticalPanel.add(lblNewLabel);
		
		FlowPanel flowPanel = new FlowPanel();
		verticalPanel.add(flowPanel);
		
		Label lblPorFavorVolte = new Label("Dados do registro em processo de cria\u00E7\u00E3o:");
		lblPorFavorVolte.setStyleName("tituloDadosRegistro");
		verticalPanel.add(lblPorFavorVolte);
		
		txtrDadosNoInformados = new TextArea();
		txtrDadosNoInformados.setReadOnly(true);
		txtrDadosNoInformados.setText("Dados n\u00E3o informados...");
		txtrDadosNoInformados.setStyleName("dadosRegistro");
		verticalPanel.add(txtrDadosNoInformados);
		txtrDadosNoInformados.setSize("592px", "152px");
		
		chckbxAbrirEstaTela = new CheckBox("abrir tela automaticamente assim que a tentativa de cria\u00E7\u00E3o de registro cessar");
		verticalPanel.add(chckbxAbrirEstaTela);
		
 
		
		Label lblMensagemDeLembrete = new Label("mensagem de lembrete:");
		verticalPanel.add(lblMensagemDeLembrete);
		
		textBox = new TextBox();
		verticalPanel.add(textBox);
		textBox.setWidth("592px");
		setStyleName("estiloTelaBloqueada");

	}

	public CheckBox getChckbxAbrirEstaTela() {
		return chckbxAbrirEstaTela;
	}
	public TextBox getTextBoxMensagem() {
		return textBox;
	}
	public TextArea getTxtAreaDadosRegistroEmCriacao() {
		return txtrDadosNoInformados;
	}
}
