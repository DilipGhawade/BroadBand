package com.broadband.www.broadband.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.broadband.www.broadband.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login_Fragment extends Fragment implements View.OnClickListener{
  EditText edtemial,edtpassword;
  Button btnlogin;
  TextView txtregister,txtshowpwd;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.login_fragment,container,false);
    return v;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    edtemial = view.findViewById(R.id.edt_username);
    edtpassword = view.findViewById(R.id.edt_password);
    txtshowpwd = view.findViewById(R.id.txt_spwd);
    txtshowpwd.setOnClickListener(this);

    txtregister = view.findViewById(R.id.txt_registerhere);
    btnlogin = view.findViewById(R.id.btn_login);
    btnlogin.setOnClickListener(this);
    txtregister.setOnClickListener(this);

  }

  public void checkLogin(View arg0) {

    final String uname = edtemial.getText().toString();
    final String pwd = edtpassword.getText().toString();
    if (uname.equals("wifi") && pwd.equals("wifi"))
    {
      replaceFragment(new Home_Fragment(),true);
    }
    else
    {
      Toast.makeText(getContext(),"Invalid User Name Or Password",Toast.LENGTH_LONG).show();
    }

    final String email = edtemial.getText().toString();
    if (!isValidEmail(email)) {
      //Set error message for email field
      edtemial.setError("Invalid Email");
    }

    final String pass = edtpassword.getText().toString();
    if (!isValidPassword(pass)) {
      //Set error message for password field
      edtpassword.setError("Invalid Password or cannot be empty");
    }

    if(isValidEmail(email) && isValidPassword(pass))
    {
      // Validation Completed


    }

  }
  private boolean isValidEmail(String email) {
    String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
      + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    Matcher matcher = pattern.matcher(email);
    return matcher.matches();
  }

  // validating password
  private boolean isValidPassword(String pass) {
    if (pass != null && pass.length() >= 4) {
      return true;
    }
    return false;
  }

  @Override
  public void onClick(View view) {
    switch (view.getId())
    {
      case R.id.btn_login:
        checkLogin(view);
        break;
      case R.id.txt_registerhere:
        replaceFragment(new Register_Fragment(),true);
        break;
      case R.id.txt_spwd:
        showPassword();
        break;
    }
  }
  public void showPassword() {
    boolean isclicked = true;
    if (!isclicked) {
      edtpassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }
    else
    {
      edtpassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
    }
  }
  public void replaceFragment(Fragment fragment, boolean addToBack)
  {
    FragmentManager fm = getFragmentManager();
    FragmentTransaction ft = fm.beginTransaction();
    ft.replace(R.id.MAIN_CONTAINER,fragment,fragment.getClass().getName());
   /* if (addToBack)
      ft.addToBackStack(null);*/
    ft.commit();
  }
}
