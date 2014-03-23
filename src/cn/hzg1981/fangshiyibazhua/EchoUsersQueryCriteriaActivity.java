package cn.hzg1981.fangshiyibazhua;

import java.io.File;
import android.os.Bundle;
import android.app.Activity;
import android.view.MenuItem;
import android.widget.Spinner;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.annotation.SuppressLint;
import android.content.Intent;

public class EchoUsersQueryCriteriaActivity extends Activity {

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
	        
//	        String resultSummary = getFileLength("ganji.txt");
//	        TextView resutlSummaryTextView = new TextView(this);
//	        resutlSummaryTextView.setTextSize(40);
//	        resutlSummaryTextView.setText(resultSummary);
//	        Log.v(TAG, "currentX=" + resultSummary);    
//	        System.out.print(resultSummary);
	        
        setContentView(R.layout.activity_echo_query_criteria);
	      
        cityTextView = (TextView)findViewById(R.id.city);
        cityTextView.setText(city);
        districtTextView = (TextView)findViewById(R.id.district);
        districtTextView.setText(district);
        business_circleTextView = (TextView)findViewById(R.id.business_circle);
        business_circleTextView.setText(business_circle);
        acreageTextView = (TextView)findViewById(R.id.acreage);
        acreageTextView.setText(acreage);
        roomTextView = (TextView)findViewById(R.id.room);
        roomTextView.setText(room);
        priceTextView = (TextView)findViewById(R.id.price);
        priceTextView.setText(price);
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
	}
