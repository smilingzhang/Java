package com.abc.cakeonline.cake.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abc.cakeonline.cake.dao.CakeDao;
import com.abc.cakeonline.entity.Cake;

@Service
@Transactional(readOnly = true)
public class CakePageService {
	@Resource
	private CakeDao cakeDao;

	public List<Cake> find(int pageNum, int pageSize, int level) {
		return this.cakeDao.findAll(pageNum, pageSize, level);
	}

	// 调用Dao中查询level=?的蛋糕总数量的方法
	public int countAll(int level) {
		return this.cakeDao.queryCount(level);
	}

}
