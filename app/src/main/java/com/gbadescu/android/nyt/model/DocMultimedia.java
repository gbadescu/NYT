package com.gbadescu.android.nyt.model;


import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;


@ApiModel(description = "")
@Parcel
public class DocMultimedia  {
  
  @SerializedName("height")
  private Integer height = null;
  @SerializedName("subtype")
  private String subtype = null;
  @SerializedName("width")
  private Integer width = null;
  @SerializedName("caption")
  private String caption = null;
  @SerializedName("copyright")
  private String copyright = null;
  @SerializedName("format")
  private String format = null;
  @SerializedName("type")
  private String type = null;
  @SerializedName("url")
  private String url = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  public Integer getHeight() {
    return height;
  }
  public void setHeight(Integer height) {
    this.height = height;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getSubtype() {
    return subtype;
  }
  public void setSubtype(String subtype) {
    this.subtype = subtype;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public Integer getWidth() {
    return width;
  }
  public void setWidth(Integer width) {
    this.width = width;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getCaption() {
    return caption;
  }
  public void setCaption(String caption) {
    this.caption = caption;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getCopyright() {
    return copyright;
  }
  public void setCopyright(String copyright) {
    this.copyright = copyright;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getFormat() {
    return format;
  }
  public void setFormat(String format) {
    this.format = format;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getUrl() {
    return url;
  }
  public void setUrl(String url) {
    this.url = url;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocMultimedia {\n");
    
    sb.append("  height: ").append(height).append("\n");
    sb.append("  subtype: ").append(subtype).append("\n");
    sb.append("  width: ").append(width).append("\n");
    sb.append("  caption: ").append(caption).append("\n");
    sb.append("  copyright: ").append(copyright).append("\n");
    sb.append("  format: ").append(format).append("\n");
    sb.append("  type: ").append(type).append("\n");
    sb.append("  url: ").append(url).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
