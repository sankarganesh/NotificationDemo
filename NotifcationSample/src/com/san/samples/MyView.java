package com.san.samples;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;

public class MyView extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Calendar Calendar_Object = Calendar.getInstance();
		Calendar_Object.set(Calendar.MONTH, 8);
		Calendar_Object.set(Calendar.YEAR, 2012);
		Calendar_Object.set(Calendar.DAY_OF_MONTH, 6);

		Calendar_Object.set(Calendar.HOUR_OF_DAY, 14);
		Calendar_Object.set(Calendar.MINUTE, 25);
		Calendar_Object.set(Calendar.SECOND, 0);

		// MyView is my current Activity, and AlarmReceiver is the
		// BoradCastReceiver
		Intent myIntent = new Intent(MyView.this, AlarmReceiver.class);

		PendingIntent pendingIntent = PendingIntent.getBroadcast(MyView.this,
				0, myIntent, 0);

		AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

		/*
		 * The following sets the Alarm in the specific time by getting the long
		 * value of the alarm date time which is in calendar object by calling
		 * the getTimeInMillis(). Since Alarm supports only long value , we're
		 * using this method.
		 */

		alarmManager.set(AlarmManager.RTC, Calendar_Object.getTimeInMillis(),
				pendingIntent);
	}
}