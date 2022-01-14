package DesignModel.Proxy.StaticProxy;

/**
 * @author pbb
 * @apiNote
 */
public class LogPrinter extends Printer{
    @Override
    /*
    这个类继承了打印机的类，重写了打印机的print方法，提供了记录日志的功能，以后需要打印机的时候使用这个类就好。问题似乎得到了解决，我们可以在这个解决方案的基础上进一步的优化：
     */
    public void print(){
        System.out.println("记录日志！");
        System.out.println("打印！");
    }
}
