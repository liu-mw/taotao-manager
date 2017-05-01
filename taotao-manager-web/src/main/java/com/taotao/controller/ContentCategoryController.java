package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.service.ContentCategoryService;

@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {
	//展示cms管理的内容
	@Autowired
	private ContentCategoryService contentCategoryService;
	
	@RequestMapping("/list")
     @ResponseBody
	public List<EUTreeNode> getContentCatList(@RequestParam(value="id", defaultValue="0")Long parentId) {
		List<EUTreeNode> list = contentCategoryService.getCategoryList(parentId);
		return list;
	}
	//增加cms：内容分类管理系统的节点
	@RequestMapping("/create")
	@ResponseBody
	public TaotaoResult createContentCategory(Long parentId, String name) {
		TaotaoResult result = contentCategoryService.insertContentCategory(parentId, name);
		return result;
	}

}
