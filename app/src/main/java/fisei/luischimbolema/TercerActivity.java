package fisei.luischimbolema;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TercerActivity extends AppCompatActivity {

    private EditText editTextNombre3, editTextApellido3, editTextBase3, editTextExponente3, editTextNumero3;
    private Button buttonCerrar3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercer);
        editTextNombre3 = findViewById(R.id.editTextNombre3);
        editTextNombre3.setEnabled(false);
        editTextApellido3 = findViewById(R.id.editTextApellido3);
        editTextBase3 = findViewById(R.id.editTextBase3);
        editTextBase3.setEnabled(false);
        editTextExponente3 = findViewById(R.id.editTextExponente3);
        editTextNumero3 = findViewById(R.id.editTextNumero3);


        Bundle datosExtra = getIntent().getExtras();
        String nombre = datosExtra.getString("key_nombre");
        String base = String.valueOf(datosExtra.getInt("key_base"));
        editTextNombre3.setText(nombre);
        editTextBase3.setText(base);
    }

    public void onClicCerrar3(View view){
        String apellido = editTextApellido3.getText().toString();
        String exponente = editTextExponente3.getText().toString();
        String numero = editTextNumero3.getText().toString();

        Intent intent = new Intent();
        intent.putExtra("apellido",apellido);
        intent.putExtra("exponente",exponente);
        intent.putExtra("numero",numero);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}