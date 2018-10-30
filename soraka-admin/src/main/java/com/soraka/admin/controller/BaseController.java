package com.soraka.admin.controller;

import com.soraka.common.constant.Constants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.List;

/**
 * @author yongjie.teng
 * @date 2018/8/17
 * @package com.soraka.admin.controller
 */
@RestController
public class BaseController {
    @Autowired
    private HttpServletRequest request;

    /**
     * 根据JWT中的角色
     *
     * @return 角色名
     */
    public List<String> getRole() {
        List<String> roleKeys = (List<String>) getJwtClaims().get("authorities");
        return roleKeys;
    }


    /**
     * 根据JWT中的角色
     *
     * @return 角色名
     */
    public String getUsername() {
        return (String) getJwtClaims().get("user_name");
    }

    /**
     * 从请求头中分离出token
     *
     * @return token
     */
    private Claims getJwtClaims() {
        String authorization = request.getHeader(Constants.TOKEN_HEADER);
        String token = StringUtils.substringAfter(authorization, Constants.TOKEN_BEARER);
        String key = Base64.getEncoder().encodeToString(Constants.JWT_SIGN_KEY.getBytes());
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
    }
}
