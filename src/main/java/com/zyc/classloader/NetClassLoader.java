package com.zyc.classloader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class NetClassLoader extends ClassLoader {

	private String url;

	public NetClassLoader(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	@Override
	protected Class<?> findClass(String className) throws ClassNotFoundException {
		byte[] bytes = this.getClassBytes(className);

		if (null == bytes) {
			throw new ClassNotFoundException();
		}

		return this.defineClass(className, bytes, 0, bytes.length);
	}

	protected byte[] getClassBytes(String className) {
		String path = this.buildPath(className);

		InputStream is = null;
		ByteArrayOutputStream bytesStream = null;
		try {
			is = new URL(path).openStream();
			bytesStream = new ByteArrayOutputStream();
			byte[] buffer = new byte[4096];
			int len = 0;
			while ((len = is.read(buffer)) != -1) {
				bytesStream.write(buffer, 0, len);
			}
			
			return bytesStream.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (IOException e) {
					// Ignore ...
				}
			}
			
			if(null != bytesStream) {
				try {
					bytesStream.close();
				} catch (IOException e) {
					// Ignore ...
				}
			}
		}

		return null;
	}

	protected String buildPath(String className) {
		return this.getUrl() + "/" + className.replace('.', '/') + ".class";
	}

}
