package di

import io.reactivex.schedulers.Schedulers
import org.koin.dsl.module
import usecases.GetProductsUseCase

val useCaseModule = module {
    factory {
        GetProductsUseCase(
            productRepository = get(),
            scheduler = Schedulers.io()
        )
    }
}

val domainModule = listOf(useCaseModule)