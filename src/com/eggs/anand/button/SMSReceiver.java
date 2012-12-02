package com.eggs.anand.button;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

public class SMSReceiver extends BroadcastReceiver {
    public SMSReceiver() {
    }
    
    private final String MESSAGE_KEY = "abcd";
    
    @Override
    public void onReceive(Context context, Intent intent) {
    	
    	Log.d(getResultData(), "got into onReceive", null);
    	
    	Bundle bundle = intent.getExtras();

		Object messages[] = (Object[]) bundle.get("pdus");
		SmsMessage smsMessage[] = new SmsMessage[messages.length];
		for (int n = 0; n < messages.length; n++) {
		smsMessage[n] = SmsMessage.createFromPdu((byte[]) messages[n]);
		}	
		
		System.out.println(smsMessage[0].getMessageBody() + ", "+ Integer.toString(messages.length));
		Intent anandSoundIntent = new Intent(context, AnandService.class);
		if(messages.length == 1) {
			System.out.println("messages.length = 1");
			String message = smsMessage[0].getMessageBody();
			message = message.substring(1, message.length()-1);
			if(message.equals(MESSAGE_KEY)) {
				System.out.println("the key fit in the hole");
				context.startService(anandSoundIntent);
				this.abortBroadcast();
			}
		}        
    }
}
