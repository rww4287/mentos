package com.ktds.mentos.review.vo;

import com.ktds.mentos.common.web.pager.Pager;
import com.ktds.mentos.common.web.pager.PagerFactory;

public class ReviewSearchVO {
	private Pager pager;

	public Pager getPager() {
		if(pager == null){
			pager = PagerFactory.getPager(pager.ORACLE);
		}
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}
	
	
}
