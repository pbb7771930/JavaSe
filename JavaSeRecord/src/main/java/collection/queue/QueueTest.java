package collection.queue;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/*
 * 队列的遍历
 */
public class QueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> q = new LinkedBlockingQueue<Integer>();
		//初始化队列
		for(int i = 0 ; i < 5 ; i ++){
			q.offer(i);
		}
		System.out.println("--------------1-------------");
		
		//集合方式遍历，元素不会被移除
		for(Integer x : q){
			System.out.println(x);
		}
		System.out.println("--------------2-------------");
		
		//队列方式遍历，元素逐个被移除
		while(q.peek() != null){
			System.out.println(q.poll());
		}
	}

}
