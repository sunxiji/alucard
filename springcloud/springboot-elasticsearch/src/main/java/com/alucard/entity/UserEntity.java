package com.alucard.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author alucard
 * @Description
 * @Date Create in 13:03 2018/11/20
 */
@Document(indexName = "mymayikt", type = "user")
@Data
public class UserEntity {
    @Id
    private String id;
    private String name;
    private int sex;
    private int age;
}
