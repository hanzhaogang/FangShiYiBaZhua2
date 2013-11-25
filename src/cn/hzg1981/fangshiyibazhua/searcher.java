package cn.hzg1981.fangshiyibazhua;
import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;

public class searcher {
/* search for keyword stored in local file and return the results  */
	
	public static void main(String[] args) throws IOException {
		String dataFilePath = "D:\\workspace\\crawlStorageFolder\\StoredData";
        String keyFilePath = "D:\\workspace\\crawlStorageFolder\\Key.txt";
		
        String string4Data = getStringFromFile(dataFilePath);
        String stringWanted = getStringFromFile(keyFilePath);

        outPutSearchResults(string4Data, stringWanted);    
	}
    
	private static void outPutSearchResults(String string4Data, String stringWanted ) {
        int matchTimes = string4Data.indexOf(stringWanted);
        if( matchTimes > -1) {
            System.out.println(stringWanted + " --- " + matchTimes );
        } else {
            System.out.println(stringWanted + " --- not found! ");
        }
    }
	
	private static String getStringFromFile(String filePath){
        String string = "";
		try{
	        FileInputStream fileInputStream = new FileInputStream(filePath);
            FileChannel fileChannel = fileInputStream.getChannel();
            int dataSize = (int)fileChannel.size();
            MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, dataSize);
            
//      如果与中文无关，此二句及其后相关语句可刪除
    	    Charset charset = Charset.forName("GB18030");
            CharsetDecoder decoder = charset.newDecoder();
            CharBuffer charBuffer = decoder.decode(mappedByteBuffer);
            
            string = String.valueOf(charBuffer);
        	string = string.substring(0, string.length()-2);
            
        	fileInputStream.close(); 
            fileChannel.close();
        }catch(Exception e){
	        System.out.println(e);
        }
        return string;
	}
    
}
