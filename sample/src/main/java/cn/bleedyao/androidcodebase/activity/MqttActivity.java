package cn.bleedyao.androidcodebase.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import cn.bleedyao.androidcodebase.R;
import cn.bleedyao.library.mqtt.ArcticWindIMqttActionListener;
import cn.bleedyao.library.mqtt.ArcticWindMqttAndroidClient;
import cn.bleedyao.library.mqtt.ArcticWindMqttConnectOptions;

public class MqttActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mqtt);

        ArcticWindMqttAndroidClient client = new ArcticWindMqttAndroidClient
                (getApplicationContext());

        client.setCallback(new MqttCallbackExtended() {
            @Override
            public void connectComplete(boolean reconnect, String serverURI) {
                if (reconnect){
                    TextView textView1 = findViewById(R.id.textView1);
                    textView1.setText("subscribed");
                }
            }

            @Override
            public void connectionLost(Throwable cause) {

            }

            @Override
            public void messageArrived(String topic, MqttMessage message) throws Exception {

            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken token) {

            }
        });

        ArcticWindMqttConnectOptions options = new ArcticWindMqttConnectOptions();

        try {
            client.connect(options, new ArcticWindIMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    TextView textView = (TextView) findViewById(R.id.textView2);
                    textView.setText("connected");
                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {

                }
            });
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
