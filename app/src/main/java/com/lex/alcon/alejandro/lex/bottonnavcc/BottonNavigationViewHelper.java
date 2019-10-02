package com.lex.alcon.alejandro.lex.bottonnavcc;

import android.annotation.SuppressLint;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;

import java.lang.reflect.Field;

/**
 * Created by Pamela on 31/12/2017.
 */

public class BottonNavigationViewHelper {

    @SuppressLint("RestrictedApi")
    public static void disableShiftMode(BottomNavigationView navigation){
        BottomNavigationMenuView menuView=(BottomNavigationMenuView) navigation.getChildAt(0);
        try {
            Field ShiftingMode=menuView.getClass().getDeclaredField("mShiftingMode");
            ShiftingMode.setAccessible(true);
            ShiftingMode.setBoolean(menuView,false);
            ShiftingMode.setAccessible(false);
            for (int i=0; i<menuView.getChildCount();i++){
                BottomNavigationItemView item=(BottomNavigationItemView) menuView.getChildAt(i);
                //item.setShiftingMode(false);
                item.setChecked(item.getItemData().isChecked());
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }
}
