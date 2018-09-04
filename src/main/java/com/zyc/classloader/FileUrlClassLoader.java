package com.zyc.classloader;

import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandlerFactory;

public class FileUrlClassLoader extends URLClassLoader {

	public FileUrlClassLoader(URL[] urls) {
		super(urls);
	}
	
	public FileUrlClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    public FileUrlClassLoader(URL[] urls, ClassLoader parent, URLStreamHandlerFactory factory) {
        super(urls, parent, factory);
    }
}
