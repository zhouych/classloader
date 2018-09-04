package com.zyc.classloader;

import org.junit.Test;

public class NetClassLoaderTest {

	@Test
	public void test() throws Exception {
		String url = "";
		NetClassLoader loader = new NetClassLoader(url);
		Class<?> clazz = loader.loadClass("");
		System.out.println(clazz.newInstance().toString());
	}
	
}
