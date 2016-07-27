package de.hegmanns.spring.schulung.demo.hallowelt.ohnespring.extended;

import java.util.Optional;

public abstract class AbstractMessageRenderer implements MessageRenderer {

	private Optional<MessageProvider> messageProvider = Optional.empty();
	
	@Override
	public final void render() {
		messageProvider.orElseThrow(() -> new RuntimeException("MessageProvider nicht initialisiert."));
//		messageProvider.map(MessageProvider::getMessage)
//			.ifPresent((s) -> renderMessage(s));
//		
		if (messageProvider.isPresent()){
			renderMessage(messageProvider.get().getMessage());
		}
		
	}
	
	protected abstract void renderMessage(String message);

	@Override
	public void setMessageProvider(MessageProvider messageProvider) {
		this.messageProvider = Optional.ofNullable(messageProvider);
	}

}
