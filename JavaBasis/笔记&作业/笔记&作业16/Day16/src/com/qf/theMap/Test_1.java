package com.qf.theMap;

import java.util.HashMap;

public class Test_1 {
/*需求: 统计字符串中每个字符出现的次数
 * 例如 abaabcfgddddqhiidcd
 * 打印结果 a(3) b(2) c(2)
 * 分析:
 * 发现 字母 和 出现次数之间 有映射关系 -->map集合
 * a  --> 1
 * a  --> 2 i++
 * */
	public static void main(String[] args) {
		String str = "abaabcfgddddqhiidcd";
		char[] arr = str.toCharArray(); //将字符串中的字符取出
		HashMap<Character,Integer> hm = new HashMap<>();
		for(char c : arr) {
			//普通写法
			if(!hm.containsKey(c)) { //如果不包含这个键
				hm.put(c, 1);//就将键和值为1 添加入Map集合中
			}else {//如果包含这个键
				hm.put(c, hm.get(c)+1);//就将 键 和 值+1添加进来
			}
			//三元运算符写法
			//hm.put(c, !hm.containsKey(c) ? 1 : hm.get(c)+1);
		}
		for(Character key : hm.keySet()) {
			System.out.println(key+"("+hm.get(key)+")");
		}
	}

}








