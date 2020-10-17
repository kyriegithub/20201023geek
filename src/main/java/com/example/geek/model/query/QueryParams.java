package com.example.geek.model.query;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;


import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * @author xiehejun@dxy.cn
 * @Description
 * @date 2019/8/30 4:49 PM
 */
@Data
public class QueryParams implements Serializable {

    /**
     * if required will be get from request header
     */
    private Integer orgId;
    /**
     * if required will be get from request header
     */
    private Integer clinicId;
    /**
     * if required will be get from request header
     */
    private Integer staffId;

    /**
     * default value is 1
     */
    private Integer subscribeStatus;

    /**
     * default value is ALL
     */
    private String subscribeType;


    private String codeStr;

    private List<String> tagCodes;

    public List<String> getTagCodes() {
        if(StringUtils.isNotBlank(codeStr)){
            tagCodes = Arrays.asList(codeStr.split(","));
        }
        return tagCodes;
    }
}
