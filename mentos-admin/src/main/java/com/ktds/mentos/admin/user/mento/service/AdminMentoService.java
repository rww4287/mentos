package com.ktds.mentos.admin.user.mento.service;

import com.ktds.mentos.user.mento.biz.MentoBiz;

public interface AdminMentoService extends MentoBiz{

	public boolean deleteOneMento(String mentoId);

}
