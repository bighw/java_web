
    /**  
    * @Title: PropertiesTest.java
    * @Package com.harvey.test
    * @Description: TODO(用一句话描述该文件做什么)
    * @author rose
    * @Email  rose@maizuo.com
    * @date 2016年3月25日
    * @version V1.0  
    */
    
package com.harvey.learn;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;

import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;
import com.google.common.collect.Ordering;
import com.google.common.collect.Range;
import com.google.common.collect.Sets;
import com.google.common.io.Files;
import com.google.common.primitives.Ints;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.gson.Gson;
import com.harvey.entity.Student;


    /**
 * @ClassName: PropertiesTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author rose
 * @Email  rose@maizuo.com
 * @date 2016年3月25日
 *
 */

public class PropertiesTest {
	@Test
	public void testA(){
		Properties pros = new Properties();
		Resource re = new PathResource("E:\\WORK\\serverConfig.properties");
		try {
			FileOutputStream fos = new FileOutputStream(new File("E:\\WORK\\test.md"));
			PrintWriter pw = new PrintWriter(fos,true);
			pw.println("**mobileif公共配置项**");
			pw.println();
			pw.println("|业务键|业务值|描述|");
			pw.println("|---|---|---|");
			pros.load(re.getInputStream());
			for(Entry<Object, Object> entry : pros.entrySet()){
				String line = "| "+entry.getKey()+" | "+entry.getValue()+" |       |";
				pw.println(line);
			}
			pw.flush();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	@Test
	public void testB(){
		URL url = getClass().getResource("/index.html");
		try {
			System.out.println(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testC(){
		ImmutableMap<String,String> map = ImmutableMap.of("key1", "value1", "key2", "value2");
		ImmutableList<String> of = ImmutableList.of("a", "b", "c", "d");

		for(Map.Entry<String, String> entry : map.entrySet()){
			System.out.println(entry.getKey()+" : "+entry.getValue());
		}
		for(String str : of){
			System.out.println(str);
		}
	}
	@Test
	public void testD(){
		File file = new File(getClass().getResource("/index.html").getFile());
		List<String> lines = null;
		try {
		  lines = Files.readLines(file, Charsets.UTF_8);
		  for(String str : lines){
			  System.out.println(str);
		  }
		} catch (IOException e) {
		  e.printStackTrace();
		}
	}
	@Test
	public void testE(){
		String string = CharMatcher.DIGIT.retainFrom("some text 89983 and more");
		System.out.println(string);
	}
	@Test
	public void testF(){
		Optional<Integer> possible = Optional.of(5);

	    System.out.println(possible.isPresent());; // returns true

	    System.out.println(possible.get());; // returns 5
	}
	@Test
	public void testG(){
		Preconditions.checkNotNull("a");
	}
	@Test
	public void testH(){
		Student student = new Student();
		String str = new String("a");
		System.out.println("a" == str);
		System.out.println(Objects.equal("a", str));
		System.out.println(Objects.equal(str, null));
		System.out.println(Objects.toStringHelper(Student.class).add("name", student.getName()).toString());;
	}
	@Test
	public void testI(){
		Ordering<String> byLengthOrdering = new Ordering<String>() {
			@Override
			public int compare(String left, String right) {
				return Ints.compare(left.length(), right.length());
			}
		};
		ArrayList<String> list = new ArrayList<String>();
		list.add("abcd");
		list.add("ab");
		list.add("abc");
		
		Collections.sort(list, byLengthOrdering);
		System.out.println(list.toString());
	}
	
	
	@Test
	public void testJ(){
		Student s1 = new Student();
		s1.setAge(13);
		Student s2 = new Student();
		s2.setAge(10);
		Student s3 = new Student();
		s3.setAge(13);
		Student s4 = new Student();
		s4.setAge(18);
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		Ordering<Student> ordering = Ordering.natural().onResultOf(new Function<Student, Integer>() {
		      public Integer apply(Student foo) {
		        return foo.getAge();
		      }
		    });
		Collections.sort(students, ordering);
		for(Student student : students){
			System.out.println(student.getAge());
		}
	}
	@Test
	public void testK(){
		Range<Double> range = Range.open(1.0, 12.0);
		System.out.println(range.contains(5.0));
		
	}
	@Test
	public void testL(){
		List<String> list = Lists.newArrayList("a","b","c");
		Joiner joiner = Joiner.on(":").useForNull("");
		System.out.println(joiner.join(list));
	}
	@Test
	public void testM(){
		Splitter splitter = Splitter.on("|");
		System.out.println(splitter.split("abc|abac|adaf").toString());
		
		for(String str : Lists.newArrayList(splitter.split("abc|abac|adaf"))){
			System.out.println(str);
		}
	}
	@Test
	public void testN(){
		String str = CharMatcher.JAVA_ISO_CONTROL.removeFrom("abcontrolint");
		System.out.println(str);
	}
	@Test
	public void testO(){
		Multiset<String> m = HashMultiset.create();
		m.add("a");
		m.add("b");
		m.add("a");
		for(Multiset.Entry<String> entry: m.entrySet()){
			System.out.println(entry.getElement()+":"+entry.getCount());			
		}
		System.out.println(m.count("a"));
		Gson gson = new Gson();
		System.out.println(gson.toJson(m));
	}
	@Test
	public void testP(){
		String[] strs = new String[3];
		strs[0] = "hello";
		strs[1] = "World";
		strs[2] = "hello";
//		List<String> list1 = Arrays.asList(strs);
////		list1.remove(1);
//		List<String> list2 = Lists.newArrayList(strs);
//		list2.remove(1);
//		System.out.println(list2.toString());
		Set<String> set = Sets.newHashSet(strs);
		System.out.println(set.toString());
	}
	@SuppressWarnings("unchecked")
	@Test
	public void testQ(){
		ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
	    ListenableFuture explosion = service.submit(new Callable<Student>() {
	      public Student call() {
	    	  Student student = new Student();
	    	  student.setAge(12);
	    	  return student;
	      }
	    });
	    try {
			System.out.println(explosion.get().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    Futures.addCallback(explosion, new FutureCallback<Student>() {
	      public void onFailure(Throwable thrown) {
	    	 System.out.println(thrown.getMessage());
	      }

		@Override
		public void onSuccess(Student result) {
			// TODO Auto-generated method stub
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(result.getAge());
		}
	    });
	    
	    System.out.println("game over");
	}
	
	@Test
	public void testR(){
		List<String> list = Lists.newArrayList("ab","c");
		System.out.println(list.contains("b"));
	}
	@Test
	public void testS(){
		
	}
	
	@Test
	public void tesT(){
		String MAIZUO_ALL_IPS = "10.45.52.214,114.55.8.44,10.46.75.190,120.27.146.102,10.24.27.99,114.55.2.206,10.47.105.36,120.27.152.116,10.24.27.114,114.55.29.198,10.24.27.105,114.55.29.165,10.45.52.10,114.55.9.251,10.46.76.243,120.27.141.150,10.24.27.110,114.55.29.23,10.24.28.81,114.55.30.119,10.24.28.107,114.55.30.106,10.45.53.64,114.55.11.4,10.47.97.146,120.27.142.21,10.24.28.106,114.55.30.114,10.24.28.101,114.55.30.107,10.24.28.100,114.55.30.57,10.24.28.73,114.55.30.62,10.24.28.79,114.55.30.118,10.24.28.84,114.55.27.49,10.24.27.178,114.55.29.196,10.45.53.40,114.55.10.203,10.47.63.70,121.196.230.118,10.24.27.183,114.55.2.173,10.24.25.125,114.55.29.228,10.24.25.193,114.55.27.223,10.24.25.98,114.55.27.222,10.45.53.4,114.55.8.139,10.47.108.15,120.27.140.177,10.24.17.97,114.55.27.72,10.24.25.34,114.55.27.104,10.24.25.33,114.55.27.68,10.24.25.24,114.55.26.130,10.24.25.39,114.55.1.171,10.45.53.29,114.55.9.143,10.47.107.229,120.27.152.81,10.24.25.22,114.55.26.172,10.45.52.152,114.55.8.102,10.45.35.28,114.55.6.93,10.45.35.43,114.55.6.173,10.45.34.186,114.55.6.165,10.47.100.105,120.27.144.220,10.47.95.85,120.27.143.0,10.47.98.28,120.27.142.222,10.47.94.67,120.27.139.150,10.47.89.16,120.27.134.21,10.46.78.211,120.27.134.65,10.47.89.4,120.27.133.249,10.47.132.158,114.215.241.157,10.161.157.230,115.29.184.90,10.162.33.139,115.29.174.82,10.162.61.22,115.29.251.174,10.165.4.250,114.215.180.166,10.161.220.222,115.29.197.237,10.161.147.178,115.29.184.224,10.162.98.185,114.215.177.30,10.161.130.226,115.29.161.218,10.161.145.130,115.29.161.100,10.165.14.156,115.29.209.211,10.162.34.175,115.29.173.164,10.162.48.93,112.124.116.130,10.162.19.75,115.29.236.108,10.165.33.251,112.124.116.135,10.161.160.53,115.29.174.134,10.162.97.83,218.244.139.162,10.165.5.65,218.244.142.1,10.161.132.252,115.29.229.6,10.161.181.64,115.29.188.186,10.161.136.154,115.29.231.27,10.165.33.77,218.244.132.145,10.162.64.136,115.29.249.231,10.162.68.209,218.244.130.212,10.132.33.170,121.199.40.167,10.162.79.4,112.124.127.139,10.161.211.68,114.215.209.114,10.162.79.39,114.215.237.223,10.162.70.231,112.124.127.161,10.162.48.138,114.215.236.97,10.162.79.40,112.124.118.104,10.162.70.67,114.215.237.212,10.132.4.222,121.199.0.196,10.161.232.119,114.215.200.115,10.162.100.38,114.215.168.187,10.122.82.203,115.29.29.240,10.132.3.55,121.199.12.105,10.161.232.118,114.215.192.226,10.162.100.238,114.215.183.205,10.132.14.147,121.199.1.182,10.162.100.227,114.215.187.185,10.162.90.84,10.162.90.169,10.161.208.51,114.215.188.202,10.161.208.46,10.161.208.47,10.132.19.193,121.199.53.152,10.122.70.232,115.29.13.24,10.122.70.228,10.161.150.237,115.29.236.48,10.160.5.153,10.161.144.192,10.160.46.7,10.161.191.159,10.160.4.165,10.161.144.32,112.124.100.117,10.160.46.71,112.124.45.176,10.161.191.149,112.124.108.155,10.160.3.38,112.124.11.51,10.161.143.222,112.124.100.129,10.160.46.130,112.124.46.69,10.161.191.13,112.124.108.126,10.160.46.171,112.124.45.68,10.160.45.186,112.124.43.209,10.160.45.180,10.161.141.118,115.29.228.121,10.122.70.120,115.29.9.211,10.122.69.3,115.29.9.19,10.160.5.57,112.124.12.237,10.161.128.161,115.29.162.79,10.161.167.219,115.29.188.165,10.161.167.214,115.29.175.161,10.161.128.147,115.29.161.116,10.160.30.231,112.124.30.72,10.160.9.234,112.124.16.69,10.132.6.81,121.199.48.67,10.132.39.39,121.199.30.21,10.132.39.40,121.199.30.211,10.132.39.38,121.199.30.209,10.132.39.4,121.199.30.210,10.132.32.151,121.199.24.123,10.200.60.95,42.121.14.2,10.200.125.81,42.121.57.73,10.200.241.89,42.121.114.74,10.135.14.135,42.121.104.81,10.241.115.41,42.120.43.228,10.200.229.231,42.121.67.87,10.200.229.230,42.121.67.86,10.241.86.124,110.76.43.101,10.241.80.201,110.76.43.103,10.241.84.224,110.76.42.99,10.241.95.216,110.76.42.98,10.241.140.3,42.120.51.116,127.0.0.1,192.168.1.1,192.168.1.2,192.168.1.3,192.168.1.4,192.168.1.5,192.168.1.6,192.168.1.7,192.168.1.8,192.168.1.9,192.168.1.10,192.168.1.11,192.168.1.12,192.168.1.13,192.168.1.14,192.168.1.15,192.168.1.16,192.168.1.17,192.168.1.18,192.168.1.19,192.168.1.20,192.168.1.21,192.168.1.22,192.168.1.23,192.168.1.24,192.168.1.25,192.168.1.26,192.168.1.27,192.168.1.28,192.168.1.29,192.168.1.30,192.168.1.31,192.168.1.32,192.168.1.33,192.168.1.34,192.168.1.35,192.168.1.36,192.168.1.37,192.168.1.38,192.168.1.39,192.168.1.40,192.168.1.41,192.168.1.42,192.168.1.43,192.168.1.44,192.168.1.45,192.168.1.46,192.168.1.47,192.168.1.48,192.168.1.49,192.168.1.50,192.168.1.51,192.168.1.52,192.168.1.53,192.168.1.54,192.168.1.55,192.168.1.56,192.168.1.57,192.168.1.58,192.168.1.59,192.168.1.60,192.168.1.61,192.168.1.62,192.168.1.63,192.168.1.64,192.168.1.65,192.168.1.66,192.168.1.67,192.168.1.68,192.168.1.69,192.168.1.70,192.168.1.71,192.168.1.72,192.168.1.73,192.168.1.74,192.168.1.75,192.168.1.76,192.168.1.77,192.168.1.78,192.168.1.79,192.168.1.80,192.168.1.81,192.168.1.82,192.168.1.83,192.168.1.84,192.168.1.85,192.168.1.86,192.168.1.87,192.168.1.88,192.168.1.89,192.168.1.90,192.168.1.91,192.168.1.92,192.168.1.93,192.168.1.94,192.168.1.95,192.168.1.96,192.168.1.97,192.168.1.98,192.168.1.99,192.168.1.100,192.168.1.101,192.168.1.102,192.168.1.103,192.168.1.104,192.168.1.105,192.168.1.106,192.168.1.107,192.168.1.108,192.168.1.109,192.168.1.110,192.168.1.111,192.168.1.112,192.168.1.113,192.168.1.114,192.168.1.115,192.168.1.116,192.168.1.117,192.168.1.118,192.168.1.119,192.168.1.120,192.168.1.121,192.168.1.122,192.168.1.123,192.168.1.124,192.168.1.125,192.168.1.126,192.168.1.127,192.168.1.128,192.168.1.129,192.168.1.130,192.168.1.131,192.168.1.132,192.168.1.133,192.168.1.134,192.168.1.135,192.168.1.136,192.168.1.137,192.168.1.138,192.168.1.139,192.168.1.140,192.168.1.141,192.168.1.142,192.168.1.143,192.168.1.144,192.168.1.145,192.168.1.146,192.168.1.147,192.168.1.148,192.168.1.149,192.168.1.150,192.168.1.151,192.168.1.152,192.168.1.153,192.168.1.154,192.168.1.155,192.168.1.156,192.168.1.157,192.168.1.158,192.168.1.159,192.168.1.160,192.168.1.161,192.168.1.162,192.168.1.163,192.168.1.164,192.168.1.165,192.168.1.166,192.168.1.167,192.168.1.168,192.168.1.169,192.168.1.170,192.168.1.171,192.168.1.172,192.168.1.173,192.168.1.174,192.168.1.175,192.168.1.176,192.168.1.177,192.168.1.178,192.168.1.179,192.168.1.180,192.168.1.181,192.168.1.182,192.168.1.183,192.168.1.184,192.168.1.185,192.168.1.186,192.168.1.187,192.168.1.188,192.168.1.189,192.168.1.190,192.168.1.191,192.168.1.192,192.168.1.193,192.168.1.194,192.168.1.195,192.168.1.196,192.168.1.197,192.168.1.198,192.168.1.199,192.168.1.200,192.168.1.201,192.168.1.202,192.168.1.203,192.168.1.204,192.168.1.205,192.168.1.206,192.168.1.207,192.168.1.208,192.168.1.209,192.168.1.210,192.168.1.211,192.168.1.212,192.168.1.213,192.168.1.214,192.168.1.215,192.168.1.216,192.168.1.217,192.168.1.218,192.168.1.219,192.168.1.220,192.168.1.221,192.168.1.222,192.168.1.223,192.168.1.224,192.168.1.225,192.168.1.226,192.168.1.227,192.168.1.228,192.168.1.229,192.168.1.230,192.168.1.231,192.168.1.232,192.168.1.233,192.168.1.234,192.168.1.235,192.168.1.236,192.168.1.237,192.168.1.238,192.168.1.239,192.168.1.240,192.168.1.241,192.168.1.242,192.168.1.243,192.168.1.244,192.168.1.245,192.168.1.246,192.168.1.247,192.168.1.248,192.168.1.249,192.168.1.250,192.168.1.251,192.168.1.252,192.168.1.253,192.168.1.254,192.168.1.255";
		String MAIZUO_INNER_IPS = "10.45.52.214,10.46.75.190,10.24.27.99,10.47.105.36,10.24.27.114,10.24.27.105,10.45.52.10,10.46.76.243,10.24.27.110,10.24.28.81,10.24.28.107,10.45.53.64,10.47.97.146,10.24.28.106,10.24.28.101,10.24.28.100,10.24.28.73,10.24.28.79,10.24.28.84,10.24.27.178,10.45.53.40,10.47.63.70,10.24.27.183,10.24.25.125,10.24.25.193,10.24.25.98,10.45.53.4,10.47.108.15,10.24.17.97,10.24.25.34,10.24.25.33,10.24.25.24,10.24.25.39,10.45.53.29,10.47.107.229,10.24.25.22,10.45.52.152,10.45.35.28,10.45.35.43,10.45.34.186,10.47.100.105,10.47.95.85,10.47.98.28,10.47.94.67,10.47.89.16,10.46.78.211,10.47.89.4,10.47.132.158,10.161.157.230,10.162.33.139,10.162.61.22,10.165.4.250,10.161.220.222,10.161.147.178,10.162.98.185,10.161.130.226,10.161.145.130,10.165.14.156,10.162.34.175,10.162.48.93,10.162.19.75,10.165.33.251,10.161.160.53,10.162.97.83,10.165.5.65,10.161.132.252,10.161.181.64,10.161.136.154,10.165.33.77,10.162.64.136,10.162.68.209,10.132.33.170,10.162.79.4,10.161.211.68,10.162.79.39,10.162.70.231,10.162.48.138,10.162.79.40,10.162.70.67,10.132.4.222,10.161.232.119,10.162.100.38,10.122.82.203,10.132.3.55,10.161.232.118,10.162.100.238,10.132.14.147,10.162.100.227,10.162.90.84,10.162.90.169,10.161.208.51,10.161.208.46,10.161.208.47,10.132.19.193,10.122.70.232,10.122.70.228,10.161.150.237,10.160.5.153,10.161.144.192,10.160.46.7,10.161.191.159,10.160.4.165,10.161.144.32,10.160.46.71,10.161.191.149,10.160.3.38,10.161.143.222,10.160.46.130,10.161.191.13,10.160.46.171,10.160.45.186,10.160.45.180,10.161.141.118,10.122.70.120,10.122.69.3,10.160.5.57,10.161.128.161,10.161.167.219,10.161.167.214,10.161.128.147,10.160.30.231,10.160.9.234,10.132.6.81,10.132.39.39,10.132.39.40,10.132.39.38,10.132.39.4,10.132.32.151,10.200.60.95,10.200.125.81,10.200.241.89,10.135.14.135,10.241.115.41,10.200.229.231,10.200.229.230,10.241.86.124,10.241.80.201,10.241.84.224,10.241.95.216,10.241.140.3,127.0.0.1,192.168.1.1,192.168.1.2,192.168.1.3,192.168.1.4,192.168.1.5,192.168.1.6,192.168.1.7,192.168.1.8,192.168.1.9,192.168.1.10,192.168.1.11,192.168.1.12,192.168.1.13,192.168.1.14,192.168.1.15,192.168.1.16,192.168.1.17,192.168.1.18,192.168.1.19,192.168.1.20,192.168.1.21,192.168.1.22,192.168.1.23,192.168.1.24,192.168.1.25,192.168.1.26,192.168.1.27,192.168.1.28,192.168.1.29,192.168.1.30,192.168.1.31,192.168.1.32,192.168.1.33,192.168.1.34,192.168.1.35,192.168.1.36,192.168.1.37,192.168.1.38,192.168.1.39,192.168.1.40,192.168.1.41,192.168.1.42,192.168.1.43,192.168.1.44,192.168.1.45,192.168.1.46,192.168.1.47,192.168.1.48,192.168.1.49,192.168.1.50,192.168.1.51,192.168.1.52,192.168.1.53,192.168.1.54,192.168.1.55,192.168.1.56,192.168.1.57,192.168.1.58,192.168.1.59,192.168.1.60,192.168.1.61,192.168.1.62,192.168.1.63,192.168.1.64,192.168.1.65,192.168.1.66,192.168.1.67,192.168.1.68,192.168.1.69,192.168.1.70,192.168.1.71,192.168.1.72,192.168.1.73,192.168.1.74,192.168.1.75,192.168.1.76,192.168.1.77,192.168.1.78,192.168.1.79,192.168.1.80,192.168.1.81,192.168.1.82,192.168.1.83,192.168.1.84,192.168.1.85,192.168.1.86,192.168.1.87,192.168.1.88,192.168.1.89,192.168.1.90,192.168.1.91,192.168.1.92,192.168.1.93,192.168.1.94,192.168.1.95,192.168.1.96,192.168.1.97,192.168.1.98,192.168.1.99,192.168.1.100,192.168.1.101,192.168.1.102,192.168.1.103,192.168.1.104,192.168.1.105,192.168.1.106,192.168.1.107,192.168.1.108,192.168.1.109,192.168.1.110,192.168.1.111,192.168.1.112,192.168.1.113,192.168.1.114,192.168.1.115,192.168.1.116,192.168.1.117,192.168.1.118,192.168.1.119,192.168.1.120,192.168.1.121,192.168.1.122,192.168.1.123,192.168.1.124,192.168.1.125,192.168.1.126,192.168.1.127,192.168.1.128,192.168.1.129,192.168.1.130,192.168.1.131,192.168.1.132,192.168.1.133,192.168.1.134,192.168.1.135,192.168.1.136,192.168.1.137,192.168.1.138,192.168.1.139,192.168.1.140,192.168.1.141,192.168.1.142,192.168.1.143,192.168.1.144,192.168.1.145,192.168.1.146,192.168.1.147,192.168.1.148,192.168.1.149,192.168.1.150,192.168.1.151,192.168.1.152,192.168.1.153,192.168.1.154,192.168.1.155,192.168.1.156,192.168.1.157,192.168.1.158,192.168.1.159,192.168.1.160,192.168.1.161,192.168.1.162,192.168.1.163,192.168.1.164,192.168.1.165,192.168.1.166,192.168.1.167,192.168.1.168,192.168.1.169,192.168.1.170,192.168.1.171,192.168.1.172,192.168.1.173,192.168.1.174,192.168.1.175,192.168.1.176,192.168.1.177,192.168.1.178,192.168.1.179,192.168.1.180,192.168.1.181,192.168.1.182,192.168.1.183,192.168.1.184,192.168.1.185,192.168.1.186,192.168.1.187,192.168.1.188,192.168.1.189,192.168.1.190,192.168.1.191,192.168.1.192,192.168.1.193,192.168.1.194,192.168.1.195,192.168.1.196,192.168.1.197,192.168.1.198,192.168.1.199,192.168.1.200,192.168.1.201,192.168.1.202,192.168.1.203,192.168.1.204,192.168.1.205,192.168.1.206,192.168.1.207,192.168.1.208,192.168.1.209,192.168.1.210,192.168.1.211,192.168.1.212,192.168.1.213,192.168.1.214,192.168.1.215,192.168.1.216,192.168.1.217,192.168.1.218,192.168.1.219,192.168.1.220,192.168.1.221,192.168.1.222,192.168.1.223,192.168.1.224,192.168.1.225,192.168.1.226,192.168.1.227,192.168.1.228,192.168.1.229,192.168.1.230,192.168.1.231,192.168.1.232,192.168.1.233,192.168.1.234,192.168.1.235,192.168.1.236,192.168.1.237,192.168.1.238,192.168.1.239,192.168.1.240,192.168.1.241,192.168.1.242,192.168.1.243,192.168.1.244,192.168.1.245,192.168.1.246,192.168.1.247,192.168.1.248,192.168.1.249,192.168.1.250,192.168.1.251,192.168.1.252,192.168.1.253,192.168.1.254,192.168.1.255";
		String NOT_YUN_ALL_IPS = "127.0.0.1,192.168.1.1,192.168.1.2,192.168.1.3,192.168.1.4,192.168.1.5,192.168.1.6,192.168.1.7,192.168.1.8,192.168.1.9,192.168.1.10,192.168.1.11,192.168.1.12,192.168.1.13,192.168.1.14,192.168.1.15,192.168.1.16,192.168.1.17,192.168.1.18,192.168.1.19,192.168.1.20,192.168.1.21,192.168.1.22,192.168.1.23,192.168.1.24,192.168.1.25,192.168.1.26,192.168.1.27,192.168.1.28,192.168.1.29,192.168.1.30,192.168.1.31,192.168.1.32,192.168.1.33,192.168.1.34,192.168.1.35,192.168.1.36,192.168.1.37,192.168.1.38,192.168.1.39,192.168.1.40,192.168.1.41,192.168.1.42,192.168.1.43,192.168.1.44,192.168.1.45,192.168.1.46,192.168.1.47,192.168.1.48,192.168.1.49,192.168.1.50,192.168.1.51,192.168.1.52,192.168.1.53,192.168.1.54,192.168.1.55,192.168.1.56,192.168.1.57,192.168.1.58,192.168.1.59,192.168.1.60,192.168.1.61,192.168.1.62,192.168.1.63,192.168.1.64,192.168.1.65,192.168.1.66,192.168.1.67,192.168.1.68,192.168.1.69,192.168.1.70,192.168.1.71,192.168.1.72,192.168.1.73,192.168.1.74,192.168.1.75,192.168.1.76,192.168.1.77,192.168.1.78,192.168.1.79,192.168.1.80,192.168.1.81,192.168.1.82,192.168.1.83,192.168.1.84,192.168.1.85,192.168.1.86,192.168.1.87,192.168.1.88,192.168.1.89,192.168.1.90,192.168.1.91,192.168.1.92,192.168.1.93,192.168.1.94,192.168.1.95,192.168.1.96,192.168.1.97,192.168.1.98,192.168.1.99,192.168.1.100,192.168.1.101,192.168.1.102,192.168.1.103,192.168.1.104,192.168.1.105,192.168.1.106,192.168.1.107,192.168.1.108,192.168.1.109,192.168.1.110,192.168.1.111,192.168.1.112,192.168.1.113,192.168.1.114,192.168.1.115,192.168.1.116,192.168.1.117,192.168.1.118,192.168.1.119,192.168.1.120,192.168.1.121,192.168.1.122,192.168.1.123,192.168.1.124,192.168.1.125,192.168.1.126,192.168.1.127,192.168.1.128,192.168.1.129,192.168.1.130,192.168.1.131,192.168.1.132,192.168.1.133,192.168.1.134,192.168.1.135,192.168.1.136,192.168.1.137,192.168.1.138,192.168.1.139,192.168.1.140,192.168.1.141,192.168.1.142,192.168.1.143,192.168.1.144,192.168.1.145,192.168.1.146,192.168.1.147,192.168.1.148,192.168.1.149,192.168.1.150,192.168.1.151,192.168.1.152,192.168.1.153,192.168.1.154,192.168.1.155,192.168.1.156,192.168.1.157,192.168.1.158,192.168.1.159,192.168.1.160,192.168.1.161,192.168.1.162,192.168.1.163,192.168.1.164,192.168.1.165,192.168.1.166,192.168.1.167,192.168.1.168,192.168.1.169,192.168.1.170,192.168.1.171,192.168.1.172,192.168.1.173,192.168.1.174,192.168.1.175,192.168.1.176,192.168.1.177,192.168.1.178,192.168.1.179,192.168.1.180,192.168.1.181,192.168.1.182,192.168.1.183,192.168.1.184,192.168.1.185,192.168.1.186,192.168.1.187,192.168.1.188,192.168.1.189,192.168.1.190,192.168.1.191,192.168.1.192,192.168.1.193,192.168.1.194,192.168.1.195,192.168.1.196,192.168.1.197,192.168.1.198,192.168.1.199,192.168.1.200,192.168.1.201,192.168.1.202,192.168.1.203,192.168.1.204,192.168.1.205,192.168.1.206,192.168.1.207,192.168.1.208,192.168.1.209,192.168.1.210,192.168.1.211,192.168.1.212,192.168.1.213,192.168.1.214,192.168.1.215,192.168.1.216,192.168.1.217,192.168.1.218,192.168.1.219,192.168.1.220,192.168.1.221,192.168.1.222,192.168.1.223,192.168.1.224,192.168.1.225,192.168.1.226,192.168.1.227,192.168.1.228,192.168.1.229,192.168.1.230,192.168.1.231,192.168.1.232,192.168.1.233,192.168.1.234,192.168.1.235,192.168.1.236,192.168.1.237,192.168.1.238,192.168.1.239,192.168.1.240,192.168.1.241,192.168.1.242,192.168.1.243,192.168.1.244,192.168.1.245,192.168.1.246,192.168.1.247,192.168.1.248,192.168.1.249,192.168.1.250,192.168.1.251,192.168.1.252,192.168.1.253,192.168.1.254,192.168.1.255";
//		System.out.println(formatString(MAIZUO_ALL_IPS, 8));
//		System.out.println(formatString(MAIZUO_INNER_IPS, 8));
		System.out.println(formatString(NOT_YUN_ALL_IPS, 8));
	}
	
	public static String formatString(String str , int num){
		if(StringUtils.isBlank(str)){
			return null;
		}
		String[] liststr  = str.split(",");
		StringBuffer sb = new StringBuffer();
		int i =0;
		for(String string : liststr){
			if(i>0 && i%num == 0){
				sb.append("<br>"+string+",");
			}
			sb.append(string+",");
			i++;
		}
		return sb.toString();
	}
}
