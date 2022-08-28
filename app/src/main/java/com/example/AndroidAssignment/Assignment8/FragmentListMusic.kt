package com.example.AndroidAssignment.Assignment8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.AndroidAssignment.Assignment5.SendRcvToDetail
import com.example.AndroidAssignment.Assignment7.Foods
import com.example.AndroidAssignment.Assignment7.RcvFragmentDirections
import com.example.AndroidAssignment.Assignment7.rcvAdapter
import com.example.AndroidAssignment.Assignment8.ForeGroundService.Companion.startService
import com.example.kotlinassignment.R

class FragmentListMusic(private var click: Click?) : Fragment() {

    val listmusic : ArrayList<Music> = ArrayList()
    val adapterRecycle = ListMusicAdapter(listmusic)
    val linearLayoutManager = LinearLayoutManager(context)
    var recycleViewFood : RecyclerView? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_list_music, container, false)

        recycleViewFood = view.findViewById(R.id.fragMusic)
        recycleViewFood?.adapter = adapterRecycle
        recycleViewFood?.layoutManager = linearLayoutManager

        listmusic.add(Music(R.drawable.three_points,"Đoạn tuyệt nàng đi","04:33","Hà Anh Tuấn",273, true,R.raw.doantuyetnangdi))
        listmusic.add(Music(R.drawable.three_points,"Music","05:06","Nguyễn Hải Phong",306, true,R.raw.music))
        listmusic.add(Music(R.drawable.three_points,"Number 4321","04:42","Châu Khải Phong",282, true,R.raw.number))
        listmusic.add(Music(R.drawable.three_points,"For Your Future  陽山偉偉  送给未来的你","03:52","Andiez x Biti's Hunter",232, true,R.raw.foryourfuture))
        listmusic.add(Music(R.drawable.three_points,"Star Sky Remix阳山伟伟  星空","06:15","Châu Khải Phong",375, true,R.raw.starsky))
        listmusic.add(Music(R.drawable.three_points,"Two step from hell","03:35","Soobin Hoàng Sơn",215, true,R.raw.twostepfromhell))
        listmusic.add(Music(R.drawable.three_points,"Victory","10:52","Tăng Phúc",652, true,R.raw.victory))
        listmusic.add(Music(R.drawable.three_points,"Waiting For Love  Romy Wave ","04:33","Hà Anh Tuấn",273, true,R.raw.waitingforlove))
        listmusic.add(Music(R.drawable.three_points,"Windy Hill Piano  Remix","04:26","Thanh Bình,266",266, true,R.raw.windyfill))
        listmusic.add(Music(R.drawable.three_points,"Nếu ngày ấy","05:34","Soobin Hoàng Sơn",334, true,R.raw.music))
        listmusic.add(Music(R.drawable.three_points,"Hơn cả yêu","04:56","Đức Phúc",296, true,R.raw.music))
        listmusic.add(Music(R.drawable.three_points,"Chúng ta của hiện tại","04:12","Sơn Tùng",252, true,R.raw.music))
        listmusic.add(Music(R.drawable.three_points,"Yêu xa khó lắm","01:16","No singer",76, true,R.raw.music))
        listmusic.add(Music(R.drawable.three_points,"Yến vô hiết","03:55","是七叔呢",235, true,R.raw.music))
        listmusic.add(Music(R.drawable.three_points,"Thái thế","04:52","Hương Ly",292, true,R.raw.music))
        listmusic.add(Music(R.drawable.three_points,"Níu duyên","03:12","Lê Bảo Bình",192, true,R.raw.music))
        listmusic.add(Music(R.drawable.three_points,"Chúng ta dường lại ở đây thôi","04:20","Nguyễn Đình Vũ",260, true,R.raw.music))
        listmusic.add(Music(R.drawable.three_points, " ", " ", " ",0, true,R.raw.music))
        listmusic.add(Music(R.drawable.three_points, " ", " ", " ",0, true,R.raw.music))

        adapterRecycle.onItemClick = {
            var rcvFood = it
            click?.close()
            click?.click(rcvFood)
        }
        return view
    }

}