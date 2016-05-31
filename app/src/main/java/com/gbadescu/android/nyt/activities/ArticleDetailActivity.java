package com.gbadescu.android.nyt.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.gbadescu.android.nyt.R;
import com.gbadescu.android.nyt.model.Doc;

import org.parceler.Parcels;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ArticleDetailActivity extends AppCompatActivity {
    private WebView myWebView;

    private Intent shareIntent;
    private ShareActionProvider miShareAction;
    Doc article;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // ...
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);
        // Fetch views
        myWebView = (WebView) findViewById(R.id.webview);
        // Configure related browser settings
        myWebView.getSettings().setLoadsImagesAutomatically(true);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        // Configure the client to use when opening URLs
        myWebView.setWebViewClient(new MyBrowser());

        // Enable responsive layout
        myWebView.getSettings().setUseWideViewPort(true);
// Zoom out if the content width is greater than the width of the veiwport
        myWebView.getSettings().setLoadWithOverviewMode(true);
        // Load the initial URL

        article = (Doc) Parcels.unwrap(getIntent().getParcelableExtra("article"));

        myWebView.loadUrl(article.getWebUrl());

    }

    // Manages the behavior when URLs are loaded
    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            prepareShareIntent();
            attachShareIntentAction();
            return true;
        }
    }


    // Gets the image URI and setup the associated share intent to hook into the provider
    public void prepareShareIntent() {
        shareIntent = new Intent(android.content.Intent.ACTION_SEND);
        shareIntent.setType("text/plain");

        // Add data to the intent, the receiving app will decide
        // what to do with it.
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, article.getHeadline().toString());
        shareIntent.putExtra(Intent.EXTRA_TEXT, article.getWebUrl());

        //startActivity(Intent.createChooser(share, "Share using"));
    }

    // Attaches the share intent to the share menu item provider
    public void attachShareIntentAction() {
        if (miShareAction != null && shareIntent != null)
            miShareAction.setShareIntent(shareIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate menu resource file.
        getMenuInflater().inflate(R.menu.menu_article_detail, menu);
        // Locate MenuItem with ShareActionProvider
        MenuItem item = menu.findItem(R.id.menu_item_share);
        // Fetch reference to the share action provider
        miShareAction = (ShareActionProvider) MenuItemCompat.getActionProvider(item);

        //attachShareIntentAction(); // call here in case this method fires second
        // Return true to display menu
        return true;
    }
}
