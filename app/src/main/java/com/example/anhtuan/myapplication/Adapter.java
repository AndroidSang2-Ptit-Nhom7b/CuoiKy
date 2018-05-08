package com.example.anhtuan.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.anhtuan.myapplication.model.CongViec;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private Context context;
    private OnLongClickItem onLongClickItem;
    private List<CongViec> congViecList;

    public Adapter(Context context, List<CongViec> congViecList) {
        this.context = context;
        this.congViecList = congViecList;
    }

    public void setOnLongClickItem(OnLongClickItem onLongClickItem) {
        this.onLongClickItem = onLongClickItem;
    }

    public List<CongViec> getCongViecList() {
        return congViecList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_congviec, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final CongViec congViec = congViecList.get(position);
        holder.tvTenCV.setText(congViec.getTenCV());
        holder.tvTimeBD.setText(congViec.getNgayBD() + "/" + congViec.getThangBD() + "/" + congViec.getNamBD());
        holder.tvTimeKT.setText(congViec.getNgayKT() + "/" + congViec.getThangKT() + "/" + congViec.getNamKT());
        holder.clItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Sửa 1 phần từ danh sách
                context.startActivity(new Intent(context, ThemCongViec.class));
            }
        });
        holder.clItem.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // Truyền vị trí qua màn hình chính
                onLongClickItem.onClickLongItemListener(position);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return congViecList != null ? congViecList.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTenCV;
        TextView tvTimeBD;
        TextView tvTimeKT;
        ConstraintLayout clItem;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTenCV = itemView.findViewById(R.id.tvTenCV);
            tvTimeBD = itemView.findViewById(R.id.tvTimeBD);
            tvTimeKT = itemView.findViewById(R.id.tvTimeKT);
            clItem = itemView.findViewById(R.id.clItem);
        }
    }
}
