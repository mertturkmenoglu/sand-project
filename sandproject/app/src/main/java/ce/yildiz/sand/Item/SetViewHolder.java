package ce.yildiz.sand.Item;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import ce.yildiz.sand.R;

public class SetViewHolder extends RecyclerView.ViewHolder {
    public TextView appNameTV;

    public SetViewHolder(@NonNull View itemView) {
        super(itemView);
        appNameTV = (TextView) itemView.findViewById(R.id.appName);

    }

}
