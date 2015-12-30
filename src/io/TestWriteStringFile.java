package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestWriteStringFile {
	private static String content = "������������һ���ܼ򵥵Ķ��߳�ͬ������Ŀ����Ϊ�˲��Զ��̱߳�������ʹ��ͬ��(synchronized)"
			+ "��ֹ��������������Դ�Ĵ���״̬�����еõ����ĵ��ǣ�һ��Ҫ����������ı�����װ��һ�����У�"
			+ "�������йظñ����Ĳ��������������ܵط�װ�ڰ����ñ��������У����������йض�ȡ�޸ĸù�������ķ�������Ϊͬ������.";

	public static void main(String[] args) {

		File file = new File("E:/java����", "panda.jpg");
		// writeStringToFile(content, file);
		// readStringFromFile(file);
		File imageFile = new File("E:/java����", "xiongmao.jpg");
		try {
			imageFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		copyImageFile(imageFile, new File("E:/javatest", "panda.jpg"));
	}

	

	// �жϷ���
	//
	// 1.boolean canExecute()�ж��ļ��Ƿ��ִ��
	// 2.boolean canRead()�ж��ļ��Ƿ�ɶ�
	// 3.boolean canWrite() �ж��ļ��Ƿ��д
	// 4.boolean exists() �ж��ļ��Ƿ����
	// 5.boolean isDirectory()
	// 6.boolean isFile()
	// 7.boolean isHidden()
	// 8.boolean isAbsolute()�ж��Ƿ��Ǿ���·�� �ļ�������Ҳ���ж�
	//
	// ��ȡ����
	//
	// 1.String getName()
	// 2.String getPath()
	// 3.String getAbsolutePath()
	// 4.String getParent()//���û�и�Ŀ¼����null
	// 5.long lastModified()//��ȡ���һ���޸ĵ�ʱ��
	// 6.long length()
	// 7.boolean renameTo(File f)
	// 8.File[] liseRoots()//��ȡ�����̷�
	// 9.String[] list()
	// 10.String[] list(FilenameFilter filter)
	//

	/**
	 * ����ͼƬ�ļ�
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
	 * ���ַ���д���ļ���
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
	 * ���ļ��ж�ȡ�ַ���
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
