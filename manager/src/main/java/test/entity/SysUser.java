package test.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * 用户表(SysUser)实体表
 *
 * @author dupihua
 * @since 2020-02-19 10:41:39
 */
@Data
@Table(name = "SYS_USER")
public class SysUser implements Serializable {

    /**
     * 流水号
     */        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)        
    @Column(name = "ID")
    private Integer id;

    /**
     * 用户名
     */            
    @Column(name = "USER_NAME")
    private String userName;

    /**
     * 用户密码
     */            
    @Column(name = "PASSWORD")
    private String password;

    /**
     * 用户中文名
     */            
    @Column(name = "NICK_NAME")
    private String nickName;

    /**
     * 机构类型
     */            
    @Column(name = "ORG_TYPE")
    private String orgType;

    /**
     * 机构集团代码
     */            
    @Column(name = "ORG_GROUP_CODE")
    private String orgGroupCode;

    /**
     * 机构公司代码
     */            
    @Column(name = "ORG_COMP_CODE")
    private String orgCompCode;

    /**
     * 机构网点代码
     */            
    @Column(name = "ORG_SITE_CODE")
    private String orgSiteCode;

    /**
     * 用户邮箱
     */            
    @Column(name = "EMAIL")
    private String email;

    /**
     * 用户电话
     */            
    @Column(name = "PHONE")
    private String phone;

    /**
     * 状态
     */            
    @Column(name = "STATUS")
    private String status;

    /**
     * 建立人ID
     */            
    @Column(name = "CREATE_ID")
    private String createId;

    /**
     * 建立日期时间
     */            
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "CREATE_DATETIME")
    private LocalDateTime createDatetime;

    /**
     * 修改人ID
     */            
    @Column(name = "MODIFY_ID")
    private String modifyId;

    /**
     * 修改日期时间
     */        
    @JsonFormat(pattern = "yyy-MM-dd")    
    @Column(name = "MODIFY_DATETIME")
    private LocalDate modifyDatetime;

    /**
     * 病假小时数
     */            
    @Column(name = "SICK_LEAVE_HOURS")
    private BigDecimal sickLeaveHours;

    /**
     * log
     */            
    @Column(name = "log")
    private Long log;

}