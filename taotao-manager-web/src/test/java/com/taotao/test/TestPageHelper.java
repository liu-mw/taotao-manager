package com.taotao.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;

public class TestPageHelper {
	@Test
	public void testPageHelper(){
		//测试分页效果
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		//获取代理对象
		TbItemMapper mapper = applicationContext.getBean(TbItemMapper.class);
		TbItemExample example = new TbItemExample();
		PageHelper.startPage(2, 10);
		List<TbItem> list = mapper.selectByExample(example);
		for(TbItem tbItem:list){
			System.out.println(tbItem.getTitle());
		}
		//获得分页信息
		//取分页信息
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		System.out.println("共有商品："+ total);

	}
}
