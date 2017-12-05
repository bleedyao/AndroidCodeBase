package cn.bleedyao.library.mqtt;

import org.eclipse.paho.client.mqttv3.IMqttToken;

/**
 * Created by yaoluhao on 05/12/2017.
 */

public interface ArcticWindIMqttActionListener {
    void onSuccess(IMqttToken asyncActionToken);

    void onFailure(IMqttToken asyncActionToken, Throwable exception);
}
