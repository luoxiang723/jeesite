package lx.util;

import java.util.concurrent.CyclicBarrier;

public class TestHttpClientUtil {
	public static void main(String[] args) {
//		String url = "http://127.0.0.1:8080/gold/gateway/wms_gateway!testHttp.action";
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("code", "1");
//		params.put("msg", "0");
//		try {
//			String result = HttpClientUtil.post(url, params);
//			System.out.println(result);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		int count = 50;
		CyclicBarrier cb = new CyclicBarrier(count);
		for(int i=0;i<=count;i++){
			new Thread(new HttpclientThread(cb)).start();
		}
	}
}
