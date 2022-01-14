package DesignModel.Proxy.StaticProxy;

/**
 * @author pbb
 * @apiNote
 */
public class PrinterProxy implements IPrinter{
    private IPrinter printer;
    public PrinterProxy(){
        this.printer = new Printer();
    }
    @Override
    public void print() {
        System.out.println("记录日志");
        printer.print();
    }
}
