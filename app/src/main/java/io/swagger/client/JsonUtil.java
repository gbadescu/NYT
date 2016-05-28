package io.swagger.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import io.swagger.client.model.*;

public class JsonUtil {
  public static GsonBuilder gsonBuilder;

  static {
    gsonBuilder = new GsonBuilder();
    gsonBuilder.serializeNulls();
    gsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
  }

  public static Gson getGson() {
    return gsonBuilder.create();
  }

  public static String serialize(Object obj){
    return getGson().toJson(obj);
  }

  public static <T> T deserializeToList(String jsonString, Class cls){
    return getGson().fromJson(jsonString, getListTypeForDeserialization(cls));
  }

  public static <T> T deserializeToObject(String jsonString, Class cls){
    return getGson().fromJson(jsonString, getTypeForDeserialization(cls));
  }

  public static Type getListTypeForDeserialization(Class cls) {
    String className = cls.getSimpleName();
    
    if ("Doc".equalsIgnoreCase(className)) {
      return new TypeToken<List<Doc>>(){}.getType();
    }
    
    if ("DocByline".equalsIgnoreCase(className)) {
      return new TypeToken<List<DocByline>>(){}.getType();
    }
    
    if ("DocHeadline".equalsIgnoreCase(className)) {
      return new TypeToken<List<DocHeadline>>(){}.getType();
    }
    
    if ("DocKeywords".equalsIgnoreCase(className)) {
      return new TypeToken<List<DocKeywords>>(){}.getType();
    }
    
    if ("DocMultimedia".equalsIgnoreCase(className)) {
      return new TypeToken<List<DocMultimedia>>(){}.getType();
    }
    
    if ("InlineResponse200".equalsIgnoreCase(className)) {
      return new TypeToken<List<InlineResponse200>>(){}.getType();
    }
    
    if ("InlineResponse200Response".equalsIgnoreCase(className)) {
      return new TypeToken<List<InlineResponse200Response>>(){}.getType();
    }
    
    if ("InlineResponse200ResponseMeta".equalsIgnoreCase(className)) {
      return new TypeToken<List<InlineResponse200ResponseMeta>>(){}.getType();
    }
    
    return new TypeToken<List<Object>>(){}.getType();
  }

  public static Type getTypeForDeserialization(Class cls) {
    String className = cls.getSimpleName();
    
    if ("Doc".equalsIgnoreCase(className)) {
      return new TypeToken<Doc>(){}.getType();
    }
    
    if ("DocByline".equalsIgnoreCase(className)) {
      return new TypeToken<DocByline>(){}.getType();
    }
    
    if ("DocHeadline".equalsIgnoreCase(className)) {
      return new TypeToken<DocHeadline>(){}.getType();
    }
    
    if ("DocKeywords".equalsIgnoreCase(className)) {
      return new TypeToken<DocKeywords>(){}.getType();
    }
    
    if ("DocMultimedia".equalsIgnoreCase(className)) {
      return new TypeToken<DocMultimedia>(){}.getType();
    }
    
    if ("InlineResponse200".equalsIgnoreCase(className)) {
      return new TypeToken<InlineResponse200>(){}.getType();
    }
    
    if ("InlineResponse200Response".equalsIgnoreCase(className)) {
      return new TypeToken<InlineResponse200Response>(){}.getType();
    }
    
    if ("InlineResponse200ResponseMeta".equalsIgnoreCase(className)) {
      return new TypeToken<InlineResponse200ResponseMeta>(){}.getType();
    }
    
    return new TypeToken<Object>(){}.getType();
  }

};
