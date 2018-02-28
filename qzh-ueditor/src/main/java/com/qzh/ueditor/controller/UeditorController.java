package com.qzh.ueditor.controller;

import com.qzh.ueditor.common.ueditor.ActionEnter;
import org.json.JSONException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * 用于处理关于ueditor插件相关的请求
 * @author Guoqing
 * @date 2017-11-29
 *
 */
@RestController
@CrossOrigin
public class UeditorController {

	@RequestMapping(value = "/exec")
	@ResponseBody
	public String exec(HttpServletRequest request) throws UnsupportedEncodingException, JSONException {
		request.setCharacterEncoding("utf-8");
		String rootPath = request.getRealPath("/");
		return new ActionEnter( request, rootPath ).exec();
	}
	
}
