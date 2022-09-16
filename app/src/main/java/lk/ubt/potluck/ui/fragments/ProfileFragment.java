package lk.ubt.potluck.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import lk.ubt.potluck.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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

    Button btnProfileUpdate;
    TextInputEditText etName, etPhone, etEmail,etAddress;
    TextInputLayout tiName, tiPhone, tiEmail, tiAddress;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        btnProfileUpdate = view.findViewById(R.id.btnProfileUpdate);
        etName = view.findViewById(R.id.etName);
        etPhone = view.findViewById(R.id.etPhone);
        etEmail = view.findViewById(R.id.etEmail);
        etAddress = view.findViewById(R.id.etAddress);

        tiName = view.findViewById(R.id.tiName);
        tiPhone = view.findViewById(R.id.tiPhoneNo);
        tiEmail = view.findViewById(R.id.tiEmail);
        tiAddress = view.findViewById(R.id.tiAddress);

        btnProfileUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //update account details

                if (validateInputs(view)){
                    //sent a network call to update the details
                    Toast.makeText(getContext(), "Your details updated successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
    private boolean validateInputs(View view){
        boolean success = true;
        if (TextUtils.isEmpty(etName.getText().toString())){
            success = false;
            tiName.setError("Enter your name");
        }
        if (TextUtils.isEmpty(etAddress.getText().toString())){
            success = false;
            tiAddress.setError("Enter your address");
        }
        if (TextUtils.isEmpty(etEmail.getText().toString())){
            success = false;
            tiEmail.setError("Enter your email");
        }
        if (!checkEmail(etEmail.getText().toString())){
            success = false;
            tiEmail.setError("Enter valid email");
        }
        if (TextUtils.isEmpty(etPhone.getText().toString())){
            success = false;
            tiPhone.setError("Enter your phone number");
        }
        return success;
    }

    private boolean checkEmail(String toString) {
        return true;
    }
}