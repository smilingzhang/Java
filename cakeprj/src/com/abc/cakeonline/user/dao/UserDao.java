package com.abc.cakeonline.user.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.abc.cakeonline.entity.User;
@Repository
public class UserDao {
	@Resource
	private SessionFactory sessionFactory;

	// �û���ע����Ϣ���뵽�û�����
	public void insertUsers(User user) {
		Session session=this.sessionFactory.getCurrentSession();
		session.save(user);
	}

	// ͨ���û���¼ʱ��mail�ж��û��Ƿ�ע���Լ��Ƿ��¼�ɹ�
	public int findUser(String mail, String password) {
		Session session=this.sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User u where u.mail=? ");
		query.setParameter(0, mail);
		List<User> list=query.list();
		if(list.size()==0) {
			return 0; //����δע��
		}else {
			if(list.get(0).getPassword().equals(password)) {
				return 1; //��¼�ɹ�
			}else {
				return 2; //��¼�ɹ����������
			}
		}
	}
	//ͨ���û���mail���û���Ϣ
	public User findByMail(String mail) {
		Session session =this.sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User u where u.mail=?");
		query.setParameter(0, mail);
		return (User) query.list().get(0);
	}

}
