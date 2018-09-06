package com.zyc.classloader;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;

import org.junit.Test;

public class NetClassLoaderTest {

	@Test
	public void test() throws Exception {
		String url = "https://raw.githubusercontent.com/zhouych/classloader/master/src/main/java";
		NetClassLoader loader = new NetClassLoader(url);
		Class<?> clazz = loader.loadClass("com.zyc.classloader.tmps.User");
		String str = clazz.newInstance().toString();
		System.out.println(str);
		assertEquals(str.startsWith("com.zyc.classloader.tmps"), true);
		for (Field field : clazz.getDeclaredFields()) {
			System.out.println(field.getName());
		}
	}
	
}
