package nl.hhs.werkbon.werkbon;

import android.app.Activity;
import android.content.Context;
import android.support.v7.internal.view.menu.MenuView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filterable;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Filter;

import java.util.ArrayList;

import nl.hhs.werkbon.werkbon.Models.WorkOrder;

import static android.text.method.TextKeyListener.clear;

/**
 * Created by jeroner on 10/01/15.
 */
public class WorkOrderAdapter extends BaseAdapter implements Filterable {
    private LayoutInflater mInflater;
    private ArrayList<WorkOrder> items;
    private ArrayList<WorkOrder> filtered;
    private Filter filter;

    public WorkOrderAdapter(Context context, ArrayList<WorkOrder> items) {
        mInflater = LayoutInflater.from(context);
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder holder;
        if(convertView == null) {
            view = mInflater.inflate(R.layout.row_layout, parent, false);
            holder = new ViewHolder();
            holder.name = (TextView)view.findViewById(R.id.name);
            holder.address = (TextView)view.findViewById(R.id.address);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder)view.getTag();
        }

        WorkOrder w = items.get(position);
        holder.name.setText(w.getCustomer().getInitials() + " " + w.getCustomer().getLastName());
        holder.address.setText(w.getCustomer().getAddress() + " " + w.getCustomer().getHouseNumber() + " " + w.getCustomer().getZipcode() + " " + w.getCustomer().getCity());

        return view;
    }

    private class ViewHolder {
        public TextView name, address;
    }

    @Override
    public Filter getFilter() {
        if (filter == null)
            filter = new AppFilter<WorkOrder>(items);
        return filter;
    }

    /**
     * Class for filtering in Arraylist listview. Objects need a valid
     * 'toString()' method.
     *
     * @author Tobias Schürg inspired by Alxandr
     *         (http://stackoverflow.com/a/2726348/570168)
     *
     */
    private class AppFilter<T> extends Filter {

        private ArrayList<T> sourceObjects;

        public AppFilter(ArrayList<T> objects) {
            sourceObjects = new ArrayList<T>();
            synchronized (this) {
                sourceObjects.addAll(objects);
            }
        }

        @Override
        protected FilterResults performFiltering(CharSequence chars) {
            String filterSeq = chars.toString().toLowerCase();
            FilterResults result = new FilterResults();
            if (filterSeq != null && filterSeq.length() > 0) {
                ArrayList<T> filter = new ArrayList<T>();

                for (T object : sourceObjects) {
                    // the filtering itself:
                    WorkOrder workOrder = (WorkOrder) object;
                    if (workOrder.toStringForFilter().toLowerCase().contains(filterSeq))
                        filter.add(object);

                    System.out.println(object.toString());
                }
                result.count = filter.size();
                result.values = filter;

                System.out.println(result.count);
                System.out.println(result.values);


            } else {
                // add all objects
                synchronized (this) {
                    result.values = sourceObjects;
                    result.count = sourceObjects.size();
                }
            }
            return result;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            // NOTE: this function is *always* called from the UI thread.
            items = (ArrayList<WorkOrder>)results.values;
            notifyDataSetChanged();

        }
    }

}