package cn.bleedyao.library.mqtt;

import android.content.Context;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.DisconnectedBufferOptions;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttClientPersistence;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

/**
 * Created by yaoluhao on 05/12/2017.
 */

public class ArcticWindMqttAndroidClient extends MqttAndroidClient {
    public static String serverUri = "tcp://iot.sensoro.com:1883";
    public static String clientId = "iWtF60VYn8tz";
    public static boolean bufferEnable = true;
    public static int bufferSize = 100;
    public static boolean persistBuffer = false;
    public static boolean deleteOldesMessages = false;

    public ArcticWindMqttAndroidClient(Context context) {
        this(context, serverUri, clientId, null, Ack.AUTO_ACK);
    }

    public ArcticWindMqttAndroidClient(Context context, String serverURI, String clientId) {
        this(context, serverURI, clientId, null, Ack.AUTO_ACK);
    }

    public ArcticWindMqttAndroidClient(Context ctx, String serverURI, String clientId, Ack
            ackType) {
        this(ctx, serverURI, clientId, null, ackType);
    }

    public ArcticWindMqttAndroidClient(Context ctx, String serverURI, String clientId,
                                       MqttClientPersistence persistence) {
        this(ctx, serverURI, clientId, persistence, Ack.AUTO_ACK);
    }

    public ArcticWindMqttAndroidClient(Context context, String serverURI, String clientId,
                                       MqttClientPersistence persistence, Ack ackType) {
        super(context, serverURI, clientId, persistence, ackType);
    }

    public IMqttToken connect(MqttConnectOptions options, final ArcticWindIMqttActionListener
            awListener) throws MqttException {
        IMqttActionListener listener = new IMqttActionListener() {
            @Override
            public void onSuccess(IMqttToken asyncActionToken) {
                DisconnectedBufferOptions disconnectedBufferOptions = new
                        DisconnectedBufferOptions();
                disconnectedBufferOptions.setBufferEnabled(bufferEnable);
                disconnectedBufferOptions.setBufferSize(bufferSize);
                disconnectedBufferOptions.setPersistBuffer(persistBuffer);
                disconnectedBufferOptions.setDeleteOldestMessages(deleteOldesMessages);
                setBufferOpts(disconnectedBufferOptions);
                awListener.onSuccess(asyncActionToken);
            }

            @Override
            public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                awListener.onFailure(asyncActionToken, exception);
            }
        };
        return super.connect(options, null, listener);
    }
}
