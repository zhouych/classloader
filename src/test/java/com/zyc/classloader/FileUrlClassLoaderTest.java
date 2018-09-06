package com.zyc.classloader;

import java.io.File;
import java.net.URL;

import org.junit.Test;

public class FileUrlClassLoaderTest {
	
	private FileUrlClassLoader loader;

	@Test
	public void test() throws Exception {
		URL[] urls = { new File("C:\\class").toURI().toURL() };
		loader = new FileUrlClassLoader(urls);
		
		Class<?> clazz = loader.loadClass("com.zyc.classloader.tmps.User");
		System.out.println(clazz.newInstance().toString());
	}
}
