package com.rimi.sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends AppCompatActivity implements SensorEventListener {

    TextView txtNumber;
    SensorManager sm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNumber=findViewById(R.id.txt_number);
        sm=(SensorManager)this.getSystemService(Context.SENSOR_SERVICE);

        sm.registerListener( this,sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
   if (event.sensor.getType()==Sensor.TYPE_ACCELEROMETER)
   {
   float value[]=event.values;
   float x=value[0];
   float y=value[1];
   float z=value[2];

   float asr=(x*x+y*y+z*z)/(SensorManager.GRAVITY_EARTH*SensorManager.GRAVITY_EARTH);

   if (asr>=2)//er man joto barbe spreed toto barbe
   {
       Random r=new Random();
       int number=r.nextInt(3000);
       txtNumber.setText(""+number);//+number ta deya hoi number tar string  generate korte
   }

   }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
