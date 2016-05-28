package io.swagger.client.model;


import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class InlineResponse200ResponseMeta  {
  
  @SerializedName("time")
  private Integer time = null;
  @SerializedName("hits")
  private Integer hits = null;
  @SerializedName("offset")
  private Integer offset = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  public Integer getTime() {
    return time;
  }
  public void setTime(Integer time) {
    this.time = time;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public Integer getHits() {
    return hits;
  }
  public void setHits(Integer hits) {
    this.hits = hits;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public Integer getOffset() {
    return offset;
  }
  public void setOffset(Integer offset) {
    this.offset = offset;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse200ResponseMeta {\n");
    
    sb.append("  time: ").append(time).append("\n");
    sb.append("  hits: ").append(hits).append("\n");
    sb.append("  offset: ").append(offset).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
