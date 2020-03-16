package com.hkb.Bean;

import java.sql.Timestamp;

public class Park {
    private String parkno = "";
    private String carno = "";
    private String cartype = "";
    private Timestamp intime;

    public Park() {
    }

    public Park(String parkno, String carno, String cartype, Timestamp intime) {
        this.parkno = parkno;
        this.carno = carno;
        this.cartype = cartype;
        this.intime = intime;
    }

    public String getParkno() {
        return parkno;
    }

    public void setParkno(String parkno) {
        this.parkno = parkno;
    }

    public String getCarno() {
        return carno;
    }

    public void setCarno(String carno) {
        this.carno = carno;
    }

    public String getCartype() {
        return cartype;
    }

    public void setCartype(String cartype) {
        this.cartype = cartype;
    }

    public Timestamp getIntime() {
        return intime;
    }

    public void setIntime(Timestamp intime) {
        this.intime = intime;
    }
}
