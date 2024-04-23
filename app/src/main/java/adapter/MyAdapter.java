package adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import activity.MainActivity;
import model.MyItem;
import padilha.anna.lista.R;

public class MyAdapter extends RecyclerView.Adapter {
    MainActivity mainActivity;
    List<MyItem> itens;
    public MyAdapter(MainActivity mainActivity, List<MyItem> itens){ //função para guardar o tamanho da lista e passar de uma act para outra
        this.mainActivity = mainActivity;
        this.itens = itens;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //cria os elementos da inerface para um obj que são guardados em VH
        LayoutInflater inflater = LayoutInflater.from(mainActivity); //le arquivoxml e cria elementos
        View v = inflater.inflate(R.layout.item_list,parent,false); //cria elementos de um item
        return new MyViewHolder(v); //guarda objeto View num objeto do tipo MyViewHolder
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) { //holder: guarda os itens de criados, position: qual elemento da lista
        MyItem myItem = itens.get(position); //pega posição do objeto
        View v = holder.itemView; //objeto do tipo View
        ImageView imvPhoto = v.findViewById(R.id.imvPhoto); //pega a foto
        imvPhoto.setImageURI(myItem.photo); //seta a foto

        TextView tvTitle = v.findViewById(R.id.tvTitle);
        tvTitle.setText(myItem.title);

        TextView tvDesc = v.findViewById(R.id.tvDesc);
        tvDesc.setText(myItem.description);
    }

    @Override
    public int getItemCount() { //quantos elementos a lista possui;

        return itens.size();
    }
}
