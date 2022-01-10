package collection.list;

import java.util.Stack;

/*
 * 栈的遍历
 */
public class StackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> s = new Stack<Integer>();
		//数据插入
		for(int i = 0; i < 10; i ++){
			s.push(i);
		}
		//集合遍历
		for(Integer x : s){
			System.out.println(x);
		}
		System.out.println("--------------1-------------");
		
		//栈弹出遍历方式
		//while (s.peek()!=null) {     //不健壮的判断方式，容易抛异常，正确写法是下面的
		while(!s.empty()){
			System.out.println(s.pop());
		}

	}

}
