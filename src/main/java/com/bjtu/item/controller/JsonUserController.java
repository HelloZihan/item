package com.bjtu.item.controller;

import com.bjtu.item.db.SessionContext;
import com.bjtu.item.db.SessionFactory;
import com.bjtu.item.db.mapper.UserMapper;
import com.bjtu.item.entity.User;
import com.bjtu.item.mendb.UserMemDB;
import com.bjtu.item.utils.ApiResult;
import com.bjtu.item.utils.LoggerUtil;
import com.bjtu.item.utils.MD5Util;
import com.bjtu.item.utils.MessageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
public class JsonUserController {

	private Logger logger = LoggerFactory.getLogger(SampleController.class);

	@Autowired
	private SessionFactory sessionFactory;

	@RequestMapping(value = "/api/json/user/register", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String register(HttpServletRequest request,
						   HttpServletResponse res,
					@RequestParam(value = "name") String name,
					@RequestParam(value = "role",defaultValue = "1") Byte role,
					@RequestParam(value = "password") String password) {


		res.setContentType("text/html;charset=UTF-8");

		res.setHeader("Access-Control-Allow-Origin", "*");

		res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");

		res.setHeader("Access-Control-Max-Age", "0");

		res.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");

		res.setHeader("Access-Control-Allow-Credentials", "true");

		res.setHeader("XDomainRequestAllowed","1");

		String s = MD5Util.digestPassword(password);
		String finalName = name.trim();
		if (UserMemDB.userNameMap.get(finalName) != null ){
			return ApiResult.errorStr(MessageUtil.CODE_SYS_UNKNOWN, MessageUtil.get(MessageUtil.CODE_SYS_UNKNOWN));
		}
		SessionContext context = sessionFactory.getSessionContext();
		try {
			User user = new User();
			user.setName(finalName);
			user.setPassword(s);
			user.setRole(role);
			int row = context.getMapper(UserMapper.class).addUser(user);
			context.commit();
			if (row > 0) {
				UserMemDB.addUses(user);
			}
			Map<String, Object> map = new HashMap<>();
			map.put("id", user.getId());
			map.put("name", user.getName());

			return ApiResult.succStr(map);
		} catch (Exception e) {
			LoggerUtil.error(logger, e);
			return ApiResult.errorStr(MessageUtil.CODE_UNKNOWN_ERROR,MessageUtil.get(MessageUtil.CODE_UNKNOWN_ERROR));
		} finally {
			SessionContext.closeSilently(context);
		}
	}

	@RequestMapping(value = "/api/json/user/login", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String login(HttpServletResponse res,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "password") String password) {

		res.setContentType("text/html;charset=UTF-8");

		res.setHeader("Access-Control-Allow-Origin", "*");

		res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");

		res.setHeader("Access-Control-Max-Age", "0");

		res.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");

		res.setHeader("Access-Control-Allow-Credentials", "true");

		res.setHeader("XDomainRequestAllowed","1");

		String finalName = name.trim();
		String s = MD5Util.digestPassword(password);

		User user = UserMemDB.userNameMap.get(finalName);
		if (user == null) {
			return ApiResult.errorStr(MessageUtil.CODE_SYS_UNEXPECTED_ERROR,MessageUtil.get(MessageUtil.CODE_SYS_UNEXPECTED_ERROR));
		}
		if (!s.equals(user.getPassword())){
			return ApiResult.errorStr(MessageUtil.CODE_SYS_ILLEGAL_OPERATION,MessageUtil.get(MessageUtil.CODE_SYS_ILLEGAL_OPERATION));

		}
		Map<String, Object> map = new HashMap<>();
		map.put("id", user.getId());
		map.put("name", user.getName());
		return ApiResult.succStr(map);
	}

}