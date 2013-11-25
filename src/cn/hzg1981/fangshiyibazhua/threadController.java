package cn.hzg1981.fangshiyibazhua;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.ArrayList;

public class threadController {
	
//	private final static int websiteNumber = 6 ;
    private final static String GANJI =
    		"http://bj.ganji.com/fang1/a1o6/_%E5%8C%97%E4%B8%83%E5%AE%B6/";
// 			"http://bj.ganji.com/fang1/a1/";	
    private final static String DOUBAN = 
    		"http://www.douban.com/group/beijingzufang/";
    private final static String TONGCHENG = 
    		"http://bj.58.com/chuzu/0/";
           //http://bj.58.com/chuzu/0/pn5/
    private final static String ANJUKE =
    		"http://bj.zu.anjuke.com/fangyuan/#filtersort";
    private final static String SOUFANG =
    		"http://zu.soufun.com/house/a21/";
//	public enum Website  { douban, shuimu, ganji, tongcheng, anjuke, soufang };
    
	public static void main(String[] args) throws IOException {
	    
//		for (Website website : Website.values()) {
////	    System.out.println(website + ", ordinal " + website.ordinal()); 
//			new Thread(new CrawlerThread(
//			    		  "D:\\workspace\\crawlStorageFolder\\" + website.toString() + ".text", website )).start();
//		}    
		
//      new Thread(new CrawlerThread("D:\\workspace\\crawlStorageFolder\\douban", DOUBAN)).start();	
//      new Thread(new CrawlerThread("D:\\workspace\\crawlStorageFolder\\shuimu", SHUIMU)).start();	
//      new Thread(new CrawlerThread("D:\\workspace\\crawlStorageFolder\\soufang", SOUFANG)).start();	
//      new Thread(new CrawlerThread("D:\\workspace\\crawlStorageFolder\\anjuke", ANJUKE)).start();	
//      new Thread(new CrawlerThread("D:\\workspace\\crawlStorageFolder\\tongcheng", TONGCHENG)).start();	
        new Thread(new GanjiCrawler()).start();	
	//System.out.print("done");
	}
}
		
