package com.zs.home.network.dto.base;

import java.io.Serializable;

public class TecentBaseResponseDTO implements Serializable {
    public Integer showapiResCode;
    public String showapiResError;

    public Integer getShowapiResCode() {
        return showapiResCode;
    }

    public void setShowapiResCode(Integer showapiResCode) {
        this.showapiResCode = showapiResCode;
    }

    public String getShowapiResError() {
        return showapiResError;
    }

    public void setShowapiResError(String showapiResError) {
        this.showapiResError = showapiResError;
    }

    @Override
    public String toString() {
        return "TecentBaseResponseDTO{" +
                "showapiResCode=" + showapiResCode +
                ", showapiResError='" + showapiResError + '\'' +
                '}';
    }
}
