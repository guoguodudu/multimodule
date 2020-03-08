package test.bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * 用户表(SysUser)响应bean
 *
 * @author dupihua
 * @since 2020-02-19 10:23:46
 */
@Data
public class SysUserResBean implements Serializable {

    /**
     * 流水号
     */                
    private Integer id;
    
    /**
     * 用户名
     */    
    @Excel(name = "用户名")            
    private String userName;
    
    /**
     * 用户密码
     */    
    @Excel(name = "用户密码")            
    private String password;
    
    /**
     * 用户中文名
     */    
    @Excel(name = "用户中文名")            
    private String nickName;
    
    /**
     * 机构类型
     */    
    @Excel(name = "机构类型")            
    private String orgType;
    
    /**
     * 机构集团代码
     */    
    @Excel(name = "机构集团代码")            
    private String orgGroupCode;
    
    /**
     * 机构公司代码
     */    
    @Excel(name = "机构公司代码")            
    private String orgCompCode;
    
    /**
     * 机构网点代码
     */    
    @Excel(name = "机构网点代码")            
    private String orgSiteCode;
    
    /**
     * 用户邮箱
     */    
    @Excel(name = "用户邮箱")            
    private String email;
    
    /**
     * 用户电话
     */    
    @Excel(name = "用户电话")            
    private String phone;
    
    /**
     * 状态
     */    
    @Excel(name = "状态")            
    private String status;
    
    /**
     * 建立人ID
     */    
    @Excel(name = "建立人ID")            
    private String createId;
    
    /**
     * 建立日期时间
     */                
    @Excel(name = "建立日期时间", exportFormat = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDatetime;
    
    /**
     * 修改人ID
     */    
    @Excel(name = "修改人ID")            
    private String modifyId;
    
    /**
     * 修改日期时间
     */            
    @Excel(name = "修改日期时间", exportFormat = "yyy-MM-dd")
    @JsonFormat(pattern = "yyy-MM-dd")        
    private LocalDate modifyDatetime;
    
    /**
     * 病假小时数
     */                
    @Excel(name = "病假小时数", type = 10)    
    private BigDecimal sickLeaveHours;
    
    /**
     * log
     */                
    private Long log;
    
}