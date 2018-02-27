package com.roncoo.eshop.product.ha.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.*;

/**
 * 商品服务的接口
 * @author Administrator
 *
 */
@Controller
public class ProductController {

	@RequestMapping("/getProductInfo")
	@ResponseBody
	public String getProductInfo(Long productId) {
		return "{\"id\": " + productId + ", \"name\": \"iphone7手机\", \"price\": 5599, \"pictureList\":\"a.jpg,b.jpg\", \"specification\": \"iphone7的规格\", \"service\": \"iphone7的售后服务\", \"color\": \"红色,白色,黑色\", \"size\": \"5.5\", \"shopId\": 1, \"modifiedTime\": \"2017-01-01 12:00:00\"}";
	}

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		Future<Integer> future = executorService.submit(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				System.out.println("子线程执行for循环");
				Thread.sleep(5000);
				int sum =0;
				for(int i=0;i<100;i++){
					sum+=i;
				}
				return sum;
			}
		});
//		Thread.sleep(3000);
		System.out.println("主线程在执行");
		System.out.println("子线程执行完:"+future.get()+"");
		System.out.println("asdadadadadadada");
		executorService.shutdown();
//		if(future.isDone()){
//			System.out.println("子线程执行完for循环结果为："+future.get()+"");
//		}else {
//			System.out.println("子线程还未执行完for虚幻");
//		}

	}
	
}
