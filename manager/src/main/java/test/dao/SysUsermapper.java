package test.dao;

import test.entity.SysUser;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 用户表(SysUser)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-19 10:28:45
 */
public interface SysUsermapper {

    /**
     * 查询指定行数据
     *
     * @return 对象列表
     */
    List<SysUser> queryAllByLimit();


}