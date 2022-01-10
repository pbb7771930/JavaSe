package suanfa.sort;

import java.util.Arrays;
/*
插入排序
将第一待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。
从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。（如果待插入的元素与有序序列中的某个元素相等，则将待插入元素插入到相等元素的后面。）
 */
public class InsertSort {
    public int[] sort(int[] sourceArray) throws Exception {
        // 对 arr 进行拷贝，不改变参数内容。
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < arr.length; i++) {

            // 要插入的数据先拿出来保存
            int tmp = arr[i];

            //从已经排序的序列最右边的开始往左比较，找到比其小的数
            int j = i;
            //循环往左比较
            while (j > 0 && tmp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            // 存在比其小的数，插入
            if (j != i) {
                arr[j] = tmp;
            }

        }
        //输出数组
        System.out.println();
        for (int j : arr) {
            System.out.print(j + ",");
        }
        return arr;
    }
    public static void main(String[] args) throws Exception {
        InsertSort is = new InsertSort();
        is.sort(new int[]{4,7,1,9,8,10,22,45,32,12,34,57,13,86,69});
    }
}
