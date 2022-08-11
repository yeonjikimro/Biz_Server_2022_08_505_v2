package com.callor.todo.service.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.callor.todo.model.AuthorityVO;
import com.callor.todo.model.UserVO;
import com.callor.todo.persistance.UserDao;

@Service("authenticationProvider")
public class AuthenticationProviderImpl  implements AuthenticationProvider{
	@Autowired
	private UserDao userDao;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {


		String username = (String) authentication.getPrincipal();
		String password = (String) authentication.getCredentials();
		
		UserVO userVO = userDao.findById(username);
		if(userVO == null) {
			throw new UsernameNotFoundException(username + "은 회원가입 하세요");
		}


		
		if(userVO.getPassword().equals(password) == false) {
			throw new BadCredentialsException("비밀번호 오류");
		}
		
		List<AuthorityVO> authList = userDao.select_auths(username);
		List<GrantedAuthority> grantList = new ArrayList<>();
		for(AuthorityVO vo : authList) {
			grantList.add(new SimpleGrantedAuthority(vo.getAuthority()));
		}
		userVO.setAuthorities(grantList);
		
		UsernamePasswordAuthenticationToken token
		= new UsernamePasswordAuthenticationToken(userVO,null, grantList);
		return token;
		
			
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}
