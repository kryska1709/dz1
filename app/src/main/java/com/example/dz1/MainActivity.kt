package com.example.dz1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.dz1.ui.theme.Dz1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Dz1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier
                        .padding(innerPadding)
                        .background(Color.Black)
                        ) {
                        Cinemas()
                    }
                }
            }
        }
    }
}

enum class Prioritys(){
    Low,
    Medium,
    High
}
data class Cinema(
    val name: String,
    val image: String,
    val priority: Prioritys
)
@Composable
fun Cinemas() {
    val cinemaList = listOf<Cinema>(
        Cinema("Властелин колец", "https://vkplay.ru/hotbox/content_files/Stories/2024/04/25/47bd73f97a664157a124609b52a6b2b7.jpg", Prioritys.High),
        Cinema("Хоббит","https://avatars.mds.yandex.net/i?id=58b6c1d4e996dbe9ef19164d3a6f173c_l-10355200-images-thumbs&n=13", Prioritys.High),
        Cinema("Аватар легенда об Аанге","https://lastfm.freetls.fastly.net/i/u/ar0/f2b1d6e87ad207cc70fddfe1f66956f9.jpg", Prioritys.High),
        Cinema("Волшебный меч: Спасение камелота","https://static.okko.tv/images/v4/91273cee-902e-4443-8391-a32aacfd1a04?presetId=4000&amp;width=1200&amp;height=630&amp;scale=1&amp;quality=80", Prioritys.High),
        Cinema("Динозавр","https://yandex-images.clstorage.net/e52seN198/551a5ch8jbt/tnvIltCDbGoU6VKkocqvEDZ_c__NwC6eUY8KG8GbhBM79q4MbOhcub1C7hR_GsZP1I4kHdA4V294_je-4XWivKOo3EYCQ61oUHsVoDEOrFNmvHZrXkE9StMPCxqaFA1b528wFPJ0QmQ7QjiBa52B3hCA_kza_EOutWf4-7pv8yK4vc1f3ZEjI16_XK6kSGRepzA5flBEM9bQWNHEXNdBneyhtlR6NcOutcu6RKTQ0ZJVRTycEvDE5TVntPB-bTxovLjLmNQcLO5R-pckpwIk3yz-MDHYirCf0BYXghFRAxFvKbMbMbQFb_WIPsogV5MRU4Wy2Rd4y-t-anZ9t-x1afo_DpIR3WxiE34eKS7P6N7pPfP5UEE7WFjTlowdWMTQoWU-2v4xDiw-Sj1KL1mU0NtFvBxfPcZnfKd8t7Cssim3uwpQEFOkYtN41GhqxS9aLzrwcdyJutpS21SIFlrEEq0tsRwyd4BnMwe9AWKeGtnYzL0d1XEGZjzqvHm5ZXNtN3fOnlTdZihRf1XnY8ZkH6w6vjOTQrxU1VPXh9zfDl-qZT9Z_HkNpnFA8AjuEJNbnAUx1t25i2v8I3mxdud6rLW0TJmckG9h2P-dIOnAL55vOTu5GkjzF9gU2c9XUMOV6ms5Hfr4iu7xj3KL5pgZFJREv96aMgoqdaawtzAsPiu09IMWFNIirhmz3i1sym8aIX768diP9VFWnFoLUdXFUuNtf949_84qfwmzhe8RXNYcyTpQFP4D4v0vuX63ZTuuc7OJFt2bo-oRcdRopwfkGmwycjJUTrJR0tuTzVcagZKvrHKd9PHJq72HNwiqVh-YFsozX9RzAmw8YLAxuCW6ozN4i5tdWavjUjsUJ6nKoBvuPHMyHEg_Eh7UGoOQm4QbZyb_krI5zqT-Ab1JLxlZ0NPP9JFc8wHsciJ-NjbsP-R0dUJZnBTvb9v3UGruxuaTpvD4sl5LtB6TkpcIGE",Prioritys.High),
        Cinema("Гравити Фолз","https://avatars.mds.yandex.net/i?id=ffae54b077e5289a6b3a38fe13e5cb38_l-9145122-images-thumbs&n=13",Prioritys.Low),
        Cinema("Алиса в стране чудес","https://cdn.culture.ru/images/3a07cb74-f4c2-5e81-b526-e9725f00b808",Prioritys.Medium),
        Cinema("Сверхъестественное","https://avatars.mds.yandex.net/get-kinopoisk-image/1900788/33f9e1e7-6901-42fc-b8cd-6c5d92c4a09a/1920x",Prioritys.High),
        Cinema("Десятое Королевство","https://avatars.mds.yandex.net/i?id=044cc53431dce38bf8e433007b6efdcb_l-8607024-images-thumbs&n=13", Prioritys.High),
        Cinema("Атака титанов","https://m.media-amazon.com/images/I/91-09sUYpvL._AC_UL800_QL65_.jpg",Prioritys.High),
        Cinema("Пираты карибского моря","https://i.pinimg.com/originals/d8/cc/5d/d8cc5d2485a3a9f20788d87763724ba8.jpg",Prioritys.Medium),
        Cinema("Астрал","https://static.okko.tv/images/v4/dbf9a98a-28dc-41d4-b677-2c89d6f0bca9",Prioritys.Medium),
        Cinema("Омен","https://m.media-amazon.com/images/M/MV5BNDhhMTBlODEtMGIxOC00MzVjLTllMzctY2NkMWNmODY3MWZmXkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg",Prioritys.Low),
        Cinema("Ванильное небо","https://yandex-images.clstorage.net/e52seN198/551a5ch8jbt/tnvIltCDbGoU6VKkocqvEDZ_c__NwC6eUY8e28GaRcavNe7Y7avceryUO8CqTlKOAVkkiEQsFLn4f_e-4XSjviKqXoRHEqxrUfuQN6dJqxVleCM6nUZvn4fMC4GaE41bICs3UjH3w6n9QfoBLMgW39oA4ZdVucOitSp-NbwkfCa1O0VblZznZZWynqLhgabU6Tc2NJhI85zQFtVHWV9LUO6td9pwdgkndMM_zmGYWpofwjFfWT6IIrVmdfG-6zYisD2CUhiTKmrQeRShq8EnXyc-ebxWy7qcntCTCt8dx9NmqDiR8bDIZzdHsUrm2tmc30x0WtExhmm4pPg4P6I3ZDf4iJfZ06YoVPAZKGYNJprk_bE0nUB9FFtRnQbW2gYdKiX5XnS7i6z1RDFF6N0YFB9CsRKUPAprda4yP39ldymz_EqWVxum6FI6WGxsyqJc4_45uFXB_x5Tk5kN1NrEEWKqP5IyNcChuMR6CC9TEReWQ7CY2PwLKzhu_Da2pDOpfziE0tnZ7GpVu9dlb4Hn3-Owe_eex3GZ2xCWx1EQiRYqJHpcPLgB4_-Jc4Sh2pNTX897kBBxBuvxqzT5NK3yK7y6gxqU0KXj1XMQ72nKZhzgNfF-lIgylJwe3kze3UNWJCI-Wr0_SWMwC_CMKVDcWx5Bc9eb8EdidGIyv__pdSr8dQyS1p1qIpkwHWpjiuJSp_S5vFOOdBoUnRpKW9uEXyJk_Z26e43ttsr-haAVHtOTxP1ZV_mP6v1r-zi27PDtu38MW58cLipbOlihrgHiH-t8ejCSyXSeU1TcTJSfRBPjab5UtHwMLzhOc8DnVlDZkM3ymdr4ASuyYrQ39m39rXB9gdtdFCdpEfoXr2NF453lfXp4lEQ3UlzdkosVms3baeSxEnx7A2y-xDJFqBAYHJUKPBFa-4Fl8KyzuT_ouup9tEMaEFCr4N2-WuhvA2vVKfb6OpfPO98aUBkD3I", Prioritys.Low),
        Cinema("Феррари","https://m.media-amazon.com/images/M/MV5BMDYwZjVhODQtNTU4Mi00MzQ3LWFhMjQtZTY2NTYxMDBjZmQ1XkEyXkFqcGc@._V1_.jpg",Prioritys.Low)
    )
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(22.dp)
    ) {
        item {
            Text(
                text = "Любимый кинематограф",
                color = Color.White,
                fontSize = 33.sp,
                fontWeight = FontWeight(11),
            )
        }
        items(cinemaList.sortedByDescending { it.priority })
        {
                Text(text = it.name,
                    modifier = Modifier.padding(18.dp),
                    fontSize = 28.sp,
                    color = Color.Cyan,
                    fontWeight = FontWeight(9))
                AsyncImage(
                    model = it.image,
                    modifier = Modifier.fillMaxSize(),
                    contentDescription = null
                )
            }
        }
}

