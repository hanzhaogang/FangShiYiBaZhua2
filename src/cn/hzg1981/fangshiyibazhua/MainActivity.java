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
        
        //���м����������
        citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            
        	// ��ʾѡ��ı��ʱ�򴥷��˷�������Ҫʵ�ְ취����̬�ı�ؼ��������İ�ֵ
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long arg3)
            {
                //positionΪ��ǰ���м�ѡ�е�ֵ�����

                //��������������ֵ�ı�Ϊcity[position]�е�ֵ
                districtAdapter = new ArrayAdapter<String>(
                        MainActivity.this, android.R.layout.simple_spinner_item, district[position]);
                // ���ö��������б��ѡ������������
                districtSpinner.setAdapter(districtAdapter);
                cityPosition = position;    //��¼��ǰʡ����ţ����������޸��ؼ�������ʱ��
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0)
            {

            }

        });

        //�ؼ���������
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
        citySpinner.setSelection(0,true);  //����Ĭ��ѡ����˴�ΪĬ��ѡ�е�0��ֵ
        
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
