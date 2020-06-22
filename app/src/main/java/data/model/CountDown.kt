package data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.util.*

@Entity(tableName = "countdown_table")
data class CountDown(

    @PrimaryKey
    var uuid:String = UUID.randomUUID().toString(),

    @ColumnInfo(name = "date")
    var date:String = Date().toString(),

    @ColumnInfo(name = "title")
    var title: String = "title"){

    fun getFormatedDate():String{

        //e.g: Mon: 16/06/2020, 16:16"
        val format = SimpleDateFormat("EEE: dd/MM/yyyy, HH:mm")
        val dateFormat: String = format.format(Date(date))

        return dateFormat;
    }
}