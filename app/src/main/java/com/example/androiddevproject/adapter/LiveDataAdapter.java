package com.example.androiddevproject.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androiddevproject.R;
import com.example.androiddevproject.model.LiveData;

import java.util.ArrayList;
import java.util.List;

public class LiveDataAdapter<C> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<LiveData> liveData;
    private LayoutInflater layoutInflater;
    private C appOperationAware;

    public LiveDataAdapter(ArrayList<LiveData> liveData, C appOperationAware) {
        this.liveData = liveData;
        this.appOperationAware = appOperationAware;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.layoutemail_addres, parent, false);
        return new LiveViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int viewType = holder.getItemViewType();
        LiveData liveDatal = liveData.get(position);
        LiveViewHolder liveViewHolder = (LiveViewHolder) holder;

        TextView txtEmail = liveViewHolder.getTxtEmail();
        txtEmail.setText(liveDatal.getName());

        TextView txtAddress = liveViewHolder.getTxtAddress();
        txtAddress.setText(liveDatal.getAddress());

    }


    public List<LiveData> getItems() {
        return liveData;
    }


    @Override
    public int getItemCount() {
        return liveData.size();
    }


    private static class LiveViewHolder extends RecyclerView.ViewHolder {

        private TextView txtEmail;
        private TextView txtAddress;


        private LiveViewHolder(@NonNull View itemView) {
            super(itemView);
        }


        public TextView getTxtEmail() {
            if (txtEmail == null) {
                txtEmail = itemView.findViewById(R.id.txtEmail);
            }
            return txtEmail;
        }

        public TextView getTxtAddress() {
            if (txtAddress == null) {
                txtAddress = itemView.findViewById(R.id.txtAddress);
            }
            return txtAddress;
        }


    }

}
