package com.example.myapp;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class MyActivity1 extends Activity {
	private static final String TAG = MyActivity1.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "onCreate");
		
		setContentView(R.layout.my_act1);
		//ClipboardManager clipboard = (ClipboardManager) getSystemService (Context.CLIPBOARD_SERVICE);
		//String base64Str = clipboard.getPrimaryClipDescription().toString();
		//String base64Str = clipboard.getText().toString();
		String html="<font color='red'>I love Android.</font><br>";
		html+="<font color='#0000FF'><big><i>I love Android.</i></big></font><br>";
		
		CharSequence cs = Html.fromHtml(html);
		TextView tv = (TextView) this.findViewById(R.id.textView1);
		tv.setText(cs);
		//tv.setText(base64Str);
		
		/*
		EditText edText = new EditText (this);
		edText.setText("123");
		ViewGroup vgrp = (ViewGroup) this.getLayoutInflater().inflate(R.layout.my_act1, null);
		vgrp.addView(edText);
		setContentView (vgrp);
		*/
	}
	
	public void onClick_Btn (View view)
	{
		Intent intent = new Intent ();
		intent.putExtra("value", "test");
		setResult (2, intent);
		finish();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d(TAG, "onDestroy");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.d(TAG, "onPause");
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Log.d(TAG, "onRestart");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.d(TAG, "onResume");
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.d(TAG, "onStart");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.d(TAG, "onStop");
	}

}