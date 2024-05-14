package model;

import java.util.ArrayList;
import java.util.List;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel{ //ViewModel guarda os dados de uma Activity e  MainActivityViewModel guarda lista de itens
    List<MyItem> itens = new ArrayList<>();

    public List<MyItem> getItens() { //método get pega a lista de itens
        return itens;
    }
}
