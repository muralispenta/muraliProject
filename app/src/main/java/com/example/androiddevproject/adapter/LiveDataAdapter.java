package com.example.androiddevproject.adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androiddevproject.R;
import com.example.androiddevproject.UserDetails;
import com.example.androiddevproject.activty.HomeActivity;
import com.example.androiddevproject.fragments.UserProfileFragment;
import com.example.androiddevproject.model.LiveData;
import com.example.androiddevproject.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class LiveDataAdapter<C> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<LiveData> liveData;
    private LayoutInflater layoutInflater;
    private C appOperationAware;
    private UserDetailsOnClickLister userDetailsOnClickLister;

    public LiveDataAdapter(ArrayList<LiveData> liveData, Activity activity) {
        this.liveData = liveData;

        layoutInflater = (LayoutInflater) activity.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        this.appOperationAware = appOperationAware;
        this.userDetailsOnClickLister = new UserDetailsOnClickLister ();

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

        LinearLayout linearLayout = liveViewHolder.getLinearLayout();
        linearLayout.setOnClickListener(userDetailsOnClickLister);
        linearLayout.setTag(R.id.data,liveDatal);
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
        private LinearLayout linearLayout;


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

        private LinearLayout getLinearLayout(){
            if (linearLayout == null){
                linearLayout = itemView.findViewById(R.id.linearLayout);
            }
            return linearLayout;
        }

    }

    private class  UserDetailsOnClickLister implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            LiveData liveData = (LiveData) v.getTag(R.id.data);

            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            UserProfileFragment fragment2 = new UserProfileFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(Constants.DATA,liveData);
            fragment2.setArguments(bundle);
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame,
                    fragment2).addToBackStack(null).commit();

        }
    }

}
