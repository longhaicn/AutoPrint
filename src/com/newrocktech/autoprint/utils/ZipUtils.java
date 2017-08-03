package com.newrocktech.autoprint.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtils {
	public static boolean ZipMultiFile(String filepath, String zippath) {
		int len = 0;
		try {
			File file = new File(filepath);// Ҫ��ѹ�����ļ���
			File zipFile = new File(zippath);
			InputStream input = null;
			ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
			if (file.isDirectory()) {
				File[] files = file.listFiles();
				len = files.length;
				for (int i = 0; i < len; ++i) {
					input = new FileInputStream(files[i]);
					zipOut.putNextEntry(new ZipEntry(file.getName() + File.separator + files[i].getName()));
					int temp = 0;
					while ((temp = input.read()) != -1) {
						zipOut.write(temp);
					}
					input.close();
				}
			}
			zipOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (0 == len) {
			return false;
		} else {
			return true;
		}

	}

	public static void deleteFile(String rootPath, char c, String BIN) {
		File fr = new File(rootPath);
		String ip = "172." + ((int) c - 64);
		// System.out.println(ip+"deleteFile"+BIN);
		if (fr.isDirectory()) {
			File ff[] = fr.listFiles();
			if (ff.length > 0) {
				for (int i = 0; i < ff.length; i++) {
					String filename = ff[i].getName();
					if (filename.contains(ip) && filename.contains(BIN)) {
						ff[i].delete();
					}

				}
			}

		}

	}

	public static void copyFolder(String oldPath, String newPath) {

		try {
			(new File(newPath)).mkdirs(); // ����ļ��в����� �������ļ���
			File a = new File(oldPath);
			String[] file = a.list();
			File temp = null;
			for (int i = 0; i < file.length; i++) {
				if (oldPath.endsWith(File.separator)) {
					temp = new File(oldPath + file[i]);
				} else {
					temp = new File(oldPath + File.separator + file[i]);
				}

				if (temp.isFile()) {
					FileInputStream input = new FileInputStream(temp);
					FileOutputStream output = new FileOutputStream(newPath + "/" + (temp.getName()).toString());
					byte[] b = new byte[1024 * 5];
					int len;
					while ((len = input.read(b)) != -1) {
						output.write(b, 0, len);
					}
					output.flush();
					output.close();
					input.close();
				}
				if (temp.isDirectory()) {// ��������ļ���
					copyFolder(oldPath + "/" + file[i], newPath + "/" + file[i]);
				}
			}
		} catch (Exception e) {
			System.out.println("���������ļ������ݲ�������");
			e.printStackTrace();

		}

	}
}
