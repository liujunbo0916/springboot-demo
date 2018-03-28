package com.liujunbo.springbootdemo.entity;

public class TSchool {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_school.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_school.sc_name
     *
     * @mbggenerated
     */
    private String scName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_school.sc_web
     *
     * @mbggenerated
     */
    private String scWeb;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_school.sc_phone
     *
     * @mbggenerated
     */
    private String scPhone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_school.sc_address
     *
     * @mbggenerated
     */
    private String scAddress;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_school
     *
     * @mbggenerated
     */
    public TSchool(Integer id, String scName, String scWeb, String scPhone, String scAddress) {
        this.id = id;
        this.scName = scName;
        this.scWeb = scWeb;
        this.scPhone = scPhone;
        this.scAddress = scAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_school
     *
     * @mbggenerated
     */
    public TSchool() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_school.id
     *
     * @return the value of t_school.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_school.id
     *
     * @param id the value for t_school.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_school.sc_name
     *
     * @return the value of t_school.sc_name
     *
     * @mbggenerated
     */
    public String getScName() {
        return scName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_school.sc_name
     *
     * @param scName the value for t_school.sc_name
     *
     * @mbggenerated
     */
    public void setScName(String scName) {
        this.scName = scName == null ? null : scName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_school.sc_web
     *
     * @return the value of t_school.sc_web
     *
     * @mbggenerated
     */
    public String getScWeb() {
        return scWeb;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_school.sc_web
     *
     * @param scWeb the value for t_school.sc_web
     *
     * @mbggenerated
     */
    public void setScWeb(String scWeb) {
        this.scWeb = scWeb == null ? null : scWeb.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_school.sc_phone
     *
     * @return the value of t_school.sc_phone
     *
     * @mbggenerated
     */
    public String getScPhone() {
        return scPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_school.sc_phone
     *
     * @param scPhone the value for t_school.sc_phone
     *
     * @mbggenerated
     */
    public void setScPhone(String scPhone) {
        this.scPhone = scPhone == null ? null : scPhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_school.sc_address
     *
     * @return the value of t_school.sc_address
     *
     * @mbggenerated
     */
    public String getScAddress() {
        return scAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_school.sc_address
     *
     * @param scAddress the value for t_school.sc_address
     *
     * @mbggenerated
     */
    public void setScAddress(String scAddress) {
        this.scAddress = scAddress == null ? null : scAddress.trim();
    }
}