package activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import padilha.anna.lista.R;

public class NewItemActivity extends AppCompatActivity {

    static int PHOTO_PICKER_REQUEST = 1;
    Uri photoSelected = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item);

        NewItemActivityViewModel vm = new ViewModelProvider(this).get(NewItemActivityViewModel.class); //declarando o vm
        Uri selectPhotoLocation = vm.getSelectPhotoLocation(); //pegando o enderço da imagem no vm
        if(selectPhotoLocation != null){
            ImageView imvphotoPreview = findViewById(R.id.imvPhotoPreview);
            imvphotoPreview.setImageURI(selectPhotoLocation);
        }

        ImageButton imgCI = findViewById(R.id.imbCI); //pega botao
        imgCI.setOnClickListener(new View.OnClickListener() { //ouvidor de click pro botao
            @Override
            public void onClick(View v) {
                if (photoSelected == null) { //condição para verificar se foto foi selecionada
                    Toast.makeText(NewItemActivity.this, "É necessário selecionar uma imagem!", Toast.LENGTH_LONG).show();//se nao, exibe mensagem
                    return;
                }

                EditText etTitle = findViewById(R.id.etTitle);
                String title = etTitle.getText().toString();
                if (title.isEmpty()) {//condição para verificar se titulo foi preenchido
                    Toast.makeText(NewItemActivity.this, "É necessário inserir um título", Toast.LENGTH_LONG).show();
                    return;
                }

                EditText etDesc = findViewById(R.id.etDesc);
                String description = etDesc.getText().toString();
                if (description.isEmpty()) { //condição para verificar se descrição foi preenchida
                     Toast.makeText(NewItemActivity.this, "É necessário inserir uma descrição", Toast.LENGTH_LONG).show();
                     return;
                }

                Intent i = new Intent(); //intent guarda dados que vão voltar para exibir na main
                i.setData(photoSelected); //seta uri da imagem
                i.putExtra("title", title); //seta titulo
                i.putExtra("description", description); //seta descrição
                setResult(Activity.RESULT_OK, i); //indica resultado
                finish();//finaliza activity
                }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data); //requestCode: id chamada - resultCode: se Activity retornou - data: dados retornados


        if(requestCode == PHOTO_PICKER_REQUEST){ //identifica se seleciou uma foto
            if(resultCode == Activity.RESULT_OK){ //codigo ok
                Uri photoSelected = data.getData(); //se tudo ok, pega os dados
                ImageView imvphotoPreview = findViewById(R.id.imvPhotoPreview); //pega a imagem
                imvphotoPreview.setImageURI(photoSelected); //pega foto selecionada e coloca para exibir

                NewItemActivityViewModel vm = new ViewModelProvider(this).get(NewItemActivityViewModel.class);
                vm.setSelectPhotoLocation(photoSelected); //exi na tela
            }
        }
    }
}