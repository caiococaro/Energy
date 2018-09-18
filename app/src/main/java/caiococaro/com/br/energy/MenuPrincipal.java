package caiococaro.com.br.energy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MenuPrincipal extends AppCompatActivity {

    //TAG do Log do Console
    private static final String TAG = "";

    //Keys da Bundle (São os dados (ou valores) da bundle da Activity anterior)
    //(Está passando o dado numCliente para essa tela)
    private static final String KEY_NUM_CLIENTE = "NumeroCliente";
    private static final String NUM_CLIENTE = "NumeroCliente";
    //(Está passando o dado tokenAcesso para essa tela)
    private static final String KEY_TOKEN_ACESSO = "TokenAcesso";

    //Names para cada Bundle Específica (Nome de cada refêrencia de uma Bundle específica a ser usada na próxima tela)
    private static final String NAME_ACOMPANHAMENTO = "Acompanhamento";
    private static final String NAME_BAIXA_RENDA = "BaixaRenda";
    private static final String NAME_CLIENTE_VITAL = "ClienteVital";
    private static final String NAME_CONSUMO = "Consumo";
    private static final String NAME_HISTORICO = "Historico";
    private static final String NAME_RECLAMACAO = "Reclamacao";


    String valorNumCliente;

    Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        //Recebendo a bundle da MainActivity com vários valores
        bundle = getIntent().getExtras();

        //Setando os valores do bundle da MainActivity para bundles das outras Activities
        if(bundle != null ){
            valorNumCliente = bundle.getString(KEY_NUM_CLIENTE);
            Log.d(TAG, "MENUPRINCIPALCONSUMO: "+valorNumCliente);
        }



        //Enviando bundle com token para AcompanhamentoEquipeTecnica
        Bundle bundleAcompanhamento = new Bundle();
        bundleAcompanhamento = bundle.getBundle("ConsumoTempoReal");

        //Button btnConsumo = (Button) findViewById(R.id.btnConsumo);
        //Button btnHistConsumo = (Button) findViewById(R.id.btnHistConsumo);
        //Button btnReclamacao = (Button) findViewById(R.id.btnReclamacao);
        //Button btnAcompanhamento = (Button) findViewById(R.id.btnAcompanhamento);
        //Button btnCadastroVital = (Button) findViewById(R.id.btnCadastroVital);
        //Button btnCadastroBaixaRenda = (Button) findViewById(R.id.btnCadastroBaixaRenda);
        Button btnConsumo = (Button) findViewById(R.id.btnConsumo);
        Button btnHistConsumo = (Button) findViewById(R.id.btnHistConsumo);
        Button btnReclamacao = (Button) findViewById(R.id.btnReclamacao);
        Button btnAcompanhamento = (Button) findViewById(R.id.btnAcompanhamento);
        Button btnCadastroVital = (Button) findViewById(R.id.btnCadastroVital);
        Button btnCadastroBaixaRenda = (Button) findViewById(R.id.btnCadastroBaixaRenda);

        /*
        Intent intent = new Intent(MainActivity.this, MenuPrincipal.class);
        Bundle bundle = new Bundle();
        bundle.putString("ConsumoTempoReal", numCliente);
        bundle.putString("Acompanhamento", tokenAcesso);
        intent.putExtras(bundle);
        startActivity(intent);
        */


        //Inciando Activity ConsumoTempoReal
        btnConsumo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentConsumo = new Intent(MenuPrincipal.this, ConsumoTempoReal.class);

                //Enviando bundle para ConsumoTempoReal
                Bundle bundleConsumo = new Bundle();
                bundleConsumo.putString(NAME_CONSUMO, valorNumCliente);
                intentConsumo.putExtras( bundleConsumo);
                startActivity(intentConsumo);
            }
        });

        //Inciando Activity HistoricoConsumo
        btnHistConsumo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHistorico = new Intent(MenuPrincipal.this, HistoricoConsumo.class);
                startActivity(intentHistorico);
            }
        });

        //Inciando Activity ReclamacaoEspecial
        btnReclamacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentReclamacao = new Intent(MenuPrincipal.this, ReclamacaoEspecial.class);
                startActivity(intentReclamacao);
            }
        });

        //Inciando Activity AcompanhamentoEquipeTecnica
        btnAcompanhamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentEquipeTecnica = new Intent(MenuPrincipal.this, AcompanhamEquipeTecnica.class);
                startActivity(intentEquipeTecnica);
            }
        });

        //Inciando Activity CadastroClienteVital
        btnCadastroVital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentClienteVital = new Intent(MenuPrincipal.this, CadastroClienteVital.class);
                startActivity(intentClienteVital);
            }
        });

        //Inciando Activity CadastroBaixaRenda
        btnCadastroBaixaRenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBaixaRenda= new Intent(MenuPrincipal.this, CadastroBaixaRenda.class);
                startActivity(intentBaixaRenda);
            }
        });
    }
}

