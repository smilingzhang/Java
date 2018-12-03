package com.test;

import com.entity.EsDoc;
import com.res.EsDocRepository;

/**
 * 
 *@desc:接口测试 需要引入上下文
 *@author chunhui
 *@date:Nov 21, 20183:29:14 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsDocRepositoryTest {
	//引入资源库
	@Autowired
	private EsDocRepository esDocRepository;
	//初始化资源库数据
	@Before   //代表在测试之前执行
	public void initRepositoryData() {
		//先清除所有数据
		esDocRepository.deleteAll();
		
		//初始化数据
		esDocRepository.save(new EsDoc("黄鹤楼", "王之涣的黄鹤楼", "白日依山尽，黄河入海流，欲穷千里目，更上一层楼"));
		esDocRepository.save(new EsDoc("相思", "王维的相思", "红豆生南国，春来发几枝，愿君多采撷，此物最相思"));
		esDocRepository.save(new EsDoc("静夜思", "李白的静夜思", "床前明月光，疑是地上霜，举头望明月，低头思故乡"));		
	}

	@Test
	public void testFindDistinctEsDocByTitleContainingOrSummaryContainingOrContentContaining() {
		Pageable pageable=new PageRequest(0,20);//一页20条数据
		String title="思";
		String summary="相思";
		String content="相思";
		Page<EsDoc> page=esDocRepository.findDistinctEsDocByTitleContainingOrSummaryContainingOrContentContaining(title, summary, content,pageable);
		//使用断言  指定期望有多少匹配结果，不要把太多的数据展示出来
		assertThat(page.getTotalElements()).isEqualTo(2);
		
		
		//把拿到的数据打印出来 page.getContent()获取数据列表
		System.out.println("============start");
		for(EsDoc doc:page.getContent()) {
			System.out.println(doc.toString());
		}
		System.out.println("============end");
		
		
	}

}
