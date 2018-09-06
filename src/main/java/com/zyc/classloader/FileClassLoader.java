package com.zyc.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileClassLoader extends ClassLoader {
	
	private	String directory;

	public FileClassLoader(String directory) {
		this.directory = directory;
	}
	
	public String getDirectory() {
		return directory;
	}
	
	@Override
	protected Class<?> findClass(String className) throws ClassNotFoundException {
		byte[] classByte = this.getClassByte(className);
		
		if(null == classByte) {
			 throw new ClassNotFoundException();
		}
		
		return this.defineClass(className, classByte, 0, classByte.length);
	}

	protected byte[] getClassByte(String className) {
		String path = this.buildPath(className);
		
		InputStream is = null;
		ByteArrayOutputStream bytesStream = null;
		try {
			 is = new FileInputStream(path);
			 bytesStream = new ByteArrayOutputStream();
			 byte[] buffer = new byte[2048];
			 int len = 0;
			 while ((len = is.read(buffer)) != -1) {
				 bytesStream.write(buffer, 0, len);
			 }
			 return bytesStream.toByteArray();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(null != bytesStream) {
				try {
					bytesStream.close();
				} catch (IOException e) {
					// Ignore ...
				}
			}
			if(null != is) {
				try {
					is.close();
				} catch (IOException e) {
					// Ignore ...
				}
			}
		}
		
		return null;
	}
	
	protected String buildPath(String className) {
		return this.getDirectory() + File.separatorChar + className.replace('.', File.separatorChar) + ".class";
	}
}
