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

	// 查询蛋糕销量最高的前8款
	public List<Cake> findByCount() {
		Session session=this.sessionFactory.getCurrentSession();
		Query query=session.createQuery("select od.cake from OrderDetail od GROUP BY od.cake ORDER BY sum(od.count) desc");
		query.setFirstResult(0);
		query.setMaxResults(8);
		return query.list();
	}

	// 检索页面
	public List<Cake> findAll(int pageNum, int pageSize, int level) {
		Session session=this.sessionFactory.getCurrentSession();
		Query query=session.createQuery("From Cake c where c.level=?");
		query.setParameter(0, level);
		query.setFirstResult((pageNum - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	
	}

	// 查询level=?的蛋糕的总数量
	public Integer queryCount(int level) {
		Session session=this.sessionFactory.getCurrentSession();
		Query query=session.createQuery("select count(c.id) from Cake c where c.level=?");
		query.setParameter(0, level);
		Number number=(Number) query.list().get(0);
		return number.intValue();//结果返回一个数值
		
	}

	// 通过蛋糕id查询蛋糕的信息，放到详情页面
	public Cake findById(int id) {
		Session session=this.sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Cake c where c.id=?");
		query.setParameter(0, id);
		return (Cake) query.list().get(0);
	}
}

