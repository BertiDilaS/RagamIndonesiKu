package id.sch.smktelkom_mlg.project.xiirpl409192939.ragamindonesiaku;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xiirpl409192939.ragamindonesiaku.adapter.ProvinsiAdapter;
import id.sch.smktelkom_mlg.project.xiirpl409192939.ragamindonesiaku.model.Provinsi;
import id.sch.smktelkom_mlg.project.xiirpl409192939.ragamindonesiaku.model.about;

public class Main2Activity extends AppCompatActivity implements ProvinsiAdapter.IProvinsiAdapter
{

    public static final String PROVINSI = "provinsi";
    ArrayList<Provinsi> mList = new ArrayList<>();
    ProvinsiAdapter mAdapter;

    ArrayList<Provinsi> mListAll = new ArrayList<>();
    boolean isFiltered;
    ArrayList<Integer> mListMapFilter = new ArrayList<>();
    String mQuery;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("Ragam Indonesiaku");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new ProvinsiAdapter(this,mList);
        recyclerView.setAdapter(mAdapter);

        fillData();
    }

    private void fillData()
    {
        Resources resources = getResources();
        String[] arJudul = resources.getStringArray(R.array.provinsi);
        String[] arDeskripsi = resources.getStringArray(R.array.detail_provinsi);
        TypedArray a = resources.obtainTypedArray(R.array.places_picture);
        String[] arFoto = new String[a.length()];

        for (int i = 0; i < arFoto.length; i++) {

            int id = a.getResourceId(i,0);
            arFoto[i] = ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
                    + resources.getResourcePackageName(id) + '/'
                    + resources.getResourceTypeName(id) + '/'
                    + resources.getResourceEntryName(id);
        }
        a.recycle();

        for (int i = 0; i < arJudul.length; i++) {
            mList.add(new Provinsi(arJudul[i], arDeskripsi[i], arFoto[i]));
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mQuery = newText.toLowerCase();
                doFilter(mQuery);
                return true;
            }
        });
        return true;


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, about.class);
            startActivity(intent);
            return true;
        }

        if (id == R.id.action_search) {
            Toast.makeText(getApplicationContext(), "Search on process!", Toast.LENGTH_SHORT).show();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }


    private void doFilter(String query) {
        if (!isFiltered) {
            mListAll.clear();
            mListAll.addAll(mList);
            isFiltered = true;
        }

        mList.clear();
        if (query == null || query.isEmpty()) {
            mList.addAll(mListAll);
            isFiltered = false;
        } else {
            mListMapFilter.clear();
            for (int i = 0; i < mListAll.size(); i++) {
                Provinsi provinsi = mListAll.get(i);
                if (provinsi.judul.toLowerCase().contains(query) ||
                        provinsi.deskripsi.toLowerCase().contains(query)) {
                    mList.add(provinsi);
                    mListMapFilter.add(i);
                }
            }
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void doClick(int pos)
    {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(PROVINSI,mList.get(pos));
        startActivity(intent);
    }
}
