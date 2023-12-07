package com.limyel.blog.common.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PageData<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long pages;

    private Long total;

    private List<T> list;

    public PageData(Long pages, Long total, List<T> list) {
        this.pages = pages;
        this.total = total;
        this.list = list;
    }

}
