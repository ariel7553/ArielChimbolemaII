package fisei.luischimbolema;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private EditText editTextNombre, editTextApellido, editTextBase, editTextExponente,editTextFactorial,editTextPotencia;
    private Button buttonSiguiente, buttonMostrarResultados;
    private int codigoRequerido=1;
    private int base,exponente,numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNombre = findViewById(R.id.editTextNombre);
        editTextNombre.setEnabled(false);
        editTextApellido = findViewById(R.id.editTextApellido);
        editTextApellido.setEnabled(false);
        editTextBase = findViewById(R.id.editTextBase);
        editTextBase.setEnabled(false);
        editTextExponente = findViewById(R.id.editTextExponente);
        editTextExponente.setEnabled(false);
        editTextFactorial = findViewById(R.id.editTextFactorial);
        editTextFactorial.setEnabled(false);
        editTextPotencia = findViewById(R.id.editTextPotencia);
        editTextPotencia.setEnabled(false);
        buttonSiguiente = findViewById(R.id.buttonSiguiente);
        buttonMostrarResultados = findViewById(R.id.buttonMostrarResultados);
        buttonMostrarResultados.setEnabled(false);
    }

    public void onClicSiguiente(View view){
        Intent intent = new Intent(this, SegundoActivity.class);
        startActivityForResult(intent, codigoRequerido);
        //startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == codigoRequerido) && (resultCode == RESULT_OK)) {
            editTextNombre.setText(data.getStringExtra("nombre"));
            editTextApellido.setText(data.getStringExtra("apellido"));
            editTextBase.setText(data.getStringExtra("base"));
            base = Integer.parseInt(data.getStringExtra("base"));
            exponente=Integer.parseInt(data.getStringExtra("exponente"));
            editTextExponente.setText(data.getStringExtra("exponente"));
            numero = Integer.parseInt(data.getStringExtra("numero"));

            buttonMostrarResultados.setEnabled(true);

        }
    }

    public int factorial( int numero ) {
        int fact = 1;
        for( int i = 1; i <= numero; i++ ) {
            fact *= i;
        }

        return fact;

    }


    public void onClicMostrarResultados(View view){
        String n = String.valueOf(factorial(numero));
        editTextFactorial.setText(n);

        String resultado = String.valueOf((int) Math.pow(base, exponente));
        editTextPotencia.setText(resultado);

    }
}