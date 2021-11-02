package com.groupec.recyclerviewcheckbox;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class CheckBoxAdapter extends RecyclerView.Adapter<CheckBoxAdapter.ViewHolder> {

    public static ArrayList<Model> modelArrayList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        protected CheckBox checkBox;
        private TextView tvAnimal;
        public View divider;

        public ViewHolder(View view) {
            super(view);
            checkBox = (CheckBox) view.findViewById(R.id.cb);
            tvAnimal = view.findViewById(R.id.animal);
            divider = view.findViewById(R.id.divider);
        }
    }

    public CheckBoxAdapter(ArrayList<Model> modelArrayList) {
        this.modelArrayList = modelArrayList;
    }

    public Model getItem(int i) {
        return modelArrayList.get(i);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View listView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(listView);
        return holder;
    }

    @Override
    public synchronized void onBindViewHolder(final ViewHolder viewHolder, final int i) {
        final Model model = getItem(i);
        viewHolder.checkBox.setChecked(model.getSelected());
        viewHolder.tvAnimal.setText(model.getAnimal());
        viewHolder.checkBox.setTag(i);

        // When click on checkBox
        viewHolder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Integer pos = (Integer)  viewHolder.checkBox.getTag(); // Get CheckBox position

                /* Check and unCheck element */
                if(model.getSelected()){
                    model.setSelected(false);
                }else {
                    model.setSelected(true);
                }

            }
        });
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }
}