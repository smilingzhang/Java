package com.lucene;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.cjk.CJKAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.FieldType;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;

public class TestLucene {

	/**
	 * 
	 *@desc:��������������ݽ�������
	 *@return:void
	 * @throws IOException 
	 *@trhows
	 */
	@Test
	public void testAdd() throws IOException {
		//1.��������д����
		// ������Ӳ������Ĵ洢λ�ã��ڴ˹����»�����һ��hello���ļ���
		Directory directory = FSDirectory.open(new File("hello"));
		// lucene ��ǰʹ�õİ汾
		Version matchVersion = Version.LUCENE_44;
		// �ִ���, �����ǽ�һ���ı��ִ�
		// analyzer ��һ�������࣬������зִʹ���������ʵ�� ��ʱ���ö��ַ�
		Analyzer analyzer = new CJKAnalyzer(matchVersion);
		//��������д�������ö��󣬰���lecene�İ汾��ʹ�õķִ���
		IndexWriterConfig config = new IndexWriterConfig(matchVersion, analyzer);
		// ��������д��Ķ���  ����Ҫ��ŵ�λ��
		IndexWriter indexWriter = new IndexWriter(directory, config);
		//2.д���ĵ���Ϣ
				
		//����ĵ��������ĵ��Ĵ洢����
		FieldType type=new FieldType();
		type.setIndexed(true);//�Ƿ�Ҫ����
		type.setStored(true);//�Ƿ���Ҫ�洢
		
		// ����������д����,������������ݶ���document��һ��document�൱��һ����¼
		Document document1=new Document();
		// document.add(field) �������������̣��洢���ݺʹ�������
		//new Field(�ֶ������ֶ����ݣ��ֶε���������)
		document1.add(new Field("title", "doc1", type));
		document1.add(new Field("content", "�����й���", type));
		
		Document document2=new Document();
		document2.add(new Field("title", "doc2", type));
		document2.add(new Field("content", "������һ����", type));
		
		// ������������յĶ���document����
		indexWriter.addDocument(document1);
		indexWriter.addDocument(document2);
		System.out.println("����������");
		indexWriter.commit();
		indexWriter.close();
	}
	/**
	 * 
	 *@desc:�����������е��ֶΣ����µĲ�������ɾ��ԭ�ĵ���ź�����µ��ĵ���ţ���ŷ����仯
	 *@return:void
	 * @throws IOException 
	 * @throws ParseException 
	 *@trhows
	 */
	
	public void testUpdate() throws IOException, ParseException {
		//��������д����
        Directory d = FSDirectory.open(new File("hhh"));
        Analyzer analyzer = new CJKAnalyzer(Version.LUCENE_44);
        IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_44, analyzer);
        IndexWriter writer = new IndexWriter(d, config);
        //���¶���
        Term term = new Term("title", "doc2");//���µ�����       writer.deleteDocuments(term);����ɾ������

        Document updateDoc = new Document();//����֮����ĵ�����
        FieldType type = new FieldType();
        type.setIndexed(true);
        type.setStored(true);
        updateDoc.add(new Field("title", "doc2", type));
        updateDoc.add(new Field("content", "hello�ƺ�֮ˮ����������Ҫ����������", type));
        writer.updateDocument(term, updateDoc);
        //�ύ�������� �ͷ���Դ
        writer.commit();
        writer.close();
        searchIndex();
	}

	/**
	 * 
	 *@desc:��ѯ������
	 *@return:void
	 * @throws IOException 
	 * @throws ParseException 
	 *@trhows
	 */
	
	//��ѯʱ�������β� Query query  ������ȥ��Query��һ�У�����ʱ��������Ϊnew MatchAllDocsQuery()��ѯĿ¼�е������ĵ�
	
	@Test
	public void searchIndex() throws IOException, ParseException {
		//1.��������д����,ָ��������Ӳ���ϵĴ洢λ��
	    Directory d = FSDirectory.open(new File("hello"));
	    //�����ִ���
	    Analyzer analyzer = new CJKAnalyzer(Version.LUCENE_44);
	    //������Ŀ¼����ȡ��indexReader��
	    IndexReader r = DirectoryReader.open(d);
	    //����������ѯ����
	    IndexSearcher searcher = new IndexSearcher(r);
	    //���ĸ��ֶν��в�ѯ
	    QueryParser parser = new QueryParser(Version.LUCENE_44,"content", analyzer);
	    //�Ը��ֶβ�ѯ������
	    Query query = parser.parse("�й���");
	    //search(��ѯ����,����������ǰn����¼)
	    TopDocs search = searcher.search(query, 10000);//n:ǰ�������
	    System.out.println("���������ļ�¼�ж��ٸ�:" + search.totalHits);

	    ScoreDoc[] scoreDocs = search.scoreDocs;
	    for (int i = 0; i < scoreDocs.length; i++) {
	        System.out.println("*******************************");
	        System.out.println("Ȩ��:" + scoreDocs[i].score);//��ضȵ�����
	        //�õ�document��������
	        int docId = scoreDocs[i].doc;
	        //���������ŵõ��ĵ�������
	        Document document = searcher.doc(docId);
	        System.out.println("�ĵ���� docId--->" + docId);
	        System.out.println("�������� title:--->" + document.get("content"));
	    }
		
	}
	
}
