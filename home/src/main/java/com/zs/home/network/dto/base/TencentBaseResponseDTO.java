package com.zs.home.network.dto.base;

import java.io.Serializable;

public class TencentBaseResponseDTO implements Serializable {
    public Integer showapi_res_code;
    public String showapi_res_error;

    public Integer getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(Integer showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    @Override
    public String toString() {
        return "TecentBaseResponseDTO{" +
                "showapiResCode=" + showapi_res_code +
                ", showapiResError='" + showapi_res_error + '\'' +
                '}';
    }
}
