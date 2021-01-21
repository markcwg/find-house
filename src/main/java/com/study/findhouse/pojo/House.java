package com.study.findhouse.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author markcwg
 * @email caiwg@sucsoft.com
 * @date 2021/1/20 17:25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "house",createIndex = false)
public class House {
    @Field(type = FieldType.Keyword)
    private String url;
    @Field(type = FieldType.Keyword)
    private String price;
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String title;
}
