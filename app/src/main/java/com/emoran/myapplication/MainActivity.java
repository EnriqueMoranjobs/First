package com.emoran.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private SwipeRefreshLayout swipeLayout;
    private WebView miVisorWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // TextView mycontext = (TextView) findViewById(R.id.textTap);
       // registerForContextMenu(mycontext);
        // casting a la vista a la que aplicamos un menu contextual
        // y la registramos
        //  WebView miVisorWeb = (WebView) findViewById(R.id.vistaweb);
        // abre un menu contextual con un tap largo
         miVisorWeb = (WebView) findViewById(R.id.vistaweb);
         registerForContextMenu(miVisorWeb);


        // DENTRO del Oncreate
        // cast al Layout SwipeRefresh con el que rodeamos la vista
        // en el xml y le colocamos un listener
        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.mySwipe);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);

//        //La vista dentro es un webview con permiso para zoom

        // miVisorWeb.setInitialScale(1);
        //miVisorWeb.getSettings().setJavaScriptEnabled(true);
        miVisorWeb.getSettings().setBuiltInZoomControls(true);
        miVisorWeb.loadUrl("https://thispersondoesnotexist.com");


    }

    // FUERA del Oncreate
    // construimos el Listener que lanza un Toast y desactiva a
    // continuación del Swipe la animación

    protected SwipeRefreshLayout.OnRefreshListener
            mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {

            final ConstraintLayout mlayout = findViewById(R.id.myMainConstraint);
            Snackbar snackbar = Snackbar
                    .make(mlayout, "fancy a Snack", Snackbar.LENGTH_LONG)
                    .setAction("Deshacer", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Snackbar snackbar1 = Snackbar.make(mlayout, "Accion restaurada", Snackbar.LENGTH_SHORT);
                            snackbar1.show();

                        }
                    });
            snackbar.show();

            miVisorWeb.reload();
            swipeLayout.setRefreshing(false);
        }
    };


    @Override

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
             /*   Toast toast = Toast.makeText(this,"going CONTEXT ITEM",
                        Toast.LENGTH_LONG );
                toast.show();
                return true; */
                final ConstraintLayout mlayout = findViewById(R.id.myMainConstraint);
                Snackbar snackbar = Snackbar
                        .make(mlayout, "fancy a Snack", Snackbar.LENGTH_LONG)
                        .setAction("Deshacer", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Snackbar snackbar1 = Snackbar.make(mlayout, "Accion restaurada", Snackbar.LENGTH_SHORT);
                                snackbar1.show();

                            }
                        });
                snackbar.show();
            case R.id.item2:
                Toast toast2 = Toast.makeText(this, "going CONTEXT SETTINGS",
                        Toast.LENGTH_LONG);
                toast2.show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }


    }
}