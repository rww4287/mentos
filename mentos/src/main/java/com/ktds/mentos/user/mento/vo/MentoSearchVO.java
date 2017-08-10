package com.ktds.mentos.user.mento.vo;

import com.ktds.mentos.common.web.pager.Pager;
import com.ktds.mentos.common.web.pager.PagerFactory;

public class MentoSearchVO {
	private Pager pager; 
	 
	 
	public Pager getPager() { 
		if(pager == null){
			pager = PagerFactory.getPager(pager.ORACLE,5,10);
		}
	 	return pager; 
	} 
 
	 
 	public void setPager(Pager pager) { 
 		this.pager = pager; 
 	} 
}
