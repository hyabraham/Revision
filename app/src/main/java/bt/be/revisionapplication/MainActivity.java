package bt.be.revisionapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText userName,password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName=(EditText)findViewById(R.id.txt_userName);
        password=(EditText)findViewById(R.id.txt_password);
    }

    public Boolean check(String value){

        if(value.equals("") ){
            return true;
        }else {
           return false;
        }
    }

    public void connection(View v){
        String userN=userName.getText().toString();
        String passwd=password.getText().toString();
        Intent intent=new Intent(this,IsLoginActivity.class);

        if(check(userN)){
            Toast.makeText(this, "Please enter Username", Toast.LENGTH_SHORT).show();
        }else if(check(passwd)){
            Toast.makeText(this, "Please enter Passord", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Connection OK", Toast.LENGTH_SHORT).show();
            intent.putExtra("Username",userN);
            intent.putExtra("Password",passwd);
            startActivity(intent);
        }
    }
}
