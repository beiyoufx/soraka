package com.soraka.admin.controller;

import com.soraka.common.constant.Constants;
import com.soraka.common.exception.BuzCode;
import com.soraka.common.model.domain.UserDO;
import com.soraka.admin.model.dto.LoginDTO;
import com.soraka.common.model.dto.R;
import com.soraka.admin.model.dto.UserInfo;
import com.soraka.admin.service.MenuService;
import com.soraka.admin.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 测试
 * @author yongjie.teng
 * @date 2018/8/9
 * @package com.soraka.admin.controller
 */
@Slf4j
@Api(tags = "登录服务")
@RestController
public class LoginController extends BaseController {
    @Autowired
    private UserService userService;
    @Autowired
    private MenuService menuService;

    @ApiOperation("登录接口")
    @PostMapping("login")
    public R login(@Valid @RequestBody LoginDTO loginDTO) {
        if (StringUtils.isEmpty(loginDTO.getUsername()) || StringUtils.isEmpty(loginDTO.getPassword())) {
            return R.fail();
        }
        R r = R.success();
        String username = loginDTO.getUsername();
        String password = loginDTO.getPassword();
        UserDO user = userService.getByUsername(username);
        if (user == null && username.matches(Constants.EMAIL_PATTERN)) {
            user = userService.getByEmail(username);
        }
        if (user == null && username.matches(Constants.MOBILE_PHONE_PATTERN)) {
            user = userService.getByMobilephone(username);
        }

        if (user == null || Boolean.TRUE.equals(user.getDeleted())) {
            r.setCode(BuzCode.USER_NOT_FOUND.getCode());
            r.setMessage(BuzCode.USER_NOT_FOUND.getMessage());
            return r;
        }

        if (!isMatched(user, password)) {
            r.setCode(BuzCode.USER_PWD_ERROR.getCode());
            r.setMessage(BuzCode.USER_PWD_ERROR.getMessage());
            return r;
        }

        if (Constants.USER_STATUS_BLOCKED == user.getStatus()) {
            r.setCode(BuzCode.USER_IS_BLOCKED.getCode());
            r.setMessage(BuzCode.USER_IS_BLOCKED.getMessage());
            return r;
        }
        UserInfo userInfo = new UserInfo();
        //Todo 实现凭证
        userInfo.setToken("demo-token");
        userInfo.setUser(user);
        userInfo.setPermissions(menuService.getUserPermission(user.getId()));
        r.setData(userInfo);
        return r;
    }

    @ApiOperation("退出接口")
    @GetMapping("logout")
    public R logout() {
        //todo
        R r = R.success();
        r.setData("退出成功");
        return r;
    }

    /**
     * 校验用户与密码是否匹配
     *
     * @param user 用户
     * @param password 密码
     * @return
     */
    private boolean isMatched(UserDO user, String password) {
        return user.getPassword().equals(userService.encryptPassword(password));
    }
}
