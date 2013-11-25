package cn.hzg1981.fangshiyibazhua;

import cn.hzg1981.fangshiyibazhua.GanjiCrawler;
import cn.hzg1981.fangshiyibazhua.DisplayResultActivity;
import cn.hzg1981.fangshiyibazhua.InputData;
import cn.hzg1981.fangshiyibazhua.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import java.io.IOException;

public class MainActivity extends Activity {
    
    private Spinner citySpinner = null;
    private Spinner districtSpinner =null ;     
    private Spinner business_circleSpinner =null;    
    private Spinner acreageSpinner = null;    
    private Spinner priceSpinner =null ;    
    private Spinner roomSpinner =null ;    
    
    private InputData inputData = new InputData();
    String[] city = inputData.getCity();
    String[][] district = inputData.getDistrict();
    String [][][] business_circle = inputData.getBusiness_circle();
    String[] acreage = inputData.getAcreage();
    String[] room = inputData.getRoom();
    String[] price = inputData.getPrice();
    
    ArrayAdapter<String> cityAdapter = null; 
    ArrayAdapter<String> districtAdapter = null;    
    ArrayAdapter<String> business_circleAdapter = null;    
    ArrayAdapter<String> acreageAdapter = null;    
    ArrayAdapter<String> roomAdapter = null;    
    ArrayAdapter<String> priceAdapter = null;    
    
	public final static String CITY = "com.example.myfirstapp.CITY";
	public final static String DISTRICT = "com.example.myfirstapp.DISTRICT";
	public final static String BUSINESS_CIRCLE = "com.example.myfirstapp.BUSINESS_CIRCLE";
	public final static String PRICE = "com.example.myfirstapp.PRICE";
	public final static String ACREAGE = "com.example.myfirstapp.ACREAGE";
	public final static String ROOM = "com.example.myfirstapp.ROOM";

    static int cityPosition = 0;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSpinners();
//          
//        // if is the first time this app is running, setup a totally new download 
//        try {
//			new Thread(new GanjiCrawler()).start();
////			new Thread(new ShuimuCrawler()).start();
////			new Thread(new GanjiCrawler()).start();
////			new Thread(new GanjiCrawler()).start();
////			new Thread(new GanjiCrawler()).start();
////			new Thread(new GanjiCrawler()).start();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        
//        //if this app has been run before, 
    }
    
    public void sendMessage(View view) {
        // Called when the user clicks the Send button 
   
    	Intent intent = new Intent(this, DisplayResultActivity.class);
        
        String city = citySpinner.getSelectedItem().toString();
        String district = districtSpinner.getSelectedItem().toString();
        String business_circle = business_circleSpinner.getSelectedItem().toString();
        String price = priceSpinner.getSelectedItem().toString();
        String acreage = acreageSpinner.getSelectedItem().toString();
        String room = roomSpinner.getSelectedItem().toString();

    	
    	intent.putExtra(CITY, city);
    	intent.putExtra(DISTRICT, district);
    	intent.putExtra(BUSINESS_CIRCLE, business_circle);
    	intent.putExtra(PRICE, price);
    	intent.putExtra(ACREAGE, acreage);
    	intent.putExtra(ROOM, room);

    	startActivity(intent);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void setSpinners() {        
        
    	citySpinner = (Spinner)findViewById(R.id.spin_city);
        districtSpinner = (Spinner)findViewById(R.id.spin_district);
        business_circleSpinner = (Spinner)findViewById(R.id.spin_business_circle);
        priceSpinner = (Spinner)findViewById(R.id.spin_price);
        acreageSpinner = (Spinner)findViewById(R.id.spin_acreage);
        roomSpinner = (Spinner)findViewById(R.id.spin_room);

        bindAdaptersAndValue();
        
        //城市级下拉框监听
        citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            
        	// 表示选项被改变的时候触发此方法，主要实现办法：动态改变地级适配器的绑定值
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long arg3)
            {
                //position为当前城市级选中的值的序号

                //将区级适配器的值改变为city[position]中的值
                districtAdapter = new ArrayAdapter<String>(
                        MainActivity.this, android.R.layout.simple_spinner_item, district[position]);
                // 设置二级下拉列表的选项内容适配器
                districtSpinner.setAdapter(districtAdapter);
                cityPosition = position;    //记录当前省级序号，留给下面修改县级适配器时用
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0)
            {

            }

        });

        //地级下拉监听
        districtSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                    int position, long arg3)
            {
                business_circleAdapter = new ArrayAdapter<String>(MainActivity.this,
                        android.R.layout.simple_spinner_item, business_circle[cityPosition][position]);
                business_circleSpinner.setAdapter(business_circleAdapter);
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0)
            {

            }
        });
    } 
    
    private void bindAdaptersAndValue(){
        cityAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item, city);
        citySpinner.setAdapter(cityAdapter);
        citySpinner.setSelection(0,true);  //设置默认选中项，此处为默认选中第0个值
        
        districtAdapter = new ArrayAdapter<String>(MainActivity.this, 
                android.R.layout.simple_spinner_item, district[0]);
        districtSpinner.setAdapter(districtAdapter);
        districtSpinner.setSelection(0,true);  
       
        business_circleAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item, business_circle[0][0]);
        business_circleSpinner.setAdapter(business_circleAdapter);
        business_circleSpinner.setSelection(0, true);
   
        acreageAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item, acreage);
        acreageSpinner.setAdapter(acreageAdapter);
        acreageSpinner.setSelection(0,true);  
        
        roomAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item, room);
        roomSpinner.setAdapter(roomAdapter);
        roomSpinner.setSelection(0,true); 

        priceAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item, price);
        priceSpinner.setAdapter(priceAdapter);
        priceSpinner.setSelection(0,true);
    }
}
