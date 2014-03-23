package cn.hzg1981.fangshiyibazhua;

import java.util.ArrayList;
import java.util.List;

import utils.HouseRecorder;
import utils.Person;
import utils.SecondaryHouse;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class CreateSecondaryHouseTableActivity extends Activity {

    private TextView cityTextView = null;
    private TextView districtTextView = null;
    private TextView business_circleTextView = null;
    private TextView acreageTextView = null;
    private TextView roomTextView = null;
    private TextView priceTextView = null;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

    	super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String city = intent.getStringExtra(MainActivity.CITY);
        String district = intent.getStringExtra(MainActivity.DISTRICT);
        String business_circle = intent.getStringExtra(MainActivity.BUSINESS_CIRCLE);
        String price = intent.getStringExtra(MainActivity.PRICE);
        String acreage = intent.getStringExtra(MainActivity.ACREAGE);
        String room = intent.getStringExtra(MainActivity.ROOM);
	        
        setContentView(R.layout.activity_create_sqlite_database);
	      
//        cityTextView = (TextView)findViewById(R.id.city);
//        cityTextView.setText(city);
//        districtTextView = (TextView)findViewById(R.id.district);
//        districtTextView.setText(district);
//        business_circleTextView = (TextView)findViewById(R.id.business_circle);
//        business_circleTextView.setText(business_circle);
//        acreageTextView = (TextView)findViewById(R.id.acreage);
//        acreageTextView.setText(acreage);
//        roomTextView = (TextView)findViewById(R.id.room);
//        roomTextView.setText(room);
//        priceTextView = (TextView)findViewById(R.id.price);
//        priceTextView.setText(price);

        createTestDatabaseWithSampleData();
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
	    
	    
	    private List<String> getData(){
	        
	        List<String> data = new ArrayList<String>();
	        data.add("测试数据1");
	        data.add("测试数据2");
	        data.add("测试数据3");
	        data.add("测试数据4");
	         
	        return data;
	    }
	    
	    
	    boolean createSecondaryHousingTable(){
	    	 final SQLiteDatabase mSQLiteDatabase 
	            = this.openOrCreateDatabase("SecondaryHousingDatabase",MODE_PRIVATE,null);
	    	
	    	 String CREATE_TABLE="";
	    	 
	    	 mSQLiteDatabase.execSQL(CREATE_TABLE);
	    	
	    	return true;
	    	
	    }
	    
        private void createTestDatabaseWithSampleData(){
	    	
	        SQLiteDatabase db = openOrCreateDatabase("test.db", Context.MODE_PRIVATE, null);  
	        db.execSQL("DROP TABLE IF EXISTS secondaryHouse");  
	        db.execSQL("CREATE TABLE secondaryHouse" +
	        		"(_id INTEGER PRIMARY KEY AUTOINCREMENT, city VARCHAR, district VARCHAR, " +
	        		"business_circle VARCHAR, price VARCHAR, acreage VARCHAR, room VARCHAR)");  
//	        HouseRecorder houseRecorder = new HouseRecorder();
//            houseRecorder.record();
//	        SecondaryHouse secondaryHouse = new SecondaryHouse();  
//	        secondaryHouse = houseRecorder.record(j, district, business_circle, price, acreage, room)
	        db.execSQL("INSERT INTO secondaryHouse VALUES (NULL, ?, ?, ?, ?, ?, ?)", 
	        		new Object[]{"北京","丰台区","六里桥","250-300万","130-150平米","1室"} );  
	        db.close();  
	    }
    
	    private void createPersonTableWithSampleData(){
	    	
	        SQLiteDatabase db = openOrCreateDatabase("test.db", Context.MODE_PRIVATE, null);  
	        db.execSQL("DROP TABLE IF EXISTS person");  
	        db.execSQL("CREATE TABLE person " +
	        		"(_id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, age SMALLINT)");  
	        
	        Person person = new Person();  
	        person.name = "john";  
	        person.age = 30;  
	        db.execSQL("INSERT INTO person VALUES (NULL, ?, ?)", new Object[]{person.name, person.age});  
	          
//	        person.name = "david";  
//	        person.age = 33;  
//	        //ContentValues以键值对的形式存放数据  
//	        ContentValues cv = new ContentValues();  
//	        cv.put("name", person.name);  
//	        cv.put("age", person.age);  
//	        db.insert("person", null, cv);  
	          
//	        cv = new ContentValues();  
//	        cv.put("age", 35);  
//	        db.update("person", cv, "name = ?", new String[]{"john"});  
	          
	        Cursor c = db.rawQuery("SELECT * FROM person WHERE age >= ?", new String[]{"33"});  
	        while (c.moveToNext()) {  
	            int _id = c.getInt(c.getColumnIndex("_id"));  
	            String name = c.getString(c.getColumnIndex("name"));  
	            int age = c.getInt(c.getColumnIndex("age"));  
	            Log.i("db", "_id=>" + _id + ", name=>" + name + ", age=>" + age);  
	        }  
	        c.close();  
	          
            //db.delete("person", "age < ?", new String[]{"35"});  
	        db.close();  
            //deleteDatabase("test.db");  
	    }
	}







    	
   
    

    


