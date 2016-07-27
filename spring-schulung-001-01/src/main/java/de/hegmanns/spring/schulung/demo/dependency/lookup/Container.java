package de.hegmanns.spring.schulung.demo.dependency.lookup;

public interface Container {
    Object getDependency(String key);
}
