package com.jd.shop.car.service;

import java.util.HashMap;

import com.jd.shop.entity.Product;

public class Car {
    //�ѹ��ﳵ�ŵ�һ��map���� key=id,value=CarItem
	HashMap<String, CarItem> hs=new HashMap<String, CarItem>();
	public HashMap<String, CarItem> getHs() {
		return hs;
	}
	public void setHs(HashMap<String, CarItem> hs) {
		this.hs = hs;
	}
	public Car() {
		// TODO Auto-generated constructor stub
	}
	public void add(Product p) {
		//������ﳵ���Ѿ����������Ʒ������ԭ�л�����+1�����û������������Ϊ1
		if(hs.containsKey(p.getId())) {//containKey()�ж��Ƿ�������id(keyֵ)��get()ȡ����id��Ӧ��value,��ʱ��һ��CarItem����
			int count=hs.get(p.getId()).getCount()+1;
			hs.get(p.getId()).setCount(count);	
		}else {
			CarItem c=new CarItem();
			c.setP(p);
			c.setCount(1);
			hs.put(p.getId(), c);
		}
		
	}

}
