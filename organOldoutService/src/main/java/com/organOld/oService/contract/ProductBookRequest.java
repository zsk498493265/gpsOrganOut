package com.organOld.oService.contract;

public class ProductBookRequest {
    private Integer oldmanId;

    private String[] bookIds;

    public String[] getBookIds() {
        return bookIds;
    }

    public void setBookIds(String[] bookIds) {
        this.bookIds = bookIds;
    }

    public Integer getOldmanId() {
        return oldmanId;
    }

    public void setOldmanId(Integer oldmanId) {
        this.oldmanId = oldmanId;
    }
}
