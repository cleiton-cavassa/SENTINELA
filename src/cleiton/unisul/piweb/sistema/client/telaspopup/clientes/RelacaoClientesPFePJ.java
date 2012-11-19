//package cleiton.unisul.piweb.sistema.client.telaspopup.clientes;
//
//import java.util.List;
//
//import cleiton.unisul.piweb.rpc.server.ServicoArmazenamento;
//import cleiton.unisul.piweb.rpc.shared.objetoschaveados.antigos.ClientesPFePJ;
//import cleiton.unisul.piweb.sistema.client.telaspopup.clientes.clientespf.CadastroClientesPF;
//import cleiton.unisul.piweb.sistema.client.telaspopup.clientes.clientespj.CadastroClientesPJ;
//import cleiton.unisul.piweb.sistema.client.telaspopup.clientes.clientespj.CriarNovoClientePJ;
//import cleiton.unisul.piweb.sistema.client.util.CriadorTela;
//import cleiton.unisul.piweb.sistema.client.validacao.CompositeCNPJ;
//
//import com.google.gwt.cell.client.ButtonCell;
//import com.google.gwt.cell.client.FieldUpdater;
//import com.google.gwt.user.cellview.client.CellTable;
//import com.google.gwt.user.cellview.client.Column;
//import com.google.gwt.user.cellview.client.TextColumn;
//import com.google.gwt.user.client.Window;
//import com.google.gwt.user.client.rpc.AsyncCallback;
//import com.google.gwt.user.client.ui.Composite;
//import com.google.gwt.user.client.ui.FlowPanel;
//import com.google.gwt.user.client.ui.HasHorizontalAlignment;
//import com.google.gwt.user.client.ui.Label;
//import com.google.gwt.user.client.ui.VerticalPanel;
//import com.google.gwt.view.client.ListDataProvider;
//
//public class RelacaoClientesPFePJ extends Composite {
//	private CellTable<ClientesPFePJ> tabela;
//	
//	private static RelacaoClientesPFePJ get=new RelacaoClientesPFePJ();
//	
//	public static RelacaoClientesPFePJ get(){
//		if(get==null){
//			get=new RelacaoClientesPFePJ();
//		}
//		get.atualizar();
//		return get;
//	}
//	
//	
//	final ListDataProvider<ClientesPFePJ> dataProvider = new ListDataProvider<ClientesPFePJ>();
//	final String strPositivo="Sim";
//	final String strNegativo="Nao";
//	
//	private RelacaoClientesPFePJ() {
//		
//		FlowPanel flowPanel = new FlowPanel();
//		flowPanel.setStyleName("painelCadastro");
//		initWidget(flowPanel);
//		flowPanel.setSize("808px", "");
//		
//		Label lblSentinelaPessoas = new Label("SENTINELA - Pessoas F\u00EDsicas e Pessoas Jur\u00EDdicas vinculadas");
//		lblSentinelaPessoas.setStyleName("h1");
//		lblSentinelaPessoas.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
//		flowPanel.add(lblSentinelaPessoas);
//		lblSentinelaPessoas.setSize("", "");
//		
//		VerticalPanel verticalPanel = new VerticalPanel();
//		flowPanel.add(verticalPanel);
//		verticalPanel.setWidth("100%");
//		
//		CellTable<ClientesPFePJ> cellTable = new CellTable<ClientesPFePJ>();
//		verticalPanel.add(cellTable);
//		cellTable.setWidth("100%");
//		
//		TextColumn<ClientesPFePJ> textColumn = new TextColumn<ClientesPFePJ>() {
//			public String getValue(ClientesPFePJ dados) {
////				return CompositeCPF.mascaraCPF(dados.getClientePF().getChave());
//				return null;
//			}
//		};
//		cellTable.addColumn(textColumn, "CPF");
//		
//		TextColumn<ClientesPFePJ> textColumn_1 = new TextColumn<ClientesPFePJ>() {
//			public String getValue(ClientesPFePJ dados) {
////				return dados.getClientePF().getNome();
//				return null;
//			}
//		};
//		cellTable.addColumn(textColumn_1, "Nome");
//		
//		Column<ClientesPFePJ, String> column = new Column<ClientesPFePJ, String>(new ButtonCell()) {
//			public String getValue(ClientesPFePJ object) {
//				return "editar PF";
//			}
//		};
//		cellTable.addColumn(column);
//		Column<ClientesPFePJ,String> colBotoesPF=column;
//		colBotoesPF.setFieldUpdater(new FieldUpdater<ClientesPFePJ, String>(){
//			@Override
//			public void update(int index, ClientesPFePJ object, String value) {
//				CadastroClientesPF c =CadastroClientesPF.get();
////				c.setCliente(object.getClientePF());
//				new CriadorTela(c).execute();				
//			}
//			
//		});
//		
//		
//		
//		TextColumn<ClientesPFePJ> textColumn_2 = new TextColumn<ClientesPFePJ>() {
//			public String getValue(ClientesPFePJ dados) {
//				if (dados.getClientePJ()==null){
//					return "";
//				}
//				return CompositeCNPJ.mascaraCNPJ(dados.getClientePJ().getChave());
//			}
//		};
//		cellTable.addColumn(textColumn_2, "CNPJ");
//		
//		TextColumn<ClientesPFePJ> textColumn_3 = new TextColumn<ClientesPFePJ>() {
//			public String getValue(ClientesPFePJ dados) {
//				if (dados.getClientePJ()==null){
//					return "";
//				}
//				return dados.getClientePJ().getRazaoSocial();
//			}
//		};
//		cellTable.addColumn(textColumn_3, "Raz\u00E3o Social");
//		
//		Column<ClientesPFePJ, String> column_1 = new Column<ClientesPFePJ, String>(new ButtonCell()) {
//			public String getValue(ClientesPFePJ object) {
//				if(object.isPJexisteNaBaseDeDados()){
//					return "editar PJ";
//				}else{
//					return "criar PJ com esse CNPJ";
//				}
//			}
//		};
//		cellTable.addColumn(column_1);
//		
//		Column<ClientesPFePJ,String> colBotoesPJ=column_1;
//		colBotoesPJ.setFieldUpdater(new FieldUpdater<ClientesPFePJ, String>(){
//			@Override
//			public void update(int index, ClientesPFePJ object, String value) {
//				Composite c;
//				if(object.isPJexisteNaBaseDeDados()){
//					c =CadastroClientesPJ.get();
//					((CadastroClientesPJ)c).setCliente(object.getClientePJ());
//				}else{
//					c =CriarNovoClientePJ.get();
//					((CriarNovoClientePJ)c).setCliente(object.getClientePJ());
//				}
//				new CriadorTela(c).execute();
//			}
//			
//		});
//		
//		tabela=cellTable;
//		dataProvider.addDataDisplay(tabela);		
//		atualizar();
//	}
//
//	
//	
//	public void atualizar(){
//		AsyncCallback<List<ClientesPFePJ>> a= new CallbackArmazenamento(dataProvider);
//		try {
//			ServicoArmazenamento.getArmazenamento().montarLista(new ClientesPFePJ(), a);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}		
//	}
//	
//	private class CallbackArmazenamento implements AsyncCallback<List<ClientesPFePJ>>{
//		ListDataProvider<ClientesPFePJ> prov;
//		public CallbackArmazenamento(ListDataProvider<ClientesPFePJ> dtPr){
//			prov=dtPr;
//		}
//		
//		@Override
//		public void onSuccess(List<ClientesPFePJ> result) {
//			prov.setList(result);
//			//Window.alert("Sucesso!\nClientesPFePJ");
//		}
//		
//		@Override
//		public void onFailure(Throwable caught) {
//			// TODO Auto-generated method stub
//			
//			Window.alert("Problemas...\n\n"+caught.getMessage());
//		}
//	}
//
//}
