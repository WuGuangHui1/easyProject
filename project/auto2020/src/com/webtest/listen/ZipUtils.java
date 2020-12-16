package com.webtest.listen;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
public class ZipUtils {
	private static final int BUFFER_SIZE = 2 * 1024;
	/**
	 * 
	 * ZIP fangfa1
	 * 
	 * @param srcDir           
	 * 
	 * @param out              
	 * 
	 * @param KeepDirStructure 
	 * 
	 *                         false:
	 * 
	 * @throws RuntimeException 
	 * 
	 */
	public static void toZip(String srcDir, OutputStream out, boolean KeepDirStructure)
			throws RuntimeException {
		long start = System.currentTimeMillis();
		ZipOutputStream zos = null;
		try {
			zos = new ZipOutputStream(out);
			File sourceFile = new File(srcDir);
			compress(sourceFile, zos, sourceFile.getName(), KeepDirStructure);
			long end = System.currentTimeMillis();
			System.out.println("yasuowanchenghaoshi:"+ (end - start) + "ms");
		} catch (Exception e) {
			throw new RuntimeException("zip error from ZipUtils", e);
		} finally {
			if (zos != null) {
				try {
					zos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * 
	 * fangfa2
	 * 
	 * @param srcFiles 
	 * 
	 * @param out      
	 * 
	 * @throws RuntimeException 
	 * 
	 */
	public static void toZip(List<File> srcFiles, OutputStream out) throws RuntimeException {
		long start = System.currentTimeMillis();
		ZipOutputStream zos = null;
		try {
			zos = new ZipOutputStream(out);
			for (File srcFile : srcFiles) {
				byte[] buf = new byte[BUFFER_SIZE];
				zos.putNextEntry(new ZipEntry(srcFile.getName()));
				int len;
				FileInputStream in = new FileInputStream(srcFile);
				while ((len = in.read(buf)) != -1) {
					zos.write(buf, 0, len);
				}
				zos.closeEntry();
				in.close();
			}
			long end = System.currentTimeMillis();
			System.out.println("yasuohaoshi"+ (end-start) + "ms");
		} catch (Exception e) {
			throw new RuntimeException("zip error from ZipUtils", e);
		} finally {
			if (zos != null) {
				try {
					zos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	
	private static void compress(File sourceFile, ZipOutputStream zos, String name,
			boolean KeepDirStructure) throws Exception {
		byte[] buf = new byte[BUFFER_SIZE];
		if (sourceFile.isFile()) {
			zos.putNextEntry(new ZipEntry(name));
			int len;
			FileInputStream in = new FileInputStream(sourceFile);
			while ((len = in.read(buf)) != -1) {
				zos.write(buf, 0, len);
			}
			// Complete the entry
			zos.closeEntry();
			in.close();
		} else {
			File[] listFiles = sourceFile.listFiles();
			if (listFiles == null || listFiles.length == 0) {
				if (KeepDirStructure) {
		
					zos.putNextEntry(new ZipEntry(name + "/"));
					zos.closeEntry();
				}
			} else {
				for (File file : listFiles) {
					if (KeepDirStructure) {
						compress(file, zos, name + "/" + file.getName(), KeepDirStructure);
					} else {
						compress(file, zos, file.getName(), KeepDirStructure);
					}
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		/** 测试压缩方法1 */
		FileOutputStream fos1 = new FileOutputStream(new File("c:/mytest01.zip"));
		ZipUtils.toZip("D:/log", fos1, true);
		/** 测试压缩方法2 */
		List<File> fileList = new ArrayList<>();
		fileList.add(new File("D:/Java/jdk1.7.0_45_64bit/bin/jar.exe"));
		fileList.add(new File("D:/Java/jdk1.7.0_45_64bit/bin/java.exe"));
		FileOutputStream fos2 = new FileOutputStream(new File("c:/mytest02.zip"));
		ZipUtils.toZip(fileList, fos2);
	}
}

