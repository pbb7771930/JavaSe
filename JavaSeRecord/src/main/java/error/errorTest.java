package error;

/*
从来测试各种报错
 */

import java.util.ArrayList;
import java.util.List;

public class errorTest {

    /**
    测试内存溢出-HeapOutOfMemory的报错
    当Old代已经满，Eden代已经满，这时候如果还有新的对象产生，GC没有回收，则会报：java.lang.OutOfMemoryError: Java heap space
     */
    public void heapOutOfMemoryDemo() throws InterruptedException {
        List<Object> list = new ArrayList<Object>();
        int i =0;
        //数组一直增加对象
        while (true){
            if(i < 20){
                i ++ ;
                Thread.sleep(1000);
            }
            list.add(new Object());
        }
    }



    public static void main(String[] args) throws InterruptedException {
        new errorTest().heapOutOfMemoryDemo();
    }
}
