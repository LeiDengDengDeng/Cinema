package com.example.cinema.bl;

import com.example.cinema.dao.User;
import com.example.cinema.po.UserForm;
import com.example.cinema.vo.ResponseVO;

/**
 * @author huwen
 * @date 2019/3/23
 */
public interface AccountService {

    /**
     * 注册账号
     * @return
     */
    public ResponseVO registerAccount(UserForm userForm);

    /**
     * 用户登录，登录成功会将用户信息保存再session中
     * @return
     */
    public User login(UserForm userForm);

}
