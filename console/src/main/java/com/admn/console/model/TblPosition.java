package com.admn.console.model;

import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Table(name = "TBL_POSITION")
public class TblPosition implements Serializable {
    private Integer positionId;

    @NotBlank(message = "职位名不能为空")
    private String positionName;

    @NotBlank(message = "工作类型不能为空")
    private String workType;

    @NotNull(message = "薪资不能为空")
    private BigDecimal salary;

    @NotBlank(message = "薪资类型不能为空")
    private String salaryType;

    @NotBlank(message = "教育要求不能为空")
    private String eduRequirement;

    @NotBlank(message = "工作要求不能为空")
    private String workRequirement;

    @NotBlank(message = "工作地区不能为空")
    private String workArea;

    @NotBlank(message = "工作描述不能为空")
    private String workDescription;

    private static final long serialVersionUID = 1L;

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getSalaryType() {
        return salaryType;
    }

    public void setSalaryType(String salaryType) {
        this.salaryType = salaryType;
    }

    public String getEduRequirement() {
        return eduRequirement;
    }

    public void setEduRequirement(String eduRequirement) {
        this.eduRequirement = eduRequirement;
    }

    public String getWorkRequirement() {
        return workRequirement;
    }

    public void setWorkRequirement(String workRequirement) {
        this.workRequirement = workRequirement;
    }

    public String getWorkArea() {
        return workArea;
    }

    public void setWorkArea(String workArea) {
        this.workArea = workArea;
    }

    public String getWorkDescription() {
        return workDescription;
    }

    public void setWorkDescription(String workDescription) {
        this.workDescription = workDescription;
    }
}