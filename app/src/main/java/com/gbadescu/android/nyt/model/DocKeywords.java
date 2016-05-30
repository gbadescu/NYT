package com.gbadescu.android.nyt.model;


import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;


@ApiModel(description = "")
@Parcel
public class DocKeywords  {
  
  @SerializedName("rank")
  private String rank = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("value")
  private String value = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getRank() {
    return rank;
  }
  public void setRank(String rank) {
    this.rank = rank;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getValue() {
    return value;
  }
  public void setValue(String value) {
    this.value = value;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocKeywords {\n");
    
    sb.append("  rank: ").append(rank).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  value: ").append(value).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
