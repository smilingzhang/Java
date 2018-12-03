package com.abc.cakeonline.cake.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abc.cakeonline.cake.dao.CakeDao;
import com.abc.cakeonline.entity.Cake;

@Service
@Transactional(readOnly = true)
public class CakeService {
	@Resource
	private CakeDao cakeDao;

	// 调用蛋糕销量前8
	public List<Cake> maxHeight() {
		return this.cakeDao.findByCount();
	}
}
