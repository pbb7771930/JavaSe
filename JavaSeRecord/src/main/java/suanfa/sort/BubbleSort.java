package suanfa.sort;

import java.util.Arrays;

/*
https://www.runoob.com/w3cnote/ten-sorting-algorithm.html
冒泡排序
比较相邻的元素。如果第一个比第二个大，就交换他们两个(就是把大的数往后移)。
对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
针对所有的元素重复以上的步骤，除了最后一个。
持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 */
public class BubbleSort  {

    public int[] sort(int[] arr) throws Exception {
        // 排序前输出
        System.out.println("排序前输出");
        for (int j : arr) {
            System.out.print(j + ",");
        }
        //外层循环控制排序趟数,n个数就是n次，每次将最大的数放到数组末尾
        for (int i = 1; i < arr.length; i++) {
            //内层循环控制每一趟排序多少次
            // 比较相邻的两个数，每一次比较后的结果会将最大的数放到 arr[arr.length-i]的位置
            for (int j = 0; j < arr.length - i; j++) {
                //如果前面的数比后面的大，就交换位置
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        //输出数组
        System.out.println();
        System.out.println("排序后输出");
        for (int j : arr) {
            System.out.print(j + ",");
        }
        return arr;
    }

    public static void main(String[] args) throws Exception {
        BubbleSort bs = new BubbleSort();
        bs.sort(new int[]{4,7,1,9,8,10,22,45,32,12,34,57,13,86,69});
    }
}
