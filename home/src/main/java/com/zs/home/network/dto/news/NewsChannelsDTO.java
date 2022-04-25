package com.zs.home.network.dto.news;
import com.zs.home.network.dto.base.TencentBaseResponseDTO;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Allen on 2017/7/20.
 * 保留所有版权，未经允许请不要分享到互联网和其他人
 */
public class NewsChannelsDTO extends TencentBaseResponseDTO implements Serializable {
    public ShowapiResBody showapi_res_body;

    public ShowapiResBody getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(ShowapiResBody showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public class ShowapiResBody implements Serializable{
        public Integer totalNum;
        public Integer ret_code;
        public List<ChannelList> channelList = null;

        public Integer getTotalNum() {
            return totalNum;
        }

        public Integer getRet_code() {
            return ret_code;
        }

        public void setRet_code(Integer ret_code) {
            this.ret_code = ret_code;
        }

        public void setTotalNum(Integer totalNum) {
            this.totalNum = totalNum;
        }

        public List<ChannelList> getChannelList() {
            return channelList;
        }

        public void setChannelList(List<ChannelList> channelList) {
            this.channelList = channelList;
        }
    }
    public class ChannelList implements Serializable {
        public String channelId;
        public String name;

        public String getChannelId() {
            return channelId;
        }

        public void setChannelId(String channelId) {
            this.channelId = channelId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
