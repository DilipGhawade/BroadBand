package com.broadband.www.broadband.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.broadband.www.broadband.R;

public class Home_Fragment extends Fragment implements View.OnClickListener{
  TextView txtanc,txtr,txtaus,txtcus,txtcs,txtnp,txttc,txtlgt;
  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.home_fragment,container,false);
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    txtanc = view.findViewById(R.id.txt_anc);
    txtr = view.findViewById(R.id.txt_rc);
    txtaus = view.findViewById(R.id.txt_aus);
    txtcus = view.findViewById(R.id.txt_cus);
    txtcs = view.findViewById(R.id.txt_cs);
    txtnp = view.findViewById(R.id.txt_np);
    txttc = view.findViewById(R.id.txt_tc);
    txtlgt = view.findViewById(R.id.txt_lt);

    txtanc.setOnClickListener(this);
    txtr.setOnClickListener(this);
    txtaus.setOnClickListener(this);
    txtcus.setOnClickListener(this);
    txtcs.setOnClickListener(this);
    txtnp.setOnClickListener(this);
    txttc.setOnClickListener(this);
    txtlgt.setOnClickListener(this);
  }

  @Override
  public void onClick(View view) {
    switch (view.getId())
    {
      case R.id.txt_anc:
        replaceFragment(new ApplyNCon_Fragment(),true);
        break;
      case R.id.txt_rc:
        replaceFragment(new RegisterComp_Fragment(),true);
        break;
      case R.id.txt_aus:
        replaceFragment(new AboutUs_Fragment(),true);
        break;
      case R.id.txt_cus:
        replaceFragment(new ContactUs_Fragment(),true);
        break;
      case R.id.txt_cs:
        replaceFragment(new ConnectionStatus_Fragment(),true);
        break;
      case R.id.txt_np:
        replaceFragment(new NewPlan_Fragment(),true);
        break;
      case R.id.txt_tc:
        replaceFragment(new TermCondition_Fragment(),true);
        break;
      case R.id.txt_lt:
        break;
    }

  }
  public void replaceFragment(Fragment fragment, boolean addToBack)
  {
    FragmentManager fm = getFragmentManager();
    FragmentTransaction ft = fm.beginTransaction();
    ft.replace(R.id.MAIN_CONTAINER,fragment,fragment.getClass().getName());
    if (addToBack)
      ft.addToBackStack(null);
    ft.commit();
  }
}
