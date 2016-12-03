package id.sch.smktelkom_mlg.project.xiirpl409192939.ragamindonesiaku;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import id.sch.smktelkom_mlg.project.xiirpl409192939.ragamindonesiaku.model.Provinsi;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Provinsi provinsi = (Provinsi) getIntent().getSerializableExtra(Main2Activity.PROVINSI);
        setTitle(provinsi.judul);
        ImageView ivFoto = (ImageView) findViewById(R.id.imageFoto);
        ivFoto.setImageURI(Uri.parse(provinsi.foto));

        TextView tvDeskripsi = (TextView) findViewById(R.id.detail_provinsi);
        tvDeskripsi.setText(provinsi.deskripsi);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onBackPressed();
            }
        });
    }
}
