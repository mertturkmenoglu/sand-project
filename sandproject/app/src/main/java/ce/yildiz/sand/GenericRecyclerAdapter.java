package ce.yildiz.sand;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class GenericRecyclerAdapter extends RecyclerView.Adapter<GenericRecyclerAdapter.GenericViewHolder> {

    private static final String TAG = GenericRecyclerAdapter.class.getSimpleName();

    private int mNumberOfItems;

    public GenericRecyclerAdapter(int numberOfItems) {
        this.mNumberOfItems = numberOfItems;
    }

    @Override
    public GenericViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.rv_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        GenericViewHolder viewHolder = new GenericViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(GenericViewHolder holder, int position) {
        Log.d(TAG, "#" + position);
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mNumberOfItems;
    }


    class GenericViewHolder extends RecyclerView.ViewHolder {

        TextView listItemNumberView;

        public GenericViewHolder(View itemView) {
            super(itemView);

            listItemNumberView = (TextView) itemView.findViewById(R.id.item_text_view);
        }

        void bind(int listIndex) {
            listItemNumberView.setText(String.valueOf(listIndex + 1));
        }
    }

}
