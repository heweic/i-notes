package org.mypro.web.controller;

import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

	private static Log log = LogFactory.getLog(IndexController.class);

	@GetMapping("/")
	public String index() {
		log.info("收到请求");
		return "index";
	}

	public static void main(String[] args) {

			
			IndexController obj = new IndexController();
			System.out.println(obj.hashCode());
//			System.out.println(new IndexController().hashCode());
//			System.out.println(new IndexController().hashCode());
			int h;
			int index = (h = obj.hashCode() ) ^ (h >>> 16);

			System.out.println(index);
			index = 16 & index;
			System.out.println(index);
		
	}
	
}
