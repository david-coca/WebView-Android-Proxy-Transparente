package com.example.bonuzapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.content.Context;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		WebView myWebView = (WebView) findViewById(R.id.webview);

		ProxyUtils.setProxy(this, myWebView, "192.168.88.194", 3177);

		//myWebView.loadUrl("http://www.terra.com.br");
		myWebView.loadUrl("https://bonuz.typeform.com/to/epLiKL");
		// myWebView.loadDataWithBaseURL(baseUrl, data, mimeType, encoding,
		// failUrl);

		
		myWebView.setWebChromeClient(new WebChromeClient());
		
		myWebView.setWebViewClient(new WebViewClient() {
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				return false;
			}

		});

		 

		WebSettings webSettings = myWebView.getSettings();
		webSettings.setJavaScriptEnabled(true);

		/**
		 * Set the proxy.
		 * <p>
		 * To unset the proxy, call this method with host as null and port as 0.
		 * 
		 * @param appContext
		 *            The application context.
		 * @param webview
		 *            The webView to set the proxy on.
		 * @param host
		 *            The hostname
		 * @param port
		 *            The port
		 * 
		 * @return True if the proxy was set successfully, false otherwise.
		 */

	}
}
