package listItem

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.lilik.myapplication.*
import event.*

class OnItemClickListener( arg: Event){
    val currentEvent : Event = arg
    fun onClick(state : Bundle?){
        val eventDescriptionActivity : EventDescription = EventDescription()
        eventDescriptionActivity.onCreate(state)
        eventDescriptionActivity.setEvent(currentEvent)
    }
}
class MyAdapter(val values:List<Event>, state : Bundle?): RecyclerView.Adapter<MyAdapter.ViewHolder>(){
    val currentState = state
    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.tVday.text = values[p1].args.tvNames[0]
        p0.tVmonth.text = values[p1].args.tvNames[1]
        p0.tVtime.text = values[p1].args.tvNames[2]
        p0.iVavatar.setImageResource(values[p1].args.ivSrc)
        p0.tVname.text = values[p1].args.tvNames[3]
        p0.tVplace.text = values[p1].args.tvNames[4]
        p0.tVprice.text = values[p1].args.tvNames[5]
        val listener : OnItemClickListener = OnItemClickListener(values[p1])
        p0.itemView.setOnClickListener(View.OnClickListener() {
             fun onClick(v:View) {
                listener.onClick(currentState)
            }})

    }

    override fun getItemCount() = values.size

    override fun onCreateViewHolder(p0: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(p0.context).inflate(R.layout.list_item_view, p0, false)
        return ViewHolder(itemView)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var tVday: TextView = itemView.findViewById(R.id.day_tv)
        var tVmonth: TextView = itemView.findViewById(R.id.month_tv)
        var tVtime: TextView = itemView.findViewById(R.id.time_tv)
        var iVavatar : ImageView = itemView.findViewById(R.id.avatar_iv)
        var tVname : TextView = itemView.findViewById(R.id.name_tv)
        var tVplace : TextView = itemView.findViewById(R.id.place_tv)
        var tVprice : TextView = itemView.findViewById(R.id.price_tv)

    }
}