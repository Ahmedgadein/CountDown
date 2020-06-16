package data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.util.*

@Entity(tableName = "countdown_table")
data class CountDown(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val uuid: UUID = UUID.randomUUID(),

    @ColumnInfo(name = "date")
    val date:Date = Date(),

    @ColumnInfo(name = "title")
    val title: String = "title"){

    fun getFormatedDate():String{

        //e.g: Mon: 16/06/2020, 16:16"
        val format = SimpleDateFormat("EEE: dd/MM/yyyy, HH:mm")
        val dateFormat: String = format.format(date)

        return dateFormat;
    }
}