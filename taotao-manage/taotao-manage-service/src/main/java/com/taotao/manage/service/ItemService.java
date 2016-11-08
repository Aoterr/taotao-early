package com.taotao.manage.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.abel533.entity.Example;
import com.github.abel533.mapper.Mapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.bean.EasyUIResult;
import com.taotao.manage.mapper.ItemMapper;
import com.taotao.manage.pojo.Item;
import com.taotao.manage.pojo.ItemDesc;

@Service
public class ItemService extends BaseService<Item> {

	@Autowired
	public ItemMapper itemMapper;
	
	@Autowired
	public ItemDescService itemDescService;
	

	@Override
	public Mapper<Item> getMapper() {
		// TODO Auto-generated method stub
		System.out.println(itemMapper+"!!!!!!!!!!!!!!!!!!!!");
		return this.itemMapper;
	}



	public void saveItem(Item item, String desc) {
		// TODO Auto-generated method stub
		super.save(item);
		ItemDesc itemDesc = new ItemDesc();
		itemDesc.setItemId(item.getId());
		itemDesc.setItemDesc(desc);
		itemDescService.save(itemDesc);
	}


	
	public EasyUIResult queryItemList(Integer page, Integer rows) {
		// TODO Auto-generated method stub
		
		
		PageHelper.startPage(page, rows);
		
		Example example = new Example(Item.class);
		example.setOrderByClause("created DESC");
		List<Item> items = itemMapper.selectByExample(example);
		PageInfo<Item> pageInfo = new PageInfo<>(items);
		return new EasyUIResult(pageInfo.getTotal(),pageInfo.getList());
	}
	

}
