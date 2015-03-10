package com.xyengine.xelnectmobileuser.smsreciever;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
    public static TextView smsView;
    public static TextView timeView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        smsView = (TextView) findViewById(R.id.smsRecieverView);
        timeView = (TextView) findViewById(R.id.timeView);
        //IncomingSms incomingSms = new IncomingSms();
        //smsView.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/Hindi.ttf"));
        Typeface face=Typeface.createFromAsset(getAssets(),
                "hindi.ttf");
        smsView.setTypeface(face);

        //im.setText("Hindi font");

    }
    public static void updateView(TextView viewToUpdate, String textToInclude){
        viewToUpdate.setText(textToInclude);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
