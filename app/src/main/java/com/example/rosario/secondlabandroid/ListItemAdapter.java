package com.example.rosario.secondlabandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Rosario on 21/11/2014.
 */
public class ListItemAdapter extends BaseAdapter {

    static class Holder{
        ImageView image;
        TextView name;
        TextView area;
    }

    private Context myContext;
    private ArrayList<ListItem> myArrayList;
    private LayoutInflater myLayoutInflater;

    public ListItemAdapter(Context context, ArrayList<ListItem> arrayList){
        this.myContext = context;
        this.myArrayList = arrayList;
        this.myLayoutInflater = LayoutInflater.from(context);

    }


    @Override
    public int getCount() {
        return this.myArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.myArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder ;
        View view = convertView;
        //Checar si la vista es nula, si es asi crear una nueva
        if (view == null){
            holder = new Holder();
            System.out.println("la vista es nula");
            view  = this.myLayoutInflater.inflate(R.layout.list_item,null);
            holder.image = (ImageView) view.findViewById(R.id.image);
            holder.name = (TextView) view.findViewById(R.id.enterpriseName);
            holder.area = (TextView) view.findViewById(R.id.enterpriseArea);
            view.setTag(holder);
        }else{
            System.out.println("la vista EXISTE");
            holder =(Holder)view.getTag();
        }
        holder.image.setImageDrawable(this.myArrayList.get(position).getImage());
        String name  = this.myArrayList.get(position).getName();
        System.out.println("El nombre en este array list es " + name);
        holder.name.setText(name);
        holder.area.setText(this.myArrayList.get(position).getArea());

        return view;
    }
}
