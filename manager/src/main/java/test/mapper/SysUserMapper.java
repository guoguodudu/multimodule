package test.mapper;

import test.entity.SysUser;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import java.util.List;

/**
 * 用户表(SysUser)表数据库访问层
 *
 * @author dupihua
 * @since 2020-02-19 10:57:22
 */
@Repository
@org.apache.ibatis.annotations.Mapper
public interface SysUserMapper extends Mapper<SysUser>{

    /**
     * 查询指定行数据
     *
     * @return 对象列表
     */
    List<SysUser> queryAllByLimit();


}