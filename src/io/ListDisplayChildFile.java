package io;

import java.io.File;

public class ListDisplayChildFile {
	public static void main(String[] args) {
		File file = new File("E:/java测试");
		showDir(file);
	}

	/**
	 * 将目录下的file显示出来
	 * 
	 * @param dir
	 */
	public static void showDir(File dir) {
		// E:\java测试
		// E:\java测试\panda1.jpg
		// E:\java测试\xiongmao.jpg
		// E:\java测试\yang.txt
		// E:\java测试\新建文件1.txt

		System.out.println(dir);
		File[] files = dir.listFiles();
		for (File file : files) {
			if (file.isDirectory())
				showDir(file);// 递归
			else
				System.out.println(file);
		}
	}
}
