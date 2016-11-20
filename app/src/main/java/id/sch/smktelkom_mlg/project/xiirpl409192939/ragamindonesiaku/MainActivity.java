package id.sch.smktelkom_mlg.project.xiirpl409192939.ragamindonesiaku;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xiirpl409192939.ragamindonesiaku.adapter.ProvinsiAdapter;
import id.sch.smktelkom_mlg.project.xiirpl409192939.ragamindonesiaku.model.Provinsi;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.bSTART).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });
    }
}

