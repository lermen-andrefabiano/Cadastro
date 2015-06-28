package tarefa.unisinos.com.br.cadastro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;


public class CadastroActivity extends Activity {

    private static final String TAG = "CadastroActivity";

    public static final String EXTRA_NOME = "EXTRA_NOME";

    public static final String EXTRA_NASCIMENTO = "EXTRA_NASCIMENTO";

    public static final String EXTRA_SEXO = "EXTRA_SEXO";

    public static final String EXTRA_PROFISSAO = "EXTRA_PROFISSAO";

    public static final String EXTRA_ESTADO_CIVIL = "EXTRA_ESTADO_CIVIL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate");
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cadastro);

        this.populaProfissoes();

        this.populaEstadoCivil();
    }

    private void populaProfissoes(){
        Log.i(TAG, "populaProfissoes");
        Spinner spinner = (Spinner) findViewById(R.id.spinnerProfissoes);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.profissoes_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.i(TAG, parent.getSelectedItem().toString());
                Log.i(TAG, parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.i(TAG, "nada selecionado");
            }
        });
    }

    private void populaEstadoCivil(){
        Log.i(TAG, "populaEstadoCivil");
        Spinner spinner = (Spinner) findViewById(R.id.spinnerEstadoCivil);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.estado_civil_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.i(TAG, parent.getSelectedItem().toString());
                Log.i(TAG, parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.i(TAG, "nada selecionado");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cadastro, menu);
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

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_masculino:
                if (checked)
                    Log.i(TAG, "radio_masculino");
                    break;
            case R.id.radio_feminino:
                if (checked)
                    Log.i(TAG, "radio_feminino");
                    break;
            case R.id.radio_outros:
                if (checked)
                    Log.i(TAG, "radio_outros");
                    break;
        }
    }

    public void proximoPasso(View view){
        Log.i(TAG, "proximoPasso");

        EditText edtSenha = (EditText) findViewById(R.id.edtSenha);
        EditText edtConfirmarSenha = (EditText) findViewById(R.id.edtConfirmarSenha);

        String senha = edtSenha.getText().toString();
        String confirmarSenha = edtConfirmarSenha.getText().toString();

        Log.i(TAG, senha);
        Log.i(TAG, confirmarSenha);

        if(!senha.isEmpty() && !confirmarSenha.isEmpty()) {
            if (senha.equals(confirmarSenha)) {
                Log.i(TAG, "senha iguais");
                this.openDisplayCadastro();
            }else {
                String msg = getString(R.string.senha_diferrentes);
                Log.i(TAG, msg);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        }else {
            String msg = getString(R.string.informe_senha);
            Log.i(TAG, msg);
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        }

    }

    private void openDisplayCadastro(){
        EditText edtNomeCompleto = (EditText) findViewById(R.id.edtNomeCompleto);
        EditText edtDataNascimento = (EditText) findViewById(R.id.edtDataNascimento);
        Spinner spinnerEstadoCivil = (Spinner) findViewById(R.id.spinnerEstadoCivil);
        Spinner spinnerProfissoes = (Spinner) findViewById(R.id.spinnerProfissoes);

        String nome = edtNomeCompleto.getText().toString();
        String nascimento = edtDataNascimento.getText().toString();
        String estadoCivil = spinnerEstadoCivil.getSelectedItem().toString();
        String profissao = spinnerProfissoes.getSelectedItem().toString();
        String sexo = "";

        RadioGroup rg = (RadioGroup) findViewById(R.id.rgSexo);
        int op = rg.getCheckedRadioButtonId();

        switch(op) {
            case R.id.radio_masculino:
                Log.i(TAG, "radio_masculino");
                sexo = getString(R.string.masculino);
                break;
            case R.id.radio_feminino:
                Log.i(TAG, "radio_feminino");
                sexo = getString(R.string.feminino);
                break;
            case R.id.radio_outros:
                Log.i(TAG, "radio_outros");
                sexo = getString(R.string.outros);
                break;
        }

        Log.i(TAG, nome);
        Log.i(TAG, nascimento);
        Log.i(TAG, estadoCivil);
        Log.i(TAG, profissao);
        Log.i(TAG, sexo);

        /*Intent intent = new Intent(this, DisplayCadastroActivity.class);
        intent.putExtra(CadastroActivity.EXTRA_NOME, nome);
        intent.putExtra(CadastroActivity.EXTRA_NASCIMENTO, nascimento);
        intent.putExtra(CadastroActivity.EXTRA_ESTADO_CIVIL, estadoCivil);
        intent.putExtra(CadastroActivity.EXTRA_PROFISSAO, profissao);
        intent.putExtra(CadastroActivity.EXTRA_SEXO, sexo);*/

        Bundle extras = new Bundle();
        extras.putString(CadastroActivity.EXTRA_NOME, nome);
        extras.putString(CadastroActivity.EXTRA_NASCIMENTO, nascimento);
        extras.putString(CadastroActivity.EXTRA_ESTADO_CIVIL, estadoCivil);
        extras.putString(CadastroActivity.EXTRA_PROFISSAO, profissao);
        extras.putString(CadastroActivity.EXTRA_SEXO, sexo);

        Intent intent = new Intent(this, DisplayCadastroActivity.class);
        intent.putExtras(extras);

        startActivity(intent);
    }
}
