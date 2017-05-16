package pe.cibertec.fragmentsdemo;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter
        extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    private List<Contact> contacts;
    private OnItemClickListener listener;
    private int selectedItem = 0;
    //static int row_index;

    public ContactAdapter(@NonNull List<Contact> contacts,
                          OnItemClickListener listener) {
        this.contacts = contacts;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_item, parent, false);
        return new ViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.bind(contacts.get(position),position);

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtInitial, txtName;
        OnItemClickListener listener;
        LinearLayout ctndrLinearLayout;

        public ViewHolder(View itemView, OnItemClickListener listener) {
            super(itemView);
            txtInitial = (TextView) itemView.findViewById(R.id.txtInitial);
            txtName = (TextView) itemView.findViewById(R.id.txtName);
            ctndrLinearLayout = (LinearLayout) itemView.findViewById(R.id.contenedorLinear);
            this.listener = listener;
        }

        public void bind(final Contact contact,final int position) {

            txtInitial.setText(String.valueOf(contact.getName().charAt(0)));
            txtName.setText(contact.getName());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                         if (listener != null) {
                             listener.onItemClick(contact);
                             selectedItem = position;
                             notifyDataSetChanged();
                         }
                }
            });

            if(selectedItem==position){
                ctndrLinearLayout.setBackgroundColor(Color.parseColor("#567845"));

            }
            else
            {
                ctndrLinearLayout.setBackgroundColor(Color.parseColor("#ffffff"));

            }
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Contact contact);
    }
}
