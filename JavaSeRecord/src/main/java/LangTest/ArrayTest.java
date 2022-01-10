package LangTest;
import java.util.Arrays;

/**
Array是静态的，你无法一旦创建了一个数组就无法更改它的大小；in[] array = new [10]; 初始化时就决定的数组的长度
ArrayList是动态的,可以自动扩展
 * @author admin
 */
public class ArrayTest {
    public static void main(String[] args) {
        //数组初始化方法
        //1. 直接给每个元素赋值
        int[] arr = new int[]{11,44,33,22};
        //2. 给一部分赋值，后面的全部为0
        int[] arr1 = new int[]{1,2};
        //3. 由赋值参数个数决定数组的个数
        int[] arr2 = {1,2};
        //4. 数组元素的值是随机分配的
        int[] arr3 = {};

        //数组排序
        Arrays.sort(arr);
        //遍历方法
        for(int i : arr){
            System.out.println(i);
        }


        //多维数组
        int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("a的长度" + a.length);
        System.out.println("a[0]的长度" + a[0].length);
        System.out.println("a[1]的长度" + a[1].length);
        System.out.println("a[2]的长度" + a[2].length);






    }



}
