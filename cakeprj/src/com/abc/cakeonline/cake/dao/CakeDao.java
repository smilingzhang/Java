package com.abc.cakeonline.cake.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.abc.cakeonline.entity.Cake;
@Repository
public class CakeDao {
	@Resource
	private SessionFactory sessionFactory;

	// ��ѯ����������ߵ�ǰ8��
	public List<Cake> findByCount() {
		Session session=this.sessionFactory.getCurrentSession();
		Query query=session.createQuery("select od.cake from OrderDetail od GROUP BY od.cake ORDER BY sum(od.count) desc");
		query.setFirstResult(0);
		query.setMaxResults(8);
		return query.list();
	}

	// ����ҳ��
	public List<Cake> findAll(int pageNum, int pageSize, int level) {
		Session session=this.sessionFactory.getCurrentSession();
		Query query=session.createQuery("From Cake c where c.level=?");
		query.setParameter(0, level);
		query.setFirstResult((pageNum - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	
	}

	// ��ѯlevel=?�ĵ����������
	public Integer queryCount(int level) {
		Session session=this.sessionFactory.getCurrentSession();
		Query query=session.createQuery("select count(c.id) from Cake c where c.level=?");
		query.setParameter(0, level);
		Number number=(Number) query.list().get(0);
		return number.intValue();//�������һ����ֵ
		
	}

	// ͨ������id��ѯ�������Ϣ���ŵ�����ҳ��
	public Cake findById(int id) {
		Session session=this.sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Cake c where c.id=?");
		query.setParameter(0, id);
		return (Cake) query.list().get(0);
	}
}

