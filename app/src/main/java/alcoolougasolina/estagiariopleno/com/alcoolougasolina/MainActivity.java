package alcoolougasolina.estagiariopleno.com.alcoolougasolina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText caixaAlcool;
    private EditText caixaGasolina;
    private Button botaoConfirmar;
    private TextView preferencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        caixaAlcool = (EditText) findViewById(R.id.caixaAlcoolId);
        caixaGasolina = (EditText) findViewById(R.id.caixaGasolinaId);
        botaoConfirmar = (Button) findViewById(R.id.botaoConfirmarId);
        preferencia = (TextView) findViewById(R.id.preferenciaId);

        botaoConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gasolinaCapturada = caixaGasolina.getText().toString();
                String alcoolCapturado = caixaAlcool.getText().toString();

                if (gasolinaCapturada.isEmpty() || alcoolCapturado.isEmpty()){
                    preferencia.setText("Por favor, preencha todos os campos.");
                }else{
                    double gasolina = Double.parseDouble(gasolinaCapturada);
                    double alcool = Double.parseDouble(alcoolCapturado);
                    //Verifica qual tipo de combustível é melhor utilizar
                    if (alcool/gasolina >= 0.7) {
                        preferencia.setText("Recomendado: Gasolina");
                    }else{
                        preferencia.setText("Recomendado: Álcool");
                    }
                }
            }
        });
    }
}
