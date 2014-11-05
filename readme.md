#WebView Android com servidor proxy. (POC)
Este documento tem como objetivo apresentar o conceito de utilização do componente WebView do Android para consumo de URLS através de um proxy.


##Proxy Transparente
Para que a esta POC funcione é necessário ter a disposição um servidor proxy transparente devidamente configurado.

###Considerações
O componente WebView não oferece um recurso para utilização de um servidor proxy. 
Para definir tal configuração é necessário sobrescrever as configurações do mesmo definindo assim um comportamento diferenciado para as requisições http(s).
Para isso utilizamos uma classe que via reflection copia as configurações pertinentes as requisições HTTP E HTTPS, tornando possível assim a sua alteração. 



**Exemplo:**  

```java
WebView myWebView = (WebView) findViewById(R.id.webview);

	ProxyUtils.setProxy(this, myWebView, "192.168.88.194", 3177);
	myWebView.loadUrl("http://www.uol.com.br");

	myWebView.setWebChromeClient(new WebChromeClient());
		
	myWebView.setWebViewClient(new WebViewClient() {
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			return false;
		}
	});

	WebSettings webSettings = myWebView.getSettings();
	webSettings.setJavaScriptEnabled(true);
```

###Referências
http://karthikramgopal-android.blogspot.com.br/2014/01/webview-proxy.html