package com.zs.home.network.dto.news;
import com.zs.home.network.dto.base.TecentBaseResponseDTO;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Allen on 2017/7/20.
 * 保留所有版权，未经允许请不要分享到互联网和其他人
 */
public class NewsChannelsDTO extends TecentBaseResponseDTO implements Serializable {
    public ShowapiResBody showapiResBody;

    public ShowapiResBody getShowapiResBody() {
        return showapiResBody;
    }

    public void setShowapiResBody(ShowapiResBody showapiResBody) {
        this.showapiResBody = showapiResBody;
    }

    public class ShowapiResBody implements Serializable{
        public Integer totalNum;
        public Integer retCode;
        public List<ChannelList> channelList = null;

        public Integer getTotalNum() {
            return totalNum;
        }

        public void setTotalNum(Integer totalNum) {
            this.totalNum = totalNum;
        }

        public Integer getRetCode() {
            return retCode;
        }

        public void setRetCode(Integer retCode) {
            this.retCode = retCode;
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
