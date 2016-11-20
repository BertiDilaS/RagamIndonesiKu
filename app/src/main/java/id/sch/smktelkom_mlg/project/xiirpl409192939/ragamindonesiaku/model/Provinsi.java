package id.sch.smktelkom_mlg.project.xiirpl409192939.ragamindonesiaku.model;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

/**
 * Created by NanaShin on 17/11/2016.
 */

public class Provinsi implements Serializable
{
    public String judul;
    public String deskripsi;
    public String foto;

    public Provinsi(String judul, String deskripsi, String foto)
    {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.foto = foto;
    }
}
