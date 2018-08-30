package com.soraka.admin.service.impl;

import com.soraka.admin.dao.DeptDAO;
import com.soraka.admin.model.domain.DeptDO;
import com.soraka.admin.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yongjie.teng
 * @date 2018/8/16
 * @package com.soraka.admin.service.impl
 */
@Transactional(rollbackFor = {RuntimeException.class})
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    DeptDAO deptDAO;

    /**
     * 通过主键获取部门
     *
     * @param id 主键
     * @return {@link DeptDO}
     */
    @Transactional(readOnly = true, rollbackFor = {RuntimeException.class})
    @Override
    public DeptDO get(Long id) {
        return deptDAO.get(id);
    }
}
