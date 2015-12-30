package io;

import java.io.File;

public class ListDisplayChildFile {
	public static void main(String[] args) {
		File file = new File("E:/java����");
		showDir(file);
	}

	/**
	 * ��Ŀ¼�µ�file��ʾ����
	 * 
	 * @param dir
	 */
	public static void showDir(File dir) {
		// E:\java����
		// E:\java����\panda1.jpg
		// E:\java����\xiongmao.jpg
		// E:\java����\yang.txt
		// E:\java����\�½��ļ�1.txt

		System.out.println(dir);
		File[] files = dir.listFiles();
		for (File file : files) {
			if (file.isDirectory())
				showDir(file);// �ݹ�
			else
				System.out.println(file);
		}
	}
}
