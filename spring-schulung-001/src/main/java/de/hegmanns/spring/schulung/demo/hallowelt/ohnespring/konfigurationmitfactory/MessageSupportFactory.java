package de.hegmanns.spring.schulung.demo.hallowelt.ohnespring.konfigurationmitfactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.Properties;

import de.hegmanns.spring.schulung.demo.hallowelt.ohnespring.extended.MessageProvider;
import de.hegmanns.spring.schulung.demo.hallowelt.ohnespring.extended.MessageRenderer;
import de.hegmanns.spring.schulung.demo.hallowelt.ohnespring.konfiguration.HalloWeltKonfiguration;

public class MessageSupportFactory {

	private static MessageSupportFactory instance;
	
	static{
		instance = new MessageSupportFactory();
	}
	
	private MessageRenderer renderer;
	private MessageProvider provider;
	
	private static Optional<Properties> loadProperties(String path){
		String absolutePath = HalloWeltKonfiguration.class.getClassLoader().getResource(path).getPath();
		File initFile = new File(absolutePath);
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(initFile));
			return Optional.of(properties);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}
	
	private static <T> Optional<T> createInstance(String classname){
		try {
			return Optional.ofNullable((T) Class.forName(classname).newInstance());
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			return Optional.empty();
		}
	}
	
	private MessageSupportFactory(){
		Optional<Properties> properties = loadProperties("hellowelt.properties");
		
		String messageRendererClassname = properties.map((p) -> p.getProperty("renderer")).orElseThrow(() -> new RuntimeException(""));
		String messageProviderClassname = properties.map((p) -> p.getProperty("provider")).orElseThrow(() -> new RuntimeException(""));

		
		Optional<MessageRenderer> messageRenderer = createInstance(messageRendererClassname);
		Optional<MessageProvider> messageProvider = createInstance(messageProviderClassname);
		messageRenderer.ifPresent((r) -> r.setMessageProvider(messageProvider.get()));

		renderer = messageRenderer.orElseThrow(() -> new RuntimeException("Renderer nicht initialisiert"));
		provider = messageProvider.orElseThrow(() -> new RuntimeException("Provider nicht initialisiert"));
	}
	
	public MessageRenderer getMessageRenderer(){
		return renderer;
	}
	
	public static MessageSupportFactory instance(){
		return instance;
	}
	
	
}
