package com.zs.home.network.dto.news;

import com.zs.home.network.dto.base.TecentBaseResponseDTO;

import java.io.Serializable;
import java.util.List;

public class NewsListDTO extends TecentBaseResponseDTO implements Serializable {

    public ShowapiResBody showapiResBody;

    public ShowapiResBody getShowapiResBody() {
        return showapiResBody;
    }

    public void setShowapiResBody(ShowapiResBody showapiResBody) {
        this.showapiResBody = showapiResBody;
    }

    public class ShowapiResBody implements Serializable {
        public Integer retCode;
        public Pagebean pagebean;

        public Integer getRetCode() {
            return retCode;
        }

        public void setRetCode(Integer retCode) {
            this.retCode = retCode;
        }

        public Pagebean getPagebean() {
            return pagebean;
        }

        public void setPagebean(Pagebean pagebean) {
            this.pagebean = pagebean;
        }
    }

    public class Pagebean implements Serializable {
        public Integer allPages;
        public List<Contentlist> contentlist = null;
        public Integer currentPage;
        public Integer allNum;
        public Integer maxResult;

        public Integer getAllPages() {
            return allPages;
        }

        public void setAllPages(Integer allPages) {
            this.allPages = allPages;
        }

        public List<Contentlist> getContentlist() {
            return contentlist;
        }

        public void setContentlist(List<Contentlist> contentlist) {
            this.contentlist = contentlist;
        }

        public Integer getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(Integer currentPage) {
            this.currentPage = currentPage;
        }

        public Integer getAllNum() {
            return allNum;
        }

        public void setAllNum(Integer allNum) {
            this.allNum = allNum;
        }

        public Integer getMaxResult() {
            return maxResult;
        }

        public void setMaxResult(Integer maxResult) {
            this.maxResult = maxResult;
        }
    }

    public class Contentlist implements Serializable {
        public List<String> allList = null;
        public String pubDate;
        public String title;
        public String channelName;
        public List<ImageUrl> imageurls = null;
        public String desc;
        public String source;
        public String channelId;
        public String nid;
        public String link;

        public List<String> getAllList() {
            return allList;
        }

        public void setAllList(List<String> allList) {
            this.allList = allList;
        }

        public String getPubDate() {
            return pubDate;
        }

        public void setPubDate(String pubDate) {
            this.pubDate = pubDate;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getChannelName() {
            return channelName;
        }

        public void setChannelName(String channelName) {
            this.channelName = channelName;
        }

        public List<ImageUrl> getImageurls() {
            return imageurls;
        }

        public void setImageurls(List<ImageUrl> imageurls) {
            this.imageurls = imageurls;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getChannelId() {
            return channelId;
        }

        public void setChannelId(String channelId) {
            this.channelId = channelId;
        }

        public String getNid() {
            return nid;
        }

        public void setNid(String nid) {
            this.nid = nid;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }
    }

    public class ImageUrl implements Serializable {
        public String height;
        public String width;
        public String url;

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public String getWidth() {
            return width;
        }

        public void setWidth(String width) {
            this.width = width;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
