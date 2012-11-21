package cleiton.unisul.piweb.ferramentasVisuais.client.util;

import com.google.gwt.event.shared.GwtEvent;

public class FecharPopUpEvent extends GwtEvent<FecharPopUpEventHandler>{

	@Override
	public FecharPopUpEventType getAssociatedType() {
		return FecharPopUpEventType.get();
	}

	@Override
	protected void dispatch(FecharPopUpEventHandler handler) {
		handler.fecharPopUp();
	}

}
