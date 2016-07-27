package de.hegmanns.spring.schulung.demo.dependency.lookup;

public class CDLExample {
    public static void main(String[] args) {
    	Container container = new DefaultContainer();

    	ManagedComponent managedComponent = new ContextualizedDependencyLookup();
    	managedComponent.performLookup(container);

    	System.out.println(managedComponent);
    }
}
