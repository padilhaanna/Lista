package activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import adapter.MyAdapter;
import model.MyItem;
import padilha.anna.lista.R;

public class MainActivity extends AppCompatActivity {
    static int NEW_ITEM_REQUEST =1;
    List<MyItem> itens = new ArrayList<>();
    static int PHOTO_PICKER_REQUEST = 1;
    MyAdapter myAdapter;
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
        RecyclerView rvItens = findViewById(R.id.rvItens); // pega recyclerview ->

        myAdapter = new MyAdapter(this, itens); //cria myAdapter
        rvItens.setAdapter(myAdapter); //seta no rv, para agora saber como construir itens da lista

        rvItens.setHasFixedSize(true); //diz que tamanho não varia

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this); //faz com que listas apareçam de forma linear, na vertical
        rvItens.setLayoutManager(layoutManager); //seta no rv

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rvItens.getContext(), DividerItemDecoration.VERTICAL); //linha separando cada item
        rvItens.addItemDecoration(dividerItemDecoration); //seta no rv

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) { //função
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == NEW_ITEM_REQUEST){ //se o resultado está dentro dos parâmetros
            if(resultCode == Activity.RESULT_OK){//codigo ok
                MyItem myItem = new MyItem(); //MyItem guarda os dados vindos de NewItemActivity
                myItem.title = data.getStringExtra("title");
                myItem.description= data.getStringExtra("desc");
                myItem.photo = data.getData();
                itens.add(myItem);
                myAdapter.notifyItemInserted(itens.size()-1); //atualiza o recycle view
            }
        }
    }//ViewModels: os itens não ficam mais salvos na activity e sim nesse view model,
    //quando destruir a activity o viewmodel não é destruído ent os dados não se perdem
}