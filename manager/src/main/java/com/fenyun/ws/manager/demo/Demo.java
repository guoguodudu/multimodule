package com.fenyun.ws.manager.demo;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

@Data
public class Demo {


    /**
     * authenticationSubmitTime : 1546938963000
     *
     *
     * bankCard : “”
     * company : {"auditFailReason":"","auditorTime":"2019-01-08 17:15:05.0","companyName":"xxx","hasagent":"0","legal":"","legalName":"xxx","organization":"xxx","organizationPath":"xxx","regFormPath":"xxx","relatedTransactionNo":"xxx","status":"4","verifyType":"1"}
     * manager : {"auditFailReason":"","auditorTime":"","headPhotoPath":"xxx","idCard":"xxx","mobile":"xxx","personName":"xxx","status":"2","type":"1","verifyType":"0"}
     * passTime : 1546938905000
     * person : “”
     * transactionNo : xxx
     * type : 2
     */

    private String authenticationSubmitTime;
    private String bankCard;
    private CompanyBean company;
    private ManagerBean manager;
    private String passTime;
    private String person;
    private String transactionNo;
    private String type;

    public String getAuthenticationSubmitTime() {
        return authenticationSubmitTime;
    }

    public void setAuthenticationSubmitTime(String authenticationSubmitTime) {
        this.authenticationSubmitTime = authenticationSubmitTime;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public CompanyBean getCompany() {
        return company;
    }

    public void setCompany(CompanyBean company) {
        this.company = company;
    }

    public ManagerBean getManager() {
        return manager;
    }

    public void setManager(ManagerBean manager) {
        this.manager = manager;
    }

    public String getPassTime() {
        return passTime;
    }

    public void setPassTime(String passTime) {
        this.passTime = passTime;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static class CompanyBean {
        /**
         * auditFailReason :
         * auditorTime : 2019-01-08 17:15:05.0
         * companyName : xxx
         * hasagent : 0
         * legal :
         * legalName : xxx
         * organization : xxx
         * organizationPath : xxx
         * regFormPath : xxx
         * relatedTransactionNo : xxx
         * status : 4
         * verifyType : 1
         */

        private String auditFailReason;
        private String auditorTime;
        private String companyName;
        private String hasagent;
        private String legal;
        private String legalName;
        private String organization;
        private String organizationPath;
        private String regFormPath;
        private String relatedTransactionNo;
        private String status;
        private String verifyType;

        public String getAuditFailReason() {
            return auditFailReason;
        }

        public void setAuditFailReason(String auditFailReason) {
            this.auditFailReason = auditFailReason;
        }

        public String getAuditorTime() {
            return auditorTime;
        }

        public void setAuditorTime(String auditorTime) {
            this.auditorTime = auditorTime;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getHasagent() {
            return hasagent;
        }

        public void setHasagent(String hasagent) {
            this.hasagent = hasagent;
        }

        public String getLegal() {
            return legal;
        }

        public void setLegal(String legal) {
            this.legal = legal;
        }

        public String getLegalName() {
            return legalName;
        }

        public void setLegalName(String legalName) {
            this.legalName = legalName;
        }

        public String getOrganization() {
            return organization;
        }

        public void setOrganization(String organization) {
            this.organization = organization;
        }

        public String getOrganizationPath() {
            return organizationPath;
        }

        public void setOrganizationPath(String organizationPath) {
            this.organizationPath = organizationPath;
        }

        public String getRegFormPath() {
            return regFormPath;
        }

        public void setRegFormPath(String regFormPath) {
            this.regFormPath = regFormPath;
        }

        public String getRelatedTransactionNo() {
            return relatedTransactionNo;
        }

        public void setRelatedTransactionNo(String relatedTransactionNo) {
            this.relatedTransactionNo = relatedTransactionNo;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getVerifyType() {
            return verifyType;
        }

        public void setVerifyType(String verifyType) {
            this.verifyType = verifyType;
        }
    }

    public static class ManagerBean {
        /**
         * auditFailReason :
         * auditorTime :
         * headPhotoPath : xxx
         * idCard : xxx
         * mobile : xxx
         * personName : xxx
         * status : 2
         * type : 1
         * verifyType : 0
         */

        private String auditFailReason;
        private String auditorTime;
        private String headPhotoPath;
        private String idCard;
        private String mobile;
        private String personName;
        private String status;
        private String type;
        private String verifyType;

        public String getAuditFailReason() {
            return auditFailReason;
        }

        public void setAuditFailReason(String auditFailReason) {
            this.auditFailReason = auditFailReason;
        }

        public String getAuditorTime() {
            return auditorTime;
        }

        public void setAuditorTime(String auditorTime) {
            this.auditorTime = auditorTime;
        }

        public String getHeadPhotoPath() {
            return headPhotoPath;
        }

        public void setHeadPhotoPath(String headPhotoPath) {
            this.headPhotoPath = headPhotoPath;
        }

        public String getIdCard() {
            return idCard;
        }

        public void setIdCard(String idCard) {
            this.idCard = idCard;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getPersonName() {
            return personName;
        }

        public void setPersonName(String personName) {
            this.personName = personName;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getVerifyType() {
            return verifyType;
        }

        public void setVerifyType(String verifyType) {
            this.verifyType = verifyType;
        }
    }

    public static void main(String[] args) {

        String kk= "{\"authenticationSubmitTime\":\"1546938963000\",\"bankCard\":null,\"company\":{\"auditFailReason\":\n\"\",\"auditorTime\":\"2019-01-0817:15:05.0\",\"companyName\":\"xxx\",\"hasagent\":\"0\",\"legal\":\"\",\"legalName\":\"xxx\",\"organization\":\"xxx\",\"organizationPath\":\"xxx\",\"regFormPath\":\"xxx\",\"relatedTransactionNo\":\"xxx\",\"status\":\"4\",\"verifyType\":\"1\"},\"manager\":{\"auditFailReason\":\"\",\"auditorTime\":\"\",\"headPhotoPath\":\"xxx\",\"idCard\":\"xxx\",\"mobile\":\"xxx\",\"personName\":\"xxx\",\"status\":\"2\",\"type\":\"1\",\"verifyType\":\"0\"},\"passTime\":\"1546938905000\",\"person\":null,\"transactionNo\":\"xxx\",\"type\":\"2\"}";

        Demo dem = JSONObject.parseObject(kk,Demo.class);
        System.out.println(dem.getCompany().getAuditorTime());
    }
}
