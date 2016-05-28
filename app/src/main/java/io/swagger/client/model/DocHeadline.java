package io.swagger.client.model;


import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class DocHeadline  {
  
  @SerializedName("kicker")
  private String kicker = null;
  @SerializedName("main")
  private String main = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getKicker() {
    return kicker;
  }
  public void setKicker(String kicker) {
    this.kicker = kicker;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getMain() {
    return main;
  }
  public void setMain(String main) {
    this.main = main;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocHeadline {\n");
    
    sb.append("  kicker: ").append(kicker).append("\n");
    sb.append("  main: ").append(main).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
