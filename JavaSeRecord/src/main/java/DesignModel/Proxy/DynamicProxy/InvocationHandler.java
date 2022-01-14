package DesignModel.Proxy.DynamicProxy;

import java.lang.reflect.Method;

/**
 * @author pbb
 * @apiNote
 */
public interface InvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
