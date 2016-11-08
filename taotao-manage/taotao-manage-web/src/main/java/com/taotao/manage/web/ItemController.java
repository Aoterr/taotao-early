package com.taotao.manage.web;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.taotao.common.bean.EasyUIResult;
import com.taotao.manage.pojo.Item;
import com.taotao.manage.pojo.ItemDesc;
import com.taotao.manage.service.ItemDescService;
import com.taotao.manage.service.ItemService;

@Controller
@RequestMapping(value = "item")
public class ItemController {

	@Autowired
	public ItemService itemService;


	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Item> saveItem(Item item, @RequestParam("desc") String desc) {

		try {
			item.setStatus(1);
			item.setId(null);
			itemService.saveItem(item,desc);
			
			return new ResponseEntity(HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<EasyUIResult> queryItemList(
			@RequestParam(value="page",defaultValue="1") Integer page,
			@RequestParam(value = "rows",defaultValue = "30") Integer rows){
		
		
		try {
			EasyUIResult eaEasyUIResult = itemService.queryItemList(page,rows);
			return new ResponseEntity(eaEasyUIResult,HttpStatus.OK);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
