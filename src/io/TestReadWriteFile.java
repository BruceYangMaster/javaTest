package io;

import java.io.File;
import java.io.IOException;

public class TestReadWriteFile {
	private static File dictionary;
	private static File file1;
	private static int flag = 0;

	public static void main(String[] args) {
		// dictionary = createDictionary("E:", "java����");
		// file1 = createFile(dictionary.getAbsolutePath(), "java", "pdf");
		deleteFile("E:/java����", "�½��ļ�.txt");
	}

	/**
	 * ɾ���ļ�
	 * 
	 * @param filePath�ļ�·��
	 * @param fileName�ļ�����
	 */
	public static void deleteFile(String filePath, String fileName) {
		File myDelFile = null;

		if (filePath != null && fileName != null) {
			myDelFile = new File(filePath, fileName);
		}
		if (myDelFile != null && myDelFile.exists()) {
			myDelFile.delete();
			System.out.println("ɾ���ļ�--" + myDelFile.getName() + "�ɹ�!");
		} else {
			System.out.println("ɾ���ļ�--" + myDelFile.getName() + "����!");
		}

	}

	/**
	 * �����ļ��� mkdir --mkdirs
	 * 
	 * @param filePath�ļ���·��
	 * @param fileName�ļ�����
	 * @return
	 */

	public static File createDictionary(String filePath, String fileName) {
		File dictionary = new File(filePath, fileName);
		dictionary.mkdirs();// mkdir�Ǵ���Ŀ¼��ֻ�Ǵ���һ��Ŀ¼�����ұ������Ѿ����ڵ�Ŀ¼�´���Ŀ¼��
							// mkdirs���Դ����༶Ŀ¼�������ڲ����ڵ�Ŀ¼�´����༶Ŀ¼��
		System.out.println("�ļ�����·������" + dictionary.getAbsolutePath());
		System.out.println("�ļ����֡���" + dictionary.getAbsolutePath());
		return dictionary;
	}

	/**
	 * �����ļ�
	 * 
	 * @param filePath�ļ�·��
	 * @param fileName�ļ�����
	 * @param type�ļ�����
	 * @return
	 */
	public static File createFile(String filePath, String fileName, String type) {

		if (type == null) {
			type = "txt";
		}
		if (fileName == null) {

			if (flag == 0) {
				fileName = "�½��ļ�";
			} else {
				fileName = "�½��ļ�" + flag;
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

		System.out.println("�ļ�����·������" + file1.getAbsolutePath());
		System.out.println("�ļ����֡���" + file1.getName());
		System.out.println("�ļ�·������" + file1.getPath());
		return file1;
	}
}
