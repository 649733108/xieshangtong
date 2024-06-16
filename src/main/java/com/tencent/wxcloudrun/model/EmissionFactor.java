package com.tencent.wxcloudrun.model;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@TableName("emission_factor")
@Data
public class EmissionFactor {

    @TableId
    private Integer id;
    private String name;
    private String code;
    private String category;
    private String category2;
    private Double value;
    private String unit;
    private Date createTime;
    private Date updateTime;
}
