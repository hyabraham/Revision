package bt.be.revisionapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity{
    ListView malisteView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String[] data = new String[]{"Blop", "Plop", "Blip", "Blup"};
        Log.d("DATA", data[0]);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.list_film, data);
        Log.d("ADAPT", arrayAdapter.getItem(0));
        malisteView = (ListView) findViewById(R.id.list_movie);
        malisteView.setAdapter(arrayAdapter);
        malisteView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView listText = (TextView) view.findViewById(R.id.textView_list);
                String text = listText.getText().toString();
                Log.i("TEXT", text);
            }
        });
    }
}
