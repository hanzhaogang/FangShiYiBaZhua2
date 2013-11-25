package cn.hzg1981.fangshiyibazhua;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

public class UrlsDownloadService extends Service{
    
    public void downloadUrls2LocalFile(ArrayList<String> requriredUrls, String file) {
        /* download all urls one by one */	
    	try{
            Iterator<String> it = requriredUrls.iterator();
            while (it.hasNext()) {
            	String url = it.next();
		        downloadSinglePage2LocalFile(url, file);
//  	  	System.out.println("begin");
            }
		}catch(Exception e){
			return;
		}
    }

//    public void downloadRegexUrls2LocalFile(String urlsHeader, String file){
//    	try {
//    		File file = new File("E:\\test\\");
//    			File[] files = file.listFiles();
//    			for (int i = 0; i < files.length; i++) {
//    			  if(!files[i].isDirectory()){
//    			     files[i];
//    			  }
//    			}			
//			
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    }
    
	protected void setRequriredUrls(){};
	
    private void downloadSinglePage2LocalFile(String webPath, String file) {
	/* download a page specificated by the arg webPaht to a file specificated by the arg file   */ 
    	
    	try{
    		transferFromUrl2LocalFile(webPath, file);
		}catch(Exception e){
			return;
		}

	}
    
    private void transferFromUrl2LocalFile(String webPath, String fileName) throws Exception {
    	
	    URL url = new URL(webPath);
        URLConnection urlConnection = url.openConnection(); 
		InputStream inputStream = urlConnection.getInputStream(); 
        
        FileOutputStream outputStream;
        outputStream = this.openFileOutput(fileName, Context.MODE_PRIVATE);
        
		int i = 0; 
		while ((i=inputStream.read())!=-1) { 
		    outputStream.write(i); 
		}       
		 
		inputStream.close();
		outputStream.close();
    }
    
    private void transferFromUrl2Memory(String webPath, ArrayList<Integer> downloadedContent) throws Exception {
    	
	    URL url = new URL(webPath);
        URLConnection urlConnection = url.openConnection(); 
		InputStream inputStream = urlConnection.getInputStream(); 
		
		int i = 0; 
		while ((i=inputStream.read())!=-1) { 
			downloadedContent.add(i);
		} 
		 
		inputStream.close();
    }

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}
