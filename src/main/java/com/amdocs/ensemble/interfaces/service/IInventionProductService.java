package com.amdocs.ensemble.interfaces.service;


import com.amdocs.ensemble.entity.InventionProduct;
import com.amdocs.ensemble.exception.DataNotFoundException;

import java.util.List;
import java.util.Optional;

public interface IInventionProductService {
    /**
     * @param product
     */
    void addProductDetailsDb(InventionProduct product);

    /**
     * @param product
     * @throws DataNotFoundException
     */

    void updateProductDetailsDb(InventionProduct product) throws DataNotFoundException;

    /**
     * @param projectId
     * @return
     * @throws DataNotFoundException
     */

    Optional<InventionProduct> getProductDetailsDbById(String projectId) throws DataNotFoundException;

    // List<InventionProduct> getProductDetailsStatusAllDb() throws DataNotFoundException;
    List<InventionProduct> getProductDetailsDb() throws DataNotFoundException;

}
