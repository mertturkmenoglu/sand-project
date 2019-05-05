package ce.yildiz.sand;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class GenericRecyclerAdapter extends RecyclerView.Adapter<GenericRecyclerAdapter.ItemViewHolder> {
    private Context mContext;
    private Cursor mCursor;

    public GenericRecyclerAdapter(Context context, Cursor cursor) {
        this.mContext = context;
        this.mCursor = cursor;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        public TextView nameText;
        public ItemViewHolder(View itemView) {
            super(itemView);
            nameText = itemView.findViewById(R.id.appName);
        }
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.custom_list_item, viewGroup, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder( ItemViewHolder itemViewHolder, int i) {
        if (!mCursor.moveToPosition(i)) {
            return;
        }

        String name = mCursor.getString(mCursor.getColumnIndex(ItemContract.ItemEntry.COLUMN_NAME));

        itemViewHolder.nameText.setText(name);
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
