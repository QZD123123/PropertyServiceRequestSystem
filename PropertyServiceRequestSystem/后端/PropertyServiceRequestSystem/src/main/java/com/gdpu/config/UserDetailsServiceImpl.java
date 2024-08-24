package com.gdpu.config;

import com.gdpu.mapper.WxuserMapper;
import com.gdpu.pojo.Wxuser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private WxuserMapper wxuserMapper;
    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        Wxuser wxuser = wxuserMapper.findByPhone(phone);
        System.out.println("wxuser = " + wxuser);
        if (wxuser == null){
            throw new UsernameNotFoundException("User not found");
        }
        return wxuser;
    }
}
