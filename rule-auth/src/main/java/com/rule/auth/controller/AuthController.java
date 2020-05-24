package com.rule.auth.controller;

import com.rule.auth.controller.dto.InitUserRespDTO;
import com.rule.auth.controller.dto.UserLoginDto;
import com.rule.auth.service.UserService;
import com.rule.common.enums.BaseRespCodeEnum;
import com.rule.common.msg.ObjectRestResponse;
import com.rule.common.util.BaseRespUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Objects;

@Slf4j
@RestController
public class AuthController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String home() throws Exception{
		return "/index";
	}

	@PostMapping("/user/login")
	public ObjectRestResponse<InitUserRespDTO> login(@RequestBody UserLoginDto userLoginDto){

		if(Objects.isNull(userLoginDto)|| StringUtils.isEmpty(userLoginDto.getUserName())||StringUtils.isEmpty(userLoginDto.getPassword())) {
			ObjectRestResponse<InitUserRespDTO> response = new ObjectRestResponse<>();
			BaseRespUtil.setFail(response, BaseRespCodeEnum.PARAMETER_EMPTY);
			return response;
		}else {
			log.info("{} login in {}", userLoginDto.getUserName(), new Date());
			ObjectRestResponse<InitUserRespDTO> rs = userService.login(userLoginDto);
			return rs;
		}
	}
}
