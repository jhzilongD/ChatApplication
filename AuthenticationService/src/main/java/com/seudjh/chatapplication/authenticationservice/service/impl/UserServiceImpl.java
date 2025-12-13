package com.seudjh.chatapplication.authenticationservice.service.impl;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seudjh.chatapplication.authenticationservice.constants.user.ErrorEnum;
import com.seudjh.chatapplication.authenticationservice.constants.user.registerConstant;
import com.seudjh.chatapplication.authenticationservice.data.user.common.updateAvatar.UpdateAvatarRequest;
import com.seudjh.chatapplication.authenticationservice.data.user.common.updateAvatar.UpdateAvatarResponse;
import com.seudjh.chatapplication.authenticationservice.data.user.login.LoginRequest;
import com.seudjh.chatapplication.authenticationservice.data.user.login.LoginResponse;
import com.seudjh.chatapplication.authenticationservice.data.user.loginCode.LoginCodeRequest;
import com.seudjh.chatapplication.authenticationservice.data.user.loginCode.LoginCodeResponse;
import com.seudjh.chatapplication.authenticationservice.data.user.register.RegisterRequest;
import com.seudjh.chatapplication.authenticationservice.data.user.register.RegisterResponse;
import com.seudjh.chatapplication.authenticationservice.exception.CodeException;
import com.seudjh.chatapplication.authenticationservice.exception.DatabaseException;
import com.seudjh.chatapplication.authenticationservice.exception.UserException;
import com.seudjh.chatapplication.authenticationservice.mapper.UserBalanceMapper;
import com.seudjh.chatapplication.authenticationservice.model.User;
import com.seudjh.chatapplication.authenticationservice.model.UserBalance;
import com.seudjh.chatapplication.authenticationservice.service.UserService;
import com.seudjh.chatapplication.authenticationservice.mapper.UserMapper;
import com.seudjh.chatapplication.authenticationservice.utils.JwtUtil;
import com.seudjh.chatapplication.authenticationservice.utils.NickNameGenaratorUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
* @author seudmax
* @description 针对表【user(用户表)】的数据库操作Service实现
* @createDate 2025-11-09 19:56:42
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserBalanceMapper userBalanceMapper;

    @Override
    public RegisterResponse register(RegisterRequest request) {
        String phone = request.getPhone();
        String password = request.getPassword();
        boolean register = isRegister(phone);

        if (register){
            throw new UserException(ErrorEnum.REGISTER_ERROR);
        }

        String redisCode = redisTemplate.opsForValue().get(registerConstant.REGISTER_CODE + phone);
        if (redisCode == null || !redisCode.equals(request.getCode())){
            throw new CodeException(ErrorEnum.CODE_ERROR);
        }
        Snowflake snowflake = IdUtil.getSnowflake(1, 1);
        //  秘文存储用户密码
        String encryptedPassword = DigestUtils.md5DigestAsHex(password.getBytes());

        User user = new User().
                setUserId(snowflake.nextId()).
                setPassword(encryptedPassword).
                setPhone(phone).
                setUserName(NickNameGenaratorUtil.generateNickName());

        boolean isUserSave = this.save(user);
        if (!isUserSave){
            throw new DatabaseException("数据库异常，保存用户信息失败");
        }

        UserBalance userBalance = new UserBalance()
                .setUserId(user.getUserId())
                .setBalance(BigDecimal.valueOf(1000))
                .setUpdatedAt(LocalDateTime.now());

        int insert = userBalanceMapper.insert(userBalance);
        if (insert <= 0){
            throw new DatabaseException("数据库异常，创建用户账户信息错误");
        }

        return new RegisterResponse().setPhone(phone);
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        String phone = loginRequest.getPhone();

        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("phone", phone);

        User user = this.getOnly(userQueryWrapper, true);
        String password = DigestUtils.md5DigestAsHex(loginRequest.getPassword().getBytes());
        if (user == null || !user.getPassword().equals(password)){
            throw new UserException(ErrorEnum.LOGIN_ERROR);
        }
        LoginResponse loginResponse = new LoginResponse();
        BeanUtils.copyProperties(user, loginResponse);

        String to = jwtUtil.generateToken(String.valueOf(user.getUserId()));
        loginResponse.setToken(to);
        return loginResponse;
    }

    @Override
    public LoginCodeResponse loginCode(LoginCodeRequest loginCodeRequest) {
        String phone = loginCodeRequest.getPhone();
        String code = loginCodeRequest.getCode();

        String redisCode = redisTemplate.opsForValue().get(registerConstant.REGISTER_CODE + phone);
        if (redisCode == null || !redisCode.equals(code)){
            throw new CodeException(ErrorEnum.CODE_ERROR);
        }

        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("phone", phone);
        User user = this.getOnly(userQueryWrapper, true);
        if (user == null){
            throw new UserException(ErrorEnum.LOGIN_ERROR);
        }

        LoginCodeResponse response = new LoginCodeResponse();
        BeanUtils.copyProperties(user, response);

        String to = jwtUtil.generateToken(String.valueOf(user.getUserId()));
        response.setToken(to);
        return response;
    }

    @Override
    public UpdateAvatarResponse updateAvatar(String id, UpdateAvatarRequest updateAvatarRequest) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("user_id", Long.valueOf(id));
        User user = this.getOnly(userQueryWrapper, true);
        if (user == null){
            throw new UserException(ErrorEnum.NO_USER_ERROR);
        }
        user.setAvatar(updateAvatarRequest.avatarUrl);
        boolean update = this.updateById(user);
        if (!update){
            throw new DatabaseException(ErrorEnum.UPDATE_AVATAR_ERROR);
        }
        UpdateAvatarResponse updateAvatarResponse = new UpdateAvatarResponse();
        BeanUtils.copyProperties(user, updateAvatarResponse);
        return updateAvatarResponse;
    }

    private boolean isRegister(String phone){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.eq("phone", phone);
        long count = this.count(queryWrapper);

        return count > 0;

    }
}




