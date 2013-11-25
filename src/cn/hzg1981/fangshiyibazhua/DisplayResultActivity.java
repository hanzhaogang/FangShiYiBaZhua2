package cn.hzg1981.fangshiyibazhua;

import java.io.File;
import android.os.Bundle;
import android.app.Activity;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.annotation.SuppressLint;
import android.content.Intent;

public class DisplayResultActivity extends Activity {

//	private static final String TAG = "MyActivity";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

    	super.onCreate(savedInstanceState);

//        RelativeLayout r = new RelativeLayout(this);
//        r.setLayoutParams(new LayoutParams
//        		(RelativeLayout.LayoutParams.FILL_PARENT,RelativeLayout.LayoutParams.WRAP_CONTENT));

        // Get message from the intent
        Intent intent = getIntent();
        String city = intent.getStringExtra(MainActivity.CITY);
        String district = intent.getStringExtra(MainActivity.DISTRICT);
        String business_circle = intent.getStringExtra(MainActivity.BUSINESS_CIRCLE);
        String price = intent.getStringExtra(MainActivity.PRICE);
        String acreage = intent.getStringExtra(MainActivity.ACREAGE);
        String room = intent.getStringExtra(MainActivity.ROOM);
        
//        String resultSummary = getFileLength("ganji.txt");
   
        // Create the city text view
        TextView cityTextView = new TextView(this);
        cityTextView.setTextSize(40);
        cityTextView.setText(city);
        // Create the district text view
        TextView districtTextView = new TextView(this);
        districtTextView.setTextSize(40);
        districtTextView.setText(district);
        // Create the business_circle text view
        TextView business_circleTextView = new TextView(this);
        business_circleTextView.setTextSize(40);
        business_circleTextView.setText(business_circle);

//        TextView resutlSummaryTextView = new TextView(this);
//        resutlSummaryTextView.setTextSize(40);
//        resutlSummaryTextView.setText(resultSummary);
        
        // Set the text view as the activity layout
        setContentView(cityTextView);
//        setContentView(districtTextView);
//        setContentView(business_circleTextView);
//        setContentView(resutlSummaryTextView);
        
//        Log.v(TAG, "currentX=" + resultSummary);    
//        System.out.print(resultSummary);
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
