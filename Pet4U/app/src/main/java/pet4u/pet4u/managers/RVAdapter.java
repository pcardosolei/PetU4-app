package pet4u.pet4u.managers;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pet4u.pet4u.R;

/**
 * Created by andregeraldes on 01/02/17.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.CardViewHolder>{
    List<Card> cards;

    public RVAdapter(List<Card> cards){
        this.cards = cards;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_eventos, parent, false);
        CardViewHolder cvh = new CardViewHolder(v);
        return cvh;
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        holder.text.setText(cards.get(position).texto);
        holder.data.setText(cards.get(position).data);
        holder.img.setImageResource(cards.get(position).iconId);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView text;
        TextView data;
        ImageView img;

        CardViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.card_view);
            text = (TextView)itemView.findViewById(R.id.card_txt);
            data = (TextView)itemView.findViewById(R.id.card_date);
            img = (ImageView)itemView.findViewById(R.id.card_img);
        }
    }
}