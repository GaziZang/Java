package gz.maven.web.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.*;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;
import java.util.List;

/**
 * http工具类
 *
 * @author
 *
 */
public class HttpUtil {
	private static final Logger LOG = LoggerFactory.getLogger(HttpUtil.class);

	private static PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
	// 默认编码
	private static final String DEFAULT_CHARSET = "UTF-8";

	private static final HttpRequestRetryHandler httpRequestRetryHandler = new HttpRequestRetryHandler() {
		public boolean retryRequest(IOException exception,
									int executionCount, HttpContext context) {
			if (executionCount >= 3) {//重试3次
				return false;
			}
			if (exception instanceof NoHttpResponseException) {// 如果服务器丢掉了连接，那么就重试
				return true;
			}
			if (exception instanceof SSLHandshakeException) {//不要重试SSL握手异常
				return false;
			}
			if (exception instanceof InterruptedIOException) {//超时重度
				return true;
			}
			if (exception instanceof UnknownHostException) {//目标服务器不可达
				return false;
			}
			if (exception instanceof ConnectTimeoutException) {//连接被拒绝
				return false;
			}
			if (exception instanceof SSLException) {// SSL握手异常
				return false;
			}

			HttpClientContext clientContext = HttpClientContext
					.adapt(context);
			HttpRequest request = clientContext.getRequest();
			// 如果请求是幂等的，就再次尝试
			if (!(request instanceof HttpEntityEnclosingRequest)) {
				return true;
			}
			return false;
		}
	};

	static {
		// httpClinet 版本4.3以上支持 pollingHttpClinetConnnectionManager
		// 将最大连接数增加到200
		cm.setMaxTotal(300);
		// 因为目前只有一个,所以将该值跟最大者设置成一样的. 否则到api的最大不能超过该默认值.
		cm.setDefaultMaxPerRoute(300);
		// 将目标主机的最大连接数增加到200
		SocketConfig sc = SocketConfig.custom().setSoTimeout(1000).build();
		cm.setDefaultSocketConfig(sc);
	}

	public static String post(String host, List<NameValuePair> params) throws ParseException, IOException {
		return customPost(host, params, DEFAULT_CHARSET, 100, 100, 300);
	}

	public static String customPost(String host, List<NameValuePair> params, String charset, int connReqTimeout,
									int connTimeout, int socketTimeout) throws ParseException, IOException {
		HttpPost post = new HttpPost(host);
		RequestConfig.Builder builder = RequestConfig.custom().setConnectionRequestTimeout(connReqTimeout)
				.setConnectTimeout(connTimeout).setSocketTimeout(socketTimeout);
		post.setConfig(builder.build());

		if (params != null && params.size() > 0) {
			UrlEncodedFormEntity uefe = new UrlEncodedFormEntity(params, charset);
			post.setEntity(uefe);
		}
		CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).setRetryHandler(httpRequestRetryHandler).build();
		CloseableHttpResponse response = null;
		try {
			 response = httpClient.execute(post);
			return EntityUtils.toString(response.getEntity());
		}finally {
			if(response!=null){
				try {
					response.close();
				}catch (IOException e){
					LOG.error("关闭连接异常,"+e.getMessage(),e);
				}
			}
		}
	}

	/**
	 * ip地址转数字(点分十进制)
	 *
	 * @param ip
	 * @return
	 */
	public static long ip2num(String ip) {
		if (StringUtils.isEmpty(ip)) {
			throw new IllegalArgumentException("ip is empty");
		}
		String[] sections = StringUtils.split(ip, ".");
		if (sections.length > 4) {
			throw new IllegalArgumentException("ip is not well-formated， ip:" + ip);
		}
		long num = 0;
		int i = 3;
		for (String str : sections) {
			num += (Long.parseLong(str) << (i * 8));
			i--;
		}
		return num;
	}

}
