package com.soraka.admin.dao;

import com.soraka.admin.model.domain.DeptDO;
import com.soraka.admin.model.dto.QueryParam;

import java.util.List;

/**
 * 部门
 *
 * @author yongjie.teng
 * @date 2018/8/15
 * @package com.soraka.admin.dao
 */
public interface DeptDAO {
    /**
     * 通过主键获取部门
     *
     * @param id 主键
     * @return {@link DeptDO}
     */
    DeptDO get(Long id);

    /**
     * 查询部门列表
     *
     * @param param 查询参数
     * @return List<DeptDO>
     */
    List<DeptDO> find(QueryParam param);

    /**
     * 查询部门列表条数
     *
     * @param param 查询参数
     * @return {@link Integer}
     */
    Integer count(QueryParam param);

    /**
     * 新增部门
     *
     * @param deptDO
     * @return true 成功 false 失败
     */
    Integer save(DeptDO deptDO);

    /**
     * 更新部门
     *
     * @param deptDO
     * @return true 成功 false 失败
     */
    Integer update(DeptDO deptDO);

    /**
     * 删除部门
     *
     * @param id 部门ID
     * @return true 成功 false 失败
     */
    Integer delete(Long id);
}
