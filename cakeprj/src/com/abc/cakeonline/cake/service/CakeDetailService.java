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

	// 调用CakeDao中放在详情页面的查询蛋糕信息的方法
	public Cake findId(int id) {
		return this.cakeDao.findById(id);
	}

}
