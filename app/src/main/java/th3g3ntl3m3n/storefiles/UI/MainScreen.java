package th3g3ntl3m3n.storefiles.UI;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import th3g3ntl3m3n.storefiles.ImageData.Constants;
import th3g3ntl3m3n.storefiles.R;

/**
 * Created by th3g3ntl3m3n on 31/8/17.
 */

public class MainScreen extends Fragment {

    private static final String TAG = MainScreen.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.main_screen, container, false);
        final Button button = view.findViewById(R.id.savePassword);

        final String[] password = new String[1];
        final EditText passwordField = view.findViewById(R.id.passwordText);
        final int[] i = {0};

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: " + Constants.isPasswordStored(getActivity()));
                InputMethodManager inputManager = (InputMethodManager)
                        getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);

                inputManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
                if(Constants.isPasswordStored(getActivity())) {
                    Log.d(TAG, "onClick: " + " Password is stored " + Constants.getPassword(getActivity()));
                    String userEnteredPassword  = passwordField.getText().toString();
                    String storedPassword       = Constants.getPassword(getActivity());
                    if(userEnteredPassword.equals(storedPassword)) {
                        Snackbar.make(view, "Matched", Snackbar.LENGTH_SHORT).show();
                        getActivity()
                                .getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragment_container, new SecureGallery())
                                .commit();
                    } else {
                        Snackbar.make(view, "Not Matched", Snackbar.LENGTH_SHORT).show();
                        passwordField.setText("");
                    }
                } else {
                    if(i[0] == 1) {
                        String p = passwordField.getText().toString();

                        if(p.equals(password[0])) {

                            Log.d(TAG, "onClick: " + "Password matched");
                            Snackbar.make(view, "Password Matched", Snackbar.LENGTH_SHORT).show();
                            Constants.storePassword(getActivity(), p);

                            getActivity()
                                    .getSupportFragmentManager()
                                    .beginTransaction()
                                    .replace(R.id.fragment_container, new SecureGallery())
                                    .commit();

                        } else {
                            Log.d(TAG, "onClick: "  +"Password wrong.. re-enter it");
                            Snackbar.make(view, "Password wrong", Snackbar.LENGTH_SHORT).show();
                            button.setText("Store it");
                            passwordField.setText("");
                            i[0] = 0;
                        }
                    } else {
                        password[0] = passwordField.getText().toString();
                        Log.d(TAG, "onClick: " +  password[0].length());
                        if( password[0].length() < 4 ||  password[0].length() > 10) {
                            Log.d(TAG, "onClick: " +  password[0].length());
                            passwordField.setText("");
                            Snackbar.make(view, "Password must have minimum 4 and max 10 characters", Snackbar.LENGTH_LONG).show();
                            return;
                        }
                        passwordField.setText("");
                        button.setText("CONFIRM PASSWORD");
                        i[0] = 1;
                    }
                }
            }
        });
        return view;
    }
}