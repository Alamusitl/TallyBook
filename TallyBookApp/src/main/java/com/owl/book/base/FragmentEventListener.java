package com.owl.book.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * FragmentEventListener for transition data with Fragment
 * Created by Imagine Owl on 2017/5/24.
 */

public interface FragmentEventListener {

    void dismiss(Class clz, Fragment fragment, Bundle bundle);
}
