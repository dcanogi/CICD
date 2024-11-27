package com.example.myapplication

import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.core.*
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mockito.verify

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    private lateinit var navController: NavController

    @Before
    fun setUp() {
        // Se lanza la actividad para tener acceso a sus elementos.
        ActivityScenario.launch(MainActivity::class.java).use { scenario ->
            scenario.onActivity { activity ->
                // Moca el NavController
                navController = Mockito.mock(NavController::class.java)
                Navigation.setViewNavController(activity.findViewById(R.id.nav_view), navController)
            }
        }
    }

    @Test
    fun testNavigationSetup() {
        // Verifica que el NavController esté correctamente configurado
        verify(navController).navigate(R.id.navigation_home)  // Asegúrate de que la navegación esté configurada correctamente
    }
}
