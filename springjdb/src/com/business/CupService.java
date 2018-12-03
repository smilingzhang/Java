package com.business;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CupDao;
import com.entity.Cup;
@Service("cup")
public class CupService {
	@Autowired
	private CupDao cupDao;

	public CupService() {
		// TODO Auto-generated constructor stub
	}
	public void addCup(Cup cup) {
		this.cupDao.saveCup(cup);
	}

}
