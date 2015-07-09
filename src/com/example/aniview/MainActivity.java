package com.example.aniview;

import java.util.ArrayList;
import java.util.List;

import com.example.aniview.RotatablePie.pieShowAnimation;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	private RoundBollProgress rbp;
	private RoundAniRec rar;
	private RotatablePie rpie;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		rbp = (RoundBollProgress) findViewById(R.id.rbp);
		rar = (RoundAniRec) findViewById(R.id.rar);
		rpie = (RotatablePie) findViewById(R.id.rpie);
//		rpie.setSpecialAngle(90);
//		rpie.pieInterWidth=3;
//		rpie.showW = true;
//		rpie.TXlong = 50;
//		rpie.TstartAtTouch = true;
		rpie.movingShowTX = true;
		rpie.setShowCenterAll(true);
		rpie.showInCenAngle = true;
//		rpie.TstartAtTouch = true;
//		rpie.AniLine = false;
//		rpie.showLine = false;
//		rpie.lpading = 10;
		rpie.PieSelector = false;
//		rpie.selectAfterMove = true;
//		rpie.setClickPosition(2);
//		rpie.clickPosition=0;
//		rpie.Tswidth = 50;
//		rpie.nRadius = 0;
		rpie.TsColor = Color.RED;
		rpie.pieInterWidth = 2;
//		rpie.setPieRotateable(false);
		rpie.pieInterColor = Color.BLACK;
//		rpie.TsWidth= 2;
		rpie.setPieShowAnimation(pieShowAnimation.SCANNING);
//		rpie.setShowPieAnimation(false);
		rar.setAniCurrentProgress(20);
		setdata();
	}

	private void setdata() {
		List<Float> data = new ArrayList<Float>();
		data.add(45f);
		data.add(35f);
		data.add(42f);
		data.add(15f);
		data.add(35f);
		rpie.setPiedata(data);
		List<String> desc = new ArrayList<>();
		desc.add("33");
		desc.add("23");
		desc.add("13");
		desc.add("13");
		desc.add("13");
		rpie.setDescPiedata(desc);
//		rar.setAniCurrentProgress(10);
	}

	public void click(View v) {
		rpie.aniShowPie();
		rbp.setBoxRadius(10);
		rbp.setAniSweepAngle(300);
		
//		rar.setCurrentProgress(50);
		rar.setAniCurrentProgress(rar.getCurrentProgress(),50);
//		rar.setAniRecChange(0,rar.getHeight()>rar.getWidth()?rar.getHeight():rar.getWidth());
		rpie.setEachPieColor();
		rpie.postInvalidate();
		rpie.setClickPosition(0);
		
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
}
