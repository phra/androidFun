package com.example.fun;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

	public class MyDummy2 extends Fragment {

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			//super.onCreateView(inflater, container, savedInstanceState);
			View rootView = inflater.inflate(R.layout.mydummy2,
					container, false);
			TextView dummyTextView = (TextView) rootView
					.findViewById(R.id.section_label);
			dummyTextView.setText("TESTING FRAGMENTS");
			Button button = (Button) rootView.findViewById(R.id.button1);
			button.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Context context = v.getContext();
					NotificationManager nm = (NotificationManager) context.getSystemService(Service.NOTIFICATION_SERVICE);
					Notification note = new Notification(R.drawable.ic_launcher,"notification motherfucker",System.currentTimeMillis());
					note.defaults = Notification.DEFAULT_ALL;
					Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.google.com"));
					PendingIntent pi = PendingIntent.getActivity(context, 0, intent, 0);
					note.setLatestEventInfo(getActivity(), "titolo", "testo", pi);
					nm.notify(0, note);
				}
			});
			return rootView;

		}

	}