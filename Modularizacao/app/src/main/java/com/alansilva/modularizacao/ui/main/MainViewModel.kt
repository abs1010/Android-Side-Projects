package com.alansilva.modularizacao.ui.main

import androidx.lifecycle.MutableLiveData
import com.alansilva.modularizacao.viewmodel.BaseViewModel
import com.alansilva.modularizacao.viewmodel.StateMachineSingle
import com.alansilva.modularizacao.viewmodel.ViewState
import io.reactivex.Scheduler
import io.reactivex.rxkotlin.plusAssign
import model.Product
import usecases.GetProductsUseCase

class MainViewModel(
    private val useCase: GetProductsUseCase,
    private val uiScheduler: Scheduler
) : BaseViewModel() {

    val state = MutableLiveData<ViewState<List<Product>>>().apply {
        value = ViewState.Loading
    }

    fun getProducts(forceUpdate: Boolean = false) {
        disposables += useCase.execute(forceUpdate = forceUpdate)
            .compose(StateMachineSingle()).observeOn(uiScheduler).subscribe(

                {
                    state.postValue(it)
                },
                {
                    state.postValue(ViewState.Failed(it))
                }
            )
    }

}