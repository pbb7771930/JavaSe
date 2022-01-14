package DesignModel.Proxy.DynamicProxy;

/**
 * @author pbb
 * @apiNote
 */
public class Test {
    public static void main(String[] args){
        ProxyHandler proxyHandler=new ProxyHandler();
        IPrinter printer=(IPrinter) proxyHandler.newProxyInstance(new Printer());
        printer.print();
    }
}
