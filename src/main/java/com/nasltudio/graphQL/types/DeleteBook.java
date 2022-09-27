package com.nasltudio.graphQL.types;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DeleteBook {
    private Integer id;
    private String name;
    private String pageCount;
}
