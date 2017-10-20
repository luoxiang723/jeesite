package lx.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CyclicBarrier;

public class HttpclientThread implements Runnable {

	private CyclicBarrier barrier;
	
	public HttpclientThread(CyclicBarrier cb){
		this.barrier = cb;
	}
	
	@Override
	public void run() {
		try{
			System.out.println("准备发送请求");
			//线程在这里等待，直到所有线程都到达barrier。
			barrier.await();
			System.out.println(Thread.currentThread().getId()+"开始发送请求");
			System.out.println("Worker's waiting");
			String url = "http://127.0.0.1:8080/gold/gateway/wms_gateway!testHttp.action";
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("code", "1");
			params.put("msg", "成功");
			try {
				String result = HttpClientUtil.post(url, params);
				System.out.println(Thread.currentThread().getId()+"："+result);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
