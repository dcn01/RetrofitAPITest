package com.example.retrofittest.model;


import java.util.List;

/**
 * Created by Juwuguo on 2017/11/15.
 */

public class UserBean {
    private String userId;
    private String name;        //用户名
    private String address;        //用户住址
    private String area;        //地区
    private String avatar;        //用户头像
    private String birthday;        //用户生日
    private String sex;        //用户性别	0:女		1:男		2:其他
    private String status;            //用户状态	0:invalid	1:正常		2：未完成注册(default)
    private String tel;            //用户手机号
    private int type;        //用户类型	1:患者(default)	2:家属
    private String height;        //用户身高
    private String weight;        //用户体重
    private String waistline;    //用户腰围
    private String marriage;    //婚姻状况	0:未婚	1：已婚
    private String education;    //文化程度	1-6依次为初中及以下，高中或中专，大专，本科，硕士，博士
    private String ethnicity;        //民族
    private String qrCodeUrl;    //患者二维码
    public String province;
    public String city;
    public String town;
    private String doctorId;// 患者绑定医生id
    private String showId;//患者识别码
    private String bank;//银行
    private String bankCardNumber;//卡号
    private String idCard;//身份证号
    private String realName;
    private String idCardUrl;
    private List<String> photo;
    private String realStatus;
    private String wechatBindStatus;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getWaistline() {
        return waistline;
    }

    public void setWaistline(String waistline) {
        this.waistline = waistline;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }


    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;

    }

    public String getShowId() {
        return this.showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    public String getQrCodeUrl() {
        return this.qrCodeUrl;
    }

    public void setQrCodeUrl(String qrCodeUrl) {
        this.qrCodeUrl = qrCodeUrl;
    }

    public String getBank() {
        return this.bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBankCardNumber() {
        return this.bankCardNumber;
    }

    public void setBankCardNumber(String bankCardNumber) {
        this.bankCardNumber = bankCardNumber;
    }

    public String getIdCard() {
        return this.idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getRealName() {
        return this.realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdCardUrl() {
        return this.idCardUrl;
    }

    public void setIdCardUrl(String idCardUrl) {
        this.idCardUrl = idCardUrl;
    }

    public List<String> getPhoto() {
        return this.photo;
    }

    public void setPhoto(List<String> photo) {
        this.photo = photo;
    }

    public String getRealStatus() {
        return this.realStatus;
    }

    public void setRealStatus(String realStatus) {
        this.realStatus = realStatus;
    }

}
