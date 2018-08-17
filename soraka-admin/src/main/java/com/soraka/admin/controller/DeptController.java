package com.soraka.admin.controller;

import com.soraka.admin.model.domain.DeptDO;
import com.soraka.admin.model.dto.R;
import com.soraka.admin.service.DeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yongjie.teng
 * @date 2018/8/17
 * @package com.soraka.admin.controller
 */
@Api(tags = "部门服务")
@RequestMapping("dept")
@RestController
public class DeptController extends BaseController {
    @Autowired
    DeptService deptService;

    @GetMapping("{id}")
    @ApiOperation("获取部门详情")
    public R get(@PathVariable("id") Long id) {
        DeptDO dept = deptService.get(id);
        R r = R.success();
        r.setData(dept);
        return r;
    }
}
