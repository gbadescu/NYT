package com.gbadescu.android.nyt.model;

import com.gbadescu.android.nyt.model.InlineResponse200Response;

import io.swagger.annotations.*;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;


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

  class MyDeserialier implements JsonDeserializer<InlineResponse200>
  {
    @Override
    public InlineResponse200 deserialize(JsonElement je, Type type,
                                         JsonDeserializationContext jdc)
            throws JsonParseException
    {
      JsonObject obj = je.getAsJsonObject();
      if (obj.get("byline").isJsonArray())
      {
        obj.remove("byline");
      }

      return new Gson().fromJson(obj, InlineResponse200.class);
    }
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
