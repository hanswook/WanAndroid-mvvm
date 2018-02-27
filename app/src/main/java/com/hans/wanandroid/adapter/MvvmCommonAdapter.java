package com.hans.wanandroid.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by hans
 * date: 2018/1/15 10:49.
 * e-mail: hxxx1992@163.com
 */

public class MvvmCommonAdapter extends RecyclerView.Adapter<CommonHolder> {

    private Context mContext;
    private List data;
    private int mLayoutId;
    private LayoutInflater mInflater;
    private int mVariableId;

    public MvvmCommonAdapter(Context context, List data, int mLayoutId, int mVariableId) {
        this.mContext = context;
        this.data = data;
        this.mLayoutId = mLayoutId;
        this.mInflater=LayoutInflater.from(mContext);
        this.mVariableId = mVariableId;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    @Override
    public CommonHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(mInflater, mLayoutId, parent, false);
        CommonHolder holder = new CommonHolder(binding.getRoot());
        holder.setViewBinding(binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(CommonHolder holder, int position) {
        holder.getViewBinding().setVariable(mVariableId, data.get(position));
        holder.getViewBinding().executePendingBindings();

    }

    @Override
    public int getItemCount() {
        return null == data ? 0 : data.size();
    }
}
