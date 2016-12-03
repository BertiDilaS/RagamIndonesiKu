package id.sch.smktelkom_mlg.project.xiirpl409192939.ragamindonesiaku.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xiirpl409192939.ragamindonesiaku.R;
import id.sch.smktelkom_mlg.project.xiirpl409192939.ragamindonesiaku.model.Provinsi;

/**
 * Created by NanaShin on 17/11/2016.
 */

public class ProvinsiAdapter extends RecyclerView.Adapter<ProvinsiAdapter.ViewHolder>
{

    IProvinsiAdapter mIProvinsiAdapter;
    ArrayList<Provinsi> provinsiList;

    public ProvinsiAdapter(Context context, ArrayList<Provinsi> provinsiList)
    {
        this.provinsiList = provinsiList;
        mIProvinsiAdapter = (IProvinsiAdapter) context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Provinsi provinsi = provinsiList.get(position);
        /*holder.tvJudul.setText(provinsi.judul);*/
        holder.tvDeskripsi.setText(provinsi.deskripsi);
        holder.ivFoto.setImageURI(Uri.parse(provinsi.foto));
    }

    @Override
    public int getItemCount()
    {
        if (provinsiList!=null)
            return provinsiList.size();
        return 0;
    }

    public interface IProvinsiAdapter {
        void doClick(int pos);
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView ivFoto;
        /*TextView tvJudul;*/
        TextView tvDeskripsi;

        public ViewHolder(View itemView) {
            super(itemView);
            ivFoto = (ImageView) itemView.findViewById(R.id.imageView);
            /*tvJudul = (TextView) itemView.findViewById(R.id.textViewJudul);*/
            tvDeskripsi = (TextView) itemView.findViewById(R.id.textViewDeskripsi);

            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    mIProvinsiAdapter.doClick(getAdapterPosition());
                }
            });
        }
    }
}
