package com.huidong.qzh.sso.service;

import com.huidong.qzh.sso.entity.EipAccounts;
import com.huidong.qzh.util.common.util.QzhResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;

public interface EipAccountService {
    QzhResult userLogin(String username, String password,String authCode, HttpServletRequest request, HttpServletResponse response) throws NoSuchAlgorithmException;

    QzhResult getUserByToken(String token);

     EipAccounts getUserObjectByToken(String token);

    QzhResult logout(String token);

    Boolean verifyPhone(String phone);

    QzhResult register(String phone, String mobileCode, String password, String companyName, String nickName,HttpServletRequest request);

    Boolean delUser(String phone);

    QzhResult verifyMobileCode(String phone,String authCode,HttpServletRequest request) throws Exception;

    QzhResult editUserPass(String phone,String pwd, HttpServletRequest request);
}
