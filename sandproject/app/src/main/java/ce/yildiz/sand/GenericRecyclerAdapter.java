package ce.yildiz.sand;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class GenericRecyclerAdapter extends RecyclerView.Adapter<GenericRecyclerAdapter.ItemViewHolder> {
    private Context mContext;
    private Cursor mCursor;

    public GenericRecyclerAdapter(Context context, Cursor cursor) {
        this.mContext = context;
        this.mCursor = cursor;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        public TextView nameText;
        public TextView popularityText;
        public ItemViewHolder(View itemView) {
            super(itemView);
            nameText = itemView.findViewById(R.id.appName);
            popularityText = itemView.findViewById(R.id.appPopularity);
        }
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.popularity_list_item, viewGroup, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder( ItemViewHolder itemViewHolder, final int i) {
        if (!mCursor.moveToPosition(i)) {
            return;
        }

        String name = mCursor.getString(mCursor.getColumnIndex(ItemContract.ItemEntry.COLUMN_NAME));
        long id = mCursor.getLong(mCursor.getColumnIndex(ItemContract.ItemEntry._ID));

        itemViewHolder.nameText.setText(name);
        itemViewHolder.popularityText.setText(String.valueOf(i + 1));
        itemViewHolder.itemView.setTag(id);

        // TODO: Update this method later
        itemViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Clicked to " + i + "-th item", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }

    public void swapCursor(Cursor newCursor) {
        if (mCursor != null) {
            mCursor.close();
        }

        mCursor = newCursor;

        if (newCursor != null) {
            notifyDataSetChanged();
        }
    }

}
