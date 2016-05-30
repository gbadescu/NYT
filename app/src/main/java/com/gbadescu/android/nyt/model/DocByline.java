package com.gbadescu.android.nyt.model;

import java.util.*;

import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;


@ApiModel(description = "")
@Parcel
public class DocByline  {
  
  @SerializedName("person")
  private List<Person> person = null;
  @SerializedName("organization")
  private String organization = null;
  @SerializedName("original")
  private String original = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  public List<Person> getPerson() {
    return person;
  }
  public void setPerson(List<Person> person) {
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
