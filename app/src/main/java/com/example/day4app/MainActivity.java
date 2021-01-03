package com.example.day4app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.android.material.snackbar.Snackbar;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       final RelativeLayout rr = findViewById(R.id.Rawan);
        // for the toolbar
        Toolbar toolbar = findViewById(R.id.Toolbar1);
        //final LinearLayout ll = findViewById(R.id.LinearLayour);

        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("Home").withIcon(R.drawable.ic_baseline_home_24);
        PrimaryDrawerItem item2 = new PrimaryDrawerItem().withIdentifier(2).withName("Favorite").withIcon(R.drawable.ic_baseline_favorite_24);
        SecondaryDrawerItem item3 = new SecondaryDrawerItem().withIdentifier(3).withName("Settings");

        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .addDrawerItems(
                        item1,
                        item2,
                        new DividerDrawerItem(),
                        item3


                        // لعيون خالتي قماشه
                )
                .build();


//        DrawerBuilder result = new DrawerBuilder()
//                .withActivity(this)
//                .withToolbar(toolbarr)
//                .addDrawerItems(
//                        item1,
//                        item2,
//                        new DividerDrawerItem(),
//                        item3
//                ).withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
//                    @Override
//                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
//
//                        Snackbar.make(ll, "Hello", Snackbar.LENGTH_LONG).setAction("Undo", new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//
//                            }
//                        }).show();
//
//                        return false;
//                    }
//                });







       //
        ArrayList<TvShows> TvLibrary = new ArrayList<>();

        //
        TvShows bb = new TvShows("Breaking Bad", "5", "2008-2013", R.drawable.breakingbad, "62", "Crime");
        TvShows got = new TvShows("Game of Thrones", "8", "2011-2019", R.drawable.got, "60", "Action");
        TvShows bl = new TvShows("The Black List", "8", "2013-", R.drawable.blacklist, "155", "Crime");
        TvShows hof = new TvShows("House of Card", "6", "2013-2018", R.drawable.houseofcards, "73", "Drama");
        TvShows suit = new TvShows("Suits", "8", "2011-2019", R.drawable.suits, "144", "Drama");
        TvShows vik = new TvShows("Vikings", "6", "2013-", R.drawable.viking2, "59", "Action");
        TvShows ted = new TvShows("Ted Lasso", "3", "2020", R.drawable.tedlasso, "10", "Comedy");


        TvLibrary.add(bb);
        TvLibrary.add(got);
        TvLibrary.add(bl);
        TvLibrary.add(hof);
        TvLibrary.add(suit);
        TvLibrary.add(vik);
        TvLibrary.add(ted);


        RecyclerView TvList = findViewById(R.id.rv);
        // لترتيب القائمه  عشان ماتبوض الدنيا

        TvList.setHasFixedSize(true);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        TvList.setLayoutManager(lm);

        // نربط ال recycle view مع arraylist
        TvShowsAdapter tm = new TvShowsAdapter(TvLibrary, MainActivity.this,rr);
        TvList.setAdapter(tm);



//        Toolbar toolbar = findViewById(R.id.Toolbar1);
//        final LinearLayout ll = findViewById(R.id.LinearLayour);
//
//        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("Home").withIcon(R.drawable.ic_baseline_home_24);
//        PrimaryDrawerItem item2 = new PrimaryDrawerItem().withIdentifier(2).withName("Favorite").withIcon(R.drawable.ic_baseline_delete_24);
//        SecondaryDrawerItem item3 = new SecondaryDrawerItem().withIdentifier(3).withName("Settings");
//
//        DrawerBuilder result = new DrawerBuilder()
//                .withActivity(this)
//                .withToolbar(toolbar)
//                .addDrawerItems(
//                        item1,
//                        item2,
//                        new DividerDrawerItem(),
//                        item3
//                ).withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
//                    @Override
//                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
//
//                        Snackbar.make(ll, "Hello", Snackbar.LENGTH_LONG).setAction("Undo", new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//
//                            }
//                        }).show();
//
//                        return false;
//                    }
//                });


    }
}