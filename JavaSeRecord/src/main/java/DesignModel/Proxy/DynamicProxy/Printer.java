package DesignModel.Proxy.DynamicProxy;

import DesignModel.Proxy.StaticProxy.IPrinter;

/**
 * @author pbb
 * @apiNote
 */
public class Printer implements IPrinter {
    @Override
    public void print() {
            System.out.println("打印！");
        }
}
