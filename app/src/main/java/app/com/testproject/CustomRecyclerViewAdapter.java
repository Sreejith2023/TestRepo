package app.com.testproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import app.com.testproject.databinding.ItemRowBinding;

public class CustomRecyclerViewAdapter extends  RecyclerView.Adapter<CustomRecyclerViewAdapter.CustomViewHolder> implements CustomClickListener{

    private List<DataModel> dataModelList;
    private Context context;

    public CustomRecyclerViewAdapter(List<DataModel> dataModelList, Context context) {
        this.dataModelList = dataModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRowBinding itemRowBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_row, parent, false);
        return new CustomViewHolder(itemRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        DataModel dataModel = dataModelList.get(position);
        holder.bind(dataModel);
        holder.itemRowBinding.setItemClickListener(this);
    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    @Override
    public void cardClicked(DataModel item) {
        Toast.makeText(context, "You Clicked" +item.androidName, Toast.LENGTH_SHORT).show();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{
        public ItemRowBinding itemRowBinding;
        public CustomViewHolder(ItemRowBinding itemRowBinding) {
            super(itemRowBinding.getRoot());
            this.itemRowBinding = itemRowBinding;
        }

        public void bind(Object object){
            itemRowBinding.setVariable(BR.model,object);
            itemRowBinding.executePendingBindings();

        }
    }
}


