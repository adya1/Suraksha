package com.apkglobal.suraksha;

/**
 * Created by dell on 1/10/2018.
 */

interface AccelerometerListener {

    public void onAccelerationChanged(float x, float y, float z);

    public void onShake(float force);

}
