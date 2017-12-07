package com.study.cache.entity;

import java.math.BigDecimal;
import java.util.Date;

public class TOrderDetail {
	private Long orderid;
	
    private String code;

    private String gtype;

    private String gcode;

    private Date creattime;

    private BigDecimal price;

    private String ucode;

    
    public Long getOrderid() {
		return orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getGtype() {
        return gtype;
    }

    public void setGtype(String gtype) {
        this.gtype = gtype;
    }

    public String getGcode() {
        return gcode;
    }

    public void setGcode(String gcode) {
        this.gcode = gcode;
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getUcode() {
        return ucode;
    }

    public void setUcode(String ucode) {
        this.ucode = ucode;
    }

	@Override
	public String toString() {
		return "TOrderDetail [code=" + code + ", gtype=" + gtype + ", gcode="
				+ gcode + ", creattime=" + creattime + ", price=" + price
				+ ", ucode=" + ucode + "]";
	}
    
    
    
}