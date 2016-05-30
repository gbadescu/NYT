package com.gbadescu.android.nyt;

/**
 * Created by gbadesc on 5/28/16.
 */

       import com.gbadescu.android.nyt.model.DocByline;


       import com.gbadescu.android.nyt.model.DocMultimedia;
       import com.gbadescu.android.nyt.model.Person;
       import com.google.gson.JsonArray;
        import com.google.gson.JsonDeserializationContext;
        import com.google.gson.JsonDeserializer;
        import com.google.gson.JsonElement;
       import com.google.gson.JsonObject;
       import com.google.gson.JsonParseException;

        import android.text.TextUtils;

        import java.lang.reflect.Type;
        import java.util.ArrayList;
        import java.util.List;

/**
 * Created by rhu on 12/17/15.
 */
public class ByLineDeserializer implements JsonDeserializer<DocByline> {

    @Override
    public DocByline deserialize(JsonElement json, Type typeOfT,
                                        JsonDeserializationContext context) throws JsonParseException {

        if (json.isJsonArray()) {
            return new DocByline();
        } else {
            return new DocByline();
        }

    }
}
