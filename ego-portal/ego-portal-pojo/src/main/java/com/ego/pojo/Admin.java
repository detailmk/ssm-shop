package com.ego.pojo;

import java.io.Serializable;

public class Admin implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_admin.admin_id
     *
     * @mbg.generated Mon Oct 28 10:08:49 CST 2019
     */
    private Short adminId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_admin.user_name
     *
     * @mbg.generated Mon Oct 28 10:08:49 CST 2019
     */
    private String userName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_admin.email
     *
     * @mbg.generated Mon Oct 28 10:08:49 CST 2019
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_admin.password
     *
     * @mbg.generated Mon Oct 28 10:08:49 CST 2019
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_admin.ec_salt
     *
     * @mbg.generated Mon Oct 28 10:08:49 CST 2019
     */
    private String ecSalt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_admin.add_time
     *
     * @mbg.generated Mon Oct 28 10:08:49 CST 2019
     */
    private Integer addTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_admin.last_login
     *
     * @mbg.generated Mon Oct 28 10:08:49 CST 2019
     */
    private Integer lastLogin;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_admin.last_ip
     *
     * @mbg.generated Mon Oct 28 10:08:49 CST 2019
     */
    private String lastIp;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_admin.lang_type
     *
     * @mbg.generated Mon Oct 28 10:08:49 CST 2019
     */
    private String langType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_admin.agency_id
     *
     * @mbg.generated Mon Oct 28 10:08:49 CST 2019
     */
    private Short agencyId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_admin.suppliers_id
     *
     * @mbg.generated Mon Oct 28 10:08:49 CST 2019
     */
    private Short suppliersId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_admin.role_id
     *
     * @mbg.generated Mon Oct 28 10:08:49 CST 2019
     */
    private Short roleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_admin
     *
     * @mbg.generated Mon Oct 28 10:08:49 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_admin.admin_id
     *
     * @return the value of t_admin.admin_id
     *
     * @mbg.generated Mon Oct 28 10:08:49 CST 2019
     */
    public Short getAdminId() {
        return adminId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_admin.admin_id
     *
     * @param adminId the value for t_admin.admin_id
     *
     * @mbg.generated Mon Oct 28 10:08:49 CST 2019
     */
    public void setAdminId(Short adminId) {
        this.adminId = adminId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_admin.user_name
     *
     * @return the value of t_admin.user_name
     *
     * @mbg.generated Mon Oct 28 10:08:49 CST 2019
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_admin.user_name
     *
     * @param userName the value for t_admin.user_name
     *
     * @mbg.generated Mon Oct 28 10:08:49 CST 2019
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_admin.email
     *
     * @return the value of t_admin.email
     *
     * @mbg.generated Mon Oct 28 10:08:49 CST 2019
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_admin.email
     *
     * @param email the value for t_admin.email
     *
     * @mbg.generated Mon Oct 28 10:08:49 CST 2019
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_admin.password
     *
     * @return the value of t_admin.password
     *
     * @mbg.generated Mon Oct 28 10:08:49 CST 2019
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_admin.password
     *
     * @param password the value for t_admin.password
     *
     * @mbg.generated Mon Oct 28 10:08:49 CST 2019
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_admin.ec_salt
     *
     * @return the value of t_admin.ec_salt
     *
     * @mbg.generated Mon Oct 28 10:08:49 CST 2019
     */
    public String getEcSalt() {
        return ecSalt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_admin.ec_salt
     *
     * @param ecSalt the value for t_admin.ec_salt
     *
     * @mbg.generated Mon Oct 28 10:08:49 CST 2019
     */
    public void setEcSalt(String ecSalt) {
        this.ecSalt = ecSalt == null ? null : ecSalt.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_admin.add_time
     *
     * @return the value of t_admin.add_time
     *
     * @mbg.generated Mon Oct 28 10:08:49 CST 2019
     */
    public Integer getAddTime() {
        return addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_admin.add_time
     *
     * @param addTime the value for t_admin.add_time
     *
     * @mbg.generated Mon Oct 28 10:08:49 CST 2019
     */
    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_admin.last_login
     *
     * @return the value of t_admin.last_login
     *
     * @mbg.generated Mon Oct 28 10:08:49 CST 2019
     */
    public Integer getLastLogin() {
        return lastLogin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_admin.last_login
     *
     * @param lastLogin the value for t_admin.last_login
     *
     * @mbg.generated Mon Oct 28 10:08:49 CST 2019
     */
    public void setLastLogin(Integer lastLogin) {
        this.lastLogin = lastLogin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_admin.last_ip
     *
     * @return the value of t_admin.last_ip
     *
     * @mbg.generated Mon Oct 28 10:08:49 CST 2019
     */
    public String getLastIp() {
        return lastIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_admin.last_ip
     *
     * @param lastIp the value for t_admin.last_ip
     *
     * @mbg.generated Mon Oct 28 10:08:49 CST 2019
     */
    public void setLastIp(String lastIp) {
        this.lastIp = lastIp == null ? null : lastIp.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_admin.lang_type
     *
     * @return the value of t_admin.lang_type
     *
     * @mbg.generated Mon Oct 28 10:08:49 CST 2019
     */
    public String getLangType() {
        return langType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_admin.lang_type
     *
     * @param langType the value for t_admin.lang_type
     *
     * @mbg.generated Mon Oct 28 10:08:49 CST 2019
     */
    public void setLangType(String langType) {
        this.langType = langType == null ? null : langType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_admin.agency_id
     *
     * @return the value of t_admin.agency_id
     *
     * @mbg.generated Mon Oct 28 10:08:49 CST 2019
     */
    public Short getAgencyId() {
        return agencyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_admin.agency_id
     *
     * @param agencyId the value for t_admin.agency_id
     *
     * @mbg.generated Mon Oct 28 10:08:49 CST 2019
     */
    public void setAgencyId(Short agencyId) {
        this.agencyId = agencyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_admin.suppliers_id
     *
     * @return the value of t_admin.suppliers_id
     *
     * @mbg.generated Mon Oct 28 10:08:49 CST 2019
     */
    public Short getSuppliersId() {
        return suppliersId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_admin.suppliers_id
     *
     * @param suppliersId the value for t_admin.suppliers_id
     *
     * @mbg.generated Mon Oct 28 10:08:49 CST 2019
     */
    public void setSuppliersId(Short suppliersId) {
        this.suppliersId = suppliersId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_admin.role_id
     *
     * @return the value of t_admin.role_id
     *
     * @mbg.generated Mon Oct 28 10:08:49 CST 2019
     */
    public Short getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_admin.role_id
     *
     * @param roleId the value for t_admin.role_id
     *
     * @mbg.generated Mon Oct 28 10:08:49 CST 2019
     */
    public void setRoleId(Short roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin
     *
     * @mbg.generated Mon Oct 28 10:08:49 CST 2019
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", adminId=").append(adminId);
        sb.append(", userName=").append(userName);
        sb.append(", email=").append(email);
        sb.append(", password=").append(password);
        sb.append(", ecSalt=").append(ecSalt);
        sb.append(", addTime=").append(addTime);
        sb.append(", lastLogin=").append(lastLogin);
        sb.append(", lastIp=").append(lastIp);
        sb.append(", langType=").append(langType);
        sb.append(", agencyId=").append(agencyId);
        sb.append(", suppliersId=").append(suppliersId);
        sb.append(", roleId=").append(roleId);
        sb.append("]");
        return sb.toString();
    }
}