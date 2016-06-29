package bt.be.revisionapplication;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PrefsActivity extends AppCompatActivity {

    EditText email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prefs);


    }

    public Boolean chechCheckBox(View v){

        CheckBox monCheckBox;
        monCheckBox=(CheckBox)findViewById(R.id.chk_remember);
        if(monCheckBox.isChecked()){
            return true;
        } else {
            return false;
        }
    }
    public void savePrefs(View v){
        CheckBox monCheckBox;

        monCheckBox=(CheckBox)findViewById(R.id.chk_remember);
        boolean val=chechCheckBox(monCheckBox);
        if(val) {
            email = (EditText) findViewById(R.id.txt_mail);

            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("newsletters", val);
            editor.putString("email", email.getText().toString());
            editor.apply();

        }else{
            Toast.makeText(PrefsActivity.this, "Pas de preferences à sauvegarder", Toast.LENGTH_SHORT).show();

            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("newsletters", false);
            editor.putString("email", "");
            editor.apply();

        }
    }

    public void remember(View mavue){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Boolean newletters=prefs.getBoolean("newsletter",false);
        String email = prefs.getString("email","");
        TextView monTextView;
        monTextView=(TextView)findViewById(R.id.txtV_recap);
        monTextView.setText(email);
    }
}