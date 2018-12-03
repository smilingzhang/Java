package com.abc.cakeonline.cake.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abc.cakeonline.cake.dao.CakeDao;
import com.abc.cakeonline.entity.Cake;

@Service
@Transactional(readOnly = true)
public class CakeDetailService {
	@Resource
	private CakeDao cakeDao;

	// ����CakeDao�з�������ҳ��Ĳ�ѯ������Ϣ�ķ���
	public Cake findId(int id) {
		return this.cakeDao.findById(id);
	}

}
