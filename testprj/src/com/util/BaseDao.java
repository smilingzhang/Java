package com.util;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

/**
 * 
 * @desc:����Spring����hibernateʱ�������ݳ־ò�Ĳ�����������Ĳ�����ȡ����
 * @author chunhui
 * @date:Nov 19, 20182:34:00 PM
 */

public class BaseDao<T> {
	/**
	 * ע��session����
	 */
	@Resource
	private SessionFactory sessionFactory;

	/**
	 * 
	 * @desc:��������ID����ʵ��
	 * @param entityClazz
	 * @param id
	 *            ��������ʵ���˸ýӿڵ���Ķ�������Զ����int Integer String��
	 * @return
	 * @return:T
	 * @trhows
	 */
	public T get(Class<T> entityClazz, Serializable id) {
		return sessionFactory.getCurrentSession().get(entityClazz, id);
	}

	/**
	 * 
	 * @desc:����ʵ��
	 * @param entity
	 * @return
	 * @return:Serializable ���ص��Ǳ����ʵ������Ӧ������ֵ
	 * @trhows
	 */
	public Serializable save(T entity) {
		return sessionFactory.getCurrentSession().save(entity);
	}

	/**
	 * 
	 * @desc:����ʵ��
	 * @param entity
	 * @return:void
	 * @trhows
	 */
	public void update(T entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	/**
	 * 
	 * @desc:ɾ��ʵ��
	 * @param entity
	 * @return:void
	 * @trhows
	 */
	public void delete(T entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	/**
	 * 
	 * @desc:����ID ɾ��ʵ��
	 * @param entityClazz
	 * @param id
	 * @return
	 * @return:boolean ����ֵΪtrue��˵��Ӱ������>1���ɹ�
	 * @trhows
	 */
	public boolean delete(Class<T> entityClazz, Serializable id) {
		String hql = "delete " + entityClazz.getSimpleName() + " en where en.id = ?0";
		return (sessionFactory.getCurrentSession().createQuery(hql).setParameter("0", id).executeUpdate()) > 0;

	}

	/**
	 * 
	 * @desc:��ȡ����ʵ��
	 * @param entityClazz
	 * @return
	 * @return:List<T>
	 * @trhows
	 */
	public List<T> findAll(Class<T> entityClazz) {
		String hql = "select en from " + entityClazz.getSimpleName() + " en";
		return find(hql);
	}

	/**
	 * 
	 * @desc:��ȡʵ������
	 * @param entityClazz
	 * @return
	 * @return:long
	 * @trhows
	 */
	public long findCount(Class<T> entityClazz) {
		String hql = "select count(*) from " + entityClazz.getSimpleName();
		List<T> list = find(hql);
		if (list != null && list.size() == 1) {
			return (Long) list.get(0);
		}
		return 0;
	}

	/**
	 * 
	 * @desc:����HQL����ѯʵ��
	 * @param hql
	 * @return
	 * @return:List<T>
	 * @trhows
	 */
	@SuppressWarnings("unchecked")
	protected List<T> find(String hql) {
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}

	/**
	 * 
	 * @desc:���ݴ�ռλ������HQL����ѯʵ��
	 * @param hql����ѯ��hql���
	 * @param params
	 *            ����
	 * @return
	 * @return:List<T>
	 * @trhows
	 */
	@SuppressWarnings("unchecked")
	protected List<T> find(String hql, Object... params) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		for (int i = 0, len = params.length; i < len; i++) {
			query.setParameter(i + "", params[i]);
		}
		return query.list();
	}

	/**
	 * 
	 * @desc:ʹ��hql �����з�ҳ��ѯ����
	 * @param hql
	 *            ��Ҫ��ѯ��hql���
	 * @param pageNo
	 *            ��ѯ��pageNoҳ�ļ�¼
	 * @param pageSize
	 *            ÿҳ��Ҫ��ʾ�ļ�¼��
	 * @return
	 * @return:List<T> ��ǰҳ�����м�¼��Ʒ
	 * @trhows
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByPage(String hql, int pageNo, int pageSize) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize).list();
	}

	/**
	 * 
	 * @desc:ʹ��hql�����з�ҳ��ѯ����
	 * @param hql
	 *            ��Ҫ��ѯ��hql���
	 * @param pageNo
	 *            ��ѯ��pageNoҳ�ļ�¼
	 * @param pageSize
	 *            ÿҳ��Ҫ��ʾ�ļ�¼��
	 * @param params
	 *            ���hql��ռλ����params���ڴ���ռλ������
	 * @return
	 * @return:List<T>��ǰҳ�����м�¼
	 * @trhows
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByPage(String hql, int pageNo, int pageSize, Object... params) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		for (int i = 0, len = params.length; i < len; i++) {
			query.setParameter(i + "", params[i]);
		}
		return query.setFirstResult((pageNo - 1) + pageSize).setMaxResults(pageSize).list();
	}

}
