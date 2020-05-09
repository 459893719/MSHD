package com.miaosha.demo;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLTest {

	@Test
	public void test() throws IOException {
		String urlString="";
		int timeOutMillSeconds=2000;
		long lo = System.currentTimeMillis();
        URL url;   
        url = new URL(urlString);  
        URLConnection co =  url.openConnection();
        co.setConnectTimeout(timeOutMillSeconds);
        //assertEquals(co.connect(),true);
	}

}
