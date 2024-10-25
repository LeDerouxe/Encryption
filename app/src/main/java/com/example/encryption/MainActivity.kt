package com.example.encryption

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.encryption.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    var q = arrayOf(
        '7' ,'8' , '9' , '0' , ',' , '>' , '<' , '?' ,' ',
        'q', 'w' , 'e' , 'r' , 't' , 'y' , 'u' , 'i' , 'o' , 'p'
        , 'a' , 's' , 'd' , 'f' , 'g', 'h' , 'j' , 'k' , 'l'
        ,'1' , '2' , '3' , '4' , '5' , '6' ,'"',
        'z' , 'x' , 'c' , 'v' , 'b' , 'n' , 'm' ,
        '!' , '@' , '#' , '$' , '%' , '^' , '&' , '*' , '(' ,
        'Q', 'W' , 'E' , 'R' , 'T' , 'Y' , 'U' , 'I' , 'O' , 'P'
        , 'A' , 'S' , 'D' , 'F' , 'G', 'H' , 'J' , 'K' , 'L'
        , ']' , '[' , '|' , '/' , '.' , ';' , ':' , '\'' , '\\'
        , 'Z' , 'X' , 'C' , 'V' , 'B' , 'N' , 'M' ,
        /* 93 element */                    ')' , '_' , '+' , '=' , '-' , '{' , '}'
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this ,R.layout.activity_main)
        window.statusBarColor = ContextCompat.getColor(this, R.color.n)
        var key = 235


        var valueHolder : String
        var b:Int
        var v:Int
        var fl:Boolean = true
        var lenj :Int = 0
        var final :String
        var p :Int
        /////////////kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk
       binding.submitBUT.setOnClickListener {
           b=0
           v=0
           while (b<binding.valET.text.length)
           {
               v=0
               while (v<93)
               {
                   if (binding.valET.text[b]==q[v] ){fl=true
                       break
                   }
                   else{fl=false}
                   v++
               }
               if (!fl)
                   break
               b++
           }
           if(fl) {
               if (binding.keyET.text.length == 3 && !binding.keyET.text.contains(".")) {
                   key = binding.keyET.text.toString().toInt()
                   binding.resTV.text = ""
                   valueHolder = binding.valET.text.toString()
                   lenj = binding.valET.length()
                   final = ""
                   p = 0
                   while (p < lenj) {
                       final = final + encrypt(valueHolder[p], key).toString()
                       p++
                   }
                   binding.resTV.text = final

               } else {
                   Toast.makeText(this, "Enter valid values", Toast.LENGTH_SHORT).show()
               }
           }  else {
               Toast.makeText(this, "Enter valid values", Toast.LENGTH_SHORT).show()
           }
       }
           binding.button.setOnClickListener {
               b=0
               v=0
               while (b<binding.valET.text.length)
               {
                   v=0
                   while (v<93)
                   {
                       if (binding.valET.text[b]==q[v] ){fl=true
                       break
                       }
                       else{fl=false}
                           v++
                   }
                   if (!fl)
                       break
                   b++
               }
               if(fl) {
                   if (binding.keyET.text.length == 3 && !binding.keyET.text.contains(".")) {
                       key = binding.keyET.text.toString().toInt()
                       binding.resTV.text = ""
                       valueHolder = binding.valET.text.toString()
                       lenj = binding.valET.length()
                       final = ""
                       p = 0
                       while (p < lenj) {
                           final = final + decrypt(valueHolder[p], key).toString()
                           p++
                       }
                       binding.resTV.text = final

                   }
                   else {
                       Toast.makeText(this, "Enter valid values", Toast.LENGTH_SHORT).show()
                   }
               }  else {
                   Toast.makeText(this, "Enter valid values", Toast.LENGTH_SHORT).show()
               }
               }
           }


    fun encrypt(c : Char , key : Int ): Char {
        var i = 0

        var z= key/10
        var y= key/10
         var x= key
        while (i<93)
        {
            if(c==q[i]) {break}
            else {i++}
        }
         i -=(3*x)
         i +=(2*y)
         i -=(5*z)
        //   i +=(loc*4)
        //i++
        while (i>92)
        { i -= 93}
        while (i<0)
        {  i += 93}

        return q[i]

    }
    fun decrypt(c : Char , key : Int ): Char
    {
        var i = 0

        var z= key/10
        var y= key/10
        var x= key
        while (i<93)
        {
            if(c==q[i]) {break}
            else {i++}
        }
        i +=(3*x)
        i -=(2*y)
        i +=(5*z)
        //   i +=(loc*4)
        //i++
        while (i>92)
        { i -= 93}
        while (i<0)
        {  i += 93}

        return q[i]
    }}
