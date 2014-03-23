package cn.hzg1981.fangshiyibazhua;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.PrivateCredentialPermission;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.*;
import android.support.v4.app.NavUtils;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DisplayQueryResultActivity extends Activity {

    private ListView listView;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Integer recordNumber = 0;
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_query_result);
       
        SQLiteDatabase db = openOrCreateDatabase("test.db", Context.MODE_PRIVATE, null);  
        Cursor c = db.rawQuery("SELECT * FROM secondaryHouse WHERE city = ?", new String[]{"北京"});  
	    while (c.moveToNext()) {  
	        int _id = c.getInt(c.getColumnIndex("_id"));  
	        String city = c.getString(c.getColumnIndex("city"));  
	        String district = c.getString(c.getColumnIndex("district"));  
	        String business_circle = c.getString(c.getColumnIndex("business_circle"));  
	        String price = c.getString(c.getColumnIndex("price"));  
	        String acreage = c.getString(c.getColumnIndex("acreage"));  
	        String room = c.getString(c.getColumnIndex("room"));  
	        Log.i("db", "_id=>" + _id + ", city=>" + city + ", district=>" + district);  
	        recordNumber = recordNumber+1;
	    }  
	    c.close();  
	    
	    TextView recordNumberTextView = (TextView)findViewById(R.id.resultsNumber);
	    recordNumberTextView.setText(recordNumber.toString());
//    	  cityTextView = (TextView)findViewById(R.id.city);
//        districtTextView = (TextView)findViewById(R.id.district);
//        business_circleTextView = (TextView)findViewById(R.id.business_circle);
//        priceTextView = (TextView)findViewById(R.id.price);
//        acreageTextView = (TextView)findViewById(R.id.acreage);
//        roomTextView = (TextView)findViewById(R.id.room);
    	
//    	listView = new ListView(this);
//        listView.setAdapter(new ArrayAdapter<String>
//            (this, android.R.layout.simple_expandable_list_item_1,getData()));
//        setContentView(listView);

        //        RelativeLayout r = new RelativeLayout(this);
//        r.setLayoutParams(new LayoutParams
//        		(RelativeLayout.LayoutParams.FILL_PARENT,RelativeLayout.LayoutParams.WRAP_CONTENT));

//        Intent intent = getIntent();
//        String city = intent.getStringExtra(MainActivity.CITY);
//        String district = intent.getStringExtra(MainActivity.DISTRICT);
//        String business_circle = intent.getStringExtra(MainActivity.BUSINESS_CIRCLE);
//        String price = intent.getStringExtra(MainActivity.PRICE);
//        String acreage = intent.getStringExtra(MainActivity.ACREAGE);
//        String room = intent.getStringExtra(MainActivity.ROOM);
        
    }
    
    private List<String> getData(){
        
        List<String> data = new ArrayList<String>();
        data.add("测试数据1");
        data.add("测试数据2");
        data.add("测试数据3");
        data.add("测试数据4");
	        
        return data;
    }
    
    private String getFileLength (String fileName){
       
    	File ganjiFile = new File(fileName);
        String fileLength = "";
        if (ganjiFile.exists() == true) {
            Long length = ganjiFile.length();
      	    fileLength = length.toString();
        }else {
		    ;
	    }
        return fileLength;
    } 
 
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        
    	switch (item.getItemId()) {
        case android.R.id.home:
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void bindAdaptersAndValue(){
//        cityAdapter = new SimpleAdapter(DisplayQueryResultActivity.this,
//                android.R.layout.simple_spinner_item, city);
//        citySpinner.setAdapter(cityAdapter);
//        
//        districtAdapter = new SimpleAdapter(DisplayQueryResultActivity.this, 
//                android.R.layout.simple_spinner_item, district[0]);
//        districtSpinner.setAdapter(districtAdapter);
//       
//        business_circleAdapter = new SimpleAdapter(DisplayQueryResultActivity.this,
//                android.R.layout.simple_spinner_item, business_circle[0][0]);
//        business_circleSpinner.setAdapter(business_circleAdapter);
//   
//        acreageAdapter = new SimpleAdapter(DisplayQueryResultActivity.this,
//                android.R.layout.simple_spinner_item, acreage);
//        acreageSpinner.setAdapter(acreageAdapter);
//        
//        roomAdapter = new SimpleAdapter(DisplayQueryResultActivity.this,
//                android.R.layout.simple_spinner_item, room);
//        roomSpinner.setAdapter(roomAdapter);
//
//        priceAdapter = new SimpleAdapter(DisplayQueryResultActivity.this,
//                android.R.layout.Simple_spinner_item, price);
//        priceSpinner.setAdapter(priceAdapter);
     }
}
