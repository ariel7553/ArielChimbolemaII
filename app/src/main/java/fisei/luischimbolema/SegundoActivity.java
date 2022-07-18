package fisei.luischimbolema;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class SegundoActivity extends AppCompatActivity {
    private EditText editTextNombre2, editTextBase2;
    private Button buttonSiguiente2, buttonCerrar;
    private int codigoRequerido=1;
    private String apellido,exponente,numero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);
        editTextNombre2 = findViewById(R.id.editTextNombre2);
        editTextBase2 = findViewById(R.id.editTextBase2);
        buttonSiguiente2 = findViewById(R.id.buttonSiguiente2);
        buttonCerrar=findViewById(R.id.buttonCerrar);
        buttonCerrar.setEnabled(false);
    }

    public void onClicSiguiente2(View view){
        String nombre = editTextNombre2.getText().toString();
        int base = Integer.parseInt(editTextBase2.getText().toString());
        Intent intent = new Intent(this,TercerActivity.class);
        intent.putExtra("key_nombre",nombre);
        intent.putExtra("key_base",base);
        //startActivity(intent);
        startActivityForResult(intent, codigoRequerido);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == codigoRequerido) && (resultCode == RESULT_OK)) {
            apellido = data.getStringExtra("apellido");
            exponente = data.getStringExtra("exponente");
            numero = data.getStringExtra("numero");
            buttonCerrar.setEnabled(true);

        }

    }

    public void onClicCerrar2(View view){
        String nombre = editTextNombre2.getText().toString();
        String base = editTextBase2.getText().toString();

        Intent intent = new Intent();
        intent.putExtra("nombre",nombre);
        intent.putExtra("base",base);
        intent.putExtra("apellido",apellido);
        intent.putExtra("exponente",exponente);
        intent.putExtra("numero",numero);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}