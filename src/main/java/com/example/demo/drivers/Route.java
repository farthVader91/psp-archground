package com.example.demo.drivers;

public class Route {
    private String psp;
    private String company_account;
    private String merchant_account;

    public Route(String psp, String company_account, String merchant_account) {
        this.psp = psp;
        this.company_account = company_account;
        this.merchant_account = merchant_account;
    }

    public String getPsp() {
        return psp;
    }

    public void setPsp(String psp) {
        this.psp = psp;
    }

    public String getCompany_account() {
        return company_account;
    }

    public void setCompany_account(String company_account) {
        this.company_account = company_account;
    }

    public String getMerchant_account() {
        return merchant_account;
    }

    public void setMerchant_account(String merchant_account) {
        this.merchant_account = merchant_account;
    }
}
