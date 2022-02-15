package suanfa.sort;

/**
 * @Author pbb
 * @Description TODO
 * @Date 2022/1/19 14:52
 */
public class TestSort {

    /**
     * @Author pbb
     * @Description TODO
     * @Date 2022/1/19 14:49
     * @return int[]
     */
    public int[] sort(int[] arr) throws Exception{
        // 排序前输出
        System.out.println("排序前输出");
        for (int i : arr) {
            System.out.print(i + ",");
        }
        //冒泡排序
        for (int i = 1; i < arr.length ; i ++){
            for (int j = 0; j < arr.length - i; j ++){

                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }

            }
        }







        //插入排序









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
