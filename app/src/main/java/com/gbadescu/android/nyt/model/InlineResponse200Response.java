package com.gbadescu.android.nyt.model;

import com.gbadescu.android.nyt.model.Doc;
import com.gbadescu.android.nyt.model.InlineResponse200ResponseMeta;
import java.util.*;

import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class InlineResponse200Response  {
  
  @SerializedName("docs")
  private List<Doc> docs = null;
  @SerializedName("meta")
  private InlineResponse200ResponseMeta meta = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  public List<Doc> getDocs() {
    return docs;
  }
  public void setDocs(List<Doc> docs) {
    this.docs = docs;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public InlineResponse200ResponseMeta getMeta() {
    return meta;
  }
  public void setMeta(InlineResponse200ResponseMeta meta) {
    this.meta = meta;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse200Response {\n");
    
    sb.append("  docs: ").append(docs).append("\n");
    sb.append("  meta: ").append(meta).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
