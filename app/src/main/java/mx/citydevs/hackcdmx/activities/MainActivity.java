package mx.citydevs.hackcdmx.activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import mx.citydevs.hackcdmx.R;

/**
 * Created by zace3d on 3/7/15.
 * @update by mikesaurio
 */
public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    /**
     * creación e instancia del UI
     */
    private void initUI() {
        findViewById(R.id.main_btn_officer).setOnClickListener(this);
        findViewById(R.id.main_btn_infraction).setOnClickListener(this);
        findViewById(R.id.iv_acerca_de).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_acerca_de:
                startIntentClass(TutorialActivity.class);
                break;
            case R.id.main_btn_officer:
                startIntentClass(OfficersActivity.class);
                break;
            case R.id.main_btn_infraction:
                startIntentClass(InfractionsActivity.class);
                break;
        }
    }

    /**
     *Hace un StartIntent a una class activity
     * @param class_ (Class) Activity a iniciar
     */
    private void startIntentClass(Class class_){
        Intent intent = new Intent(getBaseContext(), class_);
        startActivity(intent);
    }
}
