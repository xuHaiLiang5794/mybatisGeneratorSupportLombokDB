package com.xuhailiang5794.business.entity;

import lombok.Data;

@Data
public class NationalTree extends NationalTreeKey {
    private Boolean isParent;

    /**
     * 名字
    */
    private String name;

    private String pid;

    private String wdcode;

    private Boolean required;
}