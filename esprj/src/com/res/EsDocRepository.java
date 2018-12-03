package com.res;


/**
 * 
 *@desc:����һ���ӿ�
 *@author chunhui
 *@date:Nov 21, 20183:27:03 PM
 */
public interface EsDocRepository extends ElacticSearchRepository<EsDoc,String>{
	//����һ���������ݹؼ�����title summary content����ȫ������ ��ҳ����
	Page<EsDoc> findDistinctEsDocByTitleContainingOrSummaryContainingOrContentContaining(String title,String summary,String content,Pageable pageable);
}
