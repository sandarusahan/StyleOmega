package com.example.sandaru.styleomega.Model;

/**
 * Created by sanda on 19/09/2017.
 */

public class Cart {
    int cid;
    String cname;
    String cqty;
    String cimg;

    public String getCprice() {
        return cprice;
    }

    public void setCprice(String cprice) {
        this.cprice = cprice;
    }

    String cprice ;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }



    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCqty() {
        return cqty;
    }

    public void setCqty(String cqty) {
        this.cqty = cqty;
    }

    public String getCimg() {
        return cimg;
    }

    public void setCimg(String cimg) {
        this.cimg = cimg;
    }
}
