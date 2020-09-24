package ru.modelov.testapp65apps.main.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import ru.modelov.testapp65apps.R

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		Navigation.findNavController(this, R.id.host_global)
	}
}