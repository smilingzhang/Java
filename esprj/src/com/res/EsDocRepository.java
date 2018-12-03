package com.res;


/**
 * 
 *@desc:定义一个接口
 *@author chunhui
 *@date:Nov 21, 20183:27:03 PM
 */
public interface EsDocRepository extends ElacticSearchRepository<EsDoc,String>{
	//定义一个方法根据关键字在title summary content进行全文搜索 分页检索
	Page<EsDoc> findDistinctEsDocByTitleContainingOrSummaryContainingOrContentContaining(String title,String summary,String content,Pageable pageable);
}
