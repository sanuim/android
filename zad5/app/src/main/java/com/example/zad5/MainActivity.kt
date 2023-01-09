package com.example.zad5


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private var toolbar: Toolbar? = null
    private lateinit var apiService: APIService
    private lateinit var productAdapter: ProductAdapter

    private var products = listOf<Product>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar);
        apiService = APIConfig.getRetrofitClient(this).create(APIService::class.java)

        swipeRefreshLayout.setColorSchemeColors(ContextCompat.getColor(this, com.google.android.material.R.color.material_blue_grey_900))

        swipeRefreshLayout.isRefreshing = true

        products_recyclerview.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        ShoppingCart.startCart(this)

        cart_size.text = ShoppingCart.getShoppingCartSize().toString()

        getProducts()

        showCart.setOnClickListener {
            startActivity(Intent(this, ShoppingCartActivity::class.java))
        }

    }

    fun onClick(position: Int) {
        val toast = Toast.makeText(this, "CLICKED", Toast.LENGTH_SHORT)
        toast.show()
    }

    fun getProducts() {
        apiService.getProducts().enqueue(object : retrofit2.Callback<List<Product>> {
            override fun onFailure(call: Call<List<Product>>, t: Throwable) {

                print(t.message)
                t.message?.let { Log.d("Data error", it) }
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
            }

            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {

                swipeRefreshLayout.isRefreshing = false
                products = response.body()!!

                productAdapter = ProductAdapter(this@MainActivity, products)

                products_recyclerview.adapter = productAdapter

                productAdapter.notifyDataSetChanged()



            }

        })
    }

}