package collection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TestCollection {
	public static void main(String[] args) {
		// testHashMap();
		// iteratorHashTable1();
		iteratorHash2();
	}

	/**
	 * 遍历hash
	 */
	public static void iteratorHash2() {
		Map<String, String> hashTable = new Hashtable<String, String>();
		hashTable.put("wangliming", "wangliming");
		hashTable.put("zhuyun", "zhuyun");

		// 获取到Map中所有的key ，key被放到了一个set集合中
		Set<String> keySet = hashTable.keySet();
		// 获取到所有的key集合的 迭代器
		Iterator<String> it = keySet.iterator();
		while (it.hasNext()) {
			// 遍历所有的key 并且获取到各个key
			String key = it.next();
			System.out.println(key);
			// 通过各个key 从 Map中找到对应的value
			System.out.println(hashTable.get(key));
		}

	}

	/**
	 * 测试hashmap。key和value都可以为null
	 */
	public static void testHashMap() {
		HashMap hashMap = new HashMap();
		hashMap.put(null, null);
	}

	/**
	 * 
	 * 测试hashtable，key和value都不能为null ,key可以重复，只是后面的把前面的覆盖掉了
	 * 
	 */
	public static void iteratorHashTable1() {
		Hashtable<String, String> hashTable = new Hashtable<String, String>();
		// java.lang.NullPointerException
		hashTable.put("a", "1");
		hashTable.put("a", "2");
		hashTable.put("a", "1");
		// key可以重复，只是后面的把前面的覆盖掉了
		hashTable.put("b", "2");
		hashTable.put("c", "3");

		Set<Entry<String, String>> enterySet = hashTable.entrySet();
		System.out.println(enterySet);// [b=2, a=1, c=3]
		Iterator<Entry<String, String>> it = enterySet.iterator();
		Entry<String, String> entry;
		while (it.hasNext()) {
			// 取得entry对象
			entry = it.next();
			// 取得entry的key 就是map里面的key
			System.out.print(entry.getKey() + entry.getValue());// b2a1c3
			// 取得entry的value 就是map里面的value
		}

		// System.out.println(hashTable.size());
		// System.out.println(hashTable.get("a"));
	}

}
