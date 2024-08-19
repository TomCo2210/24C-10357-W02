package dev.tomco.a24c_10357_w02.model

import dev.tomco.a24c_10357_w02.R

class DataManager {
    companion object {
        private val names = arrayOf(
            "El Salvador",
            "Qatar",
            "Dominican Republic",
            "Djibouti",
            "Luxembourg",
            "Jordan",
            "Somalia",
            "Greenland",
            "Angola",
            "Chile",
            "Venezuela",
            "United Arab Emirates",
            "Macao",
            "Haiti",
            "Malaysia",
            "Iraq",
            "Maldives",
            "United States",
            "Yemen",
            "Thailand"
        )
        private val flagImages = intArrayOf(
            R.drawable._015_el_salvador,
            R.drawable._026_qatar,
            R.drawable._047_dominican_republic,
            R.drawable._068_djibouti,
            R.drawable._035_luxembourg,
            R.drawable._077_jordan,
            R.drawable._083_somalia,
            R.drawable._113_greenland,
            R.drawable._117_angola,
            R.drawable._131_chile,
            R.drawable._139_venezuela,
            R.drawable._151_united_arab_emirates,
            R.drawable._167_macao,
            R.drawable._185_haiti,
            R.drawable._118_malasya,
            R.drawable._020_iraq,
            R.drawable._225_maldives,
            R.drawable._226_united_states,
            R.drawable._232_yemen,
            R.drawable._238_thailand,
        )
        private val canEnter = booleanArrayOf(
            true,
            false,
            true,
            true,
            true,
            true,
            false,
            true,
            true,
            true,
            true,
            true,
            true,
            true,
            false,
            false,
            true,
            true,
            false,
            true
        )

        fun getAllCountries(): List<Country> {
            val allCountries = mutableListOf<Country>()
            for (i in names.indices) {
                allCountries.add(
                    Country(
                        name = names[i],
                        flagImage = flagImages[i],
                        canEnter = canEnter[i]
                    )
                )
            }
            allCountries.shuffle()
            return allCountries
        }
    }
}