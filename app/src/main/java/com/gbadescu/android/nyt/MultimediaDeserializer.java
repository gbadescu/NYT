package com.gbadescu.android.nyt;



        import com.gbadescu.android.nyt.model.DocMultimedia;
        import com.google.gson.JsonArray;
        import com.google.gson.JsonDeserializationContext;
        import com.google.gson.JsonDeserializer;
        import com.google.gson.JsonElement;
        import com.google.gson.JsonParseException;

        import android.text.TextUtils;

        import java.lang.reflect.Type;
        import java.util.ArrayList;
        import java.util.List;

/**
 * Created by rhu on 12/17/15.
 */
public class MultimediaDeserializer implements JsonDeserializer<List<DocMultimedia>> {

    @Override
    public List<DocMultimedia> deserialize(JsonElement json, Type typeOfT,
                                        JsonDeserializationContext context) throws JsonParseException {

        ArrayList<DocMultimedia> multimedias = new ArrayList<>();

        String str = null;

        try {
            str = json.getAsString();
        } catch (IllegalStateException e) {

        }

        if (str != null && TextUtils.isEmpty(str)) {
            return multimedias;
        } else {
            JsonArray jsonArray = json.getAsJsonArray();
            for (int i = 0; i < jsonArray.size(); i++) {
                multimedias.add((DocMultimedia) context.deserialize(jsonArray.get(i), DocMultimedia.class));
            }
        }
        return multimedias;
    }
}
