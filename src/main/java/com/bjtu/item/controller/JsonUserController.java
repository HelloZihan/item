package com.bjtu.item.controller;

import com.bjtu.item.db.SessionContext;
import com.bjtu.item.db.SessionFactory;
import com.bjtu.item.db.mapper.SampleMapper;
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

@RestController
public class JsonUserController {

	private Logger logger = LoggerFactory.getLogger(SampleController.class);

	@Autowired
	private SessionFactory sessionFactory;

	@RequestMapping(value = "/api/json/user/register", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String register(@RequestParam(value = "name") String name,
					@RequestParam(value = "role") Byte role,
					@RequestParam(value = "password") String password) {

		String s = MD5Util.digestPassword(password);
		String finalName = name.trim();
		if (UserMemDB.userNameMap.get(name) !=null ){
			return ApiResult.errorStr(MessageUtil.CODE_SYS_UNKNOWN, MessageUtil.get(MessageUtil.CODE_SYS_UNKNOWN));
		}
		SessionContext context = sessionFactory.getSessionContext();
		try {
			User user = new User();
			user.setName(name.trim());
			user.setPassword(s);
			user.setRole(role);
			int row = context.getMapper(UserMapper.class).addUser(user);
			context.commit();
			if (row > 0) {
				UserMemDB.addUses(user);
			}
			return ApiResult.succStr(user);
		} catch (Exception e) {
			LoggerUtil.error(logger, e);
			return ApiResult.errorStr(MessageUtil.CODE_UNKNOWN_ERROR,MessageUtil.get(MessageUtil.CODE_UNKNOWN_ERROR));
		} finally {
			SessionContext.closeSilently(context);
		}
	}

	@RequestMapping(value = "/api/json/user/login", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String login(@RequestParam(value = "name") String name,
			@RequestParam(value = "password") String password) {

		String finalName = name.trim();
		String s = MD5Util.digestPassword(password);

		User user = UserMemDB.userNameMap.get(finalName);
		if (user == null) {
			return ApiResult.errorStr(MessageUtil.CODE_SYS_UNEXPECTED_ERROR,MessageUtil.get(MessageUtil.CODE_SYS_UNEXPECTED_ERROR));
		}
		if (!s.equals(MD5Util.digest(user.getPassword()))){
			return ApiResult.errorStr(MessageUtil.CODE_SYS_ILLEGAL_OPERATION,MessageUtil.get(MessageUtil.CODE_SYS_ILLEGAL_OPERATION));

		}
		return ApiResult.succStr(user);
	}

}