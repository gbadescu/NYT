package io.swagger.client.model;

import java.util.*;

import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class DocByline  {
  
  @SerializedName("person")
  private List<ERRORUNKNOWN> person = null;
  @SerializedName("organization")
  private String organization = null;
  @SerializedName("original")
  private String original = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  public List<ERRORUNKNOWN> getPerson() {
    return person;
  }
  public void setPerson(List<ERRORUNKNOWN> person) {
    this.person = person;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getOrganization() {
    return organization;
  }
  public void setOrganization(String organization) {
    this.organization = organization;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getOriginal() {
    return original;
  }
  public void setOriginal(String original) {
    this.original = original;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocByline {\n");
    
    sb.append("  person: ").append(person).append("\n");
    sb.append("  organization: ").append(organization).append("\n");
    sb.append("  original: ").append(original).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
