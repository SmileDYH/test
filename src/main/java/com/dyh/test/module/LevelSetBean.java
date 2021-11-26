package com.dyh.test.module;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Description:
 * Created by bq.ren on 2021/10/8.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LevelSetBean {

    @JSONField(ordinal = 1)
    private String name;

    @JSONField(ordinal = 2)
    private Integer start;

    @JSONField(ordinal = 3)
    private Integer end;

}
