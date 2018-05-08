package com.example.anhtuan.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anhtuan.myapplication.Adapter;
import com.example.anhtuan.myapplication.OnLongClickItem;
import com.example.anhtuan.myapplication.R;
import com.example.anhtuan.myapplication.model.CongViec;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Todolist_fragment extends Fragment {

    @BindView(R.id.rcDSCongViec)
    RecyclerView recyclerView;
    List<CongViec> congViecList;
    Adapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_todolist, container, false);
        ButterKnife.bind(this, view);
        //Đọc dử liệu từ database sql -> set list vào adapter show danh sách.
        congViecList = new ArrayList<>();
        CongViec cv1 = new CongViec("asd", 12, 123, 123, 123, 123, 123);
        CongViec cv2 = new CongViec("asasdsadd", 12, 123, 123, 123, 123, 123);
        CongViec cv3 = new CongViec("aasdasdasdssd", 12, 123, 123, 123, 123, 123);
        adapter = new Adapter(getActivity(), congViecList);
        Bundle bundle = getActivity().getIntent().getExtras();
        congViecList.add(cv1);
        congViecList.add(cv2);
        congViecList.add(cv3);
        if (bundle != null) {
            CongViec cv = (CongViec) bundle.getSerializable("CV");
            congViecList.add(cv);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        adapter.setOnLongClickItem(new OnLongClickItem() {
            @Override
            public void onClickLongItemListener(int position) {
                //Xóa 1 phần tử danh sách
                congViecList.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
        return view;
    }

}
