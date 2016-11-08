package com.taotao.manage.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.abel533.mapper.Mapper;
import com.taotao.manage.mapper.ItemCatMapper;
import com.taotao.manage.pojo.ItemCat;

@Service
public class ItemCatService extends BaseService<ItemCat>{

	@Autowired
	public ItemCatMapper itemCatMapper;

//	public List<ItemCat> queryItemCatListByParentsId(Long pid) {
//		// TODO Auto-generated method stub
//		ItemCat itemCat = new ItemCat();
//		itemCat.setParentId(pid);
//		return itemCatMapper.select(itemCat);
//	}

	@Override
	public Mapper<ItemCat> getMapper() {
		// TODO Auto-generated method stub
		return this.itemCatMapper;
	}
}
