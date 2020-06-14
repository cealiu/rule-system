package com.rule.auth.service;

import com.rule.auth.controller.dto.InitUserRespDTO;
import com.rule.auth.controller.dto.UserLoginDto;
import com.rule.auth.dao.UserDao;
import com.rule.auth.dao.po.User;
import com.rule.auth.enums.AuthRespCodeEnum;
import com.rule.auth.util.RsaKeyHelper;
import com.rule.auth.util.SHAUtil;
import com.rule.common.constant.CommonConstants;
import com.rule.common.enums.BaseRespCodeEnum;
import com.rule.common.msg.ObjectRestResponse;
import com.rule.common.util.BaseRespUtil;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author LiuCe
 * @date 2020/5/24 12:30 下午
 * @email liucemail@gmail.com
 */

@Slf4j
@Service
@RefreshScope
public class UserService {

	private static RsaKeyHelper rsaKeyHelper = new RsaKeyHelper();

	@Value("${jwt.privateKey}")
	private String privateKey;
	@Value("${jwt.expire}")
	private int expire;

	@Autowired
	private UserDao userDao;

	public ObjectRestResponse<InitUserRespDTO> login(UserLoginDto userLoginDto){
		ObjectRestResponse<InitUserRespDTO> response = new ObjectRestResponse<>();
		try {
			User user = new User();
			BeanUtils.copyProperties(userLoginDto,user);
			User result = userDao.selectByUser(user);
			String sha512Password = SHAUtil.SHA512(userLoginDto.getPassword());
			if(null!=result&&result.getPassword().equals(sha512Password)){
				InitUserRespDTO initUserRespDTO = new InitUserRespDTO();
				initUserRespDTO.setUserId(result.getUserId());
				initUserRespDTO.setUserName(result.getUserName());
				initUserRespDTO.setToken("sssx");
				BaseRespUtil.setSuccess(response);
				response.setData(initUserRespDTO);
				return response;
			}else {
				if(null==result){
					BaseRespUtil.setFail(response, AuthRespCodeEnum.USER_NOT_EXIST.getCode(),AuthRespCodeEnum.USER_NOT_EXIST.getMessage());
				}else {
					BaseRespUtil.setFail(response, AuthRespCodeEnum.PASSWORD_WRONG.getCode(),AuthRespCodeEnum.PASSWORD_WRONG.getMessage());
				}
				return response;
			}
		}catch (Exception e){
			log.error("login query error {}",e.getMessage());
			BaseRespUtil.setFail(response, BaseRespCodeEnum.INVOKE_EXCEPTION,BaseRespCodeEnum.INVOKE_EXCEPTION.getMessage());
			return response;
		}
	}

	private String buildToken(User user) throws Exception{
		String compactJws = Jwts.builder()
				.setSubject("rule-system")
				.setId(UUID.randomUUID().toString().replace("-",""))
				.claim(CommonConstants.USER_ID,user.getUserId())
//				.claim(CommonConstants.ROLE_ID,user.getRoleId())
				.claim(CommonConstants.USER_NAME,user.getUserName())
				.claim(CommonConstants.NAME,user.getNickname())
				.setExpiration(DateTime.now().plusSeconds(expire).toDate())
				.signWith(SignatureAlgorithm.RS512, rsaKeyHelper.getPrivateKey(privateKey))
				.compact();

		return compactJws;
	}
}
