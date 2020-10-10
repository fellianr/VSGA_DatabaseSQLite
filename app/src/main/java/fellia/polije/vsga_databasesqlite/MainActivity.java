package fellia.polije.vsga_databasesqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnStore, btnGet;
    EditText etNama;
    DatabaseHelper databaseHelper;
    TextView txtName;
    ArrayList<String> arrayList;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHelper = new DatabaseHelper(this);
        txtName = findViewById(R.id.tvNames);
        btnStore = findViewById(R.id.btnStore);
        btnGet = findViewById(R.id.btnGet);
        etNama = findViewById(R.id.etnama);

        btnStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(etNama.getText())) {
                    Toast.makeText(MainActivity.this, "Anda Belum Mengisikan Nama", Toast.LENGTH_SHORT).show();
                }else {
                    databaseHelper.addStudentDetail(etNama.getText().toString());
                    etNama.setText("");
                    Toast.makeText(MainActivity.this, "Data Tersimpan", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList = databaseHelper.getAllStudentsList();
                txtName.setText("");
                for (int i = 0; i<arrayList.size(); i++){
                    txtName.setText(txtName.getText().toString()+", "+arrayList.get(i));
                }
            }
        });
    }
}
