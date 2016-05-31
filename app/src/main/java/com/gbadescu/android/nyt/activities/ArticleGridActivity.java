package com.gbadescu.android.nyt.activities;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.gbadescu.android.nyt.R;
import com.gbadescu.android.nyt.adapters.ArticleAdapter;
import com.gbadescu.android.nyt.api.StoriesApi;
import com.gbadescu.android.nyt.model.Doc;
import com.gbadescu.android.nyt.model.InlineResponse200;
import com.gbadescu.android.nyt.utilities.EndlessScrollListener;
import com.gbadescu.android.nyt.utilities.NetworkStateReceiver;

import org.parceler.Parcels;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;


public class ArticleGridActivity extends AppCompatActivity implements NetworkStateReceiver.NetworkStateReceiverListener {
    private GridView gvArticles;
    private ArticleAdapter articleAdapter;
    ArrayList<Doc> aArticles;
    MenuItem miActionProgressItem;
    String sharedQuery;
    private NetworkStateReceiver networkStateReceiver;
    Menu optionsMenu = null;
    SwipeRefreshLayout swipeContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_grid);
        // Find the toolbar view inside the activity layout

        swipeContainer = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);
        // Setup refresh listener which triggers new data loading
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Your code to refresh the list here.
                // Make sure you call swipeContainer.setRefreshing(false)
                // once the network request has completed successfully.
                articleAdapter.clear();

                fetchArticles(null,0,false);
            }
        });
        gvArticles = (GridView) findViewById(R.id.gvArticles);
        aArticles = new ArrayList<>();
        // initialize the adapter
        articleAdapter = new ArticleAdapter(this, aArticles);
        // attach the adapter to the ListView
        gvArticles.setAdapter(articleAdapter);

        networkStateReceiver = new NetworkStateReceiver();
        networkStateReceiver.addListener(this);
        this.registerReceiver(networkStateReceiver, new IntentFilter(android.net.ConnectivityManager.CONNECTIVITY_ACTION));

        if(isNetworkAvailable())
        {
            fetchArticles("",0,true);
        }
        else
        {
            connectivityMessage("Check Network Connection.");
        }



        gvArticles.setOnScrollListener(new EndlessScrollListener(5,1) {
            @Override
            public boolean onLoadMore(int page, int totalItemsCount) {
                // Triggered only when new data needs to be appended to the list
                // Add whatever code is needed to append new items to your AdapterView
                if (isNetworkAvailable()) {
                    fetchArticles(sharedQuery, page, true);
                    return true; // ONLY if more data is actually being loaded; false otherwise.
                }
                else
                {
                    return false;
                }
            }
        });

        setupListViewListener();
    }



    private boolean setupListViewListener()
    {

        gvArticles.setOnItemClickListener(

                new AdapterView.OnItemClickListener() {

                    public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {

                        Intent detailIntent = new Intent(ArticleGridActivity.this,ArticleDetailActivity.class);

                        detailIntent.putExtra("article", Parcels.wrap(aArticles.get(pos)));
                        startActivity(detailIntent);

                        startActivityForResult(detailIntent,200);

                    }
                }
        );

        return true;
    }

    // Executes an API call to the OpenLibrary search endpoint, parses the results
    // Converts them into an array of book objects and adds them to the adapter
    private void fetchArticles(final String query, int page, final boolean loadMore) {
        String fq = null;

        StoriesApi api = new StoriesApi();

        //SharedPreferences mSettings = this.getSharedPreferences("Settings", 0);

        SharedPreferences mSettings = PreferenceManager.getDefaultSharedPreferences(this);

        String beginDate =  mSettings.getString("begin_date",null);

        String sortOrder = mSettings.getString("sort_order",null);

        HashSet<String> filterQuery =  (HashSet) mSettings.getStringSet("filter_query",null);



        if(!filterQuery.isEmpty())
        {
           fq = filterQuery.toString();

           fq = fq.replace("[","(");

            fq = fq.replace("]",")");
        }


        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat targetFormat = new SimpleDateFormat("yyyyMMdd");

        try {
            Date bDate = originalFormat.parse(beginDate);

            beginDate = targetFormat.format(bDate).toString();
        }
        catch(ParseException e)
        {
            beginDate = null;
        }

        api.articlesearchJsonGet(query, fq, beginDate, null, sortOrder, null, null, page, null, null, new Response.Listener<InlineResponse200>() {
            @Override
            public void onResponse(InlineResponse200 response) {
                List<Doc> docs = response.getResponse().getDocs();

                if (!loadMore)
                {
                    articleAdapter.clear();
                }

                // Load model objects into the adapter
                for (Doc article : docs) {
                    articleAdapter.add(article); // add article through the adapter
                }

                swipeContainer.setRefreshing(false);

                articleAdapter.notifyDataSetChanged();

                hideProgressBar();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.toString();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        optionsMenu = menu;

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_article_grid, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);

        if (!isNetworkAvailable())
        {
            searchItem.setVisible(false);
        }

        // Store instance of the menu item containing progress
        miActionProgressItem = menu.findItem(R.id.miActionProgress);
        // Extract the action-view from the menu item
        final ProgressBar v =  (ProgressBar) MenuItemCompat.getActionView(miActionProgressItem);

        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // perform query here

                showProgressBar();

                fetchArticles(query,0,false);

                sharedQuery = query;

                // workaround to avoid issues with some emulators and keyboard devices firing twice if a keyboard enter is used
                // see https://code.google.com/p/android/issues/detail?id=24599
                searchView.clearFocus();

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent settingsIntent = new Intent(ArticleGridActivity.this, SettingsActivity.class);
            ArticleGridActivity.this.startActivity(settingsIntent);
            return false;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showProgressBar() {
        // Show progress item
        miActionProgressItem.setVisible(true);
    }

    public void hideProgressBar() {
        // Hide progress item
        miActionProgressItem.setVisible(false);
    }

    public void networkAvailable() {
        if (optionsMenu != null) {
            MenuItem searchItem = optionsMenu.findItem(R.id.action_search);
            searchItem.setVisible(true);
        }
    }

    @Override
    public void networkUnavailable() {
        if (optionsMenu != null) {
            MenuItem searchItem = optionsMenu.findItem(R.id.action_search);
            searchItem.setVisible(false);
        }
    }

    private Boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting());
    }

    private boolean isOnline() {
        Runtime runtime = Runtime.getRuntime();
        try {
            Process ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8");
            int     exitValue = ipProcess.waitFor();
            return (exitValue == 0);
        } catch (IOException e)          { e.printStackTrace(); }
        catch (InterruptedException e) { e.printStackTrace(); }
        return false;
    }

    public void connectivityMessage(String msg){
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, "", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setText(msg);
        toast.show();
    }
}
