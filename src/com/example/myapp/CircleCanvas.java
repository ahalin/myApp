package com.example.myapp;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class CircleCanvas extends View {
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		for (CircleInfo info : mCircleInfos)
		{
			Paint paint = new Paint();
			paint.setColor(info.getColor());
			canvas.drawCircle(info.getX(), info.getY(), info.getRadius(), paint);
		}
	}

	public List<CircleInfo> mCircleInfos = new ArrayList<CircleCanvas.CircleInfo>();

	public CircleCanvas(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public static class CircleInfo {
		private float x,y;
		private float radius;
		private int color;
		public float getX() {
			return x;
		}
		public void setX(float x) {
			this.x = x;
		}
		public float getY() {
			return y;
		}
		public void setY(float y) {
			this.y = y;
		}
		public float getRadius() {
			return radius;
		}
		public void setRadius(float radius) {
			this.radius = radius;
		}
		public int getColor() {
			return color;
		}
		public void setColor(int color) {
			this.color = color;
		}
	}
}
