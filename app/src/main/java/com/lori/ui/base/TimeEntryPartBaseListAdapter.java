package com.lori.ui.base;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.balysv.materialripple.MaterialRippleLayout;
import com.lori.R;
import com.lori.core.entity.BaseEntity;
import com.lori.ui.dialog.EditTimeEntryDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * @author artemik
 */
public abstract class TimeEntryPartBaseListAdapter<T extends BaseEntity> extends RecyclerView.Adapter<TimeEntryPartBaseListAdapter.ViewHolder> {

    private static final int RADIUS_ENOUGH_TO_COVER_TIME_ENTRY_ITEM = 500;

    private final List<T> items = new ArrayList<>();
    protected EditTimeEntryDialog dialog;
    private int selectedIndex = 0;

    public TimeEntryPartBaseListAdapter(EditTimeEntryDialog dialog) {
        this.dialog = dialog;
    }

    public void setItems(List<T> newItems) {
        if (newItems == null || newItems.isEmpty()) {
            return;
        }

        selectedIndex = 0;

        items.clear();
        items.addAll(newItems);

        notifyDataSetChanged();
    }

    public void select(T itemToSelect) {
        if (itemToSelect == null) {
            return;
        }

        for (int i = 0; i < items.size(); i++) {
            T item = items.get(i);

            if (item.getId().equals(itemToSelect.getId())) {
                int prevSelectedIndex = selectedIndex;
                selectedIndex = i;
                notifyItemChanged(prevSelectedIndex);
                notifyItemChanged(selectedIndex);
            }
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.time_entry_part_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        String text = toString(items.get(i));
        viewHolder.partNameTextView.setText(text);

        viewHolder.rippleView.setRadius(i == selectedIndex ? RADIUS_ENOUGH_TO_COVER_TIME_ENTRY_ITEM : 0);

        viewHolder.partNameTextView.setOnClickListener(v -> {
            int prevSelectedIndex = selectedIndex;
            selectedIndex = viewHolder.getAdapterPosition();
            notifyItemChanged(prevSelectedIndex);

            onItemClick(items.get(selectedIndex));
        });
    }

    protected abstract String toString(T item);

    protected abstract void onItemClick(T item);

    @Override
    public int getItemCount() {
        return (null != items ? items.size() : 0);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.rippleView)
        MaterialRippleLayout rippleView;

        @BindView(R.id.partNameTextView)
        TextView partNameTextView;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
