package com.example.danceculture.imc;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    double alt;
    double peso;
    double imc;
    double doble;

    private EditText et1;
    private EditText et2;

    private ImageView img;
    private TextView tv008;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);

        img=(ImageView)findViewById(R.id.por);
        tv008=(TextView)findViewById(R.id.tv008);
    }

    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        /*String edit1 = tv44.getText().toString();

        outState.putString("STRING1",edit1);*/
    }
    protected void onRestoreInstanceState(Bundle saveInstanceState){
        super.onSaveInstanceState(saveInstanceState);
        //String edit1 = savedInstanceState.getString("STRING1");

        //tv44.setText(edit1);

    }

    public void acercade(View view) {
        Intent i = new Intent(this, AcercaDe.class );
        startActivity(i);
    }

    public void estimate(View v) {
        String v1 = et1.getText().toString();
        String v2 = et2.getText().toString();



        if (!v1.equals("") )  {
            if (!v2.equals("")){

                alt=Double.valueOf(v1).doubleValue();
                peso=Double.valueOf(v2).doubleValue();

                doble =alt*alt;
                imc=peso/doble;

                if (imc<=18.5) {

                    tv008.setText(getResources().getString(R.string.pesobajo));

                    Toast toart = Toast.makeText(getApplicationContext(), getResources().getString(R.string.eximc) + imc, Toast.LENGTH_LONG);
                    toart.show();

                    Drawable myDrawable = getResources().getDrawable(R.drawable.pesobajo);
                    img.setImageDrawable(myDrawable);
                }else if (imc<=24.9){
                    tv008.setText(getResources().getString(R.string.pesonorm));

                    Toast toart = Toast.makeText(getApplicationContext(), getResources().getString(R.string.eximc) + imc, Toast.LENGTH_LONG);
                    toart.show();

                    Drawable myDrawable = getResources().getDrawable(R.drawable.pesonormal);
                    img.setImageDrawable(myDrawable);

                }else if(imc<=34.9){
                    tv008.setText(getResources().getString(R.string.peso11));

                    Toast toart = Toast.makeText(getApplicationContext(), getResources().getString(R.string.eximc) + imc, Toast.LENGTH_LONG);
                    toart.show();

                    Drawable myDrawable = getResources().getDrawable(R.drawable.peso11);
                    img.setImageDrawable(myDrawable);

                }else{
                    tv008.setText(getResources().getString(R.string.peso22));

                    Toast toart = Toast.makeText(getApplicationContext(), getResources().getString(R.string.eximc) + imc, Toast.LENGTH_LONG);
                    toart.show();

                    Drawable myDrawable = getResources().getDrawable(R.drawable.peso222);
                    img.setImageDrawable(myDrawable);

                }







            }else{
                Toast toast= Toast.makeText(getApplicationContext(),getResources().getString(R.string.exaltura),Toast.LENGTH_LONG);
                toast.show();

            }

        }else {
            Toast toat= Toast.makeText(getApplicationContext(),getResources().getString(R.string.expeso),Toast.LENGTH_LONG);
            toat.show();

        }
    }
}
