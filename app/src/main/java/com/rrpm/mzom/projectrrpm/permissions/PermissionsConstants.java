package com.rrpm.mzom.projectrrpm.permissions;

import android.Manifest;

public final class PermissionsConstants {

    static final int APP_PERMISSIONS_REQUEST = 1337;

    public static final String[] ALL_PERMISSIONS = new String[]{
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.WAKE_LOCK
    };

}
