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
			Class<?> clazz = loader.loadClass("com.zyc.classloader.tmps.User");
			String str = clazz.newInstance().toString();
			System.out.println(str);
			assertEquals(str.startsWith("com.zyc.classloader.tmps"), true);
			for (Field field : clazz.getDeclaredFields()) {
				System.out.println(field.getName());
			}
			System.out.println();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test2() throws Exception {
		String dir = "C:\\class";
		FileClassLoader loader1 = new FileClassLoader(dir);
		FileClassLoader loader2 = new FileClassLoader(dir);
		System.out.println(loader1.hashCode());
		System.out.println(loader2.hashCode());
		
		String className = "com.zyc.classloader.tmps.User";
        Class<?> clazz1 = loader1.findClass(className);
        Class<?> clazz11 = loader1.findClass(className);
        Class<?> clazz2 = loader2.findClass(className);
		System.out.println(clazz1.hashCode());
		System.out.println(clazz11.hashCode());
		System.out.println(clazz2.hashCode());

		System.out.println();
	}
}
