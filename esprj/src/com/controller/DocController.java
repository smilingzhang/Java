package com.controller;
/**
 * 
 *@desc:一句话被描述
 *@author chunhui
 *@date:Nov 21, 20184:13:10 PM
 */

import java.util.List;

import com.entity.EsDoc;
import com.res.EsDocRepository;
import com.test.Autowired;
import com.test.Page;
import com.test.PageRequest;
import com.test.Pageable;

@RestController
@RequestMapping("/docs")
public class DocController {
	
	@Autowired
	private EsDocRepository esDocRepository;
	
	
//查询博客列表
	@GetMapping
	public List<EsDoc> list(@RequestParam(value="title") String title,
			@RequestParam(value="summary") String summary,
			@RequestParam(value="content") String content,
			@RequestParam(value="pageIndex",defalut="0") int pageIndex,
			@RequestParam(value="pageSize",defalut="10") int pageSize){
		Pageable pageable=new PageRequest(pageIndex,pageSize);
		Page<EsDoc> page=esDocRepository.findDistinctEsDocByTitleContainingOrSummaryContainingOrContentContaining(title, summary, content,pageable);
		
		return page.getContent();
	}
}
