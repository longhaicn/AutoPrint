package com.newrocktech.autoprint.xml;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import com.newrocktech.autoprint.utils.Base64;

public class DeviceHttpRequest {
	private static TrustManager priX509TrustManager = new X509TrustManager() {
		@Override
		public X509Certificate[] getAcceptedIssuers() {
			return null;
		}

		@Override
		public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		}

		@Override
		public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		}
	};

	public static String sendGet(String url, String param, String Authorization) {
		if (url.contains("https")) {
			return sendHttpsGet(url, param, Authorization);
		} else {
			return sendHttpGet(url, param, Authorization);
		}
	}

	public static String sendPost(String url, String param, String Authorization) {
		if (url.contains("https")) {
			return sendHttpsPost(url, param, Authorization);
		} else {
			return sendHttpPost(url, param, Authorization);
		}
	}

	public static String sendHttpGet(String url, String param, String Authorization) {
		String result = "";
		BufferedReader in = null;
		HttpURLConnection connection = null;
		String urlNameString = url;
		try {
			if ((param != null) && (!"".equals(param)))
				urlNameString = urlNameString + "?" + param;
			URL realUrl = new URL(urlNameString);

			connection = (HttpURLConnection) realUrl.openConnection();

			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("content-type", "application/x-www-form-urlencoded");
			connection.setRequestProperty("User-Agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.2; Trident/4.0; .NET CLR 1.1.4322; .NET CLR 2.0.50727)");
			connection.setRequestProperty("Authorization", "Basic " + Base64.encode(Authorization + ":"));
			connection.setConnectTimeout(3000);
			connection.setReadTimeout(3000);

			connection.connect();

			in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
			String line;
			while ((line = in.readLine()) != null) {
				// String line;
				result = result + line;
			}
		} catch (Exception e) {
			System.out.println("HTTP GET异常！[Request:]" + urlNameString + " :" + Authorization + "[Error:]" + e);
			String str1 = e.getMessage();
			return str1;
		} finally {
			try {
				if (in != null)
					in.close();
				if (connection != null)
					connection.disconnect();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	public static String sendHttpsGet(String url, String param, String Authorization) {
		String result = "";
		BufferedReader in = null;
		HttpsURLConnection connection = null;
		String urlNameString = url;

		try {
			if ((param != null) && (!"".equals(param)))
				urlNameString = urlNameString + "?" + param;
			URL realUrl = new URL(urlNameString);
			HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
				public boolean verify(String hostname, SSLSession session) {
					// System.out.println("sendHttpsGet Warning: URL Host: " +
					// hostname + " vs. " + session.getPeerHost());
					return true;
				}
			});

			connection = (HttpsURLConnection) realUrl.openConnection();

			// 设置SSLContext
			SSLContext sslcontext = SSLContext.getInstance("TLS");
			sslcontext.init(null, new TrustManager[] { priX509TrustManager }, null);

			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("content-type", "application/x-www-form-urlencoded");
			connection.setRequestProperty("User-Agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.2; Trident/4.0; .NET CLR 1.1.4322; .NET CLR 2.0.50727)");
			connection.setRequestProperty("Authorization", "Basic " + Base64.encode(Authorization + ":"));
			connection.setSSLSocketFactory(sslcontext.getSocketFactory());
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			connection.connect();

			in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
			String line;
			while ((line = in.readLine()) != null) {
				// String line;
				result = result + line;
			}
		} catch (Exception e) {
			System.out.println("HTTPS GET异常！[Request:]" + urlNameString + " :" + Authorization + "[Error:]" + e);
			String str1 = e.getMessage();
			return str1;
		} finally {
			try {
				if (in != null)
					in.close();
				if (connection != null)
					connection.disconnect();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}

		return result;
	}

	public static String sendHttpPost(String url, String param, String Authorization) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		// URLConnection connection = null;
		HttpURLConnection connection = null;
		try {
			URL realUrl = new URL(url);
			connection = (HttpURLConnection) realUrl.openConnection();
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("content-type", "application/x-www-form-urlencoded");
			connection.setRequestProperty("User-Agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.2; Trident/4.0; .NET CLR 1.1.4322; .NET CLR 2.0.50727)");
			connection.setRequestProperty("Authorization", "Basic " + Base64.encode(Authorization + ":"));
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setConnectTimeout(3000);
			connection.setReadTimeout(3000);
			connection.connect();

			out = new PrintWriter(connection.getOutputStream());

			out.print(param);

			out.flush();

			in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
			String line;
			while ((line = in.readLine()) != null) {
				// String line;
				result = result + line;
			}
		} catch (Exception e) {
			System.out.println("HTTP POST异常！[Request:]" + url + "?" + param + " :" + Authorization + "[Error:]" + e);
			String str1 = e.getMessage();
			return str1;
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null)
					in.close();
				if (connection != null)
					connection.disconnect();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	public static String sendHttpsPost(String url, String param, String Authorization) {
		String result = null;
		DataOutputStream out = null;
		BufferedReader in = null;
		HttpsURLConnection httpsConn = null;

		try {
			// 设置SSLContext
			SSLContext sslcontext = SSLContext.getInstance("TLS");
			sslcontext.init(null, new TrustManager[] { priX509TrustManager }, null);

			// 打开连接
			URL requestUrl = new URL(url);
			HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
				public boolean verify(String hostname, SSLSession session) {
					System.out
							.println("sendHttpsPost Warning: URL Host: " + hostname + " vs. " + session.getPeerHost());
					return true;
				}
			});

			httpsConn = (HttpsURLConnection) requestUrl.openConnection();
			httpsConn.setRequestProperty("Authorization", "Basic " + Base64.encode(Authorization + ":"));
			httpsConn.setRequestProperty("Connection", "Close");
			System.setProperty("http.keepAlive", "false");
			httpsConn.setConnectTimeout(3000);
			httpsConn.setReadTimeout(3000);

			httpsConn.setUseCaches(false);
			// 设置套接工厂
			httpsConn.setSSLSocketFactory(sslcontext.getSocketFactory());

			// 加入数据
			httpsConn.setRequestMethod("POST");
			httpsConn.setDoOutput(true);

			httpsConn.connect();
			out = new DataOutputStream(httpsConn.getOutputStream());
			if (param != null)
				out.writeBytes(param);

			out.flush();

			// 获取输入流
			int code = httpsConn.getResponseCode();
			if (HttpsURLConnection.HTTP_OK == code) {
				in = new BufferedReader(new InputStreamReader(httpsConn.getInputStream()));
			} else {
				in = new BufferedReader(new InputStreamReader(httpsConn.getErrorStream()));
			}

			String temp = in.readLine();
			// 连接成一个字符串
			while (temp != null) {
				if (result != null)
					result += temp;
				else
					result = temp;
				temp = in.readLine();
			}

		} catch (Exception e) {
			System.out.println("HTTPS POST异常！[Request:]" + url + "?" + param + " :" + Authorization + "[Error:]" + e);
			String str1 = e.getMessage();
			return str1;
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null)
					in.close();
				if (httpsConn != null)
					httpsConn.disconnect();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		return result;
	}

	public static String getDelete(String url, String param, String Authorization) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);

			HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();

			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("content-type", "application/x-www-form-urlencoded");
			connection.setRequestProperty("User-Agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.2; Trident/4.0; .NET CLR 1.1.4322; .NET CLR 2.0.50727)");
			connection.setRequestProperty("Authorization", "Basic " + Base64.encode(Authorization + ":"));

			connection.setRequestMethod("DELETE");
			connection.setDoOutput(true);
			connection.setDoInput(true);

			out = new PrintWriter(connection.getOutputStream());

			out.print(param);

			out.flush();

			in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
			String line;
			while ((line = in.readLine()) != null) {
				// String line;
				result = result + line;
			}
		} catch (Exception e) {
			System.out.println("发送 Delete 请求出现异常！" + e);
			String str1 = e.getMessage();
			return str1;
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null)
					in.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	public static String sendPut(String urlStr, String param, String Authorization) throws Exception {
		String result = "";
		HttpURLConnection conn = null;
		BufferedReader in = null;
		try {
			URL url = new URL(urlStr);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("Authorization", "Basic " + Base64.encode(Authorization + ":"));
			conn.setRequestMethod("put");
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.getOutputStream().write(param.toString().getBytes("utf-8"));
			conn.getOutputStream().close();

			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				// String line;
				result = result + line;
			}
		} catch (Exception e) {
			String str1 = e.getMessage();
			return str1;
		} finally {
			if (in != null) {
				in.close();
			}
			if (in != null) {
				in.close();
			}
			if (conn != null)
				conn.disconnect();
		}
		return result;
	}

	public static String download(String urlStr, String fileName) throws Exception {
		// 构造URL
		URL url = new URL(urlStr);
		// 打开连接
		URLConnection con = url.openConnection();

		// 设置Java服务器代理连接，要不然报错403
		// 浏览器可以访问此url图片并显示，但用Java程序就不行报错Server returned HTTP response code:403
		// for URL
		// 具体原因：服务器的安全设置不接受Java程序作为客户端访问(被屏蔽)，解决办法是设置客户端的User Agent
		con.setRequestProperty("User-Agent", "Mozilla/4.0(compatible;MSIE 5.0;Windows NT;DigExt)");

		// 输入流
		InputStream is = con.getInputStream();

		// 1K的数据缓冲
		byte[] bs = new byte[1024];
		// 读取到的数据长度
		int len;
		// 输出的文件流
		OutputStream os = new FileOutputStream(fileName);
		// 开始读取
		while ((len = is.read(bs)) != -1) {
			os.write(bs, 0, len);
		}
		// 完毕，关闭所有链接
		os.close();
		is.close();

		return "OK";
	}
}
