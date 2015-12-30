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
	 * ����hash
	 */
	public static void iteratorHash2() {
		Map<String, String> hashTable = new Hashtable<String, String>();
		hashTable.put("wangliming", "wangliming");
		hashTable.put("zhuyun", "zhuyun");

		// ��ȡ��Map�����е�key ��key���ŵ���һ��set������
		Set<String> keySet = hashTable.keySet();
		// ��ȡ�����е�key���ϵ� ������
		Iterator<String> it = keySet.iterator();
		while (it.hasNext()) {
			// �������е�key ���һ�ȡ������key
			String key = it.next();
			System.out.println(key);
			// ͨ������key �� Map���ҵ���Ӧ��value
			System.out.println(hashTable.get(key));
		}

	}

	/**
	 * ����hashmap��key��value������Ϊnull
	 */
	public static void testHashMap() {
		HashMap hashMap = new HashMap();
		hashMap.put(null, null);
	}

	/**
	 * 
	 * ����hashtable��key��value������Ϊnull ,key�����ظ���ֻ�Ǻ���İ�ǰ��ĸ��ǵ���
	 * 
	 */
	public static void iteratorHashTable1() {
		Hashtable<String, String> hashTable = new Hashtable<String, String>();
		// java.lang.NullPointerException
		hashTable.put("a", "1");
		hashTable.put("a", "2");
		hashTable.put("a", "1");
		// key�����ظ���ֻ�Ǻ���İ�ǰ��ĸ��ǵ���
		hashTable.put("b", "2");
		hashTable.put("c", "3");

		Set<Entry<String, String>> enterySet = hashTable.entrySet();
		System.out.println(enterySet);// [b=2, a=1, c=3]
		Iterator<Entry<String, String>> it = enterySet.iterator();
		Entry<String, String> entry;
		while (it.hasNext()) {
			// ȡ��entry����
			entry = it.next();
			// ȡ��entry��key ����map�����key
			System.out.print(entry.getKey() + entry.getValue());// b2a1c3
			// ȡ��entry��value ����map�����value
		}

		// System.out.println(hashTable.size());
		// System.out.println(hashTable.get("a"));
	}

}
