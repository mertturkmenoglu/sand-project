package ce.yildiz.sand.mainScreen;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ce.yildiz.sand.AppActivity;
import ce.yildiz.sand.databaseUtils.ItemContract;
import ce.yildiz.sand.R;

@SuppressWarnings("WeakerAccess")
public class PopularityAdapter extends RecyclerView.Adapter<PopularityAdapter.ItemViewHolder> {
    private Context mContext;
    private Cursor mCursor;

    public PopularityAdapter(Context context, Cursor cursor) {
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

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.popularity_list_item, viewGroup, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, final int i) {
        if (!mCursor.moveToPosition(i)) {
            return;
        }

        final String name = mCursor.getString(mCursor.getColumnIndex(ItemContract.ItemEntry.COLUMN_NAME));
        final long id = mCursor.getLong(mCursor.getColumnIndex(ItemContract.ItemEntry._ID));

        itemViewHolder.nameText.setText(name);
        itemViewHolder.popularityText.setText(String.valueOf(i + 1));
        itemViewHolder.itemView.setTag(id);

        itemViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, AppActivity.class);
                intent.putExtra("appID", id);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }

    @SuppressWarnings("unused")
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
