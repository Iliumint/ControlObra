package com.controlobrahito;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.webkit.WebView;

public class GoogleImageGraphActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_google_image_graph);
		
		String GraphURL = "http://chart.googleapis.com/chart?chxr=0,2010,2013|1,100,1300" +
                "&chxs=0,676767,8.5,0,l,676767&chxt=x,y&chbh=a,3,80&chs=1000x300" +
                "&cht=bvg&chco=3366CC,FF0000&chds=0,1170,0,1120" +
                "&chd=t:1000,1170,660,1030|400,460,1120,540&chdl=Sales|Expenses" +
                "&chg=0,-1&chtt=Truiton%27s+Performance";
        Log.e("GraphURL :", GraphURL);
        WebView webview = (WebView) findViewById(R.id.webView);
        webview.loadUrl(GraphURL);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.google_image_graph, menu);
		return true;
	}

}
