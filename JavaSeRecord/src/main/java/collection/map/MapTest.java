package collection.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest {
	/*
	 * map遍历方法
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,String> map = new HashMap<String, String>();
        map.put("item1", "value1");
        map.put("item2", "value2");
        map.put("item3", "value3");
        map.put("item4", "value4");
        map.put("item5", "value5");
        System.out.println(map.hashCode());
        //第三种  普遍使用,二次取值  通过Map.keySet遍历key和value：
        for(String key:map.keySet()){
            System.out.println(key+"/"+map.get(key));
        }
        System.out.println("---------------------------------");
        //第四种  通过Map.values()遍历所有的value，但不能遍历key
        for(String v:map.values()){
            System.out.println("value:"+v);
        }
        System.out.println("---------------------------------");
        //第二种遍历方法 推荐，尤其是容量大时
        for(Map.Entry<String, String> entry:map.entrySet()){
            System.out.println(entry.getKey()+"/"+entry.getValue());
        }
        System.out.println("---------------------------------");

        //第一种遍历方法
        Set<String> set = map.keySet();
        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            String str = it.next();
            System.out.println(str+"/"+map.get(str));
        }
        System.out.println("+++++++++++++++++++++");
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, String> entry = iterator.next();
            System.out.println(entry.getKey()+"/"+entry.getValue());
        }

	}

}
