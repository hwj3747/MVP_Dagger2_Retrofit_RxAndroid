package com.hwj3747.test.entity;

import java.util.List;

/**
 * @author 何伟杰
 * @version 1.0, 2017/1/11
 */
public class jsonOut {

    private List<String> wapCatalog;	/*List<String>*/
    public void setWapCatalog(List<String> value){
        this.wapCatalog = value;
    }
    public List<String> getWapCatalog(){
        return this.wapCatalog;
    }

    private	List<String>	catalog;	/*List<String>*/
    public void setCatalog(List<String> value){
        this.catalog = value;
    }
    public List<String> getCatalog(){
        return this.catalog;
    }

    public static class TCard{

        private	List<String>	value;	/*List<String>*/
        public void setValue(List<String> value){
            this.value = value;
        }
        public List<String> getValue(){
            return this.value;
        }

        private	List<String>	format;	/*List<String>*/
        public void setFormat(List<String> value){
            this.format = value;
        }
        public List<String> getFormat(){
            return this.format;
        }

        private	String	name;	/*中文名*/
        private	String	key;	/*m25_nameC*/

        public void setName(String value){
            this.name = value;
        }
        public String getName(){
            return this.name;
        }

        public void setKey(String value){
            this.key = value;
        }
        public String getKey(){
            return this.key;
        }

    }
    private	List<TCard>	card;	/*List<TCard>*/
    public void setCard(List<TCard> value){
        this.card = value;
    }
    public List<TCard> getCard(){
        return this.card;
    }

    private	String	logo;	/*http:%/%/img.baidu.com%/img%/baike%/logo-baike.gif*/
    private	Integer	imageHeight;	/*457*/
    private	String	desc;	/*关键字*/
    private	String	copyrights;	/*以上内容来自百度百科平台，由百度百科网友创作。*/
    private	String	image;	/*http:%/%/e.hiphotos.baidu.com%/baike%/pic%/item%/03087bf40ad162d916f1683413dfa9ec8a13cdff.jpg*/
    private	Integer	subLemmaId;	/*390935*/
    private	String	url;	/*http:%/%/baike.baidu.com%/view%/390935.htm*/
    private	Integer	id;	/*390935*/
    private	Integer	hasOther;	/*0*/
    private	String	title;	/*关键字*/
    private	String	isSummaryPic;	/*y*/
    private	String	wapUrl;	/*http:%/%/wapbaike.baidu.com%/view%/390935.htm*/
    private	Integer	newLemmaId;	/*7105697*/
    private	String	src;	/*03087bf40ad162d916f1683413dfa9ec8a13cdff*/
    private	String	customImg;	/**/
    private	String	key;	/*关键字*/
    private	Integer	imageWidth;	/*404*/

    public void setLogo(String value){
        this.logo = value;
    }
    public String getLogo(){
        return this.logo;
    }

    public void setImageHeight(Integer value){
        this.imageHeight = value;
    }
    public Integer getImageHeight(){
        return this.imageHeight;
    }

    public void setDesc(String value){
        this.desc = value;
    }
    public String getDesc(){
        return this.desc;
    }

    public void setCopyrights(String value){
        this.copyrights = value;
    }
    public String getCopyrights(){
        return this.copyrights;
    }

    public void setImage(String value){
        this.image = value;
    }
    public String getImage(){
        return this.image;
    }

    public void setSubLemmaId(Integer value){
        this.subLemmaId = value;
    }
    public Integer getSubLemmaId(){
        return this.subLemmaId;
    }

    public void setUrl(String value){
        this.url = value;
    }
    public String getUrl(){
        return this.url;
    }

    public void setId(Integer value){
        this.id = value;
    }
    public Integer getId(){
        return this.id;
    }

    public void setHasOther(Integer value){
        this.hasOther = value;
    }
    public Integer getHasOther(){
        return this.hasOther;
    }

    public void setTitle(String value){
        this.title = value;
    }
    public String getTitle(){
        return this.title;
    }

    public void setIsSummaryPic(String value){
        this.isSummaryPic = value;
    }
    public String getIsSummaryPic(){
        return this.isSummaryPic;
    }

    public void setWapUrl(String value){
        this.wapUrl = value;
    }
    public String getWapUrl(){
        return this.wapUrl;
    }

    public void setNewLemmaId(Integer value){
        this.newLemmaId = value;
    }
    public Integer getNewLemmaId(){
        return this.newLemmaId;
    }

    public void setSrc(String value){
        this.src = value;
    }
    public String getSrc(){
        return this.src;
    }

    public void setCustomImg(String value){
        this.customImg = value;
    }
    public String getCustomImg(){
        return this.customImg;
    }

    public void setKey(String value){
        this.key = value;
    }
    public String getKey(){
        return this.key;
    }

    public void setImageWidth(Integer value){
        this.imageWidth = value;
    }
    public Integer getImageWidth(){
        return this.imageWidth;
    }
}
