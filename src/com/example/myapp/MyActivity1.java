package com.example.myapp;

import java.lang.reflect.Field;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.Html.ImageGetter;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.SpannableString;
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
		/*
		//ClipboardManager clipboard = (ClipboardManager) getSystemService (Context.CLIPBOARD_SERVICE);
		//String base64Str = clipboard.getPrimaryClipDescription().toString();
		//String base64Str = clipboard.getText().toString();
		String html="<font color='red'>I love Android.</font><br>";
		html+="<font color='#0000FF'><big><i>I love Android.</i></big></font><br>";
		html+="<img src='ic_my'/>";
		
		CharSequence cs = Html.fromHtml(html, new ImageGetter()
		{

			@Override
			public Drawable getDrawable(String arg0) {
				Drawable drawable = getResources().getDrawable(getResourceId(arg0));
				drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
				return drawable;
			}
			
		}, null);
		TextView tv = (TextView) this.findViewById(R.id.textView1);
		tv.setText(cs);
		//tv.setText(base64Str);
		
		/ *
		EditText edText = new EditText (this);
		edText.setText("123");
		ViewGroup vgrp = (ViewGroup) this.getLayoutInflater().inflate(R.layout.my_act1, null);
		vgrp.addView(edText);
		setContentView (vgrp);
		* /
		
		*/
		TextView textView1 = (TextView) findViewById(R.id.textView1);
		TextView textView2 = (TextView) findViewById(R.id.textView2);
		String text1 = "show act1";
		String text2 = "show act2";
		String text = "<¨S¦³­I´º><¶À¦â­I´º>";
		SpannableString spannableString1 = new SpannableString(text1);
		SpannableString spannableString2 = new SpannableString(text2);
		SpannableString spannableString3 = new SpannableString(text);
		spannableString1.setSpan(new ClickableSpan() {
			
			@Override
			public void onClick(View widget) {
				startActivity(new Intent(MyActivity1.this, MyActivity2.class));
			}
		},	0, text1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		spannableString2.setSpan(new ClickableSpan() {
			
			@Override
			public void onClick(View widget) {
				startActivity(new Intent(MyActivity1.this, MyActivity3.class));
			}
		},	0, text2.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		
		spannableString3.setSpan(new BackgroundColorSpan(Color.YELLOW), 6, 12, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		spannableString3.setSpan(new CharacterStyle() {
			
			@Override
			public void updateDrawState(TextPaint tp) {
				tp.bgColor = Color.RED;
				tp.setColor(Color.BLUE);
			}
		}, 0, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		
		textView1.setText(spannableString1);
		textView2.setText(spannableString2);
		textView2.setText(spannableString3);
		textView1.setMovementMethod(LinkMovementMethod.getInstance());
		textView2.setMovementMethod(LinkMovementMethod.getInstance());
	}
	
	protected int getResourceId(String arg0) {
		try {
			Field field = R.drawable.class.getField(arg0);
			return Integer.parseInt(field.get(null).toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
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
