package com.gbadescu.android.nyt.model;

import com.gbadescu.android.nyt.model.DocByline;
import com.gbadescu.android.nyt.model.DocHeadline;
import com.gbadescu.android.nyt.model.DocKeywords;
import com.gbadescu.android.nyt.model.DocMultimedia;
import java.util.*;

import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;


@ApiModel(description = "")
@Parcel
public class Doc  {
  
  @SerializedName("web_url")
  private String webUrl = null;
  @SerializedName("snippet")
  private String snippet = null;
  @SerializedName("lead_paragraph")
  private String leadParagraph = null;
  @SerializedName("abstract")
  private String _abstract = null;
  @SerializedName("print_page")
  private String printPage = null;
  @SerializedName("blog")
  private List<String> blog = null;
  @SerializedName("source")
  private String source = null;
  @SerializedName("headline")
  private DocHeadline headline = null;
  @SerializedName("keywords")
  private List<DocKeywords> keywords = null;
  @SerializedName("pub_date")
  private String pubDate = null;
  @SerializedName("document_type")
  private String documentType = null;
  @SerializedName("news_desK")
  private String newsDesK = null;
  @SerializedName("section_name")
  private String sectionName = null;
  @SerializedName("subsection_name")
  private String subsectionName = null;
  @SerializedName("byline")
  private DocByline byline = null;
  @SerializedName("type_of_material")
  private String typeOfMaterial = null;
  @SerializedName("_id")
  private String id = null;
  @SerializedName("word_count")
  private String wordCount = null;
  @SerializedName("slideshow_credits")
  private String slideshowCredits = null;
  @SerializedName("multimedia")
  private List<DocMultimedia> multimedia = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getWebUrl() {
    return webUrl;
  }
  public void setWebUrl(String webUrl) {
    this.webUrl = webUrl;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getSnippet() {
    return snippet;
  }
  public void setSnippet(String snippet) {
    this.snippet = snippet;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getLeadParagraph() {
    return leadParagraph;
  }
  public void setLeadParagraph(String leadParagraph) {
    this.leadParagraph = leadParagraph;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getAbstract() {
    return _abstract;
  }
  public void setAbstract(String _abstract) {
    this._abstract = _abstract;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getPrintPage() {
    return printPage;
  }
  public void setPrintPage(String printPage) {
    this.printPage = printPage;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public List<String> getBlog() {
    return blog;
  }
  public void setBlog(List<String> blog) {
    this.blog = blog;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getSource() {
    return source;
  }
  public void setSource(String source) {
    this.source = source;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public DocHeadline getHeadline() {
    return headline;
  }
  public void setHeadline(DocHeadline headline) {
    this.headline = headline;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public List<DocKeywords> getKeywords() {
    return keywords;
  }
  public void setKeywords(List<DocKeywords> keywords) {
    this.keywords = keywords;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getPubDate() {
    return pubDate;
  }
  public void setPubDate(String pubDate) {
    this.pubDate = pubDate;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getDocumentType() {
    return documentType;
  }
  public void setDocumentType(String documentType) {
    this.documentType = documentType;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getNewsDesK() {
    return newsDesK;
  }
  public void setNewsDesK(String newsDesK) {
    this.newsDesK = newsDesK;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getSectionName() {
    return sectionName;
  }
  public void setSectionName(String sectionName) {
    this.sectionName = sectionName;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getSubsectionName() {
    return subsectionName;
  }
  public void setSubsectionName(String subsectionName) {
    this.subsectionName = subsectionName;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public DocByline getByline() {
    return byline;
  }
  public void setByline(DocByline byline) {
    this.byline = byline;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getTypeOfMaterial() {
    return typeOfMaterial;
  }
  public void setTypeOfMaterial(String typeOfMaterial) {
    this.typeOfMaterial = typeOfMaterial;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getWordCount() {
    return wordCount;
  }
  public void setWordCount(String wordCount) {
    this.wordCount = wordCount;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getSlideshowCredits() {
    return slideshowCredits;
  }
  public void setSlideshowCredits(String slideshowCredits) {
    this.slideshowCredits = slideshowCredits;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public List<DocMultimedia> getMultimedia() {
    return multimedia;
  }
  public void setMultimedia(List<DocMultimedia> multimedia) {
    this.multimedia = multimedia;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Doc {\n");
    
    sb.append("  webUrl: ").append(webUrl).append("\n");
    sb.append("  snippet: ").append(snippet).append("\n");
    sb.append("  leadParagraph: ").append(leadParagraph).append("\n");
    sb.append("  _abstract: ").append(_abstract).append("\n");
    sb.append("  printPage: ").append(printPage).append("\n");
    sb.append("  blog: ").append(blog).append("\n");
    sb.append("  source: ").append(source).append("\n");
    sb.append("  headline: ").append(headline).append("\n");
    sb.append("  keywords: ").append(keywords).append("\n");
    sb.append("  pubDate: ").append(pubDate).append("\n");
    sb.append("  documentType: ").append(documentType).append("\n");
    sb.append("  newsDesK: ").append(newsDesK).append("\n");
    sb.append("  sectionName: ").append(sectionName).append("\n");
    sb.append("  subsectionName: ").append(subsectionName).append("\n");
    sb.append("  byline: ").append(byline).append("\n");
    sb.append("  typeOfMaterial: ").append(typeOfMaterial).append("\n");
    sb.append("  id: ").append(id).append("\n");
    sb.append("  wordCount: ").append(wordCount).append("\n");
    sb.append("  slideshowCredits: ").append(slideshowCredits).append("\n");
    sb.append("  multimedia: ").append(multimedia).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
