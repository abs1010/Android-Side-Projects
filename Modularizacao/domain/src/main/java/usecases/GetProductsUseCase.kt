package usecases

import io.reactivex.Scheduler
import io.reactivex.Single
import model.Product
import repository.ProductRepository

class GetProductsUseCase(
    private val productRepository: ProductRepository,
    private val scheduler: Scheduler
) {

    fun execute(forceUpdate: Boolean): Single<List<Product>> {
        return productRepository.getProducts(forceUpdate)
            .subscribeOn(scheduler)
    }

}