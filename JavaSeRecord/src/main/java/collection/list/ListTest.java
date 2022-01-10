package collection.list;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;;

public class ListTest {

	/*
	 * List的四种遍历方法
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>( Arrays.asList("tom","cat","Jane","jerry")); 
		//方法1 集合类的通用遍历方式, 从很早的版本就有, 用迭代器迭代 
		Iterator<String> it1 = list.iterator(); 
		while(it1.hasNext()){ 
			System.out.println(it1.next()); 
		} 
		System.out.println("--------------1-------------");
		//方法2 集合类的通用遍历方式, 从很早的版本就有, 用迭代器迭代 
		for(Iterator<String> it2 = list.iterator();it2.hasNext();){ 
			System.out.println(it2.next()); 
		} 
		System.out.println("--------------2-------------");
		//方法3 增强型for循环遍历 
		for(String value:list){ 
			System.out.println(value); 
		} 
		System.out.println("--------------3-------------");
		//方法4 一般型for循环遍历 
		for(int i = 0;i < list.size(); i ++){ 
			System.out.println(list.get(i)); 
		}

	}

}
