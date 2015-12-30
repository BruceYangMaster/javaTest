package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestWriteStringFile {
	private static String content = "　这是我做的一个很简单的多线程同步程序，目的是为了测试多线程编程下如何使用同步(synchronized)"
			+ "防止产生竞争共享资源的错误状态，从中得到的心得是：一定要将你所共享的变量封装在一个类中，"
			+ "将所有有关该变量的操作方法都尽可能地封装在包含该变量的类中，并将所有有关读取修改该共享变量的方法都设为同步方法.";

	public static void main(String[] args) {

		File file = new File("E:/java测试", "panda.jpg");
		// writeStringToFile(content, file);
		// readStringFromFile(file);
		File imageFile = new File("E:/java测试", "xiongmao.jpg");
		try {
			imageFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		copyImageFile(imageFile, new File("E:/javatest", "panda.jpg"));
	}

	

	// 判断方法
	//
	// 1.boolean canExecute()判断文件是否可执行
	// 2.boolean canRead()判断文件是否可读
	// 3.boolean canWrite() 判断文件是否可写
	// 4.boolean exists() 判断文件是否存在
	// 5.boolean isDirectory()
	// 6.boolean isFile()
	// 7.boolean isHidden()
	// 8.boolean isAbsolute()判断是否是绝对路径 文件不存在也能判断
	//
	// 获取方法
	//
	// 1.String getName()
	// 2.String getPath()
	// 3.String getAbsolutePath()
	// 4.String getParent()//如果没有父目录返回null
	// 5.long lastModified()//获取最后一次修改的时间
	// 6.long length()
	// 7.boolean renameTo(File f)
	// 8.File[] liseRoots()//获取机器盘符
	// 9.String[] list()
	// 10.String[] list(FilenameFilter filter)
	//

	/**
	 * 复制图片文件
	 * 
	 * @param imageDir
	 * @param imageResource
	 */
	public static void copyImageFile(File imageDir, File imageResource) {
		try {
			FileInputStream fis = new FileInputStream(imageResource);
			byte[] b = new byte[fis.available()];
			fis.read(b);
			FileOutputStream fos = new FileOutputStream(imageDir);
			fos.write(b);
			fis.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 将字符串写到文件中
	 * 
	 * @param content
	 * @param file
	 */
	public static void writeStringToFile(String content, File file) {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			byte[] b = content.getBytes();
			fos.write(b);
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 从文件中读取字符串
	 * 
	 * @param file
	 * @return
	 */
	public static String readStringFromFile(File file) {
		FileInputStream fis = null;
		String content = null;
		try {
			fis = new FileInputStream(file);
			byte[] b = new byte[fis.available()];
			fis.read(b);
			content = new String(b);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(content);
		return content;
	}
}
