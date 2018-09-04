package com.zyc.classloader;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;

import org.junit.Test;

public class FileClassLoaderTest {
	
	@Test
	public void test() {
		String dir = "C:\\class";
		FileClassLoader loader = new FileClassLoader(dir);
		
		try {
			Class<?> clazz = loader.loadClass("demo.test.User");
			String str = clazz.newInstance().toString();
			System.out.println(str);
			assertEquals(str.startsWith("demo.test.User"), true);
			for (Field field : clazz.getDeclaredFields()) {
				System.out.println(field.getName());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
