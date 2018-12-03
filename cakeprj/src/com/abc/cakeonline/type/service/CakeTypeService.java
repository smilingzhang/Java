package com.abc.cakeonline.type.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abc.cakeonline.entity.CakeType;
import com.abc.cakeonline.type.dao.CakeTypeDao;

@Service
@Transactional(readOnly = true)
public class CakeTypeService {
	@Resource
	private CakeTypeDao cakeTypeDao;

	public List<CakeType> find() {
		return this.cakeTypeDao.findAll();
	}

}
