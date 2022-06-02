package com.example.deeplinking;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class LinkReceiverActivity extends Activity {

    private static String GALATASARAY = "Galatasaray";
    private static String BESIKTAS = "Besiktas";
    private static String ORDUSPOR = "Orduspor";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        finish();

        Intent intent = getIntent();

        // mobilhanem.com/takim/ dan sonra gelecek olan değeri parse edip hangi activity ile ilişkili ise onu açtırıyoruz.

        String intentData = intent.getDataString();
        if (intentData != null && Intent.ACTION_VIEW.equals(intent.getAction())) {
            String param= intentData.substring(intentData.lastIndexOf("/") + 1);
            Intent i = null;
            if (GALATASARAY.equals(param)){
                i = new Intent(this,GalatasarayAct.class);
            }else if(BESIKTAS.equals(param)){
                i = new Intent(this,BesiktasAct.class);
            }else if(ORDUSPOR.equals(param)) {
                i = new Intent(this,OrdusporAct.class);
            }
            startActivity(i);
        }
    }
}