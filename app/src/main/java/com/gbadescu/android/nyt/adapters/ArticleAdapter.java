package com.gbadescu.android.nyt.adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gbadescu.android.nyt.R;
import com.gbadescu.android.nyt.model.Doc;

import com.gbadescu.android.nyt.model.DocMultimedia;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Iterator;

public class ArticleAdapter extends ArrayAdapter<Doc> {
    // View lookup cache
    private static class ViewHolder {
        public ImageView ivThumbnail;
        public TextView tvTitle;
    }

    public ArticleAdapter(Context context, ArrayList<Doc> aArticles) {
        super(context, 0, aArticles);
    }

    // Translates a particular `Article` given a position
    // into a relevant row within an AdapterView
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final Doc doc = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_article, parent, false);
            viewHolder.ivThumbnail = (ImageView)convertView.findViewById(R.id.ivArticleThumbnail);
            viewHolder.tvTitle = (TextView)convertView.findViewById(R.id.tvTitle);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // Populate data into the template view using the data object
        viewHolder.tvTitle.setText(doc.getHeadline().getMain().toString());
        //viewHolder.tvAuthor.setText(doc.getByline().getPerson().toString());

        Iterator it = doc.getMultimedia().listIterator();
        String imageURL="";

        while (it.hasNext())
        {
            DocMultimedia multimedia = (DocMultimedia) it.next();

            if (multimedia.getSubtype().compareTo("thumbnail") == 0)
            {
                imageURL = "http://nytimes.com/"+multimedia.getUrl().toString();
            }
        }

        //Picasso.with(getContext()).load(Uri.parse(imageURL)).into(viewHolder.ivThumbnail);
        Glide.with(getContext().getApplicationContext())
                .load(Uri.parse(imageURL))
                .into(viewHolder.ivThumbnail);
        // Return the completed view to render on screen
        return convertView;
    }
}
