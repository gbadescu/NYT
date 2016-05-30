package com.gbadescu.android.nyt.model;

/**
 * Created by gbadesc on 5/27/16.
 */
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;


@ApiModel(description = "")
@Parcel
public class Person  {

    @SerializedName("rank")
    private String rank = null;
    @SerializedName("firstname")
    private String firstname = null;
    @SerializedName("lastname")
    private String lastname = null;
    @SerializedName("organization")
    private String organization = null;
    @SerializedName("role")
    private String role = null;


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
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    /**
     **/
    @ApiModelProperty(value = "")
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     **/
    @ApiModelProperty(value = "")
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }


    /**
     **/
    @ApiModelProperty(value = "")
    public String getOrganization() {
        return organization;
    }
    public void setOrganization(String value) {
        this.organization = organization;
    }



    @Override
    public String toString()  {
        StringBuilder sb = new StringBuilder();
        sb.append("class DocKeywords {\n");

        sb.append("  rank: ").append(rank).append("\n");
        sb.append("  name: ").append(firstname).append("\n");
        sb.append("  value: ").append(organization).append("\n");
        sb.append("}\n");
        return sb.toString();
    }
}
