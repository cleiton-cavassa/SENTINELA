package cleiton.unisul.piweb.ferramentasVisuais.client.util;

import com.google.gwt.event.shared.GwtEvent.Type;

public class FecharPopUpEventType extends Type<FecharPopUpEventHandler>{
	private static FecharPopUpEventType get;
	public static FecharPopUpEventType get(){
		if (get==null){
			get=new FecharPopUpEventType ();
		}
		return get;
	}
	private FecharPopUpEventType(){} 
}
