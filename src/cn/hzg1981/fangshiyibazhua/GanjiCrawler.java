package cn.hzg1981.fangshiyibazhua;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import android.content.Context;

public class GanjiCrawler implements Runnable{
	
//	private File ganjiFile = new File("ganji.txt"); 
	private String ganjiFileName = "";
	private ArrayList<String> requriredUrls = new ArrayList<String>();
    private UrlsDownloadService urlDownloader = new UrlsDownloadService();	
    
    public GanjiCrawler() throws IOException{
        setganjiFileName("ganji.txt");
	}
	
    public String getGanjiFileName(){
    	return ganjiFileName;
    }
    public boolean setganjiFileName(String name){
    	ganjiFileName = name;
    	return true;
    }
    
    @Override
    public void run() {
        requriredUrls = generateGanjiWebPath(); 
    	urlDownloader.downloadUrls2LocalFile(requriredUrls, ganjiFileName);
    }
    
    private ArrayList<String> generateGanjiWebPath(){

    	ArrayList<String> ganjiWebPath = new ArrayList<String>();
    	
		int j = 0;
		for ( j = 0; j < 200; j++ ) {
			ganjiWebPath.add("http://bj.ganji.com/fang1/a5"+"o"+String.valueOf(j));
			System.out.println(ganjiWebPath.get(j));
		}	
		
		return ganjiWebPath;
    }
}	