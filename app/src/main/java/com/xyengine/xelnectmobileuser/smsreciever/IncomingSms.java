package com.xyengine.xelnectmobileuser.smsreciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by XelnectMobileUser on 3/10/2015.
 */
public class IncomingSms extends BroadcastReceiver {

    // Get the object of SmsManager
    final SmsManager sms = SmsManager.getDefault();
    SmsMessage currentMessage;
    String phoneNumber;
    String senderNum;
    static String message;
    public static ArrayList<String> smsMessage;

    public void onReceive(Context context, Intent intent) {

        if(intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")){
            Bundle bundle = intent.getExtras();           //---get the SMS message passed in---
            SmsMessage[] msgs = null;
            String msg_from;
            String msgBody = "";
            if (bundle != null){
                //---retrieve the SMS message received---
                try{
                    Object[] pdus = (Object[]) bundle.get("pdus");
                    msgs = new SmsMessage[pdus.length];
                    for(int i=0; i<msgs.length; i++){
                        msgs[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
                        msg_from = msgs[i].getOriginatingAddress();
                       /* msgBody.add(msgs[i].getMessageBody());*/
                        Log.v("ww", Integer.toString(msgs.length));
                        msgBody=msgBody+msgs[i].getMessageBody();
                    }
                    MainActivity.updateView(MainActivity.timeView, "Message recieved on: " + IncomingSms.getCurrentTime());
                    MainActivity.updateView(MainActivity.smsView, msgBody);
                }catch(Exception e){
//                            Log.d("Exception caught",e.getMessage());
                }
            }
        }
    }
        // Retrieves a map of extended data from the intent.
        /*final Bundle bundle = intent.getExtras();

        try {

            if (bundle != null) {

                final Object[] pdusObj = (Object[]) bundle.get("pdus");

                for (Object aPdusObj : pdusObj) {
                    currentMessage = SmsMessage.createFromPdu((byte[]) aPdusObj);
                    phoneNumber = currentMessage.getDisplayOriginatingAddress();
                    senderNum = phoneNumber;
                    message = currentMessage.getDisplayMessageBody();

                    Log.i("SmsReceiver", "senderNum: " + senderNum + "; message: " + message);
                    smsMessage.add(message);

                   *//* MainActivity.updateView(MainActivity.timeView, "Message recieved on: " + IncomingSms.getCurrentTime());
                    MainActivity.updateView(MainActivity.smsView, IncomingSms.message);*//*

                    // Show Alert
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context,
                            "senderNum: " + senderNum + ", message: " + message, duration);
                    toast.show();

                } // end for loop
            } // bundle is null

        } catch (Exception e) {
            Log.e("SmsReceiver", "Exception smsReceiver" +e);

        }
    }*/
    public static String getCurrentTime(){
        Calendar cal = Calendar.getInstance();
        int second = cal.get(Calendar.SECOND);
        int minute = cal.get(Calendar.MINUTE);
        int hour = cal.get(Calendar.HOUR);
        //.out.println( sdf.format(cal.getTime()) );
        return hour + ":" + minute + ":" + second;
    }
    //test change
/*    public static String getMessage(){
        return smsMessage;
    }
    private static void setMessage(String message){
        smsMessage = message;
    }*/
}