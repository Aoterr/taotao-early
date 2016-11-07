package com.taotao.manage.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "page")
public class PageController {

	@RequestMapping(value="{pageName}")
	public String page(@PathVariable("pageName") String pageName){
		return pageName;
	}
}
