package com.example.myapplication

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.example.myapplication.repository.CompaniesBean
import com.example.myapplication.repository.TempRepository
import com.example.myapplication.viewmodels.MainViewModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    private lateinit var mainViewModel: MainViewModel
    private val tempRepository: TempRepository = mockk(relaxed = true)

    @get:Rule
    val liveDataRule = InstantTaskExecutorRule()
    private val companiesVOObserver: Observer<List<MainViewModel.CompaniesVO>> =
        mockk(relaxed = true)

    @ExperimentalCoroutinesApi
    @get:Rule
    val mainCoroutineRule = CoroutinesTestRule()

    @Before
    fun setup() {
        val fakeFlow = flowOf(mutableListOf<CompaniesBean>().apply {
            add(mockk<CompaniesBean>(relaxed = true).apply {
                every { company } returns "OK"
            })
            add(mockk<CompaniesBean>(relaxed = true).apply {
                every { company } returns "OK2"
            })
        })

        MockKAnnotations.init(this, relaxed = true)
        coEvery { tempRepository.getNewListing() } returns fakeFlow
        mainViewModel = MainViewModel(tempRepository)

        mainViewModel.displayVO.observeForever(companiesVOObserver)
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun `test main view model`() {
        assertEquals(mainViewModel.displayVO.value?.size, 2)
    }
}