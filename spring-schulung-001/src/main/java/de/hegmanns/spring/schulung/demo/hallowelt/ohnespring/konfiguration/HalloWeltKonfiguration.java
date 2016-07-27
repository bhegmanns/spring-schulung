package de.hegmanns.spring.schulung.demo.hallowelt.ohnespring.konfiguration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.Properties;

import de.hegmanns.spring.schulung.demo.hallowelt.ohnespring.extended.MessageProvider;
import de.hegmanns.spring.schulung.demo.hallowelt.ohnespring.extended.MessageRenderer;

public class HalloWeltKonfiguration {

	public static void main(String [] args){
		
		Optional<Properties> properties = loadProperties("hellowelt.properties");
		
		String messageRendererClassname = properties.map((p) -> p.getProperty("renderer")).orElseThrow(() -> new RuntimeException(""));
		String messageProviderClassname = properties.map((p) -> p.getProperty("provider")).orElseThrow(() -> new RuntimeException(""));

		Optional<MessageRenderer> messageRenderer = createInstance(messageRendererClassname);
		Optional<MessageProvider> messageProvider = createInstance(messageProviderClassname);
		messageRenderer.ifPresent((r) -> r.setMessageProvider(messageProvider.get()));
		
		messageRenderer.ifPresent(MessageRenderer::render);
	}
	
	public static Optional<Properties> loadProperties(String path){
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
	
	public static <T> Optional<T> createInstance(String classname){
		try {
			return Optional.ofNullable((T) Class.forName(classname).newInstance());
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			return Optional.empty();
		}
	}
}
