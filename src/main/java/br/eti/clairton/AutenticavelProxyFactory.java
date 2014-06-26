package br.eti.clairton;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AutenticavelProxyFactory {
    private static class AutenticavelProxy implements InvocationHandler {
        private final Object wrapper;
        
        private AutenticavelProxy(Object wrapper) {
            this.wrapper = wrapper;
        }
        
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Permissao.validar(wrapper.getClass(), method.getName());
            return method.invoke(wrapper, args);
        }
    }
    
    public static <T>T newProxy(Object object) {
        final ClassLoader cl = object.getClass().getClassLoader();
        final Class<?>[] interfaces = object.getClass().getInterfaces();
        final InvocationHandler handler = new AutenticavelProxy(object);
        @SuppressWarnings("unchecked")
        final T proxy = ( T ) Proxy.newProxyInstance(cl, interfaces, handler);
        return proxy;
    }
}
