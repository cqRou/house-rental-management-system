package com.heeexy.example.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("article")
public class ArticleEntity extends BaseEntity implements Serializable {
    @TableId
    private Long id;
    /**
     * 文章内容
     */
    private String content;

}
