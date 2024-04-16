package activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import padilha.anna.lista.R;

public class MainActivity extends AppCompatActivity {
    static int NEW_ITEM_REQUEST =1;
    static int PHOTO_PICKER_REQUEST = 1;
    //Uri photoSelected = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton fabAddItem = findViewById(R.id.fabAddNewItem); //pega o botão
        fabAddItem.setOnClickListener(new View.OnClickListener() { //pega os clicks

        @Override
        public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, NewItemActivity.class); //intent explícito (navegar para outra página)
                startActivityForResult(i, NEW_ITEM_REQUEST); //determina que NewItemAcitivity irá retornar dados para a main (NEW_ITEM - id de chamada)

        }
    });



    }
}