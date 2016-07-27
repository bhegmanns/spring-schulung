package de.hegmanns.spring.schulung.demo.dependency.lookup;

public class ContextualizedDependencyLookup implements ManagedComponent {
    private Dependency dependency;

    @Override
    public void performLookup(Container container) {
        this.dependency = (Dependency) container.getDependency("myDependency"); 
    }

    @Override
    public String toString() {
    	return dependency.toString();
    }
}
