package com.qf.theMap;

import java.util.HashMap;

public class Test_1 {
/*����: ͳ���ַ�����ÿ���ַ����ֵĴ���
 * ���� abaabcfgddddqhiidcd
 * ��ӡ��� a(3) b(2) c(2)
 * ����:
 * ���� ��ĸ �� ���ִ���֮�� ��ӳ���ϵ -->map����
 * a  --> 1
 * a  --> 2 i++
 * */
	public static void main(String[] args) {
		String str = "abaabcfgddddqhiidcd";
		char[] arr = str.toCharArray(); //���ַ����е��ַ�ȡ��
		HashMap<Character,Integer> hm = new HashMap<>();
		for(char c : arr) {
			//��ͨд��
			if(!hm.containsKey(c)) { //��������������
				hm.put(c, 1);//�ͽ�����ֵΪ1 �����Map������
			}else {//������������
				hm.put(c, hm.get(c)+1);//�ͽ� �� �� ֵ+1��ӽ���
			}
			//��Ԫ�����д��
			//hm.put(c, !hm.containsKey(c) ? 1 : hm.get(c)+1);
		}
		for(Character key : hm.keySet()) {
			System.out.println(key+"("+hm.get(key)+")");
		}
	}

}








