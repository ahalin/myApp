package com.example.myapp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Random;

import com.example.myapp.CircleCanvas.CircleInfo;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends Activity {

	private static final String TAG = MainActivity.class.getSimpleName();
	private CircleCanvas mCircleCanvas;

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode)
		{
		case 1:
			switch (resultCode)
			{
			case 2:
				Log.d(TAG, "recv reuslt 2:" + data.getStringExtra("value"));
				break;
			default:
				Log.d(TAG, "unkown result code:"+resultCode);
				break;
			}
			break;
		default:
			Log.d(TAG,"unknow req code:"+requestCode);
			break;
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ViewGroup viewGroup = (ViewGroup) this.getLayoutInflater().inflate(R.layout.activity_main, null);
		mCircleCanvas = new CircleCanvas (this);
		viewGroup.addView(mCircleCanvas, new LayoutParams (LayoutParams.FILL_PARENT, 350));
		setContentView (viewGroup);
		//setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			/*
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
					*/
		}
		if (!getPackageManager().hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE))
		{
			Toast.makeText(this, "no ble", Toast.LENGTH_SHORT).show();
		}
		else
		{
			Toast.makeText(this, "BLE", Toast.LENGTH_SHORT).show();
		}
	}
	
	public void onClick_DrawRandomCircle (View view)
	{
		Random rand = new Random ();
		float randomX = (100 + rand.nextInt(100));
		float randomY = (100 + rand.nextInt(100));
		float radius = (20 + rand.nextInt(40));
		int randomColor = 0;
		if (rand.nextInt(100) > 50)
		{
			randomColor = Color.BLUE;
		}
		else
		{
			if (rand.nextInt(100)>50)
				randomColor = Color.RED;
			else
				randomColor = Color.GREEN;
		}
		CircleInfo info = new CircleInfo ();
		info.setX(randomX);
		info.setY(randomY);
		info.setRadius(radius);
		info.setColor(randomColor);
		mCircleCanvas.mCircleInfos.add(info);
		mCircleCanvas.invalidate();
	}
	
	public void onClick_Clear (View view)
	{
		mCircleCanvas.mCircleInfos.clear();
		mCircleCanvas.invalidate();
	}
	
	public void onClick_OpenAct1 (View v)
	{
		Intent intent = new Intent (this, MyActivity1.class);
		startActivityForResult (intent,1);
		/*
		ClipboardManager clipboard = (ClipboardManager) getSystemService (Context.CLIPBOARD_SERVICE);
		Data clipboardData = new Data ();
		String base64Str = "";
		clipboardData.id = 789;
		clipboardData.name = "Transfer Data through clipboard";
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ObjectOutputStream oos = new ObjectOutputStream (baos);
			oos.writeObject(clipboardData);
			base64Str = Base64.encodeToString(baos.toByteArray(), Base64.DEFAULT);
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Log.d(TAG, base64Str);
		clipboard.setText(base64Str);
		startActivity (intent);
		*/
	}

	public void onClick_OpenAct2 (View v)
	{
		Intent intent = new Intent ("myact1");
		startActivity (intent);
	}

	public void onClick_OpenAct3 (View v)
	{
		Intent intent = new Intent ("myact2");
		intent.addCategory("mycat");
		startActivity (intent);
	}
	
	private int value = 1;
	public void onClick_test (View v)
	{
		Button btn = (Button)findViewById(R.id.button1);
		Log.d(TAG,"click test");
		//Button btn = (Button)v;
		if (value == 1 && btn.getWidth() == getWindowManager().getDefaultDisplay().getWidth())
			value = -1;
		else if (value == -1 && btn.getWidth()<100) {
			value =1;
		}
		btn.setWidth(btn.getWidth()+(int)(btn.getWidth()*0.1)*value);
		btn.setHeight(btn.getHeight()+(int)(btn.getWidth()*0.1)*value);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	/*
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}
*/
}
