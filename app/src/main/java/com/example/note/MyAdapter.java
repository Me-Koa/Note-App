package com.example.note;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;

import io.realm.Realm;
import io.realm.RealmResults;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

Context context;
RealmResults<Note>notelist;

    public MyAdapter(Context context, RealmResults<Note> notelist) {
        this.context = context;
        this.notelist = notelist;
        this.titleOutput = titleOutput;
        this.descriptionoutput = descriptionoutput;
        this.timeoutput = timeoutput;
    }
    TextView titleOutput;
    TextView descriptionoutput;
    TextView timeoutput;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter. MyViewHolder holder, int position) {

        Note note=notelist.get(position);
        holder.titleOutput.setText(note.getTitle());
        holder.descriptionoutput.setText(note.getDescription());

        String formatedTime= DateFormat.getDateTimeInstance().format(note.createdTIme);
        holder.timeoutput.setText(formatedTime);
         //-----to delete the note----

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                PopupMenu menu=new PopupMenu(context,v);
                menu.getMenu().add("Delete") ;
                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        if(item.getTitle().equals("Delete")){
                            //--- delete---

                            Realm realm=Realm.getDefaultInstance();
                            realm.beginTransaction();
                            note.deleteFromRealm();
                            realm.commitTransaction();
                            Toast.makeText(context, "Note Deleted", Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    }
                });
            return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return notelist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{


        TextView titleOutput;
        TextView descriptionoutput;
        TextView timeoutput;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            titleOutput=itemView.findViewById(R.id.titleoutput);
            descriptionoutput=itemView.findViewById(R.id.descriptionoutput);
            timeoutput=itemView.findViewById(R.id.titleoutput);
        }
    }
}
