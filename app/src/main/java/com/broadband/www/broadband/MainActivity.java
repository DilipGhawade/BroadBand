package com.broadband.www.broadband;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.broadband.www.broadband.Fragment.Login_Fragment;
import com.broadband.www.broadband.Util.Utils;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    if (Utils.isConnectedToInternet(MainActivity.this))
    {
      replaceFragment(new Login_Fragment(),true);
    }
    else
    {
      Intent i = new Intent(MainActivity.this,ConnectionFailedActivity.class);
      startActivity(i);
      finish();
    }
  }

  public void replaceFragment(Fragment fragment, boolean addToBack)
  {
    FragmentManager fm = getSupportFragmentManager();
    FragmentTransaction ft = fm.beginTransaction();
    ft.replace(R.id.MAIN_CONTAINER,fragment,fragment.getClass().getName());
   /* if (addToBack)
    ft.addToBackStack(null);*/
    ft.commit();
  }

  @Override
  public void onBackPressed() {

    if(getSupportFragmentManager().getBackStackEntryCount()==0){
      finish();
    }else {
      super.onBackPressed();
    }
  }
}
