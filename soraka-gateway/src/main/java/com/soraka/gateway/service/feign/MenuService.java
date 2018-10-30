package com.soraka.gateway.service.feign;

import com.soraka.common.model.domain.MenuDO;
import com.soraka.gateway.service.feign.fallback.MenuServiceFallbackImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author yongjie.teng
 * @date 2018/10/29
 * @package com.soraka.gateway.service.feign
 */
@FeignClient(name = "soraka-admin", fallback = MenuServiceFallbackImpl.class)
public interface MenuService {
    /**
     * 查询角色菜单
     *
     * @param roleKeys 角色Key
     * @return 菜单列表
     */
    @GetMapping("menu/roleMenu")
    List<MenuDO> findRoleMenu(@RequestParam("roleKeys") List<String> roleKeys);
}
