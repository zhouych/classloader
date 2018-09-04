package com.zyc.classloader;

import org.junit.Test;

public class NetClassLoaderTest {

	@Test
	public void test() throws Exception {
		String url = "https://github.com/zhouych/classloader/tree/master/src/main/java";
		NetClassLoader loader = new NetClassLoader(url);
		Class<?> clazz = loader.loadClass("com.zyc.classloader.tmps.User");
		System.out.println(clazz.newInstance().toString());
	}
	
}
