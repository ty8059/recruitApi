package com.admn.web.model;

import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "TBL_SYS_CODE")
public class TblSysCode implements Serializable {
    private String typeCode;

    private String typeCn;

    private String typeEn;

    private String display1;

    private String display2;

    private String status;

    private Integer showId;

    private String reserved1;

    private String reserved2;

    private static final long serialVersionUID = 1L;

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeCn() {
        return typeCn;
    }

    public void setTypeCn(String typeCn) {
        this.typeCn = typeCn;
    }

    public String getTypeEn() {
        return typeEn;
    }

    public void setTypeEn(String typeEn) {
        this.typeEn = typeEn;
    }

    public String getDisplay1() {
        return display1;
    }

    public void setDisplay1(String display1) {
        this.display1 = display1;
    }

    public String getDisplay2() {
        return display2;
    }

    public void setDisplay2(String display2) {
        this.display2 = display2;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getShowId() {
        return showId;
    }

    public void setShowId(Integer showId) {
        this.showId = showId;
    }

    public String getReserved1() {
        return reserved1;
    }

    public void setReserved1(String reserved1) {
        this.reserved1 = reserved1;
    }

    public String getReserved2() {
        return reserved2;
    }

    public void setReserved2(String reserved2) {
        this.reserved2 = reserved2;
    }
}