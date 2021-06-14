package id.topan.administrasisistemjaringan.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable


class DataMateri : Serializable {

    @field:SerializedName("judul_materi")
    val judulMateri: String? = null

//    private val materi = arrayOf(
//        "Silabus",
//        "Materi",
//        "Jobsheet",
//        "Video Tutorial",
//        "Latihan Soal",
//        "About"
//    )

//    val listData: ArrayList<DataMateri>
//        get() {
//            val list = arrayListOf<DataMateri>()
//            for (position in materi.indices) {
//                val materi = DataMateri()
//                materi.judulmateri = materi[position]
//                list.add(materi)
//            }
//            return list
//        }
}