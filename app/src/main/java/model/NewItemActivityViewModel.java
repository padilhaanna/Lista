package model;

import android.net.Uri;

import androidx.lifecycle.ViewModel;

public class NewItemActivityViewModel extends ViewModel {
    Uri selectPhotoLocation = null; //guarda o endereço uri da foto, garante q imagem continue aparecendo ao rotacionar

    public Uri getSelectPhotoLocation(){
        return selectPhotoLocation;
    }

    public void setSelectPhotoLocation(Uri selectPhotoLocation) { //seta endereço URI dentro do ViewModel
        this.selectPhotoLocation = selectPhotoLocation;
    }
}
