package com.example.hudway.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.example.hudway.MapsActivity
import com.example.hudway.R
import com.example.hudway.databinding.FragmentMainHeaderBinding
import com.example.hudway.interfaces.NavigationPasser
import com.google.android.gms.maps.model.LatLng
import java.io.File
import java.net.HttpURLConnection
import java.net.URL
import java.nio.charset.Charset
class marshrut (
    var lng: Double,
    var lat: Double,
    var angle: Double,
    var weather: Double
)
class MainHeaderFragment : Fragment() {

    private var binding : FragmentMainHeaderBinding? = null
    private var navigationPasser : NavigationPasser? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is NavigationPasser) {
            navigationPasser = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        navigationPasser = activity as NavigationPasser
        val view = inflater.inflate(R.layout.fragment_main_header,container,false)
        binding = FragmentMainHeaderBinding.bind(view)
            .apply {
                navBtn.setOnClickListener {
                    val marsh = createMarshrut()
                    navigationPasser?.passCoords(LatLng(2.4, 3.3), LatLng(2.2, 3.3))
                }

                locateBtn.setOnClickListener {
                    //Not Implemented
                }
            }
        return view
    }
    fun createMarshrut(): String {
        val list = listOf<marshrut>(
            marshrut(
                53.17567799999999778037818032316863536834716796875,
                56.87154799999999710280462750233709812164306640625,
                0.0,
                0.90000000000000002220446049250313080847263336181640625
            ),
            marshrut(
                53.18063699999999727197064203210175037384033203125,
                56.869450000000000500222085975110530853271484375,
                62.25999999999999801048033987171947956085205078125,
                0.90000000000000002220446049250313080847263336181640625
            ),
            marshrut(
                0.90000000000000002220446049250313080847263336181640625,
                56.876204999999998790372046642005443572998046875,
                88.2699999999999960209606797434389591217041015625,
                0.90000000000000002220446049250313080847263336181640625
            ),
            marshrut(
                53.18235800000000068621375248767435550689697265625,
                56.87632800000000088402885012328624725341796875,
                0.0,
                56.87632800000000088402885012328624725341796875
            )
        )
        return list.joinToString()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
        navigationPasser = null
    }
}
