package com.example.conversormoneda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var etcantidad: EditText? = null
    private var tvresultado: TextView? = null
    private var divisas: Spinner? = null
    private var divisas2: Spinner? = null
    private var numero:String? = null
    private var numero2:String? = null
    private var boton:Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        divisas = findViewById<Spinner>(R.id.spSpinner)
        divisas2 = findViewById<Spinner>(R.id.spSpinner2)
        tvresultado = findViewById<TextView>(R.id.tvResultado)
        etcantidad = findViewById<EditText>(R.id.etCantidad)
        boton = findViewById<Button>(R.id.bnGuardar)

        boton!!.setOnClickListener(this)

        val monedas = arrayOf("Peso Colombiano", "Dolar USA", "Euro", "Franco Suizo", "Libra Esterlina")

        divisas?.adapter=ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, monedas)
        divisas?.onItemSelectedListener=object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {}
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                numero =monedas.get(p2)
            }
        }

        divisas2?.adapter=ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, monedas)
        divisas2?.onItemSelectedListener=object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {}
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                numero2 =monedas.get(p2)
            }
        }

    }

    override fun onClick(v: View?) {

        var aux=etCantidad?.text.toString()

        if(numero==numero2)
            tvresultado?.text = aux
        if(numero=="Peso Colombiano"){
            if(numero2=="Dolar USA")
                tvresultado?.text = (aux.toFloat() / (3238.5f)).toString()
            if(numero2=="Euro")
                tvresultado?.text = (aux.toFloat() / (3610.12f)).toString()
            if(numero2=="Franco Suizo")
                tvresultado?.text = (aux.toFloat() / (3259.29f)).toString()
            if(numero2=="Libra Esterlina")
                tvresultado?.text = (aux.toFloat() / (4009.61f)).toString()
        }
        if(numero=="Dolar USA"){
            if(numero2=="Peso Colombiano")
                tvresultado?.text = (aux.toFloat() * (3238.5f)).toString()
            if(numero2=="Euro")
                tvresultado?.text = (aux.toFloat() * ((3238.5f)/(3610.12f))).toString()
            if(numero2=="Franco Suizo")
                tvresultado?.text = (aux.toFloat() * ((3238.5f)/(3259.29f))).toString()
            if(numero2=="Libra Esterlina")
                tvresultado?.text = (aux.toFloat() * ((3238.5f)/(4009.61f))).toString()
        }
        if(numero=="Euro"){
            if(numero2=="Peso Colombiano")
                tvresultado?.text = (aux.toFloat() * (3610.12f)).toString()
            if(numero2=="Dolar USA")
                tvresultado?.text = (aux.toFloat() * ((3610.12f)/(3238.5f))).toString()
            if(numero2=="Franco Suizo")
                tvresultado?.text = (aux.toFloat() * ((3610.12f)/(3259.29f))).toString()
            if(numero2=="Libra Esterlina")
                tvresultado?.text = (aux.toFloat() * ((3610.12f)/(4009.61f))).toString()
        }
        if(numero=="Franco Suizo"){
            if(numero2=="Peso Colombiano")
                tvresultado?.text = (aux.toFloat() * (3259.29f)).toString()
            if(numero2=="Dolar USA")
                tvresultado?.text = (aux.toFloat() * ((3259.29f)/(3610.12f))).toString()
            if(numero2=="Euro")
                tvresultado?.text = (aux.toFloat() * ((3259.29f)/(3610.12f))).toString()
            if(numero2=="Libra Esterlina")
                tvresultado?.text = (aux.toFloat() * ((3259.29f)/(4009.61f))).toString()
        }
        if(numero=="Libra Esterlina"){
            if(numero2=="Peso Colombiano")
                tvresultado?.text = (aux.toFloat() * (4009.61f)).toString()
            if(numero2=="Dolar USA")
                tvresultado?.text = (aux.toFloat() * ((4009.61f)/(3238.5f))).toString()
            if(numero2=="Euro")
                tvresultado?.text = (aux.toFloat() * ((4009.61f)/(3610.12f))).toString()
            if(numero2=="Franco Suizo")
                tvresultado?.text = (aux.toFloat() * ((4009.61f)/(3259.29f))).toString()
        }
    }
}
