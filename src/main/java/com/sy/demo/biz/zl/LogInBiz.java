package com.sy.demo.biz.zl;


import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sy.demo.dao.zl.ILogInDao;
import com.sy.demo.pojo.Login;
import com.sy.demo.pojo.User;
@Service
@Transactional(propagation=Propagation.SUPPORTS,isolation=Isolation.READ_COMMITTED,readOnly=true)
public class LogInBiz {

	@Autowired
	private ILogInDao userdao;


@Transactional(propagation=Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED, readOnly = false)
public int LogInBiz(User user,Login login){
	userdao.LoginUserDao(user);
	login.setUserID(user.getUserID());
	int s=userdao.LoginlgnDao(login);
	return s;
}

@Transactional(propagation=Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED, readOnly = false)
public int MailboxValidation(String mail){
	return userdao.MailboxValidation(mail);
}

@Transactional(propagation=Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED, readOnly = false)
public User SignInDao(int userid){
	return userdao.SignInDao(userid);
}
@Transactional(propagation=Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED, readOnly = false)
public Login LoginDao(Login login){
	return userdao.LoginDao(login);
}
}

