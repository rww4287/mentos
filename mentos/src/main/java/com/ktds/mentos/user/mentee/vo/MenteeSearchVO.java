package com.ktds.mentos.user.mentee.vo;

import com.ktds.mentos.common.web.pager.Pager;
import com.ktds.mentos.common.web.pager.PagerFactory;

public class MenteeSearchVO {

	private Pager pager;

	public Pager getPager() {
		if (pager == null) {
			pager = PagerFactory.getPager(Pager.ORACLE);
		}
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}
	
}
