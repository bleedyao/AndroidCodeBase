package cn.bleedyao.library.mqtt;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;

/**
 * Created by yaoluhao on 05/12/2017.
 */

public class ArcticWindMqttConnectOptions extends MqttConnectOptions {
    public static boolean automaticReconnect = true;
    public static String userName = "arcticwind";
    public static String password = "arcticwind";
    public static boolean cleanSession = false;

    public ArcticWindMqttConnectOptions(){
        setAutomaticReconnect(automaticReconnect);
        setUserName(userName);
        setPassword(password.toCharArray());
        setCleanSession(cleanSession);
    }
}
