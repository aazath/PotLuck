package lk.ubt.potluck.ui.order;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import lk.ubt.potluck.R;
import lk.ubt.potluck.ui.adapters.OrdersAdapter;
import lk.ubt.potluck.ui.entity.Order;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CompletedOrderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CompletedOrderFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CompletedOrderFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CompletedOrderFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CompletedOrderFragment newInstance(String param1, String param2) {
        CompletedOrderFragment fragment = new CompletedOrderFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    RecyclerView rvAllOrders;
    OrdersAdapter ordersAdapter;
    List<Order> orderList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_orders, container, false);
        rvAllOrders = view.findViewById(R.id.rvAllOrders);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ordersAdapter = new OrdersAdapter();
        rvAllOrders.setLayoutManager(new LinearLayoutManager(getContext()));

        rvAllOrders.setAdapter(ordersAdapter);
        orderList = new ArrayList<>();

        Order order = new Order();
        order.setId(1);
        order.setOrderID("ORD-20220130");
        order.setDate("2022-01-30 19:20:47");
        order.setAmount(3000.00);
        orderList.add(order);
        ordersAdapter.setOrderList(orderList);
        ordersAdapter.notifyDataSetChanged();
    }
}