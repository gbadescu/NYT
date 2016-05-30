package com.gbadescu.android.nyt.api;

import com.gbadescu.android.nyt.ApiInvoker;
import com.gbadescu.android.nyt.ApiException;
import com.gbadescu.android.nyt.Pair;

import com.gbadescu.android.nyt.model.*;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import com.gbadescu.android.nyt.model.InlineResponse200;

import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class StoriesApi {
  String basePath = "http://api.nytimes.com/svc/search/v2";
  ApiInvoker apiInvoker = ApiInvoker.getInstance();

    public void addHeader(String key, String value) {
    getInvoker().addDefaultHeader(key, value);
  }

  public ApiInvoker getInvoker() {
    return apiInvoker;
  }

  public void setBasePath(String basePath) {
    this.basePath = basePath;
  }

  public String getBasePath() {
    return basePath;
  }

  
  /**
  * Article Search
  * Article Search requests use the following URI structure:\n
   * @param q Search query term. Search is performed on the article body, headline and byline.\n
   * @param fq \&quot;Filtered search query using standard Lucene syntax. \n\nThe filter query can be specified with or without a limiting field: label. \n\nSee Filtering Your Search for more information about filtering.\&quot;\n
   * @param beginDate \&quot;Format: YYYYMMDD \n\nRestricts responses to results with publication dates of the date specified or later.\&quot;\n
   * @param endDate \&quot;Format: YYYYMMDD \n\nRestricts responses to results with publication dates of the date specified or earlier.\&quot;\n
   * @param sort \&quot;By default, search results are sorted by their relevance to the query term (q). Use the sort parameter to sort by pub_date.\&quot;\n
   * @param fl \&quot;Comma-delimited list of fields (no limit)\n\n  Limits the fields returned in your search results. By default (unless you include an fl list in your request), the following fields are returned: \n  \n  web_url\n  \n  snippet\n  \n  lead_paragraph\n  \n  abstract\n  \n  print_page\n  \n  blog\n  \n  source\n  \n  multimedia\n  \n  headline\n  \n  keywords\n  \n  pub_date\n  \n  document_type\n  \n  news_desk\n  \n  byline\n  \n  type_of_material\n  \n  _id\n  \n  word_count\&quot;\n
   * @param hl Enables highlighting in search results. When set to true, the query term (q) is highlighted in the headline and lead_paragraph fields.\n\nNote: If highlighting is enabled, snippet will be returned even if it is not specified in your fl list.\&quot;\n
   * @param page \&quot;The value of page corresponds to a set of 10 results (it does not indicate the starting number of the result set). For example, page=0 corresponds to records 0-9. To return records 10-19, set page to 1, not 10.\&quot;\n
   * @param facetField Comma-delimited list of facets\n\nSpecifies the sets of facet values to include in the facets array at the end of response, which collects the facet values from all the search results. By default no facet fields will be returned. Below is the list of valid facets:\n\nsection_name\n\ndocument_type\n\ntype_of_material\n\nsource\n\nday_of_week\n\nTo learn more about using facets, see Using Facets.\n
   * @param facetFilter When set to true, facet counts will respect any applied filters (fq, date range, etc.) in addition to the main query term. To filter facet counts, specifying at least one facet_field is required. To learn more about using facets, see Using Facets.\n
   * @return InlineResponse200
  */
  public InlineResponse200 articlesearchJsonGet (String q, String fq, String beginDate, String endDate, String sort, String fl, Boolean hl, Integer page, String facetField, Boolean facetFilter) throws TimeoutException, ExecutionException, InterruptedException, ApiException {
     Object postBody = null;
  

  // create path and map variables
  String path = "/articlesearch.json".replaceAll("\\{format\\}","json");

  // query params
  List<Pair> queryParams = new ArrayList<Pair>();
      // header params
      Map<String, String> headerParams = new HashMap<String, String>();
      // form params
      Map<String, String> formParams = new HashMap<String, String>();

  
          queryParams.addAll(ApiInvoker.parameterToPairs("", "q", q));
  
          queryParams.addAll(ApiInvoker.parameterToPairs("", "fq", fq));
  
          queryParams.addAll(ApiInvoker.parameterToPairs("", "begin_date", beginDate));
  
          queryParams.addAll(ApiInvoker.parameterToPairs("", "end_date", endDate));
  
          queryParams.addAll(ApiInvoker.parameterToPairs("", "sort", sort));
  
          queryParams.addAll(ApiInvoker.parameterToPairs("", "fl", fl));
  
          queryParams.addAll(ApiInvoker.parameterToPairs("", "hl", hl));
  
          queryParams.addAll(ApiInvoker.parameterToPairs("", "page", page));
  
          queryParams.addAll(ApiInvoker.parameterToPairs("", "facet_field", facetField));
  
          queryParams.addAll(ApiInvoker.parameterToPairs("", "facet_filter", facetFilter));
  

  

      String[] contentTypes = {
  
      };
      String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

      if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
  

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
      } else {
      // normal form params
  
      }

      String[] authNames = new String[] { "apikey" };

      try {
          apiInvoker.setApiKey("8c886a54d8b24b9d96d2e4b29e3a4b2f");
        String localVarResponse = apiInvoker.invokeAPI (basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType, authNames);
        if(localVarResponse != null){

           return (InlineResponse200) ApiInvoker.deserialize(localVarResponse, "", InlineResponse200.class);
        } else {
           return null;
        }
      } catch (ApiException ex) {
         throw ex;
      } catch (InterruptedException ex) {
         throw ex;
      } catch (ExecutionException ex) {
         if(ex.getCause() instanceof VolleyError) {
            throw new ApiException(((VolleyError) ex.getCause()).networkResponse.statusCode, ((VolleyError) ex.getCause()).getMessage());
         }
         throw ex;
      } catch (TimeoutException ex) {
         throw ex;
      }
  }

      /**
   * Article Search
   * Article Search requests use the following URI structure:\n
   * @param q Search query term. Search is performed on the article body, headline and byline.\n   * @param fq \&quot;Filtered search query using standard Lucene syntax. \n\nThe filter query can be specified with or without a limiting field: label. \n\nSee Filtering Your Search for more information about filtering.\&quot;\n   * @param beginDate \&quot;Format: YYYYMMDD \n\nRestricts responses to results with publication dates of the date specified or later.\&quot;\n   * @param endDate \&quot;Format: YYYYMMDD \n\nRestricts responses to results with publication dates of the date specified or earlier.\&quot;\n   * @param sort \&quot;By default, search results are sorted by their relevance to the query term (q). Use the sort parameter to sort by pub_date.\&quot;\n   * @param fl \&quot;Comma-delimited list of fields (no limit)\n\n  Limits the fields returned in your search results. By default (unless you include an fl list in your request), the following fields are returned: \n  \n  web_url\n  \n  snippet\n  \n  lead_paragraph\n  \n  abstract\n  \n  print_page\n  \n  blog\n  \n  source\n  \n  multimedia\n  \n  headline\n  \n  keywords\n  \n  pub_date\n  \n  document_type\n  \n  news_desk\n  \n  byline\n  \n  type_of_material\n  \n  _id\n  \n  word_count\&quot;\n   * @param hl Enables highlighting in search results. When set to true, the query term (q) is highlighted in the headline and lead_paragraph fields.\n\nNote: If highlighting is enabled, snippet will be returned even if it is not specified in your fl list.\&quot;\n   * @param page \&quot;The value of page corresponds to a set of 10 results (it does not indicate the starting number of the result set). For example, page=0 corresponds to records 0-9. To return records 10-19, set page to 1, not 10.\&quot;\n   * @param facetField Comma-delimited list of facets\n\nSpecifies the sets of facet values to include in the facets array at the end of response, which collects the facet values from all the search results. By default no facet fields will be returned. Below is the list of valid facets:\n\nsection_name\n\ndocument_type\n\ntype_of_material\n\nsource\n\nday_of_week\n\nTo learn more about using facets, see Using Facets.\n   * @param facetFilter When set to true, facet counts will respect any applied filters (fq, date range, etc.) in addition to the main query term. To filter facet counts, specifying at least one facet_field is required. To learn more about using facets, see Using Facets.\n
  */
  public void articlesearchJsonGet (String q, String fq, String beginDate, String endDate, String sort, String fl, Boolean hl, Integer page, String facetField, Boolean facetFilter, final Response.Listener<InlineResponse200> responseListener, final Response.ErrorListener errorListener) {
    Object postBody = null;

  

    // create path and map variables
    String path = "/articlesearch.json".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();

    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "q", q));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "fq", fq));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "begin_date", beginDate));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "end_date", endDate));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "sort", sort));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "fl", fl));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "hl", hl));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "page", page));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "facet_field", facetField));
    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "facet_filter", facetFilter));
    

    

    String[] contentTypes = {
      
    };
    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
      

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
    } else {
      // normal form params
      
    }

      String[] authNames = new String[] { "apikey" };

    try {
        apiInvoker.setApiKey("8c886a54d8b24b9d96d2e4b29e3a4b2f");
      apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType, authNames,
        new Response.Listener<String>() {
          @Override
          public void onResponse(String localVarResponse) {
            
            try {
              responseListener.onResponse((InlineResponse200) ApiInvoker.deserialize(localVarResponse,  "", InlineResponse200.class));
              
              
            
            } catch (ApiException exception) {
               errorListener.onErrorResponse(new VolleyError(exception));
            }
            
          }
      }, new Response.ErrorListener() {
          @Override
          public void onErrorResponse(VolleyError error) {
            errorListener.onErrorResponse(error);
          }
      });
    } catch (ApiException ex) {
      errorListener.onErrorResponse(new VolleyError(ex));
    }
      catch(Exception e)
      {
          e.printStackTrace();
      }
  }
  
}
