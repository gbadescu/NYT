package io.swagger.client.model;

import io.swagger.client.model.InlineResponse200Response;

import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class InlineResponse200  {
  
  @SerializedName("response")
  private InlineResponse200Response response = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  public InlineResponse200Response getResponse() {
    return response;
  }
  public void setResponse(InlineResponse200Response response) {
    this.response = response;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse200 {\n");
    
    sb.append("  response: ").append(response).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
