package activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import padilha.anna.lista.R;

public class NewItemActivity extends AppCompatActivity {

    static int PHOTO_PICKER_REQUEST = 1;
    Uri photoSelected = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item);

        ImageButton imgCI = findViewById(R.id.imbCI);
        imgCI.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent photoPickerIntent = new Intent(Intent.ACTION_OPEN_DOCUMENT); //intent implícito para abrir galeria
            photoPickerIntent.setType("image/*");
            startActivityForResult(photoPickerIntent, PHOTO_PICKER_REQUEST);
        }
    });
    }
}