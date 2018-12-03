package com.test;

import com.entity.EsDoc;
import com.res.EsDocRepository;

/**
 * 
 *@desc:�ӿڲ��� ��Ҫ����������
 *@author chunhui
 *@date:Nov 21, 20183:29:14 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsDocRepositoryTest {
	//������Դ��
	@Autowired
	private EsDocRepository esDocRepository;
	//��ʼ����Դ������
	@Before   //�����ڲ���֮ǰִ��
	public void initRepositoryData() {
		//�������������
		esDocRepository.deleteAll();
		
		//��ʼ������
		esDocRepository.save(new EsDoc("�ƺ�¥", "��֮���Ļƺ�¥", "������ɽ�����ƺ��뺣��������ǧ��Ŀ������һ��¥"));
		esDocRepository.save(new EsDoc("��˼", "��ά����˼", "�춹���Ϲ�����������֦��Ը�����ߢ����������˼"));
		esDocRepository.save(new EsDoc("��ҹ˼", "��׵ľ�ҹ˼", "��ǰ���¹⣬���ǵ���˪����ͷ�����£���ͷ˼����"));		
	}

	@Test
	public void testFindDistinctEsDocByTitleContainingOrSummaryContainingOrContentContaining() {
		Pageable pageable=new PageRequest(0,20);//һҳ20������
		String title="˼";
		String summary="��˼";
		String content="��˼";
		Page<EsDoc> page=esDocRepository.findDistinctEsDocByTitleContainingOrSummaryContainingOrContentContaining(title, summary, content,pageable);
		//ʹ�ö���  ָ�������ж���ƥ��������Ҫ��̫�������չʾ����
		assertThat(page.getTotalElements()).isEqualTo(2);
		
		
		//���õ������ݴ�ӡ���� page.getContent()��ȡ�����б�
		System.out.println("============start");
		for(EsDoc doc:page.getContent()) {
			System.out.println(doc.toString());
		}
		System.out.println("============end");
		
		
	}

}
