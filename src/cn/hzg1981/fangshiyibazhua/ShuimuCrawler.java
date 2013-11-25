package cn.hzg1981.fangshiyibazhua;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
//import java.net.MalformedURLException;
//import org.apache.http.*;
//import org.apache.http.impl.client.DefaultHttpClient;

public class ShuimuCrawler {
/* this class is designed for shuimu website */

	private ArrayList<String> requriredUrls = new ArrayList<String>();
    private File file = new File("D:\\workspace\\crawlStorageFolder\\shuimuData.txt ");	

    public ShuimuCrawler() throws IOException{
    	
    }	

    protected void setRequriredUrls(){
        requriredUrls.add(
        		"http://www.newsmth.net/nForum/#!s/article?t1=%25E5%258C%2597%25E4%25B8%2583%25E5%25AE%25B6&au=&b=HouseRent");
    }
    
    public void run() {
        setRequriredUrls();
	}
	
	public  static void main(String []args)	{
		try{
			ShuimuCrawler shuimuCrawler = new ShuimuCrawler();
			shuimuCrawler.run(); 	
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.print("done");
	}
	
}