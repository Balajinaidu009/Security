 package com.example.demo.ServicePackage;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.demo.EntityPackage.UserInfo;
import com.example.demo.RepositoryPackage.UserRepo;
@Component
public class UserDetailserviceImpl implements UserDetailsService {

	@Autowired
	private UserRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserInfo info=repo.findByName(username);
		
		
		if(info==null) {
			 throw new UsernameNotFoundException(username);
			
		}
		else {

			return new UserInfoUserDetails(info);
			
		}
//		try {
//			info.map(UserInfoUserDetails::new).orElseThrow(()->new Exception());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
	}

}
