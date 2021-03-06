package br.ufrgs.foodbook.service.impl;


import br.ufrgs.foodbook.dao.UserDao;
import br.ufrgs.foodbook.model.security.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService
{
    @Resource
    private UserDao userDao;

    @Override
    @Transactional
    public User loadUserByUsername(String username)
    {
        User user = userDao.findByUsername(username);
        if (user != null) {
            return user;
        }
        throw new UsernameNotFoundException(username);
    }
}