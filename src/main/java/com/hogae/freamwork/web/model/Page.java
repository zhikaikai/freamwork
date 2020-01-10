package com.hogae.freamwork.web.model;

import lombok.Data;

@Data
public class Page {

    public final static int DEFUALT_PAGE_NUM = 1;

    public final static int DEFUALT_PAGE_Size = 10;
    /**
     * 当前页数
     */
    private int pageNum = DEFUALT_PAGE_NUM;
    /**
     * 显示条数
     */
    private int pageSize = DEFUALT_PAGE_Size;


}
