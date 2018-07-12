package event


class ItemArgs(val values: Array<String>, val type : Int) {
    var tvNames  = values
    var ivSrc  = type
}


class Event(Args : ItemArgs){
    var args = Args
    var description : String = ""
    var place : String = ""
    var freeTickets : Int = 0
}