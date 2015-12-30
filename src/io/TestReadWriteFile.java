package io;

import java.io.File;
import java.io.IOException;

public class TestReadWriteFile {
	private static File dictionary;
	private static File file1;
	private static int flag = 0;

	public static void main(String[] args) {
		// dictionary = createDictionary("E:", "java测试");
		// file1 = createFile(dictionary.getAbsolutePath(), "java", "pdf");
		deleteFile("E:/java测试", "新建文件.txt");
	}

	/**
	 * 删除文件
	 * 
	 * @param filePath文件路径
	 * @param fileName文件名字
	 */
	public static void deleteFile(String filePath, String fileName) {
		File myDelFile = null;

		if (filePath != null && fileName != null) {
			myDelFile = new File(filePath, fileName);
		}
		if (myDelFile != null && myDelFile.exists()) {
			myDelFile.delete();
			System.out.println("删除文件--" + myDelFile.getName() + "成功!");
		} else {
			System.out.println("删除文件--" + myDelFile.getName() + "出错!");
		}

	}

	/**
	 * 创建文件夹 mkdir --mkdirs
	 * 
	 * @param filePath文件夹路径
	 * @param fileName文件名字
	 * @return
	 */

	public static File createDictionary(String filePath, String fileName) {
		File dictionary = new File(filePath, fileName);
		dictionary.mkdirs();// mkdir是创建目录，只是创建一级目录，而且必须是已经存在的目录下创建目录。
							// mkdirs可以创建多级目录，可以在不存在的目录下创建多级目录，
		System.out.println("文件绝对路径》》" + dictionary.getAbsolutePath());
		System.out.println("文件名字》》" + dictionary.getAbsolutePath());
		return dictionary;
	}

	/**
	 * 创建文件
	 * 
	 * @param filePath文件路径
	 * @param fileName文件名字
	 * @param type文件类型
	 * @return
	 */
	public static File createFile(String filePath, String fileName, String type) {

		if (type == null) {
			type = "txt";
		}
		if (fileName == null) {

			if (flag == 0) {
				fileName = "新建文件";
			} else {
				fileName = "新建文件" + flag;
			}
			flag++;

		}
		String fileNames = fileName + "." + type;
		File file1 = new File(filePath, fileNames);
		if (!file1.exists()) {
			try {
				file1.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("文件绝对路径》》" + file1.getAbsolutePath());
		System.out.println("文件名字》》" + file1.getName());
		System.out.println("文件路径》》" + file1.getPath());
		return file1;
	}
}
