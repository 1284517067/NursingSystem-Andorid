package com.example.nursingsystem.Model;

import java.io.Serializable;

public class Drug implements Serializable {
    private String generic_drugname;//药品通用名称
    private String general_catalogue_formulations;//通用目录剂型
    private String drug_code;//本位码
    private String acid_radical;//酸根
    private String salt_base;//盐基
    private String english_name;//英文名称
    private String specification;//药品注册标准
    private String manufacturer;//生产单位
    private String approval_num;//批准文号

    public Drug() {
    }

    public String getGeneric_drugname() {
        return generic_drugname;
    }

    public void setGeneric_drugname(String generic_drugname) {
        this.generic_drugname = generic_drugname;
    }

    public String getGeneral_catalogue_formulations() {
        return general_catalogue_formulations;
    }

    public void setGeneral_catalogue_formulations(String general_catalogue_formulations) {
        this.general_catalogue_formulations = general_catalogue_formulations;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getDrug_code() {
        return drug_code;
    }

    public void setDrug_code(String drug_code) {
        this.drug_code = drug_code;
    }

    public String getAcid_radical() {
        return acid_radical;
    }

    public void setAcid_radical(String acid_radical) {
        this.acid_radical = acid_radical;
    }

    public String getSalt_base() {
        return salt_base;
    }

    public void setSalt_base(String salt_base) {
        this.salt_base = salt_base;
    }

    public String getEnglish_name() {
        return english_name;
    }

    public void setEnglish_name(String english_name) {
        this.english_name = english_name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getApproval_num() {
        return approval_num;
    }

    public void setApproval_num(String approval_num) {
        this.approval_num = approval_num;
    }
}
