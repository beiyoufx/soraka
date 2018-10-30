package com.soraka.auth.service.feign.fallback;

import com.soraka.auth.service.feign.UserService;
import com.soraka.common.model.domain.RoleDO;
import com.soraka.common.model.domain.UserDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户服务熔断回调
 *
 * @author yongjie.teng
 * @date 2018/10/29
 * @package com.soraka.auth.service.feign.fallback
 */
@Slf4j
@Service
public class UserServiceFallbackImpl implements UserService {
    @Override
    public UserDO getByUsername(String username) {
        log.error("调用{}异常{}","getByUsername", username);
        return null;
    }

    @Override
    public List<RoleDO> getUserRole(Long id) {
        log.error("调用{}异常{}","getUserRole", id);
        return new ArrayList<>();
    }
}
