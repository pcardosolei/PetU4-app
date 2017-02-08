package pet4u.pet4u.managers;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pet4u.pet4u.R;

/**
 * Created by Rafael on 06/02/2017.
 */

public class RVAdapterAnimal  extends RecyclerView.Adapter<RVAdapterAnimal.CardViewHolderAnimal>{

    List<AnimalCard> cards;

    public RVAdapterAnimal(List<AnimalCard> cards){
        this.cards = cards;
    }


    @Override
    public RVAdapterAnimal.CardViewHolderAnimal onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_animais, parent, false);
        return new RVAdapterAnimal.CardViewHolderAnimal(v);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onBindViewHolder(RVAdapterAnimal.CardViewHolderAnimal holder, int position) {
        try {
            holder.text.setText(cards.get(position).nome);
            holder.img.setImageDrawable(cards.get(position).drawable);
        }catch (Exception e){
            Log.e("RVAdapterAnimal",e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    public static class CardViewHolderAnimal extends RecyclerView.ViewHolder {
        CardView cv;
        TextView text;
        ImageView img;

        CardViewHolderAnimal(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.card_view);
            text = (TextView) itemView.findViewById(R.id.card_txt);
            img = (ImageView) itemView.findViewById(R.id.card_img);
        }
    }
}



