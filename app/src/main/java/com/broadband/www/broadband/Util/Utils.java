package com.broadband.www.broadband.Util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by AABHALI on 14-12-2017.
 */

public class Utils {
  private static Context context;

  public static boolean isConnectedToInternet(Context context) {
    Utils.context = context;
    boolean connected = false;
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm.getNetworkInfo(cm.TYPE_MOBILE).getState()== NetworkInfo.State.CONNECTED ||
        cm.getNetworkInfo(cm.TYPE_WIFI).getState()==NetworkInfo.State.CONNECTED)
        {
            connected = true;

        }
        else {
            connected = false;
        }
        return connected;
    }
}
