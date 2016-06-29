package bt.be.revisionapplication;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class IsLoginActivity extends AppCompatActivity {
    public static final int NO_TEXT_ID = 0;
    Bundle extra;
    ListView malisteView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_is_login);
        Intent intent = getIntent();

       
        extra = intent.getExtras();
        if(extra!=null){
            String username= extra.getString("Username");
            String mdp= extra.getString("Password");
            TextView t=(TextView)findViewById(R.id.txt_userName_recup);
            t.setText(username);
            TextView p=(TextView)findViewById(R.id.txt_mdp_recup);
            p.setText(mdp);
        }



    }
    public void search(String s){

        Intent intentSearch =new Intent(Intent.ACTION_SEARCH);
        intentSearch.putExtra(SearchManager.QUERY, s);
        if (intentSearch.resolveActivity(getPackageManager()) != null) {
        startActivity(intentSearch);
        }
    }

    public void rechercher(View v){
        EditText mot=(EditText)findViewById(R.id.txt_motChercher);

        search(mot.getText().toString());
    }

}
