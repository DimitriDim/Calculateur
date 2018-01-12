package fr.m2i.calculateur;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;

import java.util.Locale;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    TextView txtAffichage, txtAffichageConv;
    String appuiTouche = "";
    String chaineCalc = "";
    boolean point, RAZ;
    Button btPoint, btPlus, btMois, btMulti, btDiv;
    TextToSpeech tts;
    private final int REQUEST_CODE_LIRE = 1;
    boolean TTS_OK = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btPoint = (Button) findViewById(R.id.btnPoint);
        btPlus = (Button) findViewById(R.id.btnPlus);
        btMois = (Button) findViewById(R.id.btnMoins);
        btMulti = (Button) findViewById(R.id.btnMultip);
        btDiv = (Button) findViewById(R.id.btnDiv);
        point = true;
        RAZ = false;

        //TTS = Text To Speach
        // On test si un synthétiseur vocal est présent
        Intent intLire = new Intent(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        //on pose la question avec startActivityForResult
        startActivityForResult(intLire, REQUEST_CODE_LIRE);
    }

    public void btnEffacer(View v) {
        txtAffichage = findViewById(R.id.txtAffichage);
        chaineCalc = "";
        txtAffichage.setText("0");
        btPoint.setEnabled(true);
        tts.speak("Effacer", TextToSpeech.QUEUE_FLUSH, null, null);
    }

    public void touche(View v) {

        if (RAZ == true) {
            chaineCalc = "";
            RAZ = false;
        }
        txtAffichage = findViewById(R.id.txtAffichage);

        if (v == findViewById(R.id.btn0)) {
            appuiTouche = "0";
            btMois.setEnabled(true);
            btDiv.setEnabled(true);
            btPlus.setEnabled(true);
            btMulti.setEnabled(true);
            if (point == true) {
                btPoint.setEnabled(true);
            }

        }
        if (v == findViewById(R.id.btn1)) {
            appuiTouche = "1";
            btMois.setEnabled(true);
            btDiv.setEnabled(true);
            btPlus.setEnabled(true);
            btMulti.setEnabled(true);
            if (point == true) {
                btPoint.setEnabled(true);
            }
        }
        if (v == findViewById(R.id.btn2)) {
            appuiTouche = "2";
            btMois.setEnabled(true);
            btDiv.setEnabled(true);
            btPlus.setEnabled(true);
            btMulti.setEnabled(true);
            if (point == true) {
                btPoint.setEnabled(true);
            }
        }
        if (v == findViewById(R.id.btn3)) {
            appuiTouche = "3";
            btMois.setEnabled(true);
            btDiv.setEnabled(true);
            btPlus.setEnabled(true);
            btMulti.setEnabled(true);
            if (point == true) {
                btPoint.setEnabled(true);
            }
        }
        if (v == findViewById(R.id.btn4)) {
            appuiTouche = "4";
            btMois.setEnabled(true);
            btDiv.setEnabled(true);
            btPlus.setEnabled(true);
            btMulti.setEnabled(true);
            if (point == true) {
                btPoint.setEnabled(true);
            }
        }
        if (v == findViewById(R.id.btn5)) {
            appuiTouche = "5";
            btMois.setEnabled(true);
            btDiv.setEnabled(true);
            btPlus.setEnabled(true);
            btMulti.setEnabled(true);
            if (point == true) {
                btPoint.setEnabled(true);
            }
        }
        if (v == findViewById(R.id.btn6)) {
            appuiTouche = "6";
            btMois.setEnabled(true);
            btDiv.setEnabled(true);
            btPlus.setEnabled(true);
            btMulti.setEnabled(true);
            if (point == true) {
                btPoint.setEnabled(true);
            }
        }
        if (v == findViewById(R.id.btn7)) {
            appuiTouche = "7";
            btMois.setEnabled(true);
            btDiv.setEnabled(true);
            btPlus.setEnabled(true);
            btMulti.setEnabled(true);
            if (point == true) {
                btPoint.setEnabled(true);
            }
        }
        if (v == findViewById(R.id.btn8)) {
            appuiTouche = "8";
            btMois.setEnabled(true);
            btDiv.setEnabled(true);
            btPlus.setEnabled(true);
            btMulti.setEnabled(true);
            if (point == true) {
                btPoint.setEnabled(true);
            }
        }
        if (v == findViewById(R.id.btn9)) {
            appuiTouche = "9";
            btMois.setEnabled(true);
            btDiv.setEnabled(true);
            btPlus.setEnabled(true);
            btMulti.setEnabled(true);
            if (point == true) {
                btPoint.setEnabled(true);
            }
        }
        if (v == findViewById(R.id.btnPlus)) {
            appuiTouche = "+";
            btMois.setEnabled(false);
            btDiv.setEnabled(false);
            btPlus.setEnabled(false);
            btMulti.setEnabled(false);
            point = true;
        }
        if (v == findViewById(R.id.btnMultip)) {
            appuiTouche = "*";
            btMois.setEnabled(false);
            btDiv.setEnabled(false);
            btPlus.setEnabled(false);
            btMulti.setEnabled(false);
            point = true;
        }
        if (v == findViewById(R.id.btnDiv)) {
            appuiTouche = "/";
            btMois.setEnabled(false);
            btDiv.setEnabled(false);
            btPlus.setEnabled(false);
            btMulti.setEnabled(false);
            point = true;
        }
        if (v == findViewById(R.id.btnPoint)) {
            appuiTouche = ".";
            btPoint.setEnabled(false);
            btMois.setEnabled(false);
            btDiv.setEnabled(false);
            btPlus.setEnabled(false);
            point = false;

        }
        if (v == findViewById(R.id.btnMoins)) {
            appuiTouche = "-";
            btMois.setEnabled(false);
            btDiv.setEnabled(false);
            btPlus.setEnabled(false);
            btMulti.setEnabled(false);
            point = true;
        }

        chaineCalc = chaineCalc + appuiTouche;
        txtAffichage.setText(chaineCalc.toString());
        tts.speak(appuiTouche.toString(), TextToSpeech.QUEUE_FLUSH, null, null);
    }


    public void convDevise(View v) {

        int tauxEuros = 1;
        double tauxDollars = 1.185;
        double tauxLivres = 0.88;
        double tauxBitcoins = 0.0001;
        double resulConv;

        txtAffichageConv = findViewById(R.id.txtAffichage);
        Integer chaineDev;
        chaineDev = Integer.parseInt(chaineCalc);


        if (v == findViewById(R.id.rbEur)) {
            resulConv = chaineDev * tauxEuros;
            txtAffichageConv.setText(Double.toString(resulConv) + " €");
        }
        if (v == findViewById(R.id.rbUSD)) {
            resulConv = chaineDev * tauxDollars;
            txtAffichageConv.setText(Double.toString(resulConv) + " $");
        }
        if (v == findViewById(R.id.rbLivres)) {
            resulConv = chaineDev * tauxLivres;
            txtAffichageConv.setText(Double.toString(resulConv) + " £");
        }
        if (v == findViewById(R.id.rdBTC)) {
            resulConv = chaineDev * tauxBitcoins;
            txtAffichageConv.setText(Double.toString(resulConv) + " ฿");
        }


    }

    public void convDeg(View v) {

        double resulConv;
        txtAffichageConv = findViewById(R.id.txtAffichage);
        Integer chaineDev;
        chaineDev = Integer.parseInt(chaineCalc);


        if (v == findViewById(R.id.rbRad)) {
            resulConv = chaineDev * (3.14 / (180));
            txtAffichageConv.setText(Double.toString(resulConv));
        }
        if (v == findViewById(R.id.rbGrd)) {
            resulConv = chaineDev * (100 / 90);
            txtAffichageConv.setText(Double.toString(resulConv));
        }
        if (v == findViewById(R.id.rbDeg)) {
            resulConv = chaineDev;
            txtAffichageConv.setText(Double.toString(resulConv));
        }

    }

    public void result(View v) {
        Evaluator eval = new Evaluator();
        try {
            txtAffichage.setText(eval.evaluate(chaineCalc));
            RAZ = true;
            tts.speak(txtAffichage.getText().toString(), TextToSpeech.QUEUE_FLUSH, null, null);
        } catch (EvaluationException e) {
            e.printStackTrace();
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_LIRE) {
            if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {
                Toast.makeText(this, "Synthétiseur ok", Toast.LENGTH_LONG).show();
                TTS_OK = true;

                // le 2e this est la classe MainActivity qu'on vient d'implémenter en écouteur, sinon pas possible
                tts = new TextToSpeech(this, this);

            } else {
                Toast.makeText(this, "Synthétiseur KO :(", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onInit(int status) {

    }
}
