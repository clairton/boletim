package br.eti.clairton;

import java.util.HashMap;
import java.util.Map;

public class Container {
    private static Container instance;
    
    private final Map<Class<?>, Class<?>> beans = new HashMap<Class<?>, Class<?>>();
    
    private Container() {}
    
    public static Container getInstance() {
        if (instance == null) {
            instance = new Container();
        }
        return instance;
    }
    
    public <T> void addBean(Class<T> klazz) {
        if (klazz.isInterface()) {
            throw new ContainerException(klazz + " não é um tipo concreto");
        }
        getInstanceBean(klazz);
        for (Class<?> contrato : klazz.getInterfaces()) {
            beans.put(contrato, klazz);
        }
    }
    
    private <T> T getInstanceBean(Class<?> klazz) {
        try {
            @SuppressWarnings("unchecked")
            T bean = ( T ) AutenticavelProxyFactory.newProxy(klazz.newInstance());
            return bean;
        } catch (InstantiationException e) {
            throw new ContainerException("Não foi possível instanciar " + klazz, e);
        } catch (IllegalAccessException e) {
            throw new ContainerException("Não foi possível instanciar " + klazz, e);
        }
    }
    
    public <T> T getBean(Class<?> klazz) {
        if (!klazz.isInterface()) {
            throw new ContainerException(klazz + " não é um tipo abstrato");
        }
        if (beans.containsKey(klazz)) {
            @SuppressWarnings("unchecked")
            T bean = ( T ) getInstanceBean(beans.get(klazz));
            return bean;
        } else {
            throw new ContainerException("Bean para " + klazz + " não encontrado");
        }
    }
}
