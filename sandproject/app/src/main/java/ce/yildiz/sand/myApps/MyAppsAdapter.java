package ce.yildiz.sand.myApps;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import ce.yildiz.sand.R;
import ce.yildiz.sand.databaseUtils.ItemContract;

public class MyAppsAdapter extends RecyclerView.Adapter<MyAppsAdapter.ItemViewHolder> {

    private Context mContext;
    private Cursor mCursor;

    public MyAppsAdapter(Context context, Cursor cursor) {
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

    public MyAppsAdapter.ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.basic_list_item, viewGroup, false);
        return new MyAppsAdapter.ItemViewHolder(view);
    }

    public void onBindViewHolder(MyAppsAdapter.ItemViewHolder itemViewHolder, final int i) {
        if (!mCursor.moveToPosition(i)) {
            return;
        }

        final String name = mCursor.getString(mCursor.getColumnIndex(ItemContract.ItemEntry.COLUMN_NAME));
        final long id = mCursor.getLong(mCursor.getColumnIndex(ItemContract.ItemEntry._ID));

        itemViewHolder.nameText.setText(name);
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
