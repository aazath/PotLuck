package lk.ubt.potluck.ui.adapters;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import lk.ubt.potluck.ui.order.AllOrdersFragment;

public class OrderPageAdapater extends FragmentStateAdapter {
    public OrderPageAdapater(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return new AllOrdersFragment();
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
