package tarefa.unisinos.com.br.cadastro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class DisplayCadastroActivity extends Activity {

    private static final String TAG = "DisplayCadastroActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_cadastro);

        Button btnVoltar = (Button) findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "voltando...");
                Intent intent = new Intent(DisplayCadastroActivity.this, CadastroActivity.class);
                startActivity(intent);
            }
        });

        this.montaDados();
    }

    private void montaDados(){

        /*Intent intent = getIntent();

        String nome = intent.getStringExtra(CadastroActivity.EXTRA_NOME);
        String nascimento = intent.getStringExtra(CadastroActivity.EXTRA_NASCIMENTO);
        String estadoCivil = intent.getStringExtra(CadastroActivity.EXTRA_ESTADO_CIVIL);
        String profissao = intent.getStringExtra(CadastroActivity.EXTRA_PROFISSAO);
        String sexo = intent.getStringExtra(CadastroActivity.EXTRA_SEXO);*/

        Bundle extras = getIntent().getExtras();

        String nome = extras.getString(CadastroActivity.EXTRA_NOME);
        String nascimento = extras.getString(CadastroActivity.EXTRA_NASCIMENTO);
        String estadoCivil = extras.getString(CadastroActivity.EXTRA_ESTADO_CIVIL);
        String profissao = extras.getString(CadastroActivity.EXTRA_PROFISSAO);
        String sexo = extras.getString(CadastroActivity.EXTRA_SEXO);

        TextView textNome = (TextView) findViewById(R.id.textNome);
        textNome.setText(nome);

        TextView textNascimento = (TextView) findViewById(R.id.textNascimento);
        textNascimento.setText(nascimento);

        TextView textEstadoCivil = (TextView) findViewById(R.id.textEstadoCivil);
        textEstadoCivil.setText(estadoCivil);

        TextView textProfissao = (TextView) findViewById(R.id.textProfissao);
        textProfissao.setText(profissao);

        TextView textSexo = (TextView) findViewById(R.id.textSexo);
        textSexo.setText(sexo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display_cadastro, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
