package com.gdpu.filter;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.gdpu.mapper.WxuserMapper;
import com.gdpu.pojo.Wxuser;
import com.gdpu.utils.JwtHelper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtHelper jwtHelper;

    @Autowired
    private WxuserMapper wxuserMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //获取token
        String token = request.getHeader("Authorization");
        System.out.println("token ===========> " + token);
        //login请求就没token,直接放行，因为后面有其他的过滤器
        if (token == null) {
            doFilter(request,response,filterChain);
            return;
        }
        //有token，通过jwt工具类，解析用户信息
        Long userId = jwtHelper.getUserId(token);
        System.out.println("userId ===========> " + userId);
        LambdaQueryWrapper<Wxuser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Wxuser::getWxuserId,userId);
        Wxuser dbUser = wxuserMapper.selectOne(queryWrapper);
        System.out.println("dbUser ===========> " + dbUser);
        //将用户信息放到SecurityContext中
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(dbUser, null, dbUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //放行
        doFilter(request,response,filterChain);
    }
}
