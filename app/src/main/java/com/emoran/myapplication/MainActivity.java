package com.emoran.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
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

    //-------------------------------------------------------------------------------------------------
    //Dialogo modal
    public void showAlertDialogButtonClicked(MainActivity mainActivity) {

        // setup the alert builder
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);
        //el dialogo estandar tiene título/icono pero podemos sustituirlo por un XML a medida
        builder.setTitle("Achtung!");
        builder.setMessage("Where do you go?");
        builder.setIcon(R.drawable.icono_descarga);
        builder.setCancelable(false);


//       // un XML a medida para el diálogo
        // builder.setView(getLayoutInflater().inflate(R.layout.alertdialog_view, null));
        // add the buttons
        builder.setPositiveButton("Signup", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // do something like...
                Intent intent = new Intent(MainActivity.this, SignUp.class);
                startActivity(intent);
                dialog.dismiss();

            }
        });

        builder.setNegativeButton("Do nothing", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                // do something like...

                dialog.dismiss();
            }
        });

        builder.setNeutralButton("Other", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                // do something like...

                dialog.dismiss();
            }
        });

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
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

    //implementing ActionBar/AppBar menu
    //añadimos appbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_top, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.idLupita) {
//            showAlertDialogButtonClicked(Main.this);

            Toast toast = Toast.makeText(this, "Infecting", Toast.LENGTH_LONG);
            toast.show();
            //llamada al metodo para dialogo modal
            showAlertDialogButtonClicked(MainActivity.this);

        }
        if (id == R.id.idDesacarga) {
            Toast toast = Toast.makeText(this, "Fixing", Toast.LENGTH_LONG);
            toast.show();
        }

        // if (id == R.id.item4) {
        //    showAlertDialogButtonClicked(Main.this);
        //  }

        return super.onOptionsItemSelected(item);
    }

    // implements context menu
    //@Override
    //  public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
    //     super.onCreateContextMenu(menu, v, menuInfo);
    //   MenuInflater inflater = getMenuInflater();
    //   inflater.inflate(R.menu.menu_context, menu);
    //  }

    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {

        getMenuInflater().inflate(R.menu.menu_context, menu);

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
                Toast toast2 = Toast.makeText(this, "downloading item",
                        Toast.LENGTH_LONG);
                toast2.show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }

    }

}


