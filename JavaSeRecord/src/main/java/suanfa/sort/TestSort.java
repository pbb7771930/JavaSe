package suanfa.sort;

/**
 * @author pbb
 * @date
 * @apiNote
 */
public class TestSort {

    //写算法
    public int[] sort(int[] arr) throws Exception{
        // 排序前输出
        System.out.println("排序前输出");
        for (int i : arr) {
            System.out.print(i + ",");
        }
        //冒泡排序

        //排序后输出数组
        System.out.println();
        System.out.println("排序后输出");
        for (int i: arr) {
            System.out.print(i + ",");
        }
        return arr;
    }


    public static void main(String[] args) throws Exception {
        TestSort bs = new TestSort();
        bs.sort(new int[]{4,7,1,9,8,10,22,45,32,12,34,57,13,86,69});
    }
}
